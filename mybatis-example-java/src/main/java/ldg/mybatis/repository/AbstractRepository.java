package ldg.mybatis.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository {
    protected final String className;
    private final SqlSessionFactory factory;

    protected AbstractRepository() {
        String mybatisConfig = "mybatis-config.xml";

        try (InputStream is = Resources.getResourceAsStream(mybatisConfig)) {
            this.factory = (new SqlSessionFactoryBuilder()).build(is);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        this.className = this.getClass().getName() + ".";
    }

    protected int dml(DmlKind kind, String statement, Object args) {
        int rowCnt = 0;
        SqlSession session = null;

        try {
            session = this.factory.openSession();

            rowCnt = switch (kind) {
                case INSERT -> session.insert(statement, args);
                case UPDATE -> session.update(statement, args);
                case DELETE -> session.delete(statement, args);
            };

            if (rowCnt > 0) session.commit();
        } catch (Exception ex) {
            if (null != session) session.rollback();
        } finally {
            if (null != session) session.close();
        }

        return rowCnt;
    }

    protected <T> T selectOne(String statement, Object args) {
        T result;

        try (SqlSession session = this.factory.openSession()) {
            result = session.selectOne(statement, args);
        }

        return result;
    }

    protected <E> List<E> selectList(String statement, Object args) {
        List<E> results;

        try (SqlSession session = this.factory.openSession()) {
            results = session.selectList(statement, args);
        }

        return null == results ? new ArrayList<>() : results;
    }
}

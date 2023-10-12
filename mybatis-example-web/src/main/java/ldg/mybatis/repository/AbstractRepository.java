package ldg.mybatis.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractRepository {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        setSqlSessionFactory();
    }

    private static void setSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    protected SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}

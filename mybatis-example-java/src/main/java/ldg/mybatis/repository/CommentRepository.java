package ldg.mybatis.repository;

import ldg.mybatis.model.Comment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    private final String className;

    private SqlSessionFactory factory = null;

    public CommentRepository() {
        this.createFactory();
        this.className = this.getClass().getName() + ".";
    }

    private SqlSession getSeesion() {

        if (null == this.factory) {
            this.factory = this.createFactory();
        }

        return this.factory.openSession();
    }

    private SqlSessionFactory createFactory() {
        SqlSessionFactory factory = null;
        String mybatisConfig = "mybatis-config.xml";

        try (InputStream is = Resources.getResourceAsStream(mybatisConfig);){
            factory = (new SqlSessionFactoryBuilder()).build(is);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return factory;
    }

    public Comment selectCommentByPrimaryKey(long commentNo) {
        String statement = this.className + "selectCommentByPrimaryKey";
        Comment comment = null;

        try (SqlSession session = this.getSeesion();) {
            comment = session.selectOne(statement, commentNo);
        }

        return comment;
    }

    public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
        String statement = this.className + "selectCommentByCondition";
        List<Comment> comments = null;

        try (SqlSession session = this.getSeesion();) {
            comments = session.selectList(statement, condition);
        }

        return null == comments ? new ArrayList<>() : comments;
    }

    public int insertComment(Comment comment) {
        String statement = this.className + "insertComment";
        int rowCnt = 0;
        SqlSession session = null;

        try {
            session = this.getSeesion();
            rowCnt = session.insert(statement, comment);

            if (rowCnt > 0) session.commit();
        } catch (Exception ex) {
            if (null != session) session.rollback();
        } finally {
            if (null != session) session.close();
        }

        return rowCnt;
    }

    public int updateComment(Comment comment) {
        String statement = this.className + "updateComment";
        int rowCnt = 0;
        SqlSession session = null;

        try {
            session = this.getSeesion();
            rowCnt = session.update(statement, comment);

            if (rowCnt > 0) session.commit();
        } catch (Exception ex) {
            if (null != session) session.rollback();
        } finally {
            if (null != session) session.close();
        }

        return rowCnt;
    }

    public int deleteComment(Long commentNo) {
        String statement = this.className + "deleteComment";

        int rowCnt = 0;
        SqlSession session = null;

        try {
            session = this.getSeesion();
            rowCnt = session.delete(statement, commentNo);

            if (rowCnt > 0) session.commit();
        } catch (Exception ex) {
            if (null != session) session.rollback();
        } finally {
            if (null != session) session.close();
        }

        return rowCnt;
    }
}

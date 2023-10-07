package ldg.mybatis.repository;

import ldg.mybatis.model.Comment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return (new SqlSessionFactoryBuilder()).build(inputStream);
    }

    public Comment selectCommentByPrimaryKey(long commentNo) {
        String statement = this.className + "selectCommentByPrimaryKey";

        return this.getSeesion().selectOne(statement, commentNo);
    }

    public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
        String statement = this.className + "selectCommentByCondition";

        return this.getSeesion().selectList(statement, condition);
    }

    public int insertComment(Comment comment) {
        String statement = this.className + "insertComment";

        return this.getSeesion().insert(statement, comment);
    }

    public int updateComment(Comment comment) {
        String statement = this.className + "updateComment";

        return this.getSeesion().update(statement, comment);
    }

    public int deleteComment(Long commentNo) {
        String statement = this.className + "deleteComment";

        return this.getSeesion().delete(statement, commentNo);
    }
}

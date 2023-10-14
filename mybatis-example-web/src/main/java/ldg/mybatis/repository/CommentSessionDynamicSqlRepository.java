package ldg.mybatis.repository;

import ldg.mybatis.model.Comment;
import ldg.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class CommentSessionDynamicSqlRepository extends AbstractRepository {
    private final String namespace = "ldg.mybatis.repository.mapper.CommentMapperDynamic";

    public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectCommentByCondition";
            return sqlSession.selectList(statement, condition);
        }
    }

    public List<Comment> selectCommentByConditionIf(Map<String, Object> condition) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectCommentByConditionIf";
            return sqlSession.selectList(statement, condition);
        }
    }

    public List<Comment> selectCommentByConditionChoose(Map<String, Object> condition) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectCommentByConditionChoose";
            return sqlSession.selectList(statement, condition);
        }
    }

    public List<Comment> selectCommentByConditionTrim(Map<String, Object> condition) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectCommentByConditionTrim";
            return sqlSession.selectList(statement, condition);
        }
    }

    public List<Comment> selectCommentByConditionForeach(Map<String, Object> condition) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectCommentByConditionForeach";
            return sqlSession.selectList(statement, condition);
        }
    }

    public List<Comment> selectOgnlStaticField() {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectOgnlStaticField";
            return sqlSession.selectList(statement);
        }
    }

    public List<Comment> selectOgnlStaticMethod() {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectOgnlStaticMethod";
            return sqlSession.selectList(statement);
        }
    }

    public List<User> selectOgnlStaticMethod2(Map<String, Object> condition) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = namespace + ".selectOgnlStaticMethod2";
            return sqlSession.selectList(statement, condition);
        }
    }
}

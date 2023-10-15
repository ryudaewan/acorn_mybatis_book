package ldg.mybatis.repository.session;

import ldg.mybatis.model.Comment;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentSessionRepository {
    private final String namespace = "ldg.mybatis.repository.mapper.CommentMapper";
    @Autowired
    private SqlSessionTemplate sqlSession;

    public Comment selectCommentByPrimaryKey(Long commentNo) {
        return (Comment) sqlSession.selectOne(String.format("%s.selectCommentByPrimaryKey", namespace), commentNo);
    }

    public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
        return sqlSession.selectList(String.format("%s.selectCommentByCondition", namespace), condition);
    }

    public Integer insertComment(Comment comment) {
        int result = sqlSession.insert(String.format("%s.insertComment", namespace), comment);
        return result;
    }

    public Integer deleteComment(Long commentNo) {
        int result = sqlSession.delete(String.format("%s.deleteComment", namespace), commentNo);
        return result;
    }
}

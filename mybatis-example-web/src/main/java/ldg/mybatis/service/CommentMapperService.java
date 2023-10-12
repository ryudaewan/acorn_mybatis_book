package ldg.mybatis.service;

import ldg.mybatis.model.Comment;
import ldg.mybatis.repository.CommentMapperRepository;

import java.util.List;
import java.util.Map;

public class CommentMapperService {
    private CommentMapperRepository commentRepository = new CommentMapperRepository();

    public Comment selectCommentByPrimaryKey(Long commentNo) {
        return commentRepository.selectCommentByPrimaryKey(commentNo);
    }

    public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
        return commentRepository.selectCommentByCondition(condition);
    }

    public Integer insertComment(Comment comment) {
        return commentRepository.insertComment(comment);
    }

    public Integer deleteComment(Long commentNo) {
        return commentRepository.deleteComment(commentNo);
    }
}
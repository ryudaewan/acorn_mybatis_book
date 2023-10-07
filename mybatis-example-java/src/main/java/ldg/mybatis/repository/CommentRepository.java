package ldg.mybatis.repository;

import ldg.mybatis.model.Comment;

import java.util.List;
import java.util.Map;

public class CommentRepository extends AbstractRepository {
    public CommentRepository() {
        super();
    }

    public Comment selectCommentByPrimaryKey(long commentNo) {
        String statement = this.className + "selectCommentByPrimaryKey";

        return this.selectOne(statement, commentNo);
    }

    public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
        String statement = this.className + "selectCommentByCondition";

        return this.selectList(statement, condition);
    }

    public int insertComment(Comment comment) {
        String statement = this.className + "insertComment";

        return this.dml(DmlKind.INSERT, statement, comment);
    }

    public int updateComment(Comment comment) {
        String statement = this.className + "updateComment";

        return this.dml(DmlKind.UPDATE, statement, comment);
    }

    public int deleteComment(Long commentNo) {
        String statement = this.className + "deleteComment";

        return this.dml(DmlKind.DELETE, statement, commentNo);
    }

}

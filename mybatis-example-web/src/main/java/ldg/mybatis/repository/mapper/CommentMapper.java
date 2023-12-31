package ldg.mybatis.repository.mapper;

import ldg.mybatis.model.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    @Select("SELECT comment_no, user_id, comment_content, reg_date FROM COMMENT WHERE comment_no = #{commentNo}")
    @Results({
            @Result(column = "comment_no", property = "commentNo", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "reg_date", property = "regDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comment_content", property = "commentContent", jdbcType = JdbcType.LONGVARCHAR)
    })
    Comment selectCommentByPrimaryKey(Long commentNo);

    @SelectProvider(type = CommentSqlProvider.class, method = "selectCommentByCondition")
    List<Comment> selectCommentByCondition(Map<String, Object> condition);

    @Insert("INSERT INTO COMMENT(comment_no, user_id, comment_content, reg_date) VALUES (#{commentNo}, #{userId}, #{commentContent}, #{regDate})")
    Integer insertComment(Comment comment);

    @Delete("DELETE FROM comment WHERE comment_no = #{commentNo}")
    Integer deleteComment(Long commentNo);
}
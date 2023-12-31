package ldg.mybatis.repository;

import ldg.mybatis.model.Comment;
import ldg.mybatis.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentMapperRepositoryTest {
    private static final Long commentNo = 1L;
    private final CommentMapperRepository commentMapperRepository = new CommentMapperRepository();

    @BeforeEach
    public void setup() {
        commentMapperRepository.deleteComment(commentNo);
        commentMapperRepository.insertComment(getComment());
    }

    @Test
    public void testSelectCommentByPrimaryKey() {
        Comment comment = commentMapperRepository.selectCommentByPrimaryKey(commentNo);

        assertNotNull(comment);
    }

    @Test
    public void testSelectCommentByCondition() {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("commentNo", 1L);
        condition.put("user", makeUser());

        List<Comment> comments = commentMapperRepository.selectCommentByCondition(condition);

        assertEquals(comments.size(), 1);
    }

    @Test
    public void testInsertComment() {
        commentMapperRepository.deleteComment(commentNo);
        Integer integer = commentMapperRepository.insertComment(getComment());

        assertEquals(integer, 1);
    }

    @Test
    public void testDeleteComment() {
        Integer integer = commentMapperRepository.deleteComment(commentNo);

        assertEquals(integer, 1);
    }

    private Comment getComment() {
        User user = makeUser();

        return makeComment(1L, user.getUserId(), user.getUserName(), Calendar.getInstance().getTime());
    }

    private Comment makeComment(Long commentNo, String userId, String commentContent, Date regDate) {
        Comment comment = new Comment();
        comment.setCommentNo(commentNo);
        comment.setUserId(userId);
        comment.setCommentContent(commentContent);
        comment.setRegDate(regDate);
        return comment;
    }

    private User makeUser() {
        User user = new User();
        user.setUserId("fromm0");
        user.setUserName("이동국");
        return user;
    }
}

package ldg.mybatis.repository;

import ldg.mybatis.model.Comment;
import ldg.mybatis.model.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CommentSessionDynamicSqlRepositoryTest {
    private final CommentSessionDynamicSqlRepository commentSessionDynamicSqlRepository = new CommentSessionDynamicSqlRepository();

    @Test
    public void testSelectCommentByCondition() {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("commentNo", 1L);
        condition.put("user", makeUser());

        List<Comment> actual = commentSessionDynamicSqlRepository.selectCommentByCondition(condition);

        //fail();
        assertTrue(1 <= actual.size());
    }

    @Test
    public void testSelectCommentByConditionIf() {
        Map<String, Object> condition = new HashMap<>();
        condition.put("commentNo", 1L);
        condition.put("user", makeUser());

        List<Comment> actual = commentSessionDynamicSqlRepository.selectCommentByConditionIf(condition);
        //fail();
        assertTrue(1 <= actual.size());
    }

    @Test
    public void testSelectCommentByConditionChoose() {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("commentNo", 1L);
        condition.put("user", makeUser());

        List<Comment> actual = commentSessionDynamicSqlRepository.selectCommentByConditionChoose(condition);
        //fail();
        assertTrue(1 <= actual.size());
    }

    @Test
    public void testSelectCommentByConditionTrim() {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("commentNo", 1L);
        condition.put("user", makeUser());

        List<Comment> actual = commentSessionDynamicSqlRepository.selectCommentByConditionTrim(condition);
        //fail();
        assertTrue(1 <= actual.size());
    }

    @Test
    public void testSelectCommentByConditionForeach() {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("commentNos", Arrays.asList(1L, 2L));

        List<Comment> actual = commentSessionDynamicSqlRepository.selectCommentByConditionForeach(condition);
        //fail();
        assertTrue(1 <= actual.size());
    }

    @Test
    public void testSelectOgnlStaticField() {
        List<Comment> actual = commentSessionDynamicSqlRepository.selectOgnlStaticField();
        //fail();
        assertTrue(1 <= actual.size());
    }

    @Test
    public void testSelectOgnlStaticMethod() {
        List<Comment> actual = commentSessionDynamicSqlRepository.selectOgnlStaticMethod();
        //fail();
        assertTrue(1 <= actual.size());
    }

    @Test
    public void testSelectOgnlStaticMethod2() {
        Map<String, Object> condition = new HashMap<>();
        condition.put("userId", "fromm0");

        List<User> actual = commentSessionDynamicSqlRepository.selectOgnlStaticMethod2(condition);
        //fail();
        assertEquals(0, actual.size());
    }

    private User makeUser() {
        User user = new User();
        user.setUserId("fromm0");
        user.setUserName("이동국");
        return user;
    }
}
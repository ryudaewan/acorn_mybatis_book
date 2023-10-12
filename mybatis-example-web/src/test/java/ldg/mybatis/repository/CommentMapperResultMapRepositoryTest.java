package ldg.mybatis.repository;

import ldg.mybatis.model.Comment;
import ldg.mybatis.model.CommentUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentMapperResultMapRepositoryTest {
    private final CommentMapperResultMapRepository commentMapperResultMapRepository = new CommentMapperResultMapRepository();
    private final CommentMapperRepository commentMapperRepository = new CommentMapperRepository();

    private final Long commentNo = 1L;
    private final Long commentNo2 = 2L;

    @BeforeEach
    public void setup() {
        makeSampleData();
    }

    public void makeSampleData() {
        commentMapperRepository.deleteComment(commentNo);
        Comment comment = new Comment();
        comment.setCommentNo(commentNo);
        comment.setUserId("fromm0");
        comment.setCommentContent("test");
        comment.setRegDate(Calendar.getInstance().getTime());
        commentMapperRepository.insertComment(comment);

        commentMapperRepository.deleteComment(commentNo2);
        comment = new Comment();
        comment.setCommentNo(commentNo2);
        comment.setUserId("manager");
        comment.setCommentContent("test");
        comment.setRegDate(Calendar.getInstance().getTime());
        commentMapperRepository.insertComment(comment);
    }

    @Test
    public void testSelectCommentByPrimaryKey() {
        Comment result = commentMapperResultMapRepository.selectCommentByPrimaryKey(commentNo);

        assertThat(result.getCommentNo()).isEqualTo(commentNo);
    }

    @Test
    public void testSelectCommentByPrimaryKeyConstructor2() {
        Comment result = commentMapperResultMapRepository.selectCommentByPrimaryKeyConstructor2(commentNo);

        assertThat(result.getCommentNo()).isEqualTo(commentNo);
    }

    @Test
    public void testSelectCommentByPrimaryKeyAssociation2() {
        CommentUser result = commentMapperResultMapRepository.selectCommentByPrimaryKeyAssociation2(commentNo);

        assertThat(result).isNotNull();
    }

    @Test
    public void testSelectCommentByPrimaryKeyCollection2() {
        Comment result = commentMapperResultMapRepository.selectCommentByPrimaryKeyCollection2(commentNo);

        assertThat(result).isNotNull();
    }

    @Test
    public void testSelectCommentByPrimaryKeyDiscriminator2() {
        Comment result = commentMapperResultMapRepository.selectCommentByPrimaryKeyDiscriminator2(commentNo);
        //assertThat(result.getCommentNo(), equalTo(commentNo));
        assertThat(result.getCommentNo()).isEqualTo(commentNo);

        result = commentMapperResultMapRepository.selectCommentByPrimaryKeyDiscriminator2(commentNo2);
        assertThat(result.getCommentNo()).isEqualTo(commentNo2);
    }
}

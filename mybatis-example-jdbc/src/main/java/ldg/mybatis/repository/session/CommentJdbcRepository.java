package ldg.mybatis.repository.session;

import ldg.mybatis.model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentJdbcRepository {
    private static final String driverName = "org.postgresql.Driver";

    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/mybatis_example";

    private static final String dbUserId = "mybatis";

    private static final String dbUserPassword = "mybatis";

    private Connection getConnection() {
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(jdbcUrl, dbUserId, dbUserPassword);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public Comment selectCommentByPrimaryKey(Long commentNo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            StringBuilder sql = new StringBuilder("");
            sql.append("SELECT comment_no, user_id, comment_content, reg_date ");
            sql.append("FROM COMMENT ");
            sql.append("WHERE comment_no = ?");
            stmt = conn.prepareStatement(sql.toString());
            stmt.setLong(1, commentNo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentNo(rs.getLong("comment_no"));
                comment.setUserId(rs.getString("user_id"));
                comment.setCommentContent(rs.getString("comment_content"));
                comment.setRegDate(rs.getDate("reg_date"));
                return comment;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != rs) rs.close();
            } catch (SQLException e) {
            }
            try {
                if (null != stmt) stmt.close();
            } catch (SQLException e) {
            }
            try {
                if (null != conn) conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<Comment>();

        try {
            conn = this.getConnection();

            StringBuilder sql = new StringBuilder("");
            sql.append("SELECT comment_no, user_id, comment_content, reg_date ");
            sql.append("FROM COMMENT ");

            if (condition.get("commentNo") != null) {
                sql.append("WHERE comment_no = ?");
            }

            stmt = conn.prepareStatement(sql.toString());

            if (condition.get("commentNo") != null) {
                stmt.setLong(1, Long.valueOf(condition.get("commentNo") + ""));
            }

            rs = stmt.executeQuery();

            if (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentNo(rs.getLong("comment_no"));
                comment.setUserId(rs.getString("user_id"));
                comment.setCommentContent(rs.getString("comment_content"));
                comment.setRegDate(rs.getDate("reg_date"));

                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != rs) rs.close();
            } catch (SQLException e) {
            }
            try {
                if (null != stmt) stmt.close();
            } catch (SQLException e) {
            }
            try {
                if (null != conn) conn.close();
            } catch (SQLException e) {
            }
        }
        return comments;
    }

    public Integer insertComment(Comment comment) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.getConnection();

            StringBuilder sql = new StringBuilder("");
            sql.append("INSERT INTO COMMENT(comment_no, user_id, comment_content, reg_date) ");
            sql.append("VALUES (?, ?, ?, ?) ");
            stmt = conn.prepareStatement(sql.toString());
            stmt.setLong(1, comment.getCommentNo());
            stmt.setString(2, comment.getUserId());
            stmt.setString(3, comment.getCommentContent());
            stmt.setDate(4, new java.sql.Date(comment.getRegDate().getTime()));
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != stmt) stmt.close();
            } catch (SQLException e) {
            }
            try {
                if (null != conn) conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public Integer updateComment(Comment comment) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.getConnection();

            StringBuilder sql = new StringBuilder("");
            sql.append("UPDATE comment SET ");
            sql.append("	comment_content = ? ");
            sql.append("WHERE comment_no = ? ");
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, comment.getCommentContent());
            stmt.setLong(2, comment.getCommentNo());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != stmt) stmt.close();
            } catch (SQLException e) {
            }
            try {
                if (null != conn) conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public Integer deleteComment(Long commentNo) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.getConnection();

            StringBuilder sql = new StringBuilder("");
            sql.append("DELETE FROM comment ");
            sql.append("WHERE comment_no = ? ");
            stmt = conn.prepareStatement(sql.toString());
            stmt.setLong(1, commentNo);
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != stmt) stmt.close();
            } catch (SQLException e) {
            }
            try {
                if (null != conn) conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }
}
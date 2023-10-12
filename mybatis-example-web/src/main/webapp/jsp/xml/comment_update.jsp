<%@page import="java.io.*,java.util.*,javax.servlet.*,ldg.mybatis.service.*,ldg.mybatis.model.*" contentType="text/html; charset=utf8"%>
<%@page import="ldg.mybatis.common.StringUtils" %>
<%
//XML만으로 매핑구문과 결과매핑 처리
//CommentMapper.xml의 updateCommentTrim매핑구문
Long commentNo = null;
String temp = request.getParameter("commentNo");

if (false == StringUtils.isNotEmpty(temp)) {
    throw new IllegalArgumentException("commentNo is Null");
}

String userId = request.getParameter("userId");

if (false == StringUtils.isNotEmpty(userId)) {
    throw new IllegalArgumentException("userId is Null");
}

userId = userId.trim();

String commentContent = request.getParameter("userId");

if (false == StringUtils.isNotEmpty(commentContent)) {
    throw new IllegalArgumentException("commentContent is Null");
}

commentContent = commentContent.trim();

Comment comment = new Comment(commentNo, userId, Calendar.getInstance().getTime(), commentContent);
System.out.println(comment.toString());
CommentService commentService = new CommentService();
Integer result = commentService.updateComment(comment);
%>
<%= result %>

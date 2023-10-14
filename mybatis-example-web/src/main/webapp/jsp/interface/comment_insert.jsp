<%@page import="java.io.*,java.util.*,javax.servlet.*,ldg.mybatis.service.*,ldg.mybatis.model.*" contentType="text/html; charset=utf8"%>
<%@page import="ldg.mybatis.common.StringUtils" %>
<%--
  인터페이스만으로 매핑구문과 결과매핑 처리
  ldg.mybatis.repository.mapper.CommentMapper.insertComment(Comment)
--%>
<%
Long commentNo = null;
String temp = request.getParameter("commentNo");

if (false == StringUtils.isNotEmpty(temp)) {
    throw new IllegalArgumentException("commentNo is Null");
}

try {
    commentNo = Long.parseLong(temp.trim());
} catch(NumberFormatException nfe) {
    throw nfe;
}

String userId = request.getParameter("userId");

if (false == StringUtils.isNotEmpty(userId)) {
    throw new IllegalArgumentException("userId is Null");
}

String commentContent = request.getParameter("commentContent");

if (false == StringUtils.isNotEmpty(commentContent)) {
    throw new IllegalArgumentException("commentContent is Null");
}

Comment comment = new Comment(commentNo, userId, Calendar.getInstance().getTime(), commentContent);
CommentService commentService = new CommentService();
Integer result = commentService.insertComment(comment);
%>
<%= result %>

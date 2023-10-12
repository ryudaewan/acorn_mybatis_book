<%@page import="java.io.*,javax.servlet.*,ldg.mybatis.service.*" contentType="text/html; charset=utf8"%>
<%@page import="ldg.mybatis.common.StringUtils" %>
<%--
  인터페이스만으로 매핑구문과 결과매핑 처리
  ldg.mybatis.repository.mapper.CommentMapper.deleteComment(Long) --%>
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
    CommentService commentService = new CommentService();
    Integer result = commentService.deleteComment(commentNo);
%>
<%= result %>
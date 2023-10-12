<%@page import="java.io.*,java.util.*,javax.servlet.*,ldg.mybatis.service.*,ldg.mybatis.model.*" contentType="text/html; charset=utf8"%>
<%
// http://localhost:8080/jsp/xml/comment_dynamicsql_foreach.jsp?commentNos=1&commentNos=2
// XML만으로 매핑구문과 결과매핑 처리
// CommentMapperDynamicSql.xml의 selectCommentByConditionForeach 매핑 구문
String[] commentNos = request.getParameterValues("commentNos");

if (null == commentNos || commentNos.length < 1) {
    throw new IllegalArgumentException("commentsNos is empty.");
}

CommentDynamicSqlService commentService = new CommentDynamicSqlService();
List<Comment> comments = commentService.selectCommentForeach(commentNos);

if (null == comments || comments.size() < 1) { %>
    <%= "조회 결과 없음" %><%
    return;
}
%>
<% for( Comment comment : comments ){ %>
<p>댓글번호 : <%= comment.getCommentNo() %><br>
작성자아이디 : <%= comment.getUserId() %><br>
작성일시 : <%= comment.getRegDate() %><br>
댓글내용 : <%= comment.getCommentContent() %><br></p>
<% } %>
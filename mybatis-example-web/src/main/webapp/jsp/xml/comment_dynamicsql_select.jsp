<%@page import="java.io.*,java.util.*,javax.servlet.*,ldg.mybatis.service.*,ldg.mybatis.model.*" contentType="text/html; charset=utf8"%>
<%@page import="ldg.mybatis.common.StringUtils" %>
<%
//XML만으로 매핑구문과 결과매핑 처리
//CommentMapperDynamicSql.xml의 selectCommentByConditionTrim 매핑 구문
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

CommentDynamicSqlService commentService = new CommentDynamicSqlService();
List<Comment> comments = commentService.selectComment(commentNo, userId);

if (null == comments || comments.size() < 1) {%>
    <%= "조회 결과 없음" %><%
    return;
}
%>
<% for( Comment comment : comments ){ %>
댓글번호 : <%= comment.getCommentNo() %><br>
작성자아이디 : <%= comment.getUserId() %><br>
작성일시 : <%= comment.getRegDate() %><br>
댓글내용 : <%= comment.getCommentContent() %><br>
<% } %>
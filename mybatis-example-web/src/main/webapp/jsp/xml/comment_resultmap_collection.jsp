<%@page import="java.io.*,java.util.*,javax.servlet.*,ldg.mybatis.service.*,ldg.mybatis.model.*" contentType="text/html; charset=utf8"%>
<%@page import="ldg.mybatis.common.StringUtils" %>
<%
//XML만으로 매핑구문과 결과매핑 처리
//CommentMapperResultMap.xml의 selectCommentByPrimaryKeyCollection매핑구문
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

CommentResultMapService commentService = new CommentResultMapService();
Comment comment = commentService.selectCommentByPrimaryKeyCollection(commentNo);

if (null == comment) {%>
    <%= "조회 결과 없음" %><%
    return;
}
%>
댓글번호 : <%= comment.getCommentNo() %><br>
댓글작성자 : <%= comment.getUserId() %><br>
댓글작성일시 : <%= comment.getRegDate() %><br>
댓글내용 : <%= comment.getCommentContent() %><br>

<p>+++ 여기부터 답글목록 +++</p>
<% for( Reply reply : comment.getReplies() ){ %>
<p>답글번호 : <%= reply.getReplyNo() %><br>
답글작성자 : <%= reply.getUserId() %><br>
답글작성일시 : <%= reply.getRegDate() %><br>
답글내용 : <%= reply.getReplyContent() %><br></p>
<% } %>
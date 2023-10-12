<%@page import="java.io.*,java.util.*,javax.servlet.*,ldg.mybatis.service.*,ldg.mybatis.model.*" contentType="text/html; charset=utf8"%>
<%@page import="ldg.mybatis.common.StringUtils" %>
<%
//XML만으로 매핑구문과 결과매핑 처리
//CommentMapperResultMap.xml의 selectCommentByPrimaryKeyAssociation매핑구문
Long commentNo = null;
String temp = request.getParameter("commentNo"));

if (false == StringUtils.isNotEmpty(temp)) {
    throw new IllegalArgumentException("commentNo is Null");
}

try {
    commentNo = Long.parseLong(temp.trim());
} catch(NumberFormatException nfe) {
    throw nfe;
}

CommentMapperResultMapService commentService = new CommentMapperResultMapService();
CommentUser commentUser = commentService.selectCommentByPrimaryKeyAssociation2(commentNo);

if (null == comments) {%>
    <%= "조회 결과 없음" %><%
    return;
}
%>
댓글번호 : <%= commentUser.getComment().getCommentNo() %><br>
댓글작성자 : <%= commentUser.getComment().getUserId() %><br>
댓글작성일시 : <%= commentUser.getComment().getRegDate() %><br>
댓글내용 : <%= commentUser.getComment().getCommentContent() %><br>

댓글작성자 : <%= commentUser.getUser().getUserId() %><br>
댓글작성자명 : <%= commentUser.getUser().getUserName() %><br>
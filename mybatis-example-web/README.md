# 통합 테스트 시나리오

브라우저에 다음 URL을 순서대로 입력하면 됩니다.

1. http://localhost:8080/jsp/interface/comment_insert.jsp?commentNo=123&userId=user3&commentContent=아싸라비야
2. http://localhost:8080/jsp/interface/comment_insert.jsp?commentNo=124&userId=user3&commentContent=콜롬비야

3. http://localhost:8080/jsp/xml/comment_dynamicsql_foreach.jsp?commentNos=123&commentNos=124
4. http://localhost:8080/jsp/xml/comment_dynamicsql_select.jsp?commentNo=124&userId=user3
5. http://localhost:8080/jsp/xml/comment_resultmap_association.jsp?commentNo=123
6. http://localhost:8080/jsp/xml/comment_resultmap_collection.jsp?commentNo=6
7. http://localhost:8080/jsp/xml/comment_resultmap_constructor.jsp?commentNo=123
8. http://localhost:8080/jsp/xml/comment_resultmap_discriminator.jsp?commentNo=124
9. http://localhost:8080/jsp/xml/comment_resultmap_one.jsp?commentNo=123
10. http://localhost:8080/jsp/xml/comment_update.jsp?commentNo=124&userId=user3&commentContent=콜롬비야쿵자라락작삐약삐약

11. http://localhost:8080/jsp/xmlinterface/comment_resultmap_association2.jsp?commentNo=124
12. http://localhost:8080/jsp/xmlinterface/comment_resultmap_constructor2.jsp?commentNo=123
13. http://localhost:8080/jsp/xmlinterface/comment_resultmap_discriminator2.jsp?commentNo=124
14. http://localhost:8080/jsp/xmlinterface/comment_resultmap_one2.jsp?commentNo=123

15. http://localhost:8080/jsp/interface/comment_delete.jsp?commentNo=123
16. http://localhost:8080/jsp/interface/comment_delete.jsp?commentNo=124
17. http://localhost:8080/jsp/xml/comment_dynamicsql_foreach.jsp?commentNos=123&commentNos=124

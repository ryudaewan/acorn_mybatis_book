# 테스트 시나리오

메이븐 제티 플러그인을 기동한 다음, 브라우저에 다음 URL을 순서대로 입력하면 됩니다.

1. http://localhost:8080/jsp/comment_insert.jsp?commentNo=111&userId=user2&commentContent=쿵작작쿵작작
2. http://localhost:8080/jsp/comment_select.jsp?commentNo=111
3. http://localhost:8080/jsp/comment_springjdbc.jsp?commentNo=111&userId=user2&commentContent=으라차차차 (롤백 테스트 목적이므로 에러가 나야 함)
4. http://localhost:8080/jsp/comment_select.jsp?commentNo=111 (2번 조회 결과와 같아야 함)
5. http://localhost:8080/jsp/comment_delete.jsp?commentNo=111
6. http://localhost:8080/jsp/comment_select.jsp?commentNo=111 (화면에 아무 것도 나오는 것이 없어야 함)

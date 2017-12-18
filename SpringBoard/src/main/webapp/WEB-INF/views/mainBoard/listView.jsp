<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 목록</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	
	$(document).ready(function(){
	    $("#btnWrite").click(function(){
	        // 페이지 주소 변경(이동)
	        location.href = "/myBoard/writeView.do";
	    });
	});

</script>
</head>
<body>
<h2>게시글 목록</h2>
<button type="button" id="btnWrite">글쓰기</button>
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이름</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="row" items="${boardVoList}">
	    <tr>
	        <td>${row.seq}</td>
	        <td><a href="/myBoard/view.do?seq=${row.seq}">${row.title}</a></td>
	        <td>${row.writer}</td>
	        <td>
	            <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
	            ${row.date}
	        </td>
	        <td>0</td>
	    </tr>    
    </c:forEach>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<style>
	a.go-to-maindboard {
	    text-decoration: none;
    	color: black;
    	background-color: gray;
    	padding: 10px;
    	border: 2px solid black;
    }
	</style>
</head>
<body>
<h1>
	Hello world!  
	여기
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a class="go-to-maindboard" href="/myBoard/mainBoardList.do">게시판</a>

</body>
</html>

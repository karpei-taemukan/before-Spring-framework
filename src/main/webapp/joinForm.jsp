<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: green">
<h1>join page</h1>
<form action="${pageContext.request.contextPath}/join" method="post">
<input type="text" name="joinId" placeholder="ID"/>
<br>
<input type="text" name="joinPw" placeholder="PW"/>
<br>
<input type="date" name="joinBirth"/>
<br>
<input type="submit" value="join"/>
</form>
</body>
</html>
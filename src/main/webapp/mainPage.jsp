<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: green">
<h1>main page</h1>

<!--  <li>에 <a> 가 없다면 각 페이지 이동이 안됨 -->
<ul>
<li>
<a href="${pageContext.request.contextPath}/mainPage">
main
</a>
</li>

<li>
<a href="${pageContext.request.contextPath}/joinForm">
join
</a>
</li>

<li>
<a href="${pageContext.request.contextPath}/loginForm">
login
</a>
</li>

<li>
<button onclick="location.href='${pageContext.request.contextPath}/boardList'">billboard</button>
</li>
</ul>
</body>
<script>
let check = '${param.ch}';
console.log("check: "+check);
if(check == "y"){
alert("join success");	
}

</script>
</html>
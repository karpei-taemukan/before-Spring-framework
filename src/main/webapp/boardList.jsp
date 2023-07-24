<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%@ page import="java.util.ArrayList" %>
   <%@ page import="dto.TestDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table,th,td{
border: 1px solid black;
}
</style>
<body style="background-color:green">

<%
ArrayList<TestDto> list = (ArrayList<TestDto>) request.getAttribute("tList");
%>
<h1>Board List</h1>

<!--  글번호 글제목 작성자 작성일 조회수 -->

<table>
<tr>
<th>No.</th>
<th>Title</th>
<th>writer</th>
</tr>

<% for(int i=0; i<list.size(); i++){ %>
<tr>
<td><%= list.get(i).getNum() %></td>
<td><%= list.get(i).getTitle() %></td>
<td><%= list.get(i).getWriter() %></td>
</tr>
<%} %>

</table>

<br><br><br>
<hr>
<br><br><br>


<table>
<tr>
<th>No.</th>
<th>Title</th>
<th>writer</th>
</tr>

<c:forEach items="${tList}" var="tdto">
<tr>
<td>${tdto.num}</td>
<td>${tdto.title}</td>
<td>${tdto.writer}</td>
</tr>
</c:forEach>
</table>


</body>
</html>
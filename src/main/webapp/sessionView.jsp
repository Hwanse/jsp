<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		border : 1px solid black;
	}
</style>
</head>
<body>
<%-- application 속성 sessionMap 정보를 화면에 표현 --%>
<table border="1">
	<tr>
		<th>session id</th>
		<th>USER_INFO.name</th>
	</tr>
	<c:forEach items="${sessionMap }" var="sess">
		<tr>
			<td>${sess.key }</td>
			<td>${sess.value.getAttribute('USER_INFO').name }</td>
		</tr>
	</c:forEach>
</table>
<br>
<h2>sessionUserMap</h2>
<table border="1">
	<tr>
		<th>사용자아이디</th>
		<th>사용자이름</th>
	</tr>
	<c:forEach items="${sessionUserMap }" var="item">
		<tr>
			<td>${item.value.userId }</td>
			<td>${item.value.name }</td>
		</tr>
	</c:forEach>
	
</table>

</body>
</html>
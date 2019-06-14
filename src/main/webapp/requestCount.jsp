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
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>url</th>
			<th>요청횟수</th>
		</tr>
		<c:forEach items="${requestMap }" var="item">
			<tr>
				<td>${item.key }</td>
				<td>${item.value }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
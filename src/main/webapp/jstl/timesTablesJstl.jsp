<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td{
		padding : 5px;
		border : 1px solid black;
	}
</style>
</head>
<body>

	<table>
		<c:forEach var="i" begin="1" end="${param.gop eq null? 9:param.gop  }" step="1">
			<tr>
			<c:forEach var="j" begin="2" end="${param.dan eq null? 9:param.dan }" step="1">
				<td>${j } * ${i } = ${j*i }</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
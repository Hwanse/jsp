<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr>
			<th>page</th>
			<th><%=pageContext.getAttribute("pageAttribute") %></th>
		</tr>
		
		<tr>
			<th>request</th>
			<th><%=request.getAttribute("requestAttribute") %></th>
		</tr>

		<tr>
			<th>session</th>
			<th><%=session.getAttribute("sessionAttribute") %></th>
		</tr>

		<tr>
			<th>application</th>
			<th><%=application.getAttribute("applicationAttribute") %></th>
		</tr>
	</table>
</body>
</html>
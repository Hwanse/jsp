<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		
		System.out.println("userId : " + request.getParameter("userId"));
	
		// dispatch방식은 경로에 getContextPath()메서드를 넣어줄 필요가 없다.
		// => 서버 내에서 이루어지는(처리되는) 방식이기 때문에 서버경로를 자동으로 잡아줌

		RequestDispatcher rd = 
		request.getRequestDispatcher("/jsp/requestDispatcherTarget.jsp");

		rd.forward(request, response);
	%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${cp}/sumCalculation" method="post">
		
		start <input type="text" name="startParam"/> <br>
		end <input type="text" name="endParam"/><br>
		<button>Sum</button>
	</form>
	
</body>
</html>
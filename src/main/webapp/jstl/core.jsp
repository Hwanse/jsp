<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:set</h2>
	
	<%
		UserVO USER_INFO = (UserVO)session.getAttribute("USER_INFO");
		pageContext.setAttribute("userId", USER_INFO.getAlias());
		// 위 script 문장과 아래 jstl 구문과 같은 의미이다.
	%>
	<!-- var : 속성명, value : 값, scope : page(default), request, session, application -->
	<c:set var="userId" value="${USER_INFO.alias }" scope="request"/>
	userId : ${userId } <br>
	requestScope.userId : ${requestScope.userId } <br>
	
	<!-- target : 대상 속성, property : 대상 속성의 필드 , value : 대입값 -->
	<c:set target="${USER_INFO }" property="alias" value="bear"/>
	USER_INFO.alias : ${USER_INFO.alias } <br>

	<h2>c:if *** c:if는 java의 if - else if - else 중에서 if에만 해당된다. 
	(c:choose 태그가 일반적인 if문 )</h2>
	
	<%-- if(test) 아래태그에서 test속성은 if()의 조건문과 같다  --%>
	<c:if test="${USER_INFO.userId == 'brown' }">
		userId는 brown입니다.
	</c:if>
	
	<c:if test="${USER_INFO.userId == 'sally' }">
		userId는 sally입니다.
	</c:if>

</body>
</html>
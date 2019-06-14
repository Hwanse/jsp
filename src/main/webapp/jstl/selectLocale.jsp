<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/basicLib.jsp" %>
</head>
<script>
	
	$(document).ready(function(){
		
		var locale = '${locale}';
		$("#language").val(locale);		
		
		
		$("#language").on("change", function(){
			var lang = $("#language").val();
			console.log(lang);
			$("#lang").val(lang);
			$("#frm").submit();
		})
		
		for(i=0; i < $("option").length; i++){
			if($("option").eq(i).val() == locale){
				$("h2").text($("option").eq(i).text());
			}
		}
		
	})

</script>
<body>

<h2></h2>
<form id="frm" method="post" action="${cp }/selectLocale">
	<select id="language">
			<option value="ko">한국어</option>
			<option value="en">english</option>
			<option value="ja">日本言</option>
	</select>
	<input type="hidden" id="lang" name="locale" />
</form>
<br>
<fmt:setLocale value="${locale }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/> <br>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

</body>
</html>
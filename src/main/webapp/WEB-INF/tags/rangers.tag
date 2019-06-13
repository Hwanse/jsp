<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.List"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="rangers" type="java.lang.String" required="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select>
	<!-- 방법1 : forTokens -->
	<%-- <c:forTokens items="${rangers }" delims="," var="ranger">
		<option>${ranger }</option>
	</c:forTokens> --%>
	<!-- 방법2 : forEach -->
	<c:forEach items="${rangers.split(',') }" var="ranger">
		<option>${ranger}</option>
	</c:forEach>
</select>
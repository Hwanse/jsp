<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

jstl import는 script의 document.location 과 동일한 기능을 한다.

<c:import var="test" url="https://search.naver.com/search.naver">
	<c:param name="query" value="html5"/>
</c:import>
${test }



<%@tag import="kr.or.ddit.prod.service.IProdService"%>
<%@tag import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@tag import="kr.or.ddit.prod.model.ProdVO"%>
<%@tag import="java.util.List"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" type="java.lang.String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	IProdService prodService = ProdServiceImpl.getInstance();
	List<ProdVO> prodList = prodService.getProdList((String)jspContext.getAttribute("code"));
%>
<select>
	<c:forEach items="<%=prodList %>" var="vo">
		<option>${vo.prod_name }</option>
	</c:forEach>
</select>

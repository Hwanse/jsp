<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.Integer" required="false" %>
<c:forEach begin="1" end="${size eq null? 5 : size}" step="1"><font color="${color}">=</font></c:forEach>
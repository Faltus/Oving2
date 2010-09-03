<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:include page="header.jsp" />

<h1>Kaffekopper AS</h1>
<img src="javakaffe.jpg" alt="Kaffemann"/>

<fmt:bundle basename="MessagesBundle">
	<p><fmt:message key="prod"/> <a href="products"><fmt:message key="products"/></a> </p>
</fmt:bundle>

<jsp:include page="footer.jsp" />
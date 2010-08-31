<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:bundle basename="MessagesBundle"><fmt:message key="cart"/></fmt:bundle></title>
</head>
<body>
<p><a href="?lng=no_NO">Norsk</a> <a href="?lng=en_US">English (US)</a> <a href="?lng=es_ES">Español</a></p>

<fmt:bundle basename="MessagesBundle">
	<h2><fmt:message key="cart"/></h2>
	<table>
		<tr><td><fmt:message key="name"/></td><td>Short Description</td><td><fmt:message key="price"/></td><td>Quantity</td><td>Total</td></tr>
		
		
		
		<tr></tr>
	</table>
	<p><a href="home"><fmt:message key="home"/></a> <a href="products"><fmt:message key="products"/></a></p>
</fmt:bundle>

<t:copyright since="2008">Høgskolen i Bergen</t:copyright>
</body>
</html>
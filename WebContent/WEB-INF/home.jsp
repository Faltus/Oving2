<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:bundle basename="MessagesBundle"><fmt:message key="home"/></fmt:bundle></title>
</head>
<body>
<p><a href="?lng=no_NO">Norsk</a> <a href="?lng=en_US">English (US)</a> <a href="?lng=es_ES">Español</a></p>

<h1>Kaffekopper AS</h1>
<img src="javakaffe.jpg" alt="Kaffemann"/>

<fmt:bundle basename="MessagesBundle">
	<p><fmt:message key="prod"/> <a href="products"><fmt:message key="products"/></a> </p>
</fmt:bundle>

<t:copyright since="2008">Høgskolen i Bergen</t:copyright>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:bundle basename="MessagesBundle"><fmt:message key="products"/></fmt:bundle></title>
</head>
<body>
<p><a href="?lng=no_NO">Norsk</a> <a href="?lng=en_US">English (US)</a> <a href="?lng=es_ES">Español</a></p>

<fmt:bundle basename="MessagesBundle">
	
	<c:forEach var="p" items="${products}">
		<h2>${p.name} (TM)</h2>
		<div style="min-height:120px;"><img src="${p.image}" style="float:left; margin-right:2px;"/>
		<p>
		<fmt:message key="name"/>: ${p.name} (TM)<br />
		<fmt:message key="price"/>: <fmt:formatNumber type="currency">${p.price}</fmt:formatNumber><br />
		<fmt:message key="desc"/>: ${p.desc}<br />
		</p>
		<form method="post">
			<input name="pNumber" type="hidden" value="${p.number}" />
			<button value="submit"><fmt:message key="add"/></button>
		</form>
		</div>
	</c:forEach>
	
	<p><a href="home"><fmt:message key="home"/></a> <a href="cart"><fmt:message key="cart"/></a></p>
</fmt:bundle>

<t:copyright since="2008">Høgskolen i Bergen</t:copyright>
</body>
</html>
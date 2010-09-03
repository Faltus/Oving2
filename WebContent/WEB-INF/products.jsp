<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<jsp:include page="header.jsp" />

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
	<c:if test="${added != null}"><p style="color:red;" >${added} <fmt:message key="isAdded"/></p>
		<% session.removeAttribute("added"); %>
	</c:if>
	<p><a href="home"><fmt:message key="home"/></a> <a href="cart"><fmt:message key="cart"/></a></p>
</fmt:bundle>

<jsp:include page="footer.jsp" />
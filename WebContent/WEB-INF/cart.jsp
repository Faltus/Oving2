<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="header.jsp" />

<fmt:bundle basename="MessagesBundle">
	<h2><fmt:message key="cart"/></h2>
	<c:choose>
		<c:when test="${tom == null}">
			<table>
				<tr><th><fmt:message key="name"/></th><th><fmt:message key="shortDesc"/></th><th><fmt:message key="price"/></th><th><fmt:message key="quantity"/></th><th><fmt:message key="total"/></th></tr>
				
				<c:forEach var="c" items="${cart}">
					<tr><td>${c.product.name}</td><td>${c.product.desc}</td><td style="text-align:right;"><fmt:formatNumber type="currency">${c.product.price}</fmt:formatNumber></td><td style="text-align:right;">${c.quantity}</td><td style="text-align:right;"><fmt:formatNumber type="currency">${c.totalPrice}</fmt:formatNumber></td></tr>
				</c:forEach>
				
				<tr style="font-weight:bold; text-align:right;"><td colspan="4"><fmt:message key="amount"/>:</td><td><fmt:formatNumber type="currency">${total}</fmt:formatNumber></td></tr>
			</table>
		</c:when>
		<c:otherwise>
			<p style="color:red;">${tom}</p>
		</c:otherwise>
	</c:choose>
	<p><a href="home"><fmt:message key="home"/></a> <a href="products"><fmt:message key="products"/></a></p>
</fmt:bundle>

<jsp:include page="footer.jsp" />
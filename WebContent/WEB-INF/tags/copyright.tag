<jsp:doBody var="theBody"/>

<%@ tag import="util.JspHelper" import="java.util.Calendar"%>
<%@ attribute name="since" required="true"%>

<%
String bc = jspContext.getAttribute("theBody").toString();
int year = Integer.parseInt(jspContext.getAttribute("since").toString());

Calendar cal=Calendar.getInstance();
int currentYear=cal.get(Calendar.YEAR);

String romanyear1 = JspHelper.toRoman(year);
String romanyear2 = JspHelper.toRoman(currentYear);
%>

<%= "<i> &#169 " + romanyear1 + "-" + romanyear2 + " " + bc + "</i>" %>
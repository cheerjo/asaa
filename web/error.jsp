<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>오류페이지</title>
</head>
<body>
<%
Exception e = (Exception) request.getAttribute("javax.servlet.error.exception");
if (e != null) {
%>
Error Class:
<%= e.getClass().getName() %><p>Error Message: <%= e.getMessage() %>
<p>
<pre>
<% e.printStackTrace(new java.io.PrintWriter(out)); %>
</pre>
<%
}
%>
</body>
</html>
<%@page import="org.springframework.http.HttpRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="org.springframework.security.core.authority.AuthorityUtils" %>
<%@ page import="java.security.Principal" %>
<%@page session="true"%>
<html>
<head>
<meta charset="UTF-8">
<title>Ghanshyam's Tutorial</title>
</head>
<body>
Ghanshayam's  Tutorial
<% 
Principal principal=request.getUserPrincipal();
if(principal==null)
{
out.println("<form action=\"login\"><input type=\"submit\" value=\"Login\"><form>");
response.sendRedirect("login");
return;
}
%>
<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>

</body>
</html>

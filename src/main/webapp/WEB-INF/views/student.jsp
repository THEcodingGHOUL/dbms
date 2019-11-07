<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page session="true"%>
<html>
<head>
<title>user</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<style >

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: black;
}

li {
  float: right;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #E91E63;
  transition: transform .3s;
  transform: scale(1.2);
}


</style>
</head>
<body style="background:#1DE9B6 ">

	<ul>
<li><a href="<c:url value="/home" />">HOME</a></li>
<li><a href="<c:url value="/login" />">LOGIN</a></li>
<li><a href="<c:url value="/admin" />" >ADMIN</a></li>
<li><a href="<c:url value="/teacher" />" >TEACHER</a></li>
<li><a href="<c:url value="/student" />" >STUDENT</a></li>
<li><a href="<c:url value="/j_spring_security_logout" />" >LOGOUT</a></li>
</ul>
   
	<br>
	<br>
	<br>
	<div class="container"> 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${user}
        </h2>
    </c:if>
    <br>
    <br>
    <h2><a href="<c:url value="/student/profile/${user}" />">Profile</a></h2>
    <h2><a href="<c:url value="/student/exam/${user}" />">Exams</a></h2>
    <h2><a href="<c:url value="/student/examresult/${user}" />">Exam Result</a></h2>
    <h2><a href="<c:url value="/student/subject/${user}" />">Your Subjects</a></h2>
    </div>
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
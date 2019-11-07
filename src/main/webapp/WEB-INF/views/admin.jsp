<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>ADMIN</title>
<style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            width: 50%;

        }
        th, td {
            padding: 15px;
            text-align: left;

        }
        tr:nth-child(even) {background-color: darkgray;}
        tr:hover {background-color:navajowhite;}
        tr:nth-child(even){background-color: #f2f2f2}

        table {
            border-spacing: 5px;
            background-color: rebeccapurple;
        }
        body{
            background-color: #8e92e8;
        }
        .button {
            color: white;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            /margin-bottom: 25px;/
            cursor: pointer;
            border: 4px solid peachpuff;
            padding: 14px 40px;
            border-radius: 34px;
            transition: 0.25s;
            background-color: #1c87c9;
            margin: 20px auto;
        }
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<ul>
<li><a href="<c:url value="/home" />">HOME</a></li>
<li><a href="<c:url value="/login" />">LOGIN</a></li>
<li><a href="<c:url value="/admin" />" >ADMIN</a></li>
<li><a href="<c:url value="/teacher" />" >TEACHER</a></li>
<li><a href="<c:url value="/student" />" >STUDENT</a></li>
<li><a href="<c:url value="/j_spring_security_logout" />" >LOGOUT</a></li>
</ul>
<div class="container">
<div class="jumbotron">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome to the admin page :<mark>${user}</mark>  | <a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a>
        </h2>
    </c:if>
    </div>
    <h2> <a href="<c:url value="/admin/studentsinfo" />">All Students</a></h2>
    <h2> <a href="<c:url value="/admin/teachersinfo" />">All teachers</a></h2>
    <h2><a href="<c:url value="/admin/examsinfo" />">Exams and Results</a></h2>
    <h2><a href="<c:url value="/admin/subjectsinfo" />">Subjects</a></h2>
    <h2><a href="<c:url value="/admin/feedbacks" />">Student's Feedbacks</a></h2>
    </div>
</body>
</html>

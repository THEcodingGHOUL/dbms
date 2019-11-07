<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>

<head>
<title>LOGIN</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
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
.content{
border:5px solid black;
border-radius:20px;
}

</style>
</head>
<body onload='document.loginForm.j_username.focus()' style="background: #ffe6e6">
<ul>
<li><a href="<c:url value="/home" />">HOME</a></li>
<li><a href="<c:url value="/login" />">LOGIN</a></li>
<li><a href="<c:url value="/admin" />" >ADMIN</a></li>
<li><a href="<c:url value="/teacher" />" >TEACHER</a></li>
<li><a href="<c:url value="/student" />" >STUDENT</a></li>
<li><a href="<c:url value="/j_spring_security_logout" />" >LOGOUT</a></li>
</ul>

	
	<div>
		<center>
			<div class="container">
				<div class="content" style="background:#69F0AE  !important" class="jumbotron">
					<h2 style="font-size: 50px;font-family: Western">GHANSHAYAM'S TUTORIALS</h2>
					<p>NURTURING THE FUTURE CREATORS</p>
				</div>
				<h3 style="font-size: 25px">Login</h3>

				<%
					String errorString = (String) request.getAttribute("error");
					if (errorString != null && errorString.trim().equals("true")) {
						out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
					}
				%>

				<form name='loginForm' action="<c:url value='login' />"
					method='POST' class="form-inline">
					<div class="form-group" style="font-size: 22px">
						<label>username:</label> <input type='text' name='username'
							class="form-control" placeholder="username" value=''><br>
					</div>
					<br>
					<div class="form-group" style="font-size: 22px">
						<label>Password:</label> <input type='password' name='password'
							class="form-control" placeholder="password" />
					</div>
					<br> <input name="submit" type="submit"
						class="btn btn-success" value="LogIn" /> <input name="reset"
						type="reset" class="btn btn-success" value="Reset" />

				
		</center>
	</div>
	</div>
	</div>
	
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
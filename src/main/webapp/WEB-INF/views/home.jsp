
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <style type="text/css">
    
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
#banner{
  margin-left:50px;
  margin-right:50px;
  text-align:center;
  font-size:20px;
  background-color:#FF9100;
  border:4px solid black;
  margin-top:10px;
  margin-bottom:20px;
  border-radius:50px;
  
}
#banner:hover{
  background-color:#EA80FC;
  transition: transform .4s;
  transform: scale(1.1);
  transition: background-color .4s;
  
}
h1{
  border:5px double black;
  background-color:red;
}

</style>
</head>
<body align="center" style="background-color:#18FFFF">
<ul>
<li><a href="<c:url value="/home" />">HOME</a></li>
<li><a href="<c:url value="/login" />">LOGIN</a></li>
<li><a href="<c:url value="/admin" />" >ADMIN</a></li>
<li><a href="<c:url value="/teacher" />" >TEACHER</a></li>
<li><a href="<c:url value="/student" />" >STUDENT</a></li>
<li><a href="<c:url value="/j_spring_security_logout" />" >LOGOUT</a></li>
</ul>

<div id="banner">
<p><b>WELCOME TO GHANSHYAM TUTORIALS</b></p>
</div>
<h1>About Us</h1>

<h2>
 Tutions for students of all classes from standard 8th to 10th
 
 
 Address : West mahesh Nagar,Patna
</h2>a

<div>
<p></p>
</div>



</body>
</html>
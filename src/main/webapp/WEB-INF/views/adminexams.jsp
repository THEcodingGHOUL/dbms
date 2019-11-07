<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EXAMS</title>
         <style>
table{
  background-color:white;
  text-align:center;
  border-collapse:collapse;
  width:100%;

}
th{
  background-color:black;
  color:white;
}
td{
  background-color:#E0F2F1;
}
td:hover{
  background-color:#E0F2F1;
  transform:scale(1.2);
  transition: transform .3s;
  transition: background-color 0.3s;
}
body{
  background-color:#FF80AB;
}
h1{
  border:3px solid black;
  background-color: #E0F2F1;
  border-radius:5px;

}
h3{
  border:3px solid black;
  background-color: white;
  border-radius:8px;
  width:fit-content;
  padding:5px 15px 5px 15px;
}
h2{
  border:3px solid black;
  background-color: white;
  border-radius:8px;
  width:fit-content;
  padding:5px 15px 5px 15px;
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
        <div align="center">
            <h1>ALL EXAMS</h1>
            <h3><a href="<c:url value="/admin/examsinfo/addexam" />">ADD EXAM</a></h3>
            
            <table border="1">
                <th>No</th>
                <th>subjectName</th>
                <th>examDate</th>
                <th>time</th>
                <th>venue</th>
                <th>action</th>
  

                
          
                
                 
                <c:forEach var="a" items="${exam}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${a.subjectName}</td>
                    <td>${a.examDate}</td>
                    <td>${a.time}</td>
                    <td>${a.venue}</td>
                    
                    <td><a href="<c:url value="/admin/examsinfo/addresult/${a.examId}" />">Add Result</a>
                    </td>
     
                    
                    
                                       
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>





<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>subject</title>
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

</style>
    </head>
    <body>
    
    <h1> Your subject : ${subjectname}</h1>


<div class="container">
<div class="jumbotron">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome to the Teacher page :<mark>${user}</mark> 
					
        </h2>
    </c:if>
    </div>
    <h2> <a href="<c:url value="/teacher/addnot/${subjectname}" />">Add notification</a></h2>
    
    </div>
    
    
        <div align="center">
        		
        
            <h1>SUBJECT DASHBOARD</h1>
            
            
            
            
            <h2>SUBJECT NOTIFICATIONS</h2>
            
            <table border="1">
                <th>No</th>
                <th>blogId</th>
                <th>content</th>
                <th>date</th>
                <th>Actions</th>

               

                
          
                
                 
                <c:forEach var="a" items="${blog}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${a.blogId}</td>
                    <td>${a.content}</td>
                    <td>${a.date}</td>
                    
                   
                    <td><a href="<c:url value="/teacher/${a.blogId}/showcomments" />" >Show comments</a>
                   </td>
     
                    
                                       
                </tr>
                </c:forEach>             
            
            
        </div>
    </body>
</html>

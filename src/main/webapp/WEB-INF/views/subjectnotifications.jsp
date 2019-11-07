
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <html>
<head>
<style>
body
{  
  background-color:#FBE9E7;
  margin: 0;
  position: absolute;
  top: 50%;
  left:50%;
  -ms-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
}
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
h1{
  text-align:center;
  border: 2px black;
    border-style:solid;
    padding-left:40px;
    padding-right:40px;
    border-radius:18px;
    background-color:white;
}
h2{
text-align:center;
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
 
        <h1>Add notifications for  subject : ${subjectId} </h1>  
        
       <form:form method="post"  action="/springproject/teacher/addnot/${subjectId}"	modelAttribute="sr">    
        <table >   
         
         <tr>
         <td>Id</td>
         <td><form:input path="blogId" /></td>
         </tr>
            
         <tr>
         <td>Add Notification</td>
         <td><form:input path="content" /></td>
         </tr> 
         <tr>    
          <td>Subject</td>  
          <td><form:input path="subjectName" /></td>  
         </tr> 
         
         <tr>    
          <td>Date</td>    
          <td><form:input path="date" /></td>  
         </tr>  
         
 
         
         
         <tr>
         <td></td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  </body>  </html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
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

<h1>Add Teacher</h1>  
<h2>Also update subject for seeing subject Dashboard</h2>

<a href="<c:url value="/admin/subjectsinfo" />">See Subjects</a>
        
       <form:form method="post"  action="/springproject/admin/teachersinfo/addteacher"	modelAttribute="sr">    
        <table >       
         <tr>
         <td>Username</td>
         <td><form:input path="username" required="required"/></td>
         </tr> 
         <tr>    
          <td>Password</td>    
          <td><form:input path="password" type="password" required="required"/></td>  
         </tr> 
         
         <tr>    
          <td>Name</td>    
          <td><form:input path="name" required="required"/></td>  
         </tr>  
         
         
         <tr>    
          <td>Phone</td>    
          <td><form:input path="phone" required="required"/></td>  
         </tr> 
         
         <tr>    
          <td>Age</td>    
          <td><form:input path="age" required="required"/></td>  
         </tr> 
         
         <tr>    
          <td>Email</td>    
          <td><form:input path="email" required="required"/></td>  
         </tr> 
         
         <tr>    
          <td>Address</td>    
          <td><form:input path="address" required="required"/></td>  
         </tr> 
         
          <tr>    
          <td>Subject</td>    
          <td><form:input path="subjectName" required="required"/></td>  
         </tr> 
         
   
         
         
         <tr>
         <td></td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    

</body>

        
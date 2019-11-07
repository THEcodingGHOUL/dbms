
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

</style>
</head> 

		<a href="<c:url value="/admin/subjectsinfo" />">See Subjects and Courses</a>
  

        <h1>Add Subject</h1>  
        
       <form:form method="post"  action="/springproject/admin/subjectsinfo/addsubject"	modelAttribute="sr">    
        <table >       
         <tr>
         <td>SubjectName</td>
         <td><form:input path="SubjectName" required="required"/></td>
         </tr> 
         <tr>    
          <td>Course Name</td>  
          <td><form:input path="courseName" required="required"/></td>  
         </tr> 
         
         
 

          <tr>    
          <td>Timetable</td>    
          <td><form:input path="timetable" required="required"/></td>  
         </tr> 
         

         
         <tr>
         <td></td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
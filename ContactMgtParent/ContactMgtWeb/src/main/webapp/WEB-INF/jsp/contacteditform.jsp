<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  <body style="background-color:powderblue;">
		<h1 style="color:green">Edit Contact</h1>
       <form:form method="POST" action="/ContactMgtWeb/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td ><form:hidden  path="contactId" /></td>
         </tr> 
         <tr>  
          <td style="color:teal">First Name : </td> 
          <td><form:input path="firstName"  style="background-color:pink;" /></td>
         </tr>  
         <tr>  
          <td style="color:teal">Last Name :</td>  
          <td><form:input path="lastName"  style="background-color:pink;" /></td>
         </tr> 
         <tr>  
          <td style="color:teal">Email :</td>  
          <td><form:input path="email"  style="background-color:pink;" /></td>
         </tr> 
         
          <tr>  
          <td style="color:teal">Phone Number :</td>  
          <td><form:input path="phoneNumber"  style="background-color:pink;" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" style="background-color:coral;"/></td>  
         </tr>  
        </table>  
       </form:form>  

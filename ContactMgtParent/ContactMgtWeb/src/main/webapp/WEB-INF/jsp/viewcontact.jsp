    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<body style="background-color:powderblue;">
	<h1 style="color:green">Contact List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr style="background-color:pink;"><th style="color:green">FirstName</th><th style="color:green">LirstName</th><th style="color:green">Email</th><th style="color:green">PhoneNumber</th><th style="color:green">Edit</th><th style="color:green">Delete</th></tr>
    <c:forEach var="contact" items="${list}"> 
    <tr style="background-color:pink;">
    <td style="color:green">${contact.firstName}</td>
    <td style="color:green">${contact.lastName}</td>
    <td style="color:green">${contact.email}</td>
    <td style="color:green">${contact.phoneNumber}</td>
    <td style="color:green"><a href="editcontact/${contact.contactId}">Edit</a></td>
    <td style="color:green"><a href="deactivateContact/${contact.contactId}" >Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="contactform" >Add New Contact</a>
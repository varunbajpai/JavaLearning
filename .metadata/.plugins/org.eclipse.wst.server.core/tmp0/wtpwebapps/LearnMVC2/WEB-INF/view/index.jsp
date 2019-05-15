<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
  <head>
    <meta charset="utf-8">
    <title>Login Form Design</title>

  </head>
  <body>
	
	<form:form action="processForm" modelAttribute="student"> 		
	First name: <form:input path="firstName" />
	<br><br>
	Last name: <form:input path="lastName" /> 
	<br><br> 
	<input type="submit" value="Submit" />
	
	<form:select path="country"> 
	<form:options items = "${student.countryOptions}" /> 
	</form:select> 	
	
	<br>
	 Java<form:radiobutton path="favoriteLanguage" value="Java" /> 
	 C#<form:radiobutton path="favoriteLanguage" value="C#" />
	 PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
	 Ruby<form:radiobutton path="favoriteLanguage" value="Ruby" />
	<br>
	
	Linux <form:checkbox path="operatingSystems" value="Linux" /> 
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS" /> 
	MS Windows <form:checkbox path="operatingSystems" value="MS Windows" /> 


	</form:form> 
	

	
	
	
	
  </body>
</html>

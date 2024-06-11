<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Sign Up</h1>
	
	<form action ="/saveuser" method="post">
		
		FirstName : <input type="text" name="firstName"/>
		Email : <input type="text" name="email"/>
		Password : <input type="text" name="password"/>
		<input type="submit" value="Submit"/>
		
	</form>
</body>
</html>
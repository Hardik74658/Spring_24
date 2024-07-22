<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<h1>Welcome , ${user.getName()}</h1>
	
	<a href="/newproduct" >New Product</a>
	<br>
	<a href="/products" >All Product</a>
	<br>
	<a href="/userproducts" >User Product</a>
	<br>
	<img src="${user.getProfilePicPath()}" width="200">
	

</body>
</html>
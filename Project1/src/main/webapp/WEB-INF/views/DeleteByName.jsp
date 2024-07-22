<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="deleteProduct">
		Enter Product Name : <input type="text" name="productName">
		<h3 style="color:red;">${productNameError}</h3> 
		<br><br>
		<input type="submit" value="Delete"> 
	</form>

</body>
</html>
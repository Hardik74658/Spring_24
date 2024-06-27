<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="saveproduct" enctype="multipart/form-data">
	
		Product Name : <input type="text" name = "productName" /><br><br>
		Category : <input type="text" name = "category" /><br><br>
		Quantity : <input type="number" name = "qty" /><br><br>
		Price : <input type="number" name = "price" /><br><br>
		
		Master Image : <input type="file" name="masterImage"/>
		
		<input type="submit" value="Add Product">
	</form>

</body>
</html>
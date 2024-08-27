<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Total Amount : $ ${ totalAmnt }</h1>
	<form method="post" action="">
		
		Credit Card No : <input type="text" name="cardNo" /><br><br>
		Expiry Date : <input type="date" name="expDate" /><br><br>
		CVV : <input type="number" name="cvv" /><br><br>
		<input type="submit" name="Checkout" /><br><br>
		
	</form>
</body>
</html>
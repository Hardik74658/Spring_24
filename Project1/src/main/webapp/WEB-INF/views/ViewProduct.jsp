<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body class="bg-primary">
	<div class="container mt-5">
	    <div class="row justify-content-center text-center">
	        <div class="col-md-8 col-lg-6">
	            <div class="card shadow-lg border border-dark rounded-lg">
	                <img src="${productBean.productImagePath}" class="card-img-top" alt="${productBean.productName}" style="max-height: 400px; object-fit: cover;">
	                <div class="card-body">
	                    <h1 class="card-title">${productBean.productName}</h1>
	                    <h2 class="card-subtitle mb-2 text-muted">${productBean.category}</h2>
	                    <p class="card-text">Quantity: ${productBean.qty}</p>
	                    <p class="card-text">Price: ${productBean.price}</p>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>


</body>
</html>
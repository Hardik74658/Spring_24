<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid p-5">
		
		<div class="row d-flex align-items-md-center p-5">
			<div class="col-md-3"></div>
			<div class="col-md-6 p-5">

				<h2>Ecom Signup</h2>


				<form method="post" enctype="multipart/form-data" action="/signup">
				
					<div class="form-group">
						Name : <input type="text" name="name" class="form-control"/>
					</div>
					<div class="form-group">
						Email : <input type="email" name="email" class="form-control"/>
					</div><div class="form-group">
						Password: <input type="password" name="password" class="form-control"/>
					</div><div class="mb-3">
						Profile : <input  type="file" id="formFile" name="profilePic" class="form-control"/>
					</div>
					
					
					<input type="submit" value="SignUp" class="btn btn-primary"/>
					
				
				</form>
				<br> 
							
				<span class="text-danger">${error}</span>

			</div>


		</div>

	</div>


</body>
</html>
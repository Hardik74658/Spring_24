<%@page import="com.bean.EProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h2 class="m-4 justify-content-center text-center">MyCart</h2>
    
    <%
    List<EProductBean> products = (List<EProductBean>) request.getAttribute("products");
    Float price = 0.0f;
    %>
    
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th>ProductId</th>
                    <th>ProductName</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (EProductBean p : products) {
                    out.print("<tr>");
                    out.print("<td>" + p.getProductId() + "</td>");
                    out.print("<td>" + p.getProductName() + "</td>");
                    out.print("<td><img class='img-fluid' height='100px' width='100px' src='"+p.getProductImagePath()+"'/></td>");
                    out.print("<td>$" + p.getPrice() + "</td>");
                    out.print("<td>" + p.getQty() + "</td>");
                    out.print("<td>$" + p.getQty()*p.getPrice() + "</td>");
                    out.print("<td><a href='/removecartitem?productId="+p.getProductId()+"' class='btn btn-danger btn-sm'>Remove</a></td>");
                    out.print("</tr>");
                    
                    price = price + p.getPrice()*p.getQty(); 
                }
                %>
            </tbody>
        </table>
    </div>

    <div class="mt-4">
        <h4>Total Amount : $<%= price %></h4>
    </div>

    <div class="mt-3">
        <a href="checkout" class="btn btn-primary">Checkout</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
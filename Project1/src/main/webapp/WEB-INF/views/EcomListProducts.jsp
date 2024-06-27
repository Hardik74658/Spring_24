<%@page import="com.bean.EProductBean"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>List Products</h2>
	
	<h3>Add <a href="/newproduct">New Product</a> </h3>
	
	<%
	
		List<EProductBean> products = (List<EProductBean>)request.getAttribute("products");
	
	%>
	
	<table border="1">
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Action</th>
		</tr>
		
		<%
			
			for(EProductBean p : products){
			
				out.print("<tr>");
				out.print("<td>"+p.getProductId()+"</td><td>"
				+p.getProductName()+"</td><td><a href='/delete?productId="+p.getProductId()+"'>Delete</a> | <a href='/view?productId="+p.getProductId()+"'>View</a></td>");
				out.print("</tr>");
			
			}
		
		%>
	
	</table>
	
</body>
</html>
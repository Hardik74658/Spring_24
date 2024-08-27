<%@page import="com.entity.RestaurantEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>List Restaurant</h2>
	
	<%
	
		List<RestaurantEntity> restaurants = (List<RestaurantEntity>)request.getAttribute("restaurants");	
		
	%>
	
	<table border="1">
	
		<tr>
			<td>RestaurantId</td>
			<td>Name</td>
			<td>Category</td>
			<td>Action</td>		
		</tr>
		
		
		<%
		
			for(RestaurantEntity r : restaurants){
				
				out.print("<tr>");
				out.print("<td>"+r.getRestaurantId()+"</td>");
				out.print("<td>"+r.getName()+"</td>");
				out.print("<td>"+r.getCategory()+"</td>");
				out.print("<td><a href='delete?restaurantId="+r.getRestaurantId()+"'></td>");
				out.print("</tr>");
				
			}
		
		
		%>
		
	</table>


</body>
</html>
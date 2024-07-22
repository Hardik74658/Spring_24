<%@page import="com.bean.EUserBean"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
	 	List<EUserBean> users = (List<EUserBean>)request.getAttribute("users");
	
	%>
	<table border="1">
		
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		
		
	<%
	
		for(EUserBean user : users){
			
			out.print("<tr>");
			out.print("<td>"+user.getId()+"</td>");
			out.print("<td>"+user.getName()+"</td>");
			out.print("<td><a href='delete?id="+user.getId()+"'>delete</a></td>");
			out.print("</tr>");
		}
	
	%>
	
	
	
	</table>


</body>
</html>
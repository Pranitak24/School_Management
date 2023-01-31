<%@page import="School_Management.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Student s=(Student)session.getAttribute("abc2");%>
<table cellpadding ="20px" border="1" bgcolor="orange">
<th>ID</th>
<th>NAME</th>
<th>STREAM</th>
<th>FEES</th>
<tr align="center">
<td><%=s.getId()  %></td>
<td><%=s.getName() %></td>
<td><%=s.getStream() %></td>
<td><%=s.getFees() %></td>
</tr>

</table>
			<a href ="Combine.html "> <u> Combine </u> </a> <br>
</body>
</html>

</body>
</html>
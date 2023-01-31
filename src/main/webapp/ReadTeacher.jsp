<%@page import="School_Management.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Teacher</title>
</head>
<body bgcolor="yellow" >
<%Teacher t=(Teacher)session.getAttribute("abc1");%>
<center>
<table cellpading="50px" border="1" bgcolor="pink">
<tr>
<th>ID</th>
<th>NAME</th>
<th>SUBJECT</th>
<th>SALARY</th>
</tr>
<tr>
<td><%=t.getId() %></td>
<td><%=t.getName() %></td>
<td><%=t.getSubject()%></td>
<td><%=t.getSalary() %></td>
</tr>
</table>
<a href ="Combine.html "> <u> Combine </u> </a> <br>


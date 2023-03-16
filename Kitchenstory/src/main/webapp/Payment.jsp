<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.simplilearn.kitchenstory.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Payment">

Pay Now <Input Type="submit" name="Go">
<%List<Product> s=(List<Product>)request.getAttribute("list");%> 

 
  <table border="1">
<tr><th> Product Id </th><th>Product  Name </th><th> Product Price </th><th> Pay with cash </th></tr>
</table>
</form>
</body>
</html>
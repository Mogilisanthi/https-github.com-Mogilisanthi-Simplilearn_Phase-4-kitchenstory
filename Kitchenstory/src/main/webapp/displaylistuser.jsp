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
<%List<Product> s=(List<Product>)request.getAttribute("list");%> 

 
<table border="1">
<tr><th> Product Id </th><th> Product Name </th><th> Product Category </th><th> Product Description </th><th>Product Price </th><th> Buy Product </th></tr>

<%for(Product se:s){%>
<tr><td><%=se.getId()%></td><td><%=se.getName() %></td><td><%=se.getCategory() %></td><td><%=se.getDescription() %></td><td><%=se.getPrice()%></td>
<td><form action="buynow">
<input type="hidden" name="price" value=<%=se.getPrice() %>>
<input type="submit" class="button" value="BuyNow">
</form></td>
</tr>
<%}%>
</table>
</body>
</html>
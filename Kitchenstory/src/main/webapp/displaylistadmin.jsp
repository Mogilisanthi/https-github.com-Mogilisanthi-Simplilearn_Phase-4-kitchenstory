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
<%-- <%User u= (User)request.getAttribute("user");%>
<%="Welcome "+u.getUser() %> --%>

<a href ="AdminMainIndex.jsp"> Go to Main Admin Page</a>
<br>


<%List<Product> s=(List<Product>)request.getAttribute("list");%> 

 
<table border="1">
<tr><th> Product Id </th><th> Product Name </th><th> Product Category </th><th> Product Description </th><th>Product Price </th><th> Delete Product </th><th> Update Product </th></tr>

<%for(Product se:s){%>
<tr><td><%=se.getId()%></td><td><%=se.getName() %></td><td><%=se.getCategory() %></td><td><%=se.getDescription() %></td><td><%=se.getPrice()%></td><td>
<form action="deleteproduct">
<input type="hidden" name="pid" value=<%=se.getId() %>>
<input type="submit" class="button" value="deleteproduct">
</form></td>
<td>
<form action="editproduct.jsp">
<input type="hidden" name="id" value=<%=se.getId() %>>
<input type="submit" class="button" value="updatedetails">
</form></td></tr>
<%}%>

</table>
</body>
</html>
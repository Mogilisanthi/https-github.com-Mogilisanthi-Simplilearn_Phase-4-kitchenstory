<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editproduct">
<table>
<tr><td><input type="hidden" name="id" value=<%=request.getParameter("id") %>></td></tr>
<tr><td>Edit Product Name <input type="text"  name="name"></td></tr>
<tr><td>Edit Product category <input type="text" name="category"></td></tr>
<tr><td>Edit Product description <input type="text" name="description"></td></tr>
<tr><td>Edit Product price <input type="number"name="price"></td></tr>
<tr><td><input type="submit" class="button" value="updateproduct"></td></tr>
</table>
<a href="productlist.jsp">updated product list  </a><br>
<a href="index.jsp">Go to main page...  </a><br>
</form>
</body>
</html>
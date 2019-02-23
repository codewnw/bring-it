<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.bringit.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Items</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<%
		List<Item> items = (List<Item>) request.getAttribute("items");
		for (Item item : items) {
	%>
	<img src="${pageContext.request.contextPath}/<%= item.getImageUrl()%>" height="200px" width="200px" class="rounded" alt="">
	
	<a href="#" class="btn btn-success" >Buy Now</a>
	<%
		}
	%>

	<jsp:include page="footer.jsp" />
</body>
</html>
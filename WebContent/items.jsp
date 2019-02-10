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
	%><img src="${pageContext.request.contextPath}/resources/images/<%= item.getName() %>.jpg" height="200px" width="200px" class="rounded" alt="">
	<%
		}
	%>



	<img src="..." class="rounded float-right" alt="...">
	<jsp:include page="footer.jsp" />
</body>
</html>
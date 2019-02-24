<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.bringit.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Items</title>
</head>
<body>
	<jsp:include page="header.jsp" />
<div class="container">
	<c:forEach var="item" items="${requestScope.items}">
		<div style="float: left; width: 200px; margin: 5px">
			<div style="float: left; width: 100%;">
				<a href="${pageContext.request.contextPath}/items/get/${item.id}"><img src="${pageContext.request.contextPath}/${item.imageUrl}"
					height="200px" width="200px" class="rounded" alt="">
					</a>
			</div>
			<div style="float: left; width: 100%;">
				<div style="float: left; width: 50%;">${item.name}</div>
				<div style="float: left; width: 50%;" align="right">${item.price}</div>
			</div>
			<div style="float: left; width: 100%;">
				<a href="#" class="btn btn-success btn-block">Buy Now</a>
			</div>
		</div>
	</c:forEach>


</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
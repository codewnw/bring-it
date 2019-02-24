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
		<div style="float: left; width: 100%">
			<div style="float: left; width: 100%">
				<div style="float: left; width: 50%">
					<img alt=""
						src="${pageContext.request.contextPath}/${requestScope.item.imageUrl}"
						width="100%" height="400px">
				</div>
				<div style="float: left; width: 50%">
					<table>
						<tr><td>${requestScope.item.name}</td></tr>
						<tr><td>${requestScope.item.description}</td></tr>
						<tr><td>${requestScope.item.price}</td></tr>
						<tr><td>In stock ${requestScope.item.quantity} items</td></tr>
						<tr><td><a href="#" class="btn btn-success btn-block">Buy Now</a></td></tr>
						</table>
				</div>
			</div>
			<div style="float: left; width: 100%">
				<hr />
				Something else
			</div>
		</div>

	</div>
	<%-- <jsp:include page="footer.jsp" /> --%>
</body>
</html>
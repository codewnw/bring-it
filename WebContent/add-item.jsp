<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new Item</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<h1 class="display-3">${requestScope.item eq null ? 'Add new' : 'Update existing'} Item</h1>
		<form action="${requestScope.item eq null ? 'items/save' : 'items/update'}" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Item Name</label> <input type="text"
						class="form-control" name="name" id="inputEmail4"
						placeholder="Item Name" value="${requestScope.item.name}">
				</div>
				<input type="text" hidden name="id" value="${requestScope.item.id}">
				<div class="form-group col-md-6">
					<label for="inputPassword4">Item Description</label> <input
						type="text" class="form-control" name="description"
						id="inputPassword4" placeholder="Item Description" value="${requestScope.item.description}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputAddress">Price</label> <input type="number"
						class="form-control" name="price" id="inputAddress"
						placeholder="Item Price" value="${requestScope.item.price}">
				</div>
				<div class="form-group col-md-6">
					<label for="inputAddress2">Quantity</label> <input type="number"
						class="form-control" name="quantity" id="inputAddress2"
						placeholder="Item Quantity" value="${requestScope.item.quantity}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">Image</label> <input type="text"
						name="image" class="form-control" id="inputCity" value="${requestScope.item.imageUrl}">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Category</label> <select id="inputState"
						class="form-control" name="category">
						<option selected value="${requestScope.item.category}">${requestScope.item.category eq null ? '--Select--' : requestScope.item.category}</option>
						<option value="Electronics">Electronics</option>
						<option value="Clothes">Clothes</option>
						<option value="Furniture">Furniture</option>
					</select>
				</div>
			</div>
			<input type="submit" class="btn btn-primary btn-block"
				value="${requestScope.item eq null ? 'Add Item' : 'Update Item'}" />
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
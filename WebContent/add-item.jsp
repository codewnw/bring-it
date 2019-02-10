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
		<h1 class="display-3">Add new Item</h1>
		<form action="items/save" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Item Name</label> <input type="text"
						class="form-control" name="name" id="inputEmail4"
						placeholder="Item Name">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Item Description</label> <input
						type="text" class="form-control" name="description"
						id="inputPassword4" placeholder="Item Description">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputAddress">Price</label> <input type="number"
						class="form-control" name="price" id="inputAddress"
						placeholder="Item Price">
				</div>
				<div class="form-group col-md-6">
					<label for="inputAddress2">Quantity</label> <input type="number"
						class="form-control" name="quantity" id="inputAddress2"
						placeholder="Item Quanity">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">Image</label> <input type="text"
						name="image" class="form-control" id="inputCity">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Category</label> <select id="inputState"
						class="form-control" name="category">
						<option selected value="">...Choose...</option>
						<option value="Electronics">Electronics</option>
						<option value="Clothes">Clothes</option>
						<option value="Furniture">Furniture</option>
					</select>
				</div>
			</div>
			<input type="submit" class="btn btn-primary btn-block"
				value="Add Item" />
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
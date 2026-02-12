<!DOCTYPE html>
<html>
<head>
<title>Add Retail Transaction</title>
</head>
<body>
	<h2>Add Retail Transaction</h2>

	<form action="MainServlet" method="post">
		<input type="hidden" name="operation" value="newRecord">

		Customer Name: <input type="text" name="customerName" required><br>
		<br> Product Name: <input type="text" name="productName" required><br>
		<br> Purchase Date: <input type="date" name="purchaseDate"
			required><br>
		<br> Quantity: <input type="number" name="quantity" required><br>
		<br> Price: <input type="number" step="0.01" name="price"
			required><br>
		<br> Remarks: <input type="text" name="remarks"><br>
		<br> <input type="submit" value="Add Transaction">
	</form>
</body>
</html>

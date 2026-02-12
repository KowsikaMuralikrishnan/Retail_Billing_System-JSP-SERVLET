<%@ page import="java.util.List"%>
<%@ page import="com.wipro.retail.bean.RetailBean"%>

<!DOCTYPE html>
<html>
<head>
<title>All Retail Transactions</title>
</head>
<body>

	<%
    List<RetailBean> list =
        (List<RetailBean>) request.getAttribute("retailList");
    String message = (String) request.getAttribute("message");

    if (list == null || list.isEmpty()) {
%>
	<h3><%= message %></h3>
	<%
    } else {
%>
	<h2>All Retail Transactions</h2>

	<table border="1">
		<tr>
			<th>Record ID</th>
			<th>Customer Name</th>
			<th>Product Name</th>
			<th>Purchase Date</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Remarks</th>
		</tr>

		<%
        for (RetailBean b : list) {
%>
		<tr>
			<td><%= b.getRecordId() %></td>
			<td><%= b.getCustomerName() %></td>
			<td><%= b.getProductName() %></td>
			<td><%= b.getPurchaseDate() %></td>
			<td><%= b.getQuantity() %></td>
			<td><%= b.getPrice() %></td>
			<td><%= b.getRemarks() %></td>
		</tr>
		<%
        }
%>
	</table>
	<%
    }
%>

	<br>
	<a href="menu.html">Back to Menu</a>

</body>
</html>

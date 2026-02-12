<%@ page import="com.wipro.retail.bean.RetailBean"%>

<!DOCTYPE html>
<html>
<head>
<title>Retail Transaction Details</title>
</head>
<body>

	<%
    RetailBean bean = (RetailBean) request.getAttribute("retailBean");
    String message = (String) request.getAttribute("message");

    if (bean == null) {
%>
	<h3><%= message %></h3>
	<%
    } else {
%>
	<h2>Retail Transaction Details</h2>

	Record ID:
	<%= bean.getRecordId() %><br> Customer Name:
	<%= bean.getCustomerName() %><br> Product Name:
	<%= bean.getProductName() %><br> Purchase Date:
	<%= bean.getPurchaseDate() %><br> Quantity:
	<%= bean.getQuantity() %><br> Price:
	<%= bean.getPrice() %><br> Remarks:
	<%= bean.getRemarks() %><br>
	<%
    }
%>

	<br>
	<a href="menu.html">Back to Menu</a>

</body>
</html>

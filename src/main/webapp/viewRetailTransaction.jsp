<!DOCTYPE html>
<html>
<head>
    <title>View Retail Transaction</title>
</head>
<body>
    <h2>View Retail Transaction</h2>

    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="viewRecord">

        Customer Name:
        <input type="text" name="customerName" required><br><br>

        Purchase Date:
        <input type="date" name="purchaseDate" required><br><br>

        <input type="submit" value="View Transaction">
    </form>
</body>
</html>

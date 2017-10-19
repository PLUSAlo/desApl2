<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Form</title>
</head>
<body>
		<form action="OrderController">
		
		<label>Customer Id:</label><br/>
		<input type="text" name="customerId" value="${order.customerId}"/><br/>
		<label>Ship Name:</label><br/>
		<input type="text" name="shipName" value="${order.shipName}"/><br/>
		<label>Ship Address :</label><br/>
		<input type="text" name="shipAddress" value="${order.shipAddress}"/><br/>
		<input type="submit" name="btn_save" value="Save"/>
	</form>

</body>
</html>
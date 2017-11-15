<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Form</title>
</head>
<body>
	<form action="ClientController">
	
		<label>Address:</label><br/>
		<input type="text" name="address" value="${client.address}"/><br/>
		<label>Phone:</label><br/>
		<input type="number" name="phone" value="${client.phone}"/><br/>
		<label>Cell Phone:</label><br/>
		<input type="number" name="cellphone" value="${client.cellphone}"/><br/>
		<label>Email:</label><br/>
		<input type="text" name="email" value="${client.email}"/><br/>
		<input type="submit" name="btn_save" value="Save"/>
	</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="OrderController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			</th>
			<th>Order Id</th>
			<th>Customer Id</th>
			<th>Ship Name</th>
			<th>Ship Address</th>
		</tr>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td>
					<form action="OrderController">
						<input type="hidden" name="id" value="${order.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${order.id}</td>
			<td>${order.customerId}</td>
			<td>${order.shipName}</td>
			<td>${order.shipAddress}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
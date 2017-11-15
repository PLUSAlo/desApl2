<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="ClientController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="ClientReport">Imprimir Lista</a>
			</th>
			<th>Id</th>
			<th>Address</th>
			<th>Phone</th>
			<th>CellPhone</th>
			<th>Email</th>
		</tr>
		<c:forEach var="client" items="${clients}">
			<tr>
				<td>
					<form action="ClientController">
						<input type="hidden" name="id" value="${client.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${client.id}</td>
			<td>${client.address}</td>
			<td>${client.phone}</td>
			<td>${client.cellphone}</td>
			<td>${client.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
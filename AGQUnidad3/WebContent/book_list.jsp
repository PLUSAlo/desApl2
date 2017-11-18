<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="BookController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="BookReport">Imprimir Lista</a>
			</th>
			<th>Id</th>
			<th>Title</th>
			<th>Author</th>
			<th>Editorial</th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>
					<form action="BookController">
						<input type="hidden" name="id" value="${book.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${book.id}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.editorial}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
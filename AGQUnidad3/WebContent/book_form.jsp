<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dog Form</title>
</head>
<body>
	<form action="BookController">
	
		<label>Title:</label><br/>
		<input type="text" name="title" value="${book.title}"/><br/>
		<label>Author:</label><br/>
		<input type="text" name="author" value="${book.author}"/><br/>
		<label>Editorial:</label><br/>
		<input type="text" name="editorial" value="${book.editorial}"/><br/>
		<input type="submit" name="btn_save" value="Save"/>
	</form>

</body>
</html>

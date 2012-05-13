<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Tarefa</title>
</head>
<body>
	<form action="${linkTo[CategoryController].insert}" method="post">
		<label for="category-name">Nome: </label>
		<input type="text" id="category-name" name="category.name" />
		
		<input type="hidden" name="project.id" value="${project.id}"/>

		<input type="submit" value="Inserir">
	</form>
</body>
</html>
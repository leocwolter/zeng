<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zeng - Nova Categoria</title>
        
        <!-- GENERIC STYLE -->
		<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"/>' />
		
		<!-- STRUCTURE STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/project.css"/>" />
    </head>
	<body>
		<form action="${linkTo[CategoryController].insert}" method="post" id="category_insert_form">
			<h1>Crie uma nova categoria</h1>
	        <br />
	        <br />
			<label for="category-name">Nome: </label>
			<input type="text" id="category_name_field" class="text" name="category.name" />
			<br />
	        <br />
			<input type="hidden" name="projectId" value="${projectId}"/>
			<input type="submit" id="category_insert_button" class="button" value="Inserir">
		</form>
	</body>
</html>
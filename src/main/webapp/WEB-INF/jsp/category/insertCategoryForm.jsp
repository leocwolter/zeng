<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zeng - Nova Categoria</title>
        <!-- CSS IMPORT -->
		<c:import url="/WEB-INF/imports/css-import.jsp" />
        <!-- STRUCTURE STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />
    </head>
    
	<body>
		<form action="${linkTo[CategoryController].insert}" method="POST" class="insert-form">
			<fieldset>
				<legend>Criar Categoria</legend>
				<br/>
				
				<label for="category-name">Nome: </label>
				<br/>
				<input type="text" name="category.name" />
				<br/>
				
				<input type="hidden" name="projectUrl" value="${projectUrl}"/>
				
				<input type="submit" class="button normal-button insert-category" value="Inserir">
			</fieldset>
		</form>
		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
		<!-- INSERT_FORM SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/insertForm.js" />"></script>
	</body>
</html>
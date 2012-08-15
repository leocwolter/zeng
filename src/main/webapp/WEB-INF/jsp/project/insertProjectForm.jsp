<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - Novo Projeto</title>

<c:import url="/WEB-INF/imports/script-css.jsp"/>

<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />

</head>
<body>
	<form action="${linkTo[ProjectController].insert}" method="POST" class="insert-form">
		<fieldset>
			<legend>Criar Projeto</legend>
			<br/>
			
			<label for="project-name">Nome: </label>
			<br/>
			<input type="text" id="project-name" name="project.name" />
			<br/>
		
			<label for="project-contributors">Colaboradores: </label>
			<br/>
			<input id="project-contributors[0]" type="text" name="contributors[0].email"/>
			<br/>
		
			<input type="submit" class="button insert-project" id="close_colorbox" value="Inserir">
		</fieldset>
	</form>
</body>
</html>
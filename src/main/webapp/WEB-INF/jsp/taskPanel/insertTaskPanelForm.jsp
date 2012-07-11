<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - Nova Lista de Tarefas</title>

<c:import url="/WEB-INF/imports/script-css.jsp"/>

<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />

</head>
<body>
	<form action="${linkTo[TaskPanelController].insert}" method="post" class="insert_form">
		<fieldset>
			<legend>Criar Lista de Tarefas </legend>
		
			<label for="taskPanel-name">Nome: </label>
			<input type="text" id="taskPanel-name" name="taskPanel.name" />
	
			<label for="taskPanel-category">Categoria: </label>
			<select id="taskPanel-category" name="categoryId">
				<c:forEach items="${project.categories}" var="category">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select><br/> 
	
			<input type="submit" class="button" value="Inserir">
		</fieldset>
	</form>
</body>
</html>
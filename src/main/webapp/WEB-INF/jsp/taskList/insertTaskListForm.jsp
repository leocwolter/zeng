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

<!-- INSERT_FORM SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/insert_form.js" />"></script>

</head>
<body>
	<form action="${linkTo[TaskListController].insert}" method="post" class="insert_form">
		<fieldset>
			<legend>Criar Lista de Tarefas </legend>
		
			<label for="taskList-name">Nome: </label>
			<input type="text" id="taskList-name" name="taskList.name" />
	
			<label for="taskList-category">Categoria: </label>
			<select id="taskList-category" name="categoryId">
				<c:forEach items="${project.categories}" var="category">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select><br/> 
	
			<input type="submit" class="button" id="close_colorbox" value="Inserir">
		</fieldset>
	</form>
</body>
</html>
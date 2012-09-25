<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - Nova Tarefa</title>
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />
</head>
<body>
	<form action="${linkTo[TaskController].insert}" method="POST" class="insert-form">
		<fieldset>
			<legend>Criar Tarefa</legend>
			<br/>
			
			<label for="task-name">Nome: </label>
			<br/>
			<input type="text" id="task-name" name="task.name" />
			<br/>
			
			<label for="task-description">Descrição: </label>
			<br/>
			<input type="text" id="task-description" name="task.description" />
			<br/>
		
			<label for="task-contributors">Colaboradores: </label>
			<br/>
			<c:forEach items="${taskList.projectContributors}" var="contributor" varStatus="i">
				<input id="task-contributors[${i.count}]" type="checkbox" value="${contributor.id}" name="contributors[${i.count}].id"/>
				<label for="task-contributors[${i.count}]">${contributor.name} </label>
				<br/> 
			</c:forEach>
		
			<label for="task-expirationDate">Data de expiração: </label>
			<br/>
			<input type="date" id="task-expirationDate" name="task.expirationDate" />
			<br/>
	
			<input type="hidden" name="taskListId" value="${taskList.id}"/>
	
			<input type="submit" class="insert-task button normal-button" value="Inserir">
		</fieldset>
	</form>
	<!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- INSERT_FORM SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/insertForm.js" />"></script>
</body>
</html>


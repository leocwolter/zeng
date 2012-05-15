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
	<form action="${linkTo[TaskController].insert}" method="post">
		<label for="task-name">Nome: </label>
		<input type="text" id="task-name" name="task.name" /><br/>
		
		<label for="task-description">Descrição: </label>
		<input type="text" id="task-description" name="task.description" /><br/>
	
		<label for="task-contributors">Colaboradores: </label><br/>
		<c:forEach items="${taskPanel.category.project.contributors}" var="contributor" varStatus="i">
			<input id="task-contributors[${i.count}]" type="checkbox" value="${contributor.id}" name="contributors[${i.count}].id"/>
			<label for="task-contributors[${i.count}]">${contributor.name} </label><br/> 
		</c:forEach>
	
		<label for="task-expirationDate">Data de expiração: </label>
		<input type="text" id="task-expirationDate" name="task.expirationDate" /><br/>

		<input type="hidden" name="taskPanel.id" value="${taskPanel.id}"/>

		<input type="submit" value="Inserir">
	</form>
</body>
</html>
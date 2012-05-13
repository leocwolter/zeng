<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Projeto - ${project.name}</title>
		<link rel="stylesheet" href='<c:url value="/css/listTaskPanels.css" />'>
	</head>
	<body>
		<c:forEach items="${project.categories}" var="category">
			<section class="category">
				<h1>${category.name}</h1>
				<c:forEach items="${category.taskPanels}" var="taskPanel">
					<section class="taskPanel">
						<h2 class="title-taskPanel">${taskPanel.name }</h2><br />
						<c:forEach items="${taskPanel.tasks }" var="task">
							<section class="task">
								${task.name }<br />
								<joda:format value="${task.expirationDate}" pattern="dd/MM/YY"/> <br />
								<c:forEach items="${task.contributors}" var="contributor">
									${contributor.name} / 					
								</c:forEach><br/>
								<a href="${linkTo[TaskController].showTask}${task.id}">Mais detalhes</a>
							</section>		
						</c:forEach>
						<a href="${linkTo[TaskController].insertTaskForm}${taskPanel.id}">Adicionar tarefa</a>
					</section>		
				</c:forEach>
				<a href="${linkTo[TaskPanelController].insertTaskPanelForm}${category.id}">Adicionar lista de tarefas</a>
			</section>
		</c:forEach>
		<a href="${linkTo[CategoryController].insertCategoryForm}${project.id}">Adicionar categoria</a>
	</body>
</html>
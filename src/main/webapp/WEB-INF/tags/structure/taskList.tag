<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="taskPanel" required="true" type="br.com.zeng.model.TaskPanel" %>

<section class="task_area">
	<h3>${taskPanel.name}</h3>
	<nav class="task_menu_bar">
		<ul class="task_menu">
	    	<li><a href="#" class="task_philter_selected">All</a></li>
	    	<li><a href="#">To do</a></li>
	        <li><a href="#">Doing</a></li>
	        <li><a href="#">Done</a></li>
	        <li><a href="#">Accepted</a></li>
	        <li><a href="#">Rejected</a></li>
	        <li><a href="#">Mine</a>
	    </ul>
	</nav>
	<section class="task_list">
		<c:forEach items="${taskPanel.tasks}" var="task">
			<div class="task_box">${task.name }</div>
			<section class="options-task">
				<c:if test="${task.state != 'DONE'}">
					<c:if test="${task.state != 'DOING'}">
					<a href="${linkTo[TaskController].start}${task.id}">Começar tarefa</a>/
					</c:if>
					<c:if test="${task.state != 'TODO'}">
					<a href="${linkTo[TaskController].stop}${task.id}">Devolver tarefa</a>/
					</c:if>
					<a href="${linkTo[TaskController].finalize}${task.id}">Finalizar tarefa</a>/
				</c:if>
			</section>
		</c:forEach>
	</section>
	<a class="add_task_button">+Add Task</a>
</section>
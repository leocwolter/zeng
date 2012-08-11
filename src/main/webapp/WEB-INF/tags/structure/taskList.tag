<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="taskList" required="true" type="br.com.zeng.model.TaskList" %>

<section class="task-area" id="task-area-${taskList.id}">
	<h3>${taskList.name}</h3>
	<nav class="task-menu-bar">
		<ul>
	    	<li><a class="task-filter task-filter-selected" rel="task-filter-nofilter" href="#" >All</a></li>
	    	<li><a class="task-filter" rel="task-filter-todo" href="#">To do</a></li>
	        <li><a class="task-filter" rel="task-filter-doing" href="#">Doing</a></li>
	        <li><a class="task-filter" rel="task-filter-done" href="#">Done</a></li>
	        <li><a class="task-filter" rel="task-filter-accepted" href="#">Accepted</a></li>
	        <li><a class="task-filter" rel="task-filter-rejected" href="#">Rejected</a></li>
	        <li><a class="task-filter" rel="task-filter-mine" href="#">Mine</a>
	    </ul>
	</nav>
	<ul class="task-list" id="task-list-${taskList.id}">
		<c:forEach items="${taskList.tasks}" var="task">
			<li class="task task-state-${task.state}" id="task-${task.id}">
				<section class="task-box">
					<h4>${task.name}</h4>
					<p>${task.description}</p>
					<div class="options-task">
						<c:if test="${task.state != 'DONE'}">
							<c:if test="${task.state != 'DOING'}">
								<a href="${linkTo[TaskController].start}${task.id}">Começar tarefa</a>/
							</c:if>
							<c:if test="${task.state != 'TODO'}">
								<a href="${linkTo[TaskController].stop}${task.id}">Devolver tarefa</a>/
							</c:if>
							<c:if test="${task.state == 'DOING'}" >
								<a href="${linkTo[TaskController].finalize}${task.id}">Finalizar tarefa</a>/
							</c:if>
						</c:if>
					</div>
				</section>
			</li>
		</c:forEach>
	</ul>
	<a class="add-task-button colorbox" href="${linkTo[TaskController].insertTaskForm}${taskList.id}">+Add Task</a>
</section>
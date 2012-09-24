<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="taskList" required="true" type="br.com.zeng.model.TaskList" %>

<section class="task-area" id="task-area-${taskList.id}">
	<h3>${taskList.name}</h3>
	
	<nav class="task-menu-bar">
		<ul>
	    	<li><a class="task-filter task-filter-selected" data-filter="nofilter" href="#" >All</a></li>
	    	<li><a class="task-filter" data-filter="todo" href="#">To do</a></li>
	        <li><a class="task-filter" data-filter="doing" href="#">Doing</a></li>
	        <li><a class="task-filter" data-filter="done" href="#">Done</a></li>
	        <li><a class="task-filter" data-filter="mine" href="#">Mine</a>
	    </ul>
	</nav>
	<ul class="task-list" data-tasklist-id="${taskList.id}">
		<c:forEach items="${taskList.tasks}" var="task">
			<li class="task task-state-${task.state}" data-task-id="${task.id}">
					<h4 class="task-name">${task.name}</h4>
					<ul class="task-contributors">
						<c:forEach items="${task.contributors}" var="contributor">
							<li>${contributor.name};</li>
						</c:forEach>
					</ul>
					
					<div class="task-options">
						<c:if test="${task.state != 'DONE'}">
							<c:if test="${task.state != 'DOING'}">
								<a href="${linkTo[TaskController].start}" class="button">Start Task</a>
							</c:if>
							<c:if test="${task.state != 'TODO'}">
								<a href="${linkTo[TaskController].stop}" class="button">Give Up</a>
							</c:if>
							<c:if test="${task.state == 'DOING'}" >
								<a href="${linkTo[TaskController].finalize}" class="button">End task</a>
							</c:if>
						</c:if>
					</div>
			</li>
		</c:forEach>
	</ul>
	<a class="add-task-button modal" href="${linkTo[TaskController].insertTaskForm}${taskList.id}">+Add Task</a>
</section>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="task" required="true" type="br.com.zeng.model.Task" %>
<li class="task task-state-${task.state}" data-task-id="${task.id}">
	<a href="${linkTo[TaskController].archive}" class="button remove-button archive-task" >X</a>
	<h4 class="task-name">${task.name}</h4>
	<ul class="task-contributors">
		<c:forEach items="${task.contributors}" var="contributor">
			<li>${contributor.name};</li>
		</c:forEach>
	</ul>
	<div class="task-options">
		<c:if test="${task.state != 'DONE'}">
			<c:if test="${task.state != 'DOING'}">
				<a href="${linkTo[TaskController].start}" class="button normal-button">Start Task</a>
			</c:if>
			<c:if test="${task.state != 'TODO'}">
				<a href="${linkTo[TaskController].stop}" class="button normal-button">Give Up</a>
			</c:if>
			<c:if test="${task.state == 'DOING'}" >
				<a href="${linkTo[TaskController].finalize}" class="button normal-button">End task</a>
			</c:if>
		</c:if>
	</div>
</li>
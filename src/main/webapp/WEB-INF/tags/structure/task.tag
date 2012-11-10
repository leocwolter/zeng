<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ attribute name="task" required="true" type="br.com.zeng.model.Task" %>
<li class="task task-state-${task.state}" data-task-id="${task.id}" style="height: auto;">
	<a href="${linkTo[TaskController].archive[task.id]}" class="button remove-button archive-task" >X</a>
	<h4 class="task-name">${task.name}</h4>
	<p class="task-description">${task.description}</p>
	<ul class="task-contributors">
		<c:forEach items="${task.contributors}" var="contributor">
			<li>${contributor.name};</li>
		</c:forEach>
	</ul>
	<c:if test="${task.expirationDate != null}">
		<c:if test="${task.closeToExpiring}">
			<p class="task-expiration-date close-to-expiring-task">Expiration Date: <joda:format value="${task.expirationDate}" pattern="d/M/Y" /></p>
		</c:if>
		<c:if test="${task.expired}">
			<p class="task-expiration-date expired-task">Expiration Date: <joda:format value="${task.expirationDate}" pattern="d/M/Y" /></p>
		</c:if>
		<c:if test="${!task.expired && !task.closeToExpiring}">
			<p class="task-expiration-date valid-task">Expiration Date: <joda:format value="${task.expirationDate}" pattern="d/M/Y" /></p>
		</c:if>
	</c:if>
	<div class="task-options">
		<c:if test="${task.state != 'DONE'}">
			<c:if test="${task.state != 'DOING'}">
				<a href="${linkTo[TaskController].start[task.id]}" class="button normal-button">Start Task</a>
			</c:if>
			<c:if test="${task.state != 'TODO'}">
				<a href="${linkTo[TaskController].stop[task.id]}" class="button normal-button">Give Up</a>
			</c:if>
			<c:if test="${task.state == 'DOING'}" >
				<a href="${linkTo[TaskController].finalize[task.id]}" class="button normal-button">End task</a>
			</c:if>
		</c:if>
	</div>
</li>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<%@ attribute name="taskList" required="true" type="br.com.zeng.model.TaskList" %>

<section class="task-area">
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
			<zeng-structure:task task="${task}"/>
		</c:forEach>
	</ul>
	<a class="add-button add-task-button modal" href="${linkTo[TaskController].insertTaskForm[taskList.id]}">+Add Task</a>
</section>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/structure" prefix="zeng-structure" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="category" required="true" type="br.com.zeng.model.Category" %>

<section class="category">
	<header class="category-header">
		<h2 class="title category-title">${category.name}</h2>
		<a href="${linkTo[TaskListController].insertTaskListForm[category.url]}"
					title="Adicionar Lista" id="new-task-list" class="button add-button modal">+</a>
	</header>
	<c:forEach items="${category.taskLists}" var="taskList">
		<zeng-structure:taskList taskList="${taskList}"/>
	</c:forEach>
</section>
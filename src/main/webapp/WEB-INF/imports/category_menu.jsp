<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu-bar" class="resizable">
	<h1>${project.name}</h1>
	<ul id="menu">
		<c:forEach items="${project.categories}" var="category">
			<li><a href="#"
				title="Categoria ${category.id}" class="category-button">${category.name}</a></li>
		</c:forEach>
	</ul>
	<section id="menu-bar-buttons">
		<a href="${linkTo[CategoryController].insertCategoryForm}${project.url}"
			id="new-category" title="Adicionar Categoria" class="button colorbox">Add category</a>
		<a href="${linkTo[TaskListController].insertTaskListForm}${project.url}"
			title="Adicionar Lista" id="new-task-list" class="button colorbox">Add 
			List</a>
	</section>
</nav>

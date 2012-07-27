<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu_bar" class="resizeble">
	<h1>${project.name}</h1>
	<ul id="menu">
		<c:forEach items="${project.categories}" var="category">
			<li><a href="#"
				title="Categoria ${category.id}" class="category_button">${category.name}</a></li>
		</c:forEach>
	</ul>
	<section id="menu_bar_buttons">
		<a href="${linkTo[CategoryController].insertCategoryForm}${project.url}"
			id="new_category" title="Adicionar Categoria" class="button colorbox">Adicionar categoria</a>
		<a href="${linkTo[TaskListController].insertTaskListForm}${project.url}"
			title="Adicionar Lista" id="new_task_list" class="button colorbox">Adicionar 
			Lista</a>
	</section>
</nav>

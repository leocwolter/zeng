<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu_bar" class="resizeble">
	<h1>${project.name}</h1>
	<ul id="menu">
		<c:forEach items="${project.categories}" var="category">
			<li><a href="#category_${category.id}"
				title="Categoria ${category.id}" id="category_selected">${category.name}</a></li>
		</c:forEach>
	</ul>
	<section id="menu_bar_buttons">
		<a	href="${linkTo[CategoryController].insertCategoryForm}${project.id}"
			id="new_category" title="Adicionar Categoria" class="button colorbox">Adicionar categoria</a>
		<a	href="${linkTo[TaskListController].insertTaskListForm}${project.id}"
			title="Adicionar Lista" id="new_task_list" class="button colorbox">+ Nova
			Lista</a>
	</section>
</nav>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu-bar" class="container resizable">
	<h1 id="project-name" data-projectid="${project.id}"><a href="${linkTo[ProjectController].showProject}${project.url}">${project.name}</a></h1>
	<ul id="menu">
		<c:forEach items="${project.categories}" var="category">
			<li><a href="${linkTo[CategoryController].showCategory[category.url]}" title="Categoria - ${category.name}" class="category-button">${category.name}</a></li>
		</c:forEach>
	</ul>
	<section id="menu-bar-buttons">
		<a href="${linkTo[CategoryController].insertCategoryForm[project.url]}"
			id="new-category" title="Adicionar Categoria" class="button normal-button modal">Add category</a>
	</section>
</nav>
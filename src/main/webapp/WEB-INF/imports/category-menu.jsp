<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<nav id="menu-bar" class="container resizable">
	<h1 id="project-name" data-projectid="${project.id}"><a href="${linkTo[ProjectController].showProject}${project.url}">${project.name}</a></h1>
	<ul id="menu">
		<c:forEach items="${project.categories}" var="category" begin="0" end="3">
			<li><a href="${linkTo[CategoryController].showCategory[category.url][project.url]}" title="Categoria - ${category.name}" class="category-button">${category.name}</a></li>
		</c:forEach>
		<c:if test="${fn:length(project.categories) > 4}">
			<li class="top-menu-dropdown">
				<div class="dropdown arrow" data-target="other-categories"></div>
				<ul class="dropdown-target other-itens" id="other-categories">
					<c:forEach items="${project.categories}" var="category" begin="4">
						<li><a href="${linkTo[CategoryController].showCategory[category.url][project.url]}" title="Categoria - ${category.name}" class="category-button">${category.name}</a></li>
					</c:forEach>
				</ul>
			</li>
		</c:if>
	</ul>
	<section id="menu-bar-buttons">
		<a href="${linkTo[CategoryController].insertCategoryForm[project.url]}"
			id="new-category" title="Adicionar Categoria" class="button normal-button modal">Add category</a>
	</section>
</nav>
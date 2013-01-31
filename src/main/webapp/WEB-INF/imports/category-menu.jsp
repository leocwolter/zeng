<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<nav class="main-menu-bar">
	<div class="resizable container">
		<h2 class="title" data-projectid="${project.id}"><a href="${linkTo[ProjectController].showProject}${project.url}">${project.name}</a></h2>
		<ul class="menu">
			<c:forEach items="${project.categories}" var="category" begin="0" end="3">
				<li class="menu-item"><a href="${linkTo[CategoryController].showCategory[category.url][project.url]}" title="Categoria - ${category.name}" class="button menu-button">${category.name}</a></li>
			</c:forEach>
			<c:if test="${fn:length(project.categories) > 4}">
				<li class="top-menu-dropdown">
					<div class="dropdown arrow" data-target="other-categories">
						<ul class="dropdown-target other-categories">
							<c:forEach items="${project.categories}" var="category" begin="4">
								<li class="menu-item"><a href="${linkTo[CategoryController].showCategory[category.url][project.url]}" title="Categoria - ${category.name}" class="button menu-button">${category.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
			</c:if>
		</ul>
		<div class="new-item">
			<a  href="${linkTo[CategoryController].insertCategoryForm[project.url]}" title="Adicionar Categoria" class="add-category button normal-button modal">Add category</a>
		</div>
	</div>
</nav>
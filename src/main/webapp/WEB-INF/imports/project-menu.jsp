<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="main-menu-bar resizable">
	<div class="container resizable">
		<h1 class="title menu-title">My projects:</h1>
		<ul class="menu ">
			<c:forEach items="${projects}" var="project">
				<li><a href="${linkTo[ProjectController].showProject}${project.url}" title="Project ${project.id}">${project.name}</a></li>
			</c:forEach>
		</ul>
		<a	href="${linkTo[ProjectController].insertProjectForm}${project.id}" title="Insert Project" class="button normal-button modal insert-project-button">Insert Project</a>
	</div>
</nav>
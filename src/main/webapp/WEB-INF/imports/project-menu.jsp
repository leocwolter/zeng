<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu-bar" class="resizable">
	<h1>My projects:</h1>
	<ul id="menu">
		<c:forEach items="${projects}" var="project">
			<li><a href="${linkTo[ProjectController].showProject}${project.url}"	title="Project ${project.id}">${project.name}</a></li>
		</c:forEach>
	</ul>
	<section id="menu-bar-buttons">
		<a	href="${linkTo[ProjectController].insertProjectForm}${project.id}" title="Insert Project" class="button normal-button modal">Insert Project</a>
	</section>
</nav>
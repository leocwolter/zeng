<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section id="top" class="resizable">
	<a href="${linkTo[ProjectController].listProjects}" id="small-logo">Zeng</a>
	<form action="${linkTo[TaskController].searchTasksWithContent}${project.url}" method="get" id="search-form">
		<input type="search" name="q" placeholder="Search" />
		<input type="submit" value="SEARCH" />
	</form>
	<a href="${linkTo[UserController].logOut}" class="user-logout">Logout</a>
	<a href="${linkTo[ProjectController].listProjects}" title="${userSession.user.name}" data-user-name="${userSession.user.name}" id="user-name-link">
		${userSession.user.name} </a>
	<a href="#" title="Atualization" id="atualization-icon">&nbsp;</a>
	<a href="#" title="Menssages" id="message-icon">&nbsp;</a>
</section>
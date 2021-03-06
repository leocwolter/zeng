<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="top" class="container resizable">
	<a href="${linkTo[ProjectController].listProjects}" id="small-logo">Zeng</a>
	<c:if test="${project != null }">
		<form action="${linkTo[ProjectController].searchTasksWithContent}${project.url}" method="get" id="search-form">
			<input type="search" name="q" placeholder="Search" />
			<input type="submit" value="SEARCH" />
		</form>
	</c:if>
	<section id="user-box">
		<a href="${linkTo[ProjectController].listProjects}" title="${userSession.user.name}" data-user-name="${userSession.user.name}" id="user-name-link">
			${userSession.user.name} </a>
		<div class="arrow dropdown" data-target="user-menu">
			<ul class="dropdown-target" id="user-menu">
				<li><a href="${linkTo[UserController].profile[userSession.user.id]}">Profile</a></li>
				<li><a href="${linkTo[UserController].editForm}" class="modal">Edit</a></li>
				<li><a href="${linkTo[UserController].logOut}">Logout</a></li>
			</ul>
		</div>
	</section>
	<!-- <a href="#" title="Atualization" id="atualization-icon">&nbsp;</a>
	<a href="#" title="Menssages" id="message-icon">&nbsp;</a> -->
</div>
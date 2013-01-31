<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="top">
	<div class="container resizable">
		<a href="${linkTo[ProjectController].listProjects}" class="small-logo">Zeng</a>
		<c:if test="${project != null }">
			<form action="${linkTo[ProjectController].searchTasksWithContent}${project.url}" method="get" class="search-form">
				<input type="search" name="q" class="field" placeholder="Search" />
				<input class="button normal-button" type="submit" value="SEARCH" />
			</form>
		</c:if>
		<section class="user">
			<a href="${linkTo[ProjectController].listProjects}" title="${userSession.user.name}" data-user-name="${userSession.user.name}" class="user-name">
				${userSession.user.name} </a>
			<div class="arrow dropdown" data-target="user-menu">
				<ul class="dropdown-target  menu">
					<li><a class="dropdown-item" href="${linkTo[UserController].profile[userSession.user.id]}">Profile</a></li>
					<li><a class="dropdown-item" href="${linkTo[UserController].editForm}" class="modal">Edit</a></li>
					<li><a class="dropdown-item" href="${linkTo[UserController].logOut}">Logout</a></li>
				</ul>
			</div>
		</section>
	</div>
</header>
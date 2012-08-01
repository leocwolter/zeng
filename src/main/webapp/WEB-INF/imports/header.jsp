<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="resizeble">
	<a href="${linkTo[ProjectController].listProjects}" id="small-logo">Zeng</a>
	<form action="search.jsp" method="get" id="search-form">
		<input type="search" name="q"/>
		<input type="submit" value="BUSCAR" />
	</form>
	<a href="${linkTo[ProjectController].listProjects}" title="${userSession.user.name}" id="user-name-link">
		${userSession.user.name} </a>
	<a href="#" title="Atualization" id="atualization-icon">&nbsp;</a>
	<a href="#" title="Menssages" id="message-icon">&nbsp;</a>
</header>
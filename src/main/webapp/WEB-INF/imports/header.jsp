<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="resizeble">
	<a href="home.html" id="small_logo"></a>
	<form action="search.jsp" method="get" id="search_form">
		<input type="text" name="search_field" id="search_field" class="text" />
		<input type="submit" id="search_button" value="BUSCAR" />
	</form>
	<a href="#" title="${userSession.user.name}" id="user_name_link">
		${userSession.user.name} </a> <a href="#" title="Atualization"
		id="atualization_icon">&nbsp;</a> <a href="#" title="Menssages"
		id="message_icon">&nbsp;</a>
</header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/messages" prefix="zeng-messages" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Profile - Edit</title>
		<!-- NOT LOGGED STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/not-logged-page.css"/>" />
		<!-- CSS IMPORT -->
		<c:import url="/WEB-INF/imports/css-import.jsp" />
		<!-- STRUCTURE STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />
	</head>
	<body>
		<form id="edit-user-form" class="insert-form" action="${linkTo[UserController].edit}" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>Profile - Edit</legend>
					<br/>
					<zeng-messages:error/>
					<zeng-messages:confirmation/>
				
					<label for="user-photo">Foto:</label>
					<br/>
					<input type="file" name="userPhoto" id="user-photo"/>
					<br/>
					<label for="name">Name:</label>
					<br/>
					<input id="name" name="editedUser.name" type="text" value="${userSession.user.name}" />
					<br/>
					<label for="email">Email:</label>
					<br/>
					<input id="email" name="editedUser.email" type="email" value="${userSession.user.email}" />
					<br/>
					<label for="password">Password:</label>
					<br/>
					<input id="password" name="editedUser.password" type="password" />
					<br/>
					<label for="confirm-password">Confirm password:</label>
					<br/>
					<input id="confirm-password" name="editedUser.confirmPassword" type="password" />
					<br/>
					<input type="submit" class="button normal-button" value="Atualizar"/>
				
			</fieldset>
		</form>
		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
		<!-- VALIDATE SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/jquery.validate.js" />"></script>
		<!-- HOME FORMS VALIDATE SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/home.js" />"></script>
	</body>
</html>
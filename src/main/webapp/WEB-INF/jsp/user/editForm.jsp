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
		<!-- FORM STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>" />
		<!-- CSS IMPORT -->
		<c:import url="/WEB-INF/imports/css-import.jsp" />
	</head>
	<body>
		<h2>Profile - Edit</h2>
		<form id="edit-user-form" class="user-form" action="${linkTo[UserController].edit}" method="post" enctype="multipart/form-data">
			<fieldset>
				<zeng-messages:error/>
				<zeng-messages:confirmation/>
				<p>
					<label for="user-photo">Foto:</label>
					<input type="file" name="userPhoto" id="user-photo"/>
				</p>
				<p>
					<label for="name">Name:</label>
					<input id="name" name="editedUser.name" type="text" class="text" value="${userSession.user.name}" />
				</p>
				<p>
					<label for="email">Email:</label>
					<input id="email" name="editedUser.email" type="email" class="text" value="${userSession.user.email}" />
				</p>
				<p>
					<label for="password">Password:</label>
					<input id="password" name="editedUser.password" class="text" type="password" />
				</p>
				<p>
					<label for="confirm-password">Confirm password:</label>
					<input id="confirm-password" name="editedUser.confirmPassword" class="text" type="password" />
				</p>
				<p>
					<input type="submit" class="button normal-button" value="Atualizar"/>
				</p>
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
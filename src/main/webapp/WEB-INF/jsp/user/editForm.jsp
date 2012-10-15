<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/messages" prefix="zeng-messages" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de usuário</title>
		<!-- NOT LOGGED STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/not-logged-page.css"/>" />
		<!-- FORM STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>" />
		<!-- CSS IMPORT -->
		<c:import url="/WEB-INF/imports/css-import.jsp" />
	</head>
	<body>
		<form method="POST" action='${linkTo[UserController].edit}' class="user-form" enctype="multipart/form-data">
			<fieldset>
				<zeng-messages:error/>
				<zeng-messages:confirmation/>
				<label for="user-photo">Foto:	</label>
				<input type="file" name="userPhoto" id="user-photo"/>
				<input type="submit" value="Atualizar"/>
			</fieldset>
		</form>
		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
	</body>
</html>
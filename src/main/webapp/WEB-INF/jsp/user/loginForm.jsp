<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/messages" prefix="zeng-messages" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Efetue login</title>
	</head>
	<body>
		<form method="POST" action='${linkTo[UserController].logIn}'>
			<zeng-messages:error/>
			<fieldset>
				<legend>Login</legend>
				<label for="user-email">Email:	</label>
				<input type="text" name="user.email" id="user-email" />
				<label for="user-password">Senha:	</label>
				<input type="password" name="user.password" id="user-password"/>
				<input type="submit" value="logar"/>
			</fieldset>
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/messages" prefix="zeng-messages" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de usuário</title>
	</head>
	<body>
		<form method="POST" action='${linkTo[UserController].register}'>
			<zeng-messages:error/>
			<fieldset>
				<legend>Cadastro</legend>
				<label for="user-email">Email:	</label>
				<input type="text" name="user.email" id="user-email" />
				<label for="user-name">Nome:	</label>
				<input type="text" name="user.name" id="user-name" />
				<label for="user-password">Senha:	</label>
				<input type="password" name="user.password" id="user-password"/>
				<input type="submit" value="cadastrar"/>
			</fieldset>
		</form>
	</body>
</html>
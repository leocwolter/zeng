<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/messages" prefix="zeng-messages" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de usuário</title>
		<!-- FORM STYLE -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>" />
		<!-- CSS IMPORT -->
		<c:import url="/WEB-INF/imports/css-import.jsp" />
	</head>
	<body>
		<section id="container">
			<header id="top" class="header resizable">
				<a href="${linkTo[ProjectController].listProjects}" id="small-logo">Zeng</a>
				<form action="${linkTo[UserController].logIn}" method="post" id="login-form">
					<input type="email" name="user.email" placeholder="email@zeng.com" autofocus="autofocus" />
					<input type="password" name="user.password" placeholder="Password" />
					<input type="submit" value="Login" class="button normal-button" />
				</form>
			</header>
			<section id="home-content" class="content">
				<form method="POST" action='${linkTo[UserController].edit}' class="user-form" enctype="multipart/form-data">
					<zeng-messages:error/>
					<zeng-messages:confirmation/>
					<fieldset>
						<label for="user-photo">Foto:	</label>
						<input type="file" name="userPhoto" id="user-photo"/>
						<input type="submit" value="Atualizar"/>
					</fieldset>
				</form>
			</section>
			<c:import url="/WEB-INF/imports/footer.jsp" />
		</section>
		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
		<!-- HEADER MARGIN SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/header.js" />"></script>
	</body>
</html>
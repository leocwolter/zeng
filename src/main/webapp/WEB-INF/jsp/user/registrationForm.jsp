<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - Project management</title>
<!-- HOME STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>" />
<!-- PROJECT STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/project.css"/>" />
<!-- FORM STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>" />
<!-- COLORBOX STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/colorbox.css"/>" />
</head>
<body>
	<section id="container">
		<header id="top">
			<a href="${linkTo[ProjectController].listProjects}" id="small-logo">Zeng</a>
			<form action="${linkTo[UserController].logIn}" method="post" id="login-form">
				<input type="email" name="user.email" placeholder="email@zeng.com" autofocus="autofocus" />
				<input type="password" name="user.password" placeholder="Password" />
				<input type="submit" value="Login" class="button" />
			</form>
		</header>
		<section id="home-content" class="content">
			<zeng-messages:error/>
			<form id="register-user-form" action="${linkTo[UserController].register}" method="post">
				<h1>Sign up for FREE</h1>
				<fieldset>
					<zeng-messages:error/>
					<p>
						<label for="name">Name:</label>
						<input id="name" name="user.name" type="text" class="text" value="" />
					</p>
					<p>
						<label for="email">Email:</label>
						<input id="email" name="user.email" type="email" class="text" value="" />
					</p>
					<p>
						<label for="password">Password:</label>
						<input id="password" name="user.password" class="text" type="password" />
					</p>
					<p>
						<label for="confirm-password">Confirm password:</label>
						<input id="confirm-password" name="user.confirmPassword" class="text" type="password" />
					</p>
					<p id="terms-paragraph">
						<input type="checkbox" name="terms" />
						<label for="terms">
							I agree to the <a href="">Terms and Conditions</a> and <a href="">Privacy Policy</a>
						</label>
						<label for="terms" generated="true" class="error"></label>
					</p>
					<p>
						<input id="register-button" class="button" type="submit" value="REGISTER" />
					</p>
				</fieldset>
 			</form>
		</section>
		<c:import url="/WEB-INF/imports/footer.jsp"/>
	</section>
	<c:import url="/WEB-INF/imports/script-css.jsp"/>
	<!-- JQUERY COLORBOX -->
	<script type="text/javascript" src="<c:url value="/js/jquery.colorbox-min.js" />"></script>
	<!-- SCREEN SIZE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>
	<!-- CATEGORY SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/category.js" />"></script>
	<!-- TASK SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/task.js" />"></script>
	<!-- VALIDATE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js" />"></script>
	<!-- HOME FORMS VALIDATE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/home.js" />"></script>
</body>
</html>
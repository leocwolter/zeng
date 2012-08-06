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
<c:import url="/WEB-INF/imports/script-css.jsp"/>
<!-- JQUERY COLORBOX -->
<script type="text/javascript" src="<c:url value="/js/jquery.colorbox-min.js" />"></script>
<!-- SCREEN SIZE SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>
<!-- CATEGORY SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/category.js" />"></script>
<!-- TASK SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/task.js" />"></script>
</head>
<body>
	<section id="container">
		<header id="top">
			<a href="${linkTo[ProjectController].listProjects}" id="small-logo">Zeng</a>
			<form action="${linkTo[UserController].logIn}" method="post" id="login-form">
				<zeng-messages:error/>
				<input type="email" name="user.email" placeholder="email@zeng.com" />
				<input type="password" name="user.password" placeholder="Password" />
				<input type="submit" value="Login" class="button" />
			</form>
		</header>
		<section id="home-content" class="content">
			<form id="register-user-form" action="" method="post">
				<h1>Sign up</h1>
				<fieldset>
					<p>
						<label for="name">Name:</label>
						<input id="name" name="name" type="text" class="text" value="" />
					</p>
					<p>
						<label for="email">Email:</label>
						<input id="email" name="email" type="email" class="text" value="" />
					</p>
					<p>
						<label for="password">Password:</label>
						<input id="password" name="password" class="text" type="password" />
					</p>
					<p>
						<label for="password">Confirm password:</label>
						<input id="password" name="password" class="text" type="password" />
					</p>
					<p id="terms-paragraph">
						<input type="checkbox" name="terms" />
						<label for="acceptTerms">
							I agree to the <a href="">Terms and Conditions</a> and <a href="">Privacy Policy</a>
						</label>
					</p>
					<p>
						<input id="register-button" class="button" type="submit" value="REGISTER" />
					</p>
				</fieldset>
 			</form>
		</section>
		<c:import url="/WEB-INF/imports/footer.jsp"/>
     </section>
</body>
</html>
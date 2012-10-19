<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages"%>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<title>Zeng - Project management</title>
	<!-- NOT LOGGED STYLE -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/not-logged-page.css"/>" />
	<!-- FORM STYLE -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>" />
	<!-- CSS IMPORT -->
	<c:import url="/WEB-INF/imports/css-import.jsp" />
</head>
<body>
	<section id="container">
		<c:import url="/WEB-INF/imports/not-logged-header.jsp"></c:import>
		<section id="home-content" class="content container">
			<zeng-messages:error />
			<form id="register-user-form" class="user-form" action="${linkTo[UserController].register}" method="post">
				<h1>Sign up for FREE</h1>
				<fieldset>
					<p>
						<label for="name">Name:</label>
						<input id="name" name="user.name" type="text" class="text" value="" />
					</p>
					<p>
						<label for="email">Email:</label>
						<input id="email" name="user.email" type="email" class="text" value="" />
					</p>
					<p>
						<label for="cpf">Cpf:</label>
						<input id="cpf" name="user.cpf" type="text" class="text" value="" />
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
						<input type="checkbox" name="terms" checked="checked" />
						<label for="terms">
							I agree to the <a href="">Terms and Conditions</a> and <a href="">Privacy Policy</a>
						</label>
						<label for="terms" generated="true" class="error" style="display: none;"></label>
					</p>
						<img id="captcha" src="<c:url value="/simpleCaptcha.jpg" />" width="150">
						<label for="captcha-answer">Digit the text above:</label>
						<input type="text" id="captcha-answer" name="captchaAnswer" />
					<p>
						<input id="register-button" class="button normal-button" type="submit" value="REGISTER" />
					</p>
				</fieldset>
 			</form>
		</section>
		<c:import url="/WEB-INF/imports/footer.jsp" />
	</section>
	<!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- VALIDATE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js" />"></script>
	<!-- SCREEN SIZE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>
	<!-- HOME FORMS VALIDATE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/home.js" />"></script>
	<!-- HEADER MARGIN SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/header.js" />"></script>

</body>
</html>
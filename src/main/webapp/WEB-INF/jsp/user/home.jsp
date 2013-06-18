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
	<!-- CSS IMPORT -->
	<c:import url="/WEB-INF/imports/css-import.jsp" />
</head>
<body>
	<section class="home-content">
		<c:import url="/WEB-INF/imports/not-logged-header.jsp"></c:import>
		<section class="content container">
			<zeng-messages:error />
			<form class="user-form" action="${linkTo[UserController].register}" method="post">
				<h2 class="user-form-title">Sign up for FREE</h2>
				<label for="name">Name:</label>
				<input id="name" name="user.name" type="text" class="input-text" value="" />

				<label for="email">Email:</label>
				<input id="email" name="user.email" type="email" class="input-text" value="" />

				<label for="password">Password:</label>
				<input id="password" name="user.password" class="input-text" type="password" />

				<label for="confirm-password">Confirm password:</label>
				<input id="confirm-password" name="user.confirmPassword" class="input-text" type="password" />

				<input type="checkbox" name="terms" checked="checked" class="terms" />
				<label for="terms" class="terms-label terms">I agree to the <a href="">Terms and Conditions</a> and <a href="">Privacy Policy</a></label>

				<input id="register-button" class="button normal-button" type="submit" value="REGISTER" />
 			</form>
		</section>
		<c:import url="/WEB-INF/imports/footer.jsp" />
	</section>
	
	<!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- SCREEN SIZE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>
	<!-- HOME FORMS VALIDATE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/home.js" />"></script>

</body>
</html>
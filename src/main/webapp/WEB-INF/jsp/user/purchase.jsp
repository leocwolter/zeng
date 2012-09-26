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
<!-- HOME STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/purchase.css"/>" />
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
			<zeng-messages:error />
			<ol class="hlisting offer-sale plans">
				<li class="option" id="bronze">
					<h4 class="fn">Basic <span class="price">£3.99 ($6 US)</span></h4>
					<ul class="description">
						<li><strong>15</strong> active clients</li>
						<li><strong>Unlimited</strong> invoices per month</li>
						<li><strong>Unlimited</strong> staff logins</li>
						<li><strong>Free</strong> upgrades</li>
						<li><strong>RapidSSL Certificate</strong></li>
					</ul>
					<p>Unlimited telephone & email support</p>
					<p>
						<a href="#" class="button">Sign up<span>30 day free trial</span></a>
					</p>
				</li>
				<li class="option" id="silver"></li>
				<li class="option" id="gold"></li>
				<li class="option" id="platinium"></li>
			</ol>
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
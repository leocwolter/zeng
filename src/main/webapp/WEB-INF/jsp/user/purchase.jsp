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
			<h1 id="purchase-title">Purchase Plans</h1>
			<ol class="offer-sale plans container">
				<li class="option" id="bronze-option">
					<h2 class="plan-title" id="bronze-title">Bronze Plan</h2>
					<ul class="plan-description">
						<li><strong>15</strong> active clients</li>
						<li><strong>Unlimited</strong> invoices per month</li>
						<li><strong>Unlimited</strong> staff logins</li>
						<li><strong>Free</strong> upgrades</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
				<li class="option" id="silver-option">
					<h2 class="plan-title" id="silver-title">Silver Plan</h2>
					<ul class="plan-description">
						<li><strong>15</strong> active clients</li>
						<li><strong>Unlimited</strong> invoices per month</li>
						<li><strong>Unlimited</strong> staff logins</li>
						<li><strong>Free</strong> upgrades</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
				<li class="option" id="gold-option">
					<h2 class="plan-title" id="gold-title">Gold Plan</h2>
					<ul class="plan-description">
						<li><strong>15</strong> active clients</li>
						<li><strong>Unlimited</strong> invoices per month</li>
						<li><strong>Unlimited</strong> staff logins</li>
						<li><strong>Free</strong> upgrades</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
				<li class="option" id="platinum-option">
					<h2 class="plan-title" id="platinum-title">Platinum Plan</h2>
					<ul class="plan-description">
						<li><strong>15</strong> active clients</li>
						<li><strong>Unlimited</strong> invoices per month</li>
						<li><strong>Unlimited</strong> staff logins</li>
						<li><strong>Free</strong> upgrades</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
			</ol>
			<br class="clear-fix" />
			<section class="button normal-button" id="extension-button">Extension Plan + More 25GB of Storage</section>
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
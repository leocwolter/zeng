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
			<form action="login.jsp" method="post" id="login-form">
				<input type="email" name="email" placeholder="email@zeng.com" />
				<input type="password" name="senha" placeholder="Senha" />
				<input type="submit" value="Login" class="button" />
			</form>
		</header>
		<section id="home-content" class="content">
			
		</section>
		<c:import url="/WEB-INF/imports/footer.jsp"/>
     </section>
</body>
</html>
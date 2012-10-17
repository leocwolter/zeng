<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projetos</title>
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
</head>
<body>
	<section id="container">
    	<section id="left-container">
    		<header class="header">
				<c:import url="/WEB-INF/imports/header.jsp"/>
			</header>
            <section class="container content">
				<div class="personal-info">
					<img src='<c:url value="/img/users_images/${user.photo}"/>' alt="${user.name}" height="100" width="100" />
					<p>${user.name}</p>
					<p>${user.email}</p>
				</div>
			</section>
			<c:import url="/WEB-INF/imports/footer.jsp"/>
        </section>
       </section>
    <!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- GENERIC MODAL SCRIPT - BIND -->
	<script type="text/javascript" src="<c:url value="/js/generic.js" />"></script>
	<!-- HEADER MARGIN SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/header.js" />"></script>
</body>
</html>
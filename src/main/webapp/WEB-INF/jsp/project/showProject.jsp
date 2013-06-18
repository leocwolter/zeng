<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Zeng - ${project.name}</title>
<!-- PROJECT STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/showProject.css"/>" />
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
</head>
	<body>
    	<section class="main-area">
			<c:import url="/WEB-INF/imports/header.jsp"/>
			<c:import url="/WEB-INF/imports/category-menu.jsp"/>
           	<div class="container resizable">
				<zeng-messages:warning/>
           		<c:if test="${!empty currentCategory}">
            		<zeng-structure:category category="${currentCategory}"/>
           		</c:if>
			</div>
			<c:import url="/WEB-INF/imports/footer.jsp"/>
        </section>
        <zeng-structure:sideBar/>

		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
		<!-- MODAL SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/modal-script.jsp"></c:import>
		<!-- DROPDOWN MENU SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/dropdown.js" />"></script>
		<!-- SCREEN SIZE SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>
		<!-- SHOWPROJECT SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/showProject.js" />"></script>
	</body>
</html>

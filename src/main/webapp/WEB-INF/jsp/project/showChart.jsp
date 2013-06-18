<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - ${project.name}</title>
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />

</head>
	<body>
		<section id="container">
	    	<section id="left_container">
				<header class="header">
					<c:import url="/WEB-INF/imports/header.jsp"/>
				</header>
	            <section class="content">
	            	<section class="project_chart container" id="zeng" style='width: 1024px; height: 500px;'></section>
				</section>
				<c:import url="/WEB-INF/imports/footer.jsp"/>
	        </section>
        </section>

		
		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
		
		<!-- GOOGLE API -->
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>
		
		<!-- CHART SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/chart.js" />"></script>
	</body>
</html>

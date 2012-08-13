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

<c:import url="/WEB-INF/imports/script-css.jsp"/>

<!-- PROJECT STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/project.css"/>" />

</head>
	<body>
		<section id="container">
	    	<section id="left_container">
				<section id="top">
					<c:import url="/WEB-INF/imports/header.jsp"/>
				</section>
	            <section id="content">
	            	<section class="project_chart" id="zeng"></section>
				</section>
				<c:import url="/WEB-INF/imports/footer.jsp"/>
	        </section>
        </section>

		<!-- GOOGLE API -->
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>
		
		<!-- CHART SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/chart.js" />"></script>
		 <script type="text/javascript">
			google.load('visualization', '1', {'packages':['corechart']});
			google.setOnLoadCallback(desenhaGrafico);
		
			function getData(){
				$.get("./getTasksPerContributors",function(data){
					console.log(data);
				});
			};	
			
			function desenhaGrafico() {
				getData();
				var data = new google.visualization.DataTable();
				data.addColumn('date', 'Dia');
				data.addColumn('number', 'Leonardo');
				data.addColumn('number', 'Enzo');
				
				data.addRows(4);
				
				data.setValue(0, 0, new Date(2012,01,09));
				data.setValue(0, 1, 30);
				data.setValue(0, 2, 60);
				
				data.setValue(1, 0, new Date(2012,02,10));
				data.setValue(1, 1, 35);
				data.setValue(1, 2, 26);
				
				data.setValue(2, 0, new Date(2012,03,12));
				data.setValue(2, 1, 30);
				data.setValue(2, 2, 30);
				
				data.setValue(3, 0, new Date(2012,04,13));
				data.setValue(3, 1, 40);
				data.setValue(3, 2, 2);
				
				var chart = new google.visualization.LineChart(document.getElementById('zeng'));
				chart.draw(data, {width: 800, height: 600, title: 'Tarefas por colaborador'});
			}  
		</script>
	</body>
</html>

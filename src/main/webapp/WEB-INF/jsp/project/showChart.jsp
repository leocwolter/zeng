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
				<section id="top">
					<c:import url="/WEB-INF/imports/header.jsp"/>
				</section>
	            <section id="content">
	            	<section class="project_chart" id="zeng"></section>
				</section>
				<c:import url="/WEB-INF/imports/footer.jsp"/>
	        </section>
        </section>

		
		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
		
		<!-- GOOGLE API -->
<!-- 		<script type="text/javascript" src="https://www.google.com/jsapi"></script> -->
		
		<!-- CHART SCRIPT -->
<%-- 		<script type="text/javascript" src="<c:url value="/js/chart.js" />"></script> --%>

		
		 <script type="text/javascript">
// 			google.load('visualization', '1', {'packages':['corechart']});
// 			google.setOnLoadCallback(desenhaGrafico);
// 			function desenhaGrafico(){
				$.get("./getTasksPerContributors",function(data){
					console.log(data);
// 					var dataChart = new google.visualization.DataTable();
// 					$(data.contributors).each(function(contributorIndex,contributor){
// 						console.log(contributor.name);
// 						dataChart.addColumn('number', contributor.name);
// 						console.log(contributor.finalizedTasks.length);
// 						dataChart.addRows(contributor.finalizedTasks.length);
// 						$(contributor.finalizedTasks).each(function(taskIndex, task){
// 							console.log(parseInt(taskIndex)+","+parseInt(contributorIndex)+1);
// 							dataChart.setValue(parseInt(taskIndex), 0, new Date(task.dateOfCompletion.iMillis));
// 							dataChart.setValue(parseInt(taskIndex), parseInt(contributorIndex),);
// 						});	
// 					});
					
// 					var chart = new google.visualization.LineChart(document.getElementById('zeng'));
// 					chart.draw(dataChart, {width: 800, height: 600, title: 'Tarefas por colaborador'});
				});
// 			}
		</script>
		

	</body>
</html>

	google.load('visualization', '1', {'packages':['annotatedtimeline']});
	google.setOnLoadCallback(desenhaGrafico);
	function desenhaGrafico(){
		$.get("./getTasksPerContributors",function(data){
			var dataChart = new google.visualization.DataTable();
			dataChart.addColumn('datetime', 'Mes');
			dataChart.addRows(12);
			$(data.quantityOfTasksPerMonth).each(function(userIndex,quantityOfTasksPerUser){
				dataChart.addColumn('number', quantityOfTasksPerUser.user.name);
				$(quantityOfTasksPerUser.tasksPerMonth).each(function(tasksPerMonthIndex, tasksPerMonth){
					dataChart.setValue(parseInt(tasksPerMonthIndex), 0, new Date(tasksPerMonth[0].iMillis));
					dataChart.setValue(parseInt(tasksPerMonthIndex), parseInt(userIndex)+1,tasksPerMonth[1]);
				});
				var chart = new google.visualization.AnnotatedTimeLine(document.getElementById('zeng'));
				
				chart.draw(dataChart, {displayZoomButtons:false});
			});
		});
	}

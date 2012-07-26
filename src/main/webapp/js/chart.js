//$(function() {
//	// carregando bibliotecas do google
//	google.load('visualization', '1', {
//		'packages' : [ 'corechart' ]
//	});
//	google.setOnLoadCallback(desenhaGrafico);
//
//	function desenhaGrafico() {
//		var data = new google.visualization.DataTable();
//		data.addColumn('string', 'Mês');
//		data.addColumn('number', 'Gastos em R$');
//
//		data.addRows(5);
//
//		// dados de janeiro
//		data.setValue(0, 0, 'Janeiro');
//		data.setValue(0, 1, 20450.0);
//		// dados de fevereiro
//		data.setValue(1, 0, 'Fevereiro');
//		data.setValue(1, 1, 21870.0);
//		// dados de marco
//		data.setValue(2, 0, 'Março');
//		data.setValue(2, 1, 22250.0);
//		// dados de abril
//		data.setValue(3, 0, 'Abril');
//		data.setValue(3, 1, 21769.0);
//		// dados de maio
//		data.setValue(4, 0, 'Maio');
//		data.setValue(4, 1, 23234.0);
//
//		var chart = new google.visualization.LineChart(document
//				.getElementById('chart_div'));
//		chart.draw(data, {
//			width : 400,
//			height : 240,
//			title : 'Gastos do mês'
//		});
//	}
//});
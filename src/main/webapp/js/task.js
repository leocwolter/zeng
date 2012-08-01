$(function() {
	$( ".task-list" ).sortable({
		connectWith: ".task-list",
		receive: function(event, ui) {
            var taskListId = ui.item.closest("ul").attr("id").split("-")[2];
            var taskId = ui.item.attr("id").split("-")[1];
            $.post("../task/moveTask", {"task.id": taskId, "taskList.id": taskListId} );	
        }
	}).disableSelection();
	
	$( ".task-box" ).click(
			function(){
				$.fn.colorbox({iframe:true, width:"600px", height:"600px", scrolling:true, href:"/zeng/task/1"});
			}
	);
	
	$(".task-filter").click(function(){
		var taskStatus = $(this).html();
		var taskListId = $(this).closest("section").attr("id").split("-")[1];
		$.get("../task/filter", {"taskListId": taskListId,"taskState":taskStatus}, function(data){
			console.log(data);
		});	
	});
		
});
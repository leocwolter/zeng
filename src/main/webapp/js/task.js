$(function() {
	$( ".task_list" ).sortable({
		connectWith: ".task_list",
	}, function(event, ui){
		var taskId = ui.item.attr("class");
		console.log(taskId);
		var taskListId = $(this).attr("class");
		console.log(taskListId);
		$.post("./task/moveTask", {"task.id": taskId, "taskList.id": taskListId} );	
	}).disableSelection();
});
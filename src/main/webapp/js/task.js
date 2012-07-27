/*$(function() {
	$( ".task_list" ).sortable({
		connectWith: ".task_list",
	}, function(event, ui){
		var taskId = ui.item.attr("class");
		console.log(taskId);
		var taskListId = $(this).attr("class");
		console.log(taskListId);
	}).disableSelection();
});*/

$(function() {
	$( ".task_list" ).sortable({
		connectWith: ".task_list",
		receive: function(event, ui) {
			$.post("../task/moveTask", {"task.id": taskId, "taskList.id": taskListId} );	
            var taskListId = ui.item.closest("ul").attr("id").split("-")[1];
            var taskId = ui.item.attr("id").split("-")[1];
        }
	}).disableSelection();
	
	$( ".task_box" ).dblclick(
			function(){
				$.fn.colorbox({iframe:true, width:"500px", height:"300px", href:"/zeng/addTaskPanel/1"});
				//alert("fununcifou!");
			}
	);
});
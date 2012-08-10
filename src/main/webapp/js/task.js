$(function() {
	$( ".task-list" ).sortable({
		connectWith: ".task-list",
		receive: function(event, ui) {
            var taskListId = ui.item.closest("ul").attr("id").split("-")[2];
            var taskId = ui.item.attr("id").split("-")[1];
            $.post("../task/moveTask", {"task.id": taskId, "taskList.id": taskListId} );	
        }
	}).disableSelection();
	
	$( ".task-box" ).dblclick(
			function(){
				$.fn.colorbox({iframe:true, width:"600px", height:"600px", scrolling:true, href:"/zeng/task/1"});
			}
	);
	
	$(".task-filter").click(function(){
		var taskStatus = $(this).attr("id").split("-")[2];
		$(this).closest("section").find(".task:not(.task-state-"+taskStatus.toUpperCase()+")").hide();
		$(this).closest("section").find(".task.task-state-"+taskStatus.toUpperCase()).show();
	});
		
});
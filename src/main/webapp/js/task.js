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
		var taskStatus = $(this).attr("rel").split("-")[2].toUpperCase();
		var taskArea = $(this).closest(".task-area");
		if(taskStatus == "NOFILTER"){
			taskArea.find(".task").show();
		}else{
			taskArea.find(".task").not(".task-state-"+taskStatus).hide();
			taskArea.find(".task-state-"+taskStatus).show();
		}
		taskArea.find(".task-filter").removeClass("task-filter-selected");
		$(this).addClass("task-filter-selected");
	});
});
$(function() {
	$( ".task_list" ).sortable({
		connectWith: ".task_list",
		receive: function(event, ui) {
            var taskListId = ui.item.closest("ul").attr("id").split("-")[1];
            var taskId = ui.item.attr("id").split("-")[1];
            $.post("../task/moveTask", {"task.id": taskId, "taskList.id": taskListId} );	
        }
	}).disableSelection();
	
	$( ".task_box" ).click(
			function(){
<<<<<<< HEAD
				$.fn.colorbox({iframe:true, width:"500px", height:"300px", href:"/zeng/task/1"});
=======
				$.fn.colorbox({iframe:true, width:"600px", height:"600px", scrolling:true, href:"/zeng/task/1"});
>>>>>>> Colorbox (modal) das tasks
			}
	);
});
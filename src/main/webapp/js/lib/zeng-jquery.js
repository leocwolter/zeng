//DragnDrop Bind Configuration
jQuery.fn.configureZengTaskList = function() {
	$(this).sortable({
		connectWith : $(this),
		receive : function(event, ui) {
			var taskListId = ui.item.closest("ul").data("tasklist-id"),
				taskId = ui.item.data("task-id");
			ui.item.attr("style","");
			$.post(context+"project/category/taskList/task/moveTask", {
				"task.id" : taskId,
				"taskList.id" : taskListId
			});
		}
	});
};
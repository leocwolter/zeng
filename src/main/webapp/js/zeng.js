$(function(){

	//Afternow Validation
	jQuery.validator.addMethod("afterNow", function(value, element) {   
		if(value === "" || value === undefined) return;
		var expirationDateText = value.split("-");
		var date = new Date(expirationDateText[0],expirationDateText[1]-1,expirationDateText[2]);
		var today = new Date;
		return date >= today;   
	}, "Informe uma data válida");

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
});
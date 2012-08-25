$(function() {
	//Drag n drop configuration
	$(".task-list").sortable({
		connectWith : ".task-list",
		receive : function(event, ui) {
			var taskListId = ui.item.closest("ul").attr("id").split("-")[2];
			var taskId = ui.item.attr("id").split("-")[1];
			$.post("../task/moveTask", {
				"task.id" : taskId,
				"taskList.id" : taskListId
			});
		}
	});
	
	//Open task description when dbclick
	$(".task-box").live("dblclick",function() {
		$.fn.colorbox({
			iframe : true,
			width : "600px",
			height : "600px",
			scrolling : true,
			href : "/zeng/task/1"
		});
	});
	
	//Filter tasks
	$(".task-filter:not([rel=mine])").live("click", function() {
		var taskStatus = $(this).attr("rel").toUpperCase();
		var taskArea = $(this).closest(".task-area");
		if (taskStatus == "NOFILTER") {
			taskArea.find(".task").show();
		} else {
			taskArea.find(".task").not(".task-state-" + taskStatus).hide();
			taskArea.find(".task-state-" + taskStatus).show();
		}
		taskArea.find(".task-filter").removeClass("task-filter-selected");
		$(this).addClass("task-filter-selected");
	});
	
	$(".task-filter[rel=mine]").live("click", function() {
		var user = $("#user-name-link").text().trim();
		var taskArea = $(this).closest(".task-area");
		console.log(user);
		taskArea.find(".task-contributors").not(":contains("+user+")").closest(".task").hide();
		taskArea.find(".task-contributors:contains("+user+")").closest(".task").show();
		
		taskArea.find(".task-filter").removeClass("task-filter-selected");
		$(this).addClass("task-filter-selected");
	});
	

	//Select Category Menu
	$('.category-button').live("click", function() {
		var categoryButtonStatus = $(this).attr('id');
		if (!(categoryButtonStatus == "selected-category-button")) {
			$("#selected-category-button").removeAttr('id');
			$(this).attr('id', 'selected-category-button');
			var categoryButtonDestination = $(this).attr("rel");
			$(categoryButtonDestination).addClass('selected-category');
			$('.category').not(categoryButtonDestination)
					.removeClass('selected-category');
		}
	});
	
	//Notifications Atualization
	setInterval(function updateNotifications(){
		var projectUrl = $("#project-name a").attr("href").split("/")[3];
		$.get("/zeng/project/"+projectUrl+"/updateNotifications", function(data){
			var notifications = $("<dl>");
			$(data.notifications).each(function(index, notification){
				var author = $("<dt>").html(notification.author.name);
				var action = $("<dd>").html(notification.action);
				notifications.append(author).append(action).append("<br>");
			});
			$("#project-notifications").html(notifications);
		});
	
	}, 3000);
		
	
	
});
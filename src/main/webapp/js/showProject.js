$(function() {
	//Drag n' drop configuration
	$(".task-list").sortable({
		connectWith : ".task-list",
		receive : function(event, ui) {
			var taskListId = ui.item.closest("ul").data("tasklist-id"),
				taskId = ui.item.data("task-id");
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
	$(".task-filter").live("click", function() {
		var taskFilter= $(this).data("filter").toUpperCase(),
			taskArea = $(this).closest(".task-area");
		filterTasksInTaskArea(taskFilter,taskArea);
		taskArea
			.find(".task-filter")
			.removeClass("task-filter-selected");
		$(this).addClass("task-filter-selected");
	});

	function filterTasksInTaskArea(taskFilter, taskArea){
		if (taskFilter == "NOFILTER") {
			taskArea.find(".task").show();
		} else if(taskFilter == "MINE") {
			showMyTasks(taskArea);
		} else{
			taskArea.find(".task").hide();
			taskArea.find(".task-state-" + taskFilter).show();
		}
	}
	
	function showMyTasks(taskArea) {
		var userName = $("#user-name-link").data("user-name");
		taskArea.find(".task-contributors").closest(".task").hide();
		taskArea.find(".task-contributors:contains("+userName+")").closest(".task").show();
	};
	

	//Select Category Menu
	$('.category-button').live("click", function() {
		$("#selected-category-button").removeAttr('id');
		$(this).attr('id', 'selected-category-button');
		var categoryButtonDestination = $(this).data("category");
		$('.category').removeClass('selected-category');
		$(categoryButtonDestination).addClass('selected-category');
	});
	
	//Notifications updating
	setInterval(function updateNotifications(){
		var projectUrl = $("#project-name").data("url");
		$.get("/zeng/project/"+projectUrl+"/updateNotifications", function(data){
			var notifications = createNotifications(data.notifications);
			$("#project-notifications").html(notifications);
		});
	}, 3000);
	
	function createNotifications(notificationsData){
		var notifications = $("<dl>");
		$(notificationsData).each(function(index, notification){
			var author = $("<dt>").html(notification.author.name),
				action = $("<dd>").html(notification.action);
			notifications
				.append(author)
				.append(action)
				.append("<br>");
		});
		return notifications;
	};
	
});
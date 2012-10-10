$(function() {
	updateNotifications();
	
	//Drag n' drop configuration
	$(".task-list").sortable({
		connectWith : ".task-list",
		receive : function(event, ui) {
			var taskListId = ui.item.closest("ul").data("tasklist-id"),
				taskId = ui.item.data("task-id");
			$.post("/zeng/task/moveTask", {
				"task.id" : taskId,
				"taskList.id" : taskListId
			});
		}
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
	});
	
	$('.task-options > a').live("click",function(event){
		var taskId = $(this).closest(".task").data("task-id");
		var url = $(this).attr('href')+taskId;
		var taskOptions = $(this).closest(".task-options");
		$.post(url,function(data){
			$(taskOptions).children().remove();
			$(taskOptions).append(data);
		});
		event.preventDefault();
	});
	
	//Archive task
	$(".archive-task").live("click", function(event){
		var taskId = $(this).closest(".task").data("task-id");
		var url = $(this).attr("href")+taskId;
		$.post(url);
		$(this).closest(".task").remove();
		event.preventDefault();
	});
	
	//Notifications updating
	setInterval(function(){
		updateNotifications();
	}, 3000);
	
	function updateNotifications(){
		var projectId= $("#project-name").data("projectid");
		$.get("/zeng/project/"+projectId+"/updateNotifications", function(data){
			var notifications = createNotifications(data.notifications);
			$("#project-notifications").html(notifications);
		});
	}
	
	function createNotifications(notificationsData){
		var notifications = $("<dl>");
		$(notificationsData).each(function(index, notification){
			var date = new Date(notification.creationDate.iMillis),
				formattedDate = date.format("dd/mm/yyyy");
			
			var author = $("<dt>").html(notification.author.name),
				action = $("<dd>").html(notification.action);
				creationDate = $("<dd>").html(formattedDate);
			
			notifications
				.append(author)
				.append(action)
				.append(creationDate)
				.append("<br>");
		});
		return notifications;
	};
	
});
$(function() {
	var context = $("#small-logo").attr("href");
	updateNotifications();

	//Drag n' drop configuration
	$(".task-list").configureZengTaskList();
	
	//Filter tasks
	$(".task-filter").live("click", function() {
		var taskFilter= $(this).data("filter").toUpperCase(),
			taskArea = $(this).closest(".task-area");
		filterTasksInTaskArea(taskFilter,taskArea);
		taskArea.find(".task-filter").removeClass("task-filter-selected");
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
	
	//Task Actions
	$('.task-options > a').live("click",function(event){
		event.preventDefault();
		var url = $(this).attr('href');
		var taskOptions = $(this).closest(".task-options");
		$.post(url,function(data){
			$(taskOptions).children().remove();
			$(taskOptions).append(data);
		});
	});
	
	//Archive task
	$(".archive-task").live("click", function(event){
		event.preventDefault();
		var url = $(this).attr("href");
		$.post(url);
		$(this).closest(".task").remove();
	});
	
	//Notifications updating
	setInterval(function(){
		updateNotifications();
	}, 3000);
	
	function updateNotifications(){
		var projectId= $("#project-name").data("projectid");
		$.get(context+"project/"+projectId+"/getActions", function(data){
			var actions = createNotifications(data.actions);
			$("#project-notifications").html(actions);
		});
	}
	
	function createNotifications(actions){
		var actionsDl = $("<dl>");
		$(actions).each(function(index, action){
			var date = new Date(action.creationDate.iMillis),
				formattedDate = date.format("dd/mm/yyyy");
			
			var author = $("<dt>").html(action.author.name),
				actionText = $("<dd>").html(action.text);
				creationDate = $("<dd>").html(formattedDate);
			
			actionsDl
				.append(author)
				.append(actionText)
				.append(creationDate)
				.append("<hr/>");
		});
		return actionsDl;
	};
	
});
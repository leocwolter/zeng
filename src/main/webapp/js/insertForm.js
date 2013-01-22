$(function () {
	var context = $("#small-logo").attr("href");
	
	function submitForm(form, callBack) {
		var formData = form.serialize(),
		url = form.attr("action");
		$.post(url, formData, function(data){
			callBack(data);
		});
		$(".messi-closebtn", parent.document).click();
	};
	
	function appendLinkToMenu(href, name){
		var page = $(parent.document),
			link = $("<a>"+name+"</a>").attr({"href":href, "title":name}),
			menuItem = $("<li>").append(link);
		var target = "";
		if($('#menu li').size() >= 4){
			target = page.find(".other-itens");
		}
		else{
			target = page.find("#menu");
		}
		$(target).append(menuItem);
		if($('#menu li').size() == 4){
			document.location.reload(true);
		}
	}

	//Project & Category insertion
	$(".simple-insert-form").submit(function (event) {
		event.preventDefault();
		var form = $(this);
		var url = form.find("[name='showUrl']").val();
		submitForm(form,  function (data) {
			appendLinkToMenu({"href":url+data.insertedElement.url, "name":data.insertedElement.name});
		});
	});
	
	function appendLinkToMenu(data) {
		var page = $(parent.document),
		menu = page.find("#menu"),
		link = $.nano("<a href='{href}' title='{name}'>{name}</a>", data),
		menuItem = $("<li>").append(link);
		$(menu).append(menuItem);
	}
	
	//Task list insertion
	$(".insert-task-list-form").submit(function (event) {	
		event.preventDefault();
		submitForm($(this), function (data) {
			var taskArea = new TaskArea(data.taskList);
			var category = $(".category", parent.document);
			$(taskArea.element).appendTo(category);		
			$(".task-list").configureZengTaskList();
		});
	});

	function TaskArea(taskListData) {
		var taskList = this.createTaskList(taskListData),
			taskListTitle = this.createTitle(taskListData),
			nav = this.createTaskAreaNavBar(),
			addTaskButton = this.createAddTaskButton(taskListData);
		
		this.element = $("<section class='task-area'>")
			.append(taskListTitle)
			.append(nav)
			.append(taskList)
			.append(addTaskButton);

	}
	
	TaskArea.prototype.createAddTaskButton = function (taskListData) {
		var href= $.nano(context+"project/category/taskList/{id}/addTaskForm", taskListData);
		var button = $("<a class='add-button add-task-button modal'>+Add Task</a>").attr("href",href);
		return button;
	}
	
	TaskArea.prototype.createTitle = function (taskListData) {
		return $.nano("<h3>{name}</h3>", taskListData)
	}
	
	TaskArea.prototype.createTaskList = function (taskListData) {
		return $.nano("<ul class='task-list ui-sortable' data-tasklist-id='{id}'>", taskListData);
	}
	
	TaskArea.prototype.createTaskAreaNavBar = function () {
		var all =  this.generateMenuItem({"filter":"nofilter","text":"All"});
		all.find("a").addClass("task-filter-selected");
		var menuItems = $("<ul>")
			.append(all)
			.append(this.generateMenuItem({"filter":"todo", "text":"To do"}))
			.append(this.generateMenuItem({"filter":"doing", "text":"Doing"}))
			.append(this.generateMenuItem({"filter":"done", "text":"Done"}))
			.append(this.generateMenuItem({"filter":"mine", "text":"Mine"}));
		return $("<nav>").addClass("task-menu-bar").append(menuItems);
	}
	
	TaskArea.prototype.generateMenuItem = function(data) {
		return $($.nano("<li><a class='task-filter' data-filter='{filter}' href='#'>{text}</a></li>", data));
	};
	
	//Task insertion
	$(".insert-task-form").submit(function (event) {
		event.preventDefault();
		submitForm($(this), function (data) {
			var taskData = data.task;
			var	task = new Task(taskData),
				selector = $.nano("[data-tasklist-id = {taskList.id}]", taskData),
				taskList = $(selector, parent.document);
			$(task.element).appendTo(taskList);
		});
	});
	
	function Task(taskData) {
		var archiveTaskButton = this.createArchiveTaskButton(taskData),
			taskName = this.createTaskName(taskData),
			taskContributors = this.createTaskContributors(taskData.contributors),
			taskOptions = this.createTaskOptions(taskData),
			taskExpirationDate = this.createTaskExpirationDate(taskData);
		
		var taskHtml = $.nano("<li class='task task-state-TODO' data-task-id='{id}'>", taskData);
		
		this.element = $(taskHtml)
			.append(archiveTaskButton)
			.append(taskName)
			.append(taskContributors)
			.append(taskExpirationDate)
			.append(taskOptions);
	}
	
	
	Task.prototype.createArchiveTaskButton = function(taskData) {
		var archiveButton = $.nano("<a class='button remove-button archive-task' href='"+context+"project/{taskList.category.project.url}/category/taskList/task/{id}/archiveTask'>X</a>", taskData);
		return archiveButton;
	}

	Task.prototype.createTaskName = function(taskData) {
		return $.nano("<h4 class='task-name'>{name}</h4>", taskData);
	}
	
	Task.prototype.createTaskContributors = function(contributors) {
		var contributorsUl = $("<ul class='task-contributors'>");
		var lis = "";
		$(contributors).each(function (index, contributor) {
			lis+=$.nano("<li>{name};&nbsp; </li>",contributor);
		});
		$(contributorsUl).append(lis);
		return contributorsUl;
	}
	
	Task.prototype.createTaskExpirationDate = function(taskData) {
		if(taskData.expirationDate === undefined) return false;
		this.validateManyTasks(taskData);
		var date = new Date(taskData.expirationDate.iMillis),
		formattedDate = date.format("dd/mm/yyyy");
		return $("<span class='task-expiration-date'>").html("Expiration Date: "+ formattedDate);
	}
	
	Task.prototype.createTaskOptions = function(taskData) {
		var taskOptions = $("<div class='task-options'>")
			.append($.nano("<a class='button normal-button' href='"+context+"project/category/taskList/task/{id}/startTask'>Start Task</a>",taskData));
		return taskOptions;
	}

	Task.prototype.validateManyTasks = function(taskData) {
		var expirationData = {"dateInMillis":taskData.expirationDate.iMillis};
		var projectUrl = $.nano(context+"project/{taskList.category.project.url}/manyTasksWithExpirationDate",taskData);
		$.get(projectUrl, expirationData, function(manyTasks){
			if(manyTasks.boolean){
				alert("There are more than three tasks with that expiration date in this project!");
			}
		});
	}

	$(".insert-form").validate({   
	    rules: {   
	        'expirationDate': {   
	            afterNow: true
	        }  
	    },
		messages: {
			'expirationDate': {
				afterNow: "The expiration date should be after today"
			}
		}
	});  
});
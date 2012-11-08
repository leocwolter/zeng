$(function () {
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
		
		if($('#menu li').size() === 4){
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
			var taskArea = createTaskArea(data.taskList),
				category = $(".category", parent.document);
			$(taskArea).appendTo(category);		
			$(".task-list").configureZengTaskList();
		});
	});

	function createTaskArea(taskListData) {
		var taskList = $.nano("<ul class='task-list ui-sortable' data-tasklist-id='{id}'>", taskListData),
			taskListTitle = $.nano("<h3>{name}</h3>", taskListData),
			nav = createTaskAreaNavBar(),
			addTaskButton = $("<a class='add-button add-task-button modal'>+Add Task</a>")
							.attr("href","/zeng/project/category/taskList/"+taskListData.id+"/addTaskForm"),
			taskArea = $("<section class='task-area'>")
						.append(taskListTitle)
						.append(nav)
						.append(taskList)
						.append(addTaskButton);

		return taskArea;
	}
	
	function createTaskAreaNavBar() {
		var all =  generateMenuItem({"filter":"nofilter","text":"All"});
		console.log(all);
		all.find("a").addClass("task-filter-selected");
		var menuItems = $("<ul>")
			.append(all)
			.append(generateMenuItem({"filter":"todo", "text":"To do"}))
			.append(generateMenuItem({"filter":"doing", "text":"Doing"}))
			.append(generateMenuItem({"filter":"done", "text":"Done"}))
			.append(generateMenuItem({"filter":"mine", "text":"Mine"}));
		return $("<nav>").addClass("task-menu-bar").append(menuItems);
	}
	
	function generateMenuItem(data) {
		return $($.nano("<li><a class='task-filter' data-filter='{filter}' href='#'>{text}</a></li>", data));
	};
	
	//Task insertion
	$(".insert-task-form").submit(function (event) {
		event.preventDefault();
		submitForm($(this), function (data) {
			var taskData = data.task,
				task = createTask(taskData),
				selector = $.nano("[data-tasklist-id = {taskList.id}]", taskData),
				taskList = $(selector, parent.document);
			$(taskList).append(task);
			validateManyTasks(taskData);
		});
	});
	
	function validateManyTasks(taskData) {
		if(expirationDate !== undefined){
			var expirationData = {"dateInMillis":taskData.expirationDate.iMillis};
			var projectUrl = $.nano("/zeng/project/{taskList.category.project.url}/manyTasksWithExpirationDate",taskData);
			$.get(projectUrl, expirationData, function(manyTasks){
				if(manyTasks.boolean){
					alert("There are more than three tasks with that expiration date in this project!");
				}
			});
		}
	}
	
	function createTask(taskData) {
		var archiveTaskButton = createArchiveTaskButton(taskData),
			taskName = createTaskName(taskData),
			taskContributors = createTaskContributors(taskData.contributors);
			taskDate = createTaskExpirationDate(taskData.expirationDate.iMillis),
			taskOptions = createTaskOptions(taskData);
		
		var taskHtml = $.nano("<li class='task task-state-TODO' data-task-id='{id}'>", taskData);
		
		var task = $(taskHtml)
			.append(archiveTaskButton)
			.append(taskName)
			.append(taskContributors)
			.append(taskDate)
			.append(taskOptions);
		
		return task;
	}
	
	
	function createArchiveTaskButton(taskData) {
		var archiveButton = $.nano("<a class='button remove-button archive-task' href='/zeng/project/category/taskList/task/{id}/archiveTask'>X</a>", taskData);
		return archiveButton;
	}

	function createTaskName(taskData) {
		return $.nano("<h4 class='task-name'>{name}</h4>", taskData);
	}
	
	function createTaskContributors(contributors) {
		var contributorsUl = $("<ul class='task-contributors'>");
		var lis = "";
		$(contributors).each(function (index, contributor) {
			lis+=$.nano("<li>{name};&nbsp; </li>",contributor);
		});
		$(contributorsUl).append(lis);
		return contributorsUl;
	}
	
	function createTaskExpirationDate(dateInMillis) {
		var date = new Date(dateInMillis),
		formattedDate = date.format("dd/mm/yyyy");
		return $("<span class='task-expiration-date'>").html("Expiration Date: "+ formattedDate);
	}
	
	function createTaskOptions(taskData) {
		var taskOptions = $("<div class='task-options'>")
			.append($.nano("<a class='button normal-button' href='/zeng/project/category/taskList/task/{id}/startTask'>Start Task</a>",taskData));
		return taskOptions;
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
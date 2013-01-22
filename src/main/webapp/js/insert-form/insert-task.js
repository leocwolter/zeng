$(function(){
	//Afternow Validation
	jQuery.validator.addMethod("afterNow", function(value, element) {   
		if(value === "" || value === undefined) return;
		var expirationDateText = value.split("-");
		var date = new Date(expirationDateText[0],expirationDateText[1]-1,expirationDateText[2]);
		var today = new Date;
		return date >= today;   
	}, "Informe uma data válida");
	
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
})
$(function(){
	function submitForm(form, callBack){
		var formData = form.serialize(),
		url = form.attr("action");
		$.post(url, formData, function(data){
			callBack(data);
		});
		$(".messi-closebtn", parent.document).click();
	};
	
	function appendLinkToMenu(href, name){
		var page = $(parent.document),
			menu = page.find("#menu"),
			link = $("<a>"+name+"</a>").attr({"href":href, "title":name}),
			menuItem = $("<li>").append(link);
		$(menu).append(menuItem);
	}
	
	//Project & Category insertion
	$(".simple-insert-form").submit(function(event){
		event.preventDefault();
		var form = $(this);
		var url = form.find("[name='showUrl']").val();
		submitForm(form,  function(data){
			appendLinkToMenu(url+data.insertedElement.url, data.insertedElement.name);
		});
	});
	
	//Task list insertion
	$(".insert-task-list-form").submit(function(event){	
		event.preventDefault();
		submitForm($(this), function(data){
			var taskArea = createTaskArea(data.taskList),
				category = $(".category", parent.document);
			$(taskArea).appendTo(category);		
			$(".task-list").configureZengTaskList();
		});
	});

	function createTaskArea(taskListData){
		var taskList = $("<ul class='task-list ui-sortable' data-tasklist-id='"+taskListData.id+"'>"),
			taskListTitle = $("<h3>"+taskListData.name+"</h3>"),
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
	
	function createTaskAreaNavBar(){
		var all =  generateMenuItem("nofilter","All");
		all.find("a").addClass("task-filter-selected");
		var menuItems = $("<ul>")
			.append(all)
			.append(generateMenuItem("todo","To do"))
			.append(generateMenuItem("doing","Doing"))
			.append(generateMenuItem("done","Done"))
			.append(generateMenuItem("mine","Mine"));
		return $("<nav>").addClass("task-menu-bar").append(menuItems);
	}
	
	function generateMenuItem(filter,text){
		return $("<li><a class='task-filter' data-filter='"+filter+"' href='#'>"+text+"</a></li>");
	};
	
	//Task insertion
	$(".insert-task-form").submit(function(event){
		event.preventDefault();
		submitForm($(this), function(data){
			var taskData = data.task,
				task = createTask(taskData),
				taskList = $("[data-tasklist-id = "+taskData.taskList.id+"]", parent.document);
			$(taskList).append(task);
			validateManyTasks(taskData);
		});
	});
	
	function validateManyTasks(taskData){
		if(expirationDate !== undefined){
			var expirationData = {"dateInMillis":taskData.expirationDate.iMillis};
			var projectUrl = taskData.taskList.category.project.url;
			$.get("/zeng/project/"+projectUrl+"/manyTasksWithExpirationDate", expirationData, function(manyTasks){
				if(manyTasks.boolean){
					alert("There are more than three tasks with that expiration date in this project!");
				}
			});
		}
	}
	
	function createTask(taskData){
		var archiveTaskButton = createArchiveTaskButton(taskData.id),
			taskName = createTaskName(taskData.name),
			taskContributors = createTaskContributors(taskData.contributors);
			taskDate = createTaskExpirationDate(taskData.expirationDate.iMillis),
			taskOptions = createTaskOptions(taskData.id);
		
		var task = $("<li class='task task-state-TODO'>").attr("data-task-id",taskData.id)
			.append(archiveTaskButton)
			.append(taskName)
			.append(taskContributors)
			.append(taskDate)
			.append(taskOptions);
		
		return task;
	}
	
	function createTaskName(taskName){
		return $("<h4>").addClass("task-name").text(taskName);
	}
	
	function createArchiveTaskButton(taskId){
		 var archiveButton = $("<a class='button remove-button archive-task'>X</a>")
			.attr("href","/zeng/task/"+taskId+"/archive/");
		 return archiveButton;
	}
	
	function createTaskExpirationDate(dateInMillis){
		var date = new Date(dateInMillis),
		formattedDate = date.format("dd/mm/yyyy");
		return $("<span class='task-expiration-date'>").html("Expiration Date: "+ formattedDate);
	}
	
	function createTaskContributors(contributors){
		var contributorsUl = $("<ul class='task-contributors'>");
		$(contributors).each(function(index, contributor){
			var contributorLi = $("<li>"+contributor.name+"; </li>");
			$(contributorsUl).append(contributorLi);
		});
		return contributorsUl;
	}
	
	function createTaskOptions(taskId){
		var taskOptions = $("<div>").addClass("task-options"),
			option = $("<a class='button normal-button'>Start Task</a>")
						.attr("href","/zeng/task/"+taskId+"/startTask/");
		return taskOptions.append(option);
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
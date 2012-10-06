$(function(){
	function insert(event, element, callBack){
		var form = $(element).closest("form"),
			inputs = form.find("select, input:not([type='submit'])"),	
			formData = createFormData(inputs),
			url = form.attr("action");
		$.post(url, formData, function(data){
			callBack(data);
		});
		$(".messi-closebtn", parent.document).click();
		event.preventDefault();
	};
	
	function createFormData(inputs){
		var formData = {};
		$(inputs).each(function(index, input){
			var name = $(input).attr("name"),
				value = $(input).val();
			formData[name] = value;
		});
		return formData;
	}
	
	//Project insertion
	$("input.insert-project").click(function(event){
		insert(event, this,  function(data){
			var menu = $("#menu", parent.document),
				projectButton = $("<li>").append("<a>");
			$(projectButton)
				.appendTo(menu)
				.find("a")
				.attr({"href":"/zeng/project/"+data.project.url, "title":data.project.name})
				.html(data.project.name);
		});
	});
	
	//Category insertion
	$("input.insert-category").click(function(event){	
		insert(event, this, function(data){
			var categoryData = data.category;
			createCategoryMenuItem(categoryData);
		});
	});

	function createCategoryMenuItem(categoryData){
		var menu = $("#menu", parent.document),
			categoryButton = $("<a>")
							.addClass("category-button")
							.attr(
									{"title":categoryData.name,
									 "href":"/zeng/project/category/"+categoryData.id
									}
								)
							.html(categoryData.name),
			item = $("<li>").append(categoryButton);
		$(item).appendTo(menu);
	}
	
	//Task list insertion
	$("input.insert-task-list").click(function(event){	
		insert(event, this, function(data){
			var taskListData = data.taskList,
				taskArea = createTaskArea(taskListData),
				categoryId = $("[name='categoryId']").val(),
				category = $("#category-"+categoryId, parent.document);
			$(taskArea).appendTo(category);		
		});
	});

	function createTaskArea(taskListData){
		var taskList = $("<ul>").addClass("task-list ui-sortable").attr("id","task-list-"+taskListData.id),
			taskListTitle = $("<h3>").text(taskListData.name),
			nav = createTaskAreaNavBar(),
			addTaskButton = $("<a>").addClass("add-task-button modal").attr("href","/zeng/taskList/addTaskForm/"+taskListData.id).html("+Add Task"),
			taskArea = $("<section>").addClass("task-area").append(taskListTitle, nav, taskList, addTaskButton);
		$(taskArea).attr("id","task-area-"+taskListData.id);
		return taskArea;
	}
	
	function createTaskAreaNavBar(){
		var menuItems = $("<ul>")
			.append(generateMenuItem("nofilter","All").addClass("task-filter-selected"))
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
	$("input.insert-task").click(function(event){
		insert(event, this,  function(data){
			var taskData = data.task,
				task = createTask(taskData),
				taskListId = $("input[name='taskListId']").val(),
				taskList = $("#task-list-"+taskListId, parent.document);
			$(taskList).append(task);
		});
	});
	
	function createTask(taskData){
		var task = $("<li>").addClass("task task-state-TODO").attr("id","task-"+taskData.id),
			taskName = $("<h4>").addClass("task-name").text(taskData.name),
			taskOptions = createTaskOptions(taskData.id);
		$(task)
			.append(taskName)
			.append(taskOptions);
		return task;
	}
	
	function createTaskOptions(taskId){
		var taskOptions = $("<div>").addClass("task-options"),
			option = $("<a>")
				.attr("href","/zeng/task/startTask/"+taskId)
				.addClass("button")
				.text("Start task");
		return taskOptions.append(option);
	}

});
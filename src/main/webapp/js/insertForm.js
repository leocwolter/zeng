$(function(){
	function insert(event, element, callBack){
		var form = $(element).closest("form");
		var inputs = form.find("select, input:not([type='submit'])");	
		var formData = createFormData(inputs);
		var url = form.attr("action");
		$.post(url, formData, function(data){
			callBack(data);
		});
		$("#cboxClose", parent.document).click();
		event.preventDefault();
	};
	
	function createFormData(inputs){
		var formData = {};
		$(inputs).each(function(index, input){
			var name = $(input).attr("name");
			var value = $(input).val();
			formData[name] = value;
		});
		return formData;
	}
	
	//Project insertion
	$("input.insert-project").click(function(event){
		insert(event, this,  function(data){
			var menu = $("#menu", parent.document);
			var projectButton = $("<li>").append("<a>");
			$(projectButton).find("a").attr({"href":"/zeng/project/"+data.project.url, "title":data.project.name}).html(data.project.name);
			$(projectButton).appendTo(menu);		
		});
	});
	
	//Category insertion
	$("input.insert-category").click(function(event){	
		insert(event, this, function(data){
			var categoryData = data.category;
			createCategory(categoryData);
			createCategoryMenuItem(categoryData);
		});
	});
	
	function createCategory(categoryData){
		var categoryContainer = $("#category-container", parent.document);
		var categoryId = "category-"+categoryData.id;
		var categoryName = categoryData.name;
		var category = $("<section>").addClass("category selected-category").attr("id",categoryId);
		var categoryTitle = $("<h2>").text(categoryName);
		$(categoryTitle).appendTo(category);
		$(category).appendTo(categoryContainer);
	}
	function createCategoryMenuItem(categoryData){
		var menu = $("#menu", parent.document);
		var categoryButton = $("<a>").addClass("category-button").attr({"data-category":"#category-"+categoryData.id, "title":categoryData.name}).html(categoryData.name);
		var item = $("<li>").append(categoryButton);
		$(item).appendTo(menu);
	}
	
	//Task list insertion
	$("input.insert-task-list").click(function(event){	
		insert(event, this, function(data){
			taskListData = data.taskList;
			var taskArea = createTaskArea(taskListData);
			var categoryId = $("[name='categoryId']").val();
			var category = $("#category-"+categoryId, parent.document);
			$(taskArea).appendTo(category);		
		});
	});

	function createTaskArea(taskListData){
		var taskList = $("<ul>").addClass("task-list ui-sortable").attr("id","task-list-"+taskListData.id);
		var taskListTitle = $("<h3>").text(taskListData.name);
		var nav = createTaskAreaNavBar();
		var addTaskButton = $("<a>").addClass("add-task-button colorbox cboxElement").attr("href","/zeng/taskList/addTaskForm/"+taskListData.id).html("+Add Task");
		var taskArea = $("<section>").addClass("task-area").append(taskListTitle, nav, taskList, addTaskButton);
		$(taskArea).attr("id","task-area-"+taskListData.id);
		return taskArea;
	}
	
	function createTaskAreaNavBar(){
		var menuItems = $("<ul>").append(generateMenuItem("nofilter","All").addClass("task-filter-selected"))
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
			var taskData = data.task;
			var task = createTask(taskData);
			var taskListId = $("input[name='taskListId']").val();
			var taskList = $("#task-list-"+taskListId, parent.document);
			$(taskList).append(task);
		});
	});
	
	function createTask(taskData){
		var task = $("<li>").addClass("task task-state-TODO").attr("id","task-"+taskData.id);
		var taskName = $("<h4>").addClass("task-name").text(taskData.name);
		var taskOptions = createTaskOptions(taskData.id);
		$(task).append(taskName);
		$(task).append(taskOptions);
		return task;
	}
	
	//Task options
	function createTaskOptions(taskId){
		var taskOptions = $("<div>").addClass("task-options");
		var option = $("<a>").attr("href","/zeng/task/startTask/"+taskId).addClass("button").text("Start task");
		return taskOptions.append(option);
	}

});
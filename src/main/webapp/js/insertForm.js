$(function(){
	function insere(event, element, callBack){
		var inputs = $(element).closest("form").find("select, input:not([type='submit'])");	
		var formData = {};
		
		$(inputs).each(function(index, input){
			var name = $(input).attr("name");
			var value = $(input).val();
			formData[name] = value;
		});
		
		var url = $(element).closest("form").attr("action");

		$.post(url, formData, function(data){
			callBack(data);
		});
		
		$("#cboxClose", parent.document).click();
		
		event.preventDefault();
	};
	
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
			var menu = $("#menu", parent.document);
			var categoryContainer = $("#category-container", parent.document);
			
			var categoryId = "category-"+data.category.id;
			var categoryName = data.category.name;
			
			var categoryButton = $("<a>").addClass("category-button").attr({"rel":"#"+categoryId, "title":categoryName}).html(categoryName);
			var item = $("<li>").append(categoryButton);
			
			var category = $("<section>").addClass("category").attr("id",categoryId);
			var categoryTitle = $("<h2>").text(categoryName);
			$(category).append(categoryTitle);
			$(category).appendTo(categoryContainer);
			$(item).appendTo(menu);
		});
	});
	
	//Task list insertion
	$("input.insert-task-list").click(function(event){	
		insert(event, this, function(data){
			var menuItems = generateMenuItems();
			var nav = $("<nav>").addClass("task-menu-bar").append(menuItems);
			var taskList = $("<ul>").addClass("task-list ui-sortable").attr("id","task-list-"+data.taskList.id);
			var addTaskButton = $("<a>").addClass("add-task-button colorbox cboxElement").attr("href","/zeng/taskList/addTaskForm/"+data.taskList.id).html("+Add Task");
			var taskListName = $("<h3>").text(data.taskList.name);

			var taskArea = $("<section>").addClass("task-area").append(taskListName, nav, taskList, addTaskButton);
			
			$(taskArea).attr("id","task-area-"+data.taskList.id);
	
			var categoryId = $("[name='categoryId']").val();
			var category = $("#category-"+categoryId, parent.document);
			$(taskArea).appendTo(category);		
		});
	});
	
	//Task insertion
	$("input.insert-task").click(function(event){
		insert(event, this,  function(data){
			var taskListId = $("input[name='taskListId']").val();
			var taskList = $("#task-list-"+taskListId, parent.document);
			var task = $("<li>").addClass("task task-state-TODO").attr("id","task-"+data.task.id);
			var taskName = $("<h4>").addClass("task-name").text(data.task.name);
			var taskOptions = generateTaskOptions(data.task.id);
			
			$(task).append(taskName);
			$(task).append(taskOptions);
			
			$(taskList).append(task);
		});
	});
	
	//Task options
	function generateTaskOptions(taskId){
		var taskOptions = $("<div>").addClass("task-options");
		var option = $("<a>").attr("href","/zeng/task/startTask/"+taskId).text("Começar tarefa");
		return taskOptions.append(option);
	}
	
	//Task list filter menu options
	function generateMenuItems(){
		return $("<ul>").append(generateMenuItem("nofilter","All",true))
			.append(generateMenuItem("todo","To do",false))
			.append(generateMenuItem("doing","Doing",false))
			.append(generateMenuItem("done","Done",false))
			.append(generateMenuItem("mine","Mine",false));
	}
	
	//Task list filter menu option selected
	function generateMenuItem(rel,text,isSelected){
		var selected="";
		if(isSelected){
			selected = " task-filter-selected";
		}
		return $("<li><a class='task-filter"+selected+"' rel='"+rel+"' href='#'>"+text+"</a></li>");
	}
});
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

		console.log(formData);
		$.post(url, formData, function(data){
			callBack(data);
		});
		
		$("#cboxClose", parent.document).click();
		
		event.preventDefault();
	};
	$("input.insert-project").click(function(event){
		insere(event, this,  function(data){
			var menu = $("#menu", parent.document);
			var item = $("<li><a></a></li>");
			$(item).find("a").attr({"href":"/zeng/project/"+data.project.url, "title":data.project.name}).html(data.project.name);
			$(item).appendTo(menu);		
		});
	});
	$("input.insert-category").click(function(event){	
		insere(event, this, function(data){
			var menu = $("#menu", parent.document);
			var categoryContainer = $("#category-container", parent.document);
			
			var categoryId = "category-"+data.category.id;
			var categoryName = data.category.name;
			
			var categoryButton = $("<a>").addClass("category-button").attr({"rel":"#"+categoryId, "title":categoryName}).html(categoryName);
			var item = $("<li>").append(categoryButton);
			
			var category = $("<section>").addClass("category").attr("id",categoryId);
			var categoryTitle = $("<h2>").html(categoryName);
			$(category).append(categoryTitle);
			$(category).appendTo(categoryContainer);
			$(item).appendTo(menu);		
		});
	});
	$("input.insert-task-list").click(function(event){	
		insere(event, this, function(data){
			var menuItems = generateMenuItems();
			var nav = $("<nav>").addClass("task-menu-bar").append(menuItems);
			var taskList = $("<ul>").addClass("task-list ui-sortable").attr("id","task-list-"+data.taskList.id);
			var addTaskButton = $("<a>").addClass("add-task-button colorbox cboxElement").attr("href","/zeng/taskpanel/addTaskForm/"+data.taskList.id).html("+Add Task");
			var taskListName = $("<h3>").html(data.taskList.name);

			var item = $("<section>").addClass("task-area").append(taskListName, nav, taskList, addTaskButton);
			
			$(item).attr("id","task-area-"+data.taskList.id);
	
			var category = $(".category", parent.document);
			$(item).appendTo(category);		
		});
	});
	function generateMenuItems(){
		return $("<ul>").append(generateMenuItem("nofilter","All",true))
			.append(generateMenuItem("todo","To do",false))
			.append(generateMenuItem("doing","Doing",false))
			.append(generateMenuItem("done","Done",false))
			.append(generateMenuItem("mine","Mine",false));
	}
	function generateMenuItem(rel,text,isSelected){
		var selected="";
		if(isSelected){
			selected = " task-filter-selected";
		}
		return $("<li><a class='task-filter"+selected+"' rel='"+rel+"' href='#'>"+text+"</a></li>");
	}
});
$(function(){
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
});
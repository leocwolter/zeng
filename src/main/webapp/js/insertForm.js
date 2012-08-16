$(function(){
	function insere(event, element, callBack){
		console.log("insere");
		var inputs = $(element).closest("form").find("input:not([type='submit'])");	
		var formData = {};
		
		$(inputs).each(function(index, input){
			var name = $(input).attr("name");
			var value = $(input).val();
			formData[name] = value;
		});
		
		var url = $(element).closest("form").attr("action");

		$.post(url, formData, function(data){
			console.log(formData);
			callBack(data);
		});
		$("#cboxClose", parent.document).click();
		
		event.preventDefault();
	};
	$("input.insert-project").click(function(event){
		console.log("insert-project");
		insere(event, this,  function(data){
			console.log("insere-callback");
			var menu = $("#menu", parent.document);
			var item = $(menu).find("li").first().clone();
			$(item).find("a").attr({"href":"/zeng/project/"+data.project.url, "title":data.project.name}).html(data.project.name);
			$(item).appendTo(menu);		
		});
	});
	$("input.insert-category").click(function(event){	
		insere(event, this, function(data){
			var menu = $("#menu", parent.document);
			var item = $(menu).find("li").first().clone();
			$(item).find("a").attr({"rel":"#category-"+data.category.id, "title":data.category.name}).html(data.category.name);
			$(item).appendTo(menu);		
		});
	});
	$("input.insert-task-list").click(function(event){	
		insere(event, this, function(data){
			var category = $(".category", parent.document);
			var item = $(category).find(".task-area").first().clone();
			$(item).attr("id","task-area-"+data.taskList.id);
			$(item).find("h3").html(data.taskList.name);
			$(item).find(".task-list").attr("id","task-list-"+data.taskList.id);
			$(item).appendTo(category);		
		});
	});
});
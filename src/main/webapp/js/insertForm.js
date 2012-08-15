

$(function(){
	$(".cboxIframe").ready(function(){
		console.log($(".cboxIframe"));
	});
	
//	
//	$(".cboxIframe").ready(function(){
//		$(this).contents().find("input.insert-project").click(function(event){	
//			insere(event, this,  function(data){
//				var item = $("#menu").find("li").eq(0).clone();
//				$(item).find("a").attr({"href":"/zeng/project/"+data.project.url, "title":data.project.name}).html(data.project.name);
//				$(item).appendTo("#menu");		
//			});
//		});
//		$(".cboxIframe").contents().find("input.insert-category").click(function(event){	
//			insere(event, this, function(data){
//				var item = $("#menu").find("li").eq(0).clone();
//				console.log(data);
//				$(item).find("a").attr({"rel":"#category-"+data.category.id, "title":data.category.name}).html(data.category.name);
//				$(item).appendTo("#menu");		
//			});
//		});
//		$(".cboxIframe").contents().find("input.insert-task-list").click(function(event){	
//			insere(event, this, function(data){
//				var item = $(".category").find(".task-area").eq(0).clone();
//				$(item).attr("id","task-area-"+data.taskList.id);
//				$(item).find("h3").html(data.taskList.name);
//				$(item).find(".task-list").attr("id","task-list-"+data.taskList.id);
//				$(item).appendTo("#menu");		
//			});
//		});
//		function insere(event, element, callBack){
//			var inputs = $(element).closest("form").find("input:not([type='submit'])");	
//			var formData = {};
//			
//			$(inputs).each(function(index, input){
//				var name = $(input).attr("name");
//				var value = $(input).val();
//				formData[name] = value;
//			});
//			
//			var url = $(element).closest("form").attr("action");
//			$.post(url, formData, function(data){
//				console.log(data);
//				callBack(data);
//			});
//			
//			$("#cboxClose").click();
//			
//			event.preventDefault();
//			return false;
//		};
//	});
});

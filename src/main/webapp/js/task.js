/*$(function() {
	$( ".task_list" ).sortable({
		connectWith: ".task_list",
	}, function(event, ui){
		var taskId = ui.item.attr("class");
		console.log(taskId);
		var taskListId = $(this).attr("class");
		console.log(taskListId);
		$.post("./task/moveTask", {"task.id": taskId, "taskList.id": taskListId} );	
	}).disableSelection();
});*/

$(function() {
	$( ".task_list" ).sortable({
		connectWith: ".task_list",
		update: function(event, ui) {
            var result = $(this).sortable('toArray'); //$(this).attr("id");
            var ListOwner = $(this).parent().attr("id");
            alert(result + " - " + ListOwner);
        }
	}).disableSelection();
	
	$( ".task_box" ).dblclick(
			function(){
				$.fn.colorbox({iframe:true, width:"500px", height:"300px", href:"/zeng/addTaskPanel/1"});
				//alert("fununcifou!");
			}
	);
});
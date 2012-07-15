$(function(){
	$(".colorbox").colorbox({
		iframe:true,
		width:"305px",
		height:"230px",
		onClosed:function(){window.location.reload();}
	});
});

$(function() {
	$( ".task_area" ).children().sortable({
		connectWith: ".task_list"
	}).disableSelection();
});
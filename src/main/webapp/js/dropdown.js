$(function(){
	$(".dropdown").live("click",function(){
		var target = $(this).data("target");
		$(".dropdown-target#"+target).toggle();
		console.log(target);
	});
});
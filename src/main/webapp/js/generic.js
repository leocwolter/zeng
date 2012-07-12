$(function(){
	$(".colorbox").colorbox({
		iframe:true,
		width:"305px",
		height:"230px",
		onClosed:function(){window.location.reload();}
	});
});
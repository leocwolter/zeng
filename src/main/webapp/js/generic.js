$(function(){
	$(".colorbox").colorbox({
		iframe:true,
		width:"500px",
		height:"400px",
		onClosed:function(){window.location.reload();}
	});
});

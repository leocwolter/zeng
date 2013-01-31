//Dropdown Bind
$(".dropdown").click(function(){
	var target = $(this).data("target");
	$(this).find(".dropdown-target").toggle();
});
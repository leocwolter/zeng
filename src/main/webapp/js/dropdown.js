//Dropdown Bind
$(".dropdown").click(function(){
	var target = $(this).data("target");
	$(".dropdown-target#"+target).toggle();
});
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- MESSI SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/lib/messi.min.js"/>"></script>
<!-- MODAL BIND SCRIPTS -->
<script type="text/javascript">
	//Modal Bind
	$(".modal").live("click", function(event){
		var url = $(this).attr("href");
		Messi.load(url,{modal:true, modalOpacity:0.4});
		event.preventDefault();
	});
</script>
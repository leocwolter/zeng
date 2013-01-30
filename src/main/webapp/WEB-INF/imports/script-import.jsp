<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- JQUERY -->
<script type="text/javascript" src="<c:url value="/js/lib/jquery.js"/>"></script>
<!-- JQUERY UI -->
<script type="text/javascript" src="<c:url value="/js/lib/jquery-ui-1.8.18.custom.min.js"/>"></script>
<!-- NANO TEMPLATE ENGINE -->
<script type="text/javascript" src="<c:url value="/js/lib/jquery.nano.js"/>"></script>
<!-- DATE FORMAT SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/lib/date.format.js" />"></script>
<!-- JQUERY VALIDATE -->
<script type="text/javascript" src="<c:url value="/js/lib/jquery.validate.js"/>"></script>
<script type="text/javascript">
	//Context definition
	var context = $("#small-logo").attr("href");
	//DragnDrop Bind Configuration
	jQuery.fn.configureZengTaskList = function() {
		$(this).sortable({
			connectWith : $(this),
			receive : function(event, ui) {
				var taskListId = ui.item.closest("ul").data("tasklist-id"),
					taskId = ui.item.data("task-id");
				ui.item.attr("style","");
				$.post(context+"project/category/taskList/task/moveTask", {
					"task.id" : taskId,
					"taskList.id" : taskListId
				});
			}
		});
	};
	//Google Analytics
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-38098928-1']);
	  _gaq.push(['_trackPageview']);
	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();

</script>
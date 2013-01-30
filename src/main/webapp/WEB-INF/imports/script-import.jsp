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
<!-- ZENG-JQUERY -->
<script type="text/javascript" src="<c:url value="/js/lib/zeng-jquery.js"/>"></script>
<script type="text/javascript">
	//Context definition
	var context = $("#small-logo").attr("href");
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
<%@ include file="header.jsp" %>

	<div class="contentBoard">
		<div class="mainContent">
			<table id="contentTable"></table>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			initTable(document.getElementById("contentTable"));
		});
	</script>
</body></html>
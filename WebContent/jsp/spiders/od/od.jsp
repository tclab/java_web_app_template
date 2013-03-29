<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JAVASCRITP -->
<script type="text/javascript" src=<c:url value="/js/jquery/timePicker/jquery.ui.timepicker.js"/>></script>
<script type="text/javascript" src=<c:url value="/js/parametrization/spiders/spiderParametrization.js"/>></script>


<script type="text/javascript">
	$(function() {
		$('#startTime').timepicker({
			showPeriodLabels : false
		});
	});

	$(function() {
		$('#btn_show_timepicker').click(function() {
			i = document.getElementById('startTime');
			$.startTime._showTimepicker(i);

		});
	});
</script>

<!-- Pagetitle -->
<h1 class="pagetitle">Spider OD</h1>

<!-- Content unit - One column -->
<!-- <h1 class="block">1 - Configuration form</h1> -->
<div class="column1-unit">
	<div class="contactform">
		<form name="generalOptions" action="" method="post">
			<fieldset>
				<legend>&nbsp;Data source&nbsp;</legend>
				<p>
					<label for="localDataFolder" class="left">Source folder</label>
					<input type="text" name="localDataFolder" id="localDataFolder" class="field" value="<c:out value="${localDataFolder}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="historicFolder" class="left">Historic folder</label>
					<input type="text" name="historicFolder" id="historicFolder" class="field" value="<c:out value="${historicFolder}"></c:out>" tabindex="1" />
				</p>
			</fieldset>
<!-- 			<fieldset> -->
<!-- 				<legend>&nbsp;Local data&nbsp;</legend> -->
<!-- 				<p> -->
<!-- 					<label for="downFolder" class="left">Download folder</label> -->
<%-- 					<input type="text" name="downFolder" id="downFolder" class="field" value="<c:out value="${downFolder}"></c:out>" tabindex="1" /> --%>
<!-- 				</p> -->
<!-- 			</fieldset> -->
<!-- 			<fieldset> -->
<!-- 				<legend>&nbsp;Frecuency&nbsp;</legend> -->
<!-- 				<p> -->
<!-- 					<label for="frequency" class="left">Frecuency</label> -->
<%-- 					<input type="text" name="frequency" id="frequency" class="field" value="<c:out value="${frequency}"></c:out>" tabindex="1" /> --%>
<!-- 				</p> -->
<!-- 			</fieldset> -->
			<p>
				<input type="button" onclick="javascript:saveOdOptions();" name="genera" id="genera" class="button" value="Save" tabindex="6" />
			</p>
		</form>
	</div>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JAVASCRITP -->
<script type="text/javascript" src=<c:url value="/js/jquery/timePicker/jquery.ui.timepicker.js"/>></script>
<script type="text/javascript" src=<c:url value="/js/parametrization/general/generalOptions.js"/>></script>


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
<h1 class="pagetitle">General options</h1>

<!-- Content unit - One column -->
<!-- <h1 class="block">1 - Configuration form</h1> -->
<div class="column1-unit">
	<div class="contactform">
<!-- 		<form name="generalOptions" action="" method="post"> -->
<!-- 			<fieldset> -->
<!-- 				<legend>&nbsp;Global parameters&nbsp;</legend> -->
<!-- 				<p> -->
<!-- 					<label for="propsLocation" class="left">Properties files location</label> -->
<%-- 					<input type="text" name="propsLocation" id="propsLocation" class="field" value="<c:out value="${propsLocation}"></c:out>" tabindex="1" /> --%>
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label for="startTime" class="left">Start time of the day</label> -->
<%-- 					<input type="text" name="startTime" id="startTime" class="field" value="<c:out value="${startTime}"></c:out>" tabindex="1" /> --%>
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label for="logLocation" class="left">Log location</label> -->
<%-- 					<input type="text" name="logLocation" id="logLocation" class="field" value="<c:out value="${logLocation}"></c:out>" tabindex="1" /> --%>
<!-- 					<input type="file" name="logLocationPath" id="logLocationPath" class="field" value="<c:out value="${logLocation}"></c:out>" tabindex="1" onblur="javascript:document.generalOptions.logLocation.value = document.generalOptions.logLocationPath.value;" onfocus="javascript:document.generalOptions.logLocation.value = document.generalOptions.logLocationPath.value;"/> --%>
<!-- 					<input type="hidden" name="logLocation" id="logLocation" value="" /> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<input type="button" onclick="javascript:saveGeneralProperties()" name="genera" id="genera" class="button" value="Save global" tabindex="6" /> -->
<!-- 				</p> -->
<!-- 			</fieldset> -->
<!-- 		</form> -->
		<form name="dataBaseOptions" action="" method="post">
			<fieldset>
				<legend>&nbsp;Database parameters&nbsp;</legend>
				<p>
					<label for="host" class="left">Host</label>
					<input type="text" name="host" id="host" disabled="disabled" readonly="readonly" class="field" value="<c:out value="${host}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="port" class="left">Port</label>
					<input type="text" name="port" id="port" disabled="disabled" readonly="readonly" class="field" value="<c:out value="${port}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="usr" class="left">User</label>
					<input type="text" name="usr" id="usr" disabled="disabled" readonly="readonly" class="field" value="<c:out value="${usr}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="pss" class="left">Password</label>
					<input type="text" name="pss" id="pss" disabled="disabled" readonly="readonly" class="field" value="<c:out value="${pss}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="dbName" class="left">Data base name</label>
					<input type="text" name="dbName" id="dbName" disabled="disabled" readonly="readonly" class="field" value="<c:out value="${dbName}"></c:out>" tabindex="1" />
				</p>
<!-- 				<p> -->
<!-- 					<input type="button" onclick="javascript:saveDatabaseProperties()" name="dataBase" id="dataBase" class="button" value="Save dataBase" tabindex="6" /> -->
<!-- 				</p> -->
			</fieldset>
		</form>
	</div>
</div>
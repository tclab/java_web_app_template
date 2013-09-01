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
<h1 class="pagetitle">Opcion 1</h1>

<!-- Content unit - One column -->
<h1 class="block">Parameters</h1>
<div class="column1-unit">
	<div class="contactform">
		<form name="generalOptions" action="" method="post">
			<fieldset>
				<legend>&nbsp;General options&nbsp;</legend>
				<p>
					<label for="localDataFolder" class="left">Local sorce folder</label>
					<input type="text" name="localDataFolder" id="localDataFolder" class="field" value="<c:out value="${localDataFolder}"></c:out>" tabindex="1" />
				</p>
			</fieldset>
			<fieldset>
				<legend>&nbsp;Data processing&nbsp;</legend>
				<p>
					<label for="rowIdentifierProgram" class="left">Program row identifier</label>
					<input type="text" name="rowIdentifierProgram" id="rowIdentifierProgram" class="field" value="<c:out value="${rowIdentifierProgram}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="rowIdentifierChannel" class="left">Channel row identifier</label>
					<input type="text" name="rowIdentifierChannel" id="rowIdentifierChannel" class="field" value="<c:out value="${rowIdentifierChannel}"></c:out>" tabindex="1" />
				</p>
			</fieldset>
			<fieldset>
				<legend>&nbsp;Local storage&nbsp;</legend>
<!-- 				<p> -->
<!-- 					<label for="downFolder" class="left">Download folder</label> -->
<%-- 					<input type="text" name="downFolder" id="downFolder" class="field" value="<c:out value="${downFolder}"></c:out>" tabindex="1" /> --%>
<!-- 				</p> -->
				<p>
					<label for="processFolder" class="left">Processing folder</label>
					<input type="text" name="processFolder" id="processFolder" class="field" value="<c:out value="${processFolder}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="historicFolder" class="left">Historic folder</label>
					<input type="text" name="historicFolder" id="historicFolder" class="field" value="<c:out value="${historicFolder}"></c:out>" tabindex="1" />
				</p>
			</fieldset>
<!-- 			<fieldset> -->
<!-- 				<legend>&nbsp;Frequency&nbsp;</legend> -->
<!-- 				<p> -->
<!-- 					<label for="frequency" class="left">Frecuency</label> -->
<%-- 					<input type="text" name="frequency" id="frequency" class="field" value="<c:out value="${frequency}"></c:out>" tabindex="1" /> --%>
<!-- 				</p> -->
<!-- 			</fieldset> -->
			<p>
				<input type="button" onclick="javascript:saveEpgOptions()" name="genera" id="genera" class="button" value="Save" tabindex="6" />
			</p>
		</form>
	</div>
</div>

<h1 class="block">Metadata</h1>
<div class="column1-unit">
	<div class="contactform">
		<form name="epgMetadataValues" action="" method="post">
			<fieldset>
				<legend>&nbsp;Metadata&nbsp;</legend>
				<p>
					<label for="keyName" class="left">Key</label>
					<input type="text" name="keyName" id="keyName" class="field" value="<c:out value="${startTime}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="keyValue" class="left">Description</label>
					<input type="text" name="keyValue" id="keyValue" class="field" value="<c:out value="${startTime}"></c:out>" tabindex="1" />
				</p>
				<p>
					<input type="hidden" name="epgMetaId" id="epgMetaId" value="" />
					<input type="button" onclick="javascript:saveEpgMetadata()" name="save" id="save" class="button" value="Save" tabindex="6" />
					<input type="button" onclick="javascript:cleanEpgMetadata()" name="clean" id="clean" class="button" value="Clean" tabindex="6" />
					<input type="button" onclick="javascript:deleteEpgMetadata()" name="clean" id="clean" class="button" value="Delete" tabindex="6" />
				</p>
			</fieldset>
			
		</form>
	</div>
</div>


<div class="column1-unit">
	<form name="epgMetadataList" action="" method="post">
		<table>
			<tr>
				<th class="top" scope="col">Key</th>
				<th class="top" scope="col">Description</th>
			</tr>
			<c:forEach items="${epgMetadata}" var="meta">
				<tr onclick="javascript:selectEpgMetadata('${meta.id}','${meta.keyName}','${meta.keyValue}');">
					<td><c:out value="${meta.keyName}" /></td>
					<td><c:out value="${meta.keyValue}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>
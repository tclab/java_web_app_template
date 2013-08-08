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
<h1 class="pagetitle">Opcion 5</h1>

<!-- Content unit - One column -->
<h1 class="block">Parameters</h1>
<div class="column1-unit">
	<div class="contactform">
		<form name="generalOptions" action="" method="post">
			<fieldset>
				<legend>&nbsp;Data source&nbsp;</legend>
				<p>
					<label for="orcaLoggin" class="left">Orca loggin url</label>
					<input type="text" name="orcaLoggin" id="orcaLoggin" class="field" value="<c:out value="${orcaLoggin}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="downUrl" class="left">Source url</label>
					<input type="text" name="downUrl" id="downUrl" class="field" value="<c:out value="${downUrl}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="downUrlPage" class="left">Page list url</label>
					<input type="text" name="downUrlPage" id="downUrlPage" class="field" value="<c:out value="${downUrlPage}"></c:out>" tabindex="1" />
				</p>
			</fieldset>
			<fieldset>
				<legend>&nbsp;Data processing&nbsp;</legend>
				<p>
					<label for="rowIdentifierPage" class="left">Page row identifier</label>
					<input type="text" name="rowIdentifierPage" id="rowIdentifierPage" class="field" value="<c:out value="${rowIdentifierPage}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="rowIdentifierVideo" class="left">Video row identifier</label>
					<input type="text" name="rowIdentifierVideo" id="rowIdentifierVideo" class="field" value="<c:out value="${rowIdentifierVideo}"></c:out>" tabindex="1" />
				</p>
			</fieldset>
			<fieldset>
				<legend>&nbsp;Local data&nbsp;</legend>
				<p>
					<label for="downFolder" class="left">Download folder</label>
					<input type="text" name="downFolder" id="downFolder" class="field" value="<c:out value="${downFolder}"></c:out>" tabindex="1" />
				</p>
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
<!-- 				<legend>&nbsp;Frecuency&nbsp;</legend> -->
<!-- 				<p> -->
<!-- 					<label for="frequency" class="left">Frecuency</label> -->
<%-- 					<input type="text" name="frequency" id="frequency" class="field" value="<c:out value="${frequency}"></c:out>" tabindex="1" /> --%>
<!-- 				</p> -->
<!-- 			</fieldset> -->
			<p>
				<input type="button" onclick="javascript:saveVodOptions();" name="genera" id="genera" class="button" value="Save" tabindex="6" />
			</p>
		</form>
	</div>
</div>


<h1 class="block">Page Metadata</h1>
<div class="column1-unit">
	<div class="contactform">
		<form name="pageMetadataValues" action="" method="post">
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
					<input type="hidden" name="pageMetaId" id="pageMetaId" value="" />
					<input type="button" onclick="javascript:savePageMetadata()" name="save" id="save" class="button" value="Save" tabindex="6" />
					<input type="button" onclick="javascript:cleanPageMetadata()" name="clean" id="clean" class="button" value="Clean" tabindex="6" />
					<input type="button" onclick="javascript:deletePageMetadata()" name="clean" id="clean" class="button" value="Delete" tabindex="6" />
				</p>
			</fieldset>
		</form>
	</div>
</div>
<div class="column1-unit">
	<form name="pageMetadataList" action="" method="post">
		<table>
			<tr>
				<th class="top" scope="col">Key</th>
				<th class="top" scope="col">Description</th>
			</tr>
			<c:forEach items="${pageMetadata}" var="meta">
				<tr onclick="javascript:selectPageMetadata('${meta.id}','${meta.keyName}','${meta.keyValue}');">
					<td><c:out value="${meta.keyName}" /></td>
					<td><c:out value="${meta.keyValue}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>

<h1 class="block">Video Metadata</h1>
<div class="column1-unit">
	<div class="contactform">
		<form name="vodMetadataValues" action="" method="post">
			<fieldset>
				<legend>&nbsp;Metadata&nbsp;</legend>
				<p>
					<label for="keyName" class="left">Key</label>
					<input type="text" name="keyName" id="keyName" class="field" value="" tabindex="1" />
				</p>
				<p>
					<label for="contact_firstname" class="left">Description</label>
					<input type="text" name="keyValue" id="keyValue" class="field" value="" tabindex="1" />
				</p>
				<p>
					<input type="hidden" name="vodMetaId" id="vodMetaId" value="" />
					<input type="button" onclick="javascript:saveVodMetadata()" name="saveVod" id="saveVod" class="button" value="Save" tabindex="6" />
					<input type="button" onclick="javascript:cleanVodMetadata()" name="cleanVod" id="cleanVod" class="button" value="Clean" tabindex="6" />
					<input type="button" onclick="javascript:deleteVodMetadata()" name="cleanVod" id="cleanVod" class="button" value="Delete" tabindex="6" />
				</p>
			</fieldset>
		</form>
	</div>
</div>
<div class="column1-unit">
	<form name="vodMetadataList" action="" method="post">
		<table>
			<tr>
				<th class="top" scope="col">Key</th>
				<th class="top" scope="col">Description</th>
			</tr>
			<c:forEach items="${vodMetadata}" var="meta">
				<tr onclick="javascript:selectVodMetadata('${meta.id}','${meta.keyName}','${meta.keyValue}');">
					<td><c:out value="${meta.keyName}" /></td>
					<td><c:out value="${meta.keyValue}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JAVASCRITP -->
<script type="text/javascript" src=<c:url value="/js/engine/engine.js"/>></script>

<!-- Pagetitle -->
<h1 class="pagetitle">Engine parametrization</h1>

<!-- <h1 class="block">1 - Configuration form</h1> -->
<div class="column1-unit">
	<div class="contactform">
		<form name="engineParams" action="FCEngineParametrization" method="post">
			<fieldset>
				<legend>&nbsp;Parameters&nbsp;</legend>
				<p>
					<label for="parameter" class="left">Parameter</label>
					<input type="text" name="parameter" id="parameter" readonly="readonly"  class="field" value="<c:out value="${parameter}"></c:out>" tabindex="1" />
				</p>
				<p>
					<label for="parameterValue" class="left">Value</label>
					<input type="text" name="parameterValue" id="parameterValue" class="field" value="<c:out value="${parameterValue}"></c:out>" tabindex="1" />
				</p>
				<p>
					<input type="button" onclick="javascript:saveProperty()" name="genera" id="genera" class="button" value="Save" tabindex="6" />
					<input type="button" onclick="javascript:clearPropery()" name="genera" id="genera" class="button" value="Clean" tabindex="6" />
				</p>
			</fieldset>
		</form>
	</div>
</div>

<!-- TABLE OF USERS -->
<h1 class="block">Parameters</h1>
<div class="column1-unit">
	<table>
		<tr>
			<th class="top" scope="col">Parameter</th>
			<th class="top" scope="col">value</th>
		</tr>
		<c:forEach items="${engineParams}" var="par">
			<tr onclick="javascript:selectProp('${par.name}','${par.value}');">
				<td><c:out value="${par.name}" /></td>
				<td><c:out value="${par.value}" /></td>
			</tr>
		</c:forEach>
	</table>
<!-- 	<p class="caption"> -->
<!-- 		<strong>Table x.x.</strong> Caption -->
<!-- 	</p> -->
</div>
<hr class="clear-contentunit" />
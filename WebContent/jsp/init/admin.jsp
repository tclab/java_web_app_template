<!-- Pagetitle -->
<!-- <h1 class="pagetitle">Loggin</h1> -->

<!-- Content unit - One column -->
<!-- <h1 class="block">1 - Configuration form</h1> -->
<div class="column1-unit">
	<div class="contactform">
		<form name="urls" action="FCInit.do.save" method="post">
			<fieldset>
				<legend>&nbsp;Url admin&nbsp;</legend>
				
				<p>
					<label for="contact_title" class="left">SPD-Cables:</label> 
					<input type="text" name="spdCables" id="spdCables" class="field" value="${spdCables}" tabindex="1" />
				</p>
				<p>
					<label for="contact_firstname" class="left">Gestion mantenimiento</label>
					<input type="text" name="gestionMantenimiento" id="gestionMantenimiento" class="field" value="${gestionMantenimiento}" tabindex="1" />
				</p>
				<p>
					<label for="contact_firstname" class="left">DiagnoVision-Rueda</label>
					<input type="text" name="diagnosticoVisionRueda" id="diagnosticoVisionRueda" class="field" value="${diagnosticoVisionRueda}" tabindex="1" />
				</p>
				<p>
					<label for="contact_firstname" class="left">DiagnoDefecto-Rueda</label>
					<input type="text" name="diagnosticoDefectoRueda" id="diagnosticoDefectoRueda" class="field" value="${diagnosticoDefectoRueda}" tabindex="1" />
				</p>
				<p>
					<label for="contact_firstname" class="left">Conteo usuarios MM</label>
					<input type="text" name="conteoUsuarios" id="conteoUsuarios" class="field" value="${conteoUsuarios}" tabindex="1" />
				</p>
				<p>
					<label for="contact_firstname" class="left">SPD-Trenes</label>
					<input type="text" name="spdTrenes" id="spdTrenes" class="field" value="${spdTrenes}" tabindex="1" />
				</p>
				<p>
					<label for="contact_firstname" class="left">MODIVIM</label>
					<input type="text" name="modivim" id="modivim" class="field" value="${modivim}" tabindex="1" />
				</p>
				
				
				<p>
					<input type="submit" name="submit" id="submit" class="button" value="Guardar" tabindex="6" />
				</p>
			</fieldset>
		</form>
	</div>
</div>
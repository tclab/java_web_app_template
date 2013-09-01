function saveProperty(){
	var form = document.engineParams;
	
	if (!form.parameter.value || form.parameter.value == '') {
		alert("You must select a property and set its value");
		return;
	}
	
	form.action = "FCEngineParametrization.do.update";
	form.submit();
	
}


function clearPropery(){
	var form = document.engineParams;
	
	form.parameter.value = "";
	form.parameterValue.value = "";
}


function selectProp (prop, value){
	var form = document.engineParams;
	
	form.parameter.value = prop;
	form.parameterValue.value = value;
}
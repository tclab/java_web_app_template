function saveGeneralProperties(){
	var form = document.generalOptions;
	form.action = "FCSpiderParametrization.do.saveGeneralParameters";
	form.submit();
}

function saveDatabaseProperties(){
	var form = document.dataBaseOptions;
	form.action = "FCSpiderParametrization.do.dataBaseOptions";
	form.submit();
}


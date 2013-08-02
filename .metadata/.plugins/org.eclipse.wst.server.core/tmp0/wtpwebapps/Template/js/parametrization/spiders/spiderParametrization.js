function saveEpgOptions(){
	var form = document.generalOptions;
	form.action = "FCSpiderParametrization.do.spiderEpgSave";
	form.submit();
}

function saveOdOptions(){
	var form = document.generalOptions;
	form.action = "FCSpiderParametrization.do.spiderOdSave";
	form.submit();
}

function saveVodOptions(){
	var form = document.generalOptions;
	form.action = "FCSpiderParametrization.do.spiderVodSave";
	form.submit();
}


function saveRatingOptions(){
	var form = document.generalOptions;
	form.action = "FCSpiderParametrization.do.spiderRatingSave";
	form.submit();
}

function saveChannelOptions(){
	var form = document.generalOptions;
	form.action = "FCSpiderParametrization.do.spideChannelSave";
	form.submit();
}


//METADATA
function selectVodMetadata(id, keyName, keyValue){
	var form = document.vodMetadataValues;
	
	form.vodMetaId.value = id;
	form.keyName.value = keyName;
	form.keyValue.value = keyValue;
}

function saveVodMetadata(){
	var form = document.vodMetadataValues;
	
	if (form.vodMetaId.value != null && form.vodMetaId.value != "") {
		form.action = "FCSpiderParametrization.do.spiderVodUpdateMetadata";
		form.submit();
	} else {
		if ((form.keyName.value != null && form.keyName.value != "") && 
			(form.keyValue.value != null && form.keyValue.value != "")) {
			form.action = "FCSpiderParametrization.do.spiderVodSaveMetadata";
			form.submit();
		} else {
			alert("You must specify key and description");
		}
	}
}

function deleteVodMetadata() {
	var form = document.vodMetadataValues;
	
	if (form.vodMetaId.value != null && form.vodMetaId.value != "") {
		if (confirm("Are you shure?")) {
			form.action = "FCSpiderParametrization.do.spiderVodDeleteMetadata";
			form.submit();
		}
		
	} else {
		alert("You must select a metadata");
	}

}

function cleanVodMetadata(){
	var form = document.vodMetadataValues;
	
	form.vodMetaId.value = ""; 
	form.keyName.value = "";
	form.keyValue.value = "";
}

//PAGE
function selectPageMetadata(id, keyName, keyValue){
	var form = document.pageMetadataValues;
	
	form.pageMetaId.value = id; 
	form.keyName.value = keyName;
	form.keyValue.value = keyValue;
}

function savePageMetadata(){
	var form = document.pageMetadataValues;
	
	if (form.pageMetaId.value != null && form.pageMetaId.value != "") {
		form.action = "FCSpiderParametrization.do.spiderPageUpdateMetadata";
		form.submit();
	} else {
		if ((form.keyName.value != null && form.keyName.value != "")
				&& (form.keyValue.value != null && form.keyValue.value != "")) {
			form.action = "FCSpiderParametrization.do.spiderPageSaveMetadata";
			form.submit();
		} else {
			alert("You must specify key and description");
		}
	}
}

function deletePageMetadata() {
	var form = document.pageMetadataValues;
	
	if (form.pageMetaId.value != null && form.pageMetaId.value != "") {
		if (confirm("Are you shure?")) {
			form.action = "FCSpiderParametrization.do.spiderPageDeleteMetadata";
			form.submit();
		}
		
	} else {
		alert("You must select a metadata");
	}

}

function cleanPageMetadata(){
	var form = document.pageMetadataValues;
	
	form.pageMetaId.value = ""; 
	form.keyName.value = "";
	form.keyValue.value = "";
}


//CHANNEL
function deleteChannelMetadata(){
	var form = document.chMetadataValues;
	if (form.channelMetaId.value != null && form.channelMetaId.value != "") {
		if (confirm("Are you shure?")) {
			form.action = "FCSpiderParametrization.do.spiderChannelDeleteMetadata";
			form.submit();
		}
		
	} else {
		alert("You must select a metadata");
	}

}

function selectChannelMetadata(id, keyName, keyValue){
	var form = document.chMetadataValues;
	
	form.channelMetaId.value = id; 
	form.keyName.value = keyName;
	form.keyValue.value = keyValue;
}

function saveChannelMetadata(){
	var form = document.chMetadataValues;

	if (form.channelMetaId.value != null && form.channelMetaId.value != "") {
		form.action = "FCSpiderParametrization.do.spiderChannelUpdateMetadata";
		form.submit();
	} else {
		
		if ((form.keyName.value != null && form.keyName.value != "")
				&& (form.keyValue.value != null && form.keyValue.value != "")) {
			form.action = "FCSpiderParametrization.do.spiderChannelSaveMetadata";
			form.submit();
		} else {
			alert("You must specify key and description");
		}
	}
}

function cleanChannelMetadata(){
	var form = document.chMetadataValues;
	
	form.channelMetaId.value = ""; 
	form.keyName.value = "";
	form.keyValue.value = "";
}

//EPG
function selectEpgMetadata(id, keyName, keyValue){
	var form = document.epgMetadataValues;
	
	form.epgMetaId.value = id; 
	form.keyName.value = keyName;
	form.keyValue.value = keyValue;
}

function deleteEpgMetadata() {
	var form = document.epgMetadataValues;
	
	if (form.epgMetaId.value != null && form.epgMetaId.value != "") {
		if (confirm("Are you shure?")) {
			form.action = "FCSpiderParametrization.do.spiderEpgDeleteMetadata";
			form.submit();
		}
		
	} else {
		alert("You must select a metadata");
	}

}

function saveEpgMetadata(){
	var form = document.epgMetadataValues;

	if (form.epgMetaId.value != null && form.epgMetaId.value != "") {
		form.action = "FCSpiderParametrization.do.spiderEpgUpdateMetadata";
		form.submit();
	} else {
		if ((form.keyName.value != null && form.keyName.value != "")
				&& (form.keyValue.value != null && form.keyValue.value != "")) {
			form.action = "FCSpiderParametrization.do.spiderEpgSaveMetadata";
			form.submit();
		} else {
			alert("You must specify key and description");
		}
	}
}

function cleanEpgMetadata(){
	var form = document.epgMetadataValues;
	
	form.epgMetaId.value = ""; 
	form.keyName.value = "";
	form.keyValue.value = "";
}
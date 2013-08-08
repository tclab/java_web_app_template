function selectUser(username, password, admin){
	var form = document.users;
	form.admin.checked = false;
	form.username.value = username; 
	form.password.value = password;
	form.admin.checked = admin == 'true' ? true : false;
}


function cleanUserInfo(){
	var form = document.users;
	form.admin.checked = false;
	form.username.value = ''; 
	form.password.value = '';
}


function saveUser(){
	var form = document.users;
	
	if (!form.username.value && form.username.value == '') {
		alert("The username must be seted");
		return;
	}
	
	if (!form.password.value && form.password.value == '') {
		alert("The password must be seted");
		return;
	}
	
	form.action = "FCUserAdmin.do.saveUser"; 
	form.submit();
}


function deleteUser(){
	var form = document.users;
	
	if (!form.username.value && form.username.value == '') {
		alert("You need to select a user");
		return;
	}
	
	form.action = "FCUserAdmin.do.deleteUser"; 
	form.submit();
} 

function selectAdminRole(){
	var form = document.users;
	
	if (form.admin.checked == true) {
		form.user.checked = true;
		form.user.disabled = true;
	} else {
		form.user.disabled = false;
	}
	
}
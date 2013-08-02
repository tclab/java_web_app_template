function selectUser(username, password, admin, user){
	var form = document.users;
	
	form.user.checked = false ;
	form.admin.checked = false;
	
	form.username.value = username; 
	form.password.value = password;
	
	form.user.checked = user == 'true' ? true : false ;
	form.admin.checked = admin == 'true' ? true : false;
	
	if (form.admin.checked == true) {
		form.user.checked = true;
		form.user.disabled = true;
	} else {
		form.user.disabled = false;
	}
}


function cleanUserInfo(){
	var form = document.users;
	
	form.user.checked = false ;
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
	if (form.user.checked == false && form.admin.checked == false) {
		alert("You need to select one role at least");
		return;
	}
	
	form.user.disabled = false;
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reservas</title>
<script type="text/javascript">
function redirect(){
	var form = document.init;
	form.action = "controller/FCInit";
	form.submit();
}
</script>

</head>
<body onload="javascript:redirect();">
<form name="init" action=""></form>

</body>
</html>
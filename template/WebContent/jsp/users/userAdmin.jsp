<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JAVASCRITP -->
<script type="text/javascript" src=<c:url value="/js/users/users.js"/>></script>

<!-- Pagetitle -->
<h1 class="pagetitle">User administration</h1>

<!-- USER PARAMETERS -->
<h1 class="block">User attributes</h1>
<div class="column1-unit">
	<div class="contactform">
		<form name="users" action="FCUserAdmin" method="post">
			<fieldset>
				<legend>&nbsp;User&nbsp;</legend>
				<p>
					<label for="username" class="left">Username:</label> 
					<input type="text" name="username" id="username" class="field" value="" tabindex="1" />
				</p>
				<p>
					<label for="password" class="left">Password:</label> 
					<input type="text" name="password" id="password" class="field" value="" tabindex="1" />
				</p>
<!-- 				<p> -->
<!-- 					<label for="user" class="left">USER</label>  -->
<!-- 					<input type="checkbox" name="user" id="user" class="left" value="ROLE_USER" /> -->
<!-- 				</p> -->
				<p>
					<label for="admin" class="left">ADMIN</label> 
<!-- 					<input type="checkbox" name="admin" id="admin" onchange="javascript:selectAdminRole();" class="left" value="ROLE_ADMIN" /> -->
					<input type="checkbox" name="admin" id="admin" class="left" value="ROLE_ADMIN" />
				</p>
				<p>
					<input type="hidden" name="pageMetaId" id="pageMetaId" value="" />
					<input type="button" onclick="javascript:saveUser()" name="save" id="save" class="button" value="Save" tabindex="6" />
					<input type="button" onclick="javascript:deleteUser()" name="clean" id="clean" class="button" value="Delete" tabindex="6" />
					<input type="button" onclick="javascript:cleanUserInfo()" name="clean" id="clean" class="button" value="Clean" tabindex="6" />
				</p>
			</fieldset>
		</form>
	</div>
</div>

<!-- TABLE OF USERS -->
<h1 class="block">Users</h1>
<div class="column1-unit">
	<table>
		<tr>
			<th class="top" scope="col">Username</th>
			<th class="top" scope="col">Password</th>
			<th class="top" scope="col">Admin</th>
		</tr>
		<c:forEach items="${userList}" var="userInfo">
			<tr onclick="javascript:selectUser('${userInfo.username}','${userInfo.password}', '${userInfo.admin}');">
				<td><c:out value="${userInfo.username}" /></td>
				<td><c:out value="${userInfo.password}" /></td>
				<td><c:out value="${userInfo.admin}" /></td>
			</tr>
		</c:forEach>
	</table>
<!-- 	<p class="caption"> -->
<!-- 		<strong>Table x.x.</strong> Caption -->
<!-- 	</p> -->
</div>
<hr class="clear-contentunit" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<dl class="nav3-grid">
	<c:forEach items="${menuItems}" var="menuItem">
		<h4 class="menu<c:if test="${not empty menuItem.url}">NoExpand</c:if>"><a href="${menuItem.url}">${menuItem.name}</a></h4>
		
		<div class="panel">
			<ul>
				<c:forEach items="${menuItem.childItems}" var="child">
					<li><a href="${child.url}">${child.name}</a></li>
				</c:forEach>
			</ul>	
		</div>
	</c:forEach>
		
</dl>
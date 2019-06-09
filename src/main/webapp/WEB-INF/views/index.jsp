<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${user.username }</title>
</head>
<body>
	<dl>
		<c:forEach var="menu" items="${LOGIN_USER.menus }">
			<dt data-id="${menu.id }" data-pid="${menu.pid }">${menu.name }</dt>
			<c:forEach var="child" items="${menu.children }">
				<dd data-id="${child.id }" data-pid="${menu.pid }">${child.name }</dd>
			</c:forEach>
		</c:forEach>
	</dl>
	
	<c:forEach var="element" items="${LOGIN_USER.elements }">
		<c:if test="${element.eleno eq 'grant' }">
			<button data-eleno="${element.eleno }">授权</button>
		</c:if>
	</c:forEach>
	
	<button>新增</button>
	
</body>
</html>
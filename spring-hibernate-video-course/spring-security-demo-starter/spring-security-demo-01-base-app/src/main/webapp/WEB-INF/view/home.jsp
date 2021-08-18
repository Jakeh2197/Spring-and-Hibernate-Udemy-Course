<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<title>Demo App</title>
	</head>
	<body>
		<h1>Made it</h1>
		
		<hr>
		
			<!-- display user name and role -->
			User name: <security:authentication property="principal.username" />
			
			<br/><br/>
			
			Role(s): <security:authentication property="principal.authorities" />
			
			<hr>
			
			<security:authorize access="hasRole('MANAGER')">
			
				<!-- Add link to point to /managers -->
				<a href="${pageContext.request.contextPath}/managers">Managers Page</a>
				
			</security:authorize>
			
			
			<br/>
			
			<security:authorize access="hasRole('ADMIN')">
			
				<!-- Add link to point to /admins -->
				<a href="${pageContext.request.contextPath}/admins">Admins Page</a>
				
			</security:authorize>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			
			<input type="submit" value="Logout" />
			
		</form:form>
	</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Account Setup</title>
		
		<style>
			.error {color:red}
		</style>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="account">
			Enter savings account starting balance: <form:input path="savingsAccountBalance" />
			<form:errors path="savingsAccountBalance" cssClass="error" />
			
			<br/><br/>
			
			Enter checking account starting balance: <form:input path="checkingAccountBalance" />
			<form:errors path="checkingAccountBalance" cssClass="error" />
			
			<br/><br/>
			
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>
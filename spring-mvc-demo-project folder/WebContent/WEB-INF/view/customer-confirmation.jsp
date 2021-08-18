<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Customer Registration Confirmation</title>
	</head>
	<body>
		The customer: <b>${customer.firstName} ${customer.lastName}</b> has successfully been registered. 
		
		<br/><br/>
		
		Free passes: ${customer.freePasses}
		
		<br/><br/>
		
		Postal code: ${customer.postalCode}
		
		<br/><br/>
		
		Course code: ${customer.courseCode}
	</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Student Confirmation</title>
	</head>
	<body>
		The student is confirmed: ${student.firstName} ${student.lastName}
		<br/><br/>
		The student is from: ${student.country}
		<br/><br/>
		The students favorite programming language is: ${student.favoriteLanguage}
		<br/><br/>
		Students operating system experience: 
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}">
				<li>${temp}</li>
			</c:forEach>
		</ul>
	</body>
</html>
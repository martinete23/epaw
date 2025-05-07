<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>	

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css/style.css">
<title>Register Form</title>
</head>
<body>

	<form id="registerForm" action="Register" method="POST">

		<label for="name">Name:</label> 
		<input type="text" id="name" name="name" required minlength="5" maxlength="20" value="${user.name}" title="Username must be beetween 5 and 20 characters."/> 
		
		<label for="password">Password:</label> 
		<input type="password" id="password" name="password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*]).{8,}$" value="${user.password}" title="Minimum 8 characters, including uppercase, number, and special character: *[!@#$%^&*]" />

		<label for="confirmPassword">Repeat password:</label> 
		<input type="password" id="confirmPassword" name="confirmPassword" required value="${user.password}" title="Passwords must match" />
		
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" value="${user.email}" title="Valid email format."/>
		
		<label for="birthday">Birthday:</label>
		<input type="date" id="birthday" name="birthday" required min="1925-01-01" max="2011-01-01" value="${user.birthday}" title="You must be at least 14 years old to register."/>
		
		<label for="gender">Gender:</label>
		<select id="gender" name="gender">
			<option value="">--Select a gender--</option>
			<option value="male">Male</option>
			<option value="female">Female</option>
		</select>
		
		<label for="platform">Platform:</label>
		<select id="platform" name="platform">
			<option value="">--Select a platform--</option>
			<option value="playstation">PlayStation</option>
			<option value="xbox">Xbox</option>
			<option value="nintendo">Nintendo</option>
			<option value="pc">PC</option>
		</select>
		
		<label for="communitiesOfInterest">Communities that interest you:</label>
		<select id="communitiesOfInterest" name="communitiesOfInterest" multiple size="4">
			<option value="minecraft">Minecraft</option>
			<option value="sims">Sims</option>
			<option value="fifa">Fifa</option>
			<option value="callofduty">Call of Duty</option>
		</select>
		
		<button type="submit">Send</button>
		
	</form>
	
	<!--  
	<ul>
		<c:forEach var="error" items="${errors}">
			<li>${error.key} -> ${error.value}</li>
		</c:forEach>
	</ul>
	-->
	
	<script>
		// Server errors to JS object
	    const serverErrors = {
	      <c:forEach var="error" items="${errors}">
	        "${error.key}": "${error.value}",
	      </c:forEach>
	    };
	</script>
	<script src="js/validation.js"></script>


</body>
</html>
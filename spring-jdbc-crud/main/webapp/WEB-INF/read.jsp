<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Read</title>
</head>
<body>
	<h2>Spring MVC</h2>
	<p><strong>Employee List is Here | <a href="create.jsp">Click for Create</a></strong></p>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Department</th>
			<th>Action</th>
		</tr>
		<c:forEach var="employee" items="${listEmployee}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.department}</td>
		    	<td><a href="../SpringMvcJdbc/update/<c:out value='${employee.id}'/>">Update</a> | <a
					href="../SpringMvcJdbc/delete/<c:out value='${employee.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
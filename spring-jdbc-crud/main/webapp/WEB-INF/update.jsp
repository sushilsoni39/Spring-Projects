<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Spring MVC</h2>
	<p><strong>Update Here | <a href="../SpringMvcJdbc/read">Click for Read</a></strong></p>
<form action="../update" method="post">
<pre>
<c:forEach var="employee" items="${listEmployee}">

Id:    	<input type="text" name="dispId" value="${employee.id}" disabled="disabled"/>
		<input type="hidden" name="id" value="${employee.id}"/>
Name:  	<input type="text" name="name" value="${employee.name}" />

Department: 	<input type="text" name="department" value="${employee.department}" />

        <input type="submit" value="Update" />
</c:forEach>
</pre>
</form>
${msg}
</body>
</html>
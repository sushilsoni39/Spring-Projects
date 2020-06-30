<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Secure page</title>    
	</head>
	<body>
		<h1>Title : ${title}</h1>
		<h1>Message : ${message}</h1>
		
		<!-- displaying the logged in user details. -->
		<c:if test="${pageContext.request.userPrincipal.name != null}">         
	       <span>Welcome: ${pageContext.request.userPrincipal.name}</span> | <span><a id="logout" href="${pageContext.servletContext.contextPath}/logout">Logout</a></span>
	    </c:if>
	</body>
</html>
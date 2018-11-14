<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error page</title>
</head>
<body>

<p>${errorMessage}</p>

<c:if test = "${resendLink== true}" >	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="/resendemail.htm" method="POST">
		User Email:<input type="text" name="username" size="30" required="required" />
		<br/>
		<input type="submit" value="Resend Email" />
	</form>	
</c:if>
<p><a href="/TripPlanning">click here to go main page</a></p>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${message}

<p><a href="/TripPlanning">click here to go main page</a></p>
<c:if test="${planLink eq 'true'}">
	<p><a href="/TripPlanning/plan/view-all-plans.htm">click here to go to discovery</a></p>
</c:if>
</body>
</html>
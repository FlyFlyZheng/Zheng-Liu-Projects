<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Plan List</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/TripPlanning/resources/css/main-cute.css" />
</head>
<body class="no-sidebar">

<!-- Header -->
<div id="header-wrapper">
       <div id="header">
        <!-- Logo -->
        <h1><a href="index.html">Trip Planning</a></h1>
        <!-- Nav -->
        <nav id="nav">
            <ul>
                <li><a href="/TripPlanning/user/dashboard.htm">Home</a></li>
                <li><a href="/TripPlanning/user/function-search-place.htm">Search Place</a></li>
                <li class="current">
                    <a href="#">Discovery</a>
                    <ul>
                        <li><a href="/TripPlanning/plan/view-all-plans.htm">All Plans</a></li>
                        <li><a href="/TripPlanning/plan/becomePlanner.htm">Become A Planner</a></li>
                        <li><a href="/TripPlanning/plan/edit.htm">Start a Plan</a></li>
                    </ul>
                </li>
                <li><a href="/TripPlanning/user/fav.htm">My Places</a></li>
                <li><a href="/TripPlanning/logout.htm">Log out</a></li>
            </ul>
        </nav>
    </div>
</div>

<div id="main-wrapper">
	<div class="container">
			<article class="box post">
				<a href="#" class="image featured"><img src="/TripPlanning/resources/images/face.jpg" alt="" /></a>

				<c:if test="${display=='ALL'}" >
				<header>
					<h3>${message}</h3>
					<h2>ALL PLANS</h2>
				</header>
				</c:if>

				<table  id="searchTable" class="table" style="{font-size:16px;border-bottom-style:solid;width:100%;}">
					<thead class="thead-dark">
                        <tr>
                            <td><b>#</b></td>
                            <td><b>Plan name</b></td>
                            <td><b>Description</b></td>
                            <td><b>Author</b></td>
                            <td><b>Like Number</b></td>
                            <td><b>DownLoad</b></td>
                            <td><b>Detail</b></td>
                        </tr>
                     </thead>
                     <tbody>
                     	<c:set var="num" value="1"/>
                        <c:forEach var="p" items="${plans}">
                        	<tr>
							  	<td>${num}</td>
								<td>${p.planName}</td>
								<td>${p.planDescription}</td>
								<td>${p.user.username}</td>
								<td>${p.likeNum}</td>
								<td><a href="/TripPlanning/plan/download.htm?id=${p.planId}"><i class='icon fas fa-download'></i></a></td>
								<td><a href="/TripPlanning/plan/Detail.htm?id=${p.planId}"><i class='icon fas fa-caret-right'></i></a></td>
							</tr>
							<c:set var="num" value="${num+1}"/>
                        </c:forEach>
                        </tbody>
				</table>

		</article>

	</div>
</div>



<script src="/TripPlanning/resources/js/jquery.min.js"></script>
<script src="/TripPlanning/resources/js/jquery.dropotron.min.js"></script>
<script src="/TripPlanning/resources/js/skel.min.js"></script>
<script src="/TripPlanning/resources/js/skel-viewport.min.js"></script>
<script src="/TripPlanning/resources/js/util.js"></script>
<script src="/TripPlanning/resources/js/main.js"></script>

</body >
</html>

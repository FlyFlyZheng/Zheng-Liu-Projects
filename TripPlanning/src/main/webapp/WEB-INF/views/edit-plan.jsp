<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Plan</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/TripPlanning/resources/css/main-cute.css" />
	<script defer src="https://use.fontawesome.com/releases/v5.5.0/js/all.js" integrity="sha384-GqVMZRt5Gn7tB9D9q7ONtcp4gtHIUEW/yG7h98J7IpE3kpi+srfFyyB/04OV6pG0" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=Google_Map_API_Key&libraries=places"></script>
    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
    <script type="text/javascript">
    formValid = function(){
    	var from1 = document.getElementById("from1");
        var from2 = document.getElementById("from2");
        if((!from1.checked)&&(!from2.checked)){
            document.getElementById("from_error").innerText = "Please select a from location!"
            return false;
        }else if((from2.checked)&&(document.getElementById("otherLocation").value == "")){
            document.getElementById("from_error").innerText = "Please Specify other location!"
            return false;
        }else{
        	return true;
        }
    }

    var map;

    initMap = function(){
    	 var options = {
    	       	zoom:13,
    	        center:{lat: ${centerLocation.lat}, lng:${centerLocation.lng} }
    	 };
    	 map = new google.maps.Map(document.getElementById("map"),options);
    }

    addMarker = function(lat,lng,address,icon){
    	var marker = new google.maps.Marker({
            position:{lat:lat,lng:lng},
            //icon:props.iconImage,
            map:map
        });
    	if(icon!=null){
            //set icon image
            var image = {
            		url:icon,
            		scaledSize: new google.maps.Size(20, 20)
            };
            marker.setIcon(image);
        };
        //check for content
        if(address!=null){
            var infoWindow = new google.maps.InfoWindow({
                content:address
            });
            marker.addListener('click',function(){
                infoWindow.open(map,marker);
            });
        };
    }

    autoComplete= function(){
        var input = document.getElementById('otherLocation');
        autocomplete = new google.maps.places.Autocomplete(input);
    }

    autoComplete_keyword= function(){
        var input = document.getElementById('keyword');
        autocomplete = new google.maps.places.Autocomplete(input);
    }
    </script>
</head>
<body>
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

<!-- Main Content -->
<div class="container">


    <!-- Map -->
    <div class="14u 20u(mobile)">
    <section class="box">
    <div id="map" style="background-color:gray;"></div>
    </section>
    </div>

     <div class="row">

    <!-- Search Form -->
    <div class="3u 14u(mobile)">
    <section class="box">
         <a href="#" class="image featured"><img src="/TripPlanning/resources/images/face.jpg" alt="" /></a>
         <header><h3>Search Place</h3></header>
         <form action="/TripPlanning/plan/search-place.htm" method="post" onsubmit="return formValid()">
         	<lable><b>keyword:</b></lable>
            <input type="text" name="keyword" id="keyword" required="required"/><br/>

            <lable><b>From:</b></lable><br/>
            <input type="radio" value="currentLocation" name="from" id="from1"/>Current Location:<br/>
            <input type="radio" value="otherLocation" name="from" id="from2">Other. Please Specify:<br/>
            <input type="text" name="otherLocation" id="otherLocation" value=""/><br/>
            <lable><b id="from_error" style="color: red"></b></lable><br/>

            <input type="submit" value="search" />
         </form>
    </section>
    </div>

    <div class="9u 12u(mobile) important(mobile)">
    <!-- Plan places -->
    <section class="box">
    	<header><h2>Your plan</h2></header>
    	<ul class="dates">
    		<c:set var="i" value="1"/>
    		<c:forEach var="p" items="${plan_places}">
    		<li>
				<span class="date">Step<strong>${i}</strong></span>
				<h3>
					${p.value.name}  -
					<a href="/TripPlanning/plan/remove-from-plan.htm?placeid=${p.value.placeId}">remove</a>
				</h3>
				<p onclick="addMarker(${p.value.lat},${p.value.lng},'${p.value.address}','${p.value.icon}')">${p.value.address}</p>
			</li>
			<c:set var="i" value="${i+1}" />
    		</c:forEach>
		</ul>
		<a href="/TripPlanning/plan/edit-plan-text.htm" class="button">Continue To Next Step</a>
    </section>
    <!-- Result List -->
    <section class="box">
    	<header><h3>Result List</h3></header>
    	<!-- Result table -->
    	<table  id="searchTable" class="table" style="{font-size:16px;border-bottom-style:solid;width:100%;}">
        	<thead class="thead-dark">
				<tr>
                	<td><b>#</b></td>
                    <td><b>Category</b></td>
                    <td><b>Name</b></td>
                    <td><b>Address</b></td>
                    <td><b>Add</b></td>
                 </tr>
            </thead>
            <tbody>
                <c:set var="num" value="1"/>
                <c:forEach var="p" items="${places_plan_search}">
                	<tr>
						<td>${num}</td>
						<td><div style="width:20px; height:20px;"><img src='${p.icon}' width="100%" height="100%"/></div></td>
						<td>${p.name}</td>
						<td>${p.address}</td>
						<td><a href="/TripPlanning/plan/add-to-plan.htm?placeid=${p.placeId}"><i class='icon fas fa-plus-circle'></i></a></td>
					</tr>
					<input type="hidden" name="marker" value="${p.lat},${p.lng}"/>
					<c:set var="num" value="${num+1}"/>
				</c:forEach>
            </tbody>
        </table>
    </section>
    </div>

	</div>
</div>


<script type="text/javascript">



initMap();
autoComplete_keyword();
autoComplete();
</script>



<script src="/TripPlanning/resources/js/jquery.min.js"></script>
<script src="/TripPlanning/resources/js/jquery.dropotron.min.js"></script>
<script src="/TripPlanning/resources/js/skel.min.js"></script>
<script src="/TripPlanning/resources/js/skel-viewport.min.js"></script>
<script src="/TripPlanning/resources/js/util.js"></script>
<script src="/TripPlanning/resources/js/main.js"></script>
</body>
</html>

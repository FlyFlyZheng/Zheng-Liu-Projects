<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>user-search-place</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../resources/css/main-cute.css" />
	<script defer src="https://use.fontawesome.com/releases/v5.5.0/js/all.js" integrity="sha384-GqVMZRt5Gn7tB9D9q7ONtcp4gtHIUEW/yG7h98J7IpE3kpi+srfFyyB/04OV6pG0" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBmEUjAPmoWx5cMarGgWqTPtLzddFl4GVU&libraries=places"></script>
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
        var reg=/^\d+$/g;
        if((!from1.checked)&&(!from2.checked)){
            document.getElementById("from_error").innerText = "Please select a from location!"
            return false;
        }else if((from2.checked)&&(document.getElementById("otherLocation").value == "")){
            document.getElementById("from_error").innerText = "Please Specify other location!"
            return false;
        }else if((document.getElementById("time").value!="")&&(reg.test(document.getElementById("time").value)!=true)){
            document.getElementById("time_error").innerText = "Please input a valid time!"
            return false;
        }else{
            return true;
        }
    }
    
    autoComplete= function(){
        var input = document.getElementById('otherLocation');
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
            	<!-- SEARCH HEADER -->
            	<c:if test="${page=='search_place'}" >
                <li><a href="/TripPlanning/user/dashboard.htm">Home</a></li>
                <li class="current"><a href="/TripPlanning/user/function-search-place.htm">Search Place</a></li>
                <li>
                    <a href="#">Discovery</a>
                    <ul>
                        <li><a href="#">All Plans</a></li>
                        <li><a href="#">Become A Planner</a></li>
                        <li><a href="#">My Plans</a></li>
                    </ul>
                </li>
                <li><a href="/TripPlanning/user/fav.htm">My Places</a></li>
                <li><a href="/TripPlanning/logout.htm">Log out</a></li>
                </c:if>
                
                <!-- FAV HEADER -->
            	<c:if test="${page=='fav_place'}" >
                <li><a href="/TripPlanning/user/dashboard.htm">Home</a></li>
                <li><a href="/TripPlanning/user/function-search-place.htm">Search Place</a></li>
                <li>
                    <a href="#">Discovery</a>
                    <ul>
                        <li><a href="#">All Plans</a></li>
                        <li><a href="#">Become A Planner</a></li>
                        <li><a href="#">My Plans</a></li>
                    </ul>
                </li>
                <li class="current"><a href="/TripPlanning/user/fav.htm">My Places</a></li>
                <li><a href="/TripPlanning/logout.htm"">Log out</a></li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>

<!-- Main Content -->
<div class="container">
    <div class="row">
    
        <c:if test="${page=='search_place'}" >
        <!-- Left search form -->
        <div class="3u 14u(mobile)">
            <section class="box">
                <a href="#" class="image featured"><img src="../resources/images/face.jpg" alt="" /></a>
                <header>
                    <h3>Search Place</h3>
                </header>

                <form action="function-search-place.htm" method="post" onsubmit="return formValid()">
                    <lable><b>keyword:</b></lable>
                    <input type="text" name="keyword" id="keyword" required="required"/><br/>

                    <lable><b>Travel Mode:</b></lable>
                    <div class="select-wrapper">
                        <select name="travelMode" id="travelMode">
                        <!-- default by car -->
                        <option value="driving">- Default -</option>
                        <option value="driving">Driving</option>
                        <option value="walking">Walking</option>
                        <option value="bicycling">Bicycling</option>
                        <option value="transit">Transit</option>
                        </select>
                    </div><br/>

                    <lable><b>Time:</b></lable><br/>
                    <input type="text" name="time" id="time"/><br/>
                    <lable><b id="time_error" style="color: red"></b></lable><br/>
                    

                    <lable><b>From:</b></lable><br/>
                    <input type="radio" value="currentLocation" name="from" id="from1"/>Current Location:<br/>
                    <input type="radio" value="otherLocation" name="from" id="from2">Other. Please Specify:<br/>
                    <input type="text" name="otherLocation" id="otherLocation" value=""/><br/>
                    <lable><b id="from_error" style="color: red"></b></lable><br/>

                    <input type="submit" value="search" />
                </form>
            </section>
        </div>
        </c:if>
	
		<c:if test="${page=='search_place'}" >
		<!-- Right Result form -->
		<div class="9u 12u(mobile) important(mobile)">
			<!-- Map -->
			<section class="box">
				<div id="map" style="background-color:gray;"></div>
			</section>
            <!-- Result List -->
            <article class="box post">				
                    <header>
                    <h2>Search Result</h2>
                </header>    
					<!-- Result table -->
                    <table  id="searchTable" class="table" style="{font-size:16px;border-bottom-style:solid;width:100%;}">
                        <thead class="thead-dark">
                        <tr>
                            <td><b>#</b></td>
                            <td><b>Category</b></td>
                            <td><b>Name</b></td>
                            <td><b>Address</b></td>
                            <td><b>Favoriate</b></td>
                            <td><b>Detail</b></td>
                        </tr>
                        </thead>
                        <tbody>		
                        
                        <c:set var="num" value="1"/>
                        <c:forEach var="p" items="${places}">
                        	<tr>
							  	<td>${num}</td>
								<td><div style="width:20px; height:20px;"><img src='${p.icon}' width="100%" height="100%"/></div></td>
								<td>${p.name}</td>
								<td>${p.address}</td>
								<td><a href="/TripPlanning/user/add-to-fav.htm?placeid=${p.placeId}"><i class='icon far fa-star'></i></a></td>
								<td><a href="/TripPlanning/user/placeDetail.htm?placeid=${p.placeId}&&fromLocationLat=${currentLocation.lat}&&fromLocationLng=${currentLocation.lng}"><i class='icon fa fa-chevron-circle-right'></i></a></td>
							</tr>
							<input type="hidden" name="marker" value="${p.lat},${p.lng}"/>
							<c:set var="num" value="${num+1}"/>
							
                        </c:forEach>				
                        </tbody>
                    </table>
            </article>
           
        </div>
   		</c:if>
   		
   		<c:if test="${page=='fav_place'}" >
		<!-- Right Result form -->
		<div class="12u 12u(mobile) important(mobile)">
			<!-- Map -->
			<section class="box">
				<div id="map" style="background-color:gray;"></div>
			</section>
            <!-- Result List -->
            <article class="box post">				
                    <header>
                    <h2>Search Result</h2>
                </header>    
					<!-- Result table -->
                    <table  id="searchTable" class="table" style="{font-size:16px;border-bottom-style:solid;width:100%;}">
                        <thead class="thead-dark">
                        <tr>
                            <td><b>#</b></td>
                            <td><b>Category</b></td>
                            <td><b>Name</b></td>
                            <td><b>Address</b></td>
                            <td><b>Remove</b></td>
                            <td><b>Detail</b></td>
                        </tr>
                        </thead>
                        <tbody>		
                        
                        <c:set var="num" value="1"/>
                        <c:forEach var="p" items="${places}">
                        	<tr>
							  	<td>${num}</td>
								<td><div style="width:20px; height:20px;"><img src='${p.icon}' width="100%" height="100%"/></div></td>
								<td>${p.name}</td>
								<td>${p.address}</td>
								<td><a href="/TripPlanning/user/remove-from-fav.htm?placeid=${p.placeId}"><i class='icon fas fa-trash-alt'></i></a></td>
								<td><a href="/TripPlanning/user/placeDetail.htm?placeid=${p.placeId}&&fromLocationLat=${currentLocation.lat}&&fromLocationLng=${currentLocation.lng}"><i class='icon fa fa-chevron-circle-right'></i></a></td>
							</tr>
							<input type="hidden" name="marker" value="${p.lat},${p.lng}"/>
							<c:set var="num" value="${num+1}"/>
							
                        </c:forEach>				
                        </tbody>
                    </table>
            </article>
           
        </div>
   		</c:if>
   		
   		
    </div>
</div>


<script type="text/javascript">
	var map;
                        
    initMap = function(){
         var options = {
         	zoom:13,
            center:{lat: ${currentLocation.lat}, lng:${currentLocation.lng} }
         };
         map = new google.maps.Map(document.getElementById("map"),options);
         var marker_center = new google.maps.Marker({
             position: {lat: ${currentLocation.lat}, lng:${currentLocation.lng} },
             map: map
           });
         var infowindow_center = new google.maps.InfoWindow({
        	    content: "Your current Location"
        	  });
         marker_center.addListener('click', function() {
        	 infowindow_center.open(map, marker_center);
        	  });
         
         var markers = document.getElementsByName("marker");
         for(var i=0; i<markers.length; i++){
        	 var lat = markers[i].value.split(",")[0]
        	 var lng = markers[i].value.split(",")[1]
        	 addMarker(lat,lng,i);
         }
         
         function addMarker(lat,lng,id){
        	 
        	 var marker = new google.maps.Marker({
        		 position:{lat:parseFloat(lat), lng:parseFloat(lng)},
        		 map:map
        	 });
        	 var infowindow = new google.maps.InfoWindow({
        		 content:String(i)
        	 });
        	 marker.addListener('click', function() {
            	 infowindow.open(map, marker);
             });
         }
        	 
        	 
     
         
    }
    
    
    initMap();         
    autoComplete();
</script>


<!-- Scripts -->
<script src="/TripPlanning/resources/js/jquery.min.js"></script>
<script src="/TripPlanning/resources/js/jquery.dropotron.min.js"></script>
<script src="/TripPlanning/resources/js/skel.min.js"></script>
<script src="/TripPlanning/resources/js/skel-viewport.min.js"></script>
<script src="/TripPlanning/resources/js/util.js"></script>
<script src="/TripPlanning/resources/js/main.js"></script>
</body>
</html>
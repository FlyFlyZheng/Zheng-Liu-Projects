<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<title>Edit Plan Text</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/TripPlanning/resources/css/main-flow.css" />
<style>
	.text{
		width: 100%;
	    outline:none;
        background:transparent;
        border:none
     }
</style>
<script type="text/javascript">
getPlaceId = function (num,mode){
	$.get("/TripPlanning/plan/get-durations.htm",{
		number:num,
		travelMode:mode
	},function(data){
		document.getElementById(num.toString()).value = data;
	})
}
</script>
</head>
<body>


<section id="header">
    <header>
        <h1>Trip Plan</h1>
        <p>Give your plan more details</p>
    </header>
    <footer>
        <a href="#first" class="button style2 scrolly-middle">Begin</a>
    </footer>
</section>

<form action="/TripPlanning/plan/save-plan.htm" method="post" >

<c:if test = "${plan_places_num gt 0}">
<c:set var="num" value="1"/>
<c:forEach items="${plan_places}" var="place">
<article id="${place.key}" class="container box style1 right">
    <a href="#" class="image fit"><img src="images/pic01.jpg" alt="" /></a>
    <div class="inner">
        <header>
            <h2>${place.value.name}</h2>
        </header>
        <p>${place.value.address}</p>
        <div class="12u$">
            <input type="number" name="stayTime" placeholder="Estimate to Stay" class="text"></input>
        </div>
        <br/>
        <div class="12u$">
            <input type="text" name="placeDescription" placeholder="description" style="height: 200px" class="text" />
        </div>   
    </div>
</article>

<c:if test="${num lt plan_places_num}">
<article class="container box style2">
    <header>
        <h2>Select a Travel mode</h2>
        <select name="travelMode" id="travelMode" onchange='getPlaceId(${num}, this[selectedIndex].value);' style="{width:300px}">
        <!-- default by car -->
        <option value="DRIVING" onclick="getPlaceId(${num}，'DRIVING')">- Default -</option>
        <option value="DRIVING" onclick="getPlaceId(${num}，'DRIVING')">Driving</option>
        <option value="WALKING" onclick="getPlaceId(${num}，'Walking')">Walking</option>
        <option value="BICYCLING" onclick="getPlaceId(${num}，'Bicycling')">Bicycling</option>
        <option value="TRANSIT" onclick="getPlaceId(${num}，'Transit')">Transit</option>
        </select>
        <p>Duration:<input type="text" id="${num}" name="time" placeholder="Estimate to Cost" class="text" readonly="readonly" style="text-align: center;"></p>
    </header>
</article>
</c:if>
<c:set var="num" value="${num+1}"/>
</c:forEach>
</c:if>


<article class="container box style3">
    <header>
        <h2>Build Your Plan</h2>
        <p>Give your plan more details</p>
    </header>
    
        <div class="row 50%">
            <div class="12u"><input type="text" class="text" name="planName" placeholder="Title" /></div>
            <div class="12u$"><input  type="text" name="abstract" placeholder="Abstract"></textarea></div>
            <div class="12u$">
                <ul class="actions">
                    <li><input type="submit" value="Confirm" /></li>
                </ul>
            </div>
        </div>
    
</article>

</form>


<script src="/TripPlanning/resources/js/jquery.min.js"></script>
<script src="/TripPlanning/resources/js/jquery.scrolly.min-flow.js"></script>
<script src="/TripPlanning/resources/js/util-flow.js"></script>
<script src="/TripPlanning/resources/js/main-flow.js"></script>
</body>
</html>
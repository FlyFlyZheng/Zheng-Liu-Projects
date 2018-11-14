<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Place Detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/TripPlanning/resources/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
 <style>

        #centeredmenu ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }
        #centeredmenu li {
            float: left;
        }
        #centeredmenu li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        /*鼠标移动到选项上修改背景颜色 */
        #centeredmenu  li a:hover {
            background-color: #111;
        }
        td.width1{
            width:200px;
        }
        td.width2{
            width:800px;
        }
        #GoogleMap {
            height: 400px;
            width: 100%;
        }
        #GoogleMap {
            height: 400px;
            width: 100%;
        }
    </style>
     <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=Google_Map_API_Key&libraries=places"></script>

    <script  type="text/javascript">
        window.onload=function() {
            $('#map').css('display', 'block');
            $('#info').css('display', 'none');
            $('#photo').css('display', 'none');

        }
    </script>

</head>
<body>

<div id="centeredmenu">
    <ul>
        <li ><a href="#map" onclick="{document.getElementById('map').style.display = 'block';document.getElementById('info').style.display = 'none';document.getElementById('photo').style.display = 'none';}">Map</a></li>
        <li ><a href="#info" onclick="{document.getElementById('info').style.display = 'block';document.getElementById('map').style.display = 'none';document.getElementById('photo').style.display = 'none';}">Info</a></li>
        <li ><a href="#photo" onclick="{document.getElementById('photo').style.display ='block';document.getElementById('map').style.display = 'none';document.getElementById('info').style.display = 'none';}">Photos</a></li>
        <li style="float:right"><a href="/TripPlanning/user/back-search-place.htm">Back To List</a></li>
    </ul><br/><br/>
    <h1 align="center" id="place_name"></h1>
</div>


<!-- Map -->
<div id="map" class="divided">
    <section class="wrapper style1 align-center" id="reference">
        <div class="inner">
            <div class="index align-left">
                <section>
                    <div class="content">
                        <form method="post" action="#">
                            <div class="field half first">
                                <label for="from">From</label>
                                <input type="text" name="from" id="from" disabled="disabled" />
                            </div>
                            <div class="field half first">
                                <label for="to">To</label>
                                <input type="text" name="to" id="to" disabled="disabled"/>
                            </div>
                            <div class="field">
                                <label for="duration">Duration</label>
                                <input type="text" name="duration" id="duration" disabled="disabled"/>
                            </div>
                            <ul class="actions" align="center">
                                <li><input type="button" name="Driving" id="Driving" value="Driving" onclick="findDirction('DRIVING')"/></li>
                                <li><input type="button" name="Walking" id="Walking" value="Walking" onclick="findDirction('WALKING')"/></li>
                                <li><input type="button" name="Bicycling" id="Bicycling" value="Bicycling" onclick="findDirction('BICYCLING')"/></li>
                                <li><input type="button" name="Transit" id="Transit" value="Transit" onclick="findDirction('TRANSIT')"/></li>
                            </ul>
                        </form>
                        <div id="GoogleMap"></div>
                        <div id="directionsPanel"></div>
                        <script>
                                var map;
                                initMap = function(){
                                    var options = {
                                        zoom:13,
                                        center:{lat:${place_location.lat}, lng:${place_location.lng} }
                                    };
                                    //new map
                                    map = new google.maps.Map(document.getElementById("GoogleMap"),options)
                                  //get detail info
                                    var place_id = '${placeid}';
                                    var request = {
                                        placeId:place_id
                                    };
                                    service = new google.maps.places.PlacesService(map);
                                    service.getDetails(request, callback);

                                    //set up directions
                                    //directionsDisplay.setMap(map);
                                    //directionsDisplay.setPanel(document.getElementById('directionsPanel'));
                                    //calculateAndDisplayRoute(directionsService, directionsDisplay);
                                };



                                function callback(place, status) {
                                    if (status == google.maps.places.PlacesServiceStatus.OK) {
                                        console.log(place)
                                        showInfo(place);
                                        showPhoto(place);
                                    }
                                }

                                var dest;

                                showInfo = function(place){
                                    $('#place_name').append(place.name);
                                    document.getElementById("from").value = '${from_location.address}';
                                    document.getElementById("to").value = place.name;
                                    $('#place_address').append(place.formatted_address);
                                    dest = place.formatted_address;
                                    $('#place_phone_number').append(place.international_phone_number);
                                    $('#place_rating').append(place.rating+"/5");
                                    var google_page = "<a href='"+place.url+"'>"+place.url+"</a>"
                                    $('#place_google_page').append(google_page);
                                    var website = "<a href='"+place.website+"'>"+place.website+"</a>"
                                    $('#place_website').append(website);
                                    var open;
                                    if(place.opening_hours.open_now==true){
                                        open = "Open"
                                    }else{
                                        open = "Closed"
                                    }
                                    $('#place_opening_hour').append(open);
                                }

                                showPhoto = function(place){
                                    var placePhotosArray = [];
                                    placePhotosArray.splice(0, placePhotosArray.length);
                                    if (place.photos != undefined) {

                                        for (var i = 0; i < place.photos.length; i++) {
                                            placePhotosArray.push(place.photos[i].getUrl({
                                                'maxWidth': 300,
                                                'maxHeight': 300
                                            }));
                                        }

                                        for(var i=0; i<placePhotosArray.length;i++){
                                            var code1="<img src='"+placePhotosArray[i]+"'width='300' height='300'>";
                                            $('#images').append(code1)
                                        }
                                    }

                                }

                                cleanMap = function(){
                                    var options = {
                                        zoom:13,
                                        center:{lat:${place_location.lat}, lng:${place_location.lng} }
                                    };
                                    //new map
                                    //get detail info
                                    map = new google.maps.Map(document.getElementById("GoogleMap"),options)
                                    var request = {
                                        placeId:'@id'
                                    };
                                }

                                findDirction = function(model){
                                    cleanMap();
                                    var directionsService = new google.maps.DirectionsService();
                                    var directionsDisplay = new google.maps.DirectionsRenderer();
                                    directionsDisplay.setMap(map);
                                    document.getElementById('directionsPanel').innerText = ""
                                    directionsDisplay.setPanel(document.getElementById('directionsPanel'));
                                    calculateAndDisplayRoute(directionsService, directionsDisplay,model);
                                }

                                function calculateAndDisplayRoute(directionsService, directionsDisplay,model) {
                                    directionsService.route({
                                        origin:  {lat:${from_location.lat}, lng:${from_location.lng}},
                                        destination: {lat:${place_location.lat}, lng:${place_location.lng}},
                                        travelMode: model
                                    }, function(response, status) {
                                        if (status === 'OK') {
                                            directionsDisplay.setDirections(response);
                                            console.log("direction response");
                                            console.log(response)
                                            console.log("duration:"+response.routes[0].legs[0].duration.text)
                                            document.getElementById("duration").value = response.routes[0].legs[0].duration.text;
                                        } else {
                                            window.alert('Directions request failed due to ' + status);
                                        }
                                    });
                                }

                                initMap();
                                //findDirction("DRIVING");
                        </script>
                    </div>
                </section>
            </div>
        </div>
    </section>
</div>

<!-- Info -->
<div id="info" class="divided">
    <section class="wrapper style1 align-center">
        <div class="inner">
            <!-- Table -->
            <section>
                <div class="content">
                    <div class="table-wrapper">
                        <table align="left">
                            <thead>
                            <tr>
                                <td class="width1"><b>Address</b></td>
                                <td class="width2" id="place_address"></td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="width1"><b>Phone Number</b></td>
                                <td class="width2" id="place_phone_number"></td>
                            </tr>
                            <tr>
                                <td class="width1"><b>Rating</b></td>
                                <td class="width2" id="place_rating"></td>
                            </tr>
                            <tr>
                                <td class="width1"><b>Google Page</b></td>
                                <td class="width2" id="place_google_page"></td>
                            </tr>
                            <tr>
                                <td class="width1"><b>Website</b></td>
                                <td class="width2" id="place_website"></td>
                            </tr>
                            <tr>
                                <td class="width1"><b>Open Status</b></td>
                                <td class="width2" id="place_opening_hour"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>
    </section>
</div>

<!-- Photo -->
<div id="photo" class="divided">
    <section class="wrapper style1 align-center">
        <div class="inner"  id="images">
            <h2>Photo</h2>
        </div>
    </section>
</div>

</body>
</html>

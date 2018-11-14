<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>user-dashboard</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/TripPlanning/resources/css/main-cute.css" />
    <script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
   
</head>
<body class="homepage">
<div id="page-wrapper">
    <div id="header-wrapper">
        <div id="header">
            <!-- Logo -->
            <h1><a href="/TripPlanning">Trip Planning</a></h1>
            <!-- Banner -->
            <section id="banner">
                <header>
                    <h2>Hi,${sessionScope.currentUser.username}! Explore The World!</h2>
                    <p>A usefully tool to search places and plan your trip</p>
                </header>
            </section>

            <!-- Intro -->
            <section id="intro" class="container">
                <div class="row">
                    <div class="4u 12u(mobile)">
                        <section class="first">                      
                            <br/><br/><i class="fas fa-search-plus fa-5x"></i><br/><br/>
                            <header><a href="/TripPlanning/user/function-search-place.htm"><h2>Search Place</h2></a></header>
                            <p>Look Around! Search your travel places of restaurant，shopping mall, museum and anything you want!</p>
                        </section>
                    </div>
                    <div class="4u 12u(mobile)">
                        <section class="middle">                        
                            <br/><br/><i class="far fa-paper-plane fa-5x"></i><br/><br/>
                            <header><a href="/TripPlanning/plan/view-all-plans.htm"><h2>Discovery</h2></a></header>
                            <p>Discovery your trip plan！Look at other's trip plan for this place</p>
                        </section>
                    </div>
                    <div class="4u 12u(mobile)">
                        <section class="last">
                        	<br/><br/><i class="fab fa-gratipay fa-5x"></i><br/><br/>                            
                            <header><a href="/TripPlanning/user/fav.htm"><h2>My Places</h2></a></header>
                            <p>Check your favorite place list here!</p>
                        </section>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
</body>
</html>


<body>

</body>
</html>
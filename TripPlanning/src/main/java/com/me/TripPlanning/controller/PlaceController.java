package com.me.TripPlanning.controller;

import java.util.ArrayList;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.ResponseWrapper;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.me.TripPlanning.dao.GooglePlaceDAO;
import com.me.TripPlanning.dao.UserDAO;
import com.me.TripPlanning.pojo.Place;
import com.me.TripPlanning.pojo.Position;
import com.me.TripPlanning.pojo.User;

@Controller
public class PlaceController {
		
	@RequestMapping(value="/user/dashboard.htm", method = RequestMethod.GET)
	protected String showLoginForm(HttpServletRequest request,ModelMap map) {
		HttpSession session = request.getSession(false);
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
			User user = (User)session.getAttribute("currentUser");
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}
		}
		return "user-dashboard";
	}
	
	@RequestMapping(value="/user/function-search-place.htm", method = RequestMethod.GET)
	protected String showSearchPlace(HttpServletRequest request,ModelMap map,GooglePlaceDAO googlePlaceDao)  throws Exception{
		HttpSession session = request.getSession(false);
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
			User user = (User)session.getAttribute("currentUser");
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}
		}		
		Position location= googlePlaceDao.getCurrentLocation();
		map.addAttribute("page","search_place");
		map.addAttribute("currentLocation", location);
		return "user-search-place";
	}
	
	@RequestMapping(value="/user/function-search-place.htm", method = RequestMethod.POST)
	protected String getPlaceList(HttpServletRequest request, ModelMap map,GooglePlaceDAO googlePlaceDao) throws Exception{
		try {
			HttpSession session = request.getSession(false);
			if(session==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}else {
				User user = (User)session.getAttribute("currentUser");
				if(user==null) {
					map.addAttribute("message","please log in first");
					return "Message";
				}
			}
			
			String keyword = request.getParameter("keyword");
			String mode = request.getParameter("travelMode");
			String time = request.getParameter("time");
			String from = request.getParameter("from");
			Position location=null;
			ArrayList<Place> places = null;
		    if(from.equals("currentLocation")) {
		    	//get current location
		    	location = googlePlaceDao.getCurrentLocation();	    			    	
		    }else if(from.equals("otherLocation")) {
		    	//get other location
		    	String other = request.getParameter("otherLocation");
		    	location = googlePlaceDao.getOtherLocation(other);	    	
		    }
		    if(time.isEmpty()) {
		    	//not limit time
		    	places = googlePlaceDao.getPlaceList(keyword, location);
		    }else {
		    	//limit time
		    	places = googlePlaceDao.getPlacesWithLimit(keyword,location,mode,100);
		    }
		    System.out.println("places num"+places.size());
		    session.setAttribute("places", places);
		    session.setAttribute("currentLocation", location);  
		    map.addAttribute("page","search_place");
		    map.addAttribute("currentLocation", location);
		    map.addAttribute("placeNum", places.size());
		    map.addAttribute("places", places);
	    	return "user-search-place";
		}catch(Exception e){
			 map.addAttribute("message", "error occur");
		     return "Message";
		}
		
	}
	
	@RequestMapping(value="user/placeDetail.htm", method = RequestMethod.GET)
	protected String showPlaceDetail(HttpServletRequest request,ModelMap map,GooglePlaceDAO googlePlaceDao) throws Exception{
		HttpSession session = request.getSession(false);
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
			User user = (User)session.getAttribute("currentUser");
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}
		}
		
		String placeid = request.getParameter("placeid");
		String from_lat = request.getParameter("fromLocationLat");
		String from_lng = request.getParameter("fromLocationLng");
		//from location
		Position from_location = googlePlaceDao.getLocationByLatLng(Double.parseDouble(from_lat), Double.parseDouble(from_lng));
		//place location
		Position place_location = googlePlaceDao.getLocationById(placeid);
		
		map.addAttribute("from_location", from_location);
		map.addAttribute("place_location", place_location);
		map.addAttribute("placeid", placeid);
		return "place-detail";
	}
	
	@RequestMapping(value="user/back-search-place.htm", method = RequestMethod.GET)
	protected String backSearchPlace(HttpServletRequest request,ModelMap map) {
		HttpSession session = request.getSession(false);
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
			User user = (User)session.getAttribute("currentUser");
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}
		}
		
	    ArrayList<Place> places = (ArrayList<Place>)session.getAttribute("places");
	    Position location = (Position)session.getAttribute("currentLocation");
	    map.addAttribute("page","search_place");
	    map.addAttribute("currentLocation", location);
	    map.addAttribute("placeNum", places.size());
	    map.addAttribute("places", places);
	    return "user-search-place";
	}
	
	
	
	
	@RequestMapping(value="user/add-to-fav.htm", method = RequestMethod.GET)
	protected String saveToFavoriate(HttpServletRequest request,ModelMap map, UserDAO userDao,GooglePlaceDAO googlePlaceDao) throws Exception{
		HttpSession session = request.getSession(false);
		User user = null;
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
		    user = (User)session.getAttribute("currentUser");
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}
		}
		ArrayList<Place> places = (ArrayList<Place>)session.getAttribute("places");
		String placeid = request.getParameter("placeid");
		System.out.println("user"+user.getUsername());
		System.out.println("placeid"+placeid);
		Place place = null;
		for(Place p:places) {
			if(p.getPlaceId().equals(placeid)) {
				place = p;
			}
		}
		Set<Place> favPlaces = userDao.getFavList(user);
		boolean tag = false;
		for(Place p : favPlaces) {
			if(p.getPlaceId().equals(placeid)) {
				tag = true;
			}
		}
		if(tag==false) {
			userDao.saveToList(user, place);
		}	
		//return to list
		
	    Position location = googlePlaceDao.getCurrentLocation();
	    map.addAttribute("page","search_place");
		map.addAttribute("currentLocation", location);
	    map.addAttribute("placeNum", places.size());
	    map.addAttribute("places", places);
	    return "user-search-place";
		
	}
		
	@RequestMapping(value="user/fav.htm", method = RequestMethod.GET)
	protected String toFavoriate(HttpServletRequest request,UserDAO userDao,ModelMap map,GooglePlaceDAO googlePlaceDao) throws Exception {
		HttpSession session = request.getSession(false);
		User user = null;
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
		    user = (User)session.getAttribute("currentUser");
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}
		}
		Set<Place> favPlaces  = userDao.getFavList(user);	
		Position location = googlePlaceDao.getCurrentLocation();
		map.addAttribute("page","fav_place");
		map.addAttribute("currentLocation", location);
		map.addAttribute("placeNum", favPlaces.size());
	    map.addAttribute("places", favPlaces);
		return "user-search-place";
	}
	
	@RequestMapping(value="user/remove-from-fav.htm", method = RequestMethod.GET)
	protected String removeFromFav(HttpServletRequest request,UserDAO userDao,ModelMap map,GooglePlaceDAO googlePlaceDao) throws Exception{
		HttpSession session = request.getSession(false);
		User user = null;
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
			user = (User)session.getAttribute("currentUser");
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}
		}
		String placeid = request.getParameter("placeid");
		Set<Place> favPlaces  = userDao.removeFromList(user, placeid);	
		Position location = googlePlaceDao.getCurrentLocation();
		map.addAttribute("page","fav_place");
		map.addAttribute("currentLocation", location);
		map.addAttribute("placeNum", favPlaces.size());
	    map.addAttribute("places", favPlaces);
		return "user-search-place";
	}

	
	
	
	
	
	
	
	

}

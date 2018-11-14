package com.me.TripPlanning.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Id;
import javax.print.attribute.standard.PrinterLocation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.apache.taglibs.standard.tag.common.core.RemoveTag;
import org.hibernate.boot.model.source.spi.PluralAttributeElementNature;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.criteria.internal.expression.function.LengthFunction;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.TripPlanning.dao.GooglePlaceDAO;
import com.me.TripPlanning.dao.PlanDAO;
import com.me.TripPlanning.dao.UserDAO;
import com.me.TripPlanning.pojo.Place;
import com.me.TripPlanning.pojo.Plan;
import com.me.TripPlanning.pojo.Position;
import com.me.TripPlanning.pojo.User;
import com.me.TripPlanning.view.PlanPdfView;

@Controller
public class PlanController {
	
	@RequestMapping(value="/plan/becomePlanner.htm", method = RequestMethod.GET)
	protected String becomeAPlanner(HttpServletRequest request,PlanDAO planDAO,ModelMap map, UserDAO userDAO) throws  Exception{
		
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
		
		userDAO.becomeAPlanner(user.getUsername());
		
		List<Plan> plans = planDAO.getAllPlans();
		map.addAttribute("plans",plans);
		map.addAttribute("display","ALL");
		map.addAttribute("message","Congratulations！ You have become a planner");
		return "view-plan-list";
	}
	
	@RequestMapping(value="/plan/like.htm", method = RequestMethod.GET)
	protected String likeAPlan(HttpServletRequest request,PlanDAO planDAO,ModelMap map) throws  Exception{
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		Plan plan = planDAO.likePlan(id);
		
		map.addAttribute("place_number", plan.getPlaces().size());
	    map.addAttribute("plan", plan);
	    return "view-plan";
	}
	
	@RequestMapping(value="/plan/download.htm", method = RequestMethod.GET)
	protected ModelAndView downloadPlan(HttpServletRequest request,PlanDAO planDAO,ModelMap map) throws  Exception{
		HttpSession session = request.getSession(false);
		User user = null;
		if(session==null) {
			return new ModelAndView("Message","message","please log in first");
		}else {
			user = (User)session.getAttribute("currentUser");
			if(user==null) {
				return new ModelAndView("Message","message","please log in first");
			}
		}
		int id = Integer.parseInt(request.getParameter("id"));
		Plan plan = planDAO.getPlan(id);
		
		return new ModelAndView(new PlanPdfView(),"plan",plan);
	}
	
	
	
	@RequestMapping(value="/plan/Detail.htm", method = RequestMethod.GET)
	protected String detailPlan(HttpServletRequest request,PlanDAO planDAO,ModelMap map) throws  Exception{
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
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		Plan plan = planDAO.getPlan(id);
		map.addAttribute("place_number", plan.getPlaces().size());
	    map.addAttribute("plan", plan);
	    return "view-plan";
	}
	
	
	
	@RequestMapping(value="/plan/view-all-plans.htm", method = RequestMethod.GET)
	protected String viewAllPlans(HttpServletRequest request,PlanDAO planDAO,ModelMap map) throws  Exception{
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
		
		List<Plan> plans = planDAO.getAllPlans();
		map.addAttribute("plans",plans);
		map.addAttribute("display","ALL");
		return "view-plan-list";
	}


	@RequestMapping(value="/plan/edit.htm", method = RequestMethod.GET)
	protected String showEditPage(HttpServletRequest request,GooglePlaceDAO googlePlaceDao,ModelMap map) throws Exception {
		HttpSession session = request.getSession(false);
		User user = null;
		if(session==null) {
			map.addAttribute("message","please log in first");
			return "Message";
		}else {
			user = (User)session.getAttribute("currentUser");
			System.out.println(user.getRole());
			if(user==null) {
				map.addAttribute("message","please log in first");
				return "Message";
			}else if(user.getRole().equals("common")) {
				map.addAttribute("message","To start edit a plan, you need to become a planner first");
				map.addAttribute("planLink","true");
				return "Message";
			}
		}
		
		Plan plan = new Plan();
		session.setAttribute("plan", plan);
		Position position = googlePlaceDao.getCurrentLocation();
		map.addAttribute("centerLocation", position);
		
		return "edit-plan";
	}
	
	@RequestMapping(value="/plan/search-place.htm", method = RequestMethod.POST)
	protected String SearchPlace(HttpServletRequest request,GooglePlaceDAO googlePlaceDao,ModelMap map) throws Exception {
		try {
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
				}else if(user.getRole().equals("common")) {
					map.addAttribute("message","To start edit a plan, you need to become a planner first");
					map.addAttribute("planLink","true");
					return "Message";
				}
			}
			
			String keyword = request.getParameter("keyword");
			String from = request.getParameter("from");
			Position location=null;
			if(from.equals("currentLocation")) {
		    	//get current location
		    	location = googlePlaceDao.getCurrentLocation();	    			    	
		    }else if(from.equals("otherLocation")) {
		    	//get other location
		    	String other = request.getParameter("otherLocation");
		    	location = googlePlaceDao.getOtherLocation(other);	    	
		    }
			ArrayList<Place> places = googlePlaceDao.getPlaceList(keyword, location);
			session.setAttribute("places_plan_search", places);
			session.setAttribute("centerLocation", location);
			
			map.addAttribute("places_plan_search", places);
			map.addAttribute("centerLocation", location);
			return "edit-plan";
		}catch(Exception e){
			 map.addAttribute("message", "error occur");
		     return "Message";
		}
	}
	
	@RequestMapping(value="/plan/add-to-plan.htm", method = RequestMethod.GET)
	protected String AddToPlan(HttpServletRequest request,GooglePlaceDAO googlePlaceDao,ModelMap map)throws Exception{
		
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
			}else if(user.getRole().equals("common")) {
				map.addAttribute("message","To start edit a plan, you need to become a planner first");
				map.addAttribute("planLink","true");
				return "Message";
			}
		}
		
			String placeid = request.getParameter("placeid");
			ArrayList<Place> places_plan_search = (ArrayList<Place>)session.getAttribute("places_plan_search");
			Place place = null;
			for(Place p:places_plan_search) {
				if(p.getPlaceId().equals(placeid)) {
					place = p;
				}
			}
			
			Plan plan = null;
			if(session.getAttribute("plan")==null) {
				Plan plan1 = new Plan();
				session.setAttribute("plan", plan1);
			}else {
				plan = (Plan)session.getAttribute("plan");
			}
			plan.getPlaces().add(place);
					
						
			Map<String, Place> plan_places = null; 
			if((Map<String,Place>)session.getAttribute("plan_places")==null) {
				plan_places = new HashMap<String, Place>();
			}else {
				plan_places = (HashMap<String, Place>)session.getAttribute("plan_places");
			}
			plan_places.put(place.getPlaceId(), place);
			int plan_num = plan_places.size();
			session.setAttribute("plan_places", plan_places);
									
			map.addAttribute("plan_places", plan_places);
			map.addAttribute("places_plan_search", places_plan_search);
			map.addAttribute("centerLocation", (Position)session.getAttribute("centerLocation"));
			return "edit-plan";
		
	}
	
	@RequestMapping(value="/plan/remove-from-plan.htm", method = RequestMethod.GET)
	protected String RemoveFromList(HttpServletRequest request,ModelMap map) throws Exception{
		
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
			}else if(user.getRole().equals("common")) {
				map.addAttribute("message","To start edit a plan, you need to become a planner first");
				map.addAttribute("planLink","true");
				return "Message";
			}
		}
		
		String placeid = request.getParameter("placeid");	
		//remove this place from plan
		Plan plan = (Plan)session.getAttribute("plan");
		Set<Place> places_of_plan = plan.getPlaces();
		Place placeToRemove = null;
		for(Place place : places_of_plan) {
			if(place.getPlaceId().equals(placeid)) {
				placeToRemove = place;
			}
		}
		plan.getPlaces().remove(placeToRemove);
		
		//remove place from session
		Map<String, Place> plan_places = (HashMap<String, Place>)session.getAttribute("plan_places");
		plan_places.remove(placeid);
		session.setAttribute("plan_places", plan_places);
		int plan_num = plan_places.size();
		
		ArrayList<Place> places_plan_search = (ArrayList<Place>)session.getAttribute("places_plan_search");
		map.addAttribute("plan_places", plan_places);
		map.addAttribute("places_plan_search", places_plan_search);
		map.addAttribute("centerLocation", (Position)session.getAttribute("centerLocation"));
		return "edit-plan";
	}
	
	
	@RequestMapping(value="/plan/edit-plan-text.htm", method = RequestMethod.GET)
	protected String editPlanText(HttpServletRequest request,ModelMap map) {
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
			}else if(user.getRole().equals("common")) {
				map.addAttribute("message","To start edit a plan, you need to become a planner first");
				map.addAttribute("planLink","true");
				return "Message";
			}
		}
		
		Map<String, Place> plan_places = (HashMap<String, Place>)session.getAttribute("plan_places");
		//remove Map<String, Place> from session
		session.removeAttribute("plan_places");
		int lengthOfDurationList = plan_places.size()-1;
		ArrayList<String> humanReadDuration = new ArrayList<String>();
		ArrayList<Long> secondDuration = new ArrayList<Long>();
		ArrayList<String> plan_travelMode = new ArrayList<String>();
		
		for(int i=0; i<plan_places.size(); i++) {
			humanReadDuration.add("0 min");
			secondDuration.add(0L);
			plan_travelMode.add("default");
		}
		session.setAttribute("humanReadDuration", humanReadDuration);
		session.setAttribute("secondDuration", secondDuration);
		session.setAttribute("plan_travelMode", plan_travelMode);
		
		
		
		map.addAttribute("plan_places_num", plan_places.size());
		map.addAttribute("plan_places", plan_places);
		return "edit-plan-text";
	}
	
	
	@RequestMapping(value="/plan/get-durations.htm", method = RequestMethod.GET)
	public @ResponseBody String getPlaceIdByNum(HttpServletRequest request,GooglePlaceDAO googlePlaceDao,
			@RequestParam(value="number") int num,
			@RequestParam(value="travelMode") String travelMode) throws Exception{
		HttpSession session = request.getSession(false);
		ArrayList<String> humanReadDuration = (ArrayList<String>)session.getAttribute("humanReadDuration");
		ArrayList<Long> secondDuration = (ArrayList<Long>)session.getAttribute("secondDuration");
		ArrayList<String> plan_travelMode = (ArrayList<String>)session.getAttribute("plan_travelMode");
		
		Plan plan = (Plan)session.getAttribute("plan");
		//System.out.println(plan);
		//System.out.println(plan.getPlaces());
		Set<Place> places_in_plan = plan.getPlaces(); 
		List<Place> places = new ArrayList<Place>();
		for(Place place :places_in_plan) {
			places.add(place);
		}
		String address1 = places.get(num-1).getAddress();
		String address2 = places.get(num).getAddress();
		
	    String resultTimeHumanRead = googlePlaceDao.getHumanReadDurationWithPlaceId(address1,address2,travelMode);
	    Long resultTimeSecond = googlePlaceDao.getSecondDurationWithPlaceId(address1,address2,travelMode);
	    System.out.println(resultTimeHumanRead+"=>"+resultTimeSecond);
	    humanReadDuration.set(num-1, resultTimeHumanRead);
	    secondDuration.set(num-1, resultTimeSecond);
	    plan_travelMode.set(num-1, travelMode);
	    session.setAttribute("humanReadDuration", humanReadDuration);
		session.setAttribute("secondDuration", secondDuration);
		session.setAttribute("plan_travelMode", plan_travelMode);
	    
	    return resultTimeHumanRead;
		
	}
	
	@RequestMapping(value="/plan/save-plan.htm", method = RequestMethod.POST)
	public String savePlan(HttpServletRequest request,GooglePlaceDAO googlePlaceDao,ModelMap map, PlanDAO planDAO) throws Exception {
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
			}else if(user.getRole().equals("common")) {
				map.addAttribute("message","To start edit a plan, you need to become a planner first");
				map.addAttribute("planLink","true");
				return "Message";
			}
		}
		
		Plan plan = (Plan)session.getAttribute("plan");
		ArrayList<String> humanReadDuration = (ArrayList<String>)session.getAttribute("humanReadDuration");
		ArrayList<Long> secondDuration = (ArrayList<Long>)session.getAttribute("secondDuration");
		ArrayList<String> plan_travelMode = (ArrayList<String>)session.getAttribute("plan_travelMode");
		
		//Parse to set
		Set<String> set_travelMode = new HashSet<String>();
		for(String str: plan_travelMode) {
			set_travelMode.add(str);
		}
		Set<String> set_humanReadDuration = new HashSet<String>();
		for(String str: humanReadDuration) {
			set_humanReadDuration.add(str);
		}
		
		//get PlanName
		String planName = request.getParameter("planName");
		//get plan description
		String planDescription = request.getParameter("abstract");
		//get place descriptions
		String[] placeDescription = request.getParameterValues("placeDescription");
		//System.out.println(placeDescription);
		//System.out.println(request.getParameterValues("stayTime"));
		Set<String> plan_placeDescriptions = new HashSet<String>();
		for(String str: placeDescription) {
			plan_placeDescriptions.add(str);
		}
		//get place Stay
	    String[] placeStay = request.getParameterValues("stayTime");
	    Set<Integer> plan_placeStay = new HashSet<Integer>();
	    for(String str: placeStay) {
	    	plan_placeStay.add(Integer.parseInt(str));
		}
	    
	    
	    
	    //total time
	    int totalDuration = getTotalDuration(secondDuration, placeStay);
	    
	    
	    plan.setPlanName(planName);
	    plan.setPlanDescription(planDescription);
	    plan.setTravelModes(set_travelMode);
	    plan.setTextDurations(set_humanReadDuration);
	    plan.setPlaceDescription(plan_placeDescriptions);
	    plan.setPlaceStay(plan_placeStay);
	    plan.setTotalDuration(totalDuration);
	    plan.setUser(user);
	    plan.setLikeNum(0);
	    
	    planDAO.save(plan);   
	    
	    map.addAttribute("place_number", plan.getPlaces().size());
	    map.addAttribute("plan", plan);
	    map.addAttribute("humanReadDuration", humanReadDuration);
	    map.addAttribute("plan_travelMode", plan_travelMode);
	    map.addAttribute("placeDescription", placeDescription);
	    return "view-plan";
	    	    
	}
	
	public int getTotalDuration(ArrayList<Long> secondDuration,String[] placeStay) {
		int result = 0;
		for(Long duration: secondDuration) {
			result += Integer.parseInt(String.valueOf(duration/60));
		}
		for(String str:placeStay) {
			result += Integer.parseInt(str);
		}		
		return result;
	}
	
	
}

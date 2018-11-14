package com.me.TripPlanning.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.PrinterLocation;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.TripPlanning.pojo.Place;
import com.me.TripPlanning.pojo.User;


public class UserDAO extends DAO{
	
	
	public User getUser(String username, String password) throws Exception{
		try {
			begin();
			System.out.println("Inside user DAO: "+username+" is logining");
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			System.out.println("finish getting user");
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username + e.getMessage());
		}
	}
	
	public void becomeAPlanner(String username) throws Exception{
		try {
			begin();		
			Query q = getSession().createQuery("from User where username=:name");
			q.setString("name", username);
		    User user = (User) q.uniqueResult();		
			user.setRole("planner");	
			commit();
			
		}catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while checking unique username: " + e.getMessage());
		}
	}
	
	public User register(User u) throws Exception {
		try {
			begin();
			System.out.println(u.getUsername()+" is registering");
			getSession().save(u);
			commit();
			System.out.println("finish register,to send email");
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while reigster user: " + e.getMessage());
		}
	}
	
	public boolean activeUser(String email) throws Exception{
		try {
			begin();
			System.out.println("inside user DAO, activating user");
			Query q = getSession().createQuery("from User where email=:email");
			q.setString("email", email);
			List<User> users = (List<User>) q.list();
			if(users.get(0)!=null){
				(users.get(0)).setStatus(1);
				getSession().update(users.get(0));
				commit();
				System.out.println("finish activating user");
				return true;
			}else{
				
				return false;
			}
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while activate user: " + e.getMessage());
		}
	}
	
	public User getByEmail(String email) throws Exception{
		try {
			begin();
			Query q = getSession().createQuery("from User where email=:email");
			q.setString("email", email);
			List<User> users = (List<User>) q.list();
			if(users.get(0)!=null) {
				
				return users.get(0);
			}else {
				
				return null;
			}
		}catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while finding user by email: " + e.getMessage());
		}
	}
	
	/*
	 * check Duplicate user name
	 * input: String name
	 * output: true=>not duplicate; false=>duplicate
	 */
	public Boolean checkDuplicateUsername(String name) throws Exception{
		try {
			begin();
			System.out.println("Inside user DAO: "+name+" is checking repeat or not");
			boolean result;
			
			Query q = getSession().createQuery("from User where username=:name");
			q.setString("name", name);
	        
			ArrayList<User> users = (ArrayList<User>) q.list();		
			System.out.println("user length:"+users.size());
			
			if(users.size()==0) {
				result = true;
			}else {
				result = false;
			}			
			commit();
			
			return result;
		}catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while checking unique username: " + e.getMessage());
		}
	}
	
	public Boolean checkDuplicateEmail(String email) throws Exception{
		try {
			begin();
			System.out.println("Inside user DAO: "+email+" is checking repeat or not");
			boolean result;
			
			Query q = getSession().createQuery("from User where email=:testemail");
			q.setString("testemail", email);
	        
			ArrayList<User> users = (ArrayList<User>) q.list();		
			System.out.println("user length:"+users.size());
			
			if(users.size()==0) {
				result = true;
			}else {
				result = false;
			}			
			commit();
			
			return result;
		}catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while checking unique email: " + e.getMessage());
		}
	}
	
	
	public void saveToList(User user, Place place) throws Exception{
		try {
			begin();
			System.out.println("Inside user DAO: "+user.getUsername()+" is saving to list");
			Query q = getSession().createQuery("from User where username=:name");
			q.setString("name",user.getUsername());
			User u = (User)q.uniqueResult();
			System.out.println("I have got u:"+u.getUsername());
			u.getPlaces().add(place);
			System.out.println("I have got u places list:"+u.getPlaces().size());
			getSession().update(u);
			commit();
			System.out.println("I have save place into User");
			
			
		}catch(HibernateException e) {
			rollback();
			throw new Exception("Exception while saving to list: " + e.getMessage());
		}
	}
	
	public Set<Place> getFavList(User user) throws Exception{
		try {
			begin();
			System.out.println("Inside user DAO: "+user.getUsername()+" is getting fav list");
			Query query = getSession().createQuery("from User where username=:name");
			query.setString("name",user.getUsername());
			User u = (User)query.uniqueResult();
			Set<Place> favPlaces = u.getPlaces();
			System.out.println("fav list size:"+favPlaces.size());
			commit();
			System.out.println("finish: getting fav list");
			return favPlaces;			
		}catch(HibernateException e) {
			rollback();
			throw new Exception("Exception while get fav list: " + e.getMessage());
		}
	}
	
	public Set<Place> removeFromList(User user, String placeId) throws Exception{
		try {
			begin();
			Query q = getSession().createQuery("from User where username=:name");
			q.setString("name",user.getUsername());
			User u = (User)q.uniqueResult();
			System.out.println("user get ,user email:"+u.getEmail());
			Set<Place> places = u.getPlaces();
			Place removePlace = null;
			for(Place p:places) {
				if(p.getPlaceId().equals(placeId)) {
					removePlace = p;
				}
			}
			System.out.println("place get ,place name:"+removePlace.getName());
			System.out.println("before remove:"+u.getPlaces().size());
			commit();
			if(removePlace!=null) {
				places.remove(removePlace);
			}
			u.setPlaces(places);
			
			begin();
			System.out.println("Inside user DAO: "+user.getUsername()+" is deleting from list");
			getSession().update(u);
			commit();
			
			System.out.println("I have got u places list after deleting:"+u.getPlaces().size());			
			return places;
		}catch(HibernateException e) {
			rollback();
			throw new Exception("Exception while remove from fav list: " + e.getMessage());
		}
	}

}

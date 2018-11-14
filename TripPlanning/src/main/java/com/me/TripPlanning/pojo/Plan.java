package com.me.TripPlanning.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "plan_table")
public class Plan {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="planId", unique = true, nullable = false)
	private int planId;
	
	@Column(name = "planName")
	private String planName;
	
	@Column(name = "planDescription")
	private String planDescription;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name="t_plan_place", joinColumns={ @JoinColumn(name="f_plan_id")}, inverseJoinColumns={ @JoinColumn(name = "f_place_id") })
	private Set<Place> places;
	
	@ElementCollection(fetch=FetchType.EAGER, targetClass=String.class)
	@CollectionTable(name="plan_travelModes")
	private Set<String> travelModes;
	
	@ElementCollection(fetch=FetchType.EAGER, targetClass=String.class)
	@CollectionTable(name="plan_textDurations")
	private Set<String> textDurations;
	
	@ElementCollection(fetch=FetchType.EAGER, targetClass=String.class)
	@CollectionTable(name="plan_placeDescription")
	private Set<String> placeDescription;
	
	@ElementCollection(fetch=FetchType.EAGER, targetClass=Integer.class)
	@CollectionTable(name="plan_placeStay")
	private Set<Integer> placeStay;
	
	@Column(name = "totalDuration")
	private int totalDuration;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "likeNum")
	private int likeNum;
	
	
	
	
	public Plan() {
		places = new HashSet<Place>();
		travelModes = new HashSet<String>();
		textDurations = new HashSet<String>();
		placeDescription = new HashSet<String>();
		placeStay = new HashSet<Integer>();
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	
	

	public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public User getAuthor() {
		return user;
	}

	public void setAuthor(User author) {
		this.user = author;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	public Set<String> getTravelModes() {
		return travelModes;
	}

	public void setTravelModes(Set<String> travelModes) {
		this.travelModes = travelModes;
	}

	public Set<String> getTextDurations() {
		return textDurations;
	}

	public void setTextDurations(Set<String> textDurations) {
		this.textDurations = textDurations;
	}

	public Set<String> getPlaceDescription() {
		return placeDescription;
	}

	public void setPlaceDescription(Set<String> placeDescription) {
		this.placeDescription = placeDescription;
	}

	public Set<Integer> getPlaceStay() {
		return placeStay;
	}

	public void setPlaceStay(Set<Integer> placeStay) {
		this.placeStay = placeStay;
	}
	
	
	
	
	
	
	
}

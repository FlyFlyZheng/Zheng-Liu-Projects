package com.me.TripPlanning.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.PriceLevel;
import com.google.maps.model.RankBy;
import com.google.maps.model.TravelMode;
import com.me.TripPlanning.pojo.Place;
import com.me.TripPlanning.pojo.Position;

public class GooglePlaceDAO{

	GeoApiContext context = new GeoApiContext.Builder()
		    .apiKey("Google_Map_API_Key")
		    .build();


	public GooglePlaceDAO() {

	}




	public Position getCurrentLocation() throws Exception {
		try {
			Position p = new Position();

			 String URLs = "http://ip-api.com/json";
			 URL url = new URL(URLs);
			 HttpURLConnection request = (HttpURLConnection) url.openConnection();
			 request.connect();

			 JsonParser jp = new JsonParser(); //from gson
			 JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			 JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
			 String lng = rootobj.get("lon").getAsString();
			 String lat = rootobj.get("lat").getAsString();
			 p.setLng(Double.parseDouble(lng));
			 p.setLat(Double.parseDouble(lat));
			return p;
		}catch(Exception e) {
			throw new Exception("Excpetion in getting curreng location:" + e.getMessage());
		}
	}


	public Position getOtherLocation(String keyword) throws Exception {
		try {
			Position position = new Position();
			GeocodingResult[] results =  GeocodingApi.geocode(context,keyword).await();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String address = results[0].formattedAddress;
			Double lng = results[0].geometry.location.lng;
			Double lat = results[0].geometry.location.lat;
			position.setAddress(address);
			position.setLat(lat);
			position.setLng(lng);
			return position;
			//System.out.println(gson.toJson(results[0].formattedAddress));
			//System.out.println("lng"+ gson.toJson(results[0].geometry.location.lng));
			//System.out.println("lat"+ gson.toJson(results[0].geometry.location.lat));
		}catch(Exception e) {
			throw new Exception("Excpetion in getting other location:" + e.getMessage());
		}
	}

	/*
	 * Get a Position by Place Id
	 * Input: Place id
	 * Output: Position: lat,lng,address
	 * */
	public Position getLocationById(String id) throws Exception{
		try {
			Position position = new Position();
			GeocodingResult[] results =  GeocodingApi.newRequest(context).place(id).await();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String address = results[0].formattedAddress;
			Double lng = results[0].geometry.location.lng;
			Double lat = results[0].geometry.location.lat;
			position.setAddress(address);
			position.setLat(lat);
			position.setLng(lng);
			return position;
		}catch(Exception e) {
			throw new Exception("Excpetion in getting location by id:" + e.getMessage());
		}
	}

	/*
	 * Get a Position by Place latLng
	 * Input: Double lat, Double lng
	 * Output: Position: lat,lng,address
	 * */
	public Position getLocationByLatLng(Double lat, Double lng) throws Exception{
		try {
			Position position = new Position();
			LatLng latlng = new LatLng(lat, lng);
			GeocodingResult[] results =  GeocodingApi.newRequest(context).latlng(latlng).await();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String address = results[0].formattedAddress;
			Double result_lng = results[0].geometry.location.lng;
			Double result_lat = results[0].geometry.location.lat;
			position.setAddress(address);
			position.setLat(result_lat);
			position.setLng(result_lng);
			return position;
		}catch(Exception e) {
			throw new Exception("Excpetion in getting location by latlng::" + e.getMessage());
		}
	}


	public ArrayList<Place> getPlaceList(String keyword, Position centerPostion) throws Exception {

		  try{
			  LatLng location = new LatLng(centerPostion.getLat(), centerPostion.getLng());
			  PlacesSearchResponse response = PlacesApi.textSearchQuery(context, keyword)
		          .location(location)
		          .radius(3000)
		          .await();

			  PlacesSearchResult[] results = response.results;
			  ArrayList<Place> places = new ArrayList<Place>();

			  for(PlacesSearchResult result:results) {
				  String address = result.formattedAddress;
				  String name = result.name;
				  Double lat = result.geometry.location.lat;
				  Double lng = result.geometry.location.lng;
				  String category = result.types[0];
				  URL icon = result.icon;
				  String id = result.placeId;


				  Place place = new Place();
				  place.setPlaceId(id);
				  place.setName(name);
				  place.setAddress(address);
				  place.setCategory(category);
				  place.setLat(lat);
				  place.setLng(lng);
				  place.setIcon(icon);
				  places.add(place);

			  }
			  return places;

		  }catch(Exception e) {
				throw new Exception("Excpetion in getting place list:" + e.getMessage());
		   }
	}

	public ArrayList<Place> getPlacesWithLimit(String keyword, Position centerPostion, String mode, int time)  throws Exception{
		try {
			ArrayList<Place> places = getPlaceList(keyword, centerPostion);


			LatLng location = new LatLng(centerPostion.getLat(), centerPostion.getLng());
			String[] origins = new String[] {centerPostion.getLat()+","+centerPostion.getLng()};
			String[] destinations = new String[places.size()];
			for(int i=0; i<places.size();i++) {
				destinations[i] = places.get(i).getAddress();
			}
			TravelMode travelMode = null;
			if(mode.equals("driving")) {
				travelMode = TravelMode.DRIVING;
			}else if(mode.equals("bicycling")) {
				travelMode = TravelMode.BICYCLING;
			}else if(mode.equals("walking")) {
				travelMode = TravelMode.WALKING;
			}else if(mode.equals("transit")) {
				travelMode = TravelMode.TRANSIT;
			}

			DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(context)
					  .origins(location)
			          .destinations(destinations)
			          .mode(travelMode)
			          .await();

			ArrayList<Place> results = new ArrayList<Place>();
			DistanceMatrixRow row = distanceMatrix.rows[0];
			for(int i=0; i<places.size();i++) {
				int duration = (int)row.elements[i].duration.inSeconds;
				if(duration<=(time*60)) {
					results.add(places.get(i));
				}

			}
		    return results;

		}catch(Exception e) {
			throw new Exception("Excpetion in getting limited place list:" + e.getMessage());
		 }
	}




	public String getHumanReadDurationWithPlaceId(String address1,String address2,String mode)  throws Exception{
		try {
			String resultTimeHumanRead = null;
			TravelMode travelMode = null;
			if(mode.equals("DRIVING")) {
				travelMode = TravelMode.DRIVING;
			}else if(mode.equals("WALKING")) {
				travelMode = TravelMode.WALKING;
			}else if(mode.equals("BICYCLING")) {
				travelMode = TravelMode.BICYCLING;
			}else if(mode.equals("TRANSIT")) {
				travelMode = TravelMode.TRANSIT;
			}else {
				travelMode = TravelMode.DRIVING;
			}

			DirectionsResult result =
			          DirectionsApi.newRequest(context)
			          	  .mode(travelMode)
			              .origin(address1)
			              .destination(address2)
			              .await();
			resultTimeHumanRead = result.routes[0].legs[0].duration.humanReadable;
			return resultTimeHumanRead;


		}catch(Exception e) {
			throw new Exception("Excpetion in getting duration with place id:" + e.getMessage());
		 }
	}

	public long getSecondDurationWithPlaceId(String address1,String address2,String mode)  throws Exception{
		try {
			long resultTime= 0;
			TravelMode travelMode = null;
			if(mode.equals("DRIVING")) {
				travelMode = TravelMode.DRIVING;
			}else if(mode.equals("WALKING")) {
				travelMode = TravelMode.WALKING;
			}else if(mode.equals("BICYCLING")) {
				travelMode = TravelMode.BICYCLING;
			}else if(mode.equals("TRANSIT")) {
				travelMode = TravelMode.TRANSIT;
			}else {
				travelMode = TravelMode.DRIVING;
			}

			DirectionsResult result =
			          DirectionsApi.newRequest(context)
			          	  .mode(travelMode)
			              .origin(address1)
			              .destination(address2)
			              .await();
			resultTime = result.routes[0].legs[0].duration.inSeconds;
			return resultTime;

		}catch(Exception e) {
			throw new Exception("Excpetion in getting duration with place id:" + e.getMessage());
		 }
	}



}

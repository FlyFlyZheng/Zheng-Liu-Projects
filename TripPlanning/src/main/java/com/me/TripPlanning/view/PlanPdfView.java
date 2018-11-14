package com.me.TripPlanning.view;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import com.me.TripPlanning.pojo.Place;
import com.me.TripPlanning.pojo.Plan;

public class PlanPdfView extends AbstractPdfView{


	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 Plan plan = (Plan) model.get("plan");
		 
		 Paragraph title = new Paragraph(plan.getPlanName());
		 title.setAlignment(1);
		 document.add(title);
		 Paragraph planDescription = new Paragraph(plan.getPlanDescription());
		 title.setAlignment(1);
		 document.add(planDescription);
		 
		 //name address
		 ArrayList<Place> places = new ArrayList<Place>();
		 for(Place place : plan.getPlaces()) {
			 places.add(place);
		 }
		 //description
		 ArrayList<String> placeDescription = new ArrayList<String>();
		 for(String str : plan.getPlaceDescription()) {
			 placeDescription.add(str);
		 }
		 //stay
		 ArrayList<Integer> placeStay = new ArrayList<Integer>();
		 for(int a : plan.getPlaceStay()) {
			 placeStay.add(a);
		 }
		//travelModes
		 ArrayList<String> travelModes = new ArrayList<String>();
		 for(String str : plan.getTravelModes()) {
			 travelModes.add(str);
		 }
		//travel time
		 ArrayList<String> plan_textDurations = new ArrayList<String>();
		 for(String str : plan.getTextDurations()) {
			 plan_textDurations.add(str);
		 }
		 
		 int num = places.size();
		 for(int i=0; i<num; i++) {
			 document.add(new Paragraph("place name:"+places.get(i).getName()));
			 document.add(new Paragraph("place address:"+places.get(i).getAddress()));
			 document.add(new Paragraph("place description:"+placeDescription.get(i)));
			 if(i<(num-1)) {
				 document.add(new Paragraph(" "));
				 document.add(new Paragraph("travel mode:"+travelModes.get(i)));
				 document.add(new Paragraph("travel duration:"+plan_textDurations.get(i)));
				 document.add(new Paragraph(" "));
			 }
			 document.add(new Paragraph(" "));
		 }
		 
		
		 
	}

}

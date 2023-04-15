package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class passingXMLRespones {
	
	//@Test(priority=1)
	void testXMLRespones() {
		given()
		    
		
		.when()
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		   .statusCode(200)
		   .header("Content-Type","application/xml; charset=utf-8")
		   .body("TravelerinformationRespones.page", equalTo("1"))
		   .body("TravelerinformationRespones.travelers.Travelerinformation[0].name",equalTo("Developer"));
	
		
	}
		 @Test   
		void testXMLResponesBody() {
			Response res = given()
			    
			
			.when()
			  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
			  
			  XmlPath xmlobj =new XmlPath(res.asString());
			  
//			  List<String> travelers = xmlobj.getList("TravelerinformationRespones.travelers.Travelerinformation");
//			  Assert.assertEquals(travelers.size(),10);
		
			 List<String> travelers_names=xmlobj.getList("TravelerinformationRespones.travelers.Travelerinformation.name"); 
			 boolean status = false;
			 for(String travelersname:travelers_names) {
				 System.out.println(travelersname);
				 if(travelersname.equals("AS")) {
					 status = true;
					 break;
				 }
			 }
			 System.out.println(status);
			 
		
	}

}

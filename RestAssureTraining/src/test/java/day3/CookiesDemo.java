package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo {
	//@Test(priority=1)
	void testCookies() {
		
		given()
		
		.when()
		   .get("https://www.google.com/")
		
		.then()
		  .cookie("AEC","ARSKqsLXdPkpZmhRvHrugkZmNKz_9yTfygxd5uE2_hmxyJWrd-BOVxX8Nps")
		  .log().all();
		
		
		
		
	}

@Test(priority=1)	
void getCookies() {
		
	Response res=given()
		
		.when()
		   .get("https://www.google.com/");

//	   String Cookie_value=res.getCookie("AEC");
//	   System.out.println(Cookie_value);
	
	 Map<String,String> cookies_value= res.getCookies();
	 
	 for(String value:cookies_value.keySet()) {
		 String cookie_val = res.getCookie(value);
		 System.out.println(value+"-----"+cookie_val);
	 }
		

		
		
		
		
	}

}

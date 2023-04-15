package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class HeaderDemo {
	@Test(priority=1)
	void testHeader() {
		
		given()
		
		
		.when()
		   .get("https://www.google.com/")
		
		.then()
		  .header("content-type","text/html; charset=ISO-8859-1");
		 
		
	}

}

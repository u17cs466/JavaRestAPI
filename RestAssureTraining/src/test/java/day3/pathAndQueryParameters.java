package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class pathAndQueryParameters {
	
	//:---https://reqres.in/api/users?page=2
	
	@Test(priority=1)
	void testPathParameter() {
		
		given()
		   .pathParam("mypath", "users")
		   .queryParam("page", 2)
		.when()
		    .get("https://reqres.in/api/{mypath}")
		
		.then()
		   .statusCode(200)
		   .log().all();
	}

}

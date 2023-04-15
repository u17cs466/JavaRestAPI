package day2;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HTTPRequest {
	int id;
	@Test(priority=1)
	void postUserData() {
		
		
		HashMap data=new HashMap();
		data.put("name","morpheus");
		data.put("job","leader");
		
		
		id=given()
		   .contentType("application/json")
		   .body(data)
		
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");
		
//		.then()
//		  .statusCode(201)
//		  .body("name",equalTo("morpheus"))
//		  .body("job",equalTo("leader"))
////		  .header("content-type","application/json; charset=utf-8")
//		  .log().all();
		  
	}
	@Test(priority=2,dependsOnMethods= {"postUserData"})
	void testDelete() {
		
		given()
		
		.when()
		   .delete("https://reqres.in/api/users/"+id)
		
		.then()
		  .statusCode(204);
		
	}

}

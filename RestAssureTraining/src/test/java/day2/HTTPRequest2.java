package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//org.json request

import java.util.HashMap;
public class HTTPRequest2 {
	int id;
	@Test(priority=1)
	void postUserDataUsingOrgJson() {
	
		JSONObject data= new JSONObject();
		given()
		   .contentType("application/json")
		   
		
		.when()
		   .post("https://reqres.in/api/users");
		   
		
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

package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class jsonQuery {
	@Test(priority=1)
	void testQueryAndPathParamater() throws FileNotFoundException {
		File f=new File(".\\body.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
	         .post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("morpheus"))
		.log().all();
	}

}

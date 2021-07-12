package Demos;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONArray;

public class Tests_GET_PathParam {
	@Test
	public void test_01()
	{
		given()
		.get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).body("data.first_name",hasItems("Michael","Lindsay"));
		//log().all();//logs the response on the console
		
		
		
	}
	@Test
	public void test_localhost_get_pathParam()
	{
		
		given()
        	.baseUri("http://localhost:8080/api/tutorials")
        	.pathParam("id",2)
       .when()
        .get("/{id}").then().log().all();
       //.then().statusCode(200).body("title", hasItems("my 1st book","my 2nd book"));

        //JSONArray JSONResponseBody = new   JSONArray(response.body().asString());
		//Assert.assertEquals(JSONResponseBody.getJsonObject(0).getString("fieldName"), "TextName");
		
		
	}
	
	

}

package Demos;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Tests_httpMethods_Local{
	//@Test
	public void test_01_put()
	{
		//POST Request using maps.....
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("name","Haritha");
		//map.put("job", "SET");
		//System.out.println(map);


		JSONObject request=new JSONObject();
		request.put("name","Haritha");
		request.put("job", "SET");
		System.out.println(request);
		given().
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).log().all();

	}
	//@Test
	public void test_local_delete()
	{
		
		
		when().
			delete("http://localhost:8081/api/tutorials/5").
		then().
			statusCode(204);

	}

	//@Test
	public void test_local_put() {//Update

		JSONObject request=new JSONObject();
		request.put("title", "my 5th book");
		request.put("description","Fifth description"); 
		given(). 
				contentType(ContentType.JSON).
				body(request.toJSONString()). 
		when().
				put("http://localhost:8081/api/tutorials/5").
		then().
				statusCode(200).log().all();
	}

	@Test public void test_local_post() { //Create
		
		JSONObject request=new JSONObject();
	    request.put("title", "my 2nd book"); 
	    request.put("description","second description");
	    String response= given(). 
	    	contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("http://localhost:8081/api/tutorials"). 
		then().
			log().all()
			.assertThat().statusCode(201).extract().response().asString();//.body("title",equalTo("Fourth description"));
	    System.out.println(response);
	    JsonPath js=new JsonPath(response);
	    String id=js.getString("id");
	    System.out.println(id);
	    
	    //update 
	    JSONObject requestUpdate=new JSONObject();
	    requestUpdate.put("title", "my 2nd book");
	    requestUpdate.put("description","updated second description"); 
		given(). 
				contentType(ContentType.JSON).
				body(requestUpdate.toJSONString()). 
		when().
				put("http://localhost:8081/api/tutorials/"+id).
		then().
				statusCode(200).log().all().body("description",equalTo("updated second description"));

	}
	 
	

}

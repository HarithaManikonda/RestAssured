package Demos;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends DataForTests
{
	
	
	@Test(dataProvider = "DataForPost")
	public void test_local_post(String title,String desc)
	{ 
		
		JSONObject request=new JSONObject();
		
	    request.put("title", title); 
	    request.put("description",desc);
	    
	    given(). 
	    	contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("http://localhost:8080/api/tutorials"). 
		then().
			statusCode(201).
			log().all();

	}
	
   @Test(dataProvider ="DeleteData")
	public void test_local_delete(int id)
	{
		when().
			delete("http://localhost:8080/api/tutorials/"+id).
		then().
			statusCode(204);

	}
    @Parameters("id")
    @Test
	public void test_local_delete_params(int id)
	{
		when().
			delete("http://localhost:8080/api/tutorials/"+id).
		then().
			statusCode(204);

	}
    
}

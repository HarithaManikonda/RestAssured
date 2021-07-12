package Demos;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class Tests_POST {
	@Test
	public void test_01_post()
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
			post("https://reqres.in/api/users").
		then().
			statusCode(201).log().all();

	}

}

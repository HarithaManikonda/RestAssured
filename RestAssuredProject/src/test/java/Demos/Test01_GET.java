package Demos;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	@Test
	public void test_01()
	{
		
		Response response=get("https://reqres.in/api/users?page=2");
		
		System.out.println("statusCode is: "+response.statusCode());
		System.out.println("Response is: "+response.asString());
		System.out.println("Response Time: "+response.getTime());
		System.out.println(response.statusLine());
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test
	void test_02()
	{
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
	}

}

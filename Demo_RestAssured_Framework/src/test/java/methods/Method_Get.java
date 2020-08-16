package methods;
import static io.restassured.RestAssured.*;


import org.hamcrest.collection.HasItemInArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class Method_Get {
	
	String baseUrl="https://reqres.in";
	
	@Test(enabled=true)
	public void listUsers()
	{
		when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.log().body()
			.statusCode(200)
			.body("size()",equalTo(6))
			.body("data.email",hasItems("michael.lawson@reqres.in", "lindsay.ferguson@reqres.in"));
	
	}
	
	@Test(enabled=true)
	public void listUsers_Negative_TC()
	{
		int incorrectPageValue=3;
		when()
			.get("https://reqres.in/api/users?page="+incorrectPageValue)
		.then()
			.log().body()
			.statusCode(200)
			.body("data",empty());
		
	}
	
	

	@Test(enabled=true)
	public void singleUser()
	{
		 String response=given().get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.body("size()",equalTo(1))
		.body("data[0].id",equalTo(2)).extract().asString();
		
		Assert.assertTrue(response.contains("janet.weaver@reqres.in"));
		
	}
	

	@Test(enabled=false)
	public void singleUserNotFound()
	{
		given().get("https://reqres.in/api/users/23").then().statusCode(404);
	}
	

	@Test(enabled=false)
	public void listResource()
	{
		given().get("https://reqres.in/api/unknown").then().statusCode(200);
	}
	
	@Test(enabled=false)
	public void singleResource()
	{
		given().get("https://reqres.in/api/unknown/2").then().statusCode(200);
	}
	
	@Test(enabled=false)
	public void singleResourceNotFound()
	{
		given().get("https://reqres.in/api/unknown/23").then().statusCode(404);
	}

}

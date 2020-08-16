package methods;

import org.testng.annotations.Test;

import utility.DataProvider_Post;

import static io.restassured.RestAssured.*;


import org.hamcrest.collection.HasItemInArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class Method_Post extends DataProvider_Post{
	
	@Test(dataProvider="user_data")
	public void createUser(String fName,String job)
	{
		
		JSONObject user=new JSONObject();
		user.put("name", fName);
		user.put("job", job);
		
		System.out.println(user);
		
		given()
			.header("Content-Type","application/json")
			.body(user.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.log().body()
			.statusCode(201)
			.assertThat().body(containsString("createdAt"));

	}

}

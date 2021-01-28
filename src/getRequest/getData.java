package getRequest;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class getData {
	
		
	String url1="https://httpbin.org/get";
	String url2="https://reqres.in/api/users?page=2";
	String url3="https://jsonplaceholder.typicode.com/users";
	String url4 = "https://api.openweathermap.org/data/2.5/weather?q=Paris&appid=14f61d11ad282e306f4f1ad66dcc5d6e";
	

	/*@BeforeTest
	public void beforeTest() {

		//RestAssured.proxy("165.225.104.32", 9400); //Authentication API is outside network and requires proxy

		System.setProperty("http.proxyHost", "gateway.zscaler.net");
		System.setProperty("http.proxyPort", "9400");
		
		//RestAssured.reset();
	}*/
	
  @Test
  public void testResponseCode() {
	  
	  
	  
	  
	  Response resp = RestAssured.get(url4);
	  
	  int code = resp.getStatusCode();
	  
	  System.out.println("Status code is: "+ code);
	  
	  Assert.assertEquals(200, code);
	  
	  
	  
  }
  
  @Test
  public void testResponseData() {
	  
	  Response resp=RestAssured.get(url4);
	  
	  String data = resp.asString();
	  
	  System.out.println("Response data is: "+ data);
	  
		  
	  
	  
  }
  
}

package getRequest;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC6_Get_Data {
	
	
	
	
	/*@BeforeTest
	public void beforeTest() {

		//System.setProperty("http.proxyHost", "gateway.zscaler.net");
		//System.setProperty("http.proxyPort", "9400");
		
			
		
	}*/
	
  @Test
  public void validateresponsenodesandvalue() {
	  
	  //Specify base URI
	  
	  RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
	  //RestAssured.baseURI = "https://httpbin.org/get";
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Specify Response object
	  Response response = httpRequest.request(Method.GET, "?q=Paris&appid=14f61d11ad282e306f4f1ad66dcc5d6e");
	  //Response response = httpRequest.request(Method.GET);
	  
	  
	  //Validate response node and values
	  JsonPath jsonpath = response.jsonPath();
	  
	  System.out.println("Temeperature is " + jsonpath.get("temp"));
	  System.out.println("Pressure is " + jsonpath.get("pressure"));
	  System.out.println("Humidity is" + jsonpath.get("humidity"));
	  
	  Assert.assertEquals("277.76", jsonpath.get("temp"));
	  Assert.assertEquals("1037", jsonpath.get("pressure"));
	  Assert.assertEquals("86", jsonpath.get("humidity"));
	  
	  
	  
	  
	  
  }
}

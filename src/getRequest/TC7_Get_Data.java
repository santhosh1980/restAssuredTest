package getRequest;

import org.testng.annotations.Test;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC7_Get_Data {
	
	
	
	
	/*@BeforeTest
	public void beforeTest() {

		//System.setProperty("http.proxyHost", "gateway.zscaler.net");
		//System.setProperty("http.proxyPort", "9400");
		
			
		
	}*/
	
  @Test
  public void authorization() {
	  
	  //Specify base URI
	  
	  RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
	  //RestAssured.baseURI = "https://httpbin.org/get";
	  
	  //Basic authentication
	  PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
	  authscheme.setUserName("ToolsQA");
	  authscheme.setPassword("Testpassword");
	  
	  RestAssured.authentication = authscheme;
	  
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Specify Response object
	  //Response response = httpRequest.request(Method.GET, "?q=Paris&appid=14f61d11ad282e306f4f1ad66dcc5d6e");
	  Response response = httpRequest.request(Method.GET);
	  
	  
	//Print response
	  String responseBody = response.getBody().asString();
	  System.out.println("Response is: " + responseBody );
	  
	  //Status code validation
	  int statuscode = response.getStatusCode();
	  System.out.println("Status code is: " + statuscode);
	  Assert.assertEquals(200, statuscode);
	  
	  
	  
  }
}

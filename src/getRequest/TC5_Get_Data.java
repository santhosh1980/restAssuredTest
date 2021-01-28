package getRequest;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC5_Get_Data {
	
	
	
	
	/*@BeforeTest
	public void beforeTest() {

		System.setProperty("http.proxyHost", "165.225.104.32");
		System.setProperty("http.proxyPort", "9400");
		
		Authenticator authenticator = new Authenticator(){
		     public PasswordAuthentication getPasswordAuthentication() {
		    	    return (new PasswordAuthentication("U35035","Bijun1980@248".toCharArray()));
		    	    }
		    	};
		    	Authenticator.setDefault(authenticator);
	}
	*/
  @Test
  public void validateresponsenode() {
	  
	  //Specify base URI
	  
	  //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
	  RestAssured.baseURI = "https://httpbin.org/get";
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Specify Response object
	  //Response response = httpRequest.request(Method.GET, "?id=1");
	  Response response = httpRequest.request(Method.GET);
	  
	  //Print response
	  String responseBody = response.getBody().asString();
	  System.out.println("Response is: " + responseBody );
	  
	  //Validate response node
	  Assert.assertEquals(true, responseBody.contains("origin"));
	  
	  
	  
	  
  }
}

package getRequest;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC1_Get_Data {
	
	
	
	
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
  public void validateresponsecode() {
	  
	  //Specify base URI
	  
	  //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
	  //RestAssured.baseURI = "https://httpbin.org/get";
	  //RestAssured.baseURI = "https://gorest.co.in/public-api/posts";
	  //RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
	  //RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
	  //RestAssured.baseURI="https://jsonplaceholder.typicode.com/comments";
	  
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Specify Response object
	  Response response = httpRequest.request(Method.GET, "?id=1");
	  //Response response = httpRequest.request(Method.GET,"/7");
	  //Response response=httpRequest.request(Method.GET,"?postId=2");
	  
	  //Print response.
	  String responseBody = response.getBody().asString();
	  System.out.println("Response is: " + responseBody );
	  
	  //Status code validation
	  int statuscode = response.getStatusCode();
	  System.out.println("Status code is: " + statuscode);
	  Assert.assertEquals(200, statuscode);
	  
	  //Status line validation
	  String statusline = response.statusLine();
	  System.out.println("Status line is: " + statusline);
	  Assert.assertEquals("HTTP/1.1 200 OK", statusline);
	  
  }
}

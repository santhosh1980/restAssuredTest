package getRequest;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC2_Post_Data {
	
	
	
	
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
  public void registersuccess() {
	  
	  //Specify base URI
	  
	  RestAssured.baseURI = "http://dummy.restapiexample.com/create";
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  
	  //Request payload sending with post request
	  JSONObject requestparams= new JSONObject();
	  requestparams.put("name", "myworld");
	  requestparams.put("salary", "1235");
	  requestparams.put("age", "32");
	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestparams.toJSONString());
	  
	//Specify Response object
	  
	  Response response = httpRequest.request(Method.POST);
	  
	  //Print response
	  String responseBody = response.getBody().asString();
	  System.out.println("Response is: " + responseBody );
	  
	  //Status code validation
	  int statuscode = response.getStatusCode();
	  System.out.println("Status code is: " + statuscode);
	  Assert.assertEquals(201, statuscode);
	  
	  //Success message validation
	  String successmessage = response.jsonPath().get("SuccessCode");
	  Assert.assertEquals("OPERATION_SUCCESS", successmessage);
	  
	  
  }
}

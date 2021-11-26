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

public class TC3_Get_Data {
	
	
	
	
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
  public void validateheader() {
	  
	  //Specify base URI
	  
	  //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
	RestAssured.baseURI = "https://httpbin.org/get";
	  
	  //RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather?q=Paris&appid=14f61d11ad282e306f4f1ad66dcc5d6e";
	  
	 // RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=2b1fd2d7f77ccf1b7de9b441571b39b8";
	  
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Specify Response object
	  //Response response = httpRequest.request(Method.GET, "?id=1");
	  Response response = httpRequest.request(Method.GET);
	  
	  //Print response
	  String responseBody = response.getBody().asString();
	  System.out.println("Response is: " + responseBody );
	  
	  //Validating headers
	  String contentType = response.header("Content-Type");//capture details of content type
	  //String contentType = response.getHeader("Content-Type");//same as above method
	  System.out.println("Content Type is: "+contentType);
	  Assert.assertEquals("application/json", contentType);
	  
	  String contentLength = response.header("Content-Length");//capture details of content length
	  //String contentlength = response.getHeader("Content-Length");//same as above method
	  System.out.println("Content Length is: "+contentLength);
	  Assert.assertEquals("323", contentLength);
	  
	  String servertype = response.header("Server");//capture details of server type
	  //String servertype = response.getHeader("servertype");//same as above method
	  System.out.println("Server type is: "+servertype);
	  Assert.assertEquals("gunicorn/19.9.0", servertype);
	  
  }
}

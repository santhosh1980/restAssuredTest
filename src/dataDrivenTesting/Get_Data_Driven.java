package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import lib.ExcelDataConfig;


public class Get_Data_Driven {
	
	@Test(dataProvider="iddataprovider")
	public void getemployee(String id) throws Exception{
	
	//Specify base URI
	  
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
	  
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Specify Response object
	  //Response response = httpRequest.request(Method.GET, "?id=1");
	  Response response = httpRequest.request(Method.GET,"/"+id);
	  
	  //Print response
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
	
	//Data provider method
	  @DataProvider(name="iddataprovider")
	  public String [][] getempid(){
		  
		  //Read data from excel
//		  String datapath = "C:\\Users\\U35035\\eclipse-workspace\\Data\\empdata.xlsx";
//		  
//		  ExcelDataConfig excel = new ExcelDataConfig(datapath);
//		  
//		  int rownum= excel.getrownum(1);
//		  
//		  int colnum=excel.getcolnum(1, 1);
//		  
//		  String id[][]= new String[rownum][colnum];
//		  
//		  for (int i=0;i<=rownum; i++) {
//			  for (int j=0;j<colnum; j++) {
//				  id[i][j]=excel.getData(0, i, j);
//			  }
//		  }
//		  //hard code data
		  String id[][]= {{"23"},{"22"},{"24"}};
		  return id;
	  }
}

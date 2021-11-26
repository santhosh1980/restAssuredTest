package dataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import lib.ExcelDataConfig;

public class Post_Data_Driven {
	
  @Test(dataProvider="empdataprovider")
  public void postaddemployee(String ename, String esalary, String eage) throws Exception {
	  
//Specify base URI
	  
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
	  
	  //Specify Request object
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  
	  //Request payload sending with post request
	  JSONObject requestparams= new JSONObject();
	  requestparams.put("name", ename);
	  requestparams.put("salary", esalary);
	  requestparams.put("age", eage);
	  
	  //Add a header stating that request body is json
	  httpRequest.header("Content-Type","application/json");
	  
	  //Add the json to the body of the request
	  httpRequest.body(requestparams.toJSONString());
	  
	  //Specify Response object and post request
	  Response response = httpRequest.request(Method.POST);
	  
	  //Print response and Capture response body to perform validations
	  String responseBody = response.getBody().asString();
	  System.out.println("Response is: " + responseBody );
	  Assert.assertEquals(true, responseBody.contains(ename));
	  Assert.assertEquals(true, responseBody.contains(esalary));
	  Assert.assertEquals(true, responseBody.contains(eage));
	  
	  
	  //Status code validation
	  int statuscode = response.getStatusCode();
	  Assert.assertEquals(200, statuscode);
	  
	  
	  
	  
	  
	  
  }
  //Data provider method
  @DataProvider(name="empdataprovider")
  public String [][] getempdata(){
	  
	  //Read data from excel
	  String datapath = "C:\\Users\\U35035\\eclipse-workspace\\Data\\empdata.xlsx";
	  
	  ExcelDataConfig excel = new ExcelDataConfig(datapath);
	  
	  int rownum= excel.getrownum(0);
	  
	  int colnum=excel.getcolnum(0, 1);
	  
	  String empdata[][]= new String[rownum][colnum];
	  
	  for (int i=0;i<=rownum; i++) {
		  for (int j=0;j<colnum; j++) {
			  empdata[i][j]=excel.getData(0, i, j);
		  }
	  }
	  
	  //hard code data
	  //String empdata[][]= {{"avvv","13000","23"},{"cdww","14000","25"},{"sdxx","17000","24"}};
	  return empdata;
  }
  
}

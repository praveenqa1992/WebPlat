package API;

import org.testng.annotations.Test;
import io.appium.java_client.pagefactory.bys.ContentType;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.response.Response;

public class getTransactionHistory {
	
	String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiI5NjA0NjA5MzIxIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Ijk2MDQ2MDkzMjEtc2hpbHBhLSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiNDM5IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiNiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3NwbiI6IlJUIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc2lkIjoiNTI5IiwibmJmIjoxNzI2NzcwODc4LCJleHAiOjE3MjY4MzA4NzgsImlzcyI6IkFQSSIsImF1ZCI6IldlYiJ9.5wGNSMNu_qx496ELj9bwdq0KIUWOj04Djc72nSXNthA";
	
  @Test
  public void getTransactionHistory() {
	  
	  HashMap header = new HashMap();
	  header.put("authorization", token);

	  
	  Response history = given()
	  
	  	//.contentType("application/json")
	  	.headers(header)
	  

			  
			  .when().get("https://newapi.webplat.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10")
			  
			  .then()
			  	.statusCode(200)
//			  	.body("statusCode",equalTo("0"))
			  	.extract().response();
			
			String printRes = history.asString();
			//JsonPath resJson1 = new JsonPath(printRes);
			System.out.println(printRes);
			  
	  
  }
}

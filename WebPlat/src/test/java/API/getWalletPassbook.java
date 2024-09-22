package API;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.pagefactory.bys.ContentType;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;



public class getWalletPassbook {
	
	String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiI5NjA0NjA5MzIxIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Ijk2MDQ2MDkzMjEtc2hpbHBhLSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiNDM5IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiNiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3NwbiI6IlJUIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc2lkIjoiMSIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvZHNhIjoiZGM0MmUxN2QtODUyZi00OWMyLWEyODAtZTgyODY0ODAzZjhlIiwibmJmIjoxNzI2OTU2NjQ3LCJleHAiOjE3MjcwMTY2NDcsImlzcyI6IkFQSSIsImF1ZCI6IldlYiJ9.s2YvB6loG7i0EEGf9CaogDVW-hhanaRb615B6Ku1aaU";
	
	public void walletPassbook() {
		
		 HashMap header = new HashMap();
		  header.put("authorization", token);

		  
		  Response response = given()
		  
		  	//.contentType("application/json")
		  	.headers(header)
		  

				  
				  .when().get("https://newapi.webplat.in/reporting/api/report-module/ledgerdatawallet1/user-wise?fromDate=09/01/2024&toDate=09/21/2024&userId=&orderId=&TransactionType=&username=&pageNumber=1&pageSize=10")
				  
				  .then()
				  	.statusCode(200)
//				  	.body("statusCode",equalTo("0"))
				  	.extract().response();
				
				
				JsonPath js = response.jsonPath();
				String totalCount1 = js.get("data.remarks");
//				ResponseBody body = response.body();
//				
//				String printRes = body.asString();
//				String totalCount = printRes.contains(totalCount);
				
				ArrayList<String> pagination = js.get("pagination");
				
//				for (String m: pagination) {
//					System.out.println(m);
//					
//				}
//				
				System.out.println(pagination);
		
	}
	
	
	
	
	

}

package API;

import org.testng.annotations.Test;
import io.appium.java_client.pagefactory.bys.ContentType;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class TC001_TransactionHistoryAPI {

	
	@Test(priority=1)
	public void getTxnHistory () {
		
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiI5NjA0NjA5MzIxIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Ijk2MDQ2MDkzMjEtc2hpbHBhLSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiNDM5IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiNiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3NwbiI6IlJUIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc2lkIjoiMSIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvZHNhIjoiYjE1Yjk5M2YtY2Y4Yi00YTQ4LTk0ODQtOWRlNjJkNDBhNTM1IiwibmJmIjoxNzI3MTg3NDcwLCJleHAiOjE3MjcyNDc0NzAsImlzcyI6IkFQSSIsImF1ZCI6IldlYiJ9.WhyaFwr9kZhx-55JoMKNbayORFfxp_DL70DnqVm1kr8";
		
		Map <String,String> hm = new HashMap <String,String>();
		hm.put("authorization",token);
		
		
	//Response resp = given()
	//		.headers(hm)
//		
//		.when()
//		.get("//newapi.webplat.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10");
//		
//		
//		JSONObject jObject = new JSONObject();
//	
//		
		
	}
	
	
	
	
	
	
	
	
}

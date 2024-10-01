package API;

import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.appium.java_client.pagefactory.bys.ContentType;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.management.openmbean.KeyAlreadyExistsException;

public class TC001_TransactionHistoryAPI {

	
	
	
	String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiI5NjA0NjA5MzIxIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Ijk2MDQ2MDkzMjEtc2hpbHBhLSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiNDM5IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiNiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3NwbiI6IlJUIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc2lkIjoiNTI5IiwibmJmIjoxNzI3NjY4ODE2LCJleHAiOjE3Mjc3Mjg4MTYsImlzcyI6IkFQSSIsImF1ZCI6IldlYiJ9.TApyQ6kE1yPsgTPF0dmxsTkmajVvyOhXEyHjpt3qMkw";

	@Test(priority=1,enabled=false)
	public void transactionHistory_getAPIresp() {

		HashMap header = new HashMap();
		header.put("authorization", token);

		Response history = given()

				// .contentType("application/json")
				.headers(header)

				.when()
				.get("https://qa.uatdev.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10")

				.then().statusCode(200)
//				  	.body("statusCode",equalTo("0"))
				.extract().response();
// response convert to string then print -------------	
		//all response in one line------
		String printRes = history.asString();
		// JsonPath resJson1 = new JsonPath(printRes);
		System.out.println("1. as string");
		System.out.println(printRes);
		
		//all response in one line----no need of printing syntax---
		 history.print();
		
		 //respnse in pretty format.........readable
		System.out.println("5.pretty print resp....no need to use printing syntax.......");
		  history.prettyPrint();

		//gives headers but list was less than postman..................WHY ??????????
		Headers allHeadersaa = history.getHeaders();
		System.out.println("6.headers list all...........");
		System.out.println(allHeadersaa);
		
		//status code e.g.200
		int respcod = history.getStatusCode();
		System.out.println("7. resp code...........");
		System.out.println(respcod);
		
		//status line which include status code ....more info than only status
		String stline = history.statusLine();
		System.out.println("4.ststus line...........");
		System.out.println(stline);
		
		
		String stlineget = history.getStatusLine();
		System.out.println("4a.get ststus line...........");
		System.out.println(stlineget);
		
		
		//time 
		long timeInSec = history.getTimeIn(TimeUnit.SECONDS);
		System.out.println("8. time in sect...........");
		System.out.println(timeInSec);
		
		//content type
		String ct = history.contentType();
		System.out.println("2.content type...........");
		System.out.println(ct);

		String getct = history.getContentType();
		System.out.println("2a.get content type...........");
		System.out.println(getct);

		//session id.....i got null
		String secid = history.getSessionId();
		System.out.println("3.session id...........");
		System.out.println(secid);

// handle below SCENARIOS / RESPONSES ---------------------------------------------------------------------------	
		byte[] respAsbyteArray = history.asByteArray();
		System.out.println("7.resp as byte array......check.....");
		System.out.println(respAsbyteArray.toString());

		Cookies allCook = history.detailedCookies();
		System.out.println("8.detailed cookies...........");
		System.out.println(allCook.asList());
		
		XmlPath xmlPathViewOfBody = history.htmlPath();
		System.out.println("9.xml path view of body...........");
		System.out.println(xmlPathViewOfBody);
		
		JsonPath jsonPathViewOfBody = history.jsonPath();
		System.out.println("10.json path view of body...........");
		System.out.println(jsonPathViewOfBody);
		
	}
	
	@Test(priority=2, enabled=true)
	public void transactionHistory_getAPIresp2() throws JSONException {

		Response txnHistoryApiResp = null;
		
		HashMap header = new HashMap();
		header.put("authorization", token);

		try {
		 txnHistoryApiResp = given()

				// .contentType("application/json")
				.headers(header)

				.when()
				.get("https://qa.uatdev.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10")

				
				.then()
				
				
				.statusCode(200)
				.extract().response();
				}
		catch (Exception e) 
		{
			
                System.out.println("ststus no match");
                System.out.println("exception captured is -"+e.toString());

		}
// response as string-------------	
		
//		System.out.println("4.pretty print resp...........");
//		txnHistoryApiResp.prettyPrint();
		System.out.println("1.................");
		

	String API_orderId_tid =	txnHistoryApiResp.path("data[0].orderId");
	System.out.println(API_orderId_tid);

	String API_categoryName =	txnHistoryApiResp.path("data[0].categoryName");
	System.out.println(API_categoryName);

	String API_serviceCode_name=	txnHistoryApiResp.path("data[0].serviceCode");
	System.out.println(API_serviceCode_name);

	String API_operatorName =	txnHistoryApiResp.path("data[0].operatorName");
	System.out.println(API_operatorName);

	String API_number_mob =	txnHistoryApiResp.path("data[0].number");
	System.out.println(API_number_mob);

	float API_amount =	txnHistoryApiResp.path("data[0].amount");
	System.out.println(API_amount);

	float API_acost_totalAmount =	txnHistoryApiResp.path("data[0].cost");
	System.out.println(API_acost_totalAmount);

	int API_status =	txnHistoryApiResp.path("data[0].status");
	System.out.println(API_status);

	String API_transactionDate =	txnHistoryApiResp.path("data[0].transactionDate");
	System.out.println(API_transactionDate);

	boolean API_isSettled =	txnHistoryApiResp.path("data[0].isSettled");
	System.out.println(API_isSettled);
	
	}

	
	@Test(priority=3, enabled=true)
	public void transactionHistory_getAPIresp_value() throws JSONException {

		HashMap header = new HashMap();
		header.put("authorization", token);

		Response txnHistoryApiResp = given()
				// .contentType("application/json")
				.headers(header)
				.when()
				.get("https://qa.uatdev.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10")
				.then()
				.statusCode(200)
				.extract().response();
// print resp to console-------------	
// txnHistoryApiResp.prettyPrint();
	
//		System.out.println("1.................");	
//		
//		System.out.println(txnHistoryApiResp.getBody().asString());
//		txnHistoryApiResp.getBody().asString();
		System.out.println("8.................");	

	JSONObject jObject= new JSONObject(txnHistoryApiResp.getBody().asString());
	
	System.out.println("1.....b.....");
	getValueFromApi_parsing(jObject,"pagination");
	System.out.println("2..........");

//	 txnHistoryApiResp.prettyPrint();
	
	
	}

	public static void getParameterValueFromApi (JSONObject jo, String key) throws JSONException {
		System.out.println("31.................");	

		System.out.println(jo.get(key));
		System.out.println("32.................");	

	
	}
	
	public static void getValueFromApi_parsing (JSONObject jo, String key) throws JSONException {

	     boolean keyExists =jo.has(key);
	     String nextKey;
		 Iterator<?> iterator;
			System.out.println("12..........");

		if(!keyExists) 
		{
			System.out.println("13..........");

			iterator =	jo.keys();
			
			if(iterator.hasNext())
			{
				System.out.println("14..........");

				 nextKey = (String)iterator.next();
				 try {
						System.out.println("15..........");

				//scenario 1=====> key is single object/value (not an array of object/values)	
					 
					    //1- if key match/found then return it
					if( jo.get(nextKey) instanceof JSONObject)	
					{
						System.out.println("16..........");

						 //2- if key no match/found then enter this if
						if(keyExists == false )
						{
							System.out.println("17..........");

							//call get key METHOD again but pass the jsonObject of new key...imp
							//to compare new object and new kay
							getValueFromApi_parsing(jo.getJSONObject(nextKey),key);
							
							System.out.println("17....bb......");

						}
					}
					
					//scenario 2=====> key is an array of object/values (not single object/value)	 

					else if (jo.get(nextKey) instanceof JSONArray)
						{
						System.out.println("18..........");

						//next key has multiple values/objects
						//convert to array to iterate
							JSONArray ja = jo.getJSONArray(nextKey);
							for (int a=0;a<ja.length();a++)
							{
								System.out.println("10....ja length is -"+ja.length());
							String nextKayValue_one =	ja.get(a).toString();
							
							//convert json value/key number one to json object	to get it'd value
							JSONObject jo2 = new JSONObject(nextKayValue_one);
							System.out.println("19..........");

								
							//same like above loop....if key one has no match with input/required key
								if(keyExists == false)
								{
									System.out.println("20..........");

									getValueFromApi_parsing(jo2,key);
									
									System.out.println("21..........");

								}
							
							}//close---loop
							
						}//close---if key is arry
											 
				 }//close----try of getting value of the mentioned key
				 catch (Exception e) 
				 {
                      System.out.println("Unable to het the value of the key -"+key);	
                      System.out.println(e);
	
			     }
		}//close----iterating if kay is not exists	
		else
		{
			System.out.println("22..........");

			getParameterValueFromApi(jo,key);
			
			System.out.println("jo -"+jo+" - "+key);

		}
	}// close---METHOD -----end
	
	
	}	
	
	
	public String transactionHistoryAPI_getTxnId() throws JSONException {

		HashMap header = new HashMap();
		header.put("authorization", token);

		Response txnHistoryApiResp = given()

				// .contentType("application/json")
				.headers(header)

				.when()
				.get("https://qa.uatdev.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10")

				.then()
				.statusCode(200)
				.extract().response();
// response as string-------------	
//		txnHistoryApiResp.prettyPrint();

            return txnHistoryApiResp.path("data[0].orderId");

	}
	
	public String transactionHistoryAPI_getCategoryName() throws JSONException {

		HashMap header = new HashMap();
		header.put("authorization", token);

		Response txnHistoryApiResp = given()

				// .contentType("application/json")
				.headers(header)

				.when()
				.get("https://qa.uatdev.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10")

				.then()
				.statusCode(200)
				.extract().response();
// response as string-------------	
//		txnHistoryApiResp.prettyPrint();
		
        	return txnHistoryApiResp.path("data[0].categoryName");

	}
	
	
	@Test(priority=5)
	public void transactionHistory_inProgress() throws JSONException {

		Response txnHistoryApiResp = null;
		
		HashMap header = new HashMap();
		header.put("authorization", token);

		try {
		 txnHistoryApiResp = given()
				// .contentType("application/json")
				.headers(header)
				.when()
				.get("https://qa.uatdev.in/reporting/api/report-module/transactiondata/user-wise?fromDate=08/01/2024&toDate=08/31/2024&SearchUserName=&CategoryId=&OperatorId=&serviceId=&SearchUserID=&pageNumber=1&pageSize=10")
				.then()
				.statusCode(200)
				.extract().response();
				}
		catch (Exception e) 
		{
                System.out.println("status no match");
                System.out.println("exception captured is -"+e.toString());
		}
// response as string-------------	
//		System.out.println("4.pretty print resp...........");
//		txnHistoryApiResp.prettyPrint();
		System.out.println("1.................");
		

	String API_orderId_tid =	txnHistoryApiResp.path("data[0].orderId");
	System.out.println("order id -"+API_orderId_tid);

	String API_categoryName =	txnHistoryApiResp.path("data[0].categoryName");
	System.out.println("cat name -"+API_categoryName);
	
	JSONObject jo= new JSONObject(txnHistoryApiResp.getBody().asString());
	
	JSONArray ja = new JSONArray(jo);
	
	int jaLength = jo.length();
	System.out.println("Json array length is -"+jaLength);

	
	for(int a=0;a<jaLength;a++)
	{
		System.out.println("Json array length is -"+a);
		
	    String catNameCaptured=	txnHistoryApiResp.path("data["+a+"].categoryName");

		System.out.println("cat name is -========="+catNameCaptured);
		
		if(catNameCaptured.equalsIgnoreCase("Telecom")) {
			
			System.out.println("captured TELECOM cat name ---"+catNameCaptured);

		}
		else {
			System.out.println("NOT captured TELECOM cat name ---");

		}
		
		
	}
	
		
	
	}

	
	
}

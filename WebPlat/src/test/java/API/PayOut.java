package API;

import org.testng.annotations.Test;

import io.appium.java_client.pagefactory.bys.ContentType;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

import java.util.HashMap;

public class PayOut {
  @Test
  public void verifyPayout() {
	  
	  HashMap payOut = new HashMap();
	  payOut.put("clientId", "53cea0ae-cd15-48fd-b5c0-f4b8f07e0376");
	  payOut.put("secretKey", "230b9b75-998a-4c36-bfdd-ea07eb326b3f");
	  payOut.put("number", "1666666666");
	  payOut.put("amount", "1");
	  payOut.put("transferMode", "IMPS");
	  payOut.put("accountNo", "34162013445");
	  payOut.put("ifscCode", "SBIN0011147");
	  payOut.put("beneficiaryName", "Vikrant Kokate");
	  payOut.put("vpa", "");
	  payOut.put("clientOrderId", "TESTVAK02113");
	  payOut.put("latitude", "18.448740");
	  payOut.put("longitude", "73.828629");
	  
	  
	  
	Response payout =  given()
	  
	  	.body(payOut)
	  	.contentType("application/json")
	  
	  .when().post("https://qa.uatdev.in/api/api/api-module/payout/payout")
	  
	  .then()
	  	.statusCode(200)
//	  	.body("statusCode",equalTo("0"))
	  	.extract().response();
	
	String printRes = payout.asString();
	JsonPath resJson1 = new JsonPath(printRes);
	System.out.println(resJson1);
	  
	  

  }
}

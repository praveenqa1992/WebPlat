package testRun;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
import pageObjects.TransactionHistoryPOM;
import testCases.TC1_VerifyLogin;
import utility.testbase;

public class softAssertTesting extends testbase{
 
	
	@Test(priority=1)
  public void one() throws InterruptedException, IOException {
	  
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();
		
//login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
	  
        
        /**********************************************************************************************************************************/		
		/*** Success Assertion **/
		logger.log(LogStatus.INFO, "success assertion ");
		
String actualTitle = driver.getTitle();
String expectedTitle = "Dashboard";

boolean result = commonfunc.compareString(actualTitle, expectedTitle,false, logger);

commonfunc.softAssert("Verify dashboard page title -", actualTitle, expectedTitle, result, logger);
/**********************************************************************************************************************************/		


/**********************************************************************************************************************************/		
		/*** Fail Assertion **/
logger.log(LogStatus.INFO, "fail assertion ");

String expectedTitle1 = "Dashboard1";
boolean result1 = commonfunc.compareString(actualTitle,expectedTitle1,false, logger);
commonfunc.softAssert("Verify dashboard page title (fail intentionally)-", actualTitle, expectedTitle1, result1, logger);
/**********************************************************************************************************************************/

logger.log(LogStatus.INFO, "Step 2: logged in successfully ");

	  
  }
	
	
	@Test(priority=2)
	  public void two() throws InterruptedException, IOException {
		  
			TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
			TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
			commonFunc commonfunc = new commonFunc();
			SoftAssert softAssert = new SoftAssert();
	//login...
			tC1_VerifyLogin.verifySignIn(driver, logger);
		  
	        
	        /**********************************************************************************************************************************/		
			/*** Success Assertion **/
			logger.log(LogStatus.INFO, "success assertion ");
			
	String actualTitle = driver.getTitle();
	String expectedTitle = "Dashboard";

	boolean result = commonfunc.compareString(actualTitle, expectedTitle,false, logger);

	commonfunc.softAssert("Verify dashboard page title -", actualTitle, expectedTitle, result, logger);
	/**********************************************************************************************************************************/		


	/**********************************************************************************************************************************/		
			/*** Fail Assertion **/
	logger.log(LogStatus.INFO, "fail assertion ");

	String expectedTitle1 = "Dashboard1";
	boolean result1 = commonfunc.compareString(actualTitle,expectedTitle1,false, logger);
	commonfunc.softAssert("Verify dashboard page title (fail intentionally)-", actualTitle, expectedTitle1, result1, logger);
	/**********************************************************************************************************************************/

	logger.log(LogStatus.INFO, "Step 2: logged in successfully ");

	softAssert.assertAll();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
}

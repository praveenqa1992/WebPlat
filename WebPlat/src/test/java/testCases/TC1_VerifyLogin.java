package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
import pageObjects.Login;
import pageObjects.TransactionHistoryPOM;
import utility.config;
import utility.testbase;

/**********************************************************************************************************************************
 * @author : Praveen Kumar QC ID : TC-1 JIRA ID : Date :
 *******************************************************************************************************************************/

public class TC1_VerifyLogin extends testbase {

	@Test
	public void verifySignIn(WebDriver driver, ExtentTest logger) throws InterruptedException, IOException {

		Login login = new Login(driver, logger);
		testConfig = new config(logger);
		// commonFunc comm =new commonFunc();

		String user = testConfig.getRunTimeProperty("username");
		String pass = testConfig.getRunTimeProperty("password");

		logger.log(LogStatus.INFO, "Step 1: Goto \"https://merchant.uatdev.in/\" ");

		login.signin(user, pass);
		
		logger.log(LogStatus.INFO, "Step 2: logged in successfully ");

		Thread.sleep(5000);
		login.dialogClose();

//		String actualTitle = driver.getTitle();
//
//		logger.log(LogStatus.INFO, "Step 3: soft assert ");
//		
//		/**********************************************************************************************************************************/
//		/*** Success Assertion **/
//
//		String expectedTitle = "Dashboard";
//
//		commonFunc comm = new commonFunc();
//		boolean result = comm.compareString(actualTitle,expectedTitle, false);
//
//		comm.softAssert("Verify dashboard page title -", actualTitle,expectedTitle, result, logger);
//		/**********************************************************************************************************************************/
//
//		/**********************************************************************************************************************************/
//		/*** Fail Assertion **/
//
//		String expectedTitle1 = "Dashboard1";
//
//		boolean result1 = comm.compareString(actualTitle,expectedTitle1,  false);
//
//		comm.softAssert("Verify dashboard page title (fail intentionally)-",  actualTitle,expectedTitle1, result1,
//				logger);
//		/**********************************************************************************************************************************/
//
//		
//		logger.log(LogStatus.INFO, "Step 4: HARD assert ");
//		String expectedTitle2 = "Dashboard1";
//
//		boolean result2 = comm.compareString(expectedTitle1, actualTitle, false);
//
//		comm.hardAssert("Verify dashboard page title (fail intentionally)-", actualTitle, expectedTitle2, result2,
//				logger);
//		
//		logger.log(LogStatus.INFO, "Step 5: again soft assert ");
//
//		boolean result3 = comm.compareString(actualTitle,expectedTitle,  false);
//
//		comm.softAssert("Verify dashboard page title -", actualTitle,expectedTitle,  result3, logger);

	}

}
package testCases;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Login;
import pageObjects.TransactionHistoryPOM;
import utility.config;
import utility.testbase;

/**********************************************************************************************************************************
 * @author : Praveen Kumar
 * QC ID   : TC-1
 * JIRA ID : 
 * Date    :
 * *******************************************************************************************************************************/


public class TC1_VerifyLogin  extends testbase{


	@Test
	public void verifySignIn(WebDriver driver, ExtentTest logger ) throws InterruptedException, IOException  {
	
		Login login = new Login (driver,logger);
		testConfig = new config(logger);
		//commonFunc comm =new commonFunc();
		
		String user = testConfig.getRunTimeProperty("username");
		String pass = testConfig.getRunTimeProperty("password");

		logger.log(LogStatus.INFO, "Step 1: Goto \"https://merchant.uatdev.in/\" ");

		login.signin(user, pass);
		Thread.sleep(5000);
		login.dialogClose();
	
		
	logger.log(LogStatus.INFO, "Step 2: logged in successfully ");

		
		
	}

}
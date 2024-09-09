package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Login;
import pageObjects.MobileRecharge;
import utility.testbase;

/**********************************************************************************************************************************
 * @author : Praveen Kumar
 * QC ID   : TC-2
 * JIRA ID : 
 * Date    :
 * *******************************************************************************************************************************/


public class TC2_VerifyMobileRecharge  extends testbase{


	@Test
	public void verifyMobileRecharge( ) throws InterruptedException, IOException  {
		MobileRecharge recharge = new MobileRecharge (driver,logger);
		
		TC1_VerifyLogin logIn = new TC1_VerifyLogin();
		
//		logIn.verifySignIn();
//

	}

}
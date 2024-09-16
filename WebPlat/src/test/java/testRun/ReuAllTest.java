package testRun;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.TransactionHistoryPOM;
import testCases.TC1_VerifyLogin;
import utility.testbase;

public class ReuAllTest extends testbase{
	
	
  @Test
  public void okk() throws InterruptedException, IOException {
	  

		TC1_VerifyLogin aLogin = new TC1_VerifyLogin();

		aLogin.verifySignIn(driver, logger);

	
	  }
  
  
  
}

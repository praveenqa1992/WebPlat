package testRun;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.TransactionHistoryPOM;
import testCases.TC1_VerifyLogin;
import utility.testbase;

public class ReuAllTest extends testbase{
	
	
  @Test
  public void okk() throws InterruptedException, IOException {
	  

		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		TC1_VerifyLogin aLogin = new TC1_VerifyLogin();

		aLogin.verifySignIn(driver, logger);

		transactionHistoryPOM.click_reportsModule();

		transactionHistoryPOM.click_txnHistoryModule();

		// transactionHistoryPOM.selectFromDate(10, "August", 2024);

		transactionHistoryPOM.selectFromDate2(10, "August", 2024);

		// transactionHistoryPOM.selectToDate(20, "August", 2024);

		transactionHistoryPOM.selectToDate2(20, "August", 2024);

		transactionHistoryPOM.click_searchButton();

	  }
  
  
  
}

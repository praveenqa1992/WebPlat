package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import API.getWalletPassbook;
import pageObjects.WalletPassbookPOM;
import utility.testbase;

public class TC3_VerifyWalletPassbook extends testbase {
	
	String FromDate = "08/01/2024";
	String ToDate = "08/31/2024";
	
  @Test
  public void verifyPassbookPage() throws InterruptedException, IOException {
	  
//	  getWalletPassbook wallet = new getWalletPassbook();
//	  
//	  wallet.walletPassbook();
	  
	  TC1_VerifyLogin login = new TC1_VerifyLogin();
	  WalletPassbookPOM wallet = new WalletPassbookPOM(driver, logger);
	  
	  login.verifySignIn(driver, logger);
	  wallet.goToWalletPassbookPage();
	  wallet.searcHistory();
	  
	  
  }
}

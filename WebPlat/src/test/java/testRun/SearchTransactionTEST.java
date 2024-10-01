package testRun;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
import pageObjects.SearchTransactionPOM;
import pageObjects.TransactionHistoryPOM;
import testCases.TC1_VerifyLogin;
import utility.testbase;

public class SearchTransactionTEST extends testbase{

	
	@Test(priority = 1, enabled = true, groups = "regression.searchTxnReport")
	public void STR001_navigateToSearchTransactionReportPage() throws InterruptedException, IOException {

//TEST -		
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
//COMMON METHOD CLASS -		
		commonFunc commonfunc = new commonFunc();
//login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		Thread.sleep(2000);
//assertion	- page title check
		String actualTitle = driver.getTitle();
		String expectedTitle = "Search Transaction Report";
		boolean ignoreCase_pageTitle = false;
	    boolean titleIsSame =	commonfunc.compareString(actualTitle, expectedTitle, ignoreCase_pageTitle, logger);
		commonfunc.softAssert("Navigate to 'Search Txn. History' page and validate page title -", actualTitle, expectedTitle,
				titleIsSame, logger);
	}

	@Test(priority = 2, enabled = true, groups = "regression.searchTxnReport")

	public void ATR002_messageDisplayedIfTableHasNoData() throws InterruptedException, IOException {

		//TEST -		
				TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		//POM -
				SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		//COMMON METHOD CLASS -		
				commonFunc commonfunc = new commonFunc();
		//login...
				tC1_VerifyLogin.verifySignIn(driver, logger);
		//navigate to search history module...
				searchTransactionPOM.click_reportsModule_sideMenuBar();
				searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
				Thread.sleep(2000);
				
	         	commonfunc.waitForPageLoaded(driver, logger);
		
//validate message displayed if table has no data	
	    		boolean ignoreCase=false;
	    		String expectedMessage ="Data Not found.";
	         	searchTransactionPOM.validateMessageDisplayedIfSearchTxnTableHasNOData(expectedMessage, ignoreCase, logger);
	
	}
	@Test(priority = 2, enabled = true, groups = "regression.searchTxnReport")
	public void STR002_inProgress() throws InterruptedException, IOException {

//TEST -		
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
//COMMON METHOD CLASS -		
		commonFunc commonfunc = new commonFunc();
//login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		Thread.sleep(2000);

//apply mobile number filter--------------
		Thread.sleep(2000);

		searchTransactionPOM.enterText_searchInputField("1999999999");
		Thread.sleep(1000);

		searchTransactionPOM.click_searchButton();
		Thread.sleep(5000);
		
		searchTransactionPOM.getCurentPageNumber();
		searchTransactionPOM.getPage_paginationDataCountingMsg();
		searchTransactionPOM.captureScreenshot_firstAndLastTxn();

		System.out.println("curent page no -"+searchTransactionPOM.getCurentPageNumber());
		
		System.out.println("pagunation counting msg. -"+searchTransactionPOM.getPage_paginationDataCountingMsg());


	}
	
	
	
	
	
}

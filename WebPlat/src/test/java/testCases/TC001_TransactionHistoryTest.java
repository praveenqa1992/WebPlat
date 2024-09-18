package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.TransactionHistoryPOM;
import utility.testbase;

public class TC001_TransactionHistoryTest extends testbase {


	@Test(priority = 1, enabled=false)
	public void TC001_navigateToTxnHistoryPage() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

		tC1_VerifyLogin.verifySignIn(driver, logger);

		transactionHistoryPOM.click_reportsModule();

		transactionHistoryPOM.click_txnHistoryModule();
				
		Thread.sleep(2000);
		String actualPageTitle =driver.getTitle();

	//	transactionHistoryPOM.validate_pageTitle("Validate 'Transaction History' page title",actualPageTitle ,"Transaction History");
         System.out.println("actualPageTitle-"+actualPageTitle);	
         
         SoftAssert softAssert = new SoftAssert();
         softAssert.assertEquals(actualPageTitle, "Transaction History","Page Title Missmatch");   
         softAssert.assertAll();
         
	}
	
	@Test(priority = 2, enabled=false)
	public void TC002_validatePageDataAccordingToPageSize() throws InterruptedException, IOException {


		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select date		
		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
		transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();
		
		System.out.println("//validate data per page and page size selected when table data is EQUAL TO or MORE than page size selected");
//		transactionHistoryPOM.validate_pageSizeSelectedAndDataPerPageFetched();
		transactionHistoryPOM.validate_tableDataAndTextMessage();
		
		System.out.println("//validate data per page and page size selected when table data is LESS than page size selected");
		transactionHistoryPOM.click_navigate_lastPageButton();
//		transactionHistoryPOM.validate_pageSizeSelectedAndDataPerPageFetched();
		transactionHistoryPOM.validate_tableDataAndTextMessage();
		
		System.out.println("//validate validate_dataPerPage by selecting All Page Sizes");
		transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();
		
	}

	@Test(priority=3, enabled=false)
	public void TC003_datePicker() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

		tC1_VerifyLogin.verifySignIn(driver, logger);

		transactionHistoryPOM.click_reportsModule();

		transactionHistoryPOM.click_txnHistoryModule();
						
		transactionHistoryPOM.changeDateIfTableHasNoData();
		
	}
	
	@Test(priority = 1, enabled=false)
	public void TC004_telecomTabTableDataFetching() throws InterruptedException, IOException {

		
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

		tC1_VerifyLogin.verifySignIn(driver, logger);

		transactionHistoryPOM.click_reportsModule();

		transactionHistoryPOM.click_txnHistoryModule();
		
		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
//		transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();
		
		Thread.sleep(5000);

//		transactionHistoryPOM.validate_pageSizeSelectedAndDataPerPageFetched();
		transactionHistoryPOM.validate_tableDataAndTextMessage();
		
		System.out.println("click_telecomTab");
		transactionHistoryPOM.click_telecomTab();
		Thread.sleep(5000);

//		transactionHistoryPOM.validate_pageSizeSelectedAndDataPerPageFetched();
		transactionHistoryPOM.validate_tableDataAndTextMessage();
		
		
	}
	
	@Test(priority = 5, enabled=false)
	public void TC005_generatedPagesAccordingToPageSize() throws InterruptedException, IOException {
		

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

		tC1_VerifyLogin.verifySignIn(driver, logger);

		transactionHistoryPOM.click_reportsModule();

		System.out.println("txn history tab click........");

		transactionHistoryPOM.click_txnHistoryModule();
		
		Thread.sleep(2000);
		
	Boolean catDrop	= transactionHistoryPOM.isCategoryTabDisplayed();

	SoftAssert softAssert = new SoftAssert();
	System.out.println("soft assert 1......");

    softAssert.assertTrue(catDrop,"cat dropdo is displayed assertTRUE (allTxnTab) failed");   
	
	Thread.sleep(2000);
	System.out.println("aeps tab click........");

    transactionHistoryPOM.click_aepsTab();
	Thread.sleep(2000);

    Boolean catDrop2 = transactionHistoryPOM.isCategoryTabDisplayed();
	System.out.println("soft assert 2......");

    softAssert.assertTrue(catDrop2,"cat dropdo is displayed assertTRUE (aepsTab) failed");   
    softAssert.assertAll();
    
    
	}
	
	
	@Test(priority = 6, enabled=false)
	public void TC006_aaa() throws InterruptedException, IOException {
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}

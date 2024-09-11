package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.TransactionHistoryPOM;
import utility.testbase;

public class TC001_TransactionHistoryTest extends testbase {


	@Test(priority = 1, enabled=true)
	public void TC001_navigateToTxnHistoryPage() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

		tC1_VerifyLogin.verifySignIn(driver, logger);

		transactionHistoryPOM.click_reportsModule();

		transactionHistoryPOM.click_txnHistoryModule();
				
//		transactionHistoryPOM.validate_pageTitle("Validate 'Transaction History' page title", "Transaction History");
		
		transactionHistoryPOM.changeDateIfTableHasNoData();
		
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
		transactionHistoryPOM.selectFromDate2(10, "August", 2024);
		transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();
		
		System.out.println("//validate data per page and page size selected when table data is EQUAL TO or MORE than page size selected");
		transactionHistoryPOM.validate_pageSizeSelectedAndDataPerPageFetched();
		transactionHistoryPOM.validate_tableDataAndTextMessage();
		
		System.out.println("//validate data per page and page size selected when table data is LESS than page size selected");
		transactionHistoryPOM.click_navigate_lastPageButton();
		transactionHistoryPOM.validate_pageSizeSelectedAndDataPerPageFetched();
		transactionHistoryPOM.validate_tableDataAndTextMessage();
		
		System.out.println("//validate validate_dataPerPage by selecting All Page Sizes");
		transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

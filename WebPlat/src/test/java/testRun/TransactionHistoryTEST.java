package testRun;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
import pageObjects.TransactionHistoryPOM;
import testCases.TC1_VerifyLogin;
import utility.testbase;

public class TransactionHistoryTEST extends testbase {

	SoftAssert softAssert;

	@Test(priority = 1, enabled = true)
	public void TC001_navigateToAllTxnHistoryPage() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();
//login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction history module...
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
        Thread.sleep(2000);
//assertion	

		String actualTitle = driver.getTitle();
		String expectedTitle ="Transaction History";
		commonfunc.compareString(actualTitle, expectedTitle, false);
		commonfunc.softAssert("Navigate to Txn. History page and validate page title -", expectedTitle, actualTitle, true, logger);

	}

	@Test(priority = 2, enabled = true)
	public void TC002_selectDateAndClickSearchButton() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select from date		
		transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//select to date	
		 transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();

	}

	@Test(priority = 3, enabled = true)
	public void TC003_messageDisplayedIfTableHasNoData() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select from date		
	//	transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//select to date	
		// transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();

		Thread.sleep(2000);
//validate if table has data
		Boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();

		if (dataInTable) {

			logger.log(LogStatus.INFO, "Txn. table has data");

		}
		else {

			logger.log(LogStatus.INFO, "No data found for the selected date.");
			logger.log(LogStatus.INFO, "checking message displayed when no data found");

			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
			String expectedMessage = "No items found.";

			commonfunc.compareString(actualMessage, expectedMessage, true);
			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, true,
					logger);

		}

	}

	@Test(priority = 4, enabled = true)
	public void TC004_validateTheDefaultPageSize() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select from date		
		transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//select to date	
		// transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();

//assert_ default page size selected

		logger.log(LogStatus.INFO, "checking default page size");

		String ActualDataPerPageNoDisplayed = transactionHistoryPOM.get_page_dataPerPageNumber();

		// default page size STATIC =10

		String expectedPageDataString = "10";

		commonfunc.compareString(ActualDataPerPageNoDisplayed, expectedPageDataString, true);
		commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString, true, logger);

	}
	
	
	@Test(priority = 5, enabled = true)
	public void TC005_validatePageDataAccordingToPageSize() throws InterruptedException, IOException {
	

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		softAssert = new SoftAssert();
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
//assert_page size selected and data fetched per page		
	Boolean dataFetchedAndPageSelected =	transactionHistoryPOM.isDataFetchedAccordingToPageSizeSelected();	
	

	}
	
	
	
	
	
	
	
	

}

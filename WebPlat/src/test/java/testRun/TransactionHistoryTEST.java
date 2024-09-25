package testRun;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
import pageObjects.TransactionHistoryPOM;
import testCases.TC1_VerifyLogin;
import utility.testbase;

public class TransactionHistoryTEST extends testbase {

//	SoftAssert softAssert;

	@Test(priority = 1, enabled = true, groups = "regression.allTxnReport")
	public void ATR001_navigateToAllTxnReportPage() throws InterruptedException, IOException {

//TEST -		
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//COMMON METHOD CLASS -		
		commonFunc commonfunc = new commonFunc();

//login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction history module...
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
		Thread.sleep(2000);
//assertion	- page title check
		String actualTitle = driver.getTitle();
		String expectedTitle = "Transaction History";

		Boolean ignoreCase_pageTitle = false;
		commonfunc.compareString(actualTitle, expectedTitle, ignoreCase_pageTitle, logger);
		logger.log(LogStatus.INFO, "act title-" + actualTitle + "expected title-" + expectedTitle);
		commonfunc.softAssert("Navigate to Txn. History page and validate page title -", actualTitle, expectedTitle,
				true, logger);
		logger.log(LogStatus.INFO, "act title2-" + actualTitle + "expected title2-" + expectedTitle);

	}

	@Test(priority = 2, enabled = true, groups = "regression.allTxnReport")
	public void ATR002_datePickerDefaultDateSelected() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();

		// get FROM date calendar date,month and year
		String fromDate = transactionHistoryPOM.getFromCalendar_highlitedDate();
		String fromMonth = transactionHistoryPOM.getFromCalendar_Month();
		String fromYear = transactionHistoryPOM.getFromCalendar_Year();
		// get TO date calendar date,month and year
		String toDate = transactionHistoryPOM.getToCalendar_highlitedDate();
		String toMonth = transactionHistoryPOM.getToCalendar_Month();
		String toYear = transactionHistoryPOM.getToCalendar_Year();

		Boolean ignoreCase = false;

//assertion - combo-------------------------		
		String fromDMY = fromDate + "/" + fromMonth + "/" + fromYear;
		String toDMY = toDate + "/" + toMonth + "/" + toYear;

		String systemDTM = transactionHistoryPOM.getCurrentDateAndTimeInFormat("dd/MMMM/yyyy");

//compare string	
		Boolean sameFromString = commonfunc.compareString(fromDMY, systemDTM, ignoreCase, logger);
		logger.log(LogStatus.INFO,
				"Default date of FROM date picker is -" + fromDMY + "</br>System doday's date is -" + systemDTM);

		// assertion - FROM date picker ----------

		commonfunc.softAssert("Validating FROM date picker date and today's date -", fromDMY, systemDTM, sameFromString,
				logger);

//compare string	
		Boolean sameToString = commonfunc.compareString(toDMY, systemDTM, ignoreCase, logger);
		logger.log(LogStatus.INFO,
				"Default date of TO date picker is -" + toDMY + "</br>System doday's date is -" + systemDTM);
		// assertion - TO date picker ----------
		commonfunc.softAssert("Validating TO date picker date and today's date -", toDMY, systemDTM, sameToString,
				logger);

//get system date,month and year

//	String systemDate = transactionHistoryPOM.getCurrentDate();
//	String systemMonth = transactionHistoryPOM.getCurrentMonth();
//	String systemYear = transactionHistoryPOM.getCurrentYear();		

////assertion - FROM date picker -------------
//		
////date
//		Boolean sameFromDate=commonfunc.compareString(fromDate, systemDate, ignoreCase, logger);
//		logger.log(LogStatus.INFO, "Default date of FROM date picker is -" + fromDate + "System doday's date is -" + systemDate);
//		commonfunc.softAssert("Validating FROM date picker date and today's date -", fromDate, systemDate,
//				sameFromDate, logger);
//	
////month
//		Boolean sameFromMonth=commonfunc.compareString(fromMonth, systemMonth, ignoreCase, logger);
//		logger.log(LogStatus.INFO, "Default month of FROM date picker is -" + fromMonth + "System current month is -" + systemMonth);
//		commonfunc.softAssert("Validating FROM date picker month and current month -", fromMonth, systemMonth,
//				sameFromMonth, logger);
//		
////year		
//		Boolean sameFromYear=commonfunc.compareString(fromYear, systemYear, ignoreCase, logger);
//		logger.log(LogStatus.INFO, "Default year of FROM date picker is -" + fromYear + "System current year is -" + systemYear);
//		commonfunc.softAssert("Validating FROM date picker year and current year -", fromYear, systemYear,
//				sameFromYear, logger);
//		
//		//assertion - TO date picker ----------
//		
//		//date
//			Boolean sameToDate=	commonfunc.compareString(toDate, systemDate, ignoreCase, logger);
//				logger.log(LogStatus.INFO, "Default date of TO date picker is -" + toDate + "System doday's date is -" + systemDate);
//				commonfunc.softAssert("Validating TO date picker date and today's date -", toDate, systemDate,
//						sameToDate, logger);
//			
//		//month
//			Boolean sameToMonth=	commonfunc.compareString(toMonth, systemMonth, ignoreCase, logger);
//				logger.log(LogStatus.INFO, "Default month of TO date picker is -" + toMonth + "System current month is -" + systemMonth);
//				commonfunc.softAssert("Validating TO date picker month and current month -", toMonth, systemMonth,
//						sameToMonth, logger);
//				
//		//year		
//				Boolean sameToYear=commonfunc.compareString(toYear, systemYear, ignoreCase, logger);
//				logger.log(LogStatus.INFO, "Default year of TO date picker is -" + toYear + "System current year is -" + systemYear);
//				commonfunc.softAssert("Validating TO date picker year and current year -", toYear, systemYear,
//						sameToYear, logger);
//				

	}

	@Test(priority = 3, enabled = true, groups = "regression.allTxnReport")
	public void ATR003_messageDisplayedIfNoDataToDateRangeSelected() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select from date		
		 transactionHistoryPOM.selectFromDate2("1", "January", "2024");
//select to date	
		 transactionHistoryPOM.selectToDate2(1, "January", 2024);
//search		
		transactionHistoryPOM.click_searchButton();
		
		commonfunc.waitForPageLoaded(driver, logger);
//validate if table has data
		boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();

		if (dataInTable) {

			commonfunc.screenshotInReport("Txn. table has data -", driver, logger);

		} else {

			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
			commonfunc.screenshotInReport("Txn. table has no data -", driver, logger);
			String expectedMessage = "No items found.";
			boolean ignoreCase = false;

//compare string
			Boolean msgIsCorrect = commonfunc.compareString(actualMessage, expectedMessage, ignoreCase, logger);
//assertion - message displayed		
			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage,
					msgIsCorrect, logger);
		}
	}

	@Test(priority = 4, enabled = true, groups = "regression.allTxnReport")
	public void ATR004_isCategoryDropdownDisplayed() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();

		// login
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to transaction module
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
		Thread.sleep(2000);

		Boolean catTabDisplayed = transactionHistoryPOM.isCategoryTabDisplayed();

//assertion - is category tab displayed	
		commonfunc.softAssertTrue("Is category dropdown displayed -", catTabDisplayed, logger);

	}

	@Test(priority = 5, enabled = true, groups = "regression.allTxnReport", dependsOnMethods = {
			"ATR004_isCategoryDropdownDisplayed" })
	public void ATR005_categoryFilterWorking() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select from date		
		transactionHistoryPOM.selectFromDate2("1", "August", "2024");

// click category dropdown
		transactionHistoryPOM.click_categoryDropdown();
// select category - Telecom
		String categoryToApplyFilter = "Telecom";
		transactionHistoryPOM.selectCategoryFromDropdown(categoryToApplyFilter);
// search the transactions
		transactionHistoryPOM.click_searchButton();

//get and validate the category of the transactions
		// navigate through table rows
		int tableDataCount = transactionHistoryPOM.getTxnTable_rowNumbers();

		for (int dataNum = 0; dataNum <= (tableDataCount - 1); dataNum++) {

			String txnNo = transactionHistoryPOM.getTxnSrNo(dataNum);
			logger.log(LogStatus.INFO, "Transaction No. -" + txnNo);

			// get txn category
			String txnCategoryInTablePair = transactionHistoryPOM.getTxnCategory(dataNum);
			String txnCategoryInTable = txnCategoryInTablePair.replace("Category: ", ""); // find alternative to get
																							// ONLY category
																							// name++++++++++++++
			Boolean ignoreCase = true;
			// compare string
			Boolean stringIsSame = commonfunc.compareString(txnCategoryInTable, categoryToApplyFilter, ignoreCase,
					logger);
//assertion - filter category and txn. category		
			commonfunc.softAssert("Category filter and category of a txn. in table-", txnCategoryInTable,
					categoryToApplyFilter, stringIsSame, logger);
		}

		logger.log(LogStatus.INFO, "End of the category filter testcase");
	}

	@Test(priority = 6, enabled = true, groups = "regression.allTxnReport")
	public void ATR006_serviceFilterWorking() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select date		
		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
//		transactionHistoryPOM.selectToDate2(20, "August", 2024);

// select category - Telecom
		transactionHistoryPOM.click_categoryDropdown();
		String categoryToApplyFilter = "Telecom";
		transactionHistoryPOM.selectCategoryFromDropdown(categoryToApplyFilter);
		Thread.sleep(2000);

		// click service dropdown
		transactionHistoryPOM.click_serviceDropdown();
		// select service
		String serviceToApplyFilter = "Mobile";
		transactionHistoryPOM.selectServiceFromDropdown(serviceToApplyFilter);
		Thread.sleep(2000);

		// search
		transactionHistoryPOM.click_searchButton();

		// get and validate the category of the transactions
		// navigate through table rows
		int tableDataCount = transactionHistoryPOM.getTxnTable_rowNumbers();

		for (int dataNum = 0; dataNum <= (tableDataCount - 1); dataNum++) {

			String txnNo = transactionHistoryPOM.getTxnSrNo(dataNum);
			logger.log(LogStatus.INFO, "Transaction No. -" + txnNo);

			// get and validate txn category------------
			String txnCategoryInTablePair = transactionHistoryPOM.getTxnCategory(dataNum);
			String txnCategoryInTable = txnCategoryInTablePair.replace("Category: ", ""); // find alternative to get
																							// ONLY category
																							// name++++++++++++++
			Boolean ignoreCase = true;

			// compare string
			Boolean stringIsSame = commonfunc.compareString(txnCategoryInTable, categoryToApplyFilter, ignoreCase,
					logger);
			// assertion - filter category and txn. category
			commonfunc.softAssert("Category filter and category of a txn. in table-", txnCategoryInTable,
					categoryToApplyFilter, stringIsSame, logger);

			// get and validate txn service------------

			String txnServiceInTablePair = transactionHistoryPOM.getTxnService(dataNum);
			String txnServiceInTable = txnServiceInTablePair.replace("Service: ", ""); // find alternative to get
																						// ONLY service
																						// name++++++++++++++

			Boolean stringIsSame_service = commonfunc.compareString(txnServiceInTable, serviceToApplyFilter, ignoreCase,
					logger);
//assertion - filter service and txn. service		

			commonfunc.softAssert("Service filter and service of a txn. in table-", txnServiceInTable,
					serviceToApplyFilter, stringIsSame_service, logger);

		}
		logger.log(LogStatus.INFO, "End of the service filter test case");

	}

	@Test(priority = 7, enabled = true, groups = "regression.allTxnReport")
	public void ATR007_operatorFilterWorking() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select date		
		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
//transactionHistoryPOM.selectToDate2(20, "August", 2024);

//select category - Telecom
		transactionHistoryPOM.click_categoryDropdown();
		String categoryToApplyFilter = "Telecom";
		transactionHistoryPOM.selectCategoryFromDropdown(categoryToApplyFilter);
		Thread.sleep(2000);

// click service - Mobile
		transactionHistoryPOM.click_serviceDropdown();
// select service
		String serviceToApplyFilter = "Mobile";
		transactionHistoryPOM.selectServiceFromDropdown(serviceToApplyFilter);
		Thread.sleep(2000);

// select operator - JIO
		transactionHistoryPOM.click_operatorDropdown();
// select operator
		String operatorToApplyFilter = "JIO";
		transactionHistoryPOM.selectOperatorFromDropdown(operatorToApplyFilter);
		Thread.sleep(2000);

// search
		transactionHistoryPOM.click_searchButton();

//get and validate the category of the transactions
		// navigate through table rows
		int tableDataCount = transactionHistoryPOM.getTxnTable_rowNumbers();

		for (int dataNum = 0; dataNum <= (tableDataCount - 1); dataNum++) {

			String txnNo = transactionHistoryPOM.getTxnSrNo(dataNum);
			logger.log(LogStatus.INFO, "Transaction No. -" + txnNo);

//get and validate txn category------------
			String txnCategoryInTablePair = transactionHistoryPOM.getTxnCategory(dataNum);
			String txnCategoryInTable = txnCategoryInTablePair.replace("Category: ", ""); // find alternative to get
																							// ONLY category
																							// name++++++++++++++
			Boolean ignoreCase = true;

			// compare string
			Boolean stringIsSame = commonfunc.compareString(txnCategoryInTable, categoryToApplyFilter, ignoreCase,
					logger);
//assertion - filter category and txn. category		
			commonfunc.softAssert("Category filter and category of a txn. in table-", txnCategoryInTable,
					categoryToApplyFilter, stringIsSame, logger);

//get and validate txn service------------

			String txnServiceInTablePair = transactionHistoryPOM.getTxnService(dataNum);
			String txnServiceInTable = txnServiceInTablePair.replace("Service: ", ""); // find alternative to get
																						// ONLY service
																						// name++++++++++++++

			Boolean stringIsSame_service = commonfunc.compareString(txnServiceInTable, serviceToApplyFilter, ignoreCase,
					logger);
//assertion - filter service and txn. service		

			commonfunc.softAssert("Service filter and service of a txn. in table-", txnServiceInTable,
					serviceToApplyFilter, stringIsSame_service, logger);

			// get and validate txn operator------------

			String txnOperatorInTablePair = transactionHistoryPOM.getTxnOperator(dataNum);
			String txnOperatorInTable = txnOperatorInTablePair.replace("Operator: ", ""); // find alternative to get
																							// ONLY category
//assertion - filter operator and txn. operator		
			Boolean stringIsSame_operator = commonfunc.compareString(txnOperatorInTable, operatorToApplyFilter,
					ignoreCase, logger);
			commonfunc.softAssert("opeartor filter applied and opeartor of a txn. in table-", txnOperatorInTable,
					operatorToApplyFilter, stringIsSame_operator, logger);

		}

		logger.log(LogStatus.INFO, "End of the operator filter test case");

	}

	@Test(priority = 10, enabled = true, groups = "regression.allTxnReport")
	public void ATR010_validateTheDefaultPageSize() throws InterruptedException, IOException {
		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();

//get default page size	
		logger.log(LogStatus.INFO, "Get default page size");
		String ActualDataPerPageNoDisplayed = transactionHistoryPOM.get_perPageDataSize();
		// default page size STATIC =10
		String expectedPageDataString = "10";

		Boolean ignoreCase = false;
//compare string		
		Boolean defaultPageSizeIsSame = commonfunc.compareString(ActualDataPerPageNoDisplayed, expectedPageDataString,
				ignoreCase, logger);
//assertion - default page size selected	
		commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString,
				defaultPageSizeIsSame, logger);

	}

	@Test(priority = 11, enabled = true, groups = "regression.allTxnReport")
	public void ATR011_validatePageDataAccordingToPageSize() throws InterruptedException, IOException {
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI S SCENARIO ????????????????????????????????????????????????????????????????????????

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
		Thread.sleep(2000);
//select date		
		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
		transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();
//assertion - page size selected and data fetched per page		
		boolean dataFetchedAndPageSelected = transactionHistoryPOM.isDataFetchedAccordingToPageSizeSelected();
		commonfunc.softAssertTrue("Data Fetched And Page Size Selected isSame-", dataFetchedAndPageSelected, logger);

// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI S SCENARIO ????????????????????????????????????????????????????????????????????????

	}

	@Test(priority = 12, enabled = true, groups = "regression.allTxnReport")
	public void ATR012_pagination_validatePageDataAndMessageCountAtPageBottom_changePageSizeALL()
			throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select from date		
		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
//select to date	
		// transactionHistoryPOM.selectToDate2(25, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();

		// change page data size and validate the table data displayed
		transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();

	}

	@Test(priority = 13, enabled = true, groups = "regression.allTxnReport")
	public void ATR013_pagination_changePagesUsingPaginationButtons() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select from date		
		transactionHistoryPOM.selectFromDate2("1", "August", "2024");
//select to date	
		// transactionHistoryPOM.selectToDate2(25, "September", 2024);
//search		
		transactionHistoryPOM.click_searchButton();

//pagination--------navigate through pages using buttons-------

		// 1---next
		transactionHistoryPOM.click_navigate_nextPageButton();
		Thread.sleep(3000);

// capture sr no of FIRST txn.	
		int firstTxnIndex = 0;
	
		transactionHistoryPOM.getTxnSrNo(firstTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of first txn. -", driver, logger);

// capture sr no of LAST txn.		
		String dataPerPageCountSTRING = transactionHistoryPOM.get_perPageDataSize();
		int dataPerPageCount = Integer.parseInt(dataPerPageCountSTRING);
	
	int tableRows=	transactionHistoryPOM.getTxnTable_rowNumbers();
		
		int lastTxnIndex = (tableRows-1);
		transactionHistoryPOM.getTxnSrNo(lastTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of last txn. -", driver, logger);

		// 2---last

		transactionHistoryPOM.click_navigate_lastPageButton();
		Thread.sleep(3000);

		// capture sr no of FIRST txn.
		transactionHistoryPOM.getTxnSrNo(firstTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of first txn. -", driver, logger);

		// capture sr no of LAST txn.
//				String dataPerPageCountSTRING = transactionHistoryPOM.get_perPageDataSize();	
//				int dataPerPageCount =Integer.parseInt(dataPerPageCountSTRING);
		transactionHistoryPOM.getTxnSrNo(lastTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of last txn. -", driver, logger);

		// 2b---last
		// navigate to last page from last page
		transactionHistoryPOM.click_navigate_lastPageButton();

		Thread.sleep(3000);

		// 3-----previous
		transactionHistoryPOM.click_navigate_previousPageButton();
		Thread.sleep(3000);

		// capture sr no of FIRST txn.
		transactionHistoryPOM.getTxnSrNo(firstTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of first txn. -", driver, logger);

		// capture sr no of LAST txn.
//						String dataPerPageCountSTRING = transactionHistoryPOM.get_perPageDataSize();	
//						int dataPerPageCount =Integer.parseInt(dataPerPageCountSTRING);
		transactionHistoryPOM.getTxnSrNo(lastTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of last txn. -", driver, logger);

		// 4-------first
		transactionHistoryPOM.click_navigate_firstPageButton();
		Thread.sleep(3000);
		transactionHistoryPOM.screenshotInReport("Last page button -", driver, logger);

		// capture sr no of FIRST txn.
		transactionHistoryPOM.getTxnSrNo(firstTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of first txn. -", driver, logger);

		// capture sr no of LAST txn.
//						String dataPerPageCountSTRING = transactionHistoryPOM.get_perPageDataSize();	
//						int dataPerPageCount =Integer.parseInt(dataPerPageCountSTRING);
		transactionHistoryPOM.getTxnSrNo(lastTxnIndex);
		transactionHistoryPOM.screenshotInReport("Sr.No. of last txn. -", driver, logger);

		// 4b-----first
//navigate to first page from first page
		transactionHistoryPOM.click_navigate_firstPageButton();
		transactionHistoryPOM.screenshotInReport("First page button -", driver, logger);

	}

	@Test(priority = 15, enabled = true, groups = "regression.allTxnReport")
	public void ATR015_moreDetailsUsingMeatballIcon_open() throws InterruptedException, IOException {
		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to transaction history module...
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
		// select date
		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
		transactionHistoryPOM.selectToDate2(20, "August", 2024);
		// search
		transactionHistoryPOM.click_searchButton();

		Thread.sleep(5000);

//open more info side bar of 1st txn.	
		transactionHistoryPOM.OpenMoreInfoOfTxnPopup(1);

//validate side bar open or close

		Boolean isMoreInfoSideMenuOpen = transactionHistoryPOM
				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
		transactionHistoryPOM.screenshotInReport("More info. side menu bar is open -", driver, logger);
		Thread.sleep(1000);

//assertion - is side bar open
		transactionHistoryPOM.softAssertTrue("offCanvas/side menu bar is open -", isMoreInfoSideMenuOpen, logger);
		Thread.sleep(2000);

		// close the more info side menu
		// bar====================================================================
		transactionHistoryPOM.click_close_lastButton_moreInfoSideBar();
		Thread.sleep(2000);
		// assertion - is side bar closed
		Boolean moreInfoSideMenuIsOpen = transactionHistoryPOM
				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
		transactionHistoryPOM.screenshotInReport("More info. side menu bar is closed -", driver, logger);

		Thread.sleep(2000);
		// assertion....side bar closed
		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close -", moreInfoSideMenuIsOpen, logger);

//print parameter and values	
//	Boolean moreInfoPopupOpen = transactionHistoryPOM.isMoreInfoOfTxnPopup_Appeared(1);
//    logger.log(LogStatus.INFO,"isMoreInfoOfTxnPopup_Appeared -"+moreInfoPopupOpen);
//      
//    int paramNos = transactionHistoryPOM.getMoreInfoTable_paramNameListSize();
//    int paramValueNos = transactionHistoryPOM.getMoreInfoTable_paramValueListSize();

	}

//	@Test(priority = 16, enabled = true, dependsOnMethods = {
//			"ATR015_moreDetailsUsingMeatballIcon_open" }, groups = "regression.allTxnReport")
//
//	public void ATR016_moreDetailsUsingMeatballIcon_close() throws InterruptedException, IOException {
//
//		// POM -
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		// close the more info side menu bar
//		transactionHistoryPOM.click_close_lastButton_moreInfoSideBar();
//		Thread.sleep(2000);
////assertion - is side bar closed
//		Boolean moreInfoSideMenuIsOpen = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//		Thread.sleep(2000);
//// assertion....side bar closed
//		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close2 -", moreInfoSideMenuIsOpen, logger);
//
//	}

	
	@Test(priority = 10, enabled = true, groups = "regression.telecomTab")
	public void TC010_moreinfo() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);

		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();

		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to transaction history module...
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
		Thread.sleep(2000);

		// navigate/click to telecom tab
		transactionHistoryPOM.click_telecomTab();
		Thread.sleep(2000);
		
		//select from date		
				transactionHistoryPOM.selectFromDate2("1", "August", "2024");
		//select to date	
				// transactionHistoryPOM.selectToDate2(25, "August", 2024);
				transactionHistoryPOM.click_searchButton();
				Thread.sleep(2000);

				//open more info side bar of 1st txn.			
				transactionHistoryPOM.validateMoreInfoSideBarHeaderButtons();//more info header buttons need combo of ...1.txn status 2.category and 3. ....get information first then handle

	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
//	@Test(priority = 10, enabled = true, groups = "regression.telecomTab")
//	public void TC010_seconsSideMenu() throws InterruptedException, IOException {
//
//		// TEST -
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		// POM -
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//
//		// COMMON METHOD CLASS -
//		commonFunc commonfunc = new commonFunc();
//
//		// login...
//		tC1_VerifyLogin.verifySignIn(driver, logger);
//		Thread.sleep(5000);
//		
//		
//		
//	}
//	
//	
//	@Test(priority = 10, enabled = true, groups = "regression.telecomTab")
//	public void TC010_telecomTabHasNoCatDropdown() throws InterruptedException, IOException {
//
//		// TEST -
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		// POM -
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//
//		// COMMON METHOD CLASS -
//		commonFunc commonfunc = new commonFunc();
//
//		// login...
//		tC1_VerifyLogin.verifySignIn(driver, logger);
//		// navigate to transaction history module...
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//		Thread.sleep(2000);
//
//		// navigate/click to telecom tab
//		transactionHistoryPOM.click_telecomTab();
//		Thread.sleep(2000);
//
//		Boolean catTabDisplayed2 = transactionHistoryPOM.isCategoryTabDisplayed();
//		System.out.println("cat tab2 is displayed -" + catTabDisplayed2);
////assertion - is category tab displayed	
//		commonfunc.softAssertFalse("is category dropdown/tab displayed -", catTabDisplayed2, logger);
//
//	}
//
//	@Test(priority = 11, enabled = true, groups = "regression.allTxnReport")
//	public void TC011_pagination_validatePageDataAndMessageCountAtPageBottom()
//			throws InterruptedException, IOException {
//
//		// TEST -
//				TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//				// POM -
//				TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//
//		//login
//				tC1_VerifyLogin.verifySignIn(driver, logger);
//		//navigate to transaction module		
//				transactionHistoryPOM.click_reportsModule();
//				transactionHistoryPOM.click_txnHistoryModule();
//		//select from date		
//				transactionHistoryPOM.selectFromDate2("10", "August", "2024");
//		//select to date	
//				transactionHistoryPOM.selectToDate2(25, "August", 2024);
//		//search		
//				transactionHistoryPOM.click_searchButton();
//				
//		// assertion - validate table data and message at page bottom with ASSERTIONS
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change VALID page data size
//		transactionHistoryPOM.changeCount_DataPerPage(25);
////assertion - validate table data and message at page bottom with ASSERTIONS		
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change INVALID page data size
//		transactionHistoryPOM.changeCount_DataPerPage(2);
//
//	}
//
//
//	
//	@Test(priority = 14, enabled = true, groups = "regression.allTxnReport")
//	public void TC014_validate_defaultDateSelected_fromDatepicker() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//		Thread.sleep(2000);
//
//		// collect data of from calendar
//
//		String fromHighlitedDate = transactionHistoryPOM.getFromCalendar_highlitedDate();
//		String fromTodaysDate = transactionHistoryPOM.getFromCalendar_todayDate();
//		String fromMonth = transactionHistoryPOM.getFromCalendar_Month();
//		String fromYear = transactionHistoryPOM.getFromCalendar_Year();
//
//		// collect current (system) data i.e. today's date,month and year
//
//		String currentDate = commonfunc.getCurrentDate();
//		String currentMonth = commonfunc.getCurrentMonth();
//		String currentYear = commonfunc.getCurrentYear();
//
////assertions -
//		Boolean isTodaysDateHighlited = commonfunc.compareString(currentDate, fromHighlitedDate, false, logger);
//		commonfunc.softAssert("from calendar highlited date is today's date -", currentDate, fromHighlitedDate,
//				isTodaysDateHighlited, logger);
//
//		Boolean isTodaysDateSelected = commonfunc.compareString(currentDate, fromTodaysDate, false, logger);
//		commonfunc.softAssert("from calendar default date is today's date -", currentDate, fromTodaysDate,
//				isTodaysDateSelected, logger);
//
//		Boolean isCurrentMonthSelected = commonfunc.compareString(currentMonth, fromMonth, false, logger);
//		commonfunc.softAssert("from calendar default month is current month -", currentMonth, fromMonth,
//				isCurrentMonthSelected, logger);
//
//		Boolean isCurrentYearSelected = commonfunc.compareString(currentYear, fromYear, false, logger);
//		commonfunc.softAssert("from calendar default year is current year -", currentYear, fromYear,
//				isCurrentYearSelected, logger);
//
//	}
//
//	@Test(priority = 15, enabled = true, groups = "regression.allTxnReport")
//	public void TC015_validate_defaultDateSelected_toDatepicker() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//		Thread.sleep(2000);
//
//		// collect data of to calendar
//		String toHighlitedDate = transactionHistoryPOM.getToCalendar_highlitedDate();
//		String toTodaysDate = transactionHistoryPOM.getToCalendar_todayDate();
//		String toMonth = transactionHistoryPOM.getToCalendar_Month();
//		String toYear = transactionHistoryPOM.getToCalendar_Year();
////collect current (system) data i.e. today's date,month and year
//		String currentDate = commonfunc.getCurrentDate();
//		String currentMonth = commonfunc.getCurrentMonth();
//		String currentYear = commonfunc.getCurrentYear();
//
////assertion -		
//		Boolean isTodaysDateHighlited = commonfunc.compareString(currentDate, toHighlitedDate, false, logger);
//		commonfunc.softAssert("to calendar highlited date is today's date -", currentDate, toHighlitedDate,
//				isTodaysDateHighlited, logger);
//
//		Boolean isTodaysDateSelected = commonfunc.compareString(currentDate, toTodaysDate, false, logger);
//		commonfunc.softAssert("to calendar default date is today's date -", currentDate, toTodaysDate,
//				isTodaysDateSelected, logger);
//
//		Boolean isCurrentMonthSelected = commonfunc.compareString(currentMonth, toMonth, false, logger);
//		commonfunc.softAssert("to calendar default month is current month -", currentMonth, toMonth,
//				isCurrentMonthSelected, logger);
//
//		Boolean isCurrentYearSelected = commonfunc.compareString(currentYear, toYear, false, logger);
//		commonfunc.softAssert("to calendar default year is current year -", currentYear, toYear, isCurrentYearSelected,
//				logger);
//
//	}
//
//// executing scenarios for other tabs than 'All Transaction	Report' tab............
//	@Test(priority = 51, enabled = true, groups = "regression.telecomTab")
//
//	public void TC051_scenarios_telecomTab() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//
//		Thread.sleep(2000);
//		// navigate to telecom module/tab.........................
//		transactionHistoryPOM.click_telecomTab();
//		Thread.sleep(2000);
//
////select from date		
//		transactionHistoryPOM.selectFromDate2("11", "September", "2024");
////select to date	
//		transactionHistoryPOM.selectToDate2(12, "September", 2024);
////search		
//		transactionHistoryPOM.click_searchButton();
////1.validate if table has data-----------
//		logger.log(LogStatus.INFO, "1.validate if table has data-----------");
//
//		Boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();
//
//		if (dataInTable) {
//
//			logger.log(LogStatus.INFO, "Txn. table has data");
//
//		} else {
//
//			logger.log(LogStatus.INFO, "No data found for the selected date.");
//			logger.log(LogStatus.INFO, "checking message displayed when no data found");
//
//			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
//			String expectedMessage = "No items found.";
//
//			commonfunc.compareString(actualMessage, expectedMessage, true, logger);
////assertion - message displayed		
//			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, true,
//					logger);
//
//		}
//
//		// 2.validating default page size-----------
//		logger.log(LogStatus.INFO, "2.validating default page size-----------");
//
//		logger.log(LogStatus.INFO, "checking default page size");
//		String ActualDataPerPageNoDisplayed = transactionHistoryPOM.get_perPageDataSize();
//		// default page size STATIC =10
//		String expectedPageDataString = "10";
//		commonfunc.compareString(ActualDataPerPageNoDisplayed, expectedPageDataString, true, logger);
//		// assertion - default page size selected
//		commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString, true,
//				logger);
//
//		Thread.sleep(5000);
//
//		// 3.validate side bar open or close---------------------
//		logger.log(LogStatus.INFO, "3.validate side bar open or close---------------------");
//
//		// select date
//		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
////			transactionHistoryPOM.selectToDate2(20, "August", 2024);
//		// search
//		transactionHistoryPOM.click_searchButton();
//		Thread.sleep(5000);
//		// open more info side bar of 1st txn.
//		transactionHistoryPOM.OpenMoreInfoOfTxnPopup(1);
//
//		// validate side bar open or close
//
//		Boolean moreInfoSideMenuIsOpen = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//		Thread.sleep(1000);
//
//		System.out.println("offCanvas/side menu bar is open1 by method -" + moreInfoSideMenuIsOpen);
//		System.out.println(
//				"offCanvas/side menu bar is open1 by me -" + transactionHistoryPOM.moreinfoSideBar.isDisplayed());
//
//		// assertion - is side bar open
//		transactionHistoryPOM.softAssertTrue("offCanvas/side menu bar is open1 -", moreInfoSideMenuIsOpen, logger);
//		Thread.sleep(2000);
//
//		// close the more info side menu bar
//		transactionHistoryPOM.click_close_lastButton_moreInfoSideBar();
//		Thread.sleep(2000);
//
//		// assertion - is side bar closed
//
//		Boolean moreInfoSideMenuIsClose = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//
//		Thread.sleep(2000);
//		// assertion....side bar closed
//		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close2 -", moreInfoSideMenuIsClose, logger);
//
//		Thread.sleep(5000);
//		// 4.validate data count and message count at page bottom---------------
//		logger.log(LogStatus.INFO, "4.validate data count and message count at page bottom---------------");
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change VALID page data size
//		transactionHistoryPOM.changeCount_DataPerPage(25);
//		// assertion - validate table data and message at page bottom with ASSERTIONS
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change INVALID page data size
//
//		transactionHistoryPOM.changeCount_DataPerPage(2);
//
//	}
//
//	@Test(priority = 52, enabled = true, groups = "regression.telecomTab")
//	public void TC052_telecomTab_moreInfoSideBarButtonsValidate() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//
//		Thread.sleep(2000);
//		// navigate to telecom module/tab.........................
//		transactionHistoryPOM.click_telecomTab();
//		Thread.sleep(2000);
//
////select from date		
//		// transactionHistoryPOM.selectFromDate2("1", "August", "2024");
////select to date	
//		// transactionHistoryPOM.selectToDate2(12, "September", 2024);
////search		
//		transactionHistoryPOM.click_searchButton();
//
//		transactionHistoryPOM.getTxnStatus();
//
//	}
//
////more info side bar has DIFFERENT OPTIONS / BUTTONS.........update script accordingly	
//	@Test(priority = 61, enabled = true, groups = "regression.Dmt")
//
//	public void TC061_scenarios_DmtTab() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//
//		Thread.sleep(2000);
//		// navigate to dmt
//		// module/tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		transactionHistoryPOM.click_dmtTab();
//		Thread.sleep(2000);
//
////select from date		
////		transactionHistoryPOM.selectFromDate2("11", "September", "2024");
//////select to date	
////		transactionHistoryPOM.selectToDate2(12, "September", 2024);
//////search		
////		transactionHistoryPOM.click_searchButton();
//////1.validate if table has data-----------
////		logger.log(LogStatus.INFO, "1.validate if table has data-----------");
////
////		Boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();
////
////		if (dataInTable) {
////
////			logger.log(LogStatus.INFO, "Txn. table has data");
////
////		} else {
////
////			logger.log(LogStatus.INFO, "No data found for the selected date.");
////			logger.log(LogStatus.INFO, "checking message displayed when no data found");
////
////			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
////			String expectedMessage = "No items found.";
////
////			commonfunc.compareString(actualMessage, expectedMessage, true);
//////assertion - message displayed		
////			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, true,
////					logger);
////			
////		}
////
////			//2.validating default page size-----------	
////			logger.log(LogStatus.INFO, "2.validating default page size-----------");
////
////			logger.log(LogStatus.INFO, "checking default page size");
////			String ActualDataPerPageNoDisplayed = transactionHistoryPOM.get_perPageDataSize();
////			// default page size STATIC =10
////			String expectedPageDataString = "10";
////			commonfunc.compareString(ActualDataPerPageNoDisplayed, expectedPageDataString, true);
////	//assertion - default page size selected	
////			commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString, true,
////					logger);
////		
////			Thread.sleep(5000);
////			
//
//		// 3.validate side bar open or close---------------------
//		logger.log(LogStatus.INFO, "3.validate side bar open or close---------------------");
//
//		// select date
//		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
////			transactionHistoryPOM.selectToDate2(20, "August", 2024);
//		// search
//		transactionHistoryPOM.click_searchButton();
//		Thread.sleep(5000);
//		// open more info side bar of 1st txn.
//		transactionHistoryPOM.OpenMoreInfoOfTxnPopup(8);
//
//		transactionHistoryPOM.screenshotInReport("TEST---Adding a screenshot to the report -", driver, logger);
//
//		// validate side bar open or close
//
//		Boolean isMoreInfoDisp = transactionHistoryPOM.isMoreInfoSideBarDisplayed();
//
//		// assertion - is side bar open
//		transactionHistoryPOM.softAssertTrue("offCanvas/side menu bar is open1 -", isMoreInfoDisp, logger);
//		Thread.sleep(2000);
//
////		transactionHistoryPOM.click_firstButton_moreInfoSideBar();
//
//		transactionHistoryPOM.click_secondButton_moreInfoSideBar();
//
//		Thread.sleep(3000);
//
////		// close the more info side menu bar
////		transactionHistoryPOM.click_close_lastButton_moreInfoSideBar();
////		Thread.sleep(2000);
////
////		// assertion - is side bar closed
////
////		Boolean moreInfoSideMenuIsClose = transactionHistoryPOM
////				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
////
////		Thread.sleep(2000);
////		// assertion....side bar closed
////		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close2 -", moreInfoSideMenuIsClose, logger);
////
////		Thread.sleep(5000);
////			//4.validate data count and message count at page bottom---------------
////			logger.log(LogStatus.INFO, "4.validate data count and message count at page bottom---------------");
////		
////			
////			transactionHistoryPOM.validate_tableDataAndTextMessage();
////			// change VALID page data size
////			transactionHistoryPOM.changeCount_DataPerPage(25);
////	//assertion - validate table data and message at page bottom with ASSERTIONS		
////
////			transactionHistoryPOM.validate_tableDataAndTextMessage();
////			// change INVALID page data size
////
////			transactionHistoryPOM.changeCount_DataPerPage(2);
//
//	}
//
//	@Test(priority = 71, enabled = true, groups = "regression.Bbps")
//
//	public void TC071_scenarios_BbpsTab() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//
//		Thread.sleep(2000);
//		// navigate to BBPS
//		// module/tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		transactionHistoryPOM.click_bbpsTab();
//		Thread.sleep(2000);
//
////select from date		
//		transactionHistoryPOM.selectFromDate2("11", "September", "2024");
////select to date	
//		transactionHistoryPOM.selectToDate2(12, "September", 2024);
////search		
//		transactionHistoryPOM.click_searchButton();
////1.validate if table has data-----------
//		logger.log(LogStatus.INFO, "1.validate if table has data-----------");
//
//		Boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();
//
//		if (dataInTable) {
//
//			logger.log(LogStatus.INFO, "Txn. table has data");
//
//		} else {
//
//			logger.log(LogStatus.INFO, "No data found for the selected date.");
//			logger.log(LogStatus.INFO, "checking message displayed when no data found");
//
//			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
//			String expectedMessage = "No items found.";
//
//			commonfunc.compareString(actualMessage, expectedMessage, true, logger);
////assertion - message displayed		
//			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, true,
//					logger);
//
//		}
//
//		// 2.validating default page size-----------
//		logger.log(LogStatus.INFO, "2.validating default page size-----------");
//
//		logger.log(LogStatus.INFO, "checking default page size");
//		String ActualDataPerPageNoDisplayed = transactionHistoryPOM.get_perPageDataSize();
//		// default page size STATIC =10
//		String expectedPageDataString = "10";
//		commonfunc.compareString(ActualDataPerPageNoDisplayed, expectedPageDataString, true, logger);
//		// assertion - default page size selected
//		commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString, true,
//				logger);
//
//		Thread.sleep(5000);
//
//		// 3.validate side bar open or close---------------------
//		logger.log(LogStatus.INFO, "3.validate side bar open or close---------------------");
//
//		// select date
//		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
////			transactionHistoryPOM.selectToDate2(20, "August", 2024);
//		// search
//		transactionHistoryPOM.click_searchButton();
//		Thread.sleep(5000);
//		// open more info side bar of 1st txn.
//		transactionHistoryPOM.OpenMoreInfoOfTxnPopup(1);
//
//		// validate side bar open or close
//
//		Boolean moreInfoSideMenuIsOpen = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//		Thread.sleep(1000);
//
//		System.out.println("offCanvas/side menu bar is open1 by method -" + moreInfoSideMenuIsOpen);
//		System.out.println(
//				"offCanvas/side menu bar is open1 by me -" + transactionHistoryPOM.moreinfoSideBar.isDisplayed());
//
//		// assertion - is side bar open
//		transactionHistoryPOM.softAssertTrue("offCanvas/side menu bar is open1 -", moreInfoSideMenuIsOpen, logger);
//		Thread.sleep(2000);
//
//		// close the more info side menu bar
//		transactionHistoryPOM.click_close_lastButton_moreInfoSideBar();
//		Thread.sleep(2000);
//
//		// assertion - is side bar closed
//
//		Boolean moreInfoSideMenuIsClose = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//
//		Thread.sleep(2000);
//		// assertion....side bar closed
//		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close2 -", moreInfoSideMenuIsClose, logger);
//
//		Thread.sleep(5000);
//		// 4.validate data count and message count at page bottom---------------
//		logger.log(LogStatus.INFO, "4.validate data count and message count at page bottom---------------");
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change VALID page data size
//		transactionHistoryPOM.changeCount_DataPerPage(25);
//		// assertion - validate table data and message at page bottom with ASSERTIONS
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change INVALID page data size
//
//		transactionHistoryPOM.changeCount_DataPerPage(2);
//
//	}
//
//	@Test(priority = 81, enabled = true, groups = "regression.Aeps")
//
//	public void TC081_scenarios_AepsTab() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//
//		Thread.sleep(2000);
//		// navigate to AEPS
//		// module/tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		transactionHistoryPOM.click_aepsTab();
//		Thread.sleep(2000);
//
////select from date		
//		transactionHistoryPOM.selectFromDate2("11", "September", "2024");
////select to date	
//		transactionHistoryPOM.selectToDate2(12, "September", 2024);
////search		
//		transactionHistoryPOM.click_searchButton();
////1.validate if table has data-----------
//		logger.log(LogStatus.INFO, "1.validate if table has data-----------");
//
//		Boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();
//
//		if (dataInTable) {
//
//			logger.log(LogStatus.INFO, "Txn. table has data");
//
//		} else {
//
//			logger.log(LogStatus.INFO, "No data found for the selected date.");
//			logger.log(LogStatus.INFO, "checking message displayed when no data found");
//
//			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
//			String expectedMessage = "No items found.";
//
//			commonfunc.compareString(actualMessage, expectedMessage, true, logger);
////assertion - message displayed		
//			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, true,
//					logger);
//
//		}
//
//		// 2.validating default page size-----------
//		logger.log(LogStatus.INFO, "2.validating default page size-----------");
//
//		logger.log(LogStatus.INFO, "checking default page size");
//		String ActualDataPerPageNoDisplayed = transactionHistoryPOM.get_perPageDataSize();
//		// default page size STATIC =10
//		String expectedPageDataString = "10";
//		commonfunc.compareString(ActualDataPerPageNoDisplayed, expectedPageDataString, true, logger);
//		// assertion - default page size selected
//		commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString, true,
//				logger);
//
//		Thread.sleep(5000);
//
//		// 3.validate side bar open or close---------------------
//		logger.log(LogStatus.INFO, "3.validate side bar open or close---------------------");
//
//		// select date
//		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
////			transactionHistoryPOM.selectToDate2(20, "August", 2024);
//		// search
//		transactionHistoryPOM.click_searchButton();
//		Thread.sleep(5000);
//		// open more info side bar of 1st txn.
//		transactionHistoryPOM.OpenMoreInfoOfTxnPopup(1);
//
//		// validate side bar open or close
//
//		Boolean moreInfoSideMenuIsOpen = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//		Thread.sleep(1000);
//
//		System.out.println("offCanvas/side menu bar is open1 by method -" + moreInfoSideMenuIsOpen);
//		System.out.println(
//				"offCanvas/side menu bar is open1 by me -" + transactionHistoryPOM.moreinfoSideBar.isDisplayed());
//
//		// assertion - is side bar open
//		transactionHistoryPOM.softAssertTrue("offCanvas/side menu bar is open1 -", moreInfoSideMenuIsOpen, logger);
//		Thread.sleep(2000);
//
//		// close the more info side menu bar
//		transactionHistoryPOM.click_close_lastButton_moreInfoSideBar();
//		Thread.sleep(2000);
//
//		// assertion - is side bar closed
//
//		Boolean moreInfoSideMenuIsClose = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//
//		Thread.sleep(2000);
//		// assertion....side bar closed
//		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close2 -", moreInfoSideMenuIsClose, logger);
//
//		Thread.sleep(5000);
//		// 4.validate data count and message count at page bottom---------------
//		logger.log(LogStatus.INFO, "4.validate data count and message count at page bottom---------------");
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change VALID page data size
//		transactionHistoryPOM.changeCount_DataPerPage(25);
//		// assertion - validate table data and message at page bottom with ASSERTIONS
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change INVALID page data size
//
//		transactionHistoryPOM.changeCount_DataPerPage(2);
//
//	}
//
//	@Test(priority = 91, enabled = true, groups = "regression.MicroAtm")
//
//	public void TC091_scenarios_MicroAtmTab() throws InterruptedException, IOException {
//
//		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
//		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
//		commonFunc commonfunc = new commonFunc();
//
////login
//		tC1_VerifyLogin.verifySignIn(driver, logger);
////navigate to transaction module		
//		transactionHistoryPOM.click_reportsModule();
//		transactionHistoryPOM.click_txnHistoryModule();
//
//		Thread.sleep(2000);
//		// navigate to Micro Atm
//		// module/tab++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		transactionHistoryPOM.click_microAtmTab();
//		Thread.sleep(2000);
//
////select from date		
//		transactionHistoryPOM.selectFromDate2("11", "September", "2024");
////select to date	
//		transactionHistoryPOM.selectToDate2(12, "September", 2024);
////search		
//		transactionHistoryPOM.click_searchButton();
////1.validate if table has data-----------
//		logger.log(LogStatus.INFO, "1.validate if table has data-----------");
//
//		Boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();
//
//		if (dataInTable) {
//
//			logger.log(LogStatus.INFO, "Txn. table has data");
//
//		} else {
//
//			logger.log(LogStatus.INFO, "No data found for the selected date.");
//			logger.log(LogStatus.INFO, "checking message displayed when no data found");
//
//			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
//			String expectedMessage = "No items found.";
//
//			commonfunc.compareString(actualMessage, expectedMessage, true, logger);
////assertion - message displayed		
//			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, true,
//					logger);
//
//		}
//
//		// 2.validating default page size-----------
//		logger.log(LogStatus.INFO, "2.validating default page size-----------");
//
//		logger.log(LogStatus.INFO, "checking default page size");
//		String ActualDataPerPageNoDisplayed = transactionHistoryPOM.get_perPageDataSize();
//		// default page size STATIC =10
//		String expectedPageDataString = "10";
//		commonfunc.compareString(ActualDataPerPageNoDisplayed, expectedPageDataString, true, logger);
//		// assertion - default page size selected
//		commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString, true,
//				logger);
//
//		Thread.sleep(5000);
//
//		// 3.validate side bar open or close---------------------
//		logger.log(LogStatus.INFO, "3.validate side bar open or close---------------------");
//
//		// select date
//		transactionHistoryPOM.selectFromDate2("10", "August", "2024");
////			transactionHistoryPOM.selectToDate2(20, "August", 2024);
//		// search
//		transactionHistoryPOM.click_searchButton();
//		Thread.sleep(5000);
//		// open more info side bar of 1st txn.
//		transactionHistoryPOM.OpenMoreInfoOfTxnPopup(1);
//
//		// validate side bar open or close
//
//		Boolean moreInfoSideMenuIsOpen = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//		Thread.sleep(1000);
//
//		System.out.println("offCanvas/side menu bar is open1 by method -" + moreInfoSideMenuIsOpen);
//		System.out.println(
//				"offCanvas/side menu bar is open1 by me -" + transactionHistoryPOM.moreinfoSideBar.isDisplayed());
//
//		// assertion - is side bar open
//		transactionHistoryPOM.softAssertTrue("offCanvas/side menu bar is open1 -", moreInfoSideMenuIsOpen, logger);
//		Thread.sleep(2000);
//
//		// close the more info side menu bar
//		transactionHistoryPOM.click_close_lastButton_moreInfoSideBar();
//		Thread.sleep(2000);
//
//		// assertion - is side bar closed
//
//		Boolean moreInfoSideMenuIsClose = transactionHistoryPOM
//				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
//
//		Thread.sleep(2000);
//		// assertion....side bar closed
//		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close2 -", moreInfoSideMenuIsClose, logger);
//
//		Thread.sleep(5000);
//		// 4.validate data count and message count at page bottom---------------
//		logger.log(LogStatus.INFO, "4.validate data count and message count at page bottom---------------");
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change VALID page data size
//		transactionHistoryPOM.changeCount_DataPerPage(25);
//		// assertion - validate table data and message at page bottom with ASSERTIONS
//
//		transactionHistoryPOM.validate_tableDataAndTextMessage();
//		// change INVALID page data size
//
//		transactionHistoryPOM.changeCount_DataPerPage(2);
//
//	}

}
package testRun;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
import pageObjects.SearchTransactionPOM;
import pageObjects.TransactionHistoryPOM;
import testCases.TC1_VerifyLogin;
import utility.testbase;

public class SearchTransactionTEST extends testbase {

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
		boolean titleIsSame = commonfunc.compareString(actualTitle, expectedTitle, ignoreCase_pageTitle, logger);
		commonfunc.softAssert("Navigate to 'Search Txn. History' page and validate page title -", actualTitle,
				expectedTitle, titleIsSame, logger);
	}

	@Test(priority = 2, enabled = true, groups = "regression.searchTxnReport")
	public void ATR002_messageDisplayedIfTableHasNoData() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		Thread.sleep(2000);

		commonfunc.waitForPageLoaded(driver, logger);

//validate message displayed if table has no data	
		boolean ignoreCase = false;
		String expectedMessage = "Data Not found.";
		searchTransactionPOM.validateMessageDisplayedIfSearchTxnTableHasNOData(expectedMessage, ignoreCase, logger);

	}

	@Test(priority = 3, enabled = true, groups = "regression.searchTxnReport")
	public void STR003_validateTheDefaultPageSize() throws InterruptedException, IOException {

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
		// apply filter and search------------
		searchTransactionPOM.selectFromDropdown("Number");
		searchTransactionPOM.enterText_filterValue("1999999999");
		searchTransactionPOM.click_searchButton();
		Thread.sleep(5000);
		boolean dataInTable = searchTransactionPOM.validateSearchTxnReportTableHasData();
		logger.log(LogStatus.INFO, "Table has data -"+dataInTable);
		// get default page size
		logger.log(LogStatus.INFO, "Get default page size");
		String actualPageSize = searchTransactionPOM.get_perPageDataSize();
		// default page size STATIC =10
		String expectedPageSize = "10";
		boolean ignoreCase = false;
		// compare string
		boolean defaultPageSizeIsSame = commonfunc.compareString(actualPageSize, expectedPageSize, ignoreCase, logger);
		// assertion - default page size selected
		commonfunc.softAssert("Dafault page size -", actualPageSize, expectedPageSize, defaultPageSizeIsSame, logger);

	}

	@Test(priority = 4, enabled = true, groups = "regression.searchTxnReport")
	public void STR004_validatePageDataAccordingToPageSize() throws InterruptedException, IOException {
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THIS SCENARIO ????????????????????????????????????????????????????

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		Thread.sleep(2000);

		// apply filter and search------------
		searchTransactionPOM.selectFromDropdown("Number");
		searchTransactionPOM.enterText_filterValue("1999999999");
		searchTransactionPOM.click_searchButton();
		Thread.sleep(10000);// assertion - page size selected and data fetched per page


		boolean isPageSizeSelected;
		boolean isSame_dataFetchedAndPageSelected;
		logger.log(LogStatus.INFO, "default page size selected===============10");

		isPageSizeSelected = searchTransactionPOM.selectPageSize(10);
		
		if (isPageSizeSelected) {
			isSame_dataFetchedAndPageSelected = searchTransactionPOM.isDataFetchedAccordingToPageSizeSelected();
			commonfunc.softAssertTrue("Data Fetched And Page Size Selected is Same-", isSame_dataFetchedAndPageSelected,
					logger);
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THIS SCENARIO ????????????????????????????????????????????????????????????????????????
			searchTransactionPOM.captureScreenshot_firstAndLastTxn();
		}
		
		
		logger.log(LogStatus.INFO, "Select page size=========20");
		
		isPageSizeSelected = searchTransactionPOM.selectPageSize(20);
		if (isPageSizeSelected) 
		{
			isSame_dataFetchedAndPageSelected = searchTransactionPOM.isDataFetchedAccordingToPageSizeSelected();
			commonfunc.softAssertTrue("Data Fetched And Page Size Selected is Same-", isSame_dataFetchedAndPageSelected,
					logger);
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THIS SCENARIO ????????????????????????????????????????????????????????????????????????
			searchTransactionPOM.captureScreenshot_firstAndLastTxn();
		}

//		isPageSizeSelected = searchTransactionPOM.selectPageSize(30);
//		if (isPageSizeSelected) {
//			isSame_dataFetchedAndPageSelected = searchTransactionPOM.isDataFetchedAccordingToPageSizeSelected();
//			commonfunc.softAssertTrue("Data Fetched And Page Size Selected is Same-", isSame_dataFetchedAndPageSelected,
//					logger);
//// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI S SCENARIO ????????????????????????????????????????????????????????????????????????
//			searchTransactionPOM.captureScreenshot_firstAndLastTxn();
//		}

		logger.log(LogStatus.INFO, "change page count to=========100");

		isPageSizeSelected = searchTransactionPOM.selectPageSize(100);
		if (isPageSizeSelected) {

			logger.log(LogStatus.INFO, "page size---1000---isPageSizeSelected---flag value ===" + isPageSizeSelected);

			isSame_dataFetchedAndPageSelected = searchTransactionPOM.isDataFetchedAccordingToPageSizeSelected();
			commonfunc.softAssertTrue("Data Fetched And Page Size Selected is Same-", isSame_dataFetchedAndPageSelected,
					logger);
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI S SCENARIO ????????????????????????????????????????????????????????????????????????
			searchTransactionPOM.captureScreenshot_firstAndLastTxn();
		}

	}

	@Test(priority = 5, enabled = true, groups = "regression.searchTxnReport")

	public void STR005_validatePageDataAccordingToPageSize_allPageSizes() throws InterruptedException, IOException {
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI S SCENARIO ????????????????????????????????????????????????????????????????????????

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		Thread.sleep(2000);

		// apply filter and search------------
		searchTransactionPOM.selectFromDropdown("Number");
		searchTransactionPOM.enterText_filterValue("1999999999");
		searchTransactionPOM.click_searchButton();
		Thread.sleep(5000);

		searchTransactionPOM.validate_dataPerPage_allPageSizes1();

	}

	@Test(priority = 6, enabled = true, groups = "regression.searchTxnReport")
	public void STR006_moreInfoSideMenu_ButtonsValidation() throws InterruptedException, IOException {

		// TEST -
				TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
				// POM -
				SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
				// COMMON METHOD CLASS -
				commonFunc commonfunc = new commonFunc();
				// login...
				tC1_VerifyLogin.verifySignIn(driver, logger);
				// navigate to search history module...
				searchTransactionPOM.click_reportsModule_sideMenuBar();
				searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
				searchTransactionPOM.selectFromDropdown("tid");

				logger.log(LogStatus.INFO, "1...category ===> Telecom - Failed");
				searchTransactionPOM.enterText_filterValue("DMORDERS47075293");//
				searchTransactionPOM.click_searchButton();
				searchTransactionPOM.moreInfo_sideBarHeaderButtonsValidate();

				logger.log(LogStatus.INFO, "1b...category ===> Telecom - Reversal");
				searchTransactionPOM.enterText_filterValue("DMORDERS47075292");
				searchTransactionPOM.click_searchButton();
				searchTransactionPOM.moreInfo_sideBarHeaderButtonsValidate();

				logger.log(LogStatus.INFO, "1c...category ===> Telecom - Successful");
				searchTransactionPOM.enterText_filterValue("DMORDERS42262963");
				searchTransactionPOM.click_searchButton();
				searchTransactionPOM.moreInfo_sideBarHeaderButtonsValidate();

				logger.log(LogStatus.INFO, "2...category ===> DMT - Successful");
				searchTransactionPOM.enterText_filterValue("DMORDERS42312066");// category- DMT txn status - Successful
				searchTransactionPOM.click_searchButton();
				searchTransactionPOM.moreInfo_sideBarHeaderButtonsValidate();

				logger.log(LogStatus.INFO, "3...category ===> BBPS - Failed");
				searchTransactionPOM.enterText_filterValue("DMORDERS42696544");
				searchTransactionPOM.click_searchButton();
				searchTransactionPOM.moreInfo_sideBarHeaderButtonsValidate();

	}

	
	@Test(priority = 7, enabled = true, groups = "regression.searchTxnReport")
	public void TC007_moreInfoSideMenu_TableDataFetch() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		searchTransactionPOM.selectFromDropdown("tid");
		searchTransactionPOM.enterText_filterValue("DMORDERS47075293");//
		searchTransactionPOM.click_searchButton();
				//open more info side bar of 1st txn.			
		searchTransactionPOM.validateMoreInfoSideMenu_TableData();//more info header buttons need combo of ...1.txn status 2.category and 3. ....get information first then handle
	}
	
	@Test(priority = 8, enabled = true, groups = "regression.searchTxnReport")
	public void TC008_moreInfoSideMenu_getParamValue() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		searchTransactionPOM.selectFromDropdown("tid");
		searchTransactionPOM.enterText_filterValue("DMORDERS47075293");//
		searchTransactionPOM.click_searchButton();
				//open more info side bar of 1st txn. (index 0)
		searchTransactionPOM.moreInfo_openSideMenu(0);
		
	boolean isDisp	= searchTransactionPOM.moreInfo_isSideBarDisplayed();
	
	if(isDisp)
	{
		
		String paramToGetVlaue = "IP Address:12";
	String valueString=	searchTransactionPOM.get_parameterValue_validateMoreInfoSideMenu(paramToGetVlaue);	
	
	logger.log(LogStatus.INFO, "parameter (entered) - value is -"+paramToGetVlaue+"-"+valueString);
	}
	else 
	{
		logger.log(LogStatus.INFO, "More info popup is not open/displayed");
	}
	
	}
	
	
	@Test(priority = 9, enabled = true, groups = "regression.searchTxnReport")
	public void STR_009_pageBottomMessageTotalPageCount() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		
//		logger.log(LogStatus.INFO, "1.........no data in table...............");
//
//		
//		Thread.sleep(1000);
//		searchTransactionPOM.validate_totalPagesCountTextMessage();
		logger.log(LogStatus.INFO, "2........................");

		searchTransactionPOM.selectFromDropdown("Mobile");
		searchTransactionPOM.enterText_filterValue("1999999999");//
		searchTransactionPOM.click_searchButton();
		Thread.sleep(10000);
		searchTransactionPOM.validate_totalPagesCountTextMessage();
		
		
		Thread.sleep(2000);
		searchTransactionPOM.selectFromDropdown("tid");
		logger.log(LogStatus.INFO, "1...category ===> Telecom - Failed");
		searchTransactionPOM.enterText_filterValue("DMORDERS47075293");//
		searchTransactionPOM.click_searchButton();
		searchTransactionPOM.validate_totalPagesCountTextMessage();

	}
	
	
	@Test(priority = 9, enabled = true, groups = "regression.searchTxnReport")
	public void inProgress() throws InterruptedException, IOException {

		// TEST -
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		// POM -
		SearchTransactionPOM searchTransactionPOM = new SearchTransactionPOM(driver, logger);
		// COMMON METHOD CLASS -
		commonFunc commonfunc = new commonFunc();
		// login...
		tC1_VerifyLogin.verifySignIn(driver, logger);
		// navigate to search history module...
		searchTransactionPOM.click_reportsModule_sideMenuBar();
		searchTransactionPOM.click_searchTxnModule_sideMenuBar_second();
		searchTransactionPOM.selectFromDropdown("Mobile");
		searchTransactionPOM.enterText_filterValue("1999999999");//
		searchTransactionPOM.click_searchButton();
		Thread.sleep(5000);
		searchTransactionPOM.validate_totalPagesCountTextMessage();

	}
	
	

	


}

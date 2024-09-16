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

	@Test(priority = 1, enabled = false)
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
		String expectedTitle = "Transaction History";
		commonfunc.compareString(actualTitle, expectedTitle, false);
		commonfunc.softAssert("Navigate to Txn. History page and validate page title -", expectedTitle, actualTitle,
				true, logger);

	}

	@Test(priority = 2, enabled = false)
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

	@Test(priority = 3, enabled = false)
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
		// transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//select to date	
		// transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();

		Thread.sleep(2000);
//validate if table has data
		Boolean dataInTable = transactionHistoryPOM.validateALLTxnReportTableHasData();

		if (dataInTable) {

			logger.log(LogStatus.INFO, "Txn. table has data");

		} else {

			logger.log(LogStatus.INFO, "No data found for the selected date.");
			logger.log(LogStatus.INFO, "checking message displayed when no data found");

			String actualMessage = transactionHistoryPOM.getTxnTable_messageIfNoTableData();
			String expectedMessage = "No items found.";

			commonfunc.compareString(actualMessage, expectedMessage, true);
			commonfunc.softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, true,
					logger);

		}

	}

	@Test(priority = 4, enabled = false)
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
		commonfunc.softAssert("Dafault page size -", ActualDataPerPageNoDisplayed, expectedPageDataString, true,
				logger);

	}

	@Test(priority = 5, enabled = false)
	public void TC005_validatePageDataAccordingToPageSize() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

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
		Boolean dataFetchedAndPageSelected = transactionHistoryPOM.isDataFetchedAccordingToPageSizeSelected();

		commonfunc.softAssertTrue("soft assert true - dataFetchedAndPageSelected", dataFetchedAndPageSelected, logger);
	}

	@Test(priority = 6, enabled = false)
	public void TC006_openMoreDetailsUsingMeatballIcon() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select date		
		transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//		transactionHistoryPOM.selectToDate2(20, "August", 2024);
//search		
		transactionHistoryPOM.click_searchButton();
		Thread.sleep(2000);

//open more info side bar of 1st txn.	
		transactionHistoryPOM.OpenMoreInfoOfTxnPopup(1);
		Thread.sleep(1000);

//assertion....side bar open	
		Boolean moreInfoSideMenuIsOpen = transactionHistoryPOM
				.isPresentAndDisplayed(transactionHistoryPOM.moreinfoSideBar, driver, logger);
		Thread.sleep(1000);

		System.out.println("offCanvas/side menu bar is open1 by method -" + moreInfoSideMenuIsOpen);
		System.out.println(
				"offCanvas/side menu bar is open1 by me -" + transactionHistoryPOM.moreinfoSideBar.isDisplayed());

		transactionHistoryPOM.softAssertTrue("offCanvas/side menu bar is open1 -", moreInfoSideMenuIsOpen, logger);
		// close the more info side menu bar
		transactionHistoryPOM.closeMoreInfoOfTxnPopup(1);
		Thread.sleep(2000);
		// assertion....side bar closed

		transactionHistoryPOM.softAssertFalse("offCanvas/side menu bar is close2 -", moreInfoSideMenuIsOpen, logger);

//print parameter and values	
//	Boolean moreInfoPopupOpen = transactionHistoryPOM.isMoreInfoOfTxnPopup_Appeared(1);
//    logger.log(LogStatus.INFO,"isMoreInfoOfTxnPopup_Appeared -"+moreInfoPopupOpen);
//      
//    int paramNos = transactionHistoryPOM.getMoreInfoTable_paramNameListSize();
//    int paramValueNos = transactionHistoryPOM.getMoreInfoTable_paramValueListSize();

	}

	@Test(priority = 7, enabled = false)
	public void TC007_categoryFilterWorking() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select date		
		transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//		transactionHistoryPOM.selectToDate2(20, "August", 2024);

		//click category dropdown
		transactionHistoryPOM.click_categoryDropdown();	
		// select category - Telecom
		String categoryToApplyFilter = "Telecom";
		transactionHistoryPOM.selectCategoryFromDropdown(categoryToApplyFilter);
		// search
		transactionHistoryPOM.click_searchButton();
		Thread.sleep(2000);

		for (int a = 1; a <= 5; a++) {

			String txnCategoryInTablePair = transactionHistoryPOM.getCategoryOfATxn(a);
			String txnCategoryInTable=	txnCategoryInTablePair.replace("Category: ",""); //find alternative to get ONLY category name++++++++++++++
			
			
			Boolean stringIsSame = commonfunc.compareString(categoryToApplyFilter, txnCategoryInTable, true);
			commonfunc.softAssert("Category filter applied and category of a txn. in table-", categoryToApplyFilter,
					txnCategoryInTable, stringIsSame, logger);
			
			System.out.println("valid--cat--Txn no.-" + a + " txn cat -" + txnCategoryInTable);


		}

	}
	
	@Test(priority = 8, enabled = false)
	public void TC008_serviceFilterWorking() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select date		
		transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//		transactionHistoryPOM.selectToDate2(20, "August", 2024);

		//click category dropdown
		transactionHistoryPOM.click_categoryDropdown();	
		// select category - Telecom
		String categoryToApplyFilter = "Telecom";
		transactionHistoryPOM.selectCategoryFromDropdown(categoryToApplyFilter);
	
		Thread.sleep(2000);
		
		//click service dropdown
				transactionHistoryPOM.click_serviceDropdown();	
	//select service	
		String serviceToApplyFilter = "Mobile";
		transactionHistoryPOM.selectServiceFromDropdown(serviceToApplyFilter);

		// search
		transactionHistoryPOM.click_searchButton();
		Thread.sleep(2000);

		for (int a = 1; a <= 5; a++) {

			String txnCategoryInTablePair = transactionHistoryPOM.getCategoryOfATxn(a);
			String txnCategoryInTable=	txnCategoryInTablePair.replace("Category: ",""); //find alternative to get ONLY category name++++++++++++++
			
			String txnServiceInTablePair = transactionHistoryPOM.getServiceOfATxn(a);
			String txnServiceInTable=	txnServiceInTablePair.replace("Service: ",""); //find alternative to get ONLY category name++++++++++++++
			
			
			Boolean stringIsSame = commonfunc.compareString(categoryToApplyFilter, txnCategoryInTable, true);
			commonfunc.softAssert("Category filter applied and category of a txn. in table-", categoryToApplyFilter,
					txnCategoryInTable, stringIsSame, logger);

			Boolean stringIsSame2 = commonfunc.compareString(serviceToApplyFilter, txnServiceInTable, true);
			commonfunc.softAssert("Service filter applied and service of a txn. in table-", serviceToApplyFilter,
					txnServiceInTable, stringIsSame2, logger);

			
			System.out.println("valid--cat--Txn no.-" + a + "." +categoryToApplyFilter+"-"+ txnCategoryInTable);
			System.out.println("valid--service--Txn no.-" + a +"." +serviceToApplyFilter+"-"+ txnServiceInTable);



		}
		
	}
	
//VALIDATE the method...operator dropdown handling........................
	
	@Test(priority = 9, enabled = false)
	public void TC009_operatorFilterWorking() throws InterruptedException, IOException {

		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to txn. history page		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
//select date		
		transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//		transactionHistoryPOM.selectToDate2(20, "August", 2024);

		//click category dropdown
		transactionHistoryPOM.click_categoryDropdown();	
		// select category - Telecom
		String categoryToApplyFilter = "Telecom";
		transactionHistoryPOM.selectCategoryFromDropdown(categoryToApplyFilter);
	
		Thread.sleep(2000);
				
		//click service dropdown
				transactionHistoryPOM.click_serviceDropdown();		
	//select service	
		String serviceToApplyFilter = "Mobile";
		transactionHistoryPOM.selectServiceFromDropdown(serviceToApplyFilter);

Thread.sleep(2000);
		
		//click operator dropdown
				transactionHistoryPOM.click_operatorDropdown();	
		//select operator	
				String operatorToApplyFilter = "JIO";
//				transactionHistoryPOM.enterText_selectOperatorFromDropdown(operatorToApplyFilter);
				transactionHistoryPOM.selectOperatorFromDropdown(serviceToApplyFilter);
				Thread.sleep(2000);

		// search
		transactionHistoryPOM.click_searchButton();
		Thread.sleep(2000);

		for (int a = 1; a <= 5; a++) {

			String txnCategoryInTablePair = transactionHistoryPOM.getCategoryOfATxn(a);
			String txnCategoryInTable=	txnCategoryInTablePair.replace("Category: ",""); //find alternative to get ONLY category name++++++++++++++
			
			String txnServiceInTablePair = transactionHistoryPOM.getServiceOfATxn(a);
			String txnServiceInTable=	txnServiceInTablePair.replace("Service: ",""); //find alternative to get ONLY category name++++++++++++++
			
			String txnOperatorInTablePair = transactionHistoryPOM.getOperatorOfATxn(a);
			String txnOperatorInTable=	txnOperatorInTablePair.replace("Operator: ",""); //find alternative to get ONLY category name++++++++++++++
	
			
			Boolean stringIsSame = commonfunc.compareString(categoryToApplyFilter, txnCategoryInTable, true);
			commonfunc.softAssert("Category filter applied and category of a txn. in table-", categoryToApplyFilter,
					txnCategoryInTable, stringIsSame, logger);

			Boolean stringIsSame2 = commonfunc.compareString(serviceToApplyFilter, txnServiceInTable, true);
			commonfunc.softAssert("Service filter applied and service of a txn. in table-", serviceToApplyFilter,
					txnServiceInTable, stringIsSame2, logger);

			Boolean stringIsSame3 = commonfunc.compareString(operatorToApplyFilter, txnOperatorInTable, true);
			commonfunc.softAssert("opeartor filter applied and opeartor of a txn. in table-", operatorToApplyFilter,
					txnOperatorInTable, stringIsSame3, logger);

			
			System.out.println("valid--cat--Txn no.-" + a + "." +categoryToApplyFilter+"-"+ txnCategoryInTable);
			System.out.println("valid--service--Txn no.-" + a +"." +serviceToApplyFilter+"-"+ txnServiceInTable);
			System.out.println("valid--operator--Txn no.-" + a +"." +operatorToApplyFilter+"-"+ txnOperatorInTable);


		}
		
	}
	
	
	@Test(priority = 10, enabled = true)
	public void TC010_telecomTabHasNoCatDropdown() throws InterruptedException, IOException {
	
		TC1_VerifyLogin tC1_VerifyLogin = new TC1_VerifyLogin();
		TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM(driver, logger);
		commonFunc commonfunc = new commonFunc();

//login
		tC1_VerifyLogin.verifySignIn(driver, logger);
//navigate to transaction module		
		transactionHistoryPOM.click_reportsModule();
		transactionHistoryPOM.click_txnHistoryModule();
		Thread.sleep(2000);
		
	Boolean catTaBoolean=	transactionHistoryPOM.isCategoryTabDisplayed();
		System.out.println("cat tab is -"+catTaBoolean);
		
		Thread.sleep(2000);
		transactionHistoryPOM.click_telecomTab();
		Thread.sleep(2000);
		
		Boolean catTaBoolean2=	transactionHistoryPOM.isCategoryTabDisplayed();
		System.out.println("cat tab 2 is -"+catTaBoolean2);
		
		
	}
	
}

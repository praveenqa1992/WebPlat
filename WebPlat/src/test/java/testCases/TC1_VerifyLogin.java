package testCases;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Login;
import pageObjects.TransactionHistoryPOM;
import utility.config;
import utility.testbase;

/**********************************************************************************************************************************
 * @author : Praveen Kumar
 * QC ID   : TC-1
 * JIRA ID : 
 * Date    :
 * *******************************************************************************************************************************/


public class TC1_VerifyLogin  extends testbase{


	@Test
	public void verifySignIn(WebDriver driver, ExtentTest logger ) throws InterruptedException, IOException  {
	
		Login login = new Login (driver,logger);
		testConfig = new config(logger);
		//commonFunc comm =new commonFunc();
		
		String user = testConfig.getRunTimeProperty("username");
		String pass = testConfig.getRunTimeProperty("password");

		logger.log(LogStatus.INFO, "Step 1: Goto \"https://merchant.uatdev.in/\" ");

		login.signin(user, pass);
		Thread.sleep(5000);
		login.dialogClose();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	logger.log(LogStatus.INFO, "Step 2: logged in successfully ");

// txn. history ....................
	
//	TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM (driver,logger);
//	
//	transactionHistoryPOM.click_reportsModule();
//
//	transactionHistoryPOM.click_txnHistoryModule();
//
//	transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//		
//    transactionHistoryPOM.selectToDate2(20, "August", 2024);
//
//    transactionHistoryPOM.click_searchButton();
//
//	Thread.sleep(5000);
//
//	System.out.println("waiting to read table data");

	
//validate table has data or not...if yes then open more info of a txn.........
	
//	Boolean tableData = transactionHistoryPOM.validateALLTxnReportTableHasData();
//	
//	System.out.println("Table has data -"+tableData);
	
//1......	
//	System.out.println("1..current page=================");
//	String currentPageNo = transactionHistoryPOM.getCurentPageNumber();
//	System.out.println("current page no. is-"+currentPageNo);
//	transactionHistoryPOM.validation_pageSizeAndDataPerPage();
//	transactionHistoryPOM.validation_tableDataAndTextMessage();
//	transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();

//	System.out.println("2..next page");
//	transactionHistoryPOM.click_navigate_nextPageButton();
//	String currentPageNo2 = transactionHistoryPOM.getCurentPageNumber();
//	logger.log(LogStatus.INFO, "current (next) Page No. is-"+currentPageNo2);
//	transactionHistoryPOM.validation_pageSizeAndDataPerPage();
//	transactionHistoryPOM.validation_tableDataAndTextMessage();
//	transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();

//	System.out.println("3..previous page");
//	transactionHistoryPOM.click_navigate_previousPageButton();
//	logger.log(LogStatus.INFO, "current (previous) Page No.is-"+transactionHistoryPOM.getCurentPageNumber());
//	transactionHistoryPOM.validation_pageSizeAndDataPerPage();
//	transactionHistoryPOM.validation_tableDataAndTextMessage();
//	transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();

//	System.out.println("4..last page");
//	transactionHistoryPOM.click_navigate_lastPageButton();
//	logger.log(LogStatus.INFO, "current(LAST)Page No. is-"+transactionHistoryPOM.getCurentPageNumber());
//	transactionHistoryPOM.validation_pageSizeAndDataPerPage();
//	transactionHistoryPOM.validation_tableDataAndTextMessage();
//	transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();

//	System.out.println("5..first page");
//	transactionHistoryPOM.click_navigate_firstPageButton();
//	logger.log(LogStatus.INFO, "current(FIRST)Page No.is-"+transactionHistoryPOM.getCurentPageNumber());
//	transactionHistoryPOM.validation_pageSizeAndDataPerPage();
//	transactionHistoryPOM.validation_tableDataAndTextMessage();
//	transactionHistoryPOM.validate_dataPerPageWithAllPageSizes();

	
	//2......	
//		System.out.println("3...current page=================");
//		String currentPageNo3 = transactionHistoryPOM.getCurentPageNumber();
//		System.out.println("current page no. is-"+currentPageNo3);
	
//navigate to same page	
	
//		transactionHistoryPOM.click_navigate_nextPageButton();
//		transactionHistoryPOM.click_navigate_nextPageButton();
//		
//		transactionHistoryPOM.click_navigate_previousPageButton();
//		transactionHistoryPOM.click_navigate_lastPageButton();
//		transactionHistoryPOM.click_navigate_firstPageButton();


		
//3................
		
	
//		transactionHistoryPOM.aaagetNextWE();
//		transactionHistoryPOM.aaagetLastWE();
//		Thread.sleep(2000);
//		transactionHistoryPOM.click_navigate_lastPageButton();
//		Thread.sleep(5000);
//		transactionHistoryPOM.aaagetPrevWE();
//		transactionHistoryPOM.aaagetFirstWE();
		
	
//        int pageCount=	transactionHistoryPOM.getPageNumbersCountDisplayedAtPageBottom();
//		System.out.println("page numbers -"+pageCount);
//		
//		
//		
//		
		
		
		
	}

}
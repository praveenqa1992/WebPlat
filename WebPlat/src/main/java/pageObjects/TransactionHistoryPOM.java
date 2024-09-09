package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class TransactionHistoryPOM extends commonFunc {

	public WebDriver driver;
	public ExtentTest logger;
	public WebElement Element;

	@FindBy(xpath = "//div[@class='app-content my-3 my-md-0']")
	public WebElement page;

	@FindBy(xpath = "//span[text()='Reports']")
	public WebElement reportsModule;

	@FindBy(xpath = "//a[@class='slide-item'] [text()=' Transaction History']")
	public WebElement txnHistoryModule;

//page top elements
	@FindBy(xpath = "//calendaricon[@class='p-element p-icon-wrapper ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromCalenderIcon;

	@FindBy(xpath = "//button[@class='p-datepicker-month p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromMonth;

	@FindBy(xpath = "//button[@class='p-datepicker-year p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromYear;

	@FindBy(xpath = "//chevronlefticon[@class='p-element p-icon-wrapper ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromCalenderPreviousButton;

//	@FindBy(xpath="//chevronlefticon[@class='p-element p-icon-wrapper ng-tns-c46-10 ng-star-inserted']")
//	public WebElement fromCalenderNextButton;

	@FindBy(xpath = "//calendaricon[@class='p-element p-icon-wrapper ng-tns-c46-11 ng-star-inserted']")
	public WebElement toCalenderIcon;

	@FindBy(xpath = "//button[@class='p-datepicker-month p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toMonth;

	@FindBy(xpath = "//button[@class='p-datepicker-year p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toYear;

	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toCalenderPreviousButton;

//	@FindBy(xpath="//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-11 ng-star-inserted']")
//	public WebElement toCalenderNextButton;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchButton;

	@FindBy(xpath = "//div[@class='col-xl-2 col-lg-2 col-md-4 col-sm-4 col-12']")
	public List<WebElement> calenderAndDropdownCommonTabList_allTabs;

	@FindBy(xpath = "//div[@class='col-xl-2 col-lg-2 col-md-4 col-sm-4 col-12 ng-star-inserted']")
	public WebElement categoryTab;

	@FindBy(xpath = "/div[@class='p-dropdown-trigger'][1]")
	public WebElement categoryDropdown;

	@FindBy(xpath = "//span[text()='Select Service']")
	public WebElement serviceDropdown;

	@FindBy(xpath = "//span[text()='Select Operator']")
	public WebElement operatorDropdown;

	@FindBy(xpath = "//table[@id='pr_id_13-table']/tbody/tr[1]/td[3]/span[1]")
	public WebElement txn_service;

	@FindBy(xpath = "//table[@id='pr_id_13-table']/tbody/tr[1]/td[3]/span[2]")
	public WebElement txn_category;

	@FindBy(xpath = "//table[@id='pr_id_13-table']/tbody/tr[1]/td[3]/span[3]")
	public WebElement txn_operator;

	@FindBy(xpath = "//button[@id='nav-home-tab']")
	public WebElement allTxnReportTab;

	@FindBy(xpath = "//button[@id='nav-profile-tab']")
	public WebElement telecomTab;

	@FindBy(xpath = "//button[@id='nav-contact-tab'][1]")
	public WebElement dmtTab;

	@FindBy(xpath = "//button[@id='nav-contact-tab'][2]")
	public WebElement bbpsTab;

	@FindBy(xpath = "//button[@id='nav-contact-tab'][3]")
	public WebElement aepsTab;

	@FindBy(xpath = "//button[@id='nav-contact-tab'][4]")
	public WebElement microAtmTab;

	@FindBy(xpath = "//img[@ptooltip='Export']")
	public WebElement exportFileIcon;

	@FindBy(xpath = "//ul[@id='pr_id_18_list']//p-dropdownitem")
	public List<WebElement> categoryDropList;

	@FindBy(xpath = "//ul[@id='pr_id_11_list']//p-dropdownitem")
	public List<WebElement> serviceDropList;

	@FindBy(xpath = "//ul[@id='pr_id_12_list']/p-dropdownitem")
	public List<WebElement> operatorDropList;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-10']//tbody//span")
	public List<WebElement> datesOfFromCalender;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-11']//tbody//span")
	public List<WebElement> datesOfToCalender;

//------------------------------------	

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/thead/tr/th")
	public List<WebElement> txnTable_columnNumbers;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr")
	public List<WebElement> txnTable_rowNumbers;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr/td")
	public List<WebElement> txnTable_ONErowData;

//modify	
	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr[1]/td[10]/a/i")
	public WebElement txnMoreInfo_Icon;

	@FindBy(xpath = "//div[@class='offcanvas reportmodule offcanvas-end show']//button")
	public WebElement txnMoreInfo_Close;

	@FindBy(xpath = "//table[@class='table reportdata']/tbody/tr/td[1]")
	public List<WebElement> moreInfoTable_paramNameList;

	@FindBy(xpath = "//table[@class='table reportdata']/tbody/tr/td[2]")
	public List<WebElement> moreInfoTable_paramValueList;

//page bottom buttons

	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']//child::button")
	public List<WebElement> bottom_PagenumbersDisplayed;

	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']")
	public WebElement curentPageNumber;

	
	
	
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link p-disabled ng-star-inserted']")
	public WebElement navigate_firstPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link p-disabled ng-star-inserted']//child::angledoublelefticon")
	public WebElement navigate_firstPageButton;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link ng-star-inserted']")
	public WebElement e_navigate_firstPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link ng-star-inserted']//child::angledoublelefticon")
	public WebElement e_navigate_firstPageButton;
	
	
	
	
	
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link p-disabled']//child::anglerighticon")
	public WebElement navigate_previousPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link p-disabled']")
	public WebElement navigate_previousPageButton;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link']//child::anglelefticon")
	public WebElement e_navigate_previousPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link']")
	public WebElement e_navigate_previousPageButton;
	
	
	
	
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link p-disabled']//child::anglerighticon")
	public WebElement navigate_nextPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link p-disabled']")
	public WebElement navigate_nextPageButton;

	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link']//child::anglerighticon")
	public WebElement e_navigate_nextPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link']")
	public WebElement e_navigate_nextPageButton;

	
	
	
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link p-disabled ng-star-inserted']")
	public WebElement navigate_lastPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link p-disabled ng-star-inserted']//child::angledoublerighticon")
	public WebElement navigate_lastPageButton;

	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link ng-star-inserted']")
	public WebElement e_navigate_lastPageButton_enabledOrDesabled;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link ng-star-inserted']//child::angledoublerighticon")
	public WebElement e_navigate_lastPageButton;
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")
	public WebElement dataPerPageField;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']//following::div[@class='p-dropdown-trigger']")
	public WebElement pageSizeDropdown;

	@FindBy(xpath = "//div[@class='p-dropdown-items-wrapper']/ul/p-dropdownitem/li")
	public List<WebElement> perPageDataOptions;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")
	public WebElement page_dataPerPageNumber;

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	public WebElement page_paginationDataCountingMsg;	
	
	@FindBy(xpath = "//div[@class='p-paginator-first pr-0 p-paginator p-component ng-star-inserted']/span[2]/child::button")
	public List<WebElement> pageNumbersCountDisplayedAtPageBottom;
	
	@FindBy(xpath = "//p-paginator[@class='p-element']")
	public WebElement paginationWebElement;
	
	@FindBy(xpath = "")
	public WebElement q;
	
	@FindBy(xpath = "")
	public WebElement a;
	

	public TransactionHistoryPOM(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	public void click_reportsModule() {
		waitForElementToAppear(reportsModule, driver, logger);
		click(reportsModule, driver, logger);
		logger.log(LogStatus.INFO, "click_reportsModule");

	}

	public void click_txnHistoryModule() {
		waitForElementToAppear(txnHistoryModule, driver, logger);
		click(txnHistoryModule, driver, logger);
		logger.log(LogStatus.INFO, "click_txnHistoryModule");

	}

	public void click_allTxnReportTab() {
		waitForElementToAppear(allTxnReportTab, driver, logger);
		click(allTxnReportTab, driver, logger);
		logger.log(LogStatus.INFO, "click_allTxnReportTab");

	}

	public void click_telecomTab() {
		waitForElementToAppear(telecomTab, driver, logger);
		click(telecomTab, driver, logger);
		logger.log(LogStatus.INFO, "click_telecomTab");

	}

	public void click_dmtTab() {
		waitForElementToAppear(dmtTab, driver, logger);
		click(dmtTab, driver, logger);
		logger.log(LogStatus.INFO, "click_telecomTab");

	}

	public void click_bbpsTab() {
		waitForElementToAppear(bbpsTab, driver, logger);
		click(bbpsTab, driver, logger);
		logger.log(LogStatus.INFO, "click_telecomTab");

	}

	public void click_aepsTab() {
		waitForElementToAppear(aepsTab, driver, logger);
		click(aepsTab, driver, logger);
		logger.log(LogStatus.INFO, "click_telecomTab");

	}

	public void click_microAtmTab() {
		waitForElementToAppear(microAtmTab, driver, logger);
		click(microAtmTab, driver, logger);
		logger.log(LogStatus.INFO, "click_telecomTab");

	}

	public void click_exportFileIcon() {
		waitForElementToAppear(exportFileIcon, driver, logger);
		click(exportFileIcon, driver, logger);
		logger.log(LogStatus.INFO, "click_telecomTab");

	}

	public void click_searchButton() {
		waitForElementToAppear(searchButton, driver, logger);
		click(searchButton, driver, logger);
		logger.log(LogStatus.INFO, "click_searchButton");

	}

//	public void selectFromDate (int date, String monthString , int year) {
//		
//		logger.log(LogStatus.INFO, "selecting a date from date calendar");
//
//		String stringDate = Integer.toString(date);
//		String stringYear = Integer.toString(year);
//
//		waitForPageLoaded(driver, logger);
//		waitForElementToAppear(fromCalenderIcon, driver, logger);
//		click(fromCalenderIcon, driver, logger);
//		
//		logger.log(LogStatus.INFO, "from calendar icon clicked");
//
//		logger.log(LogStatus.INFO, "selecting from month and from year");
//
//		
//		String calenderMonth = fromMonth.getText();
//		String calenderYear = fromYear.getText();
//		
//		
//		while(!(calenderMonth.equals(monthString) && calenderYear.equals(stringYear)))
//		{
//			waitForElementToAppear(fromCalenderPreviousButton, driver, logger);
//			click(fromCalenderPreviousButton, driver, logger);
//			 calenderMonth = fromMonth.getText();
//			 calenderYear = fromYear.getText();
//		}
//		
//		logger.log(LogStatus.INFO, "selected from month -"+monthString+" and from year -"+stringYear);
//		logger.log(LogStatus.INFO, "selecting from date");
//
//		String calenderDate = null;
//		
//		for(int row=1; row<=5; row++)
//		{
//			for(int col=1; col<=7; col++)
//			{
//				WebElement dateWebElement = driver.findElement(By.xpath("//table[@class='p-datepicker-calendar ng-tns-c46-10']//tbody//tr["+row+"]//td["+col+"]"));
//				calenderDate=dateWebElement.getText();
//			 if(calenderDate.equals(stringDate))
//			 {
//				 click(dateWebElement, driver, logger);
//				logger.log(LogStatus.INFO, "selected from date -"+stringDate);
//				break;
//			 }
//             
//			}
//			
//		}
//		
//	}
//	
//public void selectToDate (int date, String monthString , int year) throws InterruptedException {
//	
//	Thread.sleep(5000);
//	logger.log(LogStatus.INFO, "selecting a date from to calendar");
//
//	String stringDate = Integer.toString(date);
//	String stringYear = Integer.toString(year);
//
//	waitForPageLoaded(driver, logger);
//	waitForElementToAppear(toCalenderIcon, driver, logger);
//	click(toCalenderIcon, driver, logger);
//
//	logger.log(LogStatus.INFO, "to calendar icon clicked");
//
//	logger.log(LogStatus.INFO, "selecting to month and to year");
//	
//	String calenderMonth = toMonth.getText();
//	String calenderYear = toYear.getText();
//	
//	
//	while(!(calenderMonth.equals(monthString) && calenderYear.equals(stringYear)))
//	{
//		waitForElementToAppear(toCalenderPreviousButton, driver, logger);
//		click(toCalenderPreviousButton, driver, logger);
//		 calenderMonth = toMonth.getText();
//		 calenderYear = toYear.getText();
//	}
//	
//	logger.log(LogStatus.INFO, "selected to month and to year");
//	logger.log(LogStatus.INFO, "selecting to date");
//	
//	String calenderDate = null;
//	
//	for(int row=1; row<=5; row++)
//	{
//		for(int col=1; col<=7; col++)
//		{
//			WebElement dateWebElementTo = driver.findElement(By.xpath("//table[@class='p-datepicker-calendar ng-tns-c46-11']//tbody//tr["+row+"]//td["+col+"]"));
//			calenderDate=dateWebElementTo.getText();
//			
//		 if(calenderDate.equals(stringDate))
//		 {
//			 click(dateWebElementTo, driver, logger);
//			logger.log(LogStatus.INFO, "selected to date");
//            break;
//		 }
//		 
//		}
//		
//	}
//	
//	}

	public void selectCategoryFromDropdown(String categoryToSelect) {

		logger.log(LogStatus.INFO, "navigating through category dropdown ");

		for (WebElement categoryOne : categoryDropList) {
			String requiredCategory = categoryOne.getText().trim();

			if (requiredCategory.equalsIgnoreCase(categoryToSelect)) {
				click(categoryOne, driver, logger);
				logger.log(LogStatus.INFO, "category click ");
				break;
			}
		}
	}

	public void selectServiceFromDropdown(String serviceToSelect) {

		logger.log(LogStatus.INFO, "navigating through service dropdown ");

		for (WebElement serviceOne : serviceDropList) {
			String requiredService = serviceOne.getText().trim();

			if (requiredService.equalsIgnoreCase(serviceToSelect)) {
				click(serviceOne, driver, logger);
				logger.log(LogStatus.INFO, "service click ");

				break;
			}
		}
	}

	public void selectOperatorFromDropdown(String operatorToSelect) {

		logger.log(LogStatus.INFO, "navigating through operator dropdown ");

		for (WebElement operatorOne : operatorDropList) {
			String requiredOperator = operatorOne.getText().trim();

			if (requiredOperator.equalsIgnoreCase(operatorToSelect)) {
				click(operatorOne, driver, logger);
				logger.log(LogStatus.INFO, "operator click ");

				break;
			}
		}
	}

	public void selectFromDate2(int date, String monthString, int year) {

		logger.log(LogStatus.INFO, "selecting a date from date calendar");

		String stringDate = Integer.toString(date);
		String stringYear = Integer.toString(year);

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "selecting from month and from year");

		String calenderMonth = fromMonth.getText();
		String calenderYear = fromYear.getText();

		while (!(calenderMonth.equals(monthString) && calenderYear.equals(stringYear))) {
			waitForElementToAppear(fromCalenderPreviousButton, driver, logger);
			click(fromCalenderPreviousButton, driver, logger);
			calenderMonth = fromMonth.getText();
			calenderYear = fromYear.getText();
		}

//		logger.log(LogStatus.INFO, "selected from month -" + calenderMonth + " and from year -" + calenderYear);
		logger.log(LogStatus.INFO, "selecting from date");

		String calendarDateValue = null;

		for (int aa = 1; aa <= 35; aa++) {
			calendarDateValue = datesOfFromCalender.get(aa).getText();
			if (calendarDateValue.equals(stringDate)) {
				click(datesOfFromCalender.get(aa), driver, logger);
//				logger.log(LogStatus.INFO, "selected from date-" + calendarDateValue);
				break;
			}

		}
		logger.log(LogStatus.INFO, "selected from date-" + calendarDateValue + "\bselected from month -" + calenderMonth
				+ "\bselected from year -" + calenderYear);

	}

	public void selectToDate2(int date, String monthString, int year) throws InterruptedException {

		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "selecting a date from to calendar");

		String stringDate = Integer.toString(date);
		String stringYear = Integer.toString(year);

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);

		logger.log(LogStatus.INFO, "selecting to month and to year");

		String calenderMonth = toMonth.getText();
		String calenderYear = toYear.getText();

		while (!(calenderMonth.equals(monthString) && calenderYear.equals(stringYear))) {
			waitForElementToAppear(toCalenderPreviousButton, driver, logger);
			click(toCalenderPreviousButton, driver, logger);
			calenderMonth = toMonth.getText();
			calenderYear = toYear.getText();
		}

//		logger.log(LogStatus.INFO, "selected to month -" + calenderMonth + "\bselected to year -" + calenderYear);
		logger.log(LogStatus.INFO, "selecting to date");

		String calendarDateValue = null;

		for (int aa = 1; aa <= 35; aa++) {
			calendarDateValue = datesOfToCalender.get(aa).getText();
			if (calendarDateValue.equals(stringDate)) {
				click(datesOfToCalender.get(aa), driver, logger);
//				logger.log(LogStatus.INFO, "selected to date-" + calendarDateValue);
				break;
			}

		}
		logger.log(LogStatus.INFO, "selected to date-" + calendarDateValue + "\bselected to month -" + calenderMonth
				+ "\bselected to year -" + calenderYear);

	}
//txn. table methods-------------------------------------------------------------	

	public int getTxnTable_columnNumbers() {
		waitForPageLoaded(driver, logger);
		return txnTable_columnNumbers.size();
	}

	public int getTxnNumberOne() {
		waitForPageLoaded(driver, logger);

		return txnTable_rowNumbers.size();
	}

	public int getTxnNumberLast() {
		waitForPageLoaded(driver, logger);
		return txnTable_rowNumbers.size();
	}

	public int getTxnTable_rowNumbers() {
		waitForPageLoaded(driver, logger);
		return txnTable_rowNumbers.size();
	}

	public int getTxnTable_ONErowData() {

		return txnTable_ONErowData.size();

	}

	public void openTxnMoreInfo() {
		waitForElementToAppear(txnMoreInfo_Icon, driver, logger);
		logger.log(LogStatus.INFO, "Open more info. of a transaction");
		click(txnMoreInfo_Icon, driver, logger);

	}

	public void closeTxnMoreInfo() {
		waitForElementToAppear(txnMoreInfo_Close, driver, logger);
		logger.log(LogStatus.INFO, "Close more info. of a transaction");
		click(txnMoreInfo_Close, driver, logger);

	}

	public void getMoreInfoTable_paramNameList() {

		moreInfoTable_paramNameList.get(0);
	}

	public void getMoreInfoTable_paramValueList() {

		moreInfoTable_paramValueList.get(0);
	}

//	public void getBottom_PagenumbersDisplayed(int indexNo) {
//
//		bottom_PagenumbersDisplayed.get(indexNo);
//		logger.log(LogStatus.INFO, "Current page number is");
//	}

//pagination methods........................

	public String getPage_paginationDataCountingMsg() {

		waitForElementToAppear(page_paginationDataCountingMsg, driver, logger);
		scrollToWebElement(page_paginationDataCountingMsg, driver);
		logger.log(LogStatus.INFO, "Pagination data counting msg. is -" + page_paginationDataCountingMsg.getText());
		return page_paginationDataCountingMsg.getText();

	}

	public String getCurentPageNumber() {

		waitForElementToAppear(curentPageNumber, driver, logger);
		logger.log(LogStatus.INFO, "Current page number captured -" + curentPageNumber.getText());
		return curentPageNumber.getText();

	}
	

	public int getPageNumbersCountDisplayedAtPageBottom () {
		//1.check - table has data or not	

				waitForPageLoaded(driver, logger);
				Boolean dataInTable = validateALLTxnReportTableHasData();

				waitForElementToAppear(paginationWebElement, driver, logger);
				scrollToWebElement(paginationWebElement, driver);
				
				if (dataInTable) 
				{
					int pageNumbersCount =	pageNumbersCountDisplayedAtPageBottom.size();
					 return pageNumbersCount;
				}
				else
		//1b-no => 
							{
					System.out.println("no data in table....");
								logger.log(LogStatus.INFO, "no data in table.... ");
							}
				return 0;

			}
	
	public void validate_DataInLastPage () {
		
//	int pages =	getPageNumbersCountDisplayedAtPageBottom();
//	int pageSize = getCurentPageDataSize();
//	 
//	
//	int extraData=
//	
//	
			// find first and last number of record according to PAGE BOTTOM MESSAGE
//
//						String mesaheAtPageBottom = getPage_paginationDataCountingMsg();
//						String[] splittedMsg = mesaheAtPageBottom.split(" ");
//
//						String firstNum = null;
//						String lastNum = null;
//						String totalTxns = null;
//
//						for (int a = 0; a <= (splittedMsg.length - 1); a++) {
//							if (a == 0 || a == 2 || a == 4 || a == 6) {
//								continue;
//							} else {
//								if (a == 1) {
//									firstNum = splittedMsg[a];
//								} else if (a == 3) {
//									lastNum = splittedMsg[a];
//								} else if (a == 5) {
//									totalTxns = splittedMsg[a];
//								}
//
//							}
//
//						}
//		
	}
	
	

	public int getCurentPageDataSize() {

		waitForPageLoaded(driver, logger);
		scrollToWebElement(page_dataPerPageNumber, driver);
		waitForElementToAppear(page_dataPerPageNumber, driver, logger);
		int dataPerPage = 0;

		try {
			logger.log(LogStatus.INFO, "fetch data per page number");
			dataPerPage = Integer.parseInt(page_dataPerPageNumber.getText());
		} catch (Exception e) {
			logger.log(LogStatus.INFO, e);
			logger.log(LogStatus.INFO, "page size dropdown has no value");
		}

		return dataPerPage;

	}


	public void click_navigate_firstPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(e_navigate_firstPageButton, driver, logger);
		logger.log(LogStatus.INFO, "scroll to first page button");
		scrollToWebElement(e_navigate_firstPageButton, driver);

		try {
			logger.log(LogStatus.INFO, "Click on FIRST page icon");
			
			System.out.println("first button is enabled -"+e_navigate_firstPageButton_enabledOrDesabled.isEnabled());
			System.out.println("first button is displayed -"+e_navigate_firstPageButton_enabledOrDesabled.isDisplayed());
			System.out.println("first button is selected -"+e_navigate_firstPageButton_enabledOrDesabled.isSelected());
			
			
			click(e_navigate_firstPageButton, driver, logger);
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			logger.log(LogStatus.INFO, "navigate_firstPageButton is disabled. You are at first page.");

		}

		
	}
	
	public void click_navigate_previousPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(e_navigate_previousPageButton, driver, logger);
		logger.log(LogStatus.INFO, "scroll to previous page button");
		scrollToWebElement(e_navigate_previousPageButton, driver);
		logger.log(LogStatus.INFO, "Click on previous page icon");
		
		
		System.out.println("previous button is enabled -"+e_navigate_previousPageButton_enabledOrDesabled.isEnabled());
		System.out.println("previous button is displayed -"+e_navigate_previousPageButton_enabledOrDesabled.isDisplayed());
		System.out.println("previous button is selected -"+e_navigate_previousPageButton_enabledOrDesabled.isSelected());
		
		
		click(e_navigate_previousPageButton, driver, logger);

	}
	public void click_navigate_nextPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(e_navigate_nextPageButton, driver, logger);
		logger.log(LogStatus.INFO, "scroll to next page button");
		scrollToWebElement(e_navigate_nextPageButton, driver);
		logger.log(LogStatus.INFO, "Click on next page icon");
		System.out.println("next button is enabled -"+e_navigate_nextPageButton_enabledOrDesabled.isEnabled());
		System.out.println("next button is displayed -"+e_navigate_nextPageButton_enabledOrDesabled.isDisplayed());
		System.out.println("next button is selected -"+e_navigate_nextPageButton_enabledOrDesabled.isSelected());


		
		click(e_navigate_nextPageButton, driver, logger);

	}

	

	public void click_navigate_lastPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(e_navigate_lastPageButton, driver, logger);
		logger.log(LogStatus.INFO, "scroll to last page button");
		scrollToWebElement(e_navigate_lastPageButton, driver);

		try {
			logger.log(LogStatus.INFO, "Click on LAST page icon");
			
			
			System.out.println("last button is enabled -"+e_navigate_lastPageButton.isEnabled());
			System.out.println("last button is displayed -"+e_navigate_lastPageButton.isDisplayed());
			System.out.println("last button is selected -"+e_navigate_lastPageButton.isSelected());
			
			
			click(e_navigate_lastPageButton, driver, logger);
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e);
			logger.log(LogStatus.INFO, "navigate_lastPageButton is disabled. You are at last page.");

		}

	}


	public void click_pageSizeDropdown() {

		waitForElementToAppear(pageSizeDropdown, driver, logger);
		logger.log(LogStatus.INFO, "scroll to page size dropdown");
		scrollToWebElement(pageSizeDropdown, driver);

		logger.log(LogStatus.INFO, "Click on page size dropdown");
		click(pageSizeDropdown, driver, logger);

	}

	public void get_perPageDataOptions(int indexNo) {

		perPageDataOptions.get(indexNo);
	}

	public boolean validateALLTxnReportTableHasData() {

		int recordsInFirstRow = getTxnTable_ONErowData();

		Boolean tableHasData;

		if (recordsInFirstRow > 1) {

			logger.log(LogStatus.INFO,
					"TABLE -> Records Found.\nThe \"All Transactions Report\" tableHasData has data");
			tableHasData = true;

		} else {

			logger.log(LogStatus.INFO,
					"TABLE -> No Records Found.\nThe \"All Transactions Report\" tableHasData has no data");
			tableHasData = false;
		}

		return tableHasData;
	}

	
	
	public void validateMoreInfoOfTxn(int txnNo) throws InterruptedException {

		if (validateALLTxnReportTableHasData()) {

			int colNos = getTxnTable_columnNumbers(); // last column has 'more info (meatball)' icon so last column
														// number should be used

			WebElement moreInfoIcon = driver.findElement(By.xpath(
					"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
							+ txnNo + "]/td[" + colNos + "]/a/i"));
			logger.log(LogStatus.INFO, "Click on more info (meatball) icon OPEN");
			click(moreInfoIcon, driver, logger);
			Thread.sleep(3000);
			logger.log(LogStatus.INFO, "Click on more info (meatball) icon CLOSE");
			click(txnMoreInfo_Close, driver, logger);

		} else {

			logger.log(LogStatus.INFO,
					"validateMoreInfoOfTxn is failed.\n TABLE -> No Records Found.\bThe \"All Transactions Report\" tableHasData has no data");

		}
	}

	
	public void validation_pageSizeAndDataPerPage() throws IOException {
		
		waitForPageLoaded(driver, logger);
		Boolean dataInTable = validateALLTxnReportTableHasData();

		if (dataInTable) {

			scrollToWebElement(pageSizeDropdown, driver);
			int tableDataNumber = getTxnTable_rowNumbers();
			int pageDataSizeSelected = getCurentPageDataSize();
//1a-yes => check - table has data - data is less or more than page size selected		
			if (tableDataNumber >= pageDataSizeSelected) 
			{
				System.out.println("table data >= page size selected.\nTable data="+tableDataNumber+"\npage size selected="+pageDataSizeSelected);
				logger.log(LogStatus.INFO,
						"table data >= page size selected");
				softAssert("STEP-Validate data per page and page size", String.valueOf(tableDataNumber),
						String.valueOf(pageDataSizeSelected), true, logger);
//			logger.log(LogStatus.INFO, "Validate data per page and page size => data >= 10 nos."+capture(driver));	
			} else 
			{
				System.out.println("table data < page size selected.\nTable data="+tableDataNumber+"\npage size selected="+pageDataSizeSelected);
				logger.log(LogStatus.INFO,
						"table data < page size selected.\nTable data nos.-"
								+ tableDataNumber + "\nPage size nos.-" + pageDataSizeSelected);
			}
		} else
			//1b-no => 
					{
			System.out.println("no data in table....");
						logger.log(LogStatus.INFO, "no data in table.... ");
					}
		
	}
	
	
	public void validation_tableDataAndTextMessage() throws IOException {
//1.check - table has data or not	

		waitForPageLoaded(driver, logger);
		Boolean dataInTable = validateALLTxnReportTableHasData();

		if (dataInTable) {

			scrollToWebElement(pageSizeDropdown, driver);
			int tableDataNumber = getTxnTable_rowNumbers();
			int pageDataSizeSelected = getCurentPageDataSize();
//1a-yes => check - table has data - data is less or more than page size selected		
			if (tableDataNumber >= pageDataSizeSelected) 
			{
 
				System.out.println("validation_tableDataAndTextMessage-----------table data >= page size selected.\nTable data="+tableDataNumber+"\npage size selected="+pageDataSizeSelected);

				logger.log(LogStatus.INFO,
						"table data >= page size selected");
				softAssert("STEP-Validate data per page and page size", String.valueOf(tableDataNumber),
						String.valueOf(pageDataSizeSelected), true, logger);
//			logger.log(LogStatus.INFO, "Validate data per page and page size => data >= 10 nos."+capture(driver));	
			} else 
			{
				System.out.println("validation_tableDataAndTextMessage----table data < page size selected.\nTable data="+tableDataNumber+"\npage size selected="+pageDataSizeSelected);

				logger.log(LogStatus.INFO,
						"table data < page size selected.\nTable data nos.-"
								+ tableDataNumber + "\nPage size nos.-" + pageDataSizeSelected);
			}

			// find first and last number of record according to TABLE
			WebElement ElementFirstNo = driver.findElement(By.xpath(
					"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
							+ 1 + "]/td[1]"));
			String firstNumFromTable = ElementFirstNo.getText();

			int tableRows = getTxnTable_rowNumbers();
			WebElement ElementLastNo = driver.findElement(By.xpath(
					"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
							+ tableRows + "]/td[1]"));
			String lastNumFromtable = ElementLastNo.getText();

			// find first and last number of record according to PAGE BOTTOM MESSAGE

			String mesaheAtPageBottom = getPage_paginationDataCountingMsg();
			String[] splittedMsg = mesaheAtPageBottom.split(" ");

			String firstNum = null;
			String lastNum = null;
			String totalTxns = null;

			for (int a = 0; a <= (splittedMsg.length - 1); a++) {
				if (a == 0 || a == 2 || a == 4 || a == 6) {
					continue;
				} else {
					if (a == 1) {
						firstNum = splittedMsg[a];
					} else if (a == 3) {
						lastNum = splittedMsg[a];
					} else if (a == 5) {
						totalTxns = splittedMsg[a];
					}

				}

			}
			// we have first,last,total txn number
			System.out.println("1 st no.from table -" + firstNumFromTable + "\n1 st no.in message - " + firstNum);
			System.out.println("last no.from table -" + lastNumFromtable + "\nlast no.in message - " + lastNum);
			System.out.println("total in message - " + totalTxns);
			
			softAssert("validate-first number of record according to PAGE BOTTOM MESSAGE\n", firstNum, firstNumFromTable, true, logger);
			softAssert("validate-last number of record according to PAGE BOTTOM MESSAGE\n", lastNum, lastNumFromtable, true, logger);

			
		} else
//1b-no => 
		{
			System.out.println("validation_tableDataAndTextMessage-----------no data in table....");

			logger.log(LogStatus.INFO, "no data in table.... ");
		}
	}

	public void selectDataPerPage(int dataPerPage) {

//navigate and click on page size dropdown		
		click_pageSizeDropdown();

//select a value from dropdown (index base so start from 0)		
		try {
			if (dataPerPage == 10) {
				waitForElementToAppear(perPageDataOptions.get(0), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				click(perPageDataOptions.get(0), driver, logger);

			} else if (dataPerPage == 25) {
				waitForElementToAppear(perPageDataOptions.get(1), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				click(perPageDataOptions.get(1), driver, logger);
			} else if (dataPerPage == 50) {
				waitForElementToAppear(perPageDataOptions.get(2), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				click(perPageDataOptions.get(2), driver, logger);
			} else {
				logger.log(LogStatus.INFO, "Please enter a valid data size per page\n entered value is -" + dataPerPage
						+ "\nValid values are - 10,25,50");
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Please enter a valid data size per page\n entered value is -" + dataPerPage
					+ "\nValid values are - 10,25,50");
			logger.log(LogStatus.INFO, e);
		}
	}

	public void validate_dataPerPageWithAllPageSizes() throws InterruptedException, IOException {

		// scroll and click on page size dropdown to get numbers of the options
		click_pageSizeDropdown();
		// select a value from dropdown (index base so start from 0)
		int pageSizeDropdownListNumbers = perPageDataOptions.size();
//		System.out.println("dropList out of loop -" + pageSizeDropdownListNumbers);
		
		String currentPageDatSize;
		
		// for loop will fetch all options available in dropdown
		for (int a = 0; a <= (pageSizeDropdownListNumbers - 1); a++) 
		{
      System.out.println("pageSizeDropdownListNumbers  in loop -" + pageSizeDropdownListNumbers);
       //select data size option 1 (according to index no.)
			scrollToWebElement(pageSizeDropdown, driver);
			waitForElementToAppear(perPageDataOptions.get(a), driver, logger);
			scrollToWebElement(perPageDataOptions.get(a), driver);
//to log data size option 1 (according to index no.)
			currentPageDatSize = perPageDataOptions.get(a).getText();
			logger.log(LogStatus.INFO, "Selected data per page -" + currentPageDatSize);
			System.out.println("selected page size is-" + currentPageDatSize);
//click data size option 1 (according to index no.) 
			Thread.sleep(2000);
			click(perPageDataOptions.get(a), driver, logger);
			System.out.println("clicked on  -" + perPageDataOptions.get(a).getText());
			Thread.sleep(3000);
// m1...
			validation_pageSizeAndDataPerPage();
			Thread.sleep(3000);
//m2...			
			validation_tableDataAndTextMessage();
			Thread.sleep(3000);
//wait for table loading after changing the data numbers displayed on page
			waitForPageLoaded(driver, logger);
			scrollToWebElement(pageSizeDropdown, driver);
			//click page size dropdown to get data size OPTIONS for second loop (if dropdown is close the loop
			click_pageSizeDropdown();
			//scroll to next page size as we will click on next page size in next ITERATION
		    scrollToWebElement(perPageDataOptions.get(a), driver);

		}

	}
//methods to reconsider...............	

	public void get_calenderAndDropdownCommonTabList_allTabs() {

		int listNos = calenderAndDropdownCommonTabList_allTabs.size();

		System.out.println("list ize is -" + listNos);

		for (int a = 0; a <= (listNos - 1); a++) {

			String listName = calenderAndDropdownCommonTabList_allTabs.get(a).getText();

			System.out.println(a + "-" + listName);
		}

	}

	public void verify_categoryDropdownIsPresent() {

		logger.log(LogStatus.INFO, "Verifying presence of the 'Category' dropdown");
		waitForPageLoaded(driver, logger);
//		Boolean categoryDroIsPresent = isPresentAndDisplayed(categoryTab, driver, logger);
		Boolean categoryDroIsPresent = checkPresenceOfElement(categoryTab, driver);

		try {
			if (categoryDroIsPresent) {
				System.out.println("Category dropdown is PRESENT -" + categoryDroIsPresent);
				highlightElement(categoryTab);
				logger.log(LogStatus.INFO, "Category dropdown is PRESENT -" + categoryDroIsPresent);
			} else {
				System.out.println("Category dropdown is pres -" + categoryDroIsPresent);
				logger.log(LogStatus.INFO, "Category dropdown is pres -" + categoryDroIsPresent);
			}

		} catch (Exception e) {
			System.out.println("Category dropdown is present -" + categoryDroIsPresent);
			logger.log(LogStatus.INFO, "Category dropdown is present -" + categoryDroIsPresent);
			logger.log(LogStatus.INFO, e);

		}

	}
	
	
	
	public void aaagetFirstWE () {
	System.out.println("first is displayed-"+e_navigate_firstPageButton.isDisplayed());	
	System.out.println("first is enabled-"+e_navigate_firstPageButton.isEnabled());	
	
	}
	public void aaagetPrevWE () {
		System.out.println("prev is displayed-"+e_navigate_previousPageButton.isDisplayed());	
		System.out.println("prev is enabled-"+e_navigate_previousPageButton.isEnabled());	
	}
	public void aaagetNextWE () {
		System.out.println("next is displayed-"+e_navigate_nextPageButton.isDisplayed());	
		System.out.println("next is enabled-"+e_navigate_nextPageButton.isEnabled());	
	}
	public void aaagetLastWE () {
		System.out.println("last is displayed-"+e_navigate_lastPageButton.isDisplayed());	
		System.out.println("last is enabled-"+e_navigate_lastPageButton.isEnabled());	
	}

}

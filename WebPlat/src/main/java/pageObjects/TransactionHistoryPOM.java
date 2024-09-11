package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

//from calendar previous and next buttons xpath...

	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromCalenderPreviousButton;

	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c46-10']")
	public WebElement fromCalenderNextButton;

//from calendar previous and next icons xpath...

//	@FindBy(xpath = "//chevronlefticon[@class='p-element p-icon-wrapper ng-tns-c46-10 ng-star-inserted']")
//	public WebElement fromCalenderPreviousButton;
//
//	@FindBy(xpath = "//chevronrighticon[@class='p-element p-icon-wrapper ng-tns-c46-10 ng-star-inserted']")
//	public WebElement fromCalenderNextButton;

//from calendar today's date => yes or not

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr[2]/td[@class='ng-tns-c46-14 p-datepicker-today ng-star-inserted']")
	public WebElement fromCalender_Date_Today;
//checkkkk list or not
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr[2]/td[@class='ng-tns-c46-14 ng-star-inserted']")
	public List<WebElement> fromCalender_Dates_notToday;

	// from calendar highlighted,enabled,disabled dates....

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr[2]/td/span[@class='p-ripple p-element ng-tns-c46-14 p-disabled ng-star-inserted']")
	public List<WebElement> fromCalender_Dates_disabled;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr[2]/td/span[@class='p-ripple p-element ng-tns-c46-14 ng-star-inserted']")
	public List<WebElement> fromCalender_Dates_enabled_notHighlited;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr[2]/td/span[@class='p-ripple p-element ng-tns-c46-14 p-highlight ng-star-inserted']")
	public WebElement fromCalender_Date_enabled_Highlited;

//	@FindBy(xpath="//chevronlefticon[@class='p-element p-icon-wrapper ng-tns-c46-10 ng-star-inserted']")
//	public WebElement fromCalenderNextButton;

	@FindBy(xpath = "//calendaricon[@class='p-element p-icon-wrapper ng-tns-c46-11 ng-star-inserted']")
	public WebElement toCalenderIcon;

	@FindBy(xpath = "//button[@class='p-datepicker-month p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toMonth;

	@FindBy(xpath = "//button[@class='p-datepicker-year p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toYear;

	// to calendar previous and next buttons xpath...

	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toCalenderPreviousButton;

	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c46-11']")
	public WebElement toCalenderNextButton;

	// to calendar previous and next icons xpath...

//		@FindBy(xpath = "//chevronlefticon[@class='p-element p-icon-wrapper ng-tns-c46-11 ng-star-inserted']")
//		public WebElement toCalenderPreviousButton;
//
//		@FindBy(xpath = "//chevronrighticon[@class='p-element p-icon-wrapper ng-tns-c46-11 ng-star-inserted']")
//		public WebElement toCalenderNextButton;

	// to calendar today's date => yes or not

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr[2]/td[@class='ng-tns-c46-5 p-datepicker-today ng-star-inserted']")
	public WebElement toCalender_Date_Today;
//check list or not
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr[2]/td[@class='ng-tns-c46-5 ng-star-inserted']")
	public List<WebElement> toCalender_Dates_notToday;

	// to calendar highlighted,enabled,disabled dates....

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr[2]/td/span[@class='p-ripple p-element ng-tns-c46-5 p-disabled ng-star-inserted']")
	public List<WebElement> toCalender_Dates_disabled;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr[2]/td/span[@class='p-ripple p-element ng-tns-c46-5 ng-star-inserted']")
	public List<WebElement> toCalender_Dates_enabled_notHighlited;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr[2]/td/span[@class='p-ripple p-element ng-tns-c46-5 p-highlight ng-star-inserted']")
	public WebElement toCalender_Date_enabled_Highlited;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchButton;

//dropdown............ 

	@FindBy(xpath = "//div[@class='col-xl-2 col-lg-2 col-md-4 col-sm-4 col-12']")
	public List<WebElement> calenderAndDropdown_CommonTabList_allTabs;

	@FindBy(xpath = "//div[@class='col-xl-2 col-lg-2 col-md-4 col-sm-4 col-12 ng-star-inserted']")
	public WebElement categoryTab;

	@FindBy(xpath = "//div[@class='p-dropdown-trigger'][1]")
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

	@FindBy(xpath = "//button[@id='nav-profile-tab']/img")
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

//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link p-disabled ng-star-inserted']")
//	public WebElement navigate_firstPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link p-disabled ng-star-inserted']//child::angledoublelefticon")
//	public WebElement navigate_firstPageButton;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link ng-star-inserted']")
//	public WebElement e_navigate_firstPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link ng-star-inserted']//child::angledoublelefticon")
//	public WebElement e_navigate_firstPageButton;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link p-disabled']//child::anglerighticon")
//	public WebElement navigate_previousPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link p-disabled']")
//	public WebElement navigate_previousPageButton;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link']//child::anglelefticon")
//	public WebElement e_navigate_previousPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link']")
//	public WebElement e_navigate_previousPageButton;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link p-disabled']//child::anglerighticon")
//	public WebElement navigate_nextPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link p-disabled']")
//	public WebElement navigate_nextPageButton;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link']//child::anglerighticon")
//	public WebElement e_navigate_nextPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link']")
//	public WebElement e_navigate_nextPageButton;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link p-disabled ng-star-inserted']")
//	public WebElement navigate_lastPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link p-disabled ng-star-inserted']//child::angledoublerighticon")
//	public WebElement navigate_lastPageButton;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link ng-star-inserted']")
//	public WebElement e_navigate_lastPageButton_enabledOrDesabled;
//
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link ng-star-inserted']//child::angledoublerighticon")
//	public WebElement e_navigate_lastPageButton;

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

	@FindBy(xpath = "//div[@class='p-paginator-first pr-0 p-paginator p-component ng-star-inserted']/button")
	public List<WebElement> paginationsAllButtons;

	@FindBy(xpath = "")
	public WebElement qa;

//CONSTRUCTOR..........

	public TransactionHistoryPOM(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

//METHODS...............

//1.module and tab click methods..........

	public void click_reportsModule() {
		scrollUp(driver);
		waitForElementToAppear(reportsModule, driver, logger);
//		scrollToWebElement(reportsModule, driver);
		logger.log(LogStatus.INFO, "click_reportsModule");
		click(reportsModule, driver, logger);

	}

	public void click_txnHistoryModule() {
//		scrollUp(driver);
		waitForElementToAppear(txnHistoryModule, driver, logger);
		scrollToWebElement(txnHistoryModule, driver);
		logger.log(LogStatus.INFO, "click_txnHistoryModule");
		click(txnHistoryModule, driver, logger);

	}

	public void click_allTxnReportTab() {
		scrollUp(driver);
		waitForElementToAppear(allTxnReportTab, driver, logger);
//		scrollToWebElement(allTxnReportTab, driver);
		logger.log(LogStatus.INFO, "click_allTxnReportTab");
		click(allTxnReportTab, driver, logger);

	}

	public void click_telecomTab() {
		scrollUp(driver);
		waitForElementToAppear(telecomTab, driver, logger);
//		scrollToWebElement(telecomTab, driver);
		logger.log(LogStatus.INFO, "click_telecomTab");
		click(telecomTab, driver, logger);

	}

	public void click_dmtTab() {
		scrollUp(driver);
		waitForElementToAppear(dmtTab, driver, logger);
//		scrollToWebElement(dmtTab, driver);
		logger.log(LogStatus.INFO, "click_dmtTab");
		click(dmtTab, driver, logger);

	}

	public void click_bbpsTab() {
		scrollUp(driver);
		waitForElementToAppear(bbpsTab, driver, logger);
//		scrollToWebElement(bbpsTab, driver);
		logger.log(LogStatus.INFO, "click_bbpsTab");
		click(bbpsTab, driver, logger);

	}

	public void click_aepsTab() {
		scrollUp(driver);
		waitForElementToAppear(aepsTab, driver, logger);
//		scrollToWebElement(aepsTab, driver);
		logger.log(LogStatus.INFO, "click_aepsTab");
		click(aepsTab, driver, logger);

	}

	public void click_microAtmTab() {
		scrollUp(driver);
		waitForElementToAppear(microAtmTab, driver, logger);
//		scrollToWebElement(microAtmTab, driver);
		logger.log(LogStatus.INFO, "click_microAtmTab");
		click(microAtmTab, driver, logger);

	}

	public void click_exportFileIcon() {
		scrollUp(driver);
		waitForElementToAppear(exportFileIcon, driver, logger);
		scrollToWebElement(exportFileIcon, driver);
		logger.log(LogStatus.INFO, "click_telecomTab");
		click(exportFileIcon, driver, logger);

	}

	public void click_searchButton() {
		waitForElementToAppear(searchButton, driver, logger);
		scrollToWebElement(searchButton, driver);
		logger.log(LogStatus.INFO, "click_searchButton");
		click(searchButton, driver, logger);

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

//2.PAGE TOP elements methods...................

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

	public void selectFromDate2Auto() throws InterruptedException {

		logger.log(LogStatus.INFO, "click from calendar icon");
		Thread.sleep(2000);
		click(fromCalenderIcon, driver, logger);
		String calendarDateValue = null;

		String month = fromMonth.getText();
		String year = fromYear.getText();

		for (int aa = 0; aa <= 34; aa++) {

			WebElement calendarDateValueAAA = datesOfFromCalender.get(aa);
			if (calendarDateValueAAA.isEnabled()) {
				calendarDateValue = calendarDateValueAAA.getText();
				System.out.println("Enabled Date -" + calendarDateValue + "-" + month + "-" + year);

			} else {

				System.out.println("Disabled Date -" + calendarDateValue + "-" + month + "-" + year);

			}

		}

	}

	public void selectFromDate2(int date, String monthString, int year) {

		logger.log(LogStatus.INFO, "selecting a date from date calendar");

		String stringDate = Integer.toString(date);
		String stringYear = Integer.toString(year);

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
		scrollToWebElement(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "selecting from month and from year");

		String calendarMonth = fromMonth.getText();
		String calendarYear = fromYear.getText();

		while (!(calendarMonth.equals(monthString) && calendarYear.equals(stringYear))) {
			waitForElementToAppear(fromCalenderPreviousButton, driver, logger);
			click(fromCalenderPreviousButton, driver, logger);
			calendarMonth = fromMonth.getText();
			calendarYear = fromYear.getText();
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
		logger.log(LogStatus.INFO, "selected from date-" + calendarDateValue + "\nselected from month -" + calendarMonth
				+ "\nselected from year -" + calendarYear);

	}

	public void selectToDate2(int date, String monthString, int year) throws InterruptedException {

		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "selecting a date from to calendar");

		String stringDate = Integer.toString(date);
		String stringYear = Integer.toString(year);

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
		scrollToWebElement(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);

		logger.log(LogStatus.INFO, "selecting to month and to year");

		String calendarMonth = toMonth.getText();
		String calendarYear = toYear.getText();

		while (!(calendarMonth.equals(monthString) && calendarYear.equals(stringYear))) {
			waitForElementToAppear(toCalenderPreviousButton, driver, logger);
			click(toCalenderPreviousButton, driver, logger);
			calendarMonth = toMonth.getText();
			calendarYear = toYear.getText();
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
		logger.log(LogStatus.INFO, "selected to date-" + calendarDateValue + "\nselected to month -" + calendarMonth
				+ "\nselected to year -" + calendarYear);

	}

	public void validate_pageTitle(String stepName, String actualPageTitle, String expectedPageTitle) {
		compareString(expectedPageTitle, actualPageTitle, true);
		softAssert(stepName, expectedPageTitle, actualPageTitle, true, logger);
		hardAssert(stepName, expectedPageTitle, actualPageTitle, true, logger);
	}

	
	public Boolean isCategoryDropdownDisplayed() {

		//approach 1...with common method.......		
		
		
//		waitForPageLoaded(driver, logger);
//
//	    	logger.log(LogStatus.INFO,"checking category dropdown is displayed or not");
//		  Boolean catDropDisp = isPresentAndDisplayed(categoryDropdown, driver, logger);
//
//		  return catDropDisp;
//		
		
//approach 2..........		
		Boolean catDropDisp;
		
		System.out.println("checking category tab is displayed or not");
		logger.log(LogStatus.INFO,"checking category tab is displayed or not");
	  
		try {
		catDropDisp = isPresentAndDisplayed(categoryTab, driver, logger);
		highlightElement(categoryTab);
		
	  if(catDropDisp) {
		  
			System.out.println("category tab is displayed");
			logger.log(LogStatus.INFO,"category tab is displayed");
			catDropDisp=true;
	  }
	  else {
		  
			System.out.println("category tab is not displayed");
			logger.log(LogStatus.INFO,"category tab is not displayed");
			catDropDisp=false;
	  }
		}
		catch (NoSuchElementException e) {
			
			System.out.println("category dropdown is not displayed");
			System.out.println("NoSuchElementException -"+e);

			logger.log(LogStatus.INFO,"category dropdown is not displayed");
			catDropDisp=false;		
			}
		
	  return catDropDisp;
	  
		
	}
	
	
	
	
	
	
	public void changeDateIfTableHasNoData() throws InterruptedException {

		Boolean datainTable = validateALLTxnReportTableHasData();

//	if(!datainTable) 
//	{
//		System.out.println("Table has NO data");
//	
//	}
//	else
//	{
//	
//		System.out.println("Table has data");	
//		
//	}

		click(fromCalenderIcon, driver, logger);
		System.out.println("clicked from cal icon");
		Thread.sleep(2000);

		System.out.println("fromCalender_Date_Today-" + fromCalender_Date_Today.getText());
		System.out.println("fromCalender_Date_enabled_Highlited-" + fromCalender_Date_enabled_Highlited.getText());
		System.out.println(
				"fromCalender_Dates_enabled_notHighlited-" + fromCalender_Dates_enabled_notHighlited.get(1).getText());
		System.out.println("fromCalender_Dates_disabled-" + fromCalender_Dates_disabled.get(1).getText());

	}

//3.ALL TRANSACTION TABLE methods-------------------------------------------------------------	

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

	public int getTxnTable_rowNumbers() throws InterruptedException {
		Thread.sleep(5000);
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

	public void validate_noOfPagesAccordingToPageSize() throws InterruptedException {
//
//		int pages = getPageNumbersCountDisplayedAtPageBottom();
//		int pageSize = getCurentPageDataSize();
//
//		// find first and last number of record according to TABLE DATA..........
//		
//		WebElement ElementFirstNo = driver.findElement(By.xpath(
//				"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
//						+ 1 + "]/td[1]"));
//		String firstNumFromTable = ElementFirstNo.getText();
//
//		int tableRows = getTxnTable_rowNumbers();
//		WebElement ElementLastNo = driver.findElement(By.xpath(
//				"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
//						+ tableRows + "]/td[1]"));
//		String lastNumFromtable = ElementLastNo.getText();
//
////			 find first and last number of record according to PAGE BOTTOM MESSAGE.............
//
//		String msgAtPageBottom = getPage_paginationDataCountingMsg();
//		String[] splittedMsg = msgAtPageBottom.split(" ");
//
//		String firstNum = null;
//		String lastNum = null;
//		String totalTxns = null;
//
//		for (int a = 0; a <= (splittedMsg.length - 1); a++) {
//			if (a == 0 || a == 2 || a == 4 || a == 6) {
//				continue;
//			} else {
//				if (a == 1) {
//					firstNum = splittedMsg[a];
//				} else if (a == 3) {
//					lastNum = splittedMsg[a];
//				} else if (a == 5) {
//					totalTxns = splittedMsg[a];
//				}
//			}
//		}
//		System.out.println("1 st no.from table -" + firstNumFromTable + "\n1 st no.in message - " + firstNum);
//		System.out.println("last no.from table -" + lastNumFromtable + "\nlast no.in message - " + lastNum);
//		System.out.println("total in message - " + totalTxns);
//
//	   Boolean dataInTable	= validateALLTxnReportTableHasData();
//		if(dataInTable) 
//		{
//			
//			
//		}
//		
		int paginationButtons = paginationsAllButtons.size();

		System.out.println("pagination buttons numbers -" + paginationButtons);

		for (int a = 0; a < paginationButtons; a++) {

			Boolean buttinActive = paginationsAllButtons.get(a).isEnabled();

			if (buttinActive) {

			} else {

			}

		}

	}

	// ok=====method
	public boolean validateALLTxnReportTableHasData() {

		int recordsInFirstRow = getTxnTable_ONErowData();

		Boolean tableHasData;

		if (recordsInFirstRow > 0) {

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
					"validateMoreInfoOfTxn is failed.\nTABLE -> No Records Found.\nThe \"All Transactions Report\" tableHasData has no data");

		}
	}

	public void validate_pageSizeSelectedAndDataPerPageFetched() throws IOException, InterruptedException {

		waitForPageLoaded(driver, logger);
		Boolean dataInTable = validateALLTxnReportTableHasData();

// if table has data		
		if (dataInTable) {

			scrollToWebElement(pageSizeDropdown, driver);
			// table data count
			int tableDataCount = getTxnTable_rowNumbers();
			// page size selected
			int pageDataSizeSelected = getCurentPageDataSize();

			// 1a-yes => check - table has data - data is less or more than page size
			// selected
			if (tableDataCount >= pageDataSizeSelected) {
				System.out.println("table data >= page size selected.\nTable data=" + tableDataCount
						+ "\npage size selected=" + pageDataSizeSelected);

				logger.log(LogStatus.INFO, "table data >= page size selected");

				softAssert("STEP - Validate 'data per page' is fetched according to the 'page size' selected",
						String.valueOf(tableDataCount), String.valueOf(pageDataSizeSelected), true, logger);

			} else {

				// table data count
				int dataCount_lessThanPageSizeSelected = (tableDataCount % pageDataSizeSelected);

				System.out.println("table data < page size selected.\nTable data=" + tableDataCount
						+ "\npage size selected=" + pageDataSizeSelected);

				logger.log(LogStatus.INFO, "table data < page size selected.\nTable data nos.-"
						+ dataCount_lessThanPageSizeSelected + "\nPage size nos.-" + pageDataSizeSelected);

			}
		} else
// if table has no data
		{
			System.out.println("no data in table....");
			logger.log(LogStatus.INFO, "no data in table.... ");
		}

	}

	public void validate_tableDataAndTextMessage() throws IOException, InterruptedException {
		// 1.check - table has data or not

		waitForPageLoaded(driver, logger);
		Boolean dataInTable = validateALLTxnReportTableHasData();

//1a. if table has data
		if (dataInTable) {

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

			String msgAtPageBottom = getPage_paginationDataCountingMsg();
			System.out.println("msgAtPageBottom -" + msgAtPageBottom);
			String[] splittedMsg = msgAtPageBottom.split(" ");// the index number of the numbers must be same (should
																// not change)

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

			logger.log(LogStatus.INFO,
					"1 st no.from table -" + firstNumFromTable + "\n1 st no.in message - " + firstNum
							+ "last no.from table -" + lastNumFromtable + "\nlast no.in message - " + lastNum
							+ "total in message -" + totalTxns);

			System.out.println("1 st no.from table -" + firstNumFromTable + "\n1 st no.in message - " + firstNum);
			System.out.println("last no.from table -" + lastNumFromtable + "\nlast no.in message - " + lastNum);
			System.out.println("total in message - " + totalTxns);

			softAssert("validate-first number of record according to PAGE BOTTOM MESSAGE\n", firstNum,
					firstNumFromTable, true, logger);
			softAssert("validate-last number of record according to PAGE BOTTOM MESSAGE\n", lastNum, lastNumFromtable,
					true, logger);

		} else
// 1b-if table has no data =>
		{
//			System.out.println("1st no.in message - " + firstNum);
//			System.out.println("last no.in message - " + lastNum);
//			System.out.println("total in message - " + totalTxns);

			System.out.println("validation_tableDataAndTextMessage-----------no data in table....");

			logger.log(LogStatus.INFO, "no data in table....");
			// logger.log(LogStatus.INFO, "1st no.in message - " + firstNum+"\blast no.in
			// message - " + lastNum+"\btotal in message - " + totalTxns);

		}
	}

//4.PAGINATION (PAGE BOTTOM) methods........................

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

	public int getPageNumbersCountDisplayedAtPageBottom() {
		// 1.check - table has data or not

		waitForPageLoaded(driver, logger);
		Boolean dataInTable = validateALLTxnReportTableHasData();

		waitForElementToAppear(paginationWebElement, driver, logger);
		scrollToWebElement(paginationWebElement, driver);

		if (dataInTable) {
			int pageNumbersCount = pageNumbersCountDisplayedAtPageBottom.size();
			return pageNumbersCount;
		} else
		// 1b-no =>
		{
			System.out.println("no data in table....");
			logger.log(LogStatus.INFO, "no data in table.... ");
		}
		return 0;
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
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
		scrollToWebElement(paginationWebElement, driver);

//FIRST PAGE button is at ZERO index, so passing static value = 0			
			WebElement firstPageIconElement = paginationsAllButtons.get(0);
			Boolean buttonEnabled = firstPageIconElement.isEnabled();
			
			logger.log(LogStatus.INFO, "click first page button");

			if (buttonEnabled) {
				System.out.println("click first page button");
				click(firstPageIconElement, driver, logger);
			} else {
				logger.log(LogStatus.INFO, "first page button is DISABLED");
			}

		

	}

	public void click_navigate_previousPageButton() {
		
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
		scrollToWebElement(paginationWebElement, driver);

//PREVIOUS PAGE button is at ONE index, so passing static value = 1			
			WebElement prevPageIconElement = paginationsAllButtons.get(1);
			Boolean buttonEnabled = prevPageIconElement.isEnabled();

			logger.log(LogStatus.INFO, "click previous page button");

			if (buttonEnabled) {
				System.out.println("click previous page button");
				click(prevPageIconElement, driver, logger);
			} else {
				logger.log(LogStatus.INFO, "previous page button is DISABLED");
			}
	}

	public void click_navigate_nextPageButton() {

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
		scrollToWebElement(paginationWebElement, driver);

		//NEXT PAGE button is at TWO index, so passing static value = 2			
			WebElement nextPageIconElement = paginationsAllButtons.get(2);
			Boolean buttonEnabled = nextPageIconElement.isEnabled();

			logger.log(LogStatus.INFO, "click next page button");

			if (buttonEnabled) {
				System.out.println("click next page button");
				click(nextPageIconElement, driver, logger);
			} else {
				logger.log(LogStatus.INFO, "next page button is DISABLED");
			}
	}

	public void click_navigate_lastPageButton() {
		

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
		scrollToWebElement(paginationWebElement, driver);

//LAST PAGE button is at THREE index, so passing static value = 3			
			WebElement lastPageIconElement = paginationsAllButtons.get(3);
			Boolean buttonEnabled = lastPageIconElement.isEnabled();

			logger.log(LogStatus.INFO, "click last page button");

			if (buttonEnabled) {
				System.out.println("click last page button");
				click(lastPageIconElement, driver, logger);
			} else {
				logger.log(LogStatus.INFO, "last page button is DISABLED");
			}

		
//previous logic to click pagination buttons------------------		
//		waitForPageLoaded(driver, logger);
//		waitForElementToAppear(e_navigate_lastPageButton, driver, logger);
//		logger.log(LogStatus.INFO, "scroll to last page button");
//		scrollToWebElement(e_navigate_lastPageButton, driver);
//
//		try {
//			logger.log(LogStatus.INFO, "Click on LAST page icon");
//
//			System.out.println("last button is enabled -" + e_navigate_lastPageButton.isEnabled());
//			System.out.println("last button is displayed -" + e_navigate_lastPageButton.isDisplayed());
//			System.out.println("last button is selected -" + e_navigate_lastPageButton.isSelected());
//
//			click(e_navigate_lastPageButton, driver, logger);
//		} catch (Exception e) {
//			logger.log(LogStatus.ERROR, e);
//			logger.log(LogStatus.INFO, "navigate_lastPageButton is disabled. You are at last page.");
//
		

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

		String currentPageDatSize;

		// for loop will fetch all options available in dropdown
		for (int a = 0; a <= (pageSizeDropdownListNumbers - 1); a++) {
			System.out.println("pageSizeDropdownListNumbers  in loop -" + pageSizeDropdownListNumbers);
			// select data size option 1 (according to index no.)
			scrollToWebElement(pageSizeDropdown, driver);
			waitForElementToAppear(perPageDataOptions.get(a), driver, logger);
			scrollToWebElement(perPageDataOptions.get(a), driver);
//to log data size option 1 (according to index no.)
			currentPageDatSize = perPageDataOptions.get(a).getText();
			logger.log(LogStatus.INFO, "Selected data per page -" + currentPageDatSize);
//click data size option 1 (according to index no.) 
			click(perPageDataOptions.get(a), driver, logger);
			System.out.println("selected page size  -" + perPageDataOptions.get(a).getText());
// m1...
			validate_pageSizeSelectedAndDataPerPageFetched();
//m2...			
			validate_tableDataAndTextMessage();
//wait for table loading after changing the data numbers displayed on page
			waitForPageLoaded(driver, logger);
			scrollToWebElement(pageSizeDropdown, driver);
			// click page size dropdown to get data size OPTIONS for second loop (if
			// dropdown is close the loop
			click_pageSizeDropdown();
			// scroll to next page size as we will click on next page size in next ITERATION
			scrollToWebElement(perPageDataOptions.get(a), driver);

		}

	}

//methods to reconsider...............	

	public void get_calenderAndDropdownCommonTabList_allTabs() {

		int listNos = calenderAndDropdown_CommonTabList_allTabs.size();

		System.out.println("list ize is -" + listNos);

		for (int a = 0; a <= (listNos - 1); a++) {

			String listName = calenderAndDropdown_CommonTabList_allTabs.get(a).getText();

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


	public void aaagetLastWE() {
		System.out.println("last is displayed-");
		System.out.println("last is enabled-");
	}

}

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
import groovyjarjarpicocli.CommandLine.Help.Column;
//import net.bytebuddy.agent.builder.AgentBuilder.Default.BootstrapInjectionStrategy.Enabled;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class TransactionHistoryPOM extends commonFunc {

	public static boolean result;

	public WebDriver driver;
	public ExtentTest logger;
	public WebElement Element;

	@FindBy(xpath = "//div[@class='app-content my-3 my-md-0']")
	public WebElement page;

	@FindBy(xpath = "//span[text()='Reports']")
	public WebElement reportsModule;

	@FindBy(xpath = "//a[@class='slide-item'] [text()=' Transaction History']")
	public WebElement txnHistoryModule;

//Page TOP elements #####################################################################################################################

	// from calendar ##################

//from set 1---46-10	
	@FindBy(xpath = "//calendaricon[@class='p-element p-icon-wrapper ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromCalenderIcon;
	@FindBy(xpath = "//button[@class='p-datepicker-month p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromMonth;
	@FindBy(xpath = "//button[@class='p-datepicker-year p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromYear;
	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement fromCalenderPreviousButton;
	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c46-10']")
	public WebElement fromCalenderNextButton;

//todays date
	// 18 sept 2024
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-10']/tbody/tr/td[@class='ng-tns-c46-10 p-datepicker-today ng-star-inserted']")
	public WebElement fromCalender_Date_Today;
// months all dates except todays
	// 18 sept 2024
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-10']/tbody/tr/td[@class='ng-tns-c46-10 ng-star-inserted']")
	public List<WebElement> fromCalender_Dates_currentMonthsAllDatedExceptToday;
//enabled - highlited date	
	// 18 sept 2024
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-10']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-10 p-highlight ng-star-inserted']")
	public WebElement fromCalender_Date_enabled_Highlited;
//enabled - other than highlited date	
	// 18 sept 2024
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-10']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-10 ng-star-inserted']")
	public List<WebElement> fromCalender_Dates_enabled_notHighlited;
//disabled and all dates from table
	// 18 sept 2024
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-10']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-10 p-disabled ng-star-inserted']")
	public List<WebElement> fromCalender_Dates_disabled_AllDisplayedInDropdown;

	// from set 2---46-14.........................
	// todays date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr/td[@class='ng-tns-c46-14 p-datepicker-today ng-star-inserted']")
//	public WebElement fromCalender_Date_Today;	
	// months all dates except todays
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr/td[@class='ng-tns-c46-14 ng-star-inserted']")
//	public List<WebElement> fromCalender_Dates_currentMonthsAllDatedExceptToday;
	// enabled - highlited date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-14 p-highlight ng-star-inserted']")
//	public WebElement fromCalender_Date_enabled_Highlited;
	// enabled - other than highlited date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-14 ng-star-inserted']")
//	public List<WebElement> fromCalender_Dates_enabled_notHighlited;
	// disabled and all dates from table
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-14']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-14 p-disabled ng-star-inserted']")
//	public List<WebElement> fromCalender_Dates_disabled_AllDisplayedInDropdown;

// to calendar #################################################

	// to set 1---46-11.............
	@FindBy(xpath = "//calendaricon[@class='p-element p-icon-wrapper ng-tns-c46-11 ng-star-inserted']")
	public WebElement toCalenderIcon;
	@FindBy(xpath = "//button[@class='p-datepicker-month p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toMonth;
	@FindBy(xpath = "//button[@class='p-datepicker-year p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toYear;
	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-11 ng-star-inserted']")
	public WebElement toCalenderPreviousButton;
	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c46-11']")
	public WebElement toCalenderNextButton;

	// to set 2---46-27......................
//	@FindBy(xpath = "//calendaricon[@class='p-element p-icon-wrapper ng-tns-c46-27 ng-star-inserted']")
//	public WebElement toCalenderIcon;
//	@FindBy(xpath = "//button[@class='p-datepicker-month p-link ng-tns-c46-27 ng-star-inserted']")
//	public WebElement toMonth;
//	@FindBy(xpath = "//button[@class='p-datepicker-year p-link ng-tns-c46-27 ng-star-inserted']")
//	public WebElement toYear;
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-27 ng-star-inserted']")
//	public WebElement toCalenderPreviousButton;
//	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c46-27']")
//	public WebElement toCalenderNextButton;
//	
	// --------------------------------------

	// to set 2---46-11......................

	// todays date
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-11']/tbody/tr/td[@class='ng-tns-c46-11 p-datepicker-today ng-star-inserted']")
	public WebElement toCalender_Date_Today;
	// months all dates except todays
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-11']/tbody/tr/td[@class='ng-tns-c46-11 ng-star-inserted']")
	public List<WebElement> toCalender_Dates_currentMonthsAllDatedExceptToday;
	// enabled - highlited date
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-11']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-11 p-highlight ng-star-inserted']")
	public WebElement toCalender_Date_enabled_Highlited;
	// enabled - other than highlited date
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-11']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-11 ng-star-inserted']")
	public List<WebElement> toCalender_Dates_enabled_notHighlited;
	// disabled and all dates from table
	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-11']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-11 p-disabled ng-star-inserted']")
	public List<WebElement> toCalender_Dates_disabled_AllDisplayedInDropdown;

	// to set 2---46-27......................

//	//todays date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-27']/tbody/tr/td[@class='ng-tns-c46-27 p-datepicker-today ng-star-inserted']")
//	public WebElement toCalender_Date_Today;
//	// months all dates except todays
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-27']/tbody/tr/td[@class='ng-tns-c46-27 ng-star-inserted']")
//	public List<WebElement> toCalender_Dates_currentMonthsAllDatedExceptToday;
//	// enabled - highlited date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-27']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-27 p-highlight ng-star-inserted']")
//	public WebElement toCalender_Date_enabled_Highlited;
//	// enabled - other than highlited date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-27']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-27 ng-star-inserted']")
//	public List<WebElement> toCalender_Dates_enabled_notHighlited;
//	// disabled and all dates from table
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-27']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-27 p-disabled ng-star-inserted']")
//	public List<WebElement> toCalender_Dates_disabled_AllDisplayedInDropdown;

	// to set 3---46-5.............................................

//	//todays date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr/td[@class='ng-tns-c46-5 p-datepicker-today ng-star-inserted']")
//	public WebElement toCalender_Date_Today;
//	// months all dates except todays
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr/td[@class='ng-tns-c46-5 ng-star-inserted']")
//	public List<WebElement> toCalender_Dates_currentMonthsAllDatedExceptToday;
//	// enabled - highlited date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-5 p-highlight ng-star-inserted']")
//	public WebElement toCalender_Date_enabled_Highlited;
//	// enabled - other than highlited date
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr/td/span[@class='p-ripple p-element ng-tns-c46-5 ng-star-inserted']")
//	public List<WebElement> toCalender_Dates_enabled_notHighlited;
//	// disabled and all dates from table
//	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-5']/tbody/tr[2]/td/span[@class='p-ripple p-element ng-tns-c46-5 p-disabled ng-star-inserted']")
//	public List<WebElement> toCalender_Dates_disabled;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-10']//tbody//span")
	public List<WebElement> datesOfFromCalender;

	@FindBy(xpath = "//table[@class='p-datepicker-calendar ng-tns-c46-11']//tbody//span")
	public List<WebElement> datesOfToCalender;

//dropdown #####################################################################################################################

	@FindBy(xpath = "//div[@class='col-xl-2 col-lg-2 col-md-4 col-sm-4 col-12']")
	public List<WebElement> calenderAndDropdown_CommonTabList_allTabs;

	@FindBy(xpath = "//div[@class='col-xl-2 col-lg-2 col-md-4 col-sm-4 col-12 ng-star-inserted']/div/p-dropdown")
	public WebElement categoryTab;

	@FindBy(xpath = "//div[@class='col-xl-2 col-lg-2 col-md-4 col-sm-4 col-12 ng-star-inserted']/lable")
	public WebElement categoryTab_lable;

	@FindBy(xpath = "//div[@class='p-dropdown-trigger'][1]")
	public WebElement categoryDropdown;

//	@FindBy(xpath = "//span[text()='Select Service']")
//	public WebElement serviceDropdown;

	@FindBy(xpath = "//span[text()='Select Service']/following-sibling::div")
	public WebElement serviceDropdown;

//	@FindBy(xpath = "//span[text()='Select Operator']")
//	public WebElement operatorDropdown;

	@FindBy(xpath = "//span[text()='Select Operator']/following-sibling::div")
	public WebElement operatorDropdown;

	// static data- 1st txn
	@FindBy(xpath = "//table[@id='pr_id_13-table']/tbody/tr[1]/td[3]/span[1]")
	public WebElement txn_service;
//static data- 1st txn
	@FindBy(xpath = "//table[@id='pr_id_13-table']/tbody/tr[1]/td[3]/span[2]")
	public WebElement txn_category;
	// static data- 1st txn
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

	@FindBy(xpath = "//div[@class='float-end c-pointer']")
	public WebElement exportEnabled;

	@FindBy(xpath = "//div[@class='float-end c-pointer pointer-events-none']")
	public WebElement exportDisabled;

	@FindBy(xpath = "//ul[@id='pr_id_18_list']//p-dropdownitem")
	public List<WebElement> categoryDropList;

	@FindBy(xpath = "//ul[@id='pr_id_11_list']//p-dropdownitem")
	public List<WebElement> serviceDropList;

	@FindBy(xpath = "//ul[@id='pr_id_12_list']/p-dropdownitem") // replace 12 by 29 for demo 21 operator list
	public List<WebElement> operatorDropList;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
	public WebElement operatorDropdownInputField;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchButton;

//Txn. Table #####################################################################################################################

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/thead/tr/th")
	public List<WebElement> txnTable_columnsHEAD;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr")
	public List<WebElement> txnTable_rows;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr/td")
	public List<WebElement> txnTable_allColumnsAllData;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr[1]/td")
	public List<WebElement> txnTable_columnsInFirstRow;

//More info. side menu bar #################################################################################################

//modify....static x path of 1st txn	
	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr[1]/td[10]/a/i")
	public WebElement txnMoreInfo_Icon;

	@FindBy(xpath = "//table[@class='table reportdata']/tbody/tr/td[1]")
	public List<WebElement> moreInfoTable_paramNameList;

	@FindBy(xpath = "//table[@class='table reportdata']/tbody/tr/td[2]")
	public List<WebElement> moreInfoTable_paramValueList;

	@FindBy(xpath = "//div[@class='offcanvas reportmodule offcanvas-end show']//child::h4")
	public WebElement moreInfo_textAtSideBarHeaderWE;

	// 1.dmt more info side bar =>pending,failed txn. has one button (close)
	// only...success txn. has 3 buttons (1-Single, 2-Bulk, 3-Close)
	// same xpath can be used for other tabs...list will have 1 button only
	@FindBy(xpath = "//div[@class='offcanvas reportmodule offcanvas-end show']//button")
	public List<WebElement> moreInfo_headersButtonsList_dmt;
//read above comment....	
	@FindBy(xpath = "//div[@class='offcanvas reportmodule offcanvas-end show']//button")
	public WebElement txnMoreInfo_Close;

	@FindBy(xpath = "//div[@id='offcanvasRight']")
	public WebElement moreinfoSideBar;

	@FindBy(xpath = "//div[@class='ng-star-inserted']/a")
	public WebElement printButton_moreInfoSideBar_aepsSuccessTxn;

	@FindBy(xpath = "//button[@class='btn btn-primary trigg-btn px-2 fs-13 c-pointer ng-star-inserted']")
	public WebElement raiseComplaintButton_moreInfoSideBar_bbpsPendingTxn;

//page bottom elements #################################################################################################

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
	public WebElement da;

	@FindBy(xpath = "")
	public WebElement sa;

	@FindBy(xpath = "")
	public WebElement aa;

	@FindBy(xpath = "")
	public WebElement aaaa;

//CONSTRUCTOR..........

	public TransactionHistoryPOM(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

//METHODS...............

//1.PAGE TOP elements methods START #####################################################################################################

	public void click_reportsModule() {
		scrollUp(driver);
		waitForElementToAppear(reportsModule, driver, logger);
//		scrollToWebElement(reportsModule, driver);
		logger.log(LogStatus.INFO, "click_reportsModule");
		click(reportsModule, driver, logger);

	}

	public void click_txnHistoryModule() {
		waitForElementToAppear(txnHistoryModule, driver, logger);
		scrollToWebElement(txnHistoryModule, driver);
		logger.log(LogStatus.INFO, "click_txnHistoryModule");
		click(txnHistoryModule, driver, logger);

	}

	public void click_allTxnReportTab() {
		scrollUp(driver);
		waitForElementToAppear(allTxnReportTab, driver, logger);
//		scrollToWebElement(allTxnReportTab, driver);
		logger.log(LogStatus.INFO, "click_allTxnReportTab--------");
		click(allTxnReportTab, driver, logger);

	}

	public void click_telecomTab() {
		scrollUp(driver);
		waitForElementToAppear(telecomTab, driver, logger);
//		scrollToWebElement(telecomTab, driver);
		logger.log(LogStatus.INFO, "click_telecomTab--------");
		click(telecomTab, driver, logger);

	}

	public void click_dmtTab() {
		scrollUp(driver);
		waitForElementToAppear(dmtTab, driver, logger);
//		scrollToWebElement(dmtTab, driver);
		logger.log(LogStatus.INFO, "click_dmtTab-------");
		click(dmtTab, driver, logger);

	}

	public void click_bbpsTab() {
		scrollUp(driver);
		waitForElementToAppear(bbpsTab, driver, logger);
//		scrollToWebElement(bbpsTab, driver);
		logger.log(LogStatus.INFO, "click_bbpsTab-------");
		click(bbpsTab, driver, logger);

	}

	public void click_aepsTab() {
		scrollUp(driver);
		waitForElementToAppear(aepsTab, driver, logger);
//		scrollToWebElement(aepsTab, driver);
		logger.log(LogStatus.INFO, "click_aepsTab-------");
		click(aepsTab, driver, logger);

	}

	public void click_microAtmTab() {
		scrollUp(driver);
		waitForElementToAppear(microAtmTab, driver, logger);
//		scrollToWebElement(microAtmTab, driver);
		logger.log(LogStatus.INFO, "click_microAtmTab-------------");
		click(microAtmTab, driver, logger);

	}

	public void click_exportFileIcon() {
		scrollUp(driver);
		waitForElementToAppear(exportFileIcon, driver, logger);
		scrollToWebElement(exportFileIcon, driver);
		logger.log(LogStatus.INFO, "click_exportFileIcon----------");
		click(exportFileIcon, driver, logger);

	}

	public void click_searchButton() throws InterruptedException {
		waitForElementToAppear(searchButton, driver, logger);
		scrollToWebElement(searchButton, driver);
		logger.log(LogStatus.INFO, "click_searchButton--------");
		click(searchButton, driver, logger);
		Thread.sleep(2000);

	}

//dropdowns ###############################

	public Boolean isCategoryTabDisplayed() {

		Boolean catTabDisp;
		logger.log(LogStatus.INFO, "checking category tab is displayed or not");
		try {
			catTabDisp = isPresentAndDisplayed(categoryTab, driver, logger);

			if (catTabDisp) {
				logger.log(LogStatus.INFO, "category tab is displayed");
				highlightElement(categoryTab, "Red", driver, logger);
				catTabDisp = true;
			} else {
				logger.log(LogStatus.INFO, "category tab is not displayed");
				catTabDisp = false;
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.INFO, "category tab element is not displayed");
			catTabDisp = false;
		}
		return catTabDisp;
	}

	public void click_categoryDropdown() throws InterruptedException {

		waitForElementToAppear(categoryDropdown, driver, logger);
		scrollToWebElement(categoryDropdown, driver);
		logger.log(LogStatus.INFO, "click category dropdown");
		click(categoryDropdown, driver, logger);

	}

	public void click_serviceDropdown() throws InterruptedException {

		waitForElementToAppear(serviceDropdown, driver, logger);
		scrollToWebElement(serviceDropdown, driver);
		logger.log(LogStatus.INFO, "click service dropdown");
		click(serviceDropdown, driver, logger);

	}

	public void click_operatorDropdown() throws InterruptedException {

		waitForElementToAppear(operatorDropdown, driver, logger);
		scrollToWebElement(operatorDropdown, driver);
		logger.log(LogStatus.INFO, "click operator dropdown");
		click(operatorDropdown, driver, logger);

	}

	public void selectCategoryFromDropdown(String categoryToSelect) {

		logger.log(LogStatus.INFO, "Selecting category from the dropdown.");

		for (WebElement categoryOne : categoryDropList) {

			String requiredCategory = categoryOne.getText().trim();

			if (requiredCategory.equalsIgnoreCase(categoryToSelect)) {
				logger.log(LogStatus.INFO, "click category -" + categoryOne.getText());
				click(categoryOne, driver, logger);
				break;
			} else 
			{
				logger.log(LogStatus.INFO, "category not found-" + categoryToSelect);
			}
		}
	}

	public void selectServiceFromDropdown(String serviceToSelect) {

		logger.log(LogStatus.INFO, "navigating through service dropdown ");

		for (WebElement serviceOne : serviceDropList) {
			String requiredService = serviceOne.getText().trim();

			if (requiredService.equalsIgnoreCase(serviceToSelect)) {
				logger.log(LogStatus.INFO, "click service -" + serviceOne.getText());
				click(serviceOne, driver, logger);
				break;
			} else {
				logger.log(LogStatus.INFO, "service not found-" + serviceToSelect);
			}
		}
	}

	public void selectOperatorFromDropdown(String operatorToSelect) throws InterruptedException {

		logger.log(LogStatus.INFO, "navigating through operator dropdown ");

		for (WebElement operatorOne : operatorDropList) {
			String requiredOperator = operatorOne.getText().trim();

			if (requiredOperator.equalsIgnoreCase(operatorToSelect)) {
				logger.log(LogStatus.INFO, "click operator -" + operatorOne.getText());
				click(operatorOne, driver, logger);
				break;
			} else {
				logger.log(LogStatus.INFO, "operator not found-" + operatorToSelect);
			}
		}
	}

// CALENDAR methods START #####################################################################################################

	public void selectFromDate2(String stringDate, String monthString, String stringYear) {

		logger.log(LogStatus.INFO, "selecting a date from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
//		scrollToWebElement(fromCalenderIcon, driver);
		scrollUp(driver);

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
		logger.log(LogStatus.INFO,
				"selected from date-" + calendarDateValue + "-" + calendarMonth + "-" + calendarYear);

	}

	public void selectToDate2(int date, String monthString, int year) throws InterruptedException {

		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "selecting a date from to calendar");

		String stringDate = Integer.toString(date);
		String stringYear = Integer.toString(year);

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
		scrollUp(driver);
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

//		logger.log(LogStatus.INFO, "selected to month -" + calenderMonth + "\nselected to year -" + calenderYear);
		logger.log(LogStatus.INFO, "selecting to date");

		String calendarDateValue = null;

		for (int aa = 1; aa <= 35; aa++) {
			calendarDateValue = datesOfToCalender.get(aa).getText();
			if (calendarDateValue.equals(stringDate)) {
				click(datesOfToCalender.get(aa), driver, logger);
				break;
			}

		}
		logger.log(LogStatus.INFO, "selected to date-" + calendarDateValue + "-" + calendarMonth + "-" + calendarYear);
	}

//in progress-----------------	
	public void dateTest() throws InterruptedException {

//		
//		logger.log(LogStatus.INFO, "click to calendar icon");
//		click(fromCalenderIcon, driver, logger);
//		
//		System.out.println("");
//		
//		
//		Thread.sleep(2000);
//
//		System.out.println("taday's date -"+fromCalender_Date_Today.getText());
//		
//		Thread.sleep(2000);
//		
//		System.out.println("enabled highlited date -"+fromCalender_Date_enabled_Highlited.getText());
//		Thread.sleep(2000);
//		
//
//            int	enabledDatesNo =	fromCalender_Dates_enabled_notHighlited.size();
//		
//            for(int a=0;a<=(enabledDatesNo-1);a++)
//            {
//            	
//            String enabledDateString=	fromCalender_Dates_enabled_notHighlited.get(a).getText();
//        		System.out.println("enabled dates CURRENT MONTH-"+enabledDateString);
//
//            	
//            }
//
//            Thread.sleep(2000);
//		
//            int	disabledDatesNo =	fromCalender_Dates_disabled_AllDisplayedInDropdown.size();
//    		
//            for(int a=0;a<=(disabledDatesNo-1);a++)
//            {
//            	
//            String disabledDateString=	fromCalender_Dates_disabled_AllDisplayedInDropdown.get(a).getText();
//        		System.out.println("disabled dates ALL-"+disabledDateString);	
//            }
//            
//    		System.out.println("current time inMill is -"+getCurrentDateAndTimeInMill());
//
//    		System.out.println("current time formatted is -"+getCurrentDateAndTimeInFormat());
//
//    		System.out.println("current date is -"+getCurrentDate());
//
//    		System.out.println("current month is -"+getCurrentMonth());
//
//    		System.out.println("current year is -"+getCurrentYear());
//
//            
		logger.log(LogStatus.INFO, "selecting a date from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
		scrollToWebElement(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "selecting from month and from year");

		String calendarMonth = fromMonth.getText();
		String calendarYear = fromYear.getText();
		String highlitedDate = fromCalender_Date_enabled_Highlited.getText();

		System.out.println("calendar current date -" + calendarMonth);
		System.out.println("calendar current month -" + calendarMonth);
		System.out.println("calendar current year -" + calendarMonth);

	}

	public String getFromCalendar_highlitedDate() {

		logger.log(LogStatus.INFO, "getting highlited date from FROM date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
//		scrollToWebElement(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing highlited_from date");

		String calendarHighlitedDate = fromCalender_Date_enabled_Highlited.getText();
		logger.log(LogStatus.INFO, "captured default from date is -" + calendarHighlitedDate);

		return calendarHighlitedDate;
	}

	public String getFromCalendar_todayDate() {

		logger.log(LogStatus.INFO, "getting today's date from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
//		scrollToWebElement(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing today's_from date");

		String calendarTodayDate = fromCalender_Date_Today.getText();
		logger.log(LogStatus.INFO, "captured today's date from calendar is -" + calendarTodayDate);

		return calendarTodayDate;
	}

	public String getFromCalendar_Month() {

		logger.log(LogStatus.INFO, "getting selected month from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
//		scrollToWebElement(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing default_from month");

		String calendarFromMonth = fromMonth.getText();
		logger.log(LogStatus.INFO, "captured from month is -" + calendarFromMonth);

		return calendarFromMonth;
	}

	public String getFromCalendar_Year() {

		logger.log(LogStatus.INFO, "getting selected year from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
//		scrollToWebElement(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing default_from year");

		String calendarFromYear = fromYear.getText();
		logger.log(LogStatus.INFO, "captured from year is -" + calendarFromYear);

		return calendarFromYear;

	}

	public String getToCalendar_highlitedDate() {

		logger.log(LogStatus.INFO, "getting highlited date from TO date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
//		scrollToWebElement(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing highlited_to date");

		String calendarHighlitedDate = toCalender_Date_enabled_Highlited.getText();
		logger.log(LogStatus.INFO, "captured default to date is -" + calendarHighlitedDate);

		return calendarHighlitedDate;
	}

	public String getToCalendar_todayDate() {

		logger.log(LogStatus.INFO, "getting today's date to date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
//		scrollToWebElement(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing today's_to date");

		String calendarTodayDate = toCalender_Date_Today.getText();
		logger.log(LogStatus.INFO, "captured today's date from calendar is -" + calendarTodayDate);

		return calendarTodayDate;
	}

	public String getToCalendar_Month() {

		logger.log(LogStatus.INFO, "getting selected month to date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
//		scrollToWebElement(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing default_to month");

		String calendarToMonth = toMonth.getText();
		logger.log(LogStatus.INFO, "captured from month is -" + calendarToMonth);

		return calendarToMonth;
	}

	public String getToCalendar_Year() {

		logger.log(LogStatus.INFO, "getting selected year to date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
//		scrollToWebElement(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing default_to year");

		String calendarToYear = toYear.getText();
		logger.log(LogStatus.INFO, "captured from year is -" + calendarToYear);

		return calendarToYear;

	}

//incomplete
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

	// incomplete----------------
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
//		System.out.println("fromCalender_Dates_disabled-" + fromCalender_Dates_disabled.get(1).getText());

	}

// CALENDAR methods END #####################################################################################################

//3.ALL TRANSACTION TABLE methods START ##################################################################################

	public int getTxnTable_columnNumbersHEAD() {
		waitForPageLoaded(driver, logger);
		return txnTable_columnsHEAD.size();
	}

//we calculate number of columns in first row...if col=1 (table has no data)...	
	public int getTxnTable_columnsInFirstRow() {
		waitForPageLoaded(driver, logger);
		return txnTable_columnsInFirstRow.size();
	}

	public int getTxnTable_rowNumbers() throws InterruptedException {
		Thread.sleep(5000);
		waitForPageLoaded(driver, logger);
		return txnTable_rows.size();

	}

//incomplete..............	
	public void getTxnStatus() {

		Boolean dataInTable = validateALLTxnReportTableHasData();

		if (dataInTable) 
		{
			logger.log(LogStatus.INFO, "Getting transaction status");

			// columns in the table
			int totalColumns = getTxnTable_columnNumbersHEAD();

			for (int colWE = 0; colWE <= (totalColumns - 1); colWE++) {

				//get Column names
				String colName = txnTable_columnsHEAD.get(colWE).getText().trim();
				

				if (colName.equalsIgnoreCase("Status")) 
				{
					// here colWE has the INDEX no. of the status column...we can pass the static
					// number as we know the column number

					// navigate through each row
					int tableRowsIndex = txnTable_rows.size() - 1;

					for (int tableRows = 0; tableRows <= tableRowsIndex; tableRows++) {

						// enter td/column number gaving column name as 'Status' i.e.

						WebElement txnStatus = driver.findElement(By.xpath(
								"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
										+ tableRows + "]/td[" + colWE + "]"));
						String aString = txnStatus.getText().trim();
						System.out.println("status =" + aString);

					} // span

					// return aa;

				}

			}

		} else {
			logger.log(LogStatus.INFO, "Telecom table has no data");

		}

	}

	public boolean validateALLTxnReportTableHasData() {

	      waitForPageLoaded(driver, logger);
		int tableColumnsInFirstRow = txnTable_columnsInFirstRow.size();

		Boolean tableHasData;

		if (tableColumnsInFirstRow > 1) {

			logger.log(LogStatus.INFO, "Table has data");
			tableHasData = true;

		} else {

			logger.log(LogStatus.INFO, "Table has no data");
			tableHasData = false;
		}

		return tableHasData;
	}

	public String getTxnTable_messageIfNoTableData() {

		logger.log(LogStatus.INFO, "Capturing message displayed if table has no data.");
		int columnsNumbersInFirstRow = getTxnTable_columnsInFirstRow();

		String txnTableFirstRowFirstCol_Text = null;
		if (columnsNumbersInFirstRow == 1) {
			txnTableFirstRowFirstCol_Text = txnTable_columnsInFirstRow.get(0).getText();
			logger.log(LogStatus.INFO, "Message displayed if table has no data is -" + txnTableFirstRowFirstCol_Text);
		}
		return txnTableFirstRowFirstCol_Text;
	}

	public String getTxnService(int rowNum) {
		WebElement txn_service = driver
				.findElement(By.xpath("//table[@id='pr_id_13-table']/tbody/tr[" + rowNum + "]/td[3]/span[1]"));
		String serviceOfTxn = txn_service.getText();
		return serviceOfTxn;
	}

	public String getTxnCategory(int rowNum) {
		WebElement txn_category = driver
				.findElement(By.xpath("//table[@id='pr_id_13-table']/tbody/tr[" + rowNum + "]/td[3]/span[2]"));
		String categoryOfTxn = txn_category.getText();
		return categoryOfTxn;
	}

	public String getTxnOperator(int rowNum) {
		WebElement txn_operator = driver
				.findElement(By.xpath("//table[@id='pr_id_13-table']/tbody/tr[" + rowNum + "]/td[3]/span[3]"));
		String operatorOfTxn = txn_operator.getText();
		return operatorOfTxn;
	}

//3.ALL TRANSACTION TABLE methods END ##################################################################################

//4.MORE INFO side bar methods START ##################################################################################

	public void OpenMoreInfoOfTxnPopup(int txnNo) throws InterruptedException {

		logger.log(LogStatus.INFO, "Open 'More info.' side bar of the transaction");

		Boolean tableHasData = validateALLTxnReportTableHasData();
		if (tableHasData) {
			int colNos = getTxnTable_columnNumbersHEAD(); // last column has 'more info (meatball)' icon so last column
															// number should be used

			WebElement moreInfoIcon = driver.findElement(By.xpath(
					"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
							+ txnNo + "]/td[" + colNos + "]/a/i"));

			waitForPageLoaded(driver, logger);
			waitToBeClickable(moreInfoIcon, driver);
			scrollToWebElement(moreInfoIcon, driver);
			logger.log(LogStatus.INFO, "Click more info (meatball) icon OPEN");
			click(moreInfoIcon, driver, logger);
			Thread.sleep(2000);
		} else {
			logger.log(LogStatus.INFO,
					"Unable to open 'More info.' side bar.</br>'All Transactions Report' table has no data");
		}
	}

	public void click_close_lastButton_moreInfoSideBar() throws InterruptedException {

//logic if more info has ONE button only i.e. close-----------------OLD LOGIC----------------------------------
//		
//		Boolean moreInfoPopupOpen = isMoreInfoOfTxnPopup_Appeared(dataNum);
//		if (moreInfoPopupOpen) {
//			logger.log(LogStatus.INFO, "17--------------------");
//
//			waitForElementToAppear(txnMoreInfo_Close, driver, logger);
//			logger.log(LogStatus.INFO, "18--------------------");
//
//		logger.log(LogStatus.INFO, "Click on 'X' to close more info. popup of a transaction no. -" + dataNum);
//
//		try {
//		
//			Boolean xisPresent = isPresentAndDisplayed(txnMoreInfo_Close, driver, logger);
//	
//			if(xisPresent) 
//		{	
//			logger.log(LogStatus.INFO, "Click on 'X' to close more info. popup of a transaction no. -" + dataNum);
//			click(txnMoreInfo_Close, driver, logger);
//
//		}
//		else 
//		{
//			logger.log(LogStatus.INFO, "Txn. more info close 'X' button is not displayed of Txn. number -" + dataNum);
//		}
//		} catch (Exception e) 
//		{
//			logger.log(LogStatus.INFO, "Txn.. more info close 'X' button is not displayed of Txn. number -" + dataNum);
//		}

// new logic ........

		int moreInfoHeaderButtonsNo = moreInfo_headersButtonsList_dmt.size();

		int moreInfoHeaderLastButtonIndex = (moreInfoHeaderButtonsNo - 1);

		try {
			for (int a = 0; a <= moreInfoHeaderLastButtonIndex; a++) {

				// if buttons list is 1 => then enter this if condition and click this button (1
				// button must be the CLOSE button)
				if (moreInfoHeaderButtonsNo == 1) {
					logger.log(LogStatus.INFO, "More Info side bar has ONE button only");
					logger.log(LogStatus.INFO, "Click close / 'X' button");

					WebElement requiredButton_close = moreInfo_headersButtonsList_dmt.get(a);
					click(requiredButton_close, driver, logger);
				}
				// if buttons list is greater than one =>
				else {
					logger.log(LogStatus.INFO, "More Info side bar has MORE buttons ");
					// ASSUMPTION / CONDITION - close button must be LAST button.........
					// passing STATIC last index no as 'moreInfoHeaderLastButton'
					WebElement requiredButton_LAST = moreInfo_headersButtonsList_dmt.get(moreInfoHeaderLastButtonIndex);
					logger.log(LogStatus.INFO, "Click close / 'X' (Last) button");
					click(requiredButton_LAST, driver, logger);
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Failed to click the close button from more info side bar.");
			logger.log(LogStatus.INFO, "Captured exception is -" + e);
		}
	}

	public void click_firstButton_moreInfoSideBar() throws InterruptedException {

		int moreInfoHeaderButtonsNo = moreInfo_headersButtonsList_dmt.size();

		int moreInfoHeaderLastButtonIndex = (moreInfoHeaderButtonsNo - 1);

		String firstButtoNname = null;
		try {

			if (moreInfoHeaderButtonsNo > 1) {

				for (int a = 0; a <= moreInfoHeaderLastButtonIndex; a++) {

					logger.log(LogStatus.INFO, "More Info side bar has MORE buttons ");
					// get first button name to LOG in REPORT
					firstButtoNname = moreInfo_headersButtonsList_dmt.get(0).getText().trim();
					logger.log(LogStatus.INFO, "First button name is -" + firstButtoNname);
					// passing static index no 0...to get FIRST button only
					WebElement requiredButton_ONE = moreInfo_headersButtonsList_dmt.get(0);
					logger.log(LogStatus.INFO, "Click FIRST button");
					click(requiredButton_ONE, driver, logger);
				}
			} else {
				logger.log(LogStatus.INFO, "Click first button FAILED...button is unavailable");

			}

		} catch (Exception e) {
			logger.log(LogStatus.INFO,
					"Failed to click the FIRST button from more info side bar.</br>First button name is -"
							+ firstButtoNname);
			logger.log(LogStatus.INFO, "Captured exception is -" + e);
		}

	}

	public void click_secondButton_moreInfoSideBar() throws InterruptedException {

		int moreInfoHeaderButtonsNo = moreInfo_headersButtonsList_dmt.size();

		int moreInfoHeaderLastButtonIndex = (moreInfoHeaderButtonsNo - 1);

		String secondButtoNname = null;

		try {

			if (moreInfoHeaderButtonsNo > 1) {
				for (int a = 0; a <= moreInfoHeaderLastButtonIndex; a++) {

					logger.log(LogStatus.INFO, "More Info side bar has MORE buttons ");
					// get second button name to LOG in REPORT
					secondButtoNname = moreInfo_headersButtonsList_dmt.get(1).getText().trim();
					logger.log(LogStatus.INFO, "First button name is -" + secondButtoNname);

					// passing static index no 1...to get SECOND button only
					WebElement requiredButton_TWO = moreInfo_headersButtonsList_dmt.get(1);
					logger.log(LogStatus.INFO, "Click SECOND button name -" + secondButtoNname);
					click(requiredButton_TWO, driver, logger);
				}
			} else {
				logger.log(LogStatus.INFO, "Click second button FAILED...button is unavailable ");

			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO,
					"Failed to click the SECOND button from more info side bar.</br>Second button name is -"
							+ secondButtoNname);
			logger.log(LogStatus.INFO, "Captured exception is -" + e);
		}

	}

	public Boolean moreInfo_headerHasOneButton() {

		logger.log(LogStatus.INFO, "Validating - more info side bar has ONE button only");

		int moreInfoHeaderButtonsCount = moreInfo_headersButtonsList_dmt.size();
		Boolean headerHasOneButton;

		if (moreInfoHeaderButtonsCount == 1) {
			logger.log(LogStatus.INFO, "More Info side bar has ONE button only");
			headerHasOneButton = true;
		} else {
			logger.log(LogStatus.INFO, "More Info side bar has MORE buttons (Not One)");
			headerHasOneButton = false;
		}
		return headerHasOneButton;
	}

	public Boolean isMoreInfoSideBarDisplayed() throws InterruptedException {

		Boolean isMoreInfoSideBarDisplayed;

		Boolean moreInfoSideMenuIsOpen = isPresentAndDisplayed(moreinfoSideBar, driver, logger);
		Thread.sleep(1000);

		if (moreInfoSideMenuIsOpen) {
			logger.log(LogStatus.INFO, "More Info side bar is displayed/open.");
			highlightElement(moreinfoSideBar, "Red", driver, logger);
			isMoreInfoSideBarDisplayed = true;
		} else {
			logger.log(LogStatus.INFO, "More Info side bar is not displayed/open.");
			isMoreInfoSideBarDisplayed = false;
		}

		return isMoreInfoSideBarDisplayed;
	}

	// i think no use of this method
//	public Boolean isMoreInfoOfTxnPopup_Displayed(int txnNo) throws InterruptedException {
//
//		Boolean tableHasData = validateALLTxnReportTableHasData();
//		Boolean flag;
//
//		if (tableHasData) {
//
//			int colNos = getTxnTable_columnNumbersHEAD(); // last column has 'more info (meatball)' icon so last column
//															// number should be used
////if side menu is open this (...) web element is not found
//			WebElement moreInfoIcon = driver.findElement(By.xpath(
//					"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
//							+ txnNo + "]/td[" + colNos + "]/a/i"));
//
//			waitForPageLoaded(driver, logger);
//			logger.log(LogStatus.INFO, "Click on more info (meatball) icon OPEN");
//			Thread.sleep(2000);
//			click(moreInfoIcon, driver, logger);
//			Thread.sleep(2000);
//			flag = true;
//
//		} else {
//			logger.log(LogStatus.INFO,
//					"validateMoreInfoOfTxn is failed.\nTABLE -> No Records Found.\nThe \"All Transactions Report\" tableHasData has no data");
//			flag = false;
//		}
//
//		return flag;
//	}

	public int getMoreInfoTable_paramNameListSize() {
		int num = moreInfoTable_paramNameList.size();
		return num;
	}

	public int getMoreInfoTable_paramValueListSize() {
		int num = moreInfoTable_paramValueList.size();
		return num;
	}

	public String getMoreInfoTable_paramName(int paramNo) {
		return moreInfoTable_paramNameList.get(paramNo).getText();
	}

	public String getMoreInfoTable_paramValue(int paramValue) {
		return moreInfoTable_paramValueList.get(paramValue).getText();
	}

//AEPS tab...............................

	public void click_printButton_aepsMoreInfoSideBar() {

		waitForElementToAppear(printButton_moreInfoSideBar_aepsSuccessTxn, driver, logger);

		try {

			logger.log(LogStatus.INFO, "Click print button at AEPS transaction more info side bar");
			click(printButton_moreInfoSideBar_aepsSuccessTxn, driver, logger);
		} catch (Exception e) {

			logger.log(LogStatus.INFO, "Failed click print button at AEPS transaction more info side bar");
		}
	}

//4.MORE INFO side bar methods END ##################################################################################

//5.PAGINATION methods START ########################################################################################

//	public void getBottom_PagenumbersDisplayed(int indexNo) {
//
//		bottom_PagenumbersDisplayed.get(indexNo);
//		logger.log(LogStatus.INFO, "Current page number is -" + indexNo);
//	}

//incomplete
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

			Boolean buttonActive = paginationsAllButtons.get(a).isEnabled();

			if (buttonActive) {

			} else {

			}
		}
	}

	public Boolean isDataFetchedAccordingToPageSizeSelected() throws IOException, InterruptedException {
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI S SCENARIO ????????????????????????????????????????????????????????????????????????
//FOR AASERTION++++++if table has less data than page data size....how to know the VALID data count++++++++++++++++++++++++++++++++++++++++++++++...................?????????????????????????????????????	

		waitForPageLoaded(driver, logger);
		Boolean dataInTable = validateALLTxnReportTableHasData();
		Boolean flag = null;
// if table has data		
		if (dataInTable) {

			scrollToWebElement(pageSizeDropdown, driver);
			// table data count
			int tableDataCount = getTxnTable_rowNumbers();
			// page size selected

			int pageDataSizeSelected = Integer.parseInt(get_perPageDataSize());

			// => scenario - table data is equal to or more than page size selected
			if (tableDataCount >= pageDataSizeSelected) {

				logger.log(LogStatus.INFO, "table data >= page size selected");
				logger.log(LogStatus.INFO,
						"table Data Count -" + tableDataCount + "</br>page Size Selected -" + pageDataSizeSelected);

				if (tableDataCount == pageDataSizeSelected) {
					flag = true;
				} else {
					// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI
					// S SCENARIO
					// ????????????????????????????????????????????????????????????????????????

					flag = true;

				}
				return flag;
			}
			// => scenario 2- table has data - data is less than page size selected

			else {
				logger.log(LogStatus.INFO, "table data < page size selected");
				logger.log(LogStatus.INFO,
						"table Data Count -" + tableDataCount + "</br>page Size Selected -" + pageDataSizeSelected);

//FOR AASERTION++++++if table has less data than page data size....how to know the VALID data count++++++++++++++++++++++++++++++++++++++++++++++...................?????????????????????????????????????	

//				// table data count
//				int dataCount_lessThanPageSizeSelected = (tableDataCount % pageDataSizeSelected);
//
//				if (dataCount_lessThanPageSizeSelected < pageDataSizeSelected) {
//					flag = true;
//					logger.log(LogStatus.INFO, "table data count =" + dataCount_lessThanPageSizeSelected
//							            + "</br>page size selected =" + pageDataSizeSelected);
//
//				} else {
//					// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI
//					// S SCENARIO
//					// ????????????????????????????????????????????????????????????????????????
//
//					flag = false;
//					logger.log(LogStatus.ERROR, "table data count =" + dataCount_lessThanPageSizeSelected
//							+ "</br>page size selected =" + pageDataSizeSelected);
//
//				}
//				return flag;

			}
		}

		else
// if table has no data
		{
			logger.log(LogStatus.INFO, "Table has no data.... ");
		}
		return flag;

	}

//working.......fine..........
	public void validate_tableDataAndTextMessage() throws IOException, InterruptedException {

		logger.log(LogStatus.INFO, "validating - tableData And TextMessage");

		// 1.check - table has data or not
		Thread.sleep(2000);
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
			String[] splittedMsg = msgAtPageBottom.split(" ");// the index number of the numbers must be same (should
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
			// assert - first number is matching or not
			Boolean firstNumIsmatching = compareString(firstNumFromTable, firstNum, false, logger);
			softAssert("validate-first number of record according to PAGE BOTTOM MESSAGE\n", firstNumFromTable,
					firstNum, firstNumIsmatching, logger);
			// assert - last number is matching or not
			Boolean lastNumIsmatching = compareString(lastNumFromtable, lastNum, false, logger);
			softAssert("validate-last number of record according to PAGE BOTTOM MESSAGE\n", lastNumFromtable, lastNum,
					lastNumIsmatching, logger);
		} else
// 1b-if table has no data =>
		{
			logger.log(LogStatus.INFO, "Table has no data");
		}
	}

//4.PAGINATION (PAGE BOTTOM) methods........................
	public String get_perPageDataSize() {
		String dataPerPageNo = null;
		try {
			logger.log(LogStatus.INFO, "Fetch data per page number");
			dataPerPageNo = page_dataPerPageNumber.getText();
			logger.log(LogStatus.INFO, "Fetched data per page number -"+dataPerPageNo);

			return dataPerPageNo;

		} catch (Exception e) {
			logger.log(LogStatus.INFO, e);
			logger.log(LogStatus.INFO, "Data per page dropdown has no value");
		}
		return dataPerPageNo;

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
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled);
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
			logger.log(LogStatus.INFO, "previous page button is enabled -" + buttonEnabled);
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

		// NEXT PAGE button is at TWO index, so passing static value = 2
		WebElement nextPageIconElement = paginationsAllButtons.get(2);
		Boolean buttonEnabled = nextPageIconElement.isEnabled();

		logger.log(LogStatus.INFO, "click next page button");

		if (buttonEnabled) {
			logger.log(LogStatus.INFO, "next page button is enabled -" + buttonEnabled);
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
			logger.log(LogStatus.INFO, "last page button is enabled -" + buttonEnabled);
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

//	public Boolean get_defaultDataSTRING_PerPageIs(String expectedDefaultPageSize) {
//
//		waitForElementToAppear(dataPerPageField, driver, logger);
//		scrollToWebElement(dataPerPageField, driver);
//
//		String defaultDataPerPage = dataPerPageField.getText();
//
//		Boolean defaultDataPerPageSize = compareString(defaultDataPerPage, expectedDefaultPageSize, true);
//
//		return defaultDataPerPageSize;
//
//	}

	public void click_pageSizeDropdown() {

		waitForElementToAppear(pageSizeDropdown, driver, logger);
		logger.log(LogStatus.INFO, "scroll to page size dropdown");
		scrollToWebElement(pageSizeDropdown, driver);

		logger.log(LogStatus.INFO, "Click on page size dropdown");
		click(pageSizeDropdown, driver, logger);

	}

	public void changeCount_DataPerPage(int dataPerPage) {
// ASSUMPTION - page sizes are -10,25,50
//below method used data sizes from the dropdown...if needed use same logic to fetch PAGE DATA SIZES

		waitForElementToAppear(pageSizeDropdown, driver, logger);
		scrollToWebElement(pageSizeDropdown, driver);
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
						+ "</br>Valid values are - 10,25,50");
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Please enter a valid data size per page\n entered value is -" + dataPerPage
					+ "\nValid values are - 10,25,50");
			logger.log(LogStatus.INFO, e);
		}
	}

	// working......fine.....LAST LOOP FAILING- stale element , loop out of index
	// exceptions.

	public void validate_dataPerPageWithAllPageSizes() throws InterruptedException, IOException {

		// scroll and click on page size dropdown to get numbers of the options
		click_pageSizeDropdown();
		// select a value from dropdown (index base so start from 0)
		int pageSizeDropdownListNumbers = perPageDataOptions.size();

		String currentPageDatSize;

		// for loop will fetch all options available in dropdown
		for (int a = 0; a <= (pageSizeDropdownListNumbers - 1); a++) {
			// select data size option 1 (according to index no.)
			scrollToWebElement(pageSizeDropdown, driver);
			waitForElementToAppear(perPageDataOptions.get(a), driver, logger);
			scrollToWebElement(perPageDataOptions.get(a), driver);
//to logger--- data size option 1 (according to index no.)
			currentPageDatSize = perPageDataOptions.get(a).getText();
			logger.log(LogStatus.INFO, "Selected data per page -" + currentPageDatSize);
//click data size option 1 (according to index no.) 
			click(perPageDataOptions.get(a), driver, logger);
			logger.log(LogStatus.INFO, "clicked/selected page size =" + perPageDataOptions.get(a).getText());
			System.out.println("selected page size  -" + perPageDataOptions.get(a).getText());
			Thread.sleep(2000);
// m1...
//			validate_pageSizeSelectedAndDataPerPageFetched();
//m2...			
			validate_tableDataAndTextMessage();
//wait for table loading after changing the data numbers displayed on page
			logger.log(LogStatus.INFO, "validation done (loop no. completed) -" + (a + 1));

			waitForPageLoaded(driver, logger);
			scrollToWebElement(pageSizeDropdown, driver);
			// click page size dropdown to get data size OPTIONS for second loop (if
			// dropdown is close the loop
			click_pageSizeDropdown();
			// scroll to next page size as we will click on next page size in next ITERATION
			scrollToWebElement(perPageDataOptions.get(a), driver);

		}

	}

	public String getCurentPageNumber() {
		waitForElementToAppear(curentPageNumber, driver, logger);
		String pageNo = curentPageNumber.getText();
		logger.log(LogStatus.INFO, "Current page number is -" + pageNo);
		return pageNo;
	}

	public String getPage_paginationDataCountingMsg() {

		waitForElementToAppear(page_paginationDataCountingMsg, driver, logger);
		scrollToWebElement(page_paginationDataCountingMsg, driver);
		logger.log(LogStatus.INFO, "Pagination data counting msg. is -" + page_paginationDataCountingMsg.getText());
		return page_paginationDataCountingMsg.getText();
	}

	public int getPageCountToNavigateDisplayedAtPageBottom() {
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

	public void get_perPageDataOptions(int indexNo) {

		perPageDataOptions.get(indexNo);
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

	public void getStatusOfTxngggg() {

	}

	public void aaagetLastWE() {
		System.out.println("last is displayed-");
		System.out.println("last is enabled-");
	}

}

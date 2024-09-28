package pageObjects;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import org.junit.internal.matchers.Each;
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
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;
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

	@FindBy(xpath = "//div[@class='second-sidemenu']")
	public WebElement secondSideMenu;

	@FindBy(xpath = "//i[@data-name='chevrons-left']")
	public WebElement secondSideMenu_openORClose;

// demo 21-xpath	
//	@FindBy(xpath = "//a[@class='slide-item ng-star-inserted'] [text()=' Transaction History']")
//	public WebElement txnHistoryModule;

// uatdev - xpath	
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

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/thead")
	public WebElement txnTable_head;

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
	public WebElement sideBarHeader_textORTitle;

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
	public WebElement printButton_moreInfoSideBar;

	@FindBy(xpath = "//button[@class='btn btn-primary trigg-btn px-2 fs-13 c-pointer ng-star-inserted']")
	public WebElement raiseComplaintButton_moreInfoSideBar;

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

	@FindBy(xpath = "//div[@class='success-col text-center']")
	public WebElement raiseComplaintForm;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div/button")
	public WebElement raiseComplaintForm_closeButton;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div[2]")
	public WebElement raiseComplaintForm_title;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div[3]/div/label")
	public WebElement raiseComplaintForm_TID_fieldLabel;

	@FindBy(xpath = "//div[@class=success-col text-center']/form/div/div[3]/div/input")
	public WebElement raiseComplaintForm_TID;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div[4]/div/label")
	public WebElement raiseComplaintForm_operatorName_fieldLabel;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div[4]/div/input")
	public WebElement raiseComplaintForm_operatorName;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div[5]/div/label")
	public WebElement raiseComplaintForm_remark_fieldeLabel;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div[5]/div/textarea")
	public WebElement raiseComplaintForm_remarkFielde;

	@FindBy(xpath = "//div[@class='success-col text-center']/div//button")
	public WebElement raiseComplaintForm_submitButton;

	@FindBy(xpath = "//div[@class='success-col text-center']/div/div/div[2]/a")
	public WebElement raiseComplaintForm_cancelButton;

	@FindBy(xpath = "//div[@class='success-col text-center']/form/div/div[5]/div/small")
	public WebElement raiseComplaintForm_remarkMandatoryMessageSubTag;

	@FindBy(xpath = "")
	public WebElement ww;

	@FindBy(xpath = "")
	public WebElement vww;

//CONSTRUCTOR..........

	public TransactionHistoryPOM(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

//METHODS...............

//1.PAGE TOP elements methods START #####################################################################################################

	public boolean secondSideMenu_isDisplayed() {
		return secondSideMenu.isDisplayed();

	}

	public void secondSideMenu_hideORunhide() {

		scrollToWebElement(sideBarHeader_textORTitle, driver);
		scrollElementIntoMiddle(secondSideMenu_openORClose, driver);
		try {
			logger.log(LogStatus.INFO, "click secondSideMenu_openORClose");
			secondSideMenu_hideORunhide();
		} catch (Exception e) {

			logger.log(LogStatus.INFO, "captured exception is -" + e);
			logger.log(LogStatus.INFO, "Unable to click secondSideMenu_openORClose");

		}
	}

	public void secondSideMenu_open() throws IOException {

		boolean isDisp = secondSideMenu_isDisplayed();

		if (isDisp) {
			logger.log(LogStatus.INFO, "Second side menu is already displayed / open");
			screenshotInReport("Second side menu is displayed / open -", driver, logger);
		} else {
			scrollElementIntoMiddle(secondSideMenu_openORClose, driver);
			logger.log(LogStatus.INFO, "click secondSideMenu_openORClose to OPEN");
			secondSideMenu_hideORunhide();
		}
	}

	public void secondSideMenu_close() throws IOException {

		boolean isDisp = secondSideMenu_isDisplayed();

		if (isDisp) {
			scrollElementIntoMiddle(secondSideMenu_openORClose, driver);
			logger.log(LogStatus.INFO, "click secondSideMenu_openORClose to CLOSE");
			click(secondSideMenu_openORClose, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "Second side menu is not displayed / open");
			screenshotInReport("Second side menu is not displayed -", driver, logger);
		}
	}

	public void click_reportsModule() throws IOException, InterruptedException {
//		scrollUp(driver);
		Thread.sleep(2000);
		secondSideMenu_close();

		waitForPageLoaded(driver, logger);
		scrollElementIntoMiddle(reportsModule, driver);
		logger.log(LogStatus.INFO, "click_reportsModule");
		click(reportsModule, driver, logger);

	}

	public void click_txnHistoryModule() {
		waitForElementToAppear(txnHistoryModule, driver, logger);
		scrollElementIntoMiddle(txnHistoryModule, driver);
		logger.log(LogStatus.INFO, "click_txnHistoryModule");
		click(txnHistoryModule, driver, logger);
		waitForPageLoaded(driver, logger);

	}

	public void click_allTxnReportTab() {
		waitForElementToAppear(allTxnReportTab, driver, logger);
		scrollElementIntoMiddle(allTxnReportTab, driver);
		logger.log(LogStatus.INFO, "click_allTxnReportTab--------");
		click(allTxnReportTab, driver, logger);

	}

	public void click_telecomTab() {
		waitForElementToAppear(telecomTab, driver, logger);
		scrollElementIntoMiddle(telecomTab, driver);
		logger.log(LogStatus.INFO, "click_telecomTab--------");
		click(telecomTab, driver, logger);
		waitForPageLoaded(driver, logger);

	}

	public void click_dmtTab() {
		waitForElementToAppear(dmtTab, driver, logger);
		scrollElementIntoMiddle(dmtTab, driver);
		logger.log(LogStatus.INFO, "click_dmtTab-------");
		click(dmtTab, driver, logger);

	}

	public void click_bbpsTab() {
		waitForElementToAppear(bbpsTab, driver, logger);
		scrollElementIntoMiddle(bbpsTab, driver);
		logger.log(LogStatus.INFO, "click_bbpsTab-------");
		click(bbpsTab, driver, logger);

	}

	public void click_aepsTab() {
		waitForElementToAppear(aepsTab, driver, logger);
		scrollElementIntoMiddle(aepsTab, driver);
		logger.log(LogStatus.INFO, "click_aepsTab-------");
		click(aepsTab, driver, logger);
	}

	public void click_microAtmTab() {
		waitForElementToAppear(microAtmTab, driver, logger);
		scrollElementIntoMiddle(microAtmTab, driver);
		logger.log(LogStatus.INFO, "click_microAtmTab-------------");
		click(microAtmTab, driver, logger);
	}

	public void click_exportFileIcon() {
		waitForElementToAppear(exportFileIcon, driver, logger);
		scrollElementIntoMiddle(exportFileIcon, driver);
		logger.log(LogStatus.INFO, "click_exportFileIcon----------");
		click(exportFileIcon, driver, logger);
	}

	public void click_searchButton() throws InterruptedException {
		waitForElementToAppear(searchButton, driver, logger);
		scrollElementIntoMiddle(searchButton, driver);
		logger.log(LogStatus.INFO, "click_searchButton--------");
		click(searchButton, driver, logger);
		waitForPageLoaded(driver, logger);
		Thread.sleep(4000);
	}

//dropdowns ###############################

	public boolean isCategoryTabDisplayed() throws IOException {

		boolean catTabDisp;
		logger.log(LogStatus.INFO, "Verifying category tab is displayed or not");
		try {
			scrollElementIntoMiddle(categoryTab, driver);
			catTabDisp = isPresentAndDisplayed(categoryTab, driver, logger);

			if (catTabDisp) {
				logger.log(LogStatus.INFO, "category tab is displayed");
				highlightElement(categoryTab, "Red", driver, logger);
				screenshotInReport("Category tab is displayed -", driver, logger);
				catTabDisp = true;
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.INFO, "category tab element is not displayed");
			screenshotInReport("Category tab is not displayed -", driver, logger);
			catTabDisp = false;
		}
		return catTabDisp;
	}

//	public boolean isCategoryTabDisplayed2() throws IOException {
//
//		return isWebElementDisplayed(categoryTab, "Category tab is displayed -", driver, logger);
//	}

	public void click_categoryDropdown() throws InterruptedException {

		waitForElementToAppear(categoryDropdown, driver, logger);
		scrollElementIntoMiddle(categoryDropdown, driver);
		logger.log(LogStatus.INFO, "click category dropdown");
		click(categoryDropdown, driver, logger);

	}

	public void click_serviceDropdown() throws InterruptedException {

		waitForElementToAppear(serviceDropdown, driver, logger);
		scrollElementIntoMiddle(serviceDropdown, driver);
		logger.log(LogStatus.INFO, "click service dropdown");
		click(serviceDropdown, driver, logger);

	}

	public void click_operatorDropdown() throws InterruptedException {

		waitForElementToAppear(operatorDropdown, driver, logger);
		scrollElementIntoMiddle(operatorDropdown, driver);
		logger.log(LogStatus.INFO, "click operator dropdown");
		click(operatorDropdown, driver, logger);

	}

	public void selectCategoryFromDropdown(String categoryToSelect) {

		logger.log(LogStatus.INFO, "Selecting category from the dropdown.");

		boolean flag = false;

		for (WebElement categoryOne : categoryDropList) {

			String requiredCategory = categoryOne.getText().trim();

			if (requiredCategory.equalsIgnoreCase(categoryToSelect)) {
				logger.log(LogStatus.INFO, "click category -" + requiredCategory);
				click(categoryOne, driver, logger);
				break;
			}
		}
		if (!flag) {
			logger.log(LogStatus.INFO, "Category not found -" + categoryToSelect);
		}
	}

	public void selectServiceFromDropdown(String serviceToSelect) {

		logger.log(LogStatus.INFO, "navigating through service dropdown ");

		boolean flag = false;

		for (WebElement serviceOne : serviceDropList) {
			String requiredService = serviceOne.getText().trim();

			if (requiredService.equalsIgnoreCase(serviceToSelect)) {
				logger.log(LogStatus.INFO, "click service -" + requiredService);
				click(serviceOne, driver, logger);
				break;
			}
		}

		if (!flag) {
			logger.log(LogStatus.INFO, "Service not found -" + serviceToSelect);
		}
	}

	public void selectOperatorFromDropdown(String operatorToSelect) throws InterruptedException {

		logger.log(LogStatus.INFO, "navigating through operator dropdown ");

		boolean flag = false;

		for (WebElement operatorOne : operatorDropList) {
			String requiredOperator = operatorOne.getText().trim();

			if (requiredOperator.equalsIgnoreCase(operatorToSelect)) {
				logger.log(LogStatus.INFO, "click operator -" + requiredOperator);
				click(operatorOne, driver, logger);
				flag = true;
				break;
			}
		}
		if (!flag) {
			logger.log(LogStatus.INFO, "Operator not found -" + operatorToSelect);
		}
	}

// CALENDAR methods START #####################################################################################################

	public int get_count_fromCalendarEnabledDates() {

		int monthDates_enabledFrom = 0;

		boolean monthDateIsHighlitedFrom = isPresentAndDisplayed(fromCalender_Date_enabled_Highlited, driver, logger);

//		boolean monthDateIsHighlitedFrom = fromCalender_Date_enabled_Highlited.isDisplayed();

		if (Boolean.TRUE.equals(monthDateIsHighlitedFrom)) {
			monthDates_enabledFrom = (1 + fromCalender_Dates_enabled_notHighlited.size());

		} else if (Boolean.FALSE.equals(monthDateIsHighlitedFrom)) {
			monthDates_enabledFrom = fromCalender_Dates_enabled_notHighlited.size();

		}
		return monthDates_enabledFrom;

	}

	public int get_count_toCalendarEnabledDates() {

		int monthDates_enabledTo = 0;

		boolean monthDateIsHighlitedTo = isPresentAndDisplayed(toCalender_Date_enabled_Highlited, driver, logger);

//		boolean monthDateIsHighlitedTo = toCalender_Date_enabled_Highlited.isDisplayed();

		if (Boolean.TRUE.equals(monthDateIsHighlitedTo)) {
			monthDates_enabledTo = (1 + toCalender_Dates_enabled_notHighlited.size());

		} else if (Boolean.FALSE.equals(monthDateIsHighlitedTo)) {
			monthDates_enabledTo = toCalender_Dates_enabled_notHighlited.size();

		}
		return monthDates_enabledTo;

	}

	// new approach....to refer

//	public void selectFromDate2(String stringDate, String monthString, String stringYear) {
//
//		logger.log(LogStatus.INFO, "selecting a date from date calendar");
//
//		waitForPageLoaded(driver, logger);
//		waitForElementToAppear(fromCalenderIcon, driver, logger);
//		scrollElementIntoMiddle(fromCalenderIcon, driver);
//
//		logger.log(LogStatus.INFO, "click from calendar icon");
//		click(fromCalenderIcon, driver, logger);
//		logger.log(LogStatus.INFO, "selecting from month and from year");
//
//		String calendarMonth = fromMonth.getText();
//		String calendarYear = fromYear.getText();
//
//		while (!(calendarMonth.equals(monthString) && calendarYear.equals(stringYear))) {
//			waitForElementToAppear(fromCalenderPreviousButton, driver, logger);
//			click(fromCalenderPreviousButton, driver, logger);
//			calendarMonth = fromMonth.getText();
//			calendarYear = fromYear.getText();
//		}
//
//		logger.log(LogStatus.INFO, "selecting from date");
//
//		//navigate through enabled dates only...loop will iterate for those count only
//	int enabledDatesCount =	get_count_fromCalendarEnabledDates();
//	
//	logger.log(LogStatus.INFO, "1.................enabled date count -"+enabledDatesCount);
//
//	
//	String enabledDate_clicked=null;
//	try
//	{
//		for (int dateIndex = 0; dateIndex < enabledDatesCount; dateIndex++) 
//		{
//			logger.log(LogStatus.INFO, "2.................loop index -"+dateIndex);
//
//			boolean dateSelected=false;
//			
//			//select enabled non highlited date
//			for(WebElement enabledDatWE : fromCalender_Dates_enabled_notHighlited) 
//			{
//				logger.log(LogStatus.INFO, "3.................enabled date WE -"+enabledDatWE);
//
//			String enabledDate	= enabledDatWE.getText();
//			
//			logger.log(LogStatus.INFO, "4.................enabled date  -"+enabledDate);
//
//				
//		    	if (enabledDate.equals(stringDate)) 
//		    	{
//
//				  click(enabledDatWE, driver, logger);
//				  dateSelected=true;
//				   enabledDate_clicked = enabledDatWE.getText();
//					logger.log(LogStatus.INFO, "5.................click date  -"+enabledDate_clicked);
//
//				  break;			
//			   }
//			}
//		//select enabled highlited date	...if the flag 'dateSelected' is false (not true)
//			if(!dateSelected)
//			{
//				logger.log(LogStatus.INFO, "6.................highlited date nnoo  -"+enabledDate_clicked);
//
//				click(fromCalender_Date_enabled_Highlited, driver, logger);
//				enabledDate_clicked =fromCalender_Date_enabled_Highlited.getText();
//				
//				logger.log(LogStatus.INFO, "7.................highlited date clicked  -"+enabledDate_clicked);
//
//
//			}
//		 }//for loop close...date selection is complete
//		
//		
//
//		logger.log(LogStatus.INFO,
//				"selected from date-" + enabledDate_clicked + "-" + calendarMonth + "-" + calendarYear);
//		
//	}//try block close...if encountered any exception while selecting date BELOW log will be displayed
//	
//	catch (Exception e) 
//	{
//		logger.log(LogStatus.INFO,	"Unable to select a date");
//		logger.log(LogStatus.INFO,	"Captured exception is -"+e);
//	
//	}
//	logger.log(LogStatus.INFO, "8.................end...............");
//
//}

//	public void selectToDate2(int date, String monthString, int year) throws InterruptedException {
//
//		Thread.sleep(3000);
//		logger.log(LogStatus.INFO, "selecting a date from to calendar");
//
//		String stringDate = Integer.toString(date);
//		String stringYear = Integer.toString(year);
//
//		waitForPageLoaded(driver, logger);
//		waitForElementToAppear(toCalenderIcon, driver, logger);
//		scrollElementIntoMiddle(toCalenderIcon, driver);
//		logger.log(LogStatus.INFO, "click to calendar icon");
//		click(toCalenderIcon, driver, logger);
//
//		logger.log(LogStatus.INFO, "selecting to month and to year");
//
//		String calendarMonth = toMonth.getText();
//		String calendarYear = toYear.getText();
//
//		while (!(calendarMonth.equals(monthString) && calendarYear.equals(stringYear))) {
//			waitForElementToAppear(toCalenderPreviousButton, driver, logger);
//			click(toCalenderPreviousButton, driver, logger);
//			calendarMonth = toMonth.getText();
//			calendarYear = toYear.getText();
//		}
//
////		logger.log(LogStatus.INFO, "selected to month -" + calenderMonth + "\nselected to year -" + calenderYear);
//		logger.log(LogStatus.INFO, "selecting to date");
//
//		//navigate through enabled dates only...loop will iterate for those count only
//		int enabledDatesCount =	get_count_toCalendarEnabledDates();
//
//		String enabledDate_clicked=null;
//		try
//		{
//			for (int dateIndex = 0; dateIndex < enabledDatesCount; dateIndex++) 
//			{
//				
//				boolean dateSelected=false;
//				
//				//select enabled non highlited date
//				for(WebElement enabledDatWE : toCalender_Dates_enabled_notHighlited) 
//				{
//					
//				String enabledDate	= enabledDatWE.getText();
//					
//			    	if (enabledDate.equals(stringDate)) 
//			    	{
//					  click(enabledDatWE, driver, logger);
//					  dateSelected=true;
//					   enabledDate_clicked = enabledDatWE.getText();
//					  break;			
//				   }
//				}
//			//select enabled highlited date	...if the flag 'dateSelected' is false (not true)
//				if(!dateSelected)
//				{
//					click(toCalender_Date_enabled_Highlited, driver, logger);
//					enabledDate_clicked =toCalender_Date_enabled_Highlited.getText();
//				}
//			 }//for loop close...date selection is complete
//			
//			
//
//			logger.log(LogStatus.INFO,
//					"selected from date-" + enabledDate_clicked + "-" + calendarMonth + "-" + calendarYear);
//			
//		}//try block close...if encountered any exception while selecting date BELOW log will be displayed
//		
//		catch (Exception e) 
//		{
//			logger.log(LogStatus.INFO,	"Unable to select a date");
//			logger.log(LogStatus.INFO,	"Captured exception is -"+e);
//		
//		}
//		
//	}

//old approach....to refer

	public void selectFromDate2(String stringDate, String monthString, String stringYear) throws InterruptedException {

		logger.log(LogStatus.INFO, "selecting a date from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
		scrollElementIntoMiddle(fromCalenderIcon, driver);

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

		logger.log(LogStatus.INFO, "selecting from date");
		String calendarDateValue = null;
		for (int dateIndex = 0; dateIndex < 35; dateIndex++) {
			calendarDateValue = datesOfFromCalender.get(dateIndex).getText();
			if (calendarDateValue.equals(stringDate)) {
				click(datesOfFromCalender.get(dateIndex), driver, logger);
				break;
			}
		}
		logger.log(LogStatus.INFO, "selected to date-" + calendarDateValue + "-" + calendarMonth + "-" + calendarYear);
	}

	public void selectToDate2(int date, String monthString, int year) throws InterruptedException {

		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "selecting a date from to calendar");

		String stringDate = Integer.toString(date);
		String stringYear = Integer.toString(year);

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
		scrollElementIntoMiddle(toCalenderIcon, driver);
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

		for (int dateIndex = 0; dateIndex < 35; dateIndex++) {
			calendarDateValue = datesOfToCalender.get(dateIndex).getText();
			if (calendarDateValue.equals(stringDate)) {
				click(datesOfToCalender.get(dateIndex), driver, logger);
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

		logger.log(LogStatus.INFO, "Capturing highlited FROM date");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
		scrollElementIntoMiddle(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing highlited_from date");

		String calendarHighlitedDate = fromCalender_Date_enabled_Highlited.getText();
		logger.log(LogStatus.INFO, "captured default from date is -" + calendarHighlitedDate);

		return calendarHighlitedDate;
	}

	public String getFromCalendar_todayDate() {

		logger.log(LogStatus.INFO, "Capturing today's date from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
		scrollElementIntoMiddle(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing today's_from date");

		String calendarTodayDate = fromCalender_Date_Today.getText();
		logger.log(LogStatus.INFO, "captured today's date from calendar is -" + calendarTodayDate);

		return calendarTodayDate;
	}

	public String getFromCalendar_Month() {

		logger.log(LogStatus.INFO, "Capturing selected month from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
		scrollElementIntoMiddle(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing default_from month");

		String calendarFromMonth = fromMonth.getText();
		logger.log(LogStatus.INFO, "captured from month is -" + calendarFromMonth);

		return calendarFromMonth;
	}

	public String getFromCalendar_Year() {

		logger.log(LogStatus.INFO, "Capturing selected year from date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromCalenderIcon, driver, logger);
		scrollElementIntoMiddle(fromCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click from calendar icon");
		click(fromCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing default_from year");

		String calendarFromYear = fromYear.getText();
		logger.log(LogStatus.INFO, "captured from year is -" + calendarFromYear);

		return calendarFromYear;

	}

	public String getToCalendar_highlitedDate() {

		logger.log(LogStatus.INFO, "Capturing highlited date from TO date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
		scrollElementIntoMiddle(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing highlited_to date");

		String calendarHighlitedDate = toCalender_Date_enabled_Highlited.getText();
		logger.log(LogStatus.INFO, "captured default to date is -" + calendarHighlitedDate);

		return calendarHighlitedDate;
	}

	public String getToCalendar_todayDate() {

		logger.log(LogStatus.INFO, "Capturing today's date to date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
		scrollElementIntoMiddle(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing today's_to date");

		String calendarTodayDate = toCalender_Date_Today.getText();
		logger.log(LogStatus.INFO, "captured today's date from calendar is -" + calendarTodayDate);

		return calendarTodayDate;
	}

	public String getToCalendar_Month() {

		logger.log(LogStatus.INFO, "Capturing selected month to date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
		scrollElementIntoMiddle(toCalenderIcon, driver);

		logger.log(LogStatus.INFO, "click to calendar icon");
		click(toCalenderIcon, driver, logger);
		logger.log(LogStatus.INFO, "capturing default_to month");

		String calendarToMonth = toMonth.getText();
		logger.log(LogStatus.INFO, "captured from month is -" + calendarToMonth);

		return calendarToMonth;
	}

	public String getToCalendar_Year() {

		logger.log(LogStatus.INFO, "Capturing selected year to date calendar");

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(toCalenderIcon, driver, logger);
		scrollElementIntoMiddle(toCalenderIcon, driver);

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

		System.out.println("1....................");
		boolean datainTable;
		int enabledDatesCount1;

		datainTable = validateALLTxnReportTableHasData();
		click(fromCalenderIcon, driver, logger);
		enabledDatesCount1 = fromCalender_Dates_enabled_notHighlited.size();
 	int a = enabledDatesCount1-1;

		boolean needToIterate = true;
		if (needToIterate) {
			if (datainTable) {
				System.out.println(".......table has data.............");
			} else 
			{
				for (int aa = 1; aa <= 3; aa++)
				{
					System.out.println("loop num -" + aa);					
					for (int enabledDatesCountIndex = a; enabledDatesCountIndex > 0; enabledDatesCountIndex--) {
						System.out.println("1...index count ---------" + enabledDatesCountIndex);

						System.out.println("value of a ---------" + a);

						click(fromCalenderIcon, driver, logger);
					
						if(enabledDatesCountIndex == a)
						{
						switch(aa)
						{
						case 2:  
							Thread.sleep(1000);
					     	click(fromCalenderPreviousButton, driver, logger);
					    	Thread.sleep(1000); 
					    	;break;
						
						case 3:
							Thread.sleep(1000);
					     	click(fromCalenderPreviousButton, driver, logger);
					     	click(fromCalenderPreviousButton, driver, logger);
					    	Thread.sleep(1000); 
							;break;

						case 4:
							Thread.sleep(1000);
					     	click(fromCalenderPreviousButton, driver, logger);
					     	click(fromCalenderPreviousButton, driver, logger);
					     	click(fromCalenderPreviousButton, driver, logger);
					    	Thread.sleep(1000); 
							;break;
						
						default :  logger.log(LogStatus.INFO, "Navigate back for the mentioned number of monthes is COMPLETED.");  ;

						}	
					}
							
						WebElement dateWE = fromCalender_Dates_enabled_notHighlited.get(enabledDatesCountIndex);
						int dateAsInt = Integer.parseInt(dateWE.getText());
						click(dateWE, driver, logger);
						Thread.sleep(2000);
						WebElement searchButton2 = driver.findElement(By.xpath("//button[text()='Search']"));
						scrollElementIntoMiddle(searchButton2, driver);
						click(searchButton2, driver, logger);
						Thread.sleep(2000);
						datainTable = validateALLTxnReportTableHasData();
						System.out.println("2...index count ---------" + enabledDatesCountIndex);

						if (dateAsInt == 1 && !datainTable) {
							System.out.println("3...index count ---------" + enabledDatesCountIndex);
							logger.log(LogStatus.INFO, "Navigating to previous month");
							click(fromCalenderIcon, driver, logger);
							Thread.sleep(2000);
							click(fromCalenderPreviousButton, driver, logger);
							Thread.sleep(2000);
							int enabledDatesCount2 = fromCalender_Dates_enabled_notHighlited.size();
							a = (enabledDatesCount2 - 1);
							System.out.println("4...index count 2---------" + enabledDatesCount2);
							System.out.println("4b...value of aaa-----a----" + a);

						} else {
							System.out.println("----5------continue--------");
							System.out.println("5...value of aaa-----a----" + a);

							continue;
						}
					}
				} // close---navigate through dates of current month
			}
		} // close----changeMonth=false
	}

// CALENDAR methods END #####################################################################################################

//3.ALL TRANSACTION TABLE methods START ##################################################################################

	public int getTxnTable_columnNumbersHEAD() {
		waitForPageLoaded(driver, logger);
		scrollElementIntoMiddle(txnTable_head, driver);
		return txnTable_columnsHEAD.size();
	}

//we calculate number of columns in first row...if col=1 (table has no data)...	
	public int getTxnTable_columnsInFirstRow() {
		waitForPageLoaded(driver, logger);
		scrollElementIntoMiddle(txnTable_head, driver);
		return txnTable_columnsInFirstRow.size();
	}

	public int getTxnTable_rowNumbers() throws InterruptedException {
		Thread.sleep(5000);
		waitForPageLoaded(driver, logger);
		return txnTable_rows.size();

	}

	public void validateMessageDisplayedIfTableHasNOData(String expectedMessage, boolean ignoreCase, ExtentTest logger)
			throws IOException, InterruptedException {

		boolean dataInTable = validateALLTxnReportTableHasData();
		if (dataInTable) {
			screenshotInReport("Txn. table has data -", driver, logger);
		} else {
			String actualMessage = getTxnTable_messageIfNoTableData();
			screenshotInReport("Txn. table has no data 'message displayed' -", driver, logger);
//compare string
			boolean msgIsCorrect = compareString(actualMessage, expectedMessage, ignoreCase, logger);
//assertion - message displayed		
			softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, msgIsCorrect,
					logger);

		}
	}

	// incomplete..............
	public void getTxnStatus2() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "Getting transaction status.");

		Boolean dataInTable = validateALLTxnReportTableHasData();

		if (dataInTable) {

			// columns in the table
			int totalColumns = getTxnTable_columnNumbersHEAD();

			for (int colWEindex = 0; colWEindex < totalColumns; colWEindex++) {

				// get column names (index is always less by 1 than column no.)
				int colNo = (colWEindex + 1);

				String colName = txnTable_columnsHEAD.get(colNo).getText().trim();

				if (colName.equalsIgnoreCase("Status")) {

					// navigate through each row--------
					int tableRowsCount = txnTable_rows.size();

					for (int tableRowIndex = 0; tableRowIndex < tableRowsCount; tableRowIndex++) {

						// row number INCREASE and column number STATIC of column matching entered name

						int rowNo = (tableRowIndex + 1);

						WebElement txnStatusWE = driver.findElement(By.xpath(
								"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
										+ rowNo + "]/td[" + colNo + "]"));
						String statusText = txnStatusWE.getText().trim();

						// handle according to the txn. status

						String txnStatusOne = "Successful";
						String txnStatusTwo = "Failed";
						String txnStatusThree = "Pending";

						if (statusText.equalsIgnoreCase(txnStatusOne)) // successful
						{
							OpenMoreInfoOfTxnPopup(rowNo);

							// ASSERTION - validating buttons count-----------
							int buttonsCount = moreInfo_headersButtonsList_dmt.size();
							String actualButtonsCount = String.valueOf(buttonsCount);
							String expectedButtonsCount = "3";
							// compare button count.......
							boolean ignoreCase = false;
							boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
									ignoreCase, logger);
							softAssert("More info side menu header buttons count for '" + txnStatusOne + "' txn. is-",
									actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
							// ASSERTION - More info side menu PRINT button not displayed-----------
							boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
							softAssertFalse("More info side menu PRINT button is not displayed -", isPrintButtonDisp,
									logger);

						} else if (statusText.equalsIgnoreCase(txnStatusTwo))// failed
						{
							OpenMoreInfoOfTxnPopup(rowNo);
							// ASSERTION - validating buttons count-----------
							int buttonsCount = moreInfo_headersButtonsList_dmt.size();
							String actualButtonsCount = String.valueOf(buttonsCount);
							String expectedButtonsCount = "1";
							// compare button count.......
							boolean ignoreCase = false;
							boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
									ignoreCase, logger);
							softAssert("More info side menu header buttons count for '" + txnStatusTwo + "' txn. is-",
									actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

							// ASSERTION - More info side menu PRINT button not displayed-----------
							boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
							softAssertFalse("More info side menu PRINT button is not displayed -", isPrintButtonDisp,
									logger);

						} else if (statusText.equalsIgnoreCase(txnStatusThree))// pending
						{
							OpenMoreInfoOfTxnPopup(rowNo);
							// ASSERTION - validating buttons count-----------
							int buttonsCount = moreInfo_headersButtonsList_dmt.size();
							String actualButtonsCount = String.valueOf(buttonsCount);
							String expectedButtonsCount = "1";
							// compare button count.......
							boolean ignoreCase = false;
							boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
									ignoreCase, logger);
							softAssert("More info side menu header buttons count for '" + txnStatusThree + "' txn. is-",
									actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

							// ASSERTION - More info side menu PRINT button not displayed-----------
							boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
							softAssertFalse("More info side menu PRINT button is not displayed -", isPrintButtonDisp,
									logger);

						} else {
							logger.log(LogStatus.INFO, "Transaction status is not -" + txnStatusOne + "/" + txnStatusTwo
									+ "/" + txnStatusThree);
							logger.log(LogStatus.INFO, "Transaction status is -" + statusText);
						}

					} // span

					// return aa;

				}

			}

		} else {
			logger.log(LogStatus.INFO, "Telecom table has no data");

		}

	}

	public void validateMoreInfoSideBarHeaderButtons() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "Validating transaction MORE INFO side menu buttons count.");
		boolean dataInTable = validateALLTxnReportTableHasData();
//if table has data
		if (dataInTable) {
			// navigate through column header--------
			int totalColumns = getTxnTable_columnNumbersHEAD();
			for (int colWEindex = 0; colWEindex < totalColumns; colWEindex++) {
				// get column names (index is always less by 1 than column no.)
				int colNo = (colWEindex + 1);
				String colName = txnTable_columnsHEAD.get(colWEindex).getText().trim();
				if (colName.equalsIgnoreCase("Status")) {
					// navigate through each row and get STATUS of each row/txn.--------
					int tableRowsCount = txnTable_rows.size();
					for (int tableRowIndex = 0; tableRowIndex < tableRowsCount; tableRowIndex++) {

						// row number = INCREASE and column number = STATIC of column matching entered
						// name
						int rowNo = (tableRowIndex + 1);

						// fetch category and status from table
						String categoryTextFromTable = getTxnCategory(tableRowIndex);
						String statusTextFromTable = getTxnStatus(tableRowIndex);
						logger.log(LogStatus.INFO,
								"Transaction Number ------------>" + rowNo + " - " + statusTextFromTable);
						logger.log(LogStatus.INFO, "Transaction Category ------------>" + categoryTextFromTable);
						// txn. status list to handle....................
						String txnStatusSuccessful = "Successful";
						String txnStatusFailed = "Failed";
						String txnStatusPending = "Pending";
						String txnStatusProcessing = "Processing";
						String txnStatusReversal = "Reversal";
//open more info side menu bar
						OpenMoreInfoOfTxnPopup(tableRowIndex);
//validate - is more info side menu bar open
						boolean isMoreInfoSideMenuOpen;
						isMoreInfoSideMenuOpen = isMoreInfoSideBarDisplayed();
						if (isMoreInfoSideMenuOpen) {
							// if more info side menu is open then compare txn. status and validate
							// scenarios accordingly.................
							categoryTextFromTable = getTxnCategory(tableRowIndex);
							// category - telecom
							if (categoryTextFromTable.equalsIgnoreCase("Telecom")) {

								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);
								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) // status - successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertTrue("More info side menu PRINT button is displayed -", isPrintButtonDisp,
											logger);

								} else if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusProcessing)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusPending))// failed
								{
									// ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// ASSERTION - More info side menu PRINT button not displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								} else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful + "/"
													+ txnStatusFailed + "/" + txnStatusProcessing + "/"
													+ txnStatusPending);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - DMT
							else if (categoryTextFromTable.equalsIgnoreCase("DMT")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);
								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) // status - successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "3";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertTrue("More info side menu PRINT button is displayed -", isPrintButtonDisp,
											logger);
								} else if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusProcessing)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusPending))// failed
								{
									// ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// ASSERTION - More info side menu PRINT button not displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								}

								else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful + "/"
													+ txnStatusFailed + "/" + txnStatusProcessing + "/"
													+ txnStatusPending);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - payin

							else if (categoryTextFromTable.equalsIgnoreCase("Payin")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);

								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) // status - successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								}

								else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}
							// category - Payout
							else if (categoryTextFromTable.equalsIgnoreCase("Payout")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);
								if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusProcessing)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusReversal)) // status -
																									// successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								} else {
									logger.log(LogStatus.INFO, "Handled transaction status are -" + txnStatusFailed
											+ "/" + txnStatusProcessing + "/" + txnStatusReversal);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - BBPS

							else if (categoryTextFromTable.equalsIgnoreCase("BBPS")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);

								if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)) {
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								} else if (statusTextFromTable.equalsIgnoreCase(txnStatusPending)
										|| (statusTextFromTable.equalsIgnoreCase(txnStatusProcessing))) {
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "2";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isRaiseComplaintButtonDisp = moreInfoSideMenu_isRaiseComplaintButtonDisplayed();
									softAssertTrue("More info side menu RAISE COMPLAINT button is not displayed -",
											isRaiseComplaintButtonDisp, logger);
								}

								else {
									logger.log(LogStatus.INFO, "Handled transaction status are -" + txnStatusFailed
											+ "/" + txnStatusProcessing + "/" + txnStatusPending);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - AEPS

							else if (categoryTextFromTable.equalsIgnoreCase("AEPS")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);

								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) {
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertTrue("More info side menu PRINT button is displayed -", isPrintButtonDisp,
											logger);
								}

								else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// after validating all for a txn ....close the more info side bar of that txn.

							logger.log(LogStatus.INFO, "cat captured (un-handled) is -" + categoryTextFromTable);

							Thread.sleep(1000);
							click_close_lastButton_moreInfoSideBar();

						}
						// if----More info side menu is open...above actions will happens and
						// close...........one loop completed HERE
						else {
							logger.log(LogStatus.INFO, "More info side menu is already closed...");
						}
					} // for loop close---all conditions are tested for txn. one

				} // get column names----close
			} // column head navigation----close
		} // if table has data----close

		else {
			logger.log(LogStatus.INFO, "no table data....so no more info side menu bar.");

		}
	}

	public void validateMoreInfoSideBarHeaderButtons2() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "Validating transaction MORE INFO side menu buttons count and raise ticket.");

		boolean dataInTable = validateALLTxnReportTableHasData();
//if table has data
		if (dataInTable) {
			// navigate through column header--------
			int totalColumns = getTxnTable_columnNumbersHEAD();
			for (int colWEindex = 0; colWEindex < totalColumns; colWEindex++) {
				// get column names (index is always less by 1 than column no.)
				int colNo = (colWEindex + 1);
				String colName = txnTable_columnsHEAD.get(colWEindex).getText().trim();
				if (colName.equalsIgnoreCase("Status")) {
					// navigate through each row and get STATUS of each row/txn.--------
					int tableRowsCount = txnTable_rows.size();
					for (int tableRowIndex = 0; tableRowIndex < tableRowsCount; tableRowIndex++) {

						// row number = INCREASE and column number = STATIC of column matching entered
						// name
						int rowNo = (tableRowIndex + 1);

						// fetch category and status from table
						String categoryTextFromTable = getTxnCategory(tableRowIndex);
						String statusTextFromTable = getTxnStatus(tableRowIndex);
						logger.log(LogStatus.INFO,
								"Transaction Number ------------>" + rowNo + " - " + statusTextFromTable);
						logger.log(LogStatus.INFO, "Transaction Category ------------>" + categoryTextFromTable);
						// txn. status list to handle....................
						String txnStatusSuccessful = "Successful";
						String txnStatusFailed = "Failed";
						String txnStatusPending = "Pending";
						String txnStatusProcessing = "Processing";
						String txnStatusReversal = "Reversal";
//open more info side menu bar
						OpenMoreInfoOfTxnPopup(tableRowIndex);
//validate - is more info side menu bar open
						boolean isMoreInfoSideMenuOpen;
						isMoreInfoSideMenuOpen = isMoreInfoSideBarDisplayed();
						if (isMoreInfoSideMenuOpen) {
							// if more info side menu is open then compare txn. status and validate
							// scenarios accordingly.................
							categoryTextFromTable = getTxnCategory(tableRowIndex);
							// category - telecom
							if (categoryTextFromTable.equalsIgnoreCase("Telecom")) {

								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);
								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) // status - successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertTrue("More info side menu PRINT button is displayed -", isPrintButtonDisp,
											logger);

								} else if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusProcessing)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusPending))// failed
								{
									// ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// ASSERTION - More info side menu PRINT button not displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								} else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful + "/"
													+ txnStatusFailed + "/" + txnStatusProcessing + "/"
													+ txnStatusPending);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - DMT
							else if (categoryTextFromTable.equalsIgnoreCase("DMT")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);
								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) // status - successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "3";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertTrue("More info side menu PRINT button is displayed -", isPrintButtonDisp,
											logger);
								} else if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusProcessing)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusPending))// failed
								{
									// ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// ASSERTION - More info side menu PRINT button not displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								}

								else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful + "/"
													+ txnStatusFailed + "/" + txnStatusProcessing + "/"
													+ txnStatusPending);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - payin

							else if (categoryTextFromTable.equalsIgnoreCase("Payin")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);

								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) // status - successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								}

								else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}
							// category - Payout
							else if (categoryTextFromTable.equalsIgnoreCase("Payout")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);
								if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusProcessing)
										|| statusTextFromTable.equalsIgnoreCase(txnStatusReversal)) // status -
																									// successful
								{
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								} else {
									logger.log(LogStatus.INFO, "Handled transaction status are -" + txnStatusFailed
											+ "/" + txnStatusProcessing + "/" + txnStatusReversal);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - BBPS

							else if (categoryTextFromTable.equalsIgnoreCase("BBPS")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);

								if (statusTextFromTable.equalsIgnoreCase(txnStatusFailed)) {
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
								} else if (statusTextFromTable.equalsIgnoreCase(txnStatusPending)
										|| (statusTextFromTable.equalsIgnoreCase(txnStatusProcessing))) {
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();

									for (WebElement buttonElement : moreInfo_headersButtonsList_dmt) {

										String actualButtonName = buttonElement.getText().trim();
										String expectedButtonName = "Raise Complaint";

										boolean ignoreCase = false;
										boolean buttonNameIsMatching = compareString(actualButtonName,
												expectedButtonName, ignoreCase, logger);

										if (buttonNameIsMatching) {

											click(buttonElement, driver, logger);
											Thread.sleep(2000);

											driver.switchTo().activeElement();

											String tidLabel = raiseComplaintForm_TID_fieldLabel.getText();
											logger.log(LogStatus.INFO, "Txn. id field label -" + tidLabel);

											String operatorNameLabel = raiseComplaintForm_operatorName_fieldLabel
													.getText();
											logger.log(LogStatus.INFO,
													"Operator name field label -" + operatorNameLabel);

											String remarkLabel = raiseComplaintForm_remark_fieldeLabel.getText();
											logger.log(LogStatus.INFO, "Raise remark field label -" + remarkLabel);

											String remarkText = "I am shinde";
											sendingKeys(raiseComplaintForm_remarkFielde, remarkText, driver);

											Thread.sleep(1000);

											try {

												boolean isDispBoolean = isPresentAndDisplayed(
														raiseComplaintForm_remarkMandatoryMessageSubTag, driver,
														logger);

												if (isDispBoolean) {
													String textString = raiseComplaintForm_remarkMandatoryMessageSubTag
															.getText();
													logger.log(LogStatus.INFO,
															"REMARK field is mandatory.</br> Text/message displayed if remark field is empty -"
																	+ textString);
												}
											} catch (Exception e) {
												logger.log(LogStatus.INFO,
														"REMARK field is mandatory.</br> Remark is -" + remarkText);

											}

											// click(raiseComplaintForm_cancelButton, driver, logger);

											// click(raiseComplaintForm_submitButton, driver, logger);

											click(raiseComplaintForm_closeButton, driver, logger);

											Thread.sleep(1000);

										} // close----------if button name is matching

									} // close -----buttons displayed actions completed

									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "2";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertFalse("More info side menu PRINT button is not displayed -",
											isPrintButtonDisp, logger);
									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isRaiseComplaintButtonDisp = moreInfoSideMenu_isRaiseComplaintButtonDisplayed();
									softAssertTrue("More info side menu RAISE COMPLAINT button is not displayed -",
											isRaiseComplaintButtonDisp, logger);
								}

								else {
									logger.log(LogStatus.INFO, "Handled transaction status are -" + txnStatusFailed
											+ "/" + txnStatusProcessing + "/" + txnStatusPending);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// category - AEPS

							else if (categoryTextFromTable.equalsIgnoreCase("AEPS")) {
								logger.log(LogStatus.INFO,
										"Txn. status handling of the category -" + categoryTextFromTable);

								if (statusTextFromTable.equalsIgnoreCase(txnStatusSuccessful)) {
									// 1. ASSERTION - validating buttons count-----------
									int buttonsCount = moreInfo_headersButtonsList_dmt.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is-",
											actualButtonsCount, expectedButtonsCount, isCountMatching, logger);

									// 2. ASSERTION - More info side menu PRINT button displayed-----------
									boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
									softAssertTrue("More info side menu PRINT button is displayed -", isPrintButtonDisp,
											logger);
								}

								else {
									logger.log(LogStatus.INFO,
											"Handled transaction status are -" + txnStatusSuccessful);
									logger.log(LogStatus.INFO,
											"Captured transaction status is -" + statusTextFromTable);
								}
							}

							// after validating all for a txn ....close the more info side bar of that txn.

							logger.log(LogStatus.INFO,
									"begore closing----showing captured category -" + categoryTextFromTable);

							Thread.sleep(1000);
							click_close_lastButton_moreInfoSideBar();

						}
						// if----More info side menu is open...above actions will happens and
						// close...........one loop completed HERE
						else {
							logger.log(LogStatus.INFO, "More info side menu is already closed...");
						}
					} // for loop close---all conditions are tested for txn. one

				} // get column names----close
			} // column head navigation----close
		} // if table has data----close

		else {
			logger.log(LogStatus.INFO, "no table data....more info ...status...buttons,,,cat");

		}

	}

	public void validateMoreInfoSideMenuData_TableData() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "validating More Info Side Menu Data And Table Data");

		boolean dataInTable = validateALLTxnReportTableHasData();
//if table has data
		if (dataInTable) {
			// navigate through each row of table
			int tableRows = txnTable_rows.size();
			for (int tableRowIndex = 0; tableRowIndex < tableRows; tableRowIndex++) {
				// fetch data from TABLE column---to compare with MORE INFO table data
				// open more info side menu bar
				OpenMoreInfoOfTxnPopup(tableRowIndex);
//validate - is more info side menu bar open
				boolean isMoreInfoSideMenuOpen;
				isMoreInfoSideMenuOpen = isMoreInfoSideBarDisplayed();
				if (isMoreInfoSideMenuOpen) {
					// navigate through MORE INFO table
					int moreInfoParamNos = moreInfoTable_paramNameList.size();
					int moreInfoValueNos = moreInfoTable_paramValueList.size();

					logger.log(LogStatus.INFO,
							"Parameter Nos. -" + moreInfoParamNos + "</br>Parameter value Nos. --" + moreInfoValueNos);

					for (int moreInfoRowsIndex = 0; moreInfoRowsIndex < moreInfoParamNos; moreInfoRowsIndex++) {

						int moreInfoRowsNum = (moreInfoRowsIndex + 1);

						String moreInfoParam = moreInfoTable_paramNameList.get(moreInfoRowsIndex).getText();
						String moreInfoValue = moreInfoTable_paramValueList.get(moreInfoRowsIndex).getText();

						logger.log(LogStatus.INFO, "moreInfo--Param - val ==>" + moreInfoRowsIndex + "." + moreInfoParam
								+ "-" + moreInfoValue);

					} // close--- navigating through more info table
						// after validating more info table data for a txn ....close the more info side
						// bar of that txn.
					Thread.sleep(1000);
					click_close_lastButton_moreInfoSideBar();
				} // close---is more info side menu displayed
			} // close---navigate through row of table
		} // close---if table has data
	}

//	public void validateMoreInfoSideBarHeaderButtons() throws InterruptedException, IOException {
//
//		logger.log(LogStatus.INFO, "Getting transaction status.");
//
//		Boolean dataInTable = validateALLTxnReportTableHasData();
////if table has data
//		if (dataInTable) {
//			// navigate through column header--------
//			int totalColumns = getTxnTable_columnNumbersHEAD();
//			for (int colWEindex = 0; colWEindex < totalColumns; colWEindex++) {
//				// get column names (index is always less by 1 than column no.)
//				int colNo = (colWEindex + 1);
//
//				String colName = txnTable_columnsHEAD.get(colWEindex).getText().trim();
//
//				if (colName.equalsIgnoreCase("Status")) {
//					// navigate through each row and get STATUS of each row/txn.--------
//					int tableRowsCount = txnTable_rows.size();
//					for (int tableRowIndex = 0; tableRowIndex < tableRowsCount; tableRowIndex++) {
//
//						// row number = INCREASE and column number = STATIC of column matching entered
//						// name
//
//						int rowNo = (tableRowIndex + 1);
//
//						WebElement txnStatusWE = driver.findElement(By.xpath(
//								"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
//										+ rowNo + "]/td[" + colNo + "]"));
//						String statusText = txnStatusWE.getText().trim();
//
//						logger.log(LogStatus.INFO, "Transaction Number ------------>" + rowNo + " - " + statusText);
//
//						// txn. status list to handle....................
//
//						String txnStatusOne = "Successful";
//						String txnStatusTwo = "Failed";
//						String txnStatusThree = "Pending";
//						String txnStatusFour = "Processing";
//
////open more info side menu bar
//
//						OpenMoreInfoOfTxnPopup(tableRowIndex);
////validate - is more info side menu bar open
//
//						boolean isMoreInfoSideMenuOpen;
//
//						isMoreInfoSideMenuOpen = isMoreInfoSideBarDisplayed();
//
//						if (isMoreInfoSideMenuOpen) {
//							// if more info side menu is open then compare txn. status and validate
//							// scenarios accordingly.................
//							if (statusText.equalsIgnoreCase(txnStatusOne)) // successful
//							{
//								// ASSERTION - validating buttons count-----------
//								int buttonsCount = moreInfo_headersButtonsList_dmt.size();
//								String actualButtonsCount = String.valueOf(buttonsCount);
//								String expectedButtonsCount = "1";
//								// compare button count.......
//								boolean ignoreCase = false;
//								boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
//										ignoreCase, logger);
//								softAssert(
//										"More info side menu header buttons count for '" + txnStatusOne + "' txn. is-",
//										actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
//								// ASSERTION - More info side menu PRINT button displayed-----------
//								boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
//								softAssertTrue("More info side menu PRINT button is displayed -", isPrintButtonDisp,
//										logger);
//
//							} else if (statusText.equalsIgnoreCase(txnStatusTwo))// failed
//							{
//								// ASSERTION - validating buttons count-----------
//								int buttonsCount = moreInfo_headersButtonsList_dmt.size();
//								String actualButtonsCount = String.valueOf(buttonsCount);
//								String expectedButtonsCount = "1";
//								// compare button count.......
//								boolean ignoreCase = false;
//								boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
//										ignoreCase, logger);
//								softAssert(
//										"More info side menu header buttons count for '" + txnStatusTwo + "' txn. is-",
//										actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
//
//								// ASSERTION - More info side menu PRINT button not displayed-----------
//								boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
//								softAssertFalse("More info side menu PRINT button is not displayed -",
//										isPrintButtonDisp, logger);
//
//							} else if (statusText.equalsIgnoreCase(txnStatusThree))// pending
//							{
//
//								// ASSERTION - validating buttons count-----------
//								int buttonsCount = moreInfo_headersButtonsList_dmt.size();
//								String actualButtonsCount = String.valueOf(buttonsCount);
//								String expectedButtonsCount = "1";
//								// compare button count.......
//								boolean ignoreCase = false;
//								boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
//										ignoreCase, logger);
//								softAssert(
//										"More info side menu header buttons count for '" + txnStatusThree
//												+ "' txn. is-",
//										actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
//
//								// ASSERTION - More info side menu PRINT button not displayed-----------
//								boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
//								softAssertFalse("More info side menu PRINT button is not displayed -",
//										isPrintButtonDisp, logger);
//							} else if (statusText.equalsIgnoreCase(txnStatusFour))// processing
//							{
//								// ASSERTION - validating buttons count-----------
//								int buttonsCount = moreInfo_headersButtonsList_dmt.size();
//								String actualButtonsCount = String.valueOf(buttonsCount);
//								String expectedButtonsCount = "1";
//								// compare button count.......
//								boolean ignoreCase = false;
//								boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
//										ignoreCase, logger);
//								softAssert(
//										"More info side menu header buttons count for '" + txnStatusFour + "' txn. is-",
//										actualButtonsCount, expectedButtonsCount, isCountMatching, logger);
//
//								// ASSERTION - More info side menu PRINT button not displayed-----------
//								boolean isPrintButtonDisp = moreInfoSideMenu_isPrintButtonDisplayed();
//								softAssertFalse("More info side menu PRINT button is not displayed -",
//										isPrintButtonDisp, logger);
//
//							}
//
//							// if got other status than the handled status....print/log this info
//							else {
//								logger.log(LogStatus.INFO, "Handled transaction status are -" + txnStatusOne + "/"
//										+ txnStatusTwo + "/" + txnStatusThree + "/" + txnStatusFour);
//								logger.log(LogStatus.INFO, "Captured transaction status is -" + statusText);
//							}
//
//							// after validating all for a txn ....close the more info side bar of that txn.
//
//							Thread.sleep(2000);
//							click_close_lastButton_moreInfoSideBar();
//
//						}
//						// if----More info side menu is open...above actions will happens and
//						// close...........one loop completed HERE
//						else {
//							logger.log(LogStatus.INFO, "More info side menu is close...");
//						}
//					} // for loop close---all conditions are tested for txn. one
//
//				} // get column names----close
//			} // column head navigation----close
//		} // if table has data----close
//
//	}

	public boolean validateALLTxnReportTableHasData() throws InterruptedException {

		logger.log(LogStatus.INFO, "Validate txn. report table has data or not.");
		waitForPageLoaded(driver, logger);
		Thread.sleep(2000);
//scroll to column head		
		scrollElementIntoMiddle(txnTable_head, driver);
		int tableColumnsInFirstRow = txnTable_columnsInFirstRow.size();
		boolean tableHasData;
		if (tableColumnsInFirstRow > 1) {
			tableHasData = true;
		} else {
			tableHasData = false;
		}
		return tableHasData;
	}

	public String getTxnTable_messageIfNoTableData() {

		logger.log(LogStatus.INFO, "Capturing message displayed if table has no data.");

		int columnsNumbersInFirstRow = getTxnTable_columnsInFirstRow();

		String txnTableFirstRowFirstCol_Text = null;
		// columns in 1st row =1 means...no data ...only text message is displayed (if
		// any)
		if (columnsNumbersInFirstRow == 1) {

			txnTableFirstRowFirstCol_Text = txnTable_columnsInFirstRow.get(0).getText();
			logger.log(LogStatus.INFO,
					"Captured message displayed if table has no data is -" + txnTableFirstRowFirstCol_Text);
		}
		return txnTableFirstRowFirstCol_Text;
	}

//write one method to get/fetch data from the column...................
//1...sr no	
	public String getTxnSrNo(int rowNumIndex) throws InterruptedException {

		int rowNum = (rowNumIndex + 1);

		// need to pass tr number but in loop we pass index number that's why get index
		// num as method parameter and pass td number in table XPATH
		WebElement txnTable_row = driver.findElement(By.xpath(
				"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[1]"));

		waitForElementToAppear(txnTable_row, driver, logger);
		scrollElementIntoMiddle(txnTable_row, driver);
		Thread.sleep(2000);
		return txnTable_row.getText();

	}

//2...tid
	public String getTxnID(int rowNumIndex) throws InterruptedException {

		int rowNum = (rowNumIndex + 1);

		// need to pass tr number but in loop we pass index number that's why get index
		// num as method parameter and pass td number in table XPATH
		WebElement txnTable_row = driver.findElement(By.xpath(
				"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[2]"));

		waitForElementToAppear(txnTable_row, driver, logger);
		scrollElementIntoMiddle(txnTable_row, driver);
		Thread.sleep(2000);
		return txnTable_row.getText();
	}

//3...inventory...cat,service,operator	
	public String getTxnService(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);

		WebElement txn_service = driver
				.findElement(By.xpath("//table[@id='pr_id_13-table']/tbody/tr[" + rowNum + "]/td[3]/span[1]"));
		waitForElementToAppear(txn_service, driver, logger);
		scrollElementIntoMiddle(txn_service, driver);
		String txnServiceInTablePair = txn_service.getText();
		String serviceOfTxn = txnServiceInTablePair.replace("Service: ", "");

		return serviceOfTxn;
	}

	public String getTxnCategory(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);
		WebElement txn_category = driver
				.findElement(By.xpath("//table[@id='pr_id_13-table']/tbody/tr[" + rowNum + "]/td[3]/span[2]"));
		waitForElementToAppear(txn_category, driver, logger);
		scrollElementIntoMiddle(txn_category, driver);
		String txnCategoryInTablePair = txn_category.getText();
		String categoryOfTxn = txnCategoryInTablePair.replace("Category: ", "");
		return categoryOfTxn;
	}

	public String getTxnOperator(int rowNumIndex) {
		int rowNum = (rowNumIndex + 1);

		WebElement txn_operator = driver
				.findElement(By.xpath("//table[@id='pr_id_13-table']/tbody/tr[" + rowNum + "]/td[3]/span[3]"));

		waitForElementToAppear(txn_operator, driver, logger);
		scrollElementIntoMiddle(txn_operator, driver);
		String txnOperatorInTablePair = txn_operator.getText();
		String operatorOfTxn = txnOperatorInTablePair.replace("Operator: ", "");

		return operatorOfTxn;
	}

	// 4...mob number
	public void getTxnMobNumber(int rowNumIndex) {

	}

	// 5...amount
	public void getTxnAmount(int rowNumIndex) {

	}

	// 6...totalAmount
	public void getTxnTotalAmount(int rowNumIndex) {

	}

	// 7...status
	public String getTxnStatus(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);

		WebElement txn_status = driver
				.findElement(By.xpath("//table[@id='pr_id_13-table']/tbody/tr[" + rowNum + "]/td[7]/span"));

		waitForElementToAppear(txn_status, driver, logger);
		scrollElementIntoMiddle(txn_status, driver);
		String statusOfTxn = txn_status.getText();
		return statusOfTxn;

	}

	// 8...date
	public void getTxnDate(int rowNumIndex) {

	}

	// 9...is settled value
	public void getTxnIsSettled(int rowNumIndex) {

	}

//3.ALL TRANSACTION TABLE methods END ##################################################################################

//4.MORE INFO side bar methods START ##################################################################################

	// 10...moreInfo
	public void OpenMoreInfoOfTxnPopup(int txnNoIndex) throws InterruptedException, IOException {

		int txnNo = (txnNoIndex + 1);
//validate if table has data...before opening more info side menu bar-----
		logger.log(LogStatus.INFO, "Open 'More info.' side bar of the transaction -" + txnNo);
		int colNos = getTxnTable_columnNumbersHEAD(); // last column has 'more info (meatball)' icon so last column
														// number should be used
		WebElement moreInfoIcon = driver.findElement(By.xpath(
				"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
						+ txnNo + "]/td[" + colNos + "]/a/i"));
		waitForPageLoaded(driver, logger);
		waitToBeClickable(moreInfoIcon, driver);
		scrollElementIntoMiddle(moreInfoIcon, driver);
		logger.log(LogStatus.INFO, "Click more info (meatball) icon OPEN -" + txnNo);
		click(moreInfoIcon, driver, logger);
		highlightElement(moreInfoIcon, "Red", driver, logger);
		Thread.sleep(2000);

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

//		scrollElementIntoMiddle(sideBarHeader_textORTitle, driver);
		int moreInfoHeaderButtonsNo = moreInfo_headersButtonsList_dmt.size();
		int moreInfoHeaderLastButtonIndex = (moreInfoHeaderButtonsNo - 1);
		try {
			for (int a = 0; a <= moreInfoHeaderLastButtonIndex; a++) {

				// if buttons list is 1 => then enter this if condition and click this button (1
				// button must be the CLOSE button)
				if (moreInfoHeaderButtonsNo == 1) {
					logger.log(LogStatus.INFO, "More Info side bar has ONE button only");
					logger.log(LogStatus.INFO, "Click close / 'X' button");
//if button is 1 it has index 0
					WebElement requiredButton_close = moreInfo_headersButtonsList_dmt.get(a);
					click(requiredButton_close, driver, logger);
				}
				// if buttons list is greater than one =>
				else {
					logger.log(LogStatus.INFO, "More Info side bar has MORE buttons ");
					// ASSUMPTION / CONDITION - close button must be LAST button.........
					// passing STATIC last index no as 'moreInfoHeaderLastButton'
//if buttons are more than 1 navigate/click to last button

					WebElement requiredButton_LAST = moreInfo_headersButtonsList_dmt.get(moreInfoHeaderLastButtonIndex);
					logger.log(LogStatus.INFO, "Click close / 'X' (Last) button");
					click(requiredButton_LAST, driver, logger);
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO,
					"Failed to click the close button from more info side bar.</br>CLOSE button is not the last button as LOGIC applied.");
			logger.log(LogStatus.INFO, "Captured exception is -" + e);
		}
	}

	public void click_firstButton_moreInfoSideBar() throws InterruptedException {
//		scrollElementIntoMiddle(sideBarHeader_textORTitle, driver);
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
//		scrollElementIntoMiddle(sideBarHeader_textORTitle, driver);
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

	public boolean moreInfo_headerHasOneButton() {

		logger.log(LogStatus.INFO, "Validating - more info side bar has ONE button only");
		waitForElementToAppear(sideBarHeader_textORTitle, driver, logger);
//		scrollElementIntoMiddle(sideBarHeader_textORTitle, driver);
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

	public boolean moreInfoSideMenu_isPrintButtonDisplayed() throws IOException {

		boolean printButtonDisp;
		logger.log(LogStatus.INFO, "Verifying more info side menu PRINT button is displayed or not");
		try {
			printButtonDisp = isPresentAndDisplayed(printButton_moreInfoSideBar, driver, logger);

			if (printButtonDisp) {
				logger.log(LogStatus.INFO, "More info side menu PRINT button is displayed");
				highlightElement(printButton_moreInfoSideBar, "Red", driver, logger);
				screenshotInReport("More info side menu PRINT button is displayed -", driver, logger);
				printButtonDisp = true;
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.INFO, "More info side menu PRINT button element is not displayed");
			screenshotInReport("More info side menu PRINT button is not displayed -", driver, logger);
			printButtonDisp = false;
		}
		return printButtonDisp;
	}

	public boolean moreInfoSideMenu_isRaiseComplaintButtonDisplayed() throws IOException {

		boolean raiseComplaintDisp;

		logger.log(LogStatus.INFO, "Verifying more info side menu RAISE COMPLAINT button is displayed or not");
		try {
			raiseComplaintDisp = isPresentAndDisplayed(raiseComplaintButton_moreInfoSideBar, driver, logger);

			if (raiseComplaintDisp) {
				logger.log(LogStatus.INFO, "More info side menu RAISE COMPLAINT button is displayed");
				highlightElement(raiseComplaintButton_moreInfoSideBar, "Red", driver, logger);
				screenshotInReport("More info side menu RAISE COMPLAINT button is displayed -", driver, logger);
				raiseComplaintDisp = true;
			}
		} catch (NoSuchElementException e) {
			logger.log(LogStatus.INFO, "More info side menu RAISE COMPLAINT button element is not displayed");
			screenshotInReport("More info side menu RAISE COMPLAINT button is not displayed -", driver, logger);
			raiseComplaintDisp = false;
		}
		return raiseComplaintDisp;
	}

	public boolean isMoreInfoSideBarDisplayed() throws InterruptedException, IOException {

		boolean isMoreInfoSideBarDisplayed;

		boolean moreInfoSideMenuIsOpen = isPresentAndDisplayed(moreinfoSideBar, driver, logger);
		Thread.sleep(1000);

		if (moreInfoSideMenuIsOpen) {
			logger.log(LogStatus.INFO, "More Info side bar is displayed/open.");
			highlightElement(moreinfoSideBar, "Red", driver, logger);
			screenshotInReport("More Info side bar is displayed -", driver, logger);
			isMoreInfoSideBarDisplayed = true;
		} else {
			logger.log(LogStatus.INFO, "More Info side bar is not displayed/open.");
			screenshotInReport("More Info side bar is not displayed -", driver, logger);
			isMoreInfoSideBarDisplayed = false;
		}

		return isMoreInfoSideBarDisplayed;
	}

	public int getMoreInfoTable_paramNameListSize() {
		int num = moreInfoTable_paramNameList.size();
		return num;
	}

	public int getMoreInfoTable_paramValueListSize() {
		int num = moreInfoTable_paramValueList.size();
		return num;
	}

	public String getMoreInfoTable_paramName(int paramNoIndex) {
		return moreInfoTable_paramNameList.get(paramNoIndex).getText();
	}

	public String getMoreInfoTable_paramValue(int paramValueIndex) {
		return moreInfoTable_paramValueList.get(paramValueIndex).getText();
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

		scrollElementIntoMiddle(paginationWebElement, driver);
		int paginationButtons = paginationsAllButtons.size();
		for (int a = 0; a < paginationButtons; a++) {
			boolean buttonActive = paginationsAllButtons.get(a).isEnabled();

			if (buttonActive) {

			} else {

			}
		}
	}

//need to update....handle a scenario-------------
	public boolean isDataFetchedAccordingToPageSizeSelected() throws IOException, InterruptedException {
// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI S SCENARIO ????????????????????????????????????????????????????????????????????????
//FOR AASERTION++++++if table has less data than page data size....how to know the VALID data count++++++++++++++++++++++++++++++++++++++++++++++...................?????????????????????????????????????	
		// Boolean vs
		// boolean+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		logger.log(LogStatus.INFO, "Validating is Data Fetched According To PageSize Selected");
		waitForPageLoaded(driver, logger);
		boolean dataInTable = validateALLTxnReportTableHasData();
		Boolean flag = null;

		// page size selected
		int pageDataSizeSelected = Integer.parseInt(get_perPageDataSize());

// if table has data		
		if (dataInTable) {
			scrollElementIntoMiddle(pageSizeDropdown, driver);
			// table data count
			int tableRows = getTxnTable_rowNumbers();
			// => scenario 1- table data is equal to or more than page size selected
			if (tableRows >= pageDataSizeSelected) {
				logger.log(LogStatus.INFO, "table data >= page size selected");
				if (tableRows == pageDataSizeSelected) {
					logger.log(LogStatus.INFO, "table data = page size selected");
					logger.log(LogStatus.INFO,
							"Table Data  -" + tableRows + "</br>Page Size Selected -" + pageDataSizeSelected);
					flag = true;
				} else {
					logger.log(LogStatus.INFO, "table data count and page size selected has MISMATCH");
					logger.log(LogStatus.INFO,
							"Table Data Count -" + tableRows + "</br>Page Size Selected -" + pageDataSizeSelected);
					flag = false;
				}
				// return flag;
			} else if (tableRows < pageDataSizeSelected) {
				// => scenario 2- table has data - data is less than page size selected
				// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI
				// S SCENARIO
				// ????????????????????????????????????????????????????????????????????????
				logger.log(LogStatus.INFO,
						"table data < page size selected.</br>FIND A WAY TO ASSERT THIS SCENARIO.....PLEASE");
				logger.log(LogStatus.INFO,
						"table Data Count -" + tableRows + "</br>page Size Selected -" + pageDataSizeSelected);
				flag = null;
				logger.log(LogStatus.INFO, "Returning null flag -" + flag);
			} else {

			}
		} // close-----table has data

		else
// if table has no data
		{
			logger.log(LogStatus.INFO, "Table has no data.</br>Page Size Selected is -" + pageDataSizeSelected);
			// what will return if table has no data....for ASSERTION
		}
		return flag;

	}

//working.......fine..........
	public void validate_tableDataAndTextMessage() throws IOException, InterruptedException {

		logger.log(LogStatus.INFO, "validating - tableData And TextMessage");

		// 1.check - table has data or not
		Thread.sleep(2000);
		waitForPageLoaded(driver, logger);
		boolean dataInTable = validateALLTxnReportTableHasData();

		boolean ignoreCase, firstNumIsmatching, lastNumIsmatching, totalIsmatchingInTableHasNoData;
		String firstNum = null, lastNum = null, totalTxns = null;

//1a. if table has data
		if (dataInTable) {

			// Get first and last txn Sr. No. and capture screenshot in
			// log------------------------------------
			// pasing 0 index number to get sr no of 1st tr / data
			int firstTxnIndex = 0;
			String firstTxnSrNo = getTxnSrNo(firstTxnIndex);
			screenshotInReport("Capture Sr.No. of first Txn. -", driver, logger);
			// 'getTxnTable_rowNumbers' method accepts intexNumber as it's parameter
			int tableRows = getTxnTable_rowNumbers();
			int tableRowIndex = (tableRows - 1);
			String lastTxnSrNo = getTxnSrNo(tableRowIndex);
			screenshotInReport("Capture Sr.No. of last Txn. -", driver, logger);

			// find first and last number of record according to PAGE BOTTOM
			// MESSAGE---------------------------
			String msgAtPageBottom = getPage_paginationDataCountingMsg();
			String[] splittedMsg = msgAtPageBottom.split(" ");// the index number of the numbers must be same (should
			firstNum = null;
			lastNum = null;
			totalTxns = null;
			for (int splittedMsgtextIndex = 0; splittedMsgtextIndex < splittedMsg.length; splittedMsgtextIndex++) {

				if (splittedMsgtextIndex == 0 || splittedMsgtextIndex == 2 || splittedMsgtextIndex == 4
						|| splittedMsgtextIndex == 6) {
					continue;
				} else {
					if (splittedMsgtextIndex == 1) {
						firstNum = splittedMsg[splittedMsgtextIndex];
					} else if (splittedMsgtextIndex == 3) {
						lastNum = splittedMsg[splittedMsgtextIndex];
					} else if (splittedMsgtextIndex == 5) {
						totalTxns = splittedMsg[splittedMsgtextIndex];
					}
				}
			}
			// we have first,last,total txn number
			logger.log(LogStatus.INFO,
					"1 st no. in table -" + firstTxnSrNo + "</br>1 st no.in message - " + firstNum
							+ "</br>last no. in table -" + lastTxnSrNo + "</br>last no.in message - " + lastNum
							+ "</br>total in message -" + totalTxns);
			ignoreCase = false;
			// assert - first number is matching or not
			firstNumIsmatching = compareString(firstTxnSrNo, firstNum, ignoreCase, logger);
			softAssert("validate-first number of record according to PAGE BOTTOM MESSAGE", firstTxnSrNo, firstNum,
					firstNumIsmatching, logger);
			// assert - last number is matching or not
			lastNumIsmatching = compareString(lastTxnSrNo, lastNum, ignoreCase, logger);
			softAssert("validate-last number of record according to PAGE BOTTOM MESSAGE", lastTxnSrNo, lastNum,
					lastNumIsmatching, logger);
		} else
// 1b-if table has no data =>
		{
			logger.log(LogStatus.INFO, "Table has no data");
			screenshotInReport("Txn. count displayed if table has no data -", driver, logger);

			ignoreCase = false;
//passing static value = 0 as table has no data....can't read sr.no. of txn as table has no txn./data
			String firstNumFromTable = "0";
			String lastNumFromtable = "0";
			String totalNumFromtable = "0";
			// assert - first number is matching or not
			firstNumIsmatching = compareString(firstNumFromTable, firstNum, ignoreCase, logger);
			softAssert("validate-first number of record according to PAGE BOTTOM MESSAGE", firstNumFromTable, firstNum,
					firstNumIsmatching, logger);
			// assert - last number is matching or not
			lastNumIsmatching = compareString(lastNumFromtable, lastNum, ignoreCase, logger);
			softAssert("validate-last number of record according to PAGE BOTTOM MESSAGE", lastNumFromtable, lastNum,
					lastNumIsmatching, logger);
			// assert - total number is matching or not
			totalIsmatchingInTableHasNoData = compareString(totalNumFromtable, totalTxns, ignoreCase, logger);
			softAssert("validate-total number of record according to PAGE BOTTOM MESSAGE", totalNumFromtable, totalTxns,
					totalIsmatchingInTableHasNoData, logger);
		}
	}

	public void captureScreenshot_firstAndLastTxn() throws IOException, InterruptedException {

		boolean dataInTable = validateALLTxnReportTableHasData();

		if (dataInTable) {
			// Get first and last txn Sr. No. and capture screenshot in
			// log------------------------------------
			// pasing 0 index number to get sr no of 1st tr / data
			int firstTxnIndex = 0;
			String firstTxnSrNo = getTxnSrNo(firstTxnIndex);
			Thread.sleep(2000);
			screenshotInReport("Capture Sr.No. of first Txn. -", driver, logger);

			// 'getTxnTable_rowNumbers' method accepts intexNumber as it's parameter
			int tableRows = getTxnTable_rowNumbers();
			int tableRowIndex = (tableRows - 1);
			String lastTxnSrNo = getTxnSrNo(tableRowIndex);
			Thread.sleep(2000);
			screenshotInReport("Capture Sr.No. of last Txn. -", driver, logger);
		} else {
			logger.log(LogStatus.INFO, "Table has no data.");
			screenshotInReport("Table has no data -", driver, logger);
		}
	}

	public String get_perPageDataSize() {

		logger.log(LogStatus.INFO, "Fetch per page data size");
		waitForElementToAppear(page_dataPerPageNumber, driver, logger);
		scrollElementIntoMiddle(page_dataPerPageNumber, driver);

		String dataPerPageNo = null;
		try {
			dataPerPageNo = page_dataPerPageNumber.getText();
			logger.log(LogStatus.INFO, "Fetched per page data size -" + dataPerPageNo);
			return dataPerPageNo;
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Data per page dropdown has no value");
			logger.log(LogStatus.INFO, e);
		}
		return dataPerPageNo;
	}

	public void click_navigate_firstPageButton() {

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
		scrollElementIntoMiddle(paginationWebElement, driver);
//FIRST PAGE button is at ZERO index, so passing static value = 0			
		WebElement firstPageIconElement = paginationsAllButtons.get(0);
		boolean buttonEnabled = firstPageIconElement.isEnabled();
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
		scrollElementIntoMiddle(paginationWebElement, driver);

//PREVIOUS PAGE button is at ONE index, so passing static value = 1			
		WebElement prevPageIconElement = paginationsAllButtons.get(1);
		boolean buttonEnabled = prevPageIconElement.isEnabled();
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
//		scrollElementIntoMiddle(paginationWebElement, driver);
		scrollDown(driver);

		// NEXT PAGE button is at TWO index, so passing static value = 2
		WebElement nextPageIconElement = paginationsAllButtons.get(2);
		boolean buttonEnabled = nextPageIconElement.isEnabled();

		logger.log(LogStatus.INFO, "click next page button");

		if (buttonEnabled) {
			logger.log(LogStatus.INFO, "next page button is enabled -" + buttonEnabled);
			scrollElementIntoMiddle(nextPageIconElement, driver);
			click(nextPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "next page button is DISABLED");
		}
	}

	public void click_navigate_lastPageButton() {

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
//		scrollElementIntoMiddle(paginationWebElement, driver);
		scrollDown(driver);

//LAST PAGE button is at THREE index, so passing static value = 3			
		WebElement lastPageIconElement = paginationsAllButtons.get(3);
		boolean buttonEnabled = lastPageIconElement.isEnabled();

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

		logger.log(LogStatus.INFO, "scroll to page size dropdown");
		scrollElementIntoMiddle(pageSizeDropdown, driver);
		waitForElementToAppear(pageSizeDropdown, driver, logger);
//		scrollDown(driver);
		logger.log(LogStatus.INFO, "Click page size dropdown");
		click(pageSizeDropdown, driver, logger);
	}

	public void changeCount_DataPerPage(int dataPerPage) {
// ASSUMPTION - page sizes are -10,25,50
//below method used data sizes from the dropdown...if needed use same logic to fetch PAGE DATA SIZES

		waitForElementToAppear(pageSizeDropdown, driver, logger);
//		scrollElementIntoMiddle(pageSizeDropdown, driver);
		scrollDown(driver);

//navigate and click on page size dropdown		
		click_pageSizeDropdown();

//select a value from dropdown (index base so start from 0)		
		try {
			if (dataPerPage == 10) {
				waitForElementToAppear(perPageDataOptions.get(0), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				scrollElementIntoMiddle(perPageDataOptions.get(0), driver);
				click(perPageDataOptions.get(0), driver, logger);

			} else if (dataPerPage == 25) {
				waitForElementToAppear(perPageDataOptions.get(1), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				scrollElementIntoMiddle(perPageDataOptions.get(1), driver);
				click(perPageDataOptions.get(1), driver, logger);
			} else if (dataPerPage == 50) {
				waitForElementToAppear(perPageDataOptions.get(2), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				scrollElementIntoMiddle(perPageDataOptions.get(2), driver);
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

		logger.log(LogStatus.INFO, "validating data Per Page With All Page Sizes");
//----------------------------------------

//add this to a method to get ' pageSizeOptionsCount'++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		

		// scroll and click on page size dropdown to get numbers of the options
		click_pageSizeDropdown();
		// select a value from dropdown (index base so start from 0)
		scrollElementIntoMiddle(pageSizeDropdown, driver);
		Thread.sleep(1000);
		int pageSizesToSelect = perPageDataOptions.size();
//----------------------------------------------------		
		String dataSizeText;

		// for loop will fetch all options (page sizes) available in dropdown
		for (int pageSizeIndex = 0; pageSizeIndex < pageSizesToSelect; pageSizeIndex++) {

			// scroll to next page size as we will click on next page size in next ITERATION
			WebElement pageSizeWE = perPageDataOptions.get(pageSizeIndex);
			dataSizeText = pageSizeWE.getText();
			scrollElementIntoMiddle(pageSizeWE, driver);
			Thread.sleep(1000);
//click data size option 1 (according to index no.) 
			click(pageSizeWE, driver, logger);
			logger.log(LogStatus.INFO, "clicked/selected page size is -" + dataSizeText);
			waitForPageLoaded(driver, logger);
			Thread.sleep(5000);
// m1...
//			validate_pageSizeSelectedAndDataPerPageFetched();
//m2...			
			validate_tableDataAndTextMessage();
//wait for table loading after changing the data numbers displayed on page
//			logger.log(LogStatus.INFO, "validation done (loop no. completed) -" + (a + 1));
//
//			waitForPageLoaded(driver, logger);
//		       scrollElementIntoMiddle(pageSizeDropdown, driver);
//			// click page size dropdown to get data size OPTIONS for second loop (if
//			// dropdown is close the loop
//			click_pageSizeDropdown();
//			// scroll to next page size as we will click on next page size in next ITERATION
//		       scrollElementIntoMiddle(perPageDataOptions.get(a), driver);
			click_pageSizeDropdown();
			Thread.sleep(1000);

		}

	}

	public String getCurentPageNumber() {
		waitForElementToAppear(curentPageNumber, driver, logger);
//		scrollElementIntoMiddle(curentPageNumber, driver);
		scrollDown(driver);
		String pageNo = curentPageNumber.getText();
		logger.log(LogStatus.INFO, "Current page number is -" + pageNo);
		return pageNo;
	}

	public String getPage_paginationDataCountingMsg() {

		waitForElementToAppear(page_paginationDataCountingMsg, driver, logger);
//		scrollElementIntoMiddle(page_paginationDataCountingMsg, driver);
		scrollDown(driver);
		logger.log(LogStatus.INFO, "Pagination data counting msg. is -" + page_paginationDataCountingMsg.getText());
		return page_paginationDataCountingMsg.getText();
	}

//incomplete............	
	public int getPageCountToNavigateDisplayedAtPageBottom() throws InterruptedException {
		// 1.check - table has data or not
		waitForPageLoaded(driver, logger);
		boolean dataInTable = validateALLTxnReportTableHasData();

		waitForElementToAppear(paginationWebElement, driver, logger);
		scrollElementIntoMiddle(paginationWebElement, driver);

		if (dataInTable) {
			int pageNumbersCount = pageNumbersCountDisplayedAtPageBottom.size();
			return pageNumbersCount;
		} else
		// 1b-no =>
		{
			logger.log(LogStatus.INFO, "No data in table.... ");
		}
		return 0;
	}

	public void get_perPageDataOptions(int indexNo) {

		perPageDataOptions.get(indexNo);
	}

	// AEPS tab...............................

	public void click_printButton_aepsMoreInfoSideBar() {

		waitForElementToAppear(printButton_moreInfoSideBar, driver, logger);

		try {

			logger.log(LogStatus.INFO, "Click print button at AEPS transaction more info side bar");
			click(printButton_moreInfoSideBar, driver, logger);
		} catch (Exception e) {

			logger.log(LogStatus.INFO, "Failed click print button at AEPS transaction more info side bar");
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

	public void inProgressMMMTTHHOOODD() {

	}

	public void compareAPIvaluesWithUIvalues() {

		// TC001_TransactionHistoryAPI

	}

}

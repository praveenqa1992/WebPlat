package pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.tools.ant.filters.TokenFilter.Trim;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;

public class SearchTransactionPOM extends commonFunc {

	public WebDriver driver;
	public ExtentTest logger;
	public WebElement Element;

//1.navigate to page elements ########################################################

	@FindBy(xpath = "//div[@class='second-sidemenu']")
	public WebElement secondSideMenu;

	@FindBy(xpath = "//i[@data-name='chevrons-left']")
	public WebElement secondSideMenu_openORClose;

	@FindBy(xpath = "//span[text()='Reports']")
	public WebElement reportsModule_sideMenuBar;

	@FindBy(xpath = "//a [text()=' Search Transaction']")
	public WebElement searchTxnModule_sideMenuBar_second;

	@FindBy(xpath = "//div[@class='col-md-8']")
	public WebElement cardTitle_searchTxnHistory;

//2.page top elements #################################################################

//	@FindBy(xpath = "//select[@class='form-select selectDrp ng-pristine ng-valid ng-touched']")
//	public WebElement filterDropdownOptions_selectWE;

//	@FindBy(xpath = "//select[@class='form-select selectDrp ng-pristine ng-valid ng-touched']/option")
//	public List<WebElement> filterDropdownOptions;

	@FindBy(xpath = "//div[@class='col-md-2 form-group']")
	public WebElement filterDropdown;

	@FindBy(xpath = "//div[@class='col-md-2 form-group']/select")
	public WebElement filterDropdown_selectWE;

	@FindBy(xpath = "//div[@class='col-md-2 form-group']/select/option")
	public List<WebElement> filterDropdown_options;

	@FindBy(xpath = "//input[@type='search'] [@placeholder='Search']")
	public WebElement searchInputField;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchButton;

	// 3. table elements #######################################################

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']")
	public WebElement searchTxnTable;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/thead/tr/th")
	public List<WebElement> searchTxnTable_columnsHEAD;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr[1]/td")
	public List<WebElement> table_columnsInFirstRow;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/thead")
	public WebElement searchTxnTable_head;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr")
	public List<WebElement> searchTxnTable_rows;

	@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr/td")
	public List<WebElement> searchTxnTable_allColumnsAllData;

	// More info. side menu bar
	// #################################################################################################

	// modify....static x path of 1st txn

//		@FindBy(xpath = "//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr[1]/td[14]")
//		public WebElement txnMoreInfo_Icon;

	@FindBy(xpath = "//div[@id='offcanvasRight']")
	public WebElement moreinfoSideBar;

	@FindBy(xpath = "//div[@id='offcanvasRight']//child::h5")
	public WebElement sideBarHeader_textORTitle;

	// 1.dmt more info side bar =>pending,failed txn. has one button (close)
	// only...success txn. has 3 buttons (1-Single, 2-Bulk, 3-Close)
	// same xpath can be used for other tabs...list will have 1 button only
	@FindBy(xpath = "//div[@id='offcanvasRight']//child::button")
	public List<WebElement> moreInfo_headersButtonsList;

//print and raise complaint BUTTON xpath is not VALIDATEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD	
	@FindBy(xpath = "//div[@class='ng-star-inserted']/a")
	public WebElement printButton_moreInfoSideBar;
	//print and raise complaint BUTTON xpath is not VALIDATEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD	

	@FindBy(xpath = "//button[@class='btn btn-primary trigg-btn px-2 fs-13 c-pointer ng-star-inserted']")
	public WebElement raiseComplaintButton_moreInfoSideBar;
	                 
	@FindBy(xpath = "//div[@id='offcanvasRight']//table/tbody/tr[1]/td[1]")
	public List<WebElement> moreInfoTable_paramNameList;

	@FindBy(xpath = "//div[@id='offcanvasRight']//table/tbody/tr[1]/td[2]/span")
	public List<WebElement> moreInfoTable_paramValueList;

	
	//print and raise complaint BUTTON xpath is not VALIDATEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD	

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

	

	// 4. pagination elements ##################################################

	@FindBy(xpath = "//p-paginator[@class='p-element ng-star-inserted']")
	public WebElement paginationWebElement;

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	public WebElement page_paginationDataCountingMsg;

	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']//child::button")
	public List<WebElement> bottom_PagenumbersDisplayed;

	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']")
	public WebElement curentPageNumber;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")
	public WebElement dataPerPageField;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']//following::div[@class='p-dropdown-trigger']")
	public WebElement pageSizeDropdown;

	@FindBy(xpath = "//div[@class='p-dropdown-items-wrapper']/ul/p-dropdownitem/li")
	public List<WebElement> perPageDataOptions;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")
	public WebElement page_dataPerPageNumber;

//	@FindBy(xpath = "//div[@class='p-paginator-rpp-options p-dropdown p-component p-disabled']")
//	public WebElement page_dataPerPageNumber;

	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']/button")
	public List<WebElement> paginationsAllButtons;

	// 5. constructor ###########################################################

	public SearchTransactionPOM(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

//1.navigate to page methods ##########################################

	public boolean secondSideMenu_isDisplayed() {
		logger.log(LogStatus.INFO, "validate secondSideMenu_isDisplayed");
		return secondSideMenu.isDisplayed();

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

	public void click_reportsModule_sideMenuBar() throws IOException, InterruptedException {
//		scrollUp(driver);
		Thread.sleep(2000);
		secondSideMenu_close();

		waitForPageLoaded(driver, logger);
		scrollElementIntoMiddle(reportsModule_sideMenuBar, driver);
		logger.log(LogStatus.INFO, "click_reportsModule_sideMenuBar");
		click(reportsModule_sideMenuBar, driver, logger);

	}

	public void click_searchTxnModule_sideMenuBar_second() {
		waitForElementToAppear(searchTxnModule_sideMenuBar_second, driver, logger);
		logger.log(LogStatus.INFO, "click click_searchTxnModule_sideMenuBar_second");
		click(searchTxnModule_sideMenuBar_second, driver, logger);
	}

//2.page top methods ###############################################################

	public void click_filterDropdown() {
		waitForElementToAppear(filterDropdown, driver, logger);
		scrollElementIntoMiddle(filterDropdown, driver);
		logger.log(LogStatus.INFO, "click_filterDropdown");
		click(filterDropdown, driver, logger);
	}

	public void enterText_filterValue(String searchParameter) {
		sendingKeys(searchInputField, searchParameter, driver, logger);
	}

	public void click_searchButton() {
		waitForElementToAppear(searchButton, driver, logger);
		scrollElementIntoMiddle(searchButton, driver);
		click(searchButton, driver, logger);
		logger.log(LogStatus.INFO, "click_searchButton");
	}

	public void getOptionsList_filterSelectDropdown() throws InterruptedException {

		click(filterDropdown, driver, logger);
		Thread.sleep(500);
		int optNos = filterDropdown_options.size();
		logger.log(LogStatus.INFO, "List of the valid dropdown/filter option is -");
		for (int a = 0; a < optNos; a++) {
			String optionFromDropdown = filterDropdown_options.get(a).getText().trim();
			logger.log(LogStatus.INFO, (a + 1) + "." + optionFromDropdown);
		}
	}

	public void selectFromDropdown(String optToSelect) throws InterruptedException {

		logger.log(LogStatus.INFO, "Select option from the dropdown");

		logger.log(LogStatus.INFO, "click filterDropdown");
		click(filterDropdown, driver, logger);
		Thread.sleep(1000);
		Select select = new Select(filterDropdown_selectWE);
		// select.selectByVisibleText("RRN");

		logger.log(LogStatus.INFO, "1............");

		boolean isOptSelected = false;
		logger.log(LogStatus.INFO, "2............");

		select.getOptions();

		for (WebElement optElement : select.getOptions()) {
			String dropOptOne = optElement.getText().trim();
			if (dropOptOne.equalsIgnoreCase(optToSelect)) {
				logger.log(LogStatus.INFO, "3............");

				logger.log(LogStatus.INFO, "Select option -" + dropOptOne);
				highlightElement(optElement, "Red", driver, logger);
				click(optElement, driver, logger);
				logger.log(LogStatus.INFO, "4............");

				isOptSelected = true;
				break;
			} else {
				logger.log(LogStatus.INFO, "5............");

				isOptSelected = false;
				logger.log(LogStatus.INFO, "6............");

			}
		}
		if (!isOptSelected) {
			logger.log(LogStatus.INFO, "7............");

			logger.log(LogStatus.INFO, "Invalid filter -" + optToSelect + "</br>Please refer valid filter list.");
			getOptionsList_filterSelectDropdown();
			logger.log(LogStatus.INFO, "8............");

		}
	}

	// 3. table methods ############################################################

	public int getTable_columnNumbersHEAD() {
		waitForPageLoaded(driver, logger);
		scrollElementIntoMiddle(searchTxnTable_head, driver);
		return searchTxnTable_columnsHEAD.size();
	}

//we calculate number of columns in first row...if col=1 (table has no data)...	
	public int getTable_columnsInFirstRow() {
		waitForPageLoaded(driver, logger);
		scrollElementIntoMiddle(searchTxnTable_head, driver);
		return table_columnsInFirstRow.size();
	}

	public int getTable_rowNumbers() throws InterruptedException {
		Thread.sleep(5000);
		waitForPageLoaded(driver, logger);
		return searchTxnTable_rows.size();

	}

	// write one method to get/fetch data from the column...................
	// 1...sr no
	public String getTxnSrNo(int rowNumIndex) throws InterruptedException {

		int rowNum = (rowNumIndex + 1);

		// need to pass tr number but in loop we pass index number that's why get index
		// num as method parameter and pass td number in table XPATH
		WebElement txnTable_row = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[1]"));

		waitForElementToAppear(txnTable_row, driver, logger);
		scrollElementIntoMiddle(txnTable_row, driver);
		highlightElement(txnTable_row, "Red", driver, logger);
		Thread.sleep(2000);
		return txnTable_row.getText().trim();

	}

	// 2...user details
	public String getTxnUserDetails(int rowNumIndex) throws InterruptedException {

		int rowNum = (rowNumIndex + 1);
		// need to pass tr number but in loop we pass index number that's why get index
		// num as method parameter and pass td number in table XPATH
		WebElement txnTable_row = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[2]/span"));
		waitForElementToAppear(txnTable_row, driver, logger);
		scrollElementIntoMiddle(txnTable_row, driver);
		Thread.sleep(2000);
		return txnTable_row.getText().trim();
	}

	// 3...user txn id
	public String getTxnId(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);
		WebElement txnTable_row = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[3]//span"));
		waitForElementToAppear(txnTable_row, driver, logger);
		scrollElementIntoMiddle(txnTable_row, driver);

		return txnTable_row.getText().trim();
	}

	// 4...inventory...cat,service,operator
	public String getTx1nId(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);

		WebElement txn_service = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[4]//span[1]"));
		waitForElementToAppear(txn_service, driver, logger);
		scrollElementIntoMiddle(txn_service, driver);
		String txnServiceInTablePair = txn_service.getText();
		String serviceOfTxn = txnServiceInTablePair.replace("Service: ", "");

		return serviceOfTxn;
	}

	public String getTxnCategory(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);
		WebElement txn_category = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[4]//span[2]"));
		waitForElementToAppear(txn_category, driver, logger);
		scrollElementIntoMiddle(txn_category, driver);
		String txnCategoryInTablePair = txn_category.getText();
		String categoryOfTxn = txnCategoryInTablePair.replace("Category: ", "");
		return categoryOfTxn;
	}

	public String getTxnOperator(int rowNumIndex) {
		int rowNum = (rowNumIndex + 1);

		WebElement txn_operator = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[4]//span[3]"));

		waitForElementToAppear(txn_operator, driver, logger);
		scrollElementIntoMiddle(txn_operator, driver);
		String txnOperatorInTablePair = txn_operator.getText();
		String operatorOfTxn = txnOperatorInTablePair.replace("Operator: ", "");

		return operatorOfTxn;
	}

	// 5...mobile number
	public String getTxnMobNumber(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);
		WebElement txnTable_row = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[5]//span"));
		waitForElementToAppear(txnTable_row, driver, logger);
		scrollElementIntoMiddle(txnTable_row, driver);
		return txnTable_row.getText().trim();
	}

	// 6...amount
	public String getTxnAmount(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);
		WebElement txnTable_row = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[6]//div"));
		waitForElementToAppear(txnTable_row, driver, logger);
		scrollElementIntoMiddle(txnTable_row, driver);
		return txnTable_row.getText().trim();
	}
	// 7...charge and margine

	// 8...totalAmount
	public void getTxnTotalAmount(int rowNumIndex) {

	}

	// 9...status
	public String getTxnStatus(int rowNumIndex) {

		int rowNum = (rowNumIndex + 1);
		WebElement txn_status = driver.findElement(
	
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ rowNum + "]/td[9]//button"));
		waitForElementToAppear(txn_status, driver, logger);
		scrollElementIntoMiddle(txn_status, driver);
		return txn_status.getText().trim();

	}

	// 10...channel

	// 11...date

	// 12...settle type

	// 13...settle by

	// 3B.MORE INFO side bar methods #####################################
	// 14...moreInfo column of search txn. table

	public void OpenMoreInfoOfTxnPopup(int txnNoIndex) throws InterruptedException, IOException {

		int txnNo = (txnNoIndex + 1);
		// validate if table has data...before opening more info side menu bar-----
		logger.log(LogStatus.INFO, "Open 'More info.' side bar of the transaction -" + txnNo);
		int colNos = getTable_columnNumbersHEAD(); // last column has 'more info (meatball)' icon so last column
													// number should be used
				WebElement moreInfoIcon = driver.findElement(
				By.xpath("//table[@class='p-datatable-table p-datatable-scrollable-table ng-star-inserted']/tbody/tr["
						+ txnNo + "]/td[" + colNos + "]/span"));
		
		
		
		
		waitForPageLoaded(driver, logger);
		waitToBeClickable(moreInfoIcon, driver);
		scrollElementIntoMiddle(moreInfoIcon, driver);
		logger.log(LogStatus.INFO, "Click more info (meatball) icon OPEN ----->" + txnNo);
		click(moreInfoIcon, driver, logger);
		highlightElement(moreInfoIcon, "Red", driver, logger);
		Thread.sleep(2000);
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

	
	
	
	public void click_close_lastButton_moreInfoSideBar() throws InterruptedException {

		// new logic ........

//			scrollElementIntoMiddle(sideBarHeader_textORTitle, driver);
		int moreInfoHeaderButtonsNo = moreInfo_headersButtonsList.size();
		int moreInfoHeaderLastButtonIndex = (moreInfoHeaderButtonsNo - 1);
		try {
			for (int a = 0; a < moreInfoHeaderButtonsNo; a++) {

				// if buttons list is 1 => then enter this if condition and click this button (1
				// button must be the CLOSE button)
				if (moreInfoHeaderButtonsNo == 1) 
				{
					logger.log(LogStatus.INFO, "More Info side bar has ONE button only");
					logger.log(LogStatus.INFO, "Click close / 'X' button");
					// if button is 1 it has index 0
					WebElement requiredButton_close = moreInfo_headersButtonsList.get(a);
					click(requiredButton_close, driver, logger);
				}
				// if buttons list is greater than one =>
				else {
					logger.log(LogStatus.INFO, "More Info side bar has MORE buttons ");
					// ASSUMPTION / CONDITION - close button must be LAST button.........
					// passing STATIC last index no as 'moreInfoHeaderLastButton'
					// if buttons are more than 1 navigate/click to last button

					WebElement requiredButton_LAST = moreInfo_headersButtonsList.get(moreInfoHeaderLastButtonIndex);
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

	
	
	
	
	
	
	

	public void validateMoreInfoSideBarHeaderButtons2() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "Validating transaction MORE INFO side menu buttons count and raise ticket.");

		boolean dataInTable = validateSearchTxnReportTableHasData();
//if table has data
		if (dataInTable) {
			// navigate through column header--------
			int totalColumns = getTable_columnNumbersHEAD();
			for (int colWEindex = 0; colWEindex < totalColumns; colWEindex++) {
				// get column names (index is always less by 1 than column no.)
				int colNo = (colWEindex + 1);
				String colName = searchTxnTable_columnsHEAD.get(colWEindex).getText().trim();
				if (colName.equalsIgnoreCase("Status")) {
					// navigate through each row and get STATUS of each row/txn.--------
					int tableRowsCount = searchTxnTable_rows.size();
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
									int buttonsCount = moreInfo_headersButtonsList.size();
									String actualButtonsCount = String.valueOf(buttonsCount);
									String expectedButtonsCount = "1";
									// compare button count.......
									boolean ignoreCase = false;
									boolean isCountMatching = compareString(actualButtonsCount, expectedButtonsCount,
											ignoreCase, logger);
									softAssert(
											"More info side menu header buttons count for '" + statusTextFromTable
													+ "' txn. is -",
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
									int buttonsCount = moreInfo_headersButtonsList.size();
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
									int buttonsCount = moreInfo_headersButtonsList.size();
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
									int buttonsCount = moreInfo_headersButtonsList.size();
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
									int buttonsCount = moreInfo_headersButtonsList.size();
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
									logger.log(LogStatus.UNKNOWN,
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
									int buttonsCount = moreInfo_headersButtonsList.size();
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
									int buttonsCount = moreInfo_headersButtonsList.size();
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
									int buttonsCount = moreInfo_headersButtonsList.size();

									for (WebElement buttonElement : moreInfo_headersButtonsList) {

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
											sendingKeys(raiseComplaintForm_remarkFielde, remarkText, driver, logger);

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
									int buttonsCount = moreInfo_headersButtonsList.size();
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean validateSearchTxnReportTableHasData() throws InterruptedException {

		logger.log(LogStatus.INFO, "Validate search txn. report table has data or not.");
		waitForPageLoaded(driver, logger);
		Thread.sleep(2000);
//scroll to column head		
		scrollElementIntoMiddle(searchTxnTable_head, driver);

		int tableColumnsInFirstRow = getTable_columnsInFirstRow();
		boolean tableHasData;
		if (tableColumnsInFirstRow > 1) {
			tableHasData = true;
		} else {
			tableHasData = false;
		}
		return tableHasData;
	}

	public String getSearchTxnTable_messageIfNoTableData() {

		logger.log(LogStatus.INFO, "Capturing message displayed if table has no data.");

		int columnsNumbersInFirstRow = getTable_columnsInFirstRow();

		String searchTxnTableFirstRowFirstCol_Text = null;
		// columns in 1st row =1 means...no data ...only text message is displayed (if
		// any)
		if (columnsNumbersInFirstRow == 1) {

			searchTxnTableFirstRowFirstCol_Text = table_columnsInFirstRow.get(0).getText();
			logger.log(LogStatus.INFO, "Captured message displayed if search txn. table has no data is -"
					+ searchTxnTableFirstRowFirstCol_Text);
		}
		return searchTxnTableFirstRowFirstCol_Text;
	}

	public void validateMessageDisplayedIfSearchTxnTableHasNOData(String expectedMessage, boolean ignoreCase,
			ExtentTest logger) throws IOException, InterruptedException {

		boolean dataInTable = validateSearchTxnReportTableHasData();
		if (dataInTable) {
			screenshotInReport("Search txn. table has data -", driver, logger);
		} else {
			String actualMessage = getSearchTxnTable_messageIfNoTableData();
			screenshotInReport("Search txn. table has no data 'message displayed' -", driver, logger);
//compare string
			boolean msgIsCorrect = compareString(actualMessage, expectedMessage, ignoreCase, logger);
//assertion - message displayed		
			softAssert("Message displayed if no data in Txn. table -", actualMessage, expectedMessage, msgIsCorrect,
					logger);

		}
	}

	public void captureScreenshot_firstAndLastTxn() throws IOException, InterruptedException {

		boolean dataInTable = validateSearchTxnReportTableHasData();

		if (dataInTable) {
			// Get first and last txn Sr. No. and capture screenshot in
			// log------------------------------------
			// pasing 0 index number to get sr no of 1st tr / data
			int firstTxnIndex = 0;
			String firstTxnSrNo = getTxnSrNo(firstTxnIndex);
			Thread.sleep(2000);
			screenshotInReport("Capture first Txn. SR.No.-" + firstTxnSrNo, driver, logger);

			// 'getTxnTable_rowNumbers' method accepts intexNumber as it's parameter
			int tableRows = getTable_rowNumbers();
			int tableRowIndex = (tableRows - 1);
			String lastTxnSrNo = getTxnSrNo(tableRowIndex);
			Thread.sleep(2000);
			screenshotInReport("Capture last Txn. Sr.No. -" + lastTxnSrNo, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "Search txn. table has no data.");
			screenshotInReport("Search txn. table has no data -", driver, logger);
		}
	}

	// 4. pagination methods #################################################

	public String get_perPageDataSize() {

		logger.log(LogStatus.INFO, "Fetch per page data size");
		waitForElementToAppear(page_dataPerPageNumber, driver, logger);
		scrollElementIntoMiddle(page_dataPerPageNumber, driver);

		String dataPerPageNo = null;
		try {
			scrollDown(driver);
			dataPerPageNo = page_dataPerPageNumber.getText();
			logger.log(LogStatus.INFO, "Fetched per page data size -" + dataPerPageNo);
			return dataPerPageNo;
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Data per page dropdown has no value");
			logger.log(LogStatus.INFO, e);
		}
		return dataPerPageNo;
	}

	// need to update....handle a scenario-------------
	public boolean isDataFetchedAccordingToPageSizeSelected() throws IOException, InterruptedException {
		// WHAT IF DATA COUNT IS LESS THAN PAGE SIZE SELECTED---HANDLE ASSERTION FOR THI
		// S SCENARIO
		// ????????????????????????????????????????????????????????????????????????
		// FOR AASERTION++++++if table has less data than page data size....how to know
		// the VALID data
		// count++++++++++++++++++++++++++++++++++++++++++++++...................?????????????????????????????????????
		// Boolean vs
		// boolean+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		logger.log(LogStatus.INFO, "Validating is Data Fetched According To PageSize Selected");
		waitForPageLoaded(driver, logger);
		boolean dataInTable = validateSearchTxnReportTableHasData();
		Boolean rableRowsAndPageSizeisSame = null;

		// page size selected
		int pageDataSizeSelected = Integer.parseInt(get_perPageDataSize());

		// if table has data
		if (dataInTable) {
			scrollElementIntoMiddle(pageSizeDropdown, driver);
			// table data count
			int tableRows = getTable_rowNumbers();
			// => scenario 1- table data is equal to or more than page size selected
			if (tableRows >= pageDataSizeSelected) {
				logger.log(LogStatus.INFO, "table data >= page size selected");

				if (tableRows == pageDataSizeSelected) {
					logger.log(LogStatus.INFO, "table data = page size selected");
					logger.log(LogStatus.INFO,
							"Table Data  -" + tableRows + "</br>Page Size Selected -" + pageDataSizeSelected);
					rableRowsAndPageSizeisSame = true;
				} else {
					logger.log(LogStatus.INFO, "table data count and page size selected has MISMATCH");
					logger.log(LogStatus.INFO,
							"Table Data Count -" + tableRows + "</br>Page Size Selected -" + pageDataSizeSelected);
					rableRowsAndPageSizeisSame = false;
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
				rableRowsAndPageSizeisSame = null;
				logger.log(LogStatus.INFO, "Returning null flag -" + rableRowsAndPageSizeisSame);
			} else {

			}
		} // close-----table has data
		else
		// if table has no data
		{
			logger.log(LogStatus.INFO, "Table has no data.</br>Page Size Selected is -" + pageDataSizeSelected);
			// what will return if table has no data....for ASSERTION
		}
		return rableRowsAndPageSizeisSame;
	}

////re verifyyyyyyyyyyyy-------------incomplete		
//		public void validate_tableDataAndTextMessage() throws IOException, InterruptedException {
//
//			logger.log(LogStatus.INFO, "validating - tableData And TextMessage");
//
//			// 1.check - table has data or not
//			Thread.sleep(2000);
//			waitForPageLoaded(driver, logger);
//			boolean dataInTable = validateSearchTxnReportTableHasData();
//
//			boolean ignoreCase, firstNumIsmatching, totalIsmatchingInTableHasNoData;
//			String firstNum = null, totalTxns = null;
//
//	//1a. if table has data
//			if (dataInTable) {
//
//				// Get first and last txn Sr. No. and capture screenshot in
//				// log------------------------------------
//				// pasing 0 index number to get sr no of 1st tr / data
//				int firstTxnIndex = 0;
//				String firstTxnSrNo = getTxnSrNo(firstTxnIndex);
//				screenshotInReport("Capture Sr.No. of first Txn. -", driver, logger);
//				// 'getTxnTable_rowNumbers' method accepts intexNumber as it's parameter
//				int tableRows = getTable_rowNumbers();
//				int tableRowIndex = (tableRows - 1);
//				String lastTxnSrNo = getTxnSrNo(tableRowIndex);
//				screenshotInReport("Capture Sr.No. of last Txn. -", driver, logger);
//
//				// find first and last number of record according to PAGE BOTTOM
//				// MESSAGE---------------------------
//				String msgAtPageBottom = getPage_paginationDataCountingMsg();
//				String[] splittedMsg = msgAtPageBottom.split(" ");// the index number of the numbers must be same (should
//				firstNum = null;
//	//			lastNum = null;
//				totalTxns = null;
//				for (int splittedMsgtextIndex = 0; splittedMsgtextIndex < splittedMsg.length; splittedMsgtextIndex++) {
//
//					if (splittedMsgtextIndex == 1) {
//						continue;
//					} else {
//						if (splittedMsgtextIndex == 0) {
//							firstNum = splittedMsg[splittedMsgtextIndex];
//						} else if (splittedMsgtextIndex == 2) {
//							totalTxns = splittedMsg[splittedMsgtextIndex];
//						}
//					}
//				}
//				// we have first,last,total txn number
//				logger.log(LogStatus.INFO,
//						"1 st no. in table -" + firstTxnSrNo + "</br>1 st no.in message - " + firstNum
//								+ "</br>last no. in table -" + lastTxnSrNo + "</br>last no.in message - " + lastNum
//								+ "</br>total in message -" + totalTxns);
//				ignoreCase = false;
//				// assert - first number is matching or not
//				firstNumIsmatching = compareString(firstTxnSrNo, firstNum, ignoreCase, logger);
//				softAssert("validate-first number of record according to PAGE BOTTOM MESSAGE", firstTxnSrNo, firstNum,
//						firstNumIsmatching, logger);
//				// assert - last number is matching or not
//				lastNumIsmatching = compareString(lastTxnSrNo, lastNum, ignoreCase, logger);
//				softAssert("validate-last number of record according to PAGE BOTTOM MESSAGE", lastTxnSrNo, lastNum,
//						lastNumIsmatching, logger);
//			} else
//	// 1b-if table has no data =>
//			{
//				logger.log(LogStatus.INFO, "Table has no data");
//				screenshotInReport("Txn. count displayed if table has no data -", driver, logger);
//
//				ignoreCase = false;
//	//passing static value = 0 as table has no data....can't read sr.no. of txn as table has no txn./data
//				String firstNumFromTable = "0";
//				String lastNumFromtable = "0";
//				String totalNumFromtable = "0";
//				// assert - first number is matching or not
//				firstNumIsmatching = compareString(firstNumFromTable, firstNum, ignoreCase, logger);
//				softAssert("validate-first number of record according to PAGE BOTTOM MESSAGE", firstNumFromTable, firstNum,
//						firstNumIsmatching, logger);
//				// assert - last number is matching or not
//				lastNumIsmatching = compareString(lastNumFromtable, lastNum, ignoreCase, logger);
//				softAssert("validate-last number of record according to PAGE BOTTOM MESSAGE", lastNumFromtable, lastNum,
//						lastNumIsmatching, logger);
//				// assert - total number is matching or not
//				totalIsmatchingInTableHasNoData = compareString(totalNumFromtable, totalTxns, ignoreCase, logger);
//				softAssert("validate-total number of record according to PAGE BOTTOM MESSAGE", totalNumFromtable, totalTxns,
//						totalIsmatchingInTableHasNoData, logger);
//			}
//		}

	public String getCurentPageNumber() {
		waitForElementToAppear(curentPageNumber, driver, logger);
//			scrollElementIntoMiddle(curentPageNumber, driver);
		scrollDown(driver);
		String pageNo = curentPageNumber.getText();
		logger.log(LogStatus.INFO, "Current page number is -" + pageNo);
		return pageNo;
	}

	public String getPage_paginationDataCountingMsg() {

		waitForElementToAppear(page_paginationDataCountingMsg, driver, logger);
//			scrollElementIntoMiddle(page_paginationDataCountingMsg, driver);
		scrollDown(driver);
		logger.log(LogStatus.INFO, "Pagination data counting msg. is -" + page_paginationDataCountingMsg.getText());
		return page_paginationDataCountingMsg.getText();
	}

	public void click_pageSizeDropdown() {

		logger.log(LogStatus.INFO, "scroll to page size dropdown");
		scrollElementIntoMiddle(pageSizeDropdown, driver);
		waitForElementToAppear(pageSizeDropdown, driver, logger);
//		scrollDown(driver);
		logger.log(LogStatus.INFO, "Click page size dropdown");
		click(pageSizeDropdown, driver, logger);
	}

	public boolean isPageSizeSelected_changeCount_DataPerPage(int dataPerPage) {
// ASSUMPTION - page sizes are -10,20,30
//below method used data sizes from the dropdown...if needed use same logic to fetch PAGE DATA SIZES

		waitForElementToAppear(pageSizeDropdown, driver, logger);
		scrollElementIntoMiddle(pageSizeDropdown, driver);
//		scrollDown(driver);

//navigate and click on page size dropdown		
		click_pageSizeDropdown();

//select a value from dropdown (index base so start from 0)		
		boolean isPageSizeSelected = false;
		try {

			if (dataPerPage == 10) {
				waitForElementToAppear(perPageDataOptions.get(0), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				// scrollElementIntoMiddle(perPageDataOptions.get(0), driver);
				scrollToWebElement(perPageDataOptions.get(0), driver);
				click(perPageDataOptions.get(0), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page size is -" + perPageDataOptions.get(0).getText());
				isPageSizeSelected = true;
				logger.log(LogStatus.INFO, "isPageSizeSelected value is -" + isPageSizeSelected);

			} else if (dataPerPage == 20) {
				waitForElementToAppear(perPageDataOptions.get(1), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				// scrollElementIntoMiddle(perPageDataOptions.get(1), driver);
				scrollToWebElement(perPageDataOptions.get(1), driver);
				click(perPageDataOptions.get(1), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page size is -" + perPageDataOptions.get(1).getText());
				isPageSizeSelected = true;
				logger.log(LogStatus.INFO, "isPageSizeSelected value is -" + isPageSizeSelected);

			} else if (dataPerPage == 30) {
				waitForElementToAppear(perPageDataOptions.get(2), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				// scrollElementIntoMiddle(perPageDataOptions.get(2), driver);
				scrollToWebElement(perPageDataOptions.get(2), driver);
				click(perPageDataOptions.get(2), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page size is -" + perPageDataOptions.get(2).getText());
				isPageSizeSelected = true;
				logger.log(LogStatus.INFO, "isPageSizeSelected value is -" + isPageSizeSelected);

			} else {
				logger.log(LogStatus.INFO, "Please enter a valid data size per page.</br>Entered value is -"
						+ dataPerPage + "</br>Valid values are - 10,20,30");
				isPageSizeSelected = false;

			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Please enter a valid data size per page catch.</br>Entered value is -"
					+ dataPerPage + "</br>Valid values are - 10,20,30");
			logger.log(LogStatus.INFO, e);
			isPageSizeSelected = false;
			logger.log(LogStatus.INFO, "isPageSizeSelected value is CATCH -" + isPageSizeSelected);
		}

		return isPageSizeSelected;

	}

	// working......fine.....LAST LOOP need attention

	public void validate_dataPerPage_allPageSizes1() throws InterruptedException, IOException {
		logger.log(LogStatus.INFO, "Validating data Per Page With All Page Sizes");
//----------------------------------------
//add this to a method to get ' pageSizeOptionsCount'+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// scroll and click on page size dropdown to get numbers of the options
		click_pageSizeDropdown();
		// select a value from dropdown (index base so start from 0)
	//	scrollElementIntoMiddle(pageSizeDropdown, driver); //---------------------------was not commented----1
		Thread.sleep(500);
		int pageSizesToSelect = perPageDataOptions.size();
		logger.log(LogStatus.INFO, "pageSizesToSelect ==="+pageSizesToSelect);

//----------------------------------------------------		
		String dataSizeText;
		logger.log(LogStatus.INFO, "999...outside loop ----  start.....");
		
		// for loop will fetch all options (page sizes) available in dropdown
		for (int pageSizeIndex = 0; pageSizeIndex < pageSizesToSelect; pageSizeIndex++) {

			logger.log(LogStatus.INFO, "loop index-"+pageSizeIndex);
			
			// scroll to next page size as we will click on next page size in next ITERATION
			WebElement pageSizeWE = perPageDataOptions.get(pageSizeIndex);
			logger.log(LogStatus.INFO, "1........");

			scrollToWebElement(pageSizeWE, driver); //------------was below get text...2

			dataSizeText = pageSizeWE.getText();
			logger.log(LogStatus.INFO, "dataSizeText ----"+dataSizeText);

			logger.log(LogStatus.INFO, "2.......");

			Thread.sleep(500);
//click data size option 1 (according to index no.)
			click(pageSizeWE, driver, logger);
			logger.log(LogStatus.INFO, "3........");

			logger.log(LogStatus.INFO, "clicked/selected page size is -" + dataSizeText);
			logger.log(LogStatus.INFO, "4........");

			waitForPageLoaded(driver, logger);
			Thread.sleep(2000);
// m1...
			captureScreenshot_firstAndLastTxn();

//			// scroll to next page size as we will click on next page size in next ITERATION
			logger.log(LogStatus.INFO, "5........");

			click_pageSizeDropdown();
			
			logger.log(LogStatus.INFO, "6........");

			Thread.sleep(500);

		}
		logger.log(LogStatus.INFO, "999...outside loop ----  end.....");

	}
	
	
	public void validate_dataPerPage_allPageSizes() throws InterruptedException, IOException {
		logger.log(LogStatus.INFO, "Validating data Per Page With All Page Sizes");
//----------------------------------------
//add this to a method to get ' pageSizeOptionsCount'+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// scroll and click on page size dropdown to get numbers of the options
		click_pageSizeDropdown();
		// select a value from dropdown (index base so start from 0)
	//	scrollElementIntoMiddle(pageSizeDropdown, driver); //---------------------------was not commented----1
		Thread.sleep(500);
	//	int pageSizesToSelect = perPageDataOptions.size();
		int pageSizesToSelect = 3;

		logger.log(LogStatus.INFO, "pageSizesToSelect ==="+pageSizesToSelect);

//----------------------------------------------------		
		String dataSizeText;
		logger.log(LogStatus.INFO, "999...outside loop ----  start.....");
		
		// for loop will fetch all options (page sizes) available in dropdown
		for (int pageSizeIndex = 0; pageSizeIndex < pageSizesToSelect; pageSizeIndex++) {

			int pageSizeNum =(pageSizeIndex+1);
			logger.log(LogStatus.INFO, "loop index-"+pageSizeIndex);
		
				logger.log(LogStatus.INFO, "7....n....");

				click_pageSizeDropdown();
				
				logger.log(LogStatus.INFO, "8..n......");

			logger.log(LogStatus.INFO, "9....n....");
Thread.sleep(500);
			// scroll to next page size as we will click on next page size in next ITERATION
			WebElement pageSizeWE = perPageDataOptions.get(pageSizeNum);
			logger.log(LogStatus.INFO, "1........");

			scrollToWebElement(pageSizeWE, driver); //------------was below get text...2

			dataSizeText = pageSizeWE.getText();
			logger.log(LogStatus.INFO, "dataSizeText ----"+dataSizeText);

			logger.log(LogStatus.INFO, "2.......");

			Thread.sleep(500);
//click data size option 1 (according to index no.)
			click(pageSizeWE, driver, logger);
			logger.log(LogStatus.INFO, "3........");

			logger.log(LogStatus.INFO, "clicked/selected page size is -" + dataSizeText);
			logger.log(LogStatus.INFO, "4........");

			waitForPageLoaded(driver, logger);
			Thread.sleep(2000);
// m1...
			captureScreenshot_firstAndLastTxn();
			
			logger.log(LogStatus.INFO, "5........");


		}
		logger.log(LogStatus.INFO, "999...outside loop ----  end.....");

	}

	public boolean isEnabled_firstPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
//LAST PAGE button is at THREE index, so passing static value = 3			
		WebElement firstPageIconElement = paginationsAllButtons.get(0);
		boolean isButtonEnabled = firstPageIconElement.isEnabled();
		logger.log(LogStatus.INFO, "navigate to first page button enabled -" + isButtonEnabled);
		return isButtonEnabled;
	}

	public boolean isEnabled_previousPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
//LAST PAGE button is at THREE index, so passing static value = 3			
		WebElement prevPageIconElement = paginationsAllButtons.get(1);
		boolean isButtonEnabled = prevPageIconElement.isEnabled();
		logger.log(LogStatus.INFO, "navigate to previous page button enabled -" + isButtonEnabled);
		return isButtonEnabled;
	}

	public boolean isEnabled_nextPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
//LAST PAGE button is at THREE index, so passing static value = 3			
		WebElement nextPageIconElement = paginationsAllButtons.get(2);
		boolean isButtonEnabled = nextPageIconElement.isEnabled();
		logger.log(LogStatus.INFO, "navigate to next page button enabled -" + isButtonEnabled);
		return isButtonEnabled;
	}

	public boolean isEnabled_lastPageButton() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
//LAST PAGE button is at THREE index, so passing static value = 3			
		WebElement lastPageIconElement = paginationsAllButtons.get(3);
		boolean isButtonEnabled = lastPageIconElement.isEnabled();
		logger.log(LogStatus.INFO, "navigate to last page button enabled -" + isButtonEnabled);
		return isButtonEnabled;
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
			scrollDown(driver);
			click(firstPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled + " i.e. DISABLED");
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
			scrollDown(driver);
			click(prevPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled + " i.e. DISABLED");
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
			scrollDown(driver);
			click(nextPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled + " i.e. DISABLED");
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
			scrollDown(driver);
			click(lastPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled + " i.e. DISABLED");
		}
	}

}

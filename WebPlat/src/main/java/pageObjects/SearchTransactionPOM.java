package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.filters.TokenFilter.Trim;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//div[@id='offcanvasRight']")
	public WebElement moreinfoSideBar;

	@FindBy(xpath = "//div[@id='offcanvasRight']//child::h5")
	public WebElement sideBarHeader_textORTitle;

	// 1.dmt more info side bar =>pending,failed txn. has one button (close)
	// only...success txn. has 3 buttons (1-Single, 2-Bulk, 3-Close)
	// same xpath can be used for other tabs...list will have 1 button only
	@FindBy(xpath = "//div[@id='offcanvasRight']//child::button")
	public List<WebElement> moreInfo_headersButtonsList;

	@FindBy(xpath = "//div[@id='offcanvasRight']//table/tbody/tr")
	public List<WebElement> moreInfoTable_rowNos;

	// 4. pagination elements ##################################################

	@FindBy(xpath = "//p-paginator[@class='p-element ng-star-inserted']")
	public WebElement paginationWebElement;

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	public WebElement page_paginationDataCountingMsg;

	
	
	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']")
	public WebElement bottom_PagenumbersDisplayed_parentWE;
	
	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']//child::button")
	public List<WebElement> bottom_PagenumbersDisplayed;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']")
	public WebElement curentPageNumber;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")
	public WebElement dataPerPageField;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']//following::div[@class='p-dropdown-trigger']")
	public WebElement pageSizeDropdown;

	@FindBy(xpath = "//p-dropdown[@class='p-element p-inputwrapper p-inputwrapper-filled ng-untouched ng-pristine ng-star-inserted']")
	public WebElement pageSizeDropdownEnabled;

	@FindBy(xpath = "//div[@class='p-dropdown-items-wrapper']/ul/p-dropdownitem/li")
	public List<WebElement> perPageDataOptions;

	@FindBy(xpath = "//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']")
	public WebElement page_dataPerPageNumber;

	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']/button")
	public List<WebElement> paginationsAllButtons;
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']")
	public WebElement highlitedPageNumber;

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
		waitForPageLoaded(driver, logger);
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

		logger.log(LogStatus.INFO, "Selecting option/filter from the dropdown.");

		logger.log(LogStatus.INFO, "click filterDropdown");
		Thread.sleep(1000);

		click(filterDropdown, driver, logger);
		Thread.sleep(1000);
		Select select = new Select(filterDropdown_selectWE);
		// select.selectByVisibleText("RRN");
		boolean isOptSelected = false;
		select.getOptions();

		for (WebElement optElement : select.getOptions()) {
			String dropOptOne = optElement.getText().trim();
			if (dropOptOne.equalsIgnoreCase(optToSelect)) {
				logger.log(LogStatus.INFO, "Select option -" + dropOptOne);
				highlightElement(optElement, "Red", driver, logger);
				click(optElement, driver, logger);
				isOptSelected = true;
				break;
			} else {
				isOptSelected = false;
			}
		}
		if (!isOptSelected) {
			logger.log(LogStatus.INFO, "Invalid filter -" + optToSelect + "</br>Please refer valid filter list.");
			getOptionsList_filterSelectDropdown();
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
//		Thread.sleep(2000);
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
//		Thread.sleep(2000);
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

	public void validateMoreInfoSideMenu_TableData() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "validating More Info Side Menu Data");

		boolean dataInTable = validateSearchTxnReportTableHasData();
//if table has data
		if (dataInTable) {
			// navigate through each row of table
			int tableRows = searchTxnTable_rows.size();
			for (int tableRowIndex = 0; tableRowIndex < tableRows; tableRowIndex++) {
				// fetch data from TABLE column---to compare with MORE INFO table data
				// open more info side menu bar
				moreInfo_openSideMenu(tableRowIndex);

//validate - is more info side menu bar open
				boolean isMoreInfoSideMenuOpen;
				isMoreInfoSideMenuOpen = moreInfo_isSideBarDisplayed();
				if (isMoreInfoSideMenuOpen) {
					// navigate through MORE INFO table
					int moreInfoTable_rows = moreInfoTable_rowNos.size();
					for (int moreInfoRowsIndex = 0; moreInfoRowsIndex < moreInfoTable_rows; moreInfoRowsIndex++) {
						int moreInfoRowsNum = (moreInfoRowsIndex + 1);
						WebElement moreInfoTable_paramNameWE = driver.findElement(
								By.xpath("//div[@id='offcanvasRight']//table/tbody/tr[" + moreInfoRowsNum + "]/td[1]"));
						WebElement moreInfoTable_paramValueWE = driver.findElement(By.xpath(
								"//div[@id='offcanvasRight']//table/tbody/tr[" + moreInfoRowsNum + "]/td[2]/span"));
						String moreInfoParam = moreInfoTable_paramNameWE.getText();
						String moreInfoValue = moreInfoTable_paramValueWE.getText();

						logger.log(LogStatus.INFO, "moreInfo--Param - val ==>" + moreInfoRowsNum + "." + moreInfoParam
								+ "-" + moreInfoValue);
					} // close--- navigating through more info table
						// after validating more info table data for a txn ....close the more info side
						// bar of that txn.
					Thread.sleep(500);
					moreInfo_close_lastButton();
				} // close---is more info side menu displayed
			} // close---navigate through row of table
		} // close---if table has data
	}

	public String get_parameterValue_validateMoreInfoSideMenu(String moreInfoTable_param)
			throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "Fetch parameter value from more info side menu.");

		HashMap hashMap = new HashMap<String, String>();
		String valueOfKey = null;
		// navigate through MORE INFO table
		int moreInfoTable_rows = moreInfoTable_rowNos.size();
		for (int moreInfoRowsIndex = 0; moreInfoRowsIndex < moreInfoTable_rows; moreInfoRowsIndex++) {
			int moreInfoRowsNum = (moreInfoRowsIndex + 1);
			WebElement moreInfoTable_paramNameWE = driver.findElement(
					By.xpath("//div[@id='offcanvasRight']//table/tbody/tr[" + moreInfoRowsNum + "]/td[1]"));
			WebElement moreInfoTable_paramValueWE = driver.findElement(
					By.xpath("//div[@id='offcanvasRight']//table/tbody/tr[" + moreInfoRowsNum + "]/td[2]/span"));
			String moreInfoParam = moreInfoTable_paramNameWE.getText();
			String moreInfoValue = moreInfoTable_paramValueWE.getText();

			hashMap.put(moreInfoParam, moreInfoValue);
		} // close--- navigating through more info table

		boolean containsKey = hashMap.containsKey(moreInfoTable_param);
		if (containsKey) {
			logger.log(LogStatus.INFO, "Entered a valid key -" + containsKey);
			valueOfKey = (String) hashMap.get(moreInfoTable_param);
			return valueOfKey;
		} else {
			logger.log(LogStatus.INFO, "Entered a valid key -" + containsKey);
		}
		return valueOfKey;
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
//			Thread.sleep(2000);
			screenshotInReport("Capture first Txn. SR.No.-" + firstTxnSrNo, driver, logger);
			// 'getTxnTable_rowNumbers' method accepts intexNumber as it's parameter
			int tableRows = getTable_rowNumbers();
			int tableRowIndex = (tableRows - 1);
			String lastTxnSrNo = getTxnSrNo(tableRowIndex);
//			Thread.sleep(2000);
			screenshotInReport("Capture last Txn. Sr.No. -" + lastTxnSrNo, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "Search txn. table has no data.");
			screenshotInReport("Search txn. table has no data -", driver, logger);
		}
	}

	public void moreInfo_openSideMenu(int txnNoIndex) throws InterruptedException, IOException {

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

	public boolean moreInfo_isSideBarDisplayed() throws InterruptedException, IOException {

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

	public String moreInfo_getParameterValue(String paramToGetVlaue) throws InterruptedException, IOException {

		boolean isDisp = moreInfo_isSideBarDisplayed();
		String paramValueString;

		if (isDisp) {

			paramValueString = get_parameterValue_validateMoreInfoSideMenu(paramToGetVlaue);
			logger.log(LogStatus.INFO, "parameter (entered) - value is -" + paramToGetVlaue + "-" + paramValueString);
			return paramValueString;

		} else {
			logger.log(LogStatus.INFO, "More info popup is not open/displayed");
			paramValueString = null;
//		return paramValueString;
		}

		return paramValueString;
	}

	public void moreInfo_close_lastButton() throws InterruptedException {

		// new logic ........

//			scrollElementIntoMiddle(sideBarHeader_textORTitle, driver);
		int moreInfoHeaderButtonsNo = moreInfo_headersButtonsList.size();
		int moreInfoHeaderLastButtonIndex = (moreInfoHeaderButtonsNo - 1);
		try {
			for (int a = 0; a < moreInfoHeaderButtonsNo; a++) {

				// if buttons list is 1 => then enter this if condition and click this button (1
				// button must be the CLOSE button)
				if (moreInfoHeaderButtonsNo == 1) {
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

	public void moreInfo_sideBarHeaderButtonsValidate() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO,
				"Validating transaction MORE INFO side menu buttons count at 'search transaction' module.");

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

//open more info side menu bar
						moreInfo_openSideMenu(tableRowIndex);
//validate - is more info side menu bar open
						boolean isMoreInfoSideMenuOpen;
						isMoreInfoSideMenuOpen = moreInfo_isSideBarDisplayed();
						if (isMoreInfoSideMenuOpen) {

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
							Thread.sleep(500);
							moreInfo_close_lastButton();
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
			logger.log(LogStatus.INFO, "Table has no data.");

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

	public boolean selectPageSize(int dataPerPage) {
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
				scrollToWebElement(perPageDataOptions.get(0), driver, logger);
				click(perPageDataOptions.get(0), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page size is -" + perPageDataOptions.get(0).getText());
				isPageSizeSelected = true;
				logger.log(LogStatus.INFO, "isPageSizeSelected value is -" + isPageSizeSelected);

			} else if (dataPerPage == 20) {
				waitForElementToAppear(perPageDataOptions.get(1), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				// scrollElementIntoMiddle(perPageDataOptions.get(1), driver);
				scrollToWebElement(perPageDataOptions.get(1), driver, logger);
				click(perPageDataOptions.get(1), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page size is -" + perPageDataOptions.get(1).getText());
				isPageSizeSelected = true;
				logger.log(LogStatus.INFO, "isPageSizeSelected value is -" + isPageSizeSelected);

			} else if (dataPerPage == 30) {
				waitForElementToAppear(perPageDataOptions.get(2), driver, logger);
				logger.log(LogStatus.INFO, "Selected data per page -" + dataPerPage);
				// scrollElementIntoMiddle(perPageDataOptions.get(2), driver);
				scrollToWebElement(perPageDataOptions.get(2), driver, logger);
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

		click_pageSizeDropdown();
		Thread.sleep(500);
//----------------------------------------------------		
		String dataSizeText;

		for (int pageSizeIndex = 0; pageSizeIndex < (perPageDataOptions.size()); pageSizeIndex++) {

			logger.log(LogStatus.INFO, "loop index ----------------" + pageSizeIndex);

			WebElement pageSizeWE = perPageDataOptions.get(pageSizeIndex);
			logger.log(LogStatus.INFO, "(opt) web element ----" + pageSizeWE);

//		List<WebElement>	 perPageDataOptions = driver.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper']/ul/p-dropdownitem/li")); // Adjust the selector as needed
//			    pageSizeWE = perPageDataOptions.get(pageSizeIndex);
//			

			scrollToWebElement(pageSizeWE, driver, logger); // ------------was below get text...2
			dataSizeText = pageSizeWE.getText();
			logger.log(LogStatus.INFO, "option text is ----" + dataSizeText);
			Thread.sleep(500);
			waitForElementToAppear(pageSizeWE, driver, logger);
			click(pageSizeWE, driver, logger);
			logger.log(LogStatus.INFO, "clicked/selected page size is -" + pageSizeWE.getText());
			Thread.sleep(2000);
// m1...
			captureScreenshot_firstAndLastTxn();

			click_pageSizeDropdown();
			Thread.sleep(500);

			logger.log(LogStatus.INFO, "loop end...");
		}
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
		Boolean flag = null;

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

	public void validate_dataPerPageooooooooooooo() throws InterruptedException, IOException {

		logger.log(LogStatus.INFO, "Validating first and last transaction data Per Page.");

//----------------------------------------
//add this to a method to get ' pageSizeOptionsCount'+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// scroll and click on page size dropdown to get numbers of the options
		click_pageSizeDropdown();
		// select a value from dropdown (index base so start from 0)
		scrollElementIntoMiddle(pageSizeDropdown, driver); // ---------------------------was not commented----1
		Thread.sleep(500);
		int pageSizesToSelect;
		pageSizesToSelect = perPageDataOptions.size();
//		int pageSizesToSelect = 3;

		logger.log(LogStatus.INFO, "pageSizesToSelect ===" + pageSizesToSelect);

//----------------------------------------------------		
		String dataSizeText;
		logger.log(LogStatus.INFO, "999...outside loop ----  start.....");

		// for loop will fetch all options (page sizes) available in dropdown
		for (int pageSizeIndex = 0; pageSizeIndex < pageSizesToSelect; pageSizeIndex++) {

			int pageSizeNum = (pageSizeIndex + 1);
			logger.log(LogStatus.INFO, "loop index-" + pageSizeIndex);

			logger.log(LogStatus.INFO, "7....n....");

			click_pageSizeDropdown();

			logger.log(LogStatus.INFO, "8..n......");

			logger.log(LogStatus.INFO, "9....n....");
			Thread.sleep(500);
			// scroll to next page size as we will click on next page size in next ITERATION
			WebElement pageSizeWE = perPageDataOptions.get(pageSizeNum);
			logger.log(LogStatus.INFO, "1........");

			scrollToWebElement(pageSizeWE, driver, logger); // ------------was below get text...2

			dataSizeText = pageSizeWE.getText();
			logger.log(LogStatus.INFO, "dataSizeText ----" + dataSizeText);

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

	public boolean isEnabled_pageSizeDropdown() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
//LAST PAGE button is at THREE index, so passing static value = 3			
		boolean isDropdownEnabled = pageSizeDropdownEnabled.isEnabled();
		logger.log(LogStatus.INFO, "navigate to next page button enabled -" + isDropdownEnabled);
		return isDropdownEnabled;
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
//			scrollDown(driver);
			scrollElementIntoMiddle(firstPageIconElement, driver);
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
//			scrollDown(driver);
			scrollElementIntoMiddle(prevPageIconElement, driver);
			click(prevPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled + " i.e. DISABLED");
		}
	}

	public void click_navigate_nextPageButton() {

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
		scrollElementIntoMiddle(paginationWebElement, driver);
//		scrollDown(driver);
		// NEXT PAGE button is at TWO index, so passing static value = 2
		WebElement nextPageIconElement = paginationsAllButtons.get(2);
		boolean buttonEnabled = nextPageIconElement.isEnabled();
		logger.log(LogStatus.INFO, "click next page button");
		if (buttonEnabled) {
			logger.log(LogStatus.INFO, "next page button is enabled -" + buttonEnabled);
			scrollElementIntoMiddle(nextPageIconElement, driver);
//			scrollDown(driver);
			click(nextPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled + " i.e. DISABLED");
		}
	}

	public void click_navigate_lastPageButton() throws InterruptedException {

		waitForPageLoaded(driver, logger);
		waitForElementToAppear(paginationWebElement, driver, logger);
		logger.log(LogStatus.INFO, "scroll to pagination WebElement");
		scrollElementIntoMiddle(paginationWebElement, driver);
//		scrollDown(driver);
//LAST PAGE button is at THREE index, so passing static value = 3			
		WebElement lastPageIconElement = paginationsAllButtons.get(3);
		boolean buttonEnabled = lastPageIconElement.isEnabled();
		logger.log(LogStatus.INFO, "click last page button");
		if (buttonEnabled) {
			logger.log(LogStatus.INFO, "last page button is enabled -" + buttonEnabled);
//			scrollDown(driver);
			scrollElementIntoMiddle(lastPageIconElement, driver);
			Thread.sleep(2000);
			click(lastPageIconElement, driver, logger);
		} else {
			logger.log(LogStatus.INFO, "first page button is enabled -" + buttonEnabled + " i.e. DISABLED");
		}
	}

	public void validate_totalPagesGeneratedAccordingToTableDataText() throws IOException, InterruptedException {

		logger.log(LogStatus.INFO, "validating - tableData And TextMessage");

		// 1.check - table has data or not
		waitForPageLoaded(driver, logger);
		boolean dataInTable = validateSearchTxnReportTableHasData();

		boolean ignoreCase, currentPageIsMatching, totalPagesCountIsMatching;
		String currentPageMessage = null, totalPagesMessage = null, expectedTotalPagesCount_inMessageString;
		int expectedTotalPagesCount_inMessageINT = 0;
		int lastTxnSrNoTableInt;

		// 1a. if table has data
		if (dataInTable) {
			// Passing 0 index number to get sr no of 1st tr / data
			int firstTxnIndex = 0;
			String firstTxnSrNo = getTxnSrNo(firstTxnIndex);
			screenshotInReport("Capture Sr.No. of first Txn. -", driver, logger);
			// 'getTxnTable_rowNumbers' method accepts intexNumber as it's parameter
			int tableRows = getTable_rowNumbers();
			int tableRowIndex = (tableRows - 1);
			String lastTxnSrNo = getTxnSrNo(tableRowIndex);
			screenshotInReport("Capture Sr.No. of last Txn. -", driver, logger);
//current page size------------
			String currentPageDataSizeSelectedIs = get_perPageDataSize();
//current page size------------for MATH
			int currentPageDataSizeSelectedIsInt = Integer.parseInt(currentPageDataSizeSelectedIs);

// find first and last number of record according to PAGE BOTTOM MESSAGE------------------
			String msgAtPageBottom = getPage_paginationDataCountingMsg();
			String[] splittedMsg = msgAtPageBottom.split(" ");// the index number of the numbers must be same (should
			for (int splittedMsgtextIndex = 0; splittedMsgtextIndex < splittedMsg.length; splittedMsgtextIndex++) {

				if (splittedMsgtextIndex == 1) {
					continue;
				} else {
					if (splittedMsgtextIndex == 0) {
						currentPageMessage = splittedMsg[splittedMsgtextIndex];
					} else if (splittedMsgtextIndex == 2) {
						totalPagesMessage = splittedMsg[splittedMsgtextIndex];
					}
				}
			}
			// we have first,last,total txn number
			logger.log(LogStatus.INFO,
					"1 st no. in table -" + firstTxnSrNo + "</br>last no. in table -" + lastTxnSrNo
							+ "</br>Current Page Size is - " + currentPageDataSizeSelectedIs
							+ "</br>Total pages count according to the message is -" + totalPagesMessage);

//			// total pages count according to message (INT)
//			int totalPagesInt = Integer.parseInt(totalPagesMessage);
//			
			// validate if table data > page size (table has more pages or not)
			boolean isLastPageEnabled = isEnabled_lastPageButton();

			// 1----if table data > page size (table has more pages)
			// if last page is enabled...then navigate to last page

			if (isLastPageEnabled) {
				logger.log(LogStatus.INFO, "isLastPageEnabled -" + isLastPageEnabled);
				// navigate to last page
				click_navigate_lastPageButton();
				waitForPageLoaded(driver, logger);
				// get last page txn. id---for MATH
				String lastTxnSrNo_lastTxn = getTxnSrNo(tableRowIndex);
				int lastTxnSrNoTableInt_lastTxn = Integer.parseInt(lastTxnSrNo_lastTxn);

				// calculate total pages count...
				int expectedPageNos = lastTxnSrNoTableInt_lastTxn / currentPageDataSizeSelectedIsInt;
				int needExtraPageThan_expectedPageNos = lastTxnSrNoTableInt_lastTxn % currentPageDataSizeSelectedIsInt;

				if (needExtraPageThan_expectedPageNos == 0) {
					expectedTotalPagesCount_inMessageINT = expectedPageNos;
				} else if (needExtraPageThan_expectedPageNos != 0) {
					expectedTotalPagesCount_inMessageINT = (expectedPageNos + 1);
				} else {
					logger.log(LogStatus.INFO, "Check----calculate total pages count...");
				}
				// calculated---expected total page count...by doing data/page size and few more
				// math

				// validate - total page count as per MATH and MESSAGE....
				// convert to string to COMPARE
				expectedTotalPagesCount_inMessageString = String.valueOf(expectedTotalPagesCount_inMessageINT);

				ignoreCase = false;
				totalPagesCountIsMatching = compareString(totalPagesMessage, expectedTotalPagesCount_inMessageString,
						ignoreCase, logger);
				softAssert(
						"validate-total page count according to the PAGE BOTTOM MESSAGE</br>(table data >  page size)",
						totalPagesMessage, expectedTotalPagesCount_inMessageString, totalPagesCountIsMatching, logger);
			}
			// validate 2......- total page count for SINGLE PAGE ------- table data <= per
			// page data size
			else {
				logger.log(LogStatus.INFO, "isLastPageEnabled2 -" + isLastPageEnabled);
				expectedTotalPagesCount_inMessageString = "1";
				ignoreCase = false;
				totalPagesCountIsMatching = compareString(totalPagesMessage, expectedTotalPagesCount_inMessageString,
						ignoreCase, logger);
				softAssert(
						"validate-total page count according to the PAGE BOTTOM MESSAGE</br>(table data <=  page size",
						totalPagesMessage, expectedTotalPagesCount_inMessageString, totalPagesCountIsMatching, logger);
			}

		} else
		// 1b-if table has no data =>
		{
			logger.log(LogStatus.INFO, "Table has no data");
			screenshotInReport("Txn. count displayed if table has no data -", driver, logger);

			expectedTotalPagesCount_inMessageString = "0";
			ignoreCase = false;
			totalPagesCountIsMatching = compareString(totalPagesMessage, expectedTotalPagesCount_inMessageString,
					ignoreCase, logger);
			softAssert("validate-total page count according to the PAGE BOTTOM MESSAGE</br>(table has no data)",
					totalPagesMessage, expectedTotalPagesCount_inMessageString, totalPagesCountIsMatching, logger);

		}
	}

	
	public boolean isPagesCountMatchingAccordingToTheTableData() throws IOException, InterruptedException {

		logger.log(LogStatus.INFO, "Validate - pagesCount According To The TableData");

		// 1.check - table has data or not
		waitForPageLoaded(driver, logger);
		boolean dataInTable = validateSearchTxnReportTableHasData();

		int expectedTotalPagesCount_inMessage_int = 0;
		
		boolean pageCountMatching;
		int pagesCountAtPagination;
		String expectedTotalPagesCount_inMessage;
		String perPageDataSizeSelectedString; // data size selected from dropdown
		int perPageDataSizeSelectedInt; // data size selected from dropdown...converted to int for math
		String highlitedPageNumString = null;
		
		// 1a. if table has data
		if (dataInTable) {
			pagesCountAtPagination = bottom_PagenumbersDisplayed.size();		 
//current page size------------
			 perPageDataSizeSelectedString = get_perPageDataSize();
			 perPageDataSizeSelectedInt = Integer.parseInt(perPageDataSizeSelectedString);

			boolean isLastPageEnabled = isEnabled_lastPageButton();

			// 1----if table data > page size (table has more pages)
			// if last page is enabled...then navigate to last page
			if (isLastPageEnabled) {
				logger.log(LogStatus.INFO, "isLastPageEnabled -" + isLastPageEnabled);
				// navigate to last page...to get last txn. number--------------------------
				click_navigate_lastPageButton();
				waitForPageLoaded(driver, logger);
				int tableRows = getTable_rowNumbers();
				int tableRowIndexOfLastRow = (tableRows - 1);
				String srNo_lastTxn = getTxnSrNo(tableRowIndexOfLastRow);
				int srNo_lastTxn_int = Integer.parseInt(srNo_lastTxn);
				
				// calculate total pages count...
				int expectedPageNos = srNo_lastTxn_int / perPageDataSizeSelectedInt; 
				int needExtraPageThan_expectedPageNos = srNo_lastTxn_int % perPageDataSizeSelectedInt;
				
				if (needExtraPageThan_expectedPageNos == 0) 
				{
					expectedTotalPagesCount_inMessage_int = expectedPageNos;
				} 
				else if (needExtraPageThan_expectedPageNos != 0) 
				{
					expectedTotalPagesCount_inMessage_int = (expectedPageNos + 1);
				} 
				else 
				{
					logger.log(LogStatus.INFO, "Check----calculate total pages count.</br>Entered else block of 'isLastPageEnabled' . ");
					pageCountMatching=false;
				}
		    	 expectedTotalPagesCount_inMessage = String.valueOf(expectedTotalPagesCount_inMessage_int);
                 highlitedPageNumString = highlitedPageNumber.getText();	
                pageCountMatching = compareString(highlitedPageNumString, expectedTotalPagesCount_inMessage, false, logger);	
			}
			// validate 2......- total page count for SINGLE PAGE ------- table data <= per
			// page data size
			else {
				logger.log(LogStatus.INFO, "isLastPageEnabled2 (i.e. disabled) -" + isLastPageEnabled);
				expectedTotalPagesCount_inMessage = "1";
		    	pageCountMatching = compareString(highlitedPageNumString, expectedTotalPagesCount_inMessage,
						false, logger);
			}

		} else
		// 1b-if table has no data ===>
		{	
			pagesCountAtPagination =	bottom_PagenumbersDisplayed.size();
			logger.log(LogStatus.INFO, "Table has no data.</br>Pages count is -" + pagesCountAtPagination);
			if(pagesCountAtPagination == 0)
			{
				pageCountMatching=true;
				logger.log(LogStatus.INFO, "pageCountMatching -"+pageCountMatching);

			}
			else 
			{
				pageCountMatching=false;
				logger.log(LogStatus.INFO, "pageCountMatching -"+pageCountMatching);
			}
		}
		return pageCountMatching;
	}
	
	

}

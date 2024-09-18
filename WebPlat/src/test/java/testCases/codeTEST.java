package testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Login;
import pageObjects.TransactionHistoryPOM;
import utility.config;

public class codeTEST {

	public static void main(String[] args) {
		
		
//		
//
//		Login login = new Login (driver,logger);
//		testConfig = new config(logger);
//		//commonFunc comm =new commonFunc();
//		
//		String user = testConfig.getRunTimeProperty("username");
//		String pass = testConfig.getRunTimeProperty("password");
//
//		logger.log(LogStatus.INFO, "Step 1: Goto \"https://merchant.uatdev.in/\" ");
//
//		login.signin(user, pass);
//		Thread.sleep(5000);
//		login.dialogClose();
//		
//	logger.log(LogStatus.INFO, "Step 2: logged in successfully ");
//
//	TransactionHistoryPOM transactionHistoryPOM = new TransactionHistoryPOM (driver,logger);
//	
//	transactionHistoryPOM.click_reportsModule();
//
//	transactionHistoryPOM.click_txnHistoryModule();
//
//  //  transactionHistoryPOM.selectFromDate(10, "August", 2024);
//
//	transactionHistoryPOM.selectFromDate2(10, "August", 2024);
//	
// //   transactionHistoryPOM.selectToDate(20, "August", 2024);
//	
//    transactionHistoryPOM.selectToDate2(20, "August", 2024);
//
//    transactionHistoryPOM.click_searchButton();
//
//	Thread.sleep(5000);
//
//	System.out.println("waiting to read table data");
//
////	List <WebElement> table_rows = driver.findElements(By.xpath("//table[@id='pr_id_13-table']/tbody/tr/td[1]"));
//	
////	List <WebElement> table_rows_way2 = driver.findElements(By.xpath("//table[@id='pr_id_13-table']/tbody/tr"));
//
////	List <WebElement> table_srNo = driver.findElements(By.xpath("//table[@id='pr_id_24-table']/tbody/tr/td[1]"));
//
////	List <WebElement> columnsNo = driver.findElements(By.xpath("//table[@id='pr_id_13-table']/thead/tr/th"));
//
//	List <WebElement> roww = driver.findElements(By.xpath("//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr"));
//	System.out.println(" rows m1= "+roww.size());
//	List <WebElement> coll = driver.findElements(By.xpath("//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/thead/tr/th"));
//	System.out.println(" col m1= "+coll.size());
//	
//	Thread.sleep(1000);
////// more info.............
////	WebElement moreInfoIcon = driver.findElement(By.xpath("//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr[1]/td[10]/a/i"));
////	moreInfoIcon.click();
////
////	Thread.sleep(2000);
////
////	WebElement moreTable_paramName = driver.findElement(By.xpath("//table[@class='table reportdata']/tbody/tr/td[1]"));
////	WebElement moreTable_paramValue = driver.findElement(By.xpath("//table[@class='table reportdata']/tbody/tr/td[2]"));
////
////	System.out.println("moreTable_paramName = "+moreTable_paramName.getText());
////
////	System.out.println(" moreTable_paramValue = "+moreTable_paramValue.getText());
////	System.out.println(" moreTable_paramValue_afterReplacing = "+moreTable_paramValue.getText().replace("₹","") );
////	System.out.println(" moreTable_paramValue_as double = "+Double.parseDouble(moreTable_paramValue.getText().replace("₹","")) );
////
////	Thread.sleep(3000);
////	
////	System.out.println("moreTable_closeButton = closing");
////
////	WebElement moreTable_closeButton = driver.findElement(By.xpath("//div[@class='offcanvas reportmodule offcanvas-end show']//button"));
////	moreTable_closeButton.click();
////	System.out.println("moreTable_closeButton = clicked/closed");
//
////	Thread.sleep(3000);
//	
//	((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
//	
//	Thread.sleep(3000);
//	
//	System.out.println("scrolled to page end.........------------------...........");
//
////page change.......................	
//
//	List <WebElement> buttons_numbers = driver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']//child::button"));
//	System.out.println("buttons_numbers (between previous and next buttons) are ="+ buttons_numbers.size());
//	
//	Thread.sleep(3000);
//	WebElement CurentPageNumber = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']"));
//	System.out.println("current page no. is -"+CurentPageNumber.getText());
//	
//	Thread.sleep(3000);
//	WebElement navigate_nextPageButton = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link']"));
//	navigate_nextPageButton.click();
//	System.out.println("clicked on next button");
//	
//	Thread.sleep(3000);
//	WebElement CurentPageNumber2 = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']"));
//	System.out.println("current(next) page no.2 is -"+CurentPageNumber2.getText());
//	
//	Thread.sleep(3000);
//	WebElement navigate_previousPageButton = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-prev p-paginator-element p-link']"));
//	navigate_previousPageButton.click();
//	System.out.println("clicked on previous button");
//
//	Thread.sleep(3000);
//	WebElement CurentPageNumber3 = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']"));
//	System.out.println("current(prev) page no.3 is -"+CurentPageNumber3.getText());
//	
//	Thread.sleep(3000);
//	WebElement navigate_lastPageButton = driver.findElement(By.xpath("//angledoublerighticon[@class='p-element p-icon-wrapper ng-star-inserted']"));
//	navigate_lastPageButton.click();
//	System.out.println("clicked on last page button");
//
//	Thread.sleep(3000);
//	WebElement CurentPageNumberLAST = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']"));
//	System.out.println("current(LAST) page no.4 is -"+CurentPageNumberLAST.getText());
//	
//	Thread.sleep(3000);
//	WebElement navigate_firstPageButton = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link ng-star-inserted']"));	
//	navigate_firstPageButton.click();
//	System.out.println("clicked on first page button");
//	
//	Thread.sleep(3000);
//	WebElement CurentPageNumberFIRST = driver.findElement(By.xpath("//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link p-highlight ng-star-inserted']"));
//	System.out.println("current(FIRST) page no.4 is -"+CurentPageNumberFIRST.getText());
//	
//	Thread.sleep(3000);
//
//	
//	
//	
//	//button[@class="p-ripple p-element p-paginator-first p-paginator-element p-link ng-star-inserted p-disabled"]	
//	//button[@class="p-ripple p-element p-paginator-last p-paginator-element p-link ng-star-inserted p-disabled"]
//	
//	
//	
//	
//	
//	
////pagination.........................	
////	WebElement page_dataZizeSelected = driver.findElement(By.xpath("//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']"));
////	System.out.println("data per page selected = "+page_dataZizeSelected.getText());
////	
////	WebElement pageSizeDropdown = driver.findElement(By.xpath("//span[@class='p-element p-dropdown-label p-inputtext ng-star-inserted']//following::div[@class='p-dropdown-trigger']"));
////	pageSizeDropdown.click();
////	Thread.sleep(2000);
////	
////	((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
////	Thread.sleep(2000);
////
////	
////	List <WebElement> page_dataZizes = driver.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper']/ul/p-dropdownitem/li"));
////	System.out.println("page size nos..= "+page_dataZizes.size());
////	Thread.sleep(2000);
////	System.out.println("page size ..0= "+page_dataZizes.get(0).getText());
////	System.out.println("page size ..1= "+page_dataZizes.get(1).getText());
////	System.out.println("page size ..2= "+page_dataZizes.get(2).getText());
////
////	((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
////
////	page_dataZizes.get(1).click();
////	
////	System.out.println("clicked on 1std data size");
////
////	Thread.sleep(5000);
////
////	System.out.println("data per page selected 2 = "+page_dataZizeSelected.getText());
////
////	List <WebElement> roww2 = driver.findElements(By.xpath("//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr"));
////	
////	System.out.println(" rows m2 = "+roww2.size());
////	
////	System.out.println("table data finding --------------------");
////	
////	List <WebElement> noDatFound_dataInARow = driver.findElements(By.xpath("//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr/td"));
////
////	int rowDataNo = noDatFound_dataInARow.size();
////	
////	Boolean tableHasDta;
////	
////	if(rowDataNo > 1) 
////	{
////		System.out.println("TABLE - has data");
////		tableHasDta=true;
////		System.out.println("tableHasDta FLAG - "+tableHasDta);
////	}
////	else 
////	{
////		System.out.println("TABLE - has NO DATA");
////		tableHasDta=false;
////		System.out.println("tableHasDta FLAG - "+tableHasDta);
////	}
////	
////	System.out.println("table data count completed------------");
//
//
//	
////	WebElement moreInfoIcon = driver.findElement(By.xpath("//div[@class=\"p-dropdown-items-wrapper\"]/ul/p-dropdownitem"));
////	WebElement moreInfoIcon = driver.findElement(By.xpath("//div[@class=\"p-dropdown-items-wrapper\"]/ul/p-dropdownitem"));	
////	WebElement page_dataZizes = driver.findElement(By.xpath("//div[@class=\"p-dropdown-items-wrapper\"]/ul/p-dropdownitem"));
//
//	
//	
////	WebElement moreTable_closeButton = driver.findElement(By.xpath("//div[@class='offcanvas reportmodule offcanvas-end show']//button"));
////	WebElement moreTable_closeButton = driver.findElement(By.xpath("//div[@class='offcanvas reportmodule offcanvas-end show']//button"));
////	WebElement moreTable_closeButton = driver.findElement(By.xpath("//div[@class='offcanvas reportmodule offcanvas-end show']//button"));
//
//	
//
////	System.out.println(" rows m1= "+table_rows.size());
////	System.out.println("row m1 print = "+table_rows);
////
////	System.out.println(" rows m2= "+table_rows_way2.size());
////	System.out.println("row m2 print = "+table_rows_way2);
//
//
//
////	System.out.println("columns = "+columnsNo.size());
////	System.out.println("columns print = "+columnsNo);
//
//
//	
//	//table[@id="pr_id_7-table"]/tbody/tr/td/a/i
////	List <WebElement> columnsNo = driver.findElements(By.xpath("//table[@id='pr_id_13-table']/thead/tr/th"));
//
//	
////	List <WebElement> columnsNo = driver.findElements(By.xpath("//table[@id='pr_id_13-table']/thead/tr/th"));
//
//	
//    
		
		
		
//		public void validateMoreInfoOfTxn(int txnNo) throws InterruptedException {
//
//			if (validateALLTxnReportTableHasData()) {
//
//				int colNos = getTxnTable_columnNumbers(); // last column has 'more info (meatball)' icon so last column
//															// number should be used
//
//				WebElement moreInfoIcon = driver.findElement(By.xpath(
//						"//table[@class='p-datatable-table p-datatable-resizable-table p-datatable-resizable-table-fit ng-star-inserted']/tbody/tr["
//								+ txnNo + "]/td[" + colNos + "]/a/i"));
//				logger.log(LogStatus.INFO, "Click on more info (meatball) icon OPEN");
//				click(moreInfoIcon, driver, logger);
//				Thread.sleep(3000);
//				logger.log(LogStatus.INFO, "Click on more info (meatball) icon CLOSE");
//				click(txnMoreInfo_Close, driver, logger);
//
//			} else {
//
//				logger.log(LogStatus.INFO,
//						"validateMoreInfoOfTxn is failed.\b TABLE -> No Records Found.\bThe \"All Transactions Report\" tableHasData has no data");
//
//			}
//		}
//
//		public void paginationANDTableData_validation () throws IOException {
//	//1.check - table has data or not		
//			Boolean dataInTable =validateALLTxnReportTableHasData();
//			
//			if (dataInTable)
//			{
//				scrollToWebElement(pageSizeDropdown, driver);
//			int tableDataNumber = getTxnTable_rowNumbers();
//			int pageDataSizeSelected = getCurentPageDataSize();
//	//1a-yes => check - table has data - data is less or more than page size selected		
//			if(tableDataNumber>=pageDataSizeSelected)
//			{
//				logger.log(LogStatus.INFO, "Validate data per page and page size => data >= 10 nos.");
//				softAssert("STEP-Validate data per page and page size", String.valueOf(tableDataNumber), String.valueOf(pageDataSizeSelected), true, logger); 
//				logger.log(LogStatus.INFO, "Validate data per page and page size => data >= 10 nos."+capture(driver));	
//			}
//			else	
//			{
//				logger.log(LogStatus.INFO, "Validate data per page and page size => data is less than 10 nos.\bTable data nos.-"+tableDataNumber+"\bPage size nos.-"+pageDataSizeSelected);
//			}
//			 
//			}
//			else 
//	//1b-no => 
//				{
//				logger.log(LogStatus.INFO, "no data in table.... ");
//				}
//		
//		}
		
		
		
		
		
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss"); 
		String formattedDate = sdf. format(date); 
			
		System.out.println("date -"+formattedDate);
		
		
		
		
		
		
		
		
		
	}
	
	
	
}

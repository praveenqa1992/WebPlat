package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;

public class SearchTransactioReportPOM extends commonFunc{

	public WebDriver driver;
	public ExtentTest logger;
	public WebElement Element;
	
	
    @FindBy(xpath="//a [text()=' Search Transaction']")
	public WebElement searchTxnModule;
    
    @FindBy(xpath="//select[@class='form-select selectDrp ng-pristine ng-valid ng-touched']")
	public WebElement filterDropdown;
    
    @FindBy(xpath="//input[@type='search'] [@placeholder='Search']")
	public WebElement searchInputField;
    
    @FindBy(xpath="//button[text()='Search']")
	public WebElement searchButton;
    
    @FindBy(xpath="//table[@id='pr_id_54-table']")
	public WebElement asearchTxnTable;
    
    @FindBy(xpath="//span[@id='pr_id_55_label']")
	public WebElement paginationNumber;

//    @FindBy(xpath="")
//	public WebElement a;
	
    
	public SearchTransactioReportPOM(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
		
	public void click_searchTxnModule() {
		waitForElementToAppear(searchTxnModule, driver, logger);
		click(searchTxnModule, driver, logger);
		logger.log(LogStatus.INFO, "searchTxnModule");
		}
	
	public void click_filterDropdown() {
		waitForElementToAppear(filterDropdown, driver, logger);
		click(filterDropdown, driver, logger);
		logger.log(LogStatus.INFO, "click_filterDropdown");
		}
	
	public void enterText_searchInputField(String searchParameter) {
		waitForElementToAppear(searchInputField, driver, logger);
		sendingKeys(searchInputField, searchParameter, driver);
		logger.log(LogStatus.INFO, "search input field value -"+searchParameter);
		}
	
	public void click_searchButton() {
		waitForElementToAppear(searchButton, driver, logger);
		click(searchButton, driver, logger);
		logger.log(LogStatus.INFO, "click_searchButton");
		}
	
	public void selectFromFilterDropdown(String filterToApply) {

		waitForElementToAppear(filterDropdown, driver, logger);
        Select select = new Select (filterDropdown);
        
        try {
        	
        	select.selectByVisibleText(filterToApply);
           
        }catch(Exception e)
        {
        	
        	
        	
        }
        
        
	}
	
	
	
}

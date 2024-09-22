package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import common.commonFunc;

public class WalletPassbookPOM extends commonFunc{
	
	@FindBy(xpath = "//span[text()='Reports']")
	public WebElement reportsModule;

	@FindBy(xpath = "//a[@class='slide-item'] [text()=' Wallet Passbook']")
	public WebElement txnHistoryModule;
	
	@FindBy(xpath = "//input[@class='ng-tns-c46-10 p-inputtext p-component ng-star-inserted'][@placeholder='From Date']")
	public WebElement fromDate;
	
	@FindBy(xpath = "//input[@class='ng-tns-c46-11 p-inputtext p-component ng-star-inserted'][@placeholder='To Date']")
	public WebElement toDate;
	
	@FindBy(xpath = "//input[@class='ng-tns-c46-10 p-inputtext p-component ng-star-inserted']")
	public WebElement selectCalendar;
	
	@FindBy(xpath = "//button[@class='p-datepicker-month p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement month;

	@FindBy(xpath = "//button[@class='p-datepicker-year p-link ng-tns-c46-10 ng-star-inserted']")
	public WebElement year;	
	
	@FindBy(xpath = "//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c46-47 ng-star-inserted']")
	public WebElement prevClick;	
	

	
	public WebDriver driver;
	public ExtentTest logger;
	public WebElement Element;



	public WalletPassbookPOM(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	public void goToWalletPassbookPage() {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(reportsModule, driver, logger);
		click(reportsModule, driver, logger);
		
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(txnHistoryModule, driver, logger);
		click(txnHistoryModule, driver, logger);
	}
	
	public void searcHistory() throws InterruptedException {
		
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(fromDate, driver, logger);
		waitForElementToAppear(prevClick, driver, logger);
		waitForElementToAppear(selectCalendar, driver, logger);


		
		Thread.sleep(5000);
		//scrollUp(driver);
		click(selectCalendar, driver, logger);
		Thread.sleep(5000);
		
		String aMonth = month.getText();
		String aYear = year.getText();
		System.out.println(aMonth);
		System.out.println(aYear);
		Thread.sleep(5000);
		waitForElementToAppear(prevClick, driver, logger);
		
		while(!(aMonth.equals(" August ") && aYear.equals(" 2024 "))) {
			
			click(prevClick, driver, logger);
			
			
		}
		
	}

}

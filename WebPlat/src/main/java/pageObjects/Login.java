package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.commonFunc;
public class Login  extends commonFunc
{


	
	
	@FindBy(xpath="//input[@id='fullName']")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='Password']")
	public WebElement password;
	
	
	@FindBy(xpath="//button[text()=' Sign In ']")
	public WebElement btnSign;
	
	@FindBy(xpath="//h1[text()='News']//following-sibling::button[@aria-label='Close']")
	public WebElement closeDialogBox;

	public WebDriver driver;
	public ExtentTest logger;

	public WebElement Element;
	public static String title;




	public Login(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}


	
	public String signin(String user, String pass) throws InterruptedException {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(username, driver, logger);
		sendingKeys(username, user, driver);
		sendingKeys(password, pass, driver);
		click(btnSign, driver, logger);
		
		waitForPageLoaded(driver, logger);
		Thread.sleep(10000);
		
		title = driver.getTitle();
		
		return title;
		
//Thread.sleep(5000);
		
	}
	
	public void dialogClose() throws InterruptedException {
		waitForPageLoaded(driver, logger);
		waitForElementToAppear(closeDialogBox, driver, logger);
		
		click(closeDialogBox, driver, logger);
		Thread.sleep(2000);	
	}

			
	}
	
	










package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

@Listeners({ SuiteListener.class })
public class testbase {

	public static String path; //2.reports folder path with folder name
	public static String extentReportFile; //3.html report path with folder name
	public static String reqBrowser; //1.browser....used in @BeforeMethod method
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static config testConfig;
	public WebDriver driver;
	public AndroidDriver<MobileElement> driver_m;

	
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browser", "environment", "platformName", "os", "sharedDirectory", "mobileos", "appiumurl", "device",
			"resultsDir", "tomail", "cmsusername","cmspassword" })
	public void InitializeParameters(@Optional String browser, @Optional String environment,
			@Optional String platformName, @Optional String os, @Optional String sharedDirectory,
			@Optional String mobileos, @Optional String appiumurl, @Optional String device, @Optional String resultsdir,
			@Optional String tomail, @Optional String cmsusername, @Optional String cmspassword) throws IOException 
	{
		testConfig = new config();
		config.BrowserName = browser;
		config.Environment = environment;
		config.PlatformName = platformName;
		config.os = os;
		config.SharedDirectory = sharedDirectory;
		config.mobileos = mobileos;
		config.appiumurl = appiumurl;
		config.device = device;
		config.ResultsDir = resultsdir;
		config.tomail = tomail;
		config.cmsusername= cmsusername;
		config.cmspassword=cmspassword;

		testConfig = new config(logger);
	
	//1.browser...	used in @BeforeMethod method
		reqBrowser = testConfig.getRunTimeProperty("browser");

		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_SSS");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		
//2.reports FOLDER (path and name) as date as mentioned in above format...DECIDE
		path = testConfig.getRunTimeProperty("ResultsDir") + testConfig.getRunTimeProperty("fileSeparator") + strDate;

	//2B.reports folder (path and name) as date as mentioned in above format...CREATE folder to store html report
	
		new File(path).mkdirs();
		
//2C_html report......
		   //3.html report path with folder name
		//html report NAME...DECIDE
		extentReportFile = path + testConfig.getRunTimeProperty("fileSeparator")
				+ testConfig.getRunTimeProperty("reportfilename");
		
		// navigate to html report...CREATE
		File file = new File(extentReportFile);
		file.createNewFile();
	
		//Extent Reports class objjjjjjjjjjjjjj==============++++++++++++++++++====================
		extent = new ExtentReports(extentReportFile, true);
		
		//Extent Test class objjjjjjjjjjjjjjjjj========================
		
		//set/log INITIAL info to the report........
		
		//1.suite name...start test
		logger = extent.startTest("Configurations for : " + getSuiteName());//method to get suite name is at last
		
		//2.log info at suite name...start test
		logger.log(LogStatus.INFO, "Details for starting the suite",
				     "1. Browser name : " + testConfig.getRunTimeProperty("browser") + 
				"</br>2. Environment : "+ testConfig.getRunTimeProperty("environment") +
				"</br>3. Platform Name : "+ testConfig.getRunTimeProperty("platformName"));
		
		//3.suite name...end test
		//end test.....	after suite to FLUSH logs used in this method to the report	

		extent.endTest(logger);
	
	}
	
//logging basic information at REPORT top
//browser initialization
	
	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void startMethod(Method method) 
	{
		
		//get annotations mentioned in the "Test.class" and store in test......???????????????
		Test test = method.getAnnotation(Test.class);
	
		if (test == null) 
		{
			return;
		}
		
		String class_name = this.getClass().getName();
		
		//start test 2 (1st is in before suite method)...like second tab with mentioned/logged info
		
		logger = extent.startTest("Class_Name : " + class_name + "</br>" + "Test_Name : " + method.getName());
		
		logger.assignCategory(class_name); //?????????????????
		
		
		int flag = 1;
		try {

//platform - DESKTOP---------
			if (testConfig.getRunTimeProperty("platformname").equalsIgnoreCase("desktop")) 
			{
				
				//BROWSER REQUIRED - NO
				if (reqBrowser.equalsIgnoreCase("notrequired")) 
				{
					logger.log(LogStatus.INFO, "Browser required", "No");
					flag = 0;
		//flag = 0	===============	
				}
				
				//browser req - YES (desktop + browser)
				else if 
				(testConfig.getRunTimeProperty("os").equalsIgnoreCase("mac")) //os- mac....then initialize the CHROME DRIVER (name should be -"chromedriver")
				
				{
					
					//initialize the CHROME DRIVER ------------
					
					System.setProperty("webdriver.chrome.driver", testConfig.getRunTimeProperty("SharedDirectory")//chrome driver location
							+ testConfig.getRunTimeProperty("fileSeparator") + "chromedriver"); // chrome driver file name

					driver = new ChromeDriver();
					System.out.println(driver);
					
				} else if (testConfig.getRunTimeProperty("os").equalsIgnoreCase("windows")) 
				{
					if (reqBrowser.equalsIgnoreCase("chrome")) 
					{
						System.setProperty("webdriver.chrome.driver", testConfig.getRunTimeProperty("SharedDirectory")
								+ testConfig.getRunTimeProperty("fileSeparator") + "chromedriver_windows.exe");
						driver = new ChromeDriver();
						System.out.println(driver);
					} 
//					else if (reqBrowser.equalsIgnoreCase("mozilla")) {
//						System.setProperty("webdriver.gecko.driver", testConfig.getRunTimeProperty("SharedDirectory")
//								+ testConfig.getRunTimeProperty("fileSeparator") + "geckodriver.exe");
//						FirefoxProfile profile = new FirefoxProfile();
//						profile.setPreference("network.proxy.type", ProxyType.SYSTEM.ordinal());
//						driver = new FirefoxDriver();
//					}
				}
			}
////platform - MOBILE---------

			else if (testConfig.getRunTimeProperty("platformname").equalsIgnoreCase("mobile")) {
				flag = 2;
				if (reqBrowser.equalsIgnoreCase("notrequired")) 
				{
					logger.log(LogStatus.INFO, "Browser required", "No");
					flag = 0;
				} 
				else if 
				
			//MOBILE OS - ANDROID	
				(testConfig.getRunTimeProperty("mobileos").equalsIgnoreCase("android")) 
				{
					DesiredCapabilities capabilities = new DesiredCapabilities();
			
				//	OS - MAC	
					if (testConfig.getRunTimeProperty("os").equalsIgnoreCase("mac")) 
					{
						capabilities.setCapability("chromedriverExecutable",
								testConfig.getRunTimeProperty("SharedDirectory")
										+ testConfig.getRunTimeProperty("fileSeparator") + "chromedriver");
			//	OS - WINDOWS		
					} else if (testConfig.getRunTimeProperty("os").equalsIgnoreCase("windows")) 
					{
						capabilities.setCapability("chromedriverExecutable",
								testConfig.getRunTimeProperty("SharedDirectory")
										+ testConfig.getRunTimeProperty("fileSeparator") + "chromedriver_windows.exe");
					}
					
					capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
					capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
					capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
							
							testConfig.getRunTimeProperty("device"));
					
					capabilities.setCapability("showChromedriverLog", true);
					
					URL url = null;
					try 
					{
						url = new URL(testConfig.getRunTimeProperty("appiumurl"));
					} catch (MalformedURLException e) 
					{
						e.printStackTrace();
					}
					driver_m = new AndroidDriver<MobileElement>(url, capabilities);
				}

			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Browser Open", e.getLocalizedMessage());
			
			//MOST IMP.......
			//end test.....	 to FLUSH logs used in this method to the report if unable to open the browser...thst's why endTest is called in CATCH block 
			//if called out side the box all logs will be flushed as method starts and not when method ends.)

			extent.endTest(logger);
					}
		
		//platform - ( desktop or android + no browser required).... flag = 0
		//platform - android ... flag = 2

// maximize browser after opening it..................		
		if (flag == 1) {
			logger.log(LogStatus.INFO, "Browser Open", "Browser opened successfully");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		
		//if properties file has URL provided then navigate to that url..........	
			if (testConfig.getRunTimeProperty("url")!=null) 
			{
				driver.get(testConfig.getRunTimeProperty("url"));
			}
			logger.log(LogStatus.INFO, "Browser Maximize", "Browser maximized sucessfully");
		}
	}

	
	@SuppressWarnings("deprecation")
	@AfterMethod(alwaysRun = true)
	public void endMethod(ITestResult result) throws IOException, InterruptedException 
	{
		try {
			
			if (result.getStatus() == ITestResult.FAILURE) 
			{
				logger.log(LogStatus.FAIL, result.getName() + " : Test case failed due to : ", result.getThrowable());

			//if browser is not required	
				
				if (!reqBrowser.equalsIgnoreCase("notrequired")) 
				{
				//	take screenshot................
					File scrf_a = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

					
					String encodedBase64 = null;
					FileInputStream fileInputStreamReader = null;
					try 
					{
				//read/navigate to screenshot taken............
						fileInputStreamReader = new FileInputStream(scrf_a);
						
				//get the screenshot length ==> to convert into byte		
						byte[] bytes = new byte[(int) scrf_a.length()];
				//read the bytes	
						fileInputStreamReader.read(bytes);
						
				//ENCODE bytes to base64 string		
						encodedBase64 = new String(Base64.encodeBase64(bytes));
						
					} catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
					
					
					String final_file_path = "data:image/png;base64," + encodedBase64;
					String image_a = logger.addScreenCapture(final_file_path);
					logger.log(LogStatus.FAIL, "Test case failed. Please check - visible image", image_a);

					// ************** Commenting code for full page screenshot ******************
//					String newPath_b = path + "/" + result.getName() + "_2.jpg";
//					Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
//							.takeScreenshot(driver);
//					ImageIO.write(screenshot.getImage(), "jpg", new File(newPath_b));
//					String image_b = logger.addScreenCapture(newPath_b);
//					logger.log(LogStatus.FAIL, "Test case failed. Please check - full image", image_b);
				}
			} else if (result.getStatus() == ITestResult.SUCCESS) 
			{
				logger.log(LogStatus.PASS, result.getName() + " : Test case passed");
			} else 
			{
				logger.log(LogStatus.SKIP, result.getName() + " : Test case skipped due to : ", result.getThrowable());
			}

		} catch (Exception e) 
		{
			logger.log(LogStatus.WARNING, "Final test step failed due to : ", e.toString());
		} finally 
		{
			if ((!reqBrowser.equalsIgnoreCase("notrequired"))
					&& (testConfig.getRunTimeProperty("platformname").equalsIgnoreCase("desktop"))) 
			{
				Thread.sleep(5000);
				driver.quit();
				logger.log(LogStatus.PASS, "Browser Closed");
			} else if ((!reqBrowser.equalsIgnoreCase("notrequired"))
					&& (testConfig.getRunTimeProperty("platformname").equalsIgnoreCase("mobile"))) 
			{
				Thread.sleep(5000);
				driver_m.quit();
				logger.log(LogStatus.PASS, "Browser Closed");
			}
			
	//end test.....	after every method to FLUSH logs to the report	
			extent.endTest(logger);
		//	extent.config().addCustomStylesheet("/Users/praveenkumar/Downloads/data.css");
		}
	}

	
	@AfterSuite(alwaysRun = true)
	public void dumpParameters() throws IOException {
		//extent.config().addCustomStylesheet("/Users/praveenkumar/Downloads/data.css");// File.separator;
		extent.flush();
		extent.close();
		
	//send the report on mail.........
		
		String bodyData = "1. Browser name : " + testConfig.getRunTimeProperty("browser") + 
				        "\n2. Environment : "+ testConfig.getRunTimeProperty("environment") + 
				        "\n3. Platform Name : "+ testConfig.getRunTimeProperty("platformName") + 
				        "\n4. OS : " + testConfig.getRunTimeProperty("os")
				      + "\n5. To Mail : " + testConfig.getRunTimeProperty("tomail")+ 
				        "\n6. style : " + testConfig.getRunTimeProperty("style") + 
				        "\n\n PFA report.";
		
		sendmail sendmail = new sendmail();
		sendmail.SendMail(testConfig.getRunTimeProperty("tomail"), testConfig.getRunTimeProperty("replyto"),
				"Automation Report : " + getSuiteName(), path, testConfig.getRunTimeProperty("reportemail"),
				testConfig.getRunTimeProperty("reportpassword"), bodyData);
	}

	public String getSuiteName() {
		ISuite suiteListner = SuiteListener.getAccess();
		String runningSuite = suiteListner.getName();
		return runningSuite;
	}

}
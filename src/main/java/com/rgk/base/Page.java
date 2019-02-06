package com.rgk.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.rgk.pages.actions.TopNavigation;
import com.rgk.utilities.ExcelReader;
import com.rgk.utilities.ExtentManager;

public class Page {

	// initialize webdriver
	// excel reader
	// logs
	// webdriver wait
	// explict and implicit waits
	// extent reports

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopNavigation topNav;

	public static void initConfiguration() {

		if (Constants.browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.debug("Launching firefox");
			Reporter.log("Firefox launched !!");
		} else if (Constants.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			log.debug("Chrome launched!!");
			Reporter.log("Chrome launched !!");
		} else if (Constants.browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.debug("IE launched!!");
			Reporter.log("IE launched !!");
		}
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Constants.implicitwait,
		// TimeUnit.SECONDS);
		topNav = new TopNavigation(driver);
	}

	// Implementation of common keywords and functions
	public static void click(WebElement element) {

		element.click();
		log.debug("Clicking on element:- " + element);
		test.log(LogStatus.INFO, "Clicked on:- " + element);
	}

	public static void type(WebElement element, String value) {

		element.sendKeys(value);
		log.debug("Typing in element:- " + element + "entered valye is" + value);
		test.log(LogStatus.INFO, "Typing in element:- " + element + "entered valye is" + value);
	}

	public static void quitBrowser() {
		driver.quit();
	}
}

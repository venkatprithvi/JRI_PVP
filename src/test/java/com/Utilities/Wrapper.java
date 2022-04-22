package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wrapper {

	public static WebDriver driver;
	Properties prop = new Properties();

	/*************************************************************
	 * wrapper class constructor
	 ************************************************************/
	public Wrapper() {

		File screenShotPath = new File(".\\ScreenShots");
		if (screenShotPath.exists()) {
			System.out.println("ScreenShots folder is avilable");
		} else {
			screenShotPath.mkdir();
			System.out.println("ScreenShot folder is created");
		}
	}

	/***************************************************************
	 * Driver created for Chrome Browser and maximize the browser
	 ************************************************************/
	public void chromeBrowserLaunch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome Browser launched and maximized");
	}

	/****************************************************************
	 * Driver created for firefox Browser and maximize the browser
	 * 
	 ****************************************************************/
	public void firefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("FireFox Browser launched and maximized");
	}

	/************************************************************
	 * Driver created for edge Browser and maximize the browser
	 ************************************************************/
	public void edgeBrowserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		System.out.println("Edge Browser launched and maximized");
	}

	/*********************************************************************
	 * Muilti browser Launch based on user selection chrome/firefox/edge
	 *********************************************************************/
	public void multiBrowserLaunch(String browserName) {

		System.out.println("Choosing One in multibrowser");
		if (browserName.equalsIgnoreCase("chrome")) {
			chromeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			firefoxBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("edge")) {
			edgeBrowserLaunch();
		} else {
			System.out.println("******Please check the browerName******");
		}
	}

	/************************************************************
	 * Browser Closing with time delay of 3 sec
	 * 
	 * @throws InterruptedException
	 **********************************************************/
	public void browserClosing() throws InterruptedException {
		Thread.sleep(3000);
		// close - closes the current tab if it is the only tab it closes the browser
		driver.close();
		System.out.println("Browser closed and quit the driver");
	}

	/************************************************************
	 * loading Property file
	 ************************************************************/
	public void loaddata_From_Prop_File(String x) throws FileNotFoundException, IOException {
		File file = new File(x);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/***********************************************************
	 * get data from input stream file
	 ***********************************************************/
	public String getdata_from_prop(String key) throws IOException {
		String keyvalue = null;
		keyvalue = prop.getProperty(key);
		return keyvalue;

	}

	/***********************************************************
	 * get data from input stream file
	 * 
	 * @return
	 ***********************************************************/
	public void UrlPageOpening(String x) {
		implicitWait(10);
		driver.get(x);
	}

	/***********************************************************
	 * ClickByLocator
	 * 
	 * @throws InterruptedException
	 ***********************************************************/
	public void clickByLocator(By locat) throws InterruptedException {
		WebElement element = driver.findElement(locat);
		if (element.isDisplayed()) {
			System.out.println(locat + " : element is enabled");
			if (element.isEnabled()) {
				driver.findElement(locat).click();
				implicitWait(10);
				System.out.println(locat + " : element clicked");
			} else {
				System.out.println(locat + " : element is not enabled");
			}
		} else {
			System.out.println(locat + " : element is not displayed");
		}
	}

	/****************************************************************
	 * Implicit wait
	 **************************************************************/
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		System.out.println("******ImplicitWait method used ******");
	}

	/****************************************************************
	 * Current - TimeStamp
	 * 
	 * @return
	 **************************************************************/
	public String currentTimeStamp() {
		Date abc = new Date(0);
		DateFormat df = new SimpleDateFormat("yyyyMMMdd_HH_mm_ss");
		String timeStamp = df.format(abc);
		return timeStamp;
	}
	
	/***********************************************************************
	 * take - screenshot
	 * 
	 * @throws Exception
	 ****************************************************************************/

	public void takescreenshotWithTimeStamp(String nameOfTheFile) throws Exception {
		// take a screeshot: stored into RAM location
		File myscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// move the screenshot to specific folder above path
		FileHandler.copy(myscreenshot,
				new File("Z:\\SeleniumEclipseWorkspace\\JRI_PROJECT\\ScreenShots" + nameOfTheFile
						+ currentTimeStamp() + ".PNG"));
	}


	/****************************************************************
	 * Validation expected_value vs real_value
	 **************************************************************/
	@SuppressWarnings("unlikely-arg-type")
	public void Validation_exp_vs_real(By real, String expected) {
		if (real.equals(expected)) {
			System.out.println("expected - is matching with real ");
		} else {
			System.out.println("expected - is not matching with - real ");
		}
	}

	/****************************************************************
	 * Getting text of a locator
	 **************************************************************/
	public String getTextByAnyLocator(By Locator) {
		String elementText = driver.findElement(Locator).getText();
		System.out.println("elementText Text is: " + elementText);
		return elementText;
	}

	/*
	 * ************************************************************* Send key by
	 * using any locator
	 ************************************************************/
	public void sendKeysByAnyLocator(By locator, String inputData) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				element.clear();
				element.sendKeys(inputData);
			} else {
				System.out.println("Webelement is not enabled state on Screen,plz check");
			}
		} else {
			System.out.println("Webelement is not displayed on Screen,plz check");
		}
	}
}

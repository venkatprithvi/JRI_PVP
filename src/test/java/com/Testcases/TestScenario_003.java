package com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ObjectRepository.Locators;
import com.Utilities.Wrapper;

public class TestScenario_003 extends Wrapper {
	Locators loc = new Locators();

	/*********************************************************************
	 * Before function to run driver creation and loading properties file
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 *********************************************************************/
	@BeforeMethod
	public void BeforeTestcaseRun() throws IOException, InterruptedException {
		Thread.sleep(2000);
		loaddata_From_Prop_File("Z:\\SeleniumEclipseWorkspace\\JRI_PROJECT\\testData\\input.properties");
		multiBrowserLaunch("Chrome");
	}

	/*********************************************************************
	 * After function to run driver creation and loading properties file
	 * 
	 * @throws Exception
	 *********************************************************************/
	@AfterMethod
	public void AfterTestcaseRun() throws Exception {
		implicitWait(10);
		browserClosing();
	}

	/*********************************************************************
	 * Tc_001 opening JRI home page
	 * 
	 * @throws IOException
	 ********************************************************************/
	@Test
	public void Tc_021() throws IOException {
		UrlPageOpening(getdata_from_prop("HomePageURL"));
		Assert.assertEquals("https://www.justrechargeit.com/", driver.getCurrentUrl());
	}
	
	/*********************************************************************
	 * Tc_001 opening JRI home page
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 ********************************************************************/
	@Test
	public void Tc_022() throws Exception {
		Tc_021();
		clickByLocator(loc.sign_in_a_href_link);
		sendKeysByAnyLocator(loc.Sign_in_email_field,getdata_from_prop("JRIemail"));
		sendKeysByAnyLocator(loc.Sign_in_password_field, getdata_from_prop("JRIpassword"));
		sendKeysByAnyLocator(loc.Sign_in_capture_field, scannerInputText());
		Thread.sleep(5000);
		clickByLocator(loc.Sign_in_secure_sign_in_buttion);
		takescreenshotWithTimeStamp("abcd");
	}
	
}




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
	public void Tc_001() throws IOException {
		UrlPageOpening(getdata_from_prop("HomePageURL"));
		Assert.assertEquals("https://www.justrechargeit.com/", driver.getCurrentUrl());
	}
}

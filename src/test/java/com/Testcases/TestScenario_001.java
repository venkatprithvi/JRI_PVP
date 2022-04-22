package com.Testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ObjectRepository.Locators;
import com.Utilities.Wrapper;

public class TestScenario_001 extends Wrapper {
	Locators loc = new Locators();

	/*********************************************************************
	 * Before function to run driver creation and loading properties file
	 * 
	 * @throws IOException
	 *********************************************************************/
	@BeforeMethod
	public void BeforeTestcaseRun() throws IOException {
		
		loaddata_From_Prop_File("Z:\\SeleniumEclipseWorkspace\\JRI_PROJECT\\testData\\input.properties");
		multiBrowserLaunch("Chrome");
	}

	/*********************************************************************
	 * After function to run driver creation and loading properties file
	 * 
	 * @throws InterruptedException
	 *********************************************************************/
	@AfterMethod
	public void AfterTestcaseRun() throws FileNotFoundException, IOException, InterruptedException {
		implicitWait(10);
		browserClosing();
	}

	/************************************************************
	 * TC 001 : Test case to check project home page is opening or not
	 **************************************************************/
	@Test
	public void Tc_001() throws Exception {

		UrlPageOpening(getdata_from_prop("HomePageURL"));
		Thread.sleep(3000);
		Assert.assertEquals("https://www.justrechargeit.com/", driver.getCurrentUrl());
	}

	/************************************************************
	 * TC 002 : Checking "create new account" anchor link
	 **************************************************************/
	@Test
	public void Tc_002() throws Exception {
		Tc_001();
		clickByLocator(loc.create_new_account_a_href_link);
		Thread.sleep(3000);
	}

	/*****************************************************************************************
	 * TC 003 : checking new account creation by direct submitting the form with out
	 * filling fields
	 *****************************************************************************************/
	@Test
	public void Tc_003() throws Exception {
		Tc_002();
		clickByLocator(loc.New_account_creation_submit_buttion);
		Assert.assertEquals("Enter your name", getTextByAnyLocator(loc.failure_name_field) );
	}

	/*****************************************************************************************
	 * TC 004 : checking new account creation - fill name field with value - and
	 * submit - shows error message "Enter mobile no" fields
	 *****************************************************************************************/
	@Test
	public void Tc_004() throws Exception {
		Tc_002();
		sendKeysByAnyLocator(loc.New_account_creation_name_fill, "Prithvi");
		clickByLocator(loc.New_account_creation_submit_buttion);
		Assert.assertEquals("Enter mobile no.", getTextByAnyLocator(loc.failure_mobile_field));
	}
	
	/*****************************************************************************************
	 * TC 005 : checking new account creation - fill name,mobileno field with value - and
	 * submit - shows error message "Enter your email id" fields
	 *****************************************************************************************/
	@Test
	public void Tc_005() throws Exception {
		Tc_002();
		sendKeysByAnyLocator(loc.New_account_creation_name_fill, "Prithvi");
		sendKeysByAnyLocator(loc.New_account_creation_mobile_no_fill, "8885522518");
		clickByLocator(loc.New_account_creation_submit_buttion);
		Assert.assertEquals("Enter your email id", getTextByAnyLocator(loc.failure_email_field));
	}
	
	/*****************************************************************************************
	 * TC 006 : checking new account creation - fill name,mobile no, email id field with value - and
	 * submit - shows error message "Enter your password" fields
	 *****************************************************************************************/
	@Test
	public void Tc_006() throws Exception {
		Tc_002();
		sendKeysByAnyLocator(loc.New_account_creation_name_fill, "Prithvi");
		sendKeysByAnyLocator(loc.New_account_creation_mobile_no_fill, "8885522518");
		sendKeysByAnyLocator(loc.New_account_creation_email_fill,"jsdnjnsnvjnn@gmail.com");
		clickByLocator(loc.New_account_creation_submit_buttion);
		Assert.assertEquals("Enter your password",getTextByAnyLocator(loc.failure_password_field));
	}
	
	/*****************************************************************************************
	 * TC 007 : click new account creation - fill name,mobile no, email, password - id field 
	 * with value - and submit - shows warning message "Please agree to the terms & conditions" 
	 *****************************************************************************************/
	@Test
	public void Tc_007() throws Exception {
		Tc_002();
		sendKeysByAnyLocator(loc.New_account_creation_name_fill, "Prithvi");
		sendKeysByAnyLocator(loc.New_account_creation_mobile_no_fill, "8885522518");
		sendKeysByAnyLocator(loc.New_account_creation_email_fill,"jsdnjnsnvjnn@gmail.com");
		sendKeysByAnyLocator(loc.New_account_creation_password_fill, "123456");
		clickByLocator(loc.New_account_creation_submit_buttion);
		Assert.assertEquals("Please agree to the terms & conditions",getTextByAnyLocator(loc.failure_t_n_c_field));
	}
	
	/*****************************************************************************************
	 * TC 008 : click new account creation - fill name,mobile no, email, password - id field 
	 * with value - and then click on refresh icon  
	 *****************************************************************************************/
	@Test
	public void Tc_008() throws Exception {
		Tc_002();
		sendKeysByAnyLocator(loc.New_account_creation_name_fill, "Prithvi");
		sendKeysByAnyLocator(loc.New_account_creation_mobile_no_fill, "8885522518");
		sendKeysByAnyLocator(loc.New_account_creation_email_fill,"jsdnjnsnvjnn@gmail.com");
		sendKeysByAnyLocator(loc.New_account_creation_password_fill, "123456");
		driver.navigate().refresh();
		Assert.assertEquals("", getTextByAnyLocator(loc.failure_name_field) );
		Assert.assertEquals("", getTextByAnyLocator(loc.failure_mobile_field));
		Assert.assertEquals("", getTextByAnyLocator(loc.failure_email_field));
		Assert.assertEquals("",getTextByAnyLocator(loc.failure_password_field));
	}
	
	/*****************************************************************************************
	 * TC 010 : click new account creation - fill name,mobile no, email, password - id field 
	 * with value - and then click on submit-redirect to myaccount_directory page  
	 *****************************************************************************************/
	@Test
	public void Tc_010() throws Exception {
		Tc_002();
		sendKeysByAnyLocator(loc.New_account_creation_name_fill, "Prithvi");
		sendKeysByAnyLocator(loc.New_account_creation_mobile_no_fill, "9885122518");
		sendKeysByAnyLocator(loc.New_account_creation_email_fill,"jsdn1jnsnvjnn@gmail.com");
		sendKeysByAnyLocator(loc.New_account_creation_password_fill, "123456");
		clickByLocator(loc.New_account_creation_t_n_c_checkbox);
		clickByLocator(loc.New_account_creation_submit_buttion);
		Assert.assertEquals("https://www.justrechargeit.com/myaccount_directory.aspx", driver.getCurrentUrl());
	}
}

package com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ObjectRepository.Locators;
import com.Utilities.Wrapper;

public class TestScenario_002 extends Wrapper {
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
		takescreenshotWithTimeStamp("JRI_");
		browserClosing();
	}

	/************************************************************
	 * TC 011 : Test case to check project home page is opening or not
	 **************************************************************/
	@Test
	public void Tc_011() throws Exception {
		UrlPageOpening(getdata_from_prop("HomePageURL"));
		Thread.sleep(3000);
		Assert.assertEquals("https://www.justrechargeit.com/", driver.getCurrentUrl());
	}

	/************************************************************
	 * TC 012 : sign-in page sign-in link test
	 **************************************************************/
	@Test
	public void Tc_012() throws Exception {
		Tc_011();
		clickByLocator(loc.sign_in_a_href_link);
		clickByLocator(loc.sign_in_inside_sign_in);
		Assert.assertEquals("https://www.justrechargeit.com/SignIn.aspx", driver.getCurrentUrl());
	}

	/************************************************************
	 * TC 013 : sign-in page sign-in link test
	 **************************************************************/
	@Test
	public void Tc_013() throws Exception {
		Tc_011();
		clickByLocator(loc.sign_in_a_href_link);
		clickByLocator(loc.sign_in_inside_sign_in);
		if (driver.findElement(loc.Sign_in_email_field).isDisplayed()
				&& driver.findElement(loc.Sign_in_password_field).isDisplayed()
				&& driver.findElement(loc.Sign_in_capture_field).isDisplayed()
				&& driver.findElement(loc.Sign_in_secure_sign_in_buttion).isDisplayed()
				&& driver.findElement(loc.Sign_in_sign_in_with_facebook).isDisplayed()
				&& driver.findElement(loc.Sign_in_sign_in_with_google).isDisplayed()) {
			System.out.println("all web elements founded ");
		} else {
			System.out.println("all elements not found");
		}

		clickByLocator(loc.Sign_in_forgot_password);
		if (driver.findElement(loc.Sign_in_forgot_password_emailid).isDisplayed()
				&& driver.findElement(loc.Sign_in_forgot_password_get_password).isDisplayed()) {
			System.out.println("web elements displayed");
		} else {
			System.out.println("web elements not found");
		}
	}

	/************************************************************
	 * TC 014 : sign-in page sign-in link test
	 **************************************************************/
	@Test
	public void Tc_014() throws Exception {
		Tc_012();
		clickByLocator(loc.Sign_in_secure_sign_in_buttion);
		Assert.assertEquals("Enter your email", getTextByAnyLocator(loc.sign_in_email_validation));
		sendKeysByAnyLocator(loc.Sign_in_email_field, "pvpseleniumlearnings@gmail.com");
		clickByLocator(loc.Sign_in_secure_sign_in_buttion);
		Assert.assertEquals("Enter your password", getTextByAnyLocator(loc.sign_in_password_validation));
		sendKeysByAnyLocator(loc.Sign_in_email_field, "pvpseleniumlearnings@gmail.com");
		sendKeysByAnyLocator(loc.Sign_in_password_field, "123456");
		clickByLocator(loc.Sign_in_secure_sign_in_buttion);
		Assert.assertEquals("Enter captcha properly", getTextByAnyLocator(loc.sign_in_capture_validation));
	}

	/************************************************************
	 * TC 015 : sign-in page sign-in link test
	 **************************************************************/
	@Test
	public void Tc_015() throws Exception {
		Tc_012();
		clickByLocator(loc.sign_in_a_href_link);
		sendKeysByAnyLocator(loc.Sign_in_email_field,getdata_from_prop("JRIemail"));
		sendKeysByAnyLocator(loc.Sign_in_password_field, getdata_from_prop("JRIpassword"));
		sendKeysByAnyLocator(loc.Sign_in_capture_field, scannerInputText());
		Thread.sleep(5000);
		clickByLocator(loc.Sign_in_secure_sign_in_buttion);
	}
	
	/************************************************************
	 * TC 016 : sign up and followed by sign out
	 **************************************************************/
	@Test
	public void Tc_016() throws Exception {
		Tc_012();
		clickByLocator(loc.sign_in_a_href_link);
		sendKeysByAnyLocator(loc.Sign_in_email_field,getdata_from_prop("JRIemail"));
		sendKeysByAnyLocator(loc.Sign_in_password_field, getdata_from_prop("JRIpassword"));
		sendKeysByAnyLocator(loc.Sign_in_capture_field, scannerInputText());
		Thread.sleep(5000);
		clickByLocator(loc.Sign_in_secure_sign_in_buttion);
		Thread.sleep(5000);
		clickByLocator(loc.sign_in_sign_out);
	}

	/************************************************************
	 * TC 017 : forgot password - popup alert - email - accept
	 **************************************************************/
	@Test
	public void Tc_017() throws Exception {
		Tc_012();
		clickByLocator(loc.Sign_in_forgot_password);
		Thread.sleep(3000);
		if (driver.findElement(loc.sign_in_forgotpassword_email_field).isDisplayed()) {
			System.out.println("page has displayed");
		}
		;
	}

	/************************************************************
	 * TC 018 : forgot password - popup alert - email - accept
	 **************************************************************/
	@Test
	public void Tc_018() throws Exception {
		Tc_012();
		clickByLocator(loc.Sign_in_forgot_password);
		Thread.sleep(3000);
		if (driver.findElement(loc.sign_in_forgotpassword_email_field).isDisplayed()
				&& driver.findElement(loc.Sign_in_forgot_password_get_password).isDisplayed()) {
			System.out.println("email and get password elements founded");
		} else {
			System.out.println("email and get password elements not founded");
		}
	}

	/************************************************************
	 * TC 019 : forgot password - popup alert - email - accept
	 **************************************************************/
	@Test
	public void Tc_019() throws Exception {
		Tc_012();
		clickByLocator(loc.Sign_in_forgot_password);
		Thread.sleep(3000);

		clickByLocator(loc.Sign_in_forgot_password_get_password);
		Assert.assertEquals("Enter your email",
				getTextByAnyLocator(loc.sign_in_forgetpassword_email_validation_warning));

		sendKeysByAnyLocator(loc.sign_in_forgotpassword_email_field, "venkat");
		System.out.println(getTextByAnyLocator(loc.sign_in_forgetpassword_email_validation_warning));
		clickByLocator(loc.Sign_in_forgot_password_get_password);
		Assert.assertEquals("Enter valid login email",
				getTextByAnyLocator(loc.sign_in_forgetpassword_email_validation_warning));
	}

	/************************************************************
	 * TC 020 : forget password success - checking email
	 **************************************************************/
	@Test
	public void Tc_20() throws Exception {
		Tc_012();
		clickByLocator(loc.Sign_in_forgot_password);
		Thread.sleep(3000);
		sendKeysByAnyLocator(loc.sign_in_forgotpassword_email_field, "pvpseleniumlearnings@gmail.com");
		clickByLocator(loc.Sign_in_forgot_password_get_password);
		clickByLocator(loc.sign_in_forgetpassword_password_sent_close);
		// gmail signup page
		UrlPageOpening(getdata_from_prop("GmailSigninPage"));

		sendKeysByAnyLocator(loc.gmail_id_Tfield, getdata_from_prop("gmailusername"));
		clickByLocator(loc.gmail_emailid_next);
		sendKeysByAnyLocator(loc.gmail_password_Tfield,getdata_from_prop("gmailpassword"));
		clickByLocator(loc.gmail_password_next);
		clickByLocator(loc.google_all_icon);
		Thread.sleep(3000);
		System.out.println("partially developed");
	}
}

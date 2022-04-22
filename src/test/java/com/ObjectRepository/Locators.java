package com.ObjectRepository;

import org.openqa.selenium.By;

public class Locators 
{
/****** Create New Account - tab *********/	
public final By create_new_account_a_href_link = By.xpath("//a[@id='signup-link9']");

/****** Form Filling text fields *********/	
public final By New_account_creation_submit_buttion = By.xpath("//input[@id='imgbtnSubmit']");
public final By New_account_creation_name_fill = By.xpath("//input[@id='signup_name']");
public final By New_account_creation_mobile_no_fill = By.xpath("//input[@id='signup_mobileno']");
public final By New_account_creation_email_fill = By.xpath("//input[@id='signup_email']");
public final By New_account_creation_password_fill = By.xpath("//input[@id='signup_password']");

public final By New_account_creation_t_n_c_checkbox = By.xpath("//input[@id='checkbox']");

/****** Form Filling text fields *********/
public final By failure_name_field = By.xpath("//td[@id='nameTD']");
public final By failure_mobile_field = By.xpath("//td[@id='mobilenoTD']");
public final By failure_email_field = By.xpath("//td[@id='emailTD']");
public final By failure_password_field = By.xpath("//td[@id='passwordTD']");
public final By failure_t_n_c_field = By.xpath("//td[@id='tdcondition']");

/*************Sign - in *********************/
public final By sign_in_a_href_link = By.xpath("//a[@id='jriTop_signin9']");
public final By sign_in_inside_sign_in = By.xpath("//tbody/tr[@id='pagetitle']/td[1]/ul[1]/li[1]/a[1]");
public final By sign_in_inside_sign_in_class = By.className("current");
public final By Sign_in_email_field = By.xpath("//input[@id='txtUserName']");
public final By Sign_in_password_field = By.xpath("//input[@id='txtPasswd']");
public final By Sign_in_capture_field = By.xpath("//input[@id='txtCaptcha']");
/*---------------------*/
public final By Sign_in_forgot_password = By.xpath("//a[@id='forgotpassword']");
/*---------------------*/
public final By Sign_in_sign_in_with_facebook = By.xpath("//tbody/tr[2]/td[1]/a[1]/img[1]");
public final By Sign_in_sign_in_with_google = By.xpath("//tbody/tr[3]/td[1]/a[1]/img[1]");
/*---------------------*/
public final By Sign_in_forgot_password_emailid = By.xpath("//input[@id='forgotpass_txtEmailId']");
public final By Sign_in_forgot_password_get_password = By.xpath("//input[@id='forgotpass_imgbtnSubmit']");
/*---------------------*/
public final By Sign_in_secure_sign_in_buttion = By.xpath("//input[@id='imgbtnSignin']");
/*---------------------*/
public final By sign_in_email_validation = By.xpath("//span[@id='MessageCaption2']");
public final By sign_in_password_validation = By.xpath("//span[@id='MessageCaption3']");
public final By sign_in_capture_validation = By.xpath("//span[@id='MessageCaption4']");


}

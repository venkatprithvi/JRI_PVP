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
/*---------------------*/
public final By sign_in_forgotpassword_email_field = By.xpath("//input[@id='forgotpass_txtEmailId']");
public final By sign_in_forgotpassword_getpassword_button = By.xpath("//input[@id='forgotpass_imgbtnSubmit']");
public final By sign_in_forgetpassword_email_validation_warning = By.xpath("//span[@id='forgotpass_lblError']");
public final By sign_in_forgetpassword_password_sent_success_message = By.xpath("//tbody/tr[4]/td[1]/div[1]/span[1]/span[1]");
public final By sign_in_forgetpassword_password_sent_close = By.xpath("//body/form[@id='signin']/div[@id='forgotpasswordform']/div[@id='heading']/span[1]/a[1]/img[1]");
/*--------------------------*/
public final By sign_in_sign_out = By.xpath("//a[@id='jriTop_signOut']");

/*********GMAIL LOGIN***********/
public final By gmail_id_Tfield = By.xpath("//input[@id='identifierId']");
public final By gmail_emailid_next = By.xpath("//span[contains(text(),'Next')]");
public final By gmail_password_Tfield = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
public final By gmail_password_next = By.xpath("//span[contains(text(),'Next')]");
public final By google_all_icon = By.xpath("//header/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/*[1]");

/***************After sign-up -->> directory page  *******************/
public final By directory_mob_serv_num = By.xpath("//input[@id='txtMobileNo']");
public final By directory_mob_serv_providers = By.xpath("//select[@id='ddlMobileServiceProvider']");
public final By directory_mob_nickname = By.xpath("//input[@id='txtMobileNickName']");
/*-----------------------------------------*/
public final By directory_mob_serv_num_warning_message = By.xpath("//span[@id='errorMsgMobile']");

public final By directory_services_add_button = By.xpath("//input[@id='btnAddServices']");

}



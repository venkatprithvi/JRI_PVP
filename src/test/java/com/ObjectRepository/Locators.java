package com.ObjectRepository;

import org.openqa.selenium.By;

public class Locators 
{
/****** Create New Account - tab *********/	
public final By create_new_account = By.xpath("//a[@id='signup-link9']");

/****** Form Filling text fields *********/	
public final By New_account_creation_submit_buttion = By.xpath("//input[@id='imgbtnSubmit']");
public final By New_account_creation_name_fill = By.xpath("//input[@id='signup_name']");
public final By New_account_creation_mobile_no_fill = By.xpath("//input[@id='signup_mobileno']");
public final By New_account_creation_email_fill = By.xpath("//input[@id='signup_email']");
public final By New_account_creation_password_fill = By.xpath("//input[@id='signup_password']");

/****** Form Filling text fields *********/
public final By failure_name_field = By.xpath("//td[@id='nameTD']");
public final By failure_mobile_field = By.xpath("//td[@id='mobilenoTD']");
public final By failure_email_field = By.xpath("//td[@id='emailTD']");
public final By failure_password_field = By.xpath("//td[@id='passwordTD']");

}

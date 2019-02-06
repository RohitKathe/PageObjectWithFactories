package com.rgk.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPageLocators {

	

	@FindBy(xpath="//input[@id='gss-signin-email']")
	public WebElement email;
	
	
	@FindBy(xpath="//input[@id='gss-signin-password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@id='gss-signin-submit']")
	public WebElement submit;
}

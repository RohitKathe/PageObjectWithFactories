package com.rgk.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {

	@FindBy(xpath="//button[@id='header-account-menu']")
	public WebElement account;
	
	
	@FindBy(xpath="//a[@id='account-signin']")
	public WebElement signInBtn;
	
}

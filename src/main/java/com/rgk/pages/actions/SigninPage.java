package com.rgk.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rgk.base.Page;
import com.rgk.pages.locators.SigninPageLocators;

public class SigninPage extends Page {

	public SigninPageLocators signinPage;

	public SigninPage() {
		this.signinPage = new SigninPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.signinPage);
	}

	public void doLogin(String username, String password) {
		signinPage.email.sendKeys(username);
		signinPage.password.sendKeys(password);
		click(signinPage.submit);
	}
}

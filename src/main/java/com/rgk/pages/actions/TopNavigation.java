package com.rgk.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.rgk.base.Page;
import com.rgk.pages.locators.TopNavigationLocators;

public class TopNavigation {

	public TopNavigationLocators topNavigation;

	public TopNavigation(WebDriver driver) {
		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.topNavigation);
	}

	public SigninPage gotoSignin() {
		Page.click(topNavigation.account);
		Page.click(topNavigation.signInBtn);
		return new SigninPage();
	}

	public void gotoCreateAccount() {

	}

	public void gotoList() {

	}

	public void gotoSupport() {

	}

	public void goToMyTrip() {

	}
}

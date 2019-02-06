package com.rgk.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.rgk.base.Page;
import com.rgk.pages.locators.HomePageLocators;

public class HomePage extends Page {

	public HomePageLocators home;

	public HomePage() {
		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		// above is lazy load concept to identify webelements only when they are
		// used in an operation. if element found in 10 seconds it will work on
		// the element
		PageFactory.initElements(factory, this.home);
	}

	public HomePage gotoFlights() {
		click(home.flightTab);
		return this;
	}

	public void gotoHotels() {

	}

	public void gotoFlightsAndHotels() {

	}

	public void bookAFlight(String from, String to, String departing, String returning) {
		// .sendKeys(from, Keys.TAB);
		type(home.fromCity, from);
		// home.toCity.sendKeys(to, Keys.TAB);
		type(home.toCity, to);
		// home.departFlight.sendKeys(departing, Keys.ESCAPE);
		type(home.departFlight, departing);

		// home.returnFlight.sendKeys(returning, Keys.ESCAPE);
		type(home.returnFlight, returning);
		click(home.search);
	}

	public int findTabCount() {
		return home.tabCount.size();
	}
}

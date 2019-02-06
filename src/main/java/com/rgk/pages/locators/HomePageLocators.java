package com.rgk.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	@FindBy(xpath = "//button[@id='tab-flight-tab-hp']")
	public WebElement flightTab;

	// locators for flight booking
	@FindBy(xpath = "//input[@id='flight-origin-hp-flight']")
	public WebElement fromCity;

	@FindBy(xpath = "//input[@id='flight-destination-hp-flight']")
	public WebElement toCity;

	@FindBy(xpath = "//input[@id='flight-departing-hp-flight']")
	public WebElement departFlight;

	@FindBy(xpath = "//input[@id='flight-returning-hp-flight']")
	public WebElement returnFlight;

	@FindBy(xpath = "//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")
	public WebElement search;

	@FindBy(xpath = "//span[@class='tab-label']")
	public java.util.List<WebElement> tabCount;
}

package com.rgk.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rgk.base.Page;
import com.rgk.errorcollectors.ErrorCollector;
import com.rgk.pages.actions.HomePage;
import com.rgk.utilities.Utilities;

public class FlightSearchTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void flightSearchTest(Hashtable<String, String> data) {
		// Page.initConfiguration(); // before every test to make test
		// independent
		if (data.get("runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as runmode is no");
		}
		Page.initConfiguration();
		HomePage home = new HomePage();
		// Assert.assertEquals(home.findTabCount(), 5);
		ErrorCollector.verifyEquals(home.findTabCount(), 5);
		home.gotoFlights().bookAFlight(data.get("fromCity"), data.get("toCity"), data.get("fromDate"),
				data.get("toDate"));
		// Page.quitBrowser();// after every test to make test independent
	}

	@AfterMethod
	public void tearDown() {
		if (Page.driver != null) {
			Page.quitBrowser();
		}

	}
}

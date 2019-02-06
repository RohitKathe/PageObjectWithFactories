package com.rgk.rough;

import com.rgk.base.Page;
import com.rgk.pages.actions.HomePage;

public class FlightSearchTest {

	public static void main(String[] args) {
		Page.initConfiguration(); // before every test to make test independent
		HomePage home = new HomePage();
		home.gotoFlights().bookAFlight("Delhi", "Seattle", "02/03/2019", "02/03/2019" );
		//Page.quitBrowser();// after every test to make test independent
	}
}

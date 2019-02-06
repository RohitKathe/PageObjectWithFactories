package com.rgk.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.rgk.base.Page;
import com.rgk.pages.actions.SigninPage;
import com.rgk.utilities.Utilities;

public class SignInTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void signInTest(Hashtable<String, String> data) {
		if (data.get("runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as runmode is no");
		}
		Page.initConfiguration();
		SigninPage signin = Page.topNav.gotoSignin();
		signin.doLogin(data.get("username"), data.get("password"));

	}

	@AfterMethod
	public void tearDown() {
		if (Page.driver != null) {
			Page.quitBrowser();
		}

	}
}

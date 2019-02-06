package com.rgk.rough;

import com.rgk.base.Page;
import com.rgk.pages.actions.SigninPage;

public class SignInTest {

	public static void main(String[] args) {
		Page.initConfiguration();
		SigninPage signin = Page.topNav.gotoSignin();
		signin.doLogin("abcdef@gmail.com", "1234");
		Page.quitBrowser();
	}
}

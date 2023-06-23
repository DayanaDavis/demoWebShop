package com.demoWebShop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.demoWebShop.automationcore.Base;
import com.demoWebShop.dataprovider.DataProviders;
import com.demoWebShop.listeners.TestListner;
import com.demoWebShop.pages.HomePage;
import com.demoWebShop.pages.LoginPage;
import com.demoWebShop.utilities.ExcelUtility;

public class LoginTest extends Base {

	LoginPage login;
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();

	@Test(dataProvider = "InvalidUserCredential", dataProviderClass = DataProviders.class,priority = 1, enabled = true, description = "TC_001_verifyInvalidLoginErrorMessage", groups = {
	"Smoke" })
	public void TC_001_verifyInvalidLoginErrorMessage(String userEmail, String userPassword) {
		extentTest.get().assignCategory("Smoke");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expErrorMessage = data.get(1).get(0);
		home = new HomePage(driver);
		login = home.clickOnLoginIcon();
		login.enterUserCredential(userEmail, userPassword);
		login.clickOnLoginButton();
		String actErrormsg = login.getInvalidLoginErrorMsg();
		Assert.assertEquals(actErrormsg, expErrorMessage, "Invalid error message");
	}
}

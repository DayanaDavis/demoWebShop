package com.demoWebShop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demoWebShop.automationcore.Base;
import com.demoWebShop.constants.ExtentLog;
import com.demoWebShop.listeners.TestListner;
import com.demoWebShop.pages.HomePage;
import com.demoWebShop.utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();

	@Test(priority = 1, enabled = true, description = "TC_001_verifySubscribeEmailMessage", groups = {
	"Regression" })
	public void TC_001_verifySubscribeEmailMessage() {
		extentTest.get().assignCategory("Regression");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expSubMessage = data.get(0).get(1);
		home = new HomePage(driver);
		home.enterSubscribeEmailId();
		extentTest.get().log(Status.PASS,ExtentLog.EAMIL_ENTERED_MESSAGE);
		home.clickSubscribeButton();
		extentTest.get().log(Status.PASS, ExtentLog.SUB_Button_clicked_MESSAGE);
		String act_Message = home.getscribeButtonMessage();
		System.out.println(act_Message);
		Assert.assertEquals(act_Message, expSubMessage, "Invalid message");
		extentTest.get().log(Status.PASS,ExtentLog.VERIFIED_EMAIL_MESSAGE );

	}
}

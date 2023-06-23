package com.demoWebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoWebShop.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility{
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginButton;
	@FindBy(xpath = "//div[@class='validation-summary-errors']//span")
	WebElement errorMsg;
	
public void enterUserCredential(String username,String pswd) {
	page.enterText(email,username);
	page.enterText(password, pswd);
}
public void clickOnLoginButton() {
	page.clickOnElement(loginButton);
}
 public String getInvalidLoginErrorMsg() {
	 String msg=page.getMessage(errorMsg);
	 return msg;
	 
 }
}

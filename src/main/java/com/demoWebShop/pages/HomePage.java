package com.demoWebShop.pages;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoWebShop.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {

	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "newsletter-email")
	WebElement subscribeEmailField;
	@FindBy(id = "newsletter-subscribe-button")
	WebElement subscribeButton;
	@FindBy(id="newsletter-result-block")
	WebElement subcribeMessage;
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginIcon;
	@FindBy(xpath = "//li[@class='treeview']//span[text()='User Management']")
	WebElement userManagement;
	public void enterSubscribeEmailId() {
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String emailId=random.getRandomEmail();
		page.enterText(subscribeEmailField, emailId);
	}
	public void clickSubscribeButton() {
		subscribeButton.click();
	}
	public String getscribeButtonMessage(){
		wait.setHardWait();
		String message=page.getMessage(subcribeMessage);
		return message;
	}
	public LoginPage clickOnLoginIcon() {
		page.clickOnElement(loginIcon);
		return new LoginPage(driver);
	}
	
	
}


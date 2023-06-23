package com.demoWebShop.automationcore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.demoWebShop.constants.Constants;
import com.demoWebShop.extentManager.ExtentManager;

public class Base {
	 public WebDriver driver;
	    public Properties prop;
	    public FileInputStream fs;
	    public Base()  {
	        prop=new Properties();
	        try {
	            fs =new FileInputStream(System.getProperty("user.dir")+ Constants.CONFIG_FILE);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            prop.load(fs);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
//	    @BeforeMethod(alwaysRun = true)
//	    @Parameters({"browser"})
//	    public void setUP(String browserName){
////	        String browser= prop.getProperty("browser");
//	        String url= prop.getProperty("url");
//	        driver = DriverFactory.testInitialization(browserName);
//	        driver.get(url);
//	    }

	    @BeforeMethod(alwaysRun = true)
	    @Parameters({"browser"})
	    public void setUP(String browsername){
	    	//String browser="chrome";
	        String url= prop.getProperty("url");
	    	//String browser=browsername;
	        driver = DriverFactory.testInitialization(browsername);
	        driver.get(url);
	        //implicit wait here 
	    }
	    @AfterMethod(alwaysRun = true)
	    public void tearDown(ITestResult result) throws IOException {
	        if(result.getStatus()== ITestResult.FAILURE){
	            TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
	            File screenshot=takeScreenshot.getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(screenshot, new File("./Screenshots/"+result.getName()+".png"));
	        }
	        driver.quit();
	    }
	    @BeforeSuite
	    public void setExtent(final ITestContext testContext){
	        ExtentManager.createInstance().createTest(testContext.getName(), "TEST FAILED");
	    }	
}
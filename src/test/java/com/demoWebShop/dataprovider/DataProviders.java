package com.demoWebShop.dataprovider;

import org.testng.annotations.DataProvider;

import com.demoWebShop.utilities.ExcelUtility;

public class DataProviders {

	ExcelUtility excel=new ExcelUtility();
	@DataProvider(name="InvalidUserCredential")
	public Object[][] invalidUserCredentialstoLogin(){
		Object[][] data=excel.dataProviderRead("InvalidLoginPageDataProvider");
		return data;
	}
}

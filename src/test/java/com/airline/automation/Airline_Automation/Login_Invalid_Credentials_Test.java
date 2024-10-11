package com.airline.automation.Airline_Automation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.airline.automation.Airline_Automation.Listeners_Class.class)
public class Login_Invalid_Credentials_Test extends LaunchQuit{
	@Test(retryAnalyzer=com.airline.automation.Airline_Automation.Retry_Logic.class)
	public void login_invalid_credentials() {
		 Home_Page homepage=new  Home_Page(driver);
		 homepage.enter_wrong_otp();
	}

}

package com.airline.automation.Airline_Automation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.airline.automation.Airline_Automation.Listeners_Class.class)
public class Registration_Test extends LaunchQuit{
	@Test(retryAnalyzer=com.airline.automation.Airline_Automation.Retry_Logic.class)
	public void register() throws EncryptedDocumentException, IOException {
		 Home_Page homepage=new  Home_Page(driver);
		 homepage.enter_mobile_number();
	}
}

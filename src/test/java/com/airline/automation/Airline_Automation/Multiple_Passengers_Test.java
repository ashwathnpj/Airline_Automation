package com.airline.automation.Airline_Automation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.airline.automation.Airline_Automation.Listeners_Class.class)
public class Multiple_Passengers_Test extends LaunchQuit{
	@Test(retryAnalyzer=com.airline.automation.Airline_Automation.Retry_Logic.class)
	public void multiple_passengers() throws EncryptedDocumentException, IOException {
		Home_Page homepage=new  Home_Page(driver);
		homepage.enter_mobile_number();
		
		homepage.select_one_way_trip_option();
		homepage.pick_multiple_passengers();
		homepage.select_from_where();
		homepage.select_where_to();
		homepage.click_search_flights_button();
		
		Searched_Page searchedPage=new Searched_Page(driver);
		//searchedPage.verify_oneway_searchpage_is_displayed(driver);
		searchedPage.verify_number_of_travellers_button_is_displayed(driver);
		
	}

}

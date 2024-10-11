package com.airline.automation.Airline_Automation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.airline.automation.Airline_Automation.Listeners_Class.class)
public class Flight_Payment extends LaunchQuit {
	@Test(retryAnalyzer=com.airline.automation.Airline_Automation.Retry_Logic.class)
	public void travellers_details() throws EncryptedDocumentException, IOException  {
		Home_Page homepage=new  Home_Page(driver);
		homepage.enter_mobile_number();
		
		homepage.select_one_way_trip_option();
		homepage.select_future_date(driver);
		homepage.select_from_where();
		homepage.select_where_to();
		homepage.click_search_flights_button();
		
		Searched_Page searchedPage=new Searched_Page(driver);
		searchedPage.verify_oneway_searchpage_is_displayed(driver);
		searchedPage.click_fourth_book_button();
		
		Details_Page details=new Details_Page(driver);
		details.enter_travellers_details(driver);
		
		Payment_Page payment=new Payment_Page(driver);
		payment.verify_payment_page_navigated(driver);
		
		payment.enter_card_details(driver);
	}
}

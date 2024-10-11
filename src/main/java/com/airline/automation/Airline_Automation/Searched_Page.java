package com.airline.automation.Airline_Automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Searched_Page {
	WebDriver driver;
	
	@FindBy(css = "[value='One way']")
	WebElement one_way_trip_option;
	
	@FindBy(css = "[value='Round trip']")
	WebElement round_trip_option;
	
	@FindBy(xpath = "(//button//h4[.='Book'])[1]")
	WebElement book_button;
	
	@FindBy(xpath = "(//button//h4[.='Book'])[4]")
	WebElement fourth_book_button;
	
	@FindBy(xpath = "(//button//h4[.='Select'])[1]")
	WebElement select_first_button;
	
	@FindBy(xpath = "//button//h3[.='Continue']")
	WebElement continue_button;
	
	@FindBy(xpath = "(//p[.='Flight Details'])[1]")
	WebElement flight_details_link;
	
	@FindBy(xpath = "//div[@class='sc-aXZVg iNidEX flex flex-middle'][2]")
	WebElement flight_information_box;
	
	@FindBy(xpath = "//div[@class='sc-aXZVg hKtzvB flex flex-baseline']/h1")
	WebElement flight_fare_box;
	
	@FindBy(xpath = "//div[@class='sc-aXZVg bIVvcp mt-4 pb-10']/div/div")
	WebElement baggage_box;
	
	@FindBy(xpath = "//h3[.='Book']")
	WebElement mini_book_button;
	
	@FindBy(xpath = "(//p[contains(text(), 'Cancellation fee')])[2]")
	WebElement cancellation_details_box;
	
	@FindBy(xpath = "//p[.='My account']")
	WebElement my_account_option;
	
	@FindBy(xpath = "//span[.='Sign out']")
	WebElement sign_out_button;
	
	@FindBy(css = "[value='4 Travellers']")
	WebElement number_of_travellers_button;
	
	
	//assertions methods 
	public void verify_oneway_searchpage_is_displayed(WebDriver driver) {
		Assert.assertTrue(one_way_trip_option.isDisplayed(), "sorry, one way search page not displayed");
	}
	
	public void verify_roundtrip_searchpage_is_displayed(WebDriver driver) {
		Assert.assertTrue(round_trip_option.isDisplayed(), "sorry, round trip search page not displayed");
	}
	
	public void verify_economy_class_searchpage_is_displayed(WebDriver driver) {
		Assert.assertTrue(driver.getCurrentUrl().contains("Economy"), "URL does not contain 'Economy'");
	}
	
	public void verify_business_class_searchpage_is_displayed(WebDriver driver) {
		Assert.assertTrue(driver.getCurrentUrl().contains("Business"), "URL does not contain 'Economy'");
	}
	
	public void verify_first_class_searchpage_is_displayed(WebDriver driver) {
		Assert.assertTrue(driver.getCurrentUrl().contains("First"), "URL does not contain 'Economy'");
	}
	
	public void verify_premium_class_searchpage_is_displayed(WebDriver driver) {
		Assert.assertTrue(driver.getCurrentUrl().contains("Premium"), "URL does not contain 'Economy'");
	}

	public void verify_number_of_travellers_button_is_displayed(WebDriver driver) {
		Assert.assertTrue(number_of_travellers_button.isDisplayed(), "sorry, number of travellers button not displayed");
	}
	
	//perform methods 
	public void click_fourth_book_button() {
		fourth_book_button.click();		
		select_first_button.click();
		continue_button.click();
	}
	
	public void fetch_flight_details() {
		flight_details_link.click();
		Assert.assertTrue(flight_information_box.isDisplayed(),"flight information box not displayed");
		Assert.assertTrue(flight_fare_box.isDisplayed(),"flight fare box not displayed");
		Assert.assertTrue(baggage_box.isDisplayed(),"baggage box not displayed");
		mini_book_button.click();
		Assert.assertTrue(cancellation_details_box.isDisplayed(),"cancellation details box not displayed");
		
	}
	
	public void click_signout_button() {
		my_account_option.click();
		sign_out_button.click();
	}
	
	public Searched_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

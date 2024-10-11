package com.airline.automation.Airline_Automation;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Home_Page extends Excel_Data {
	WebDriver driver;

	@FindBy(id = "mobile")
	WebElement mobile_number_field;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement otp_field_1;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement otp_field_2;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement otp_field_3;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement otp_field_4;

	@FindBy(xpath = "//p[.='My account']")
	WebElement my_account_option;

	@FindBy(xpath = "//p[.='Please enter a valid OTP']")
	WebElement error_message;
	
	@FindBy(xpath = "(//div[@class='flex flex-middle']/span)[1]")
	WebElement trip_option;
	
	@FindBy(xpath = "//div/li//p[.='One way']")
	WebElement one_way_trip_option;
	
	@FindBy(xpath = "//div/li//p[.='Round trip']")
	WebElement round_trip_option;
	
	@FindBy(css = "[placeholder='Where from?']")
	WebElement from_where_field;

	@FindBy(xpath = "(//div/ul[@class='airportList'])[1]")
	WebElement first_city;
	
	@FindBy(css = "[placeholder='Where to?']")
	WebElement where_to_field;
	
	@FindBy(xpath = "(//div/ul[@class='airportList'])[2]")
	WebElement second_city;
	
	@FindBy(xpath = "//h4[.='Search flights']")
	WebElement search_flights_button;
	
	@FindBy(xpath = "(//div[@class='p-relative']//span)[3]")
	WebElement class_option;
	
	@FindBy(xpath = "//p[.='Economy']")
	WebElement economy_class_option;
	
	@FindBy(xpath = "//p[.='Business class']")
	WebElement business_class_option;
	
	@FindBy(xpath = "//p[.='First class']")
	WebElement first_class_option;
	
	@FindBy(xpath = "//p[.='Premium economy']")
	WebElement premium_class_option;
	
	@FindBy(xpath = "(//div[@class='flex flex-middle p-relative homeCalender']/div/div)[2]")
	WebElement calender;
	
	@FindBy(xpath = "(//div[@class='Day-grid flex flex-middle flex-column flex-top']/div)[30]")
	WebElement pick_date;
	
	
	@FindBy(xpath = "(//div[@class='p-relative'])[2]")
	WebElement passengers_option;
	
	@FindBy(xpath = "(//button[@class='bn c-pointer'])[1]")
	WebElement adults_add;
	
	@FindBy(xpath = "(//button[@class='bn c-pointer'])[3]")
	WebElement childrens_add;
	
	@FindBy(xpath = "(//button[@class='bn c-pointer'])[5]")
	WebElement infants_add;
	
	@FindBy(xpath = "//span[.='2 Adults, 1 Child, 1 Infant, Economy']")
	WebElement multiple_passengers_confirm;
	
	@FindBy(xpath = "//span[.='Sign out']")
	WebElement sign_out_button;
	
	@FindBy(xpath = "//h4[.='Log in / Sign up']")
	WebElement login_signup_button;
	
	public void verify_login_signup_button_displayed() {
		Assert.assertTrue(login_signup_button.isDisplayed(),"signout not done");
	    //Assert.assertTrue(mobile_number_field.isDisplayed(),"signout not done");
	}
	
	
	
	public void enter_mobile_number() throws EncryptedDocumentException, IOException {
		excel_sheet();
		mobile_number_field.sendKeys(mobile_number);
		//mobile_number_field.sendKeys("8088666694");

		System.out.println("What is OTP?");

		Scanner otpInput = new Scanner(System.in);
		String otp = otpInput.next();

		otp_field_1.sendKeys(Character.toString(otp.charAt(0)));
		otp_field_2.sendKeys(Character.toString(otp.charAt(1)));
		otp_field_3.sendKeys(Character.toString(otp.charAt(2)));
		otp_field_4.sendKeys(Character.toString(otp.charAt(3)));
		
		otpInput.close();

		Assert.assertTrue(my_account_option.isDisplayed(), "My Account option is not displayed after entering OTP");
	}

	public void enter_wrong_otp() {
		mobile_number_field.sendKeys("9856472598");

		System.out.println("What is OTP?");

		Scanner otpInput = new Scanner(System.in);
		String otp = otpInput.next();

		otp_field_1.sendKeys(Character.toString(otp.charAt(0)));
		otp_field_2.sendKeys(Character.toString(otp.charAt(1)));
		otp_field_3.sendKeys(Character.toString(otp.charAt(2)));
		otp_field_4.sendKeys(Character.toString(otp.charAt(3)));

		Assert.assertTrue(error_message.isDisplayed(), "error message is not displayed after entering wrong OTP");
		Reporter.log("Test case is passed because, it is not accepting the wrong otp");

	}

	public void select_from_where() {
		from_where_field.click();
		first_city.click();
	}
	
	public void select_where_to() {
		where_to_field.click();
		second_city.click();
	}
	
	public void click_search_flights_button() {
		search_flights_button.click();
	}
	
	public void select_one_way_trip_option() {
		trip_option.click();
		one_way_trip_option.click();
	}
	
	public void select_round_trip_option() {
		trip_option.click();
		round_trip_option.click();
	}
	
	public void select_economy_class_option() {
		class_option.click();
		economy_class_option.click();
	}
	
	public void select_business_class_option() {
		class_option.click();
		business_class_option.click();
	}
	
	public void select_first_class_option() {
		class_option.click();
		first_class_option.click();
	}
	
	public void select_premium_class_option() {
		class_option.click();
		premium_class_option.click();
	}
	
	public void select_future_date(WebDriver driver) {
		calender.click();
		pick_date.click();
	}
	
	public void pick_multiple_passengers() {
		passengers_option.click();
		adults_add.click();
		childrens_add.click();
		infants_add.click();
		Assert.assertTrue(multiple_passengers_confirm.isDisplayed(),"multiple passengers not selected");
	}
	
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

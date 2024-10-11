package com.airline.automation.Airline_Automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Payment_Page {
	WebDriver driver;
	
	@FindBy(xpath="(//div[.='Debit/Credit card'])[2]")
	WebElement debit_credit_card_option;
	
	@FindBy(id="cardNumber")
	WebElement card_number_field;
	
	@FindBy(id="expiryMonth")
	WebElement expiry_month_dropdown;
	
	@FindBy(id="expiryYear")
	WebElement expiry_year_dropdown;
	
	@FindBy(id="name")
	WebElement name_on_card_field;
	
	@FindBy(id="cvv")
	WebElement cvv_field;
	
	@FindBy(xpath="//button[.='Pay now']")
	WebElement pay_now_button;
	
	@FindBy(xpath="//p[.='Please enter a valid card number']")
	WebElement message_text;
	
	
	
	public void verify_payment_page_navigated(WebDriver driver) {
		Assert.assertTrue(debit_credit_card_option.isDisplayed(), "payment page is not displayed");
	}
	
	public void enter_card_details(WebDriver driver) {
		Set<String> windowHandlesSet = driver.getWindowHandles();
		Iterator<String> iterator_windowHandlesSet = windowHandlesSet.iterator();
		String parentId = iterator_windowHandlesSet.next();
		String childId = iterator_windowHandlesSet.next();

		driver.switchTo().window(childId);
		
		debit_credit_card_option.click();
		card_number_field.sendKeys("1234 5678 9012 3456");
		Select month=new Select(expiry_month_dropdown);
		month.selectByIndex(6);
		
		Select year=new Select(expiry_year_dropdown);
		year.selectByIndex(6);
		
		name_on_card_field.sendKeys("Ashwathnarayan Joshi");
		cvv_field.sendKeys("666");
		pay_now_button.click();
		Assert.assertTrue(message_text.isDisplayed(),"Please enter a valid card number text message not displayed");
	}
	
	public Payment_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

package com.airline.automation.Airline_Automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Details_Page {
	WebDriver driver;

	@FindBy(xpath = "//h3[.='OK']")
	WebElement ok_popup_button;

	@FindBy(xpath = "//button//h4[.='Continue']")
	WebElement fare_type_continue_button;

	@FindBy(xpath = "//button//h4[.='Select seats']")
	WebElement select_seat_button;

	@FindBy(css = "[data-testid='14']")
	WebElement select_seat_box;

	@FindBy(xpath = "//h4[.='Done']")
	WebElement selected_seat_done_button;

	@FindBy(xpath = "//h3[.='Seats added']")
	WebElement seats_added_text;

	@FindBy(xpath = "//h4[.='Skip add-ons']")
	WebElement skip_add_ons_button;

	@FindBy(xpath = "//p[.='Skip add ons']")
	WebElement skip_add_ons_popup_button;

	@FindBy(xpath = "(//div/input)[1]")
	WebElement contact_details_mobile_number_field;

	@FindBy(xpath = "(//div/input)[2]")
	WebElement contact_details_email_field;

	@FindBy(xpath = "//button//p[.='Continue']")
	WebElement contact_details_continue_button;

	@FindBy(xpath = "(//div/input)[3]")
	WebElement first_name_field;

	@FindBy(xpath = "(//div/input)[4]")
	WebElement last_name_field;

	@FindBy(xpath = "//p[.='Continue to payment']")
	WebElement continue_to_payment_button;

	public void verify_coupon_code_applied(WebDriver driver) {
		Set<String> windowHandlesSet = driver.getWindowHandles();
		Iterator<String> iterator_windowHandlesSet = windowHandlesSet.iterator();
		String parentId = iterator_windowHandlesSet.next();
		String childId = iterator_windowHandlesSet.next();

		driver.switchTo().window(childId);
		Assert.assertTrue(ok_popup_button.isDisplayed(), "coupon code not applied");
	}

	public void click_select_seat_button(WebDriver driver) {
		Set<String> windowHandlesSet = driver.getWindowHandles();
		Iterator<String> iterator_windowHandlesSet = windowHandlesSet.iterator();
		String parentId = iterator_windowHandlesSet.next();
		String childId = iterator_windowHandlesSet.next();

		driver.switchTo().window(childId);
		try {
			if (ok_popup_button.isDisplayed()) {
				ok_popup_button.click();
			}
		} catch (NoSuchElementException e) {

		}
		fare_type_continue_button.click();
		select_seat_button.click();
	}

	public void select_seat() {
		select_seat_box.click();
		selected_seat_done_button.click();
		Assert.assertTrue(seats_added_text.isDisplayed(), "seat is not added");
	}

	public void enter_travellers_details(WebDriver driver) {
		Set<String> windowHandlesSet = driver.getWindowHandles();
		Iterator<String> iterator_windowHandlesSet = windowHandlesSet.iterator();
		String parentId = iterator_windowHandlesSet.next();
		String childId = iterator_windowHandlesSet.next();

		driver.switchTo().window(childId);

		try {
			if (ok_popup_button.isDisplayed()) {
				ok_popup_button.click();
			}
		} catch (NoSuchElementException e) {

		}

		fare_type_continue_button.click();
		skip_add_ons_button.click();
		skip_add_ons_popup_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//p[.='Continue']")));
//		contact_details_mobile_number_field.click();
//		contact_details_mobile_number_field.sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
//		contact_details_mobile_number_field.sendKeys("8088666694");

		int attempt = 0;
		int maxAttempts = 2;
		while (attempt < maxAttempts) {
			try {
				contact_details_continue_button.click();
				break; 
			} catch (ElementClickInterceptedException e) {
				attempt++;
				if (attempt == maxAttempts) {
					throw e; 
				}
			}
		}
//		first_name_field.clear();
//		last_name_field.clear();
		first_name_field.sendKeys("Ashwathnarayan");
		last_name_field.sendKeys("Joshi");
		continue_to_payment_button.click();
	}

	public Details_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}

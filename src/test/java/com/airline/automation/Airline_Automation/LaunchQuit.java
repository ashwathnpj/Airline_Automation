package com.airline.automation.Airline_Automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.airline.automation.Airline_Automation.Listeners_Class;

public class LaunchQuit extends Listeners_Class{
	static WebDriver driver;
	
	@BeforeMethod
	public void Launch() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void Quit() throws InterruptedException {
		Thread.sleep(2000);
		//driver.quit();
	}

}

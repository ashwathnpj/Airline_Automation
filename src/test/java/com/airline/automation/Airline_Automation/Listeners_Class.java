package com.airline.automation.Airline_Automation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners_Class implements ITestListener {
	static ChromeDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		// int random = (int) (Math.random() * 1000000);
		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String className = result.getTestClass().getName();
		String testName = className.substring(className.lastIndexOf('.') + 1);
		Reporter.log("my test case is passed");
		TakesScreenshot s1 = (TakesScreenshot) LaunchQuit.driver;
		File source = s1.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ashwathnpj\\javaprograms\\Airline_Automation\\src\\Screenshots\\pass\\Passed" + timestamp + "_" + testName + ".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		// int random = (int) (Math.random() * 1000000);
		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String className = result.getTestClass().getName();
		String testName = className.substring(className.lastIndexOf('.') + 1);
		Reporter.log("my test case is failed");
		TakesScreenshot s2 = (TakesScreenshot) LaunchQuit.driver;
		File source = s2.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ashwathnpj\\javaprograms\\Airline_Automation\\src\\Screenshots\\fail\\Failed" + timestamp + "_" + testName + ".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}

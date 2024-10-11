package com.airline.automation.Airline_Automation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Logic implements IRetryAnalyzer {
	int count = 0;
	int retry_count = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (count < retry_count) {
			count++;
			return true;
		}
		return false;
	}
}

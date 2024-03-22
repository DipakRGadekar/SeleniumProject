package com.Test.Selenium_Project;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium02 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
	//	options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	//	options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		ChromeDriver driver = new ChromeDriver(options);
			
		driver.get("https://app.vwo.com/#/login");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}

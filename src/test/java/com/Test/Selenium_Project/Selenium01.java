package com.Test.Selenium_Project;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium01 {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
	//	option.addArguments("--headless=new");

		// SearchContext (I)- findelement & findelements
		// WebDriver (I) - multiple methods get. getTitle, currentURL,Size
		// RemoteWebDriver (C)
		driver.get("https://mvnrepository.com/");

		System.out.println(driver.getCurrentUrl());
	//	driver.quit();
	}
}

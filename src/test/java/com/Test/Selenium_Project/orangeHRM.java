package com.Test.Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class orangeHRM {
	WebDriver driver;
	ChromeOptions options;

	@BeforeSuite
	public void Setup() {
		options = new ChromeOptions();
		driver = new ChromeDriver(options);
	}

	@Test(priority = 1, groups = { "positive", "sanity" })
	@Description("TC#01 Verify that with valid username and valid password user login successfully")
	@Severity(SeverityLevel.MINOR)
	public void validLogin() throws InterruptedException {
		driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("Admin");

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Hacker@4321");

		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitBtn.click();
		Thread.sleep(3000);

		// Assertions
		String profile = driver.findElement(By.xpath("//p[contains(text(),'Site Owner')]")).getText();
		Assert.assertEquals(profile, "Site Owner");
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}
}

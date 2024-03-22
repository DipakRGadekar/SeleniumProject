package com.Test.Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Selenium04 {
	WebDriver driver;
	ChromeOptions options;

	@BeforeSuite
	public void Setup() {
		options = new ChromeOptions();
		driver = new ChromeDriver(options);
		WebDriverWait wait;
	}

	@Test(priority = 2, groups = { "negative", "Sanity" })
	@Description("TC#01 Verify that with Invalid username and valid password user not login successfully")
	@Severity(SeverityLevel.BLOCKER)
	public void invalidLogin() throws InterruptedException {
		driver.navigate().refresh();
		driver.get("https://app.vwo.com/#/login");

		WebElement username = driver.findElement(By.id("login-username"));
		username.sendKeys("dipak123@gmail.co");

		WebElement password = driver.findElement(By.id("login-password"));
		password.sendKeys("Dipak@2013");

		WebElement submitBtn = driver.findElement(By.id("js-login-btn"));
		submitBtn.click();

		// Assertions
		WebElement errorMssage = driver.findElement(By.id("js-notification-box-msg"));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(errorMssage));

		String errorMsg = driver.findElement(By.id("js-notification-box-msg")).getText();
		Assert.assertEquals(errorMsg, "Your email, password, IP address or location did not match");
	}

	@Test(priority = 1, groups = { "positive", "sanity" })
	@Description("TC#02 Verify that with valid username and valid password user login successfully")
	@Severity(SeverityLevel.MINOR)
	public void validLogin() throws InterruptedException {
		driver.get("https://app.vwo.com/#/login");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("login-username"));
		username.sendKeys("dipak123@gmail.com");

		WebElement password = driver.findElement(By.id("login-password"));
		password.sendKeys("Dipak@2013");

		WebElement submitBtn = driver.findElement(By.id("js-login-btn"));
		submitBtn.click();

		WebElement errorMssage = driver.findElement(By.xpath("//span[normalize-space()='Need Help?']"));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(errorMssage));

		// Assertions
		String urlString = driver.getCurrentUrl();
		Assert.assertEquals(urlString, "https://app.vwo.com/#/dashboard");

		driver.findElement(By.xpath("//img[@data-qa='user-image'] ")).click();
		driver.findElement(By.xpath("//li[@data-qa='logout-btn']")).click();
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}
}

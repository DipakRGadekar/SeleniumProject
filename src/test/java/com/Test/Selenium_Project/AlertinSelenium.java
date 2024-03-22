package com.Test.Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class AlertinSelenium {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeSuite
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Test(priority = 1)
	@Description("TC#01 Click on first JS Alert")
	public void firstAlert() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		WebElement alertElement = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
		alertElement.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		WebElement Result = driver.findElement(By.id("result"));
		Assert.assertEquals(Result.getText(), "You successfully clicked an alert");
	}

	@Test(priority = 2)
	@Description("TC#02 Click on first JS Confirm")
	public void secondAlert() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement alertElement = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		alertElement.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		WebElement Result = driver.findElement(By.id("result"));
		Assert.assertEquals(Result.getText(), "You clicked: Ok");

		alertElement.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.dismiss();
		WebElement Result1 = driver.findElement(By.id("result"));
		Assert.assertEquals(Result1.getText(), "You clicked: Cancel");

	}

	@Test(priority = 3)
	@Description("TC#03 Click on first JS Prompt")
	public void thirdAlert() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement alertElement = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		alertElement.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Dipak Gadekar");
		alert.accept();
		WebElement Result = driver.findElement(By.id("result"));
		Assert.assertEquals(Result.getText(), "You entered: Dipak Gadekar");
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}
}

package com.Test.Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Calender {
	public static void main(String[] args) {
		String URL = "https://katalon-demo-cura.herokuapp.com/";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		driver.findElement(By.id("btn-make-appointment")).click();

		WebDriverWait wait;
		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlContains("profile.php#login"));
		String demoUS = driver.findElement(By.xpath("//input[@placeholder='Username']")).getAttribute("value");
		String demoPWD = driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("value");

		driver.findElement(By.id("txt-username")).sendKeys(demoUS);
		driver.findElement(By.id("txt-password")).sendKeys(demoPWD);
		driver.findElement(By.id("btn-login")).click();

		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlContains("appointment"));
		Select select = new Select(driver.findElement(By.id("combo_facility")));
		select.selectByIndex(1);
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		driver.findElement(By.id("radio_program_medicaid")).click();
		driver.findElement(By.id("txt_visit_date")).sendKeys("25/07/1996");
		driver.findElement(By.id("txt_comment")).sendKeys("Happy me");
		driver.findElement(By.id("btn-book-appointment")).click();

		new WebDriverWait(driver, Duration.ofSeconds(2))
				.until(ExpectedConditions.urlContains("appointment.php#summary"));

		String confirmation = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"))
				.getText();
		Assert.assertEquals(confirmation, "Appointment Confirmation");
		driver.quit();
	}
}

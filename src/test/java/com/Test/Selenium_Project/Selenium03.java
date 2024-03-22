package com.Test.Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium03 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vwo.com/#/login");

		WebElement username = driver.findElement(By.id("login-username"));
		username.sendKeys("dipak123@gmail.com");

		WebElement password = driver.findElement(By.id("login-password"));
		password.sendKeys("Dipak@2013");

		WebElement submitBtn = driver.findElement(By.id("js-login-btn"));
		submitBtn.click();
	}

}

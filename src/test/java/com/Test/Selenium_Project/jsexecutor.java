package com.Test.Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsexecutor {
	public static void main(String[] args) {
		String URL = "https://the-internet.herokuapp.com/add_remove_elements/";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		WebElement addbtn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addbtn);
		driver.quit();
	}
}

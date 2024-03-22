package com.Test.Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
	public static void main(String[] args) {
		String URL = "https://the-internet.herokuapp.com/iframe";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("Hello, Good morning");
		
		
	}
}
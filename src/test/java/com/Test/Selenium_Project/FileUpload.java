package com.Test.Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args) {
		String URL = "https://awesomeqa.com/selenium/upload.html";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("fileToUpload")).sendKeys("C:\\Users\\Priti-PC\\Downloads");
		driver.findElement(By.name("submit")).click();
		
		System.out.println(driver.getCurrentUrl());
	}
}
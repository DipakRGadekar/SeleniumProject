package com.Test.Selenium_Project;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
	public static void main(String[] args) {
		String URL = "https://the-internet.herokuapp.com/windows";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		String mainWindo = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

		Set<String> windowSet = driver.getWindowHandles();

		for (String w : windowSet) {
			driver.switchTo().window(w);
			System.out.println(driver.getCurrentUrl());
		}
		driver.switchTo().window(mainWindo);
	}
}
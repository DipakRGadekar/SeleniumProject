package com.Test.Selenium_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/checkboxes");

		List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement e : checkBoxList) {
			if (!e.isSelected()) {
				e.click();
			}
		}
	}
}

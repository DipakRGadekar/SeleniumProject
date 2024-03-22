package com.Test.Selenium_Project;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action01 {
	public static void main(String[] args) throws InterruptedException {
		String URL = "https://www.makemytrip.com/";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		Thread.sleep(5000);
		WebElement sourcElement = driver.findElement(By.id("fromCity"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sourcElement).click().sendKeys("PNQ").build().perform();

		List<WebElement> sourList = driver
				.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

		for (WebElement e : sourList) {
			if (e.getText().contains("PNQ")) {
				e.click();
				break;
			}
		}

		WebElement destElement = driver.findElement(By.id("toCity"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(destElement).click().sendKeys("BOM").build().perform();

		List<WebElement> destList = driver
				.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

		for (WebElement e : destList) {
			if (e.getText().contains("BOM")) {
				e.click();
				break;
			}
		}

		driver.quit();
	}
}
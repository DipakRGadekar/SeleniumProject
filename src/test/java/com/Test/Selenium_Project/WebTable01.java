package com.Test.Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable01 {

	public static void main(String[] args) {
		String URL = "https://awesomeqa.com/webtable.html";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		/*
		 * //table[@id="customers"] - //table[contains(@id,"cust")] Row -
		 * //table[@id="customers"]/tbody/tr //table[@id="customers"]/tbody/tr[2]
		 *
		 */

		// Number of Rows and Column in table
		// Divide the path
		int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
		int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();
		System.out.println(row);
		System.out.println(col);

		String first_part = "//table[@id=\"customers\"]/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";

		for (int i = 2; i <= row; i++) { // //table[@id="customers"]/tbody/tr[1]/th[1] - First is Header
			for (int j = 1; j <= col; j++) {
				String dynamic_xpath = first_part + i + second_part + j + third_part;
				String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
				System.out.print(data + " ");

			}
		}

		// Who is in Google -
		// //table[@id="customers"]/tbody/tr[2]/td[1]/following-sibling::td[1]
		// Google In Which Country -
		// //table[@id="customers"]/tbody/tr[2]/td[1]/following::td[2]

		// Find Helen Bennett In Which Country
		for (int i = 2; i <= row; i++) {
			// //table[@id="customers"]/tbody/tr[1]/th[1] - First is Header
			for (int j = 1; j <= col; j++) {
				String dynamic_xpath = first_part + i + second_part + j + third_part;
				String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
				if (data.contains("Helen Bennett")) {
					String country_path = dynamic_xpath + "/following-sibling::td";
					String country_text = driver.findElement(By.xpath(country_path)).getText();
					System.out.println("------");
					System.out.println("Helen Bennett is In - " + country_text);
				}
			}
		}
	}
}

package dataDrivenTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v120.webauthn.model.Credential;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DDRealTime02 {
	WebDriver driver;
	ChromeOptions options;

	@BeforeSuite
	public void Setup() {
		options = new ChromeOptions();
		driver = new ChromeDriver(options);
	}

	@Test(dataProvider = "credentials", priority = 1, groups = { "positive", "sanity" })
	@Description("TC#01 Verify that with valid username and valid password user login successfully")
	@Severity(SeverityLevel.MINOR)
	public void validLogin(String ID, String Pwd) throws InterruptedException {
		driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(ID);

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(Pwd);

		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitBtn.click();
		Thread.sleep(3000);

		// Assertions
		String profile = driver.findElement(By.xpath("//p[contains(text(),'Site Owner')]")).getText();
		Assert.assertEquals(profile, "Site Owner");
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "credentials")
	public String[][] takedata() throws IOException {
		String filePath = "TestData\\DDRealTime2.xlsx";
		ExcelReader reader = new ExcelReader(filePath);
		String[][] data = reader.getDataFromSheet(filePath, "credentials");
		return data;
	}
}
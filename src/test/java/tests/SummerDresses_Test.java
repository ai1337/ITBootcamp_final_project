package tests;

import org.testng.annotations.Test;

import finalProject.pageObject.SummerDresses;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SummerDresses_Test extends SummerDresses {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test (priority = 1)
	public void clickOnDressTest() {
		driver.get(SUMMER_DRESSES_URL);
		clickOnDress(driver);
		choseDress(driver);	
	}
	@Test (priority = 2)
	public void checkoutTest() {
		checkout(driver);
	}

	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}

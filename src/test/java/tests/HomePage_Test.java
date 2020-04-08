package tests;

import org.testng.annotations.Test;

import finalProject.pageObject.HomePage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomePage_Test extends HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public String currentURL;
	public String currentURL2;
	public String expectedURL;
	public String expectedURL2;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}

	@Test(priority = 1)
	public void womenSummerDressesTest() {
		/*
		 * Test when the mouse hover to the button WOMEN from menu and then select
		 * Summer Dresses takes us to the right address.
		 */
		driver.get(HOME_URL);
		hoverOnMenuWomen(driver);
		clickOnSummerDresses(driver);
		currentURL = driver.getCurrentUrl();
		expectedURL = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(currentURL, expectedURL);
	}

	@Test(priority = 2)
	public void dressesSummerDressesTest() {
		/*
		 * Test when the mouse hover to the button DRESSES from menu and then select
		 * Summer Dresses takes us to the right address.
		 */
		driver.navigate().to(HOME_URL);
		hoverOnMenuDresses(driver);
		clickOnSummerDresses2(driver);
		currentURL2 = driver.getCurrentUrl();
		expectedURL2 = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(currentURL2, expectedURL2);

	}

	@Test(priority = 3)
	public void summerDressesSamePageTest() {
		// Test that the expected address from both Tests are the same.
		Assert.assertEquals(currentURL, currentURL2);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}

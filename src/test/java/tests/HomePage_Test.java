package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import finalProject.pageObject.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HomePage_Test extends HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public String currentURL;
	public String currentURL2;
	public String expectedURL;
	public String expectedURL2;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}

	@Test(priority = 1)
	public void womenSummerDressesTest() {
		driver.get(HOME_URL);
		hoverOnMenuWomen(driver);
		clickOnSummerDresses(driver);
		currentURL = driver.getCurrentUrl();
		expectedURL = "http://automationpractice.com/index.php?id_category=11&controller=category";
		AssertJUnit.assertEquals(currentURL, expectedURL);
	}

	@Test(priority = 2)
	public void dressesSummerDressesTest() {
		driver.navigate().to(HOME_URL);
		hoverOnMenuDresses(driver);
		clickOnSummerDresses2(driver);
		currentURL2 = driver.getCurrentUrl();
		expectedURL2 = "http://automationpractice.com/index.php?id_category=11&controller=category";
		AssertJUnit.assertEquals(currentURL2, expectedURL2);

	}

	@Test(priority = 3)
	public void summerDressesSamePageTest() {
		AssertJUnit.assertEquals(currentURL, currentURL2);
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}

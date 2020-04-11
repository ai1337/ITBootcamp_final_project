package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import finalProject.pageObject.RegistrationAfterBuy;
import finalProject.pageObject.SummerDress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class RegistrationAfterBuy_Test extends SummerDress {
	WebDriver driver;
	RegistrationAfterBuy reg = new RegistrationAfterBuy();

	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void choseDressTest() {
		driver.get(SUMMER_DRESSES_URL);
		clickOnDress(driver);
		choseDress(driver);
		checkout(driver);
		infoDress(driver);
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(sizeColorCheck.getText(), "Color : Blue, Size : M");
		sf.assertEquals(quantityCheck.getAttribute("value"), "2");
		sf.assertEquals(nameOfDressCheck.getText(), "Printed Summer Dress");
		sf.assertAll();

	}

	@Test(priority = 2)
	public void registrationAfterBuy() throws InterruptedException {
		reg.registration(driver);
		Thread.sleep(2000);
		reg.fillAccount(driver);
		Assert.assertEquals(true, reg.getUserIsLoggedIn().isDisplayed());

	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}

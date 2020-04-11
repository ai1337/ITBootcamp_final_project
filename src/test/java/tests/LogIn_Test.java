package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import finalProject.pageObject.LogIn;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LogIn_Test extends LogIn {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void loginTest() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("src/test/resources/data/TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		SoftAssert sf = new SoftAssert();
		driver.get(LOGIN_URL);

		for (int i = 1; i < 30; i++) {
			Thread.sleep(2000);

			Row row = sheet.getRow(i);
			login(driver, row.getCell(3).getStringCellValue(), row.getCell(2).getStringCellValue());
			Thread.sleep(2000);
			signOutButton = driver.findElement(By.xpath("//a[@title='Log me out']"));
			sf.assertEquals(true, signOutButton.isDisplayed());

			signOutButton.click();

			sf.assertAll();

		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

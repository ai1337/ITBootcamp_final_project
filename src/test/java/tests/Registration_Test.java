package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import finalProject.pageObject.Registration;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Registration_Test extends Registration {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void registrationTest() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("src/test/resources/data/TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		driver.get(REG_URL);
		registrationData(driver, sheet);
		sf.assertAll();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

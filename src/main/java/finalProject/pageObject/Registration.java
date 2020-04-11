package finalProject.pageObject;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Registration {
	public final String REG_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public WebElement proceed;
	public WebElement emailInput;
	public WebElement createAcccountButton;
	public WebElement firstNamePerson;
	public WebElement lastNamePerson;
	public WebElement password;
	public WebElement firstNameAddress;
	public WebElement lastNameAddress;
	public WebElement address;
	public WebElement city;
	public WebElement state;
	public WebElement country;
	public WebElement zip;
	public WebElement mobilePhone;
	public WebElement addressAlias;
	public WebElement subbmitAccount;
	public WebElement userIsLoggedIn;
	public WebElement logOut;
	public Sheet sheet;
	public SoftAssert sf;

	public void registrationData(WebDriver driver, Sheet sheet) throws InterruptedException {
		this.sheet = sheet;
		for (int i = 1; i < 30; i++) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Row row = sheet.getRow(i);
			emailInput = driver.findElement(By.id("email_create"));
			emailInput.sendKeys(row.getCell(3).getStringCellValue());
			createAcccountButton = driver.findElement(By.id("SubmitCreate"));
			createAcccountButton.click();
			Thread.sleep(1000);
			
			firstNamePerson = driver.findElement(By.id("customer_firstname"));
			firstNamePerson.sendKeys(row.getCell(0).getStringCellValue());
			lastNamePerson = driver.findElement(By.id("customer_lastname"));
			lastNamePerson.sendKeys(row.getCell(1).getStringCellValue());
			password = driver.findElement(By.id("passwd"));
			password.sendKeys(row.getCell(2).getStringCellValue());
			firstNameAddress = driver.findElement(By.id("firstname"));
			firstNameAddress.sendKeys(row.getCell(0).getStringCellValue());
			lastNameAddress = driver.findElement(By.id("lastname"));
			lastNameAddress.sendKeys(row.getCell(1).getStringCellValue());
			address = driver.findElement(By.id("address1"));
			address.sendKeys(row.getCell(4).getStringCellValue());
			city = driver.findElement(By.id("city"));
			city.sendKeys(row.getCell(5).getStringCellValue());
			Select state = new Select(driver.findElement(By.id("id_state")));
			int state_number = i + 1;
			state.selectByValue(String.valueOf(state_number));
			zip = driver.findElement(By.id("postcode"));
			int zip_code = (int) row.getCell(6).getNumericCellValue();
			zip.sendKeys(String.valueOf(zip_code));
			mobilePhone = driver.findElement(By.id("phone_mobile"));
			int phone_number = (int) row.getCell(7).getNumericCellValue();
			mobilePhone.sendKeys(String.valueOf(phone_number));
			subbmitAccount = driver.findElement(By.id("submitAccount"));
			subbmitAccount.click();
			
			userIsLoggedIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span"));
			sf = new SoftAssert();
			sf.assertEquals(true, userIsLoggedIn.isDisplayed());
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			logOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
			logOut.click();
			Thread.sleep(2000);
		}
	}
}
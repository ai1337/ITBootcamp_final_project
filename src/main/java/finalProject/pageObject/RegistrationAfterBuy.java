package finalProject.pageObject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationAfterBuy {
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

	protected String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr.toLowerCase();

	}

	public void registration(WebDriver driver) {
		proceed = driver.findElement(By.linkText("Proceed to checkout"));
		proceed.click();
		emailInput = driver.findElement(By.id("email_create"));
		emailInput.sendKeys(getRandomString() + "@gmail.com");
		createAcccountButton = driver.findElement(By.id("SubmitCreate"));
		createAcccountButton.click();
	}

	public void fillAccount(WebDriver driver) {
		firstNamePerson = driver.findElement(By.id("customer_firstname"));
		firstNamePerson.sendKeys("Pera");
		lastNamePerson = driver.findElement(By.id("customer_lastname"));
		lastNamePerson.sendKeys("Peric");
		password = driver.findElement(By.id("passwd"));
		password.sendKeys("sifra123");
		firstNameAddress = driver.findElement(By.id("firstname"));
		firstNameAddress.sendKeys("Pera");
		lastNameAddress = driver.findElement(By.id("lastname"));
		lastNameAddress.sendKeys("Peric");
		address = driver.findElement(By.id("address1"));
		address.sendKeys("Toll road 1");
		city = driver.findElement(By.id("city"));
		city.sendKeys("Dallas");
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("43");
		zip = driver.findElement(By.id("postcode"));
		zip.sendKeys("75001");
		// Select country = new Select(driver.findElement(By.id("id_country")));
		// country.deselectByValue("21");
		mobilePhone = driver.findElement(By.id("phone_mobile"));
		mobilePhone.sendKeys("06012345678");
		addressAlias = driver.findElement(By.id("alias"));
		addressAlias.clear();
		addressAlias.sendKeys("myAddress");
		subbmitAccount = driver.findElement(By.id("submitAccount"));
		subbmitAccount.click();
		userIsLoggedIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span"));

	}

	public WebElement getUserIsLoggedIn() {
		return userIsLoggedIn;
	}

}

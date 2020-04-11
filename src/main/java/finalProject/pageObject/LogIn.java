package finalProject.pageObject;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {
	public final String LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public WebElement emailInput;
	public WebElement passwordInput;
	public WebElement loginButton;
	public WebElement signOutButton;
	public Sheet sheet;

	public void login(WebDriver driver, String mail, String password) throws InterruptedException {
		emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys(mail);
		passwordInput = driver.findElement(By.id("passwd"));
		passwordInput.sendKeys(password);
		loginButton = driver.findElement(By.id("SubmitLogin"));
		loginButton.click();		

	}


}
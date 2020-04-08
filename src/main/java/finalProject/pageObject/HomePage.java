package finalProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	public static final String HOME_URL = "http://automationpractice.com/index.php";
	public WebElement women;
	public WebElement dresses;
	public WebElement summerDresses;
	public WebElement summerDresses2;

	public void hoverOnMenuWomen(WebDriver driver) {
		Actions action = new Actions(driver);
		women = driver.findElement(By.xpath("//a[@title='Women']"));
		action.moveToElement(women).perform();

	}

	public void clickOnSummerDresses(WebDriver driver) {
		summerDresses = driver.findElement(By.xpath("//a[@title='Summer Dresses']"));
		summerDresses.click();

	}

	public void hoverOnMenuDresses(WebDriver driver) {
		Actions action2 = new Actions(driver);
		dresses = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]"));
		action2.moveToElement(dresses).perform();
	}

	public void clickOnSummerDresses2(WebDriver driver) {
		summerDresses2 = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]"));
		summerDresses2.click();

	}
}

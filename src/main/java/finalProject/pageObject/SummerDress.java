package finalProject.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummerDress {
	public static final String SUMMER_DRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public WebElement more_element;
	public WebElement quntity;
	public WebElement size;
	public WebElement color;
	public WebElement addToCard;
	public WebElement checkoutButton;
	public WebElement sizeColorCheck;
	public WebElement quantityCheck;
	public WebElement nameOfDressCheck;

	public void clickOnDress(WebDriver driver) {
		more_element = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a"));
		more_element.click();

	}

	public void choseDress(WebDriver driver) {
		quntity = driver.findElement(By.id("quantity_wanted"));
		quntity.clear();
		quntity.sendKeys("2");
		size = driver.findElement(By.xpath("//select[@id='group_1']/option[@value='2']"));
		size.click();
		color = driver.findElement(By.xpath("//*[@id='color_to_pick_list']/li[3]"));
		color.click();
		addToCard = driver.findElement(By.name("Submit"));
		addToCard.click();
	}

	public void checkout(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		checkoutButton = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		wait.until(ExpectedConditions.visibilityOf(checkoutButton));
		checkoutButton.click();

	}

	public void infoDress(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		sizeColorCheck = driver.findElement(By.xpath("//*[@id='product_5_24_0_0']/td[2]/small[2]/a"));
		wait.until(ExpectedConditions.visibilityOf(sizeColorCheck));
		quantityCheck = driver.findElement(By.xpath("//input[@name='quantity_5_24_0_0']"));
		nameOfDressCheck = driver.findElement(By.xpath("//*[@id='product_5_24_0_0']/td[2]/p/a"));
		
	}

}

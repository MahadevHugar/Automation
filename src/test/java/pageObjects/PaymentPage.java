package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends Basepage {

	public PaymentPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy (xpath = "//input[@placeholder='Select Country']")
	WebElement selCountry;
	@FindBy (css = ".action__submit")
	WebElement placeOrderBtn;
	
	public void placeOrder() throws InterruptedException {
		selCountry.sendKeys("ind");
		Thread.sleep(3000);
		selCountry.sendKeys(Keys.ARROW_DOWN);
		selCountry.sendKeys(Keys.ARROW_DOWN);
		selCountry.sendKeys(Keys.ENTER);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		placeOrderBtn.click();
		
	}

}

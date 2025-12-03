package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends Basepage {

	public Checkout(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath = "//button[contains(.,'Checkout')]")
	WebElement checkoutBtn;
	
	//Action 
	
	public void goToPaymentPage() {
		checkoutBtn.click();
	}
}

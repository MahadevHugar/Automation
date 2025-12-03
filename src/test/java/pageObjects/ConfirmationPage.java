package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends Basepage {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	
	}

	@FindBy (css = ".hero-primary")
	WebElement confirmationText;
	
	
	public String OrderConfirmation() {
		String confText = confirmationText.getText();
		return confText;
	}
}

package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoard extends Basepage {

	public DashBoard(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//ul/li[contains(.,'HOME')]")
	WebElement homeBtn;
	@FindBy(xpath = "//ul/li[contains(.,'ORDERS')]")
	WebElement OrderBtn;
	@FindBy(xpath = "//ul/li[contains(.,'Cart')]")
	WebElement cartBtn;
	@FindBy(xpath = "//ul/li[contains(.,'Sign')]")
	WebElement signoutBtn;

	// auction
	public void gotoCartPage() {
		cartBtn.click();

	}

	public void gotoHomePage() {
		homeBtn.click();

	}

	public void gotoMyOrderPage() {
		OrderBtn.click();

	}

	public void signOut() {
		signoutBtn.click();

	}

//	public boolean isDashboardPageExist() {
//		boolean displayed = cartBtn.isDisplayed();
//		return displayed;
//	}
//	
	public String verifyPageTitle() throws InterruptedException {
		String title = driver.getTitle();
		return title;

	}

	public boolean verifyLogin() {
		try {
			boolean pageDispalyed = cartBtn.isDisplayed();
			return pageDispalyed;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}

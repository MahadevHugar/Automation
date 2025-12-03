package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends Basepage{
//constructor
	public LandingPage(WebDriver driver) {
		super(driver);
		
		
	}
	
	//locators or elements
	
	@FindBy (id = "userEmail")
	WebElement username;
	
	@FindBy (id = "userPassword")
	WebElement password;
	
	@FindBy (id="login")
	WebElement loginbtn;
	
	
	
	
	
	//action
	
	public void loginToApplication(String uname, String pwd) throws InterruptedException {
		username.clear();
		password.clear();
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
		Thread.sleep(3000);
	}

	public String verifyLogin() throws InterruptedException {
		Thread.sleep(2000);
		String title = driver.getTitle();
		return title;

	}
}

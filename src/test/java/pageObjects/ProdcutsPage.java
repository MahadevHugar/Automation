package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdcutsPage extends Basepage {

	public ProdcutsPage(WebDriver driver) {
		super(driver);
		
	}
	By fetchName=By.xpath("//div[@class='card-body']/h5");
	By btnClick=By.xpath("//button[@class='btn w-10 rounded']");
	
	
	
	@FindBy (css = ".mb-3")
	List<WebElement> listProducts;
	
	
	
	//action
	
	public void addToCart(String productName) throws InterruptedException {
	listProducts.stream().filter(s->s.findElement(fetchName).getText().equalsIgnoreCase(productName))
	.findFirst().ifPresent(s->s.findElement(btnClick).click());
	Thread.sleep(5000);
	}

}

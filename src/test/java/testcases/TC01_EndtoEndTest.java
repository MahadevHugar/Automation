package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Checkout;
import pageObjects.ConfirmationPage;
import pageObjects.DashBoard;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;
import pageObjects.ProdcutsPage;
import testBase.baseClass;

public class TC01_EndtoEndTest extends baseClass {
	@Test(groups= {"Regression","Master"})
	public void submitorder() throws InterruptedException {
		try {
		logger.info("Starting Testcase TC01_end to end test");
		String itemName="ZARA COAT 3";
		
		logger.info("Logging to application");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		LandingPage lp= new LandingPage(driver);
		lp.loginToApplication(username, password);
		ProdcutsPage pp= new ProdcutsPage(driver);
		logger.info("Adding product to cart");
		pp.addToCart(itemName);
		
		DashBoard dashboard = new DashBoard(driver);
		logger.info("Clicking on cart button");
		dashboard.gotoCartPage();
		Checkout checkout =new Checkout(driver);
		checkout.goToPaymentPage();
		logger.info("entering to payment page");
		PaymentPage paypage=new PaymentPage(driver);
		paypage.placeOrder();
		
		logger.info("validating order");
		ConfirmationPage cp= new ConfirmationPage(driver);
		String orderConfirmationText = cp.OrderConfirmation();
		
		Assert.assertEquals(orderConfirmationText, "THANKYOU FOR THE ORDER.");
		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001 *****");
		}
	}

}

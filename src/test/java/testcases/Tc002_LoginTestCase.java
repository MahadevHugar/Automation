package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBoard;
import pageObjects.LandingPage;
import testBase.baseClass;

public class Tc002_LoginTestCase extends baseClass {
	@Test(groups= {"Sanity","Master"})
	public void login() {

		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		logger.info("***starting Tc002_LoginTestCase **** ");
		logger.debug("capturing application debug logs....");

		try {
			LandingPage lp = new LandingPage(driver);
			logger.info("logging to application");
			lp.loginToApplication(username, password);

			// verify login
//		String verifyLogin = lp.verifyLogin();
//		
//		Assert.assertTrue(title);

			DashBoard dashboard = new DashBoard(driver);
			String dashboardPageExist = dashboard.verifyPageTitle();
			boolean title = dashboardPageExist.equalsIgnoreCase("Let's Shop");
			Assert.assertTrue(title);
			logger.info("logged in sucussfullly");
		} catch (Exception e) {
			logger.error("Login failed");
			logger.debug("login failed ");
			Assert.fail();
			

		}
		logger.info("*****Finished Tc002_LoginTestCase******* ");
	}

}

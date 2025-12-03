package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBoard;
import pageObjects.LandingPage;
import testBase.baseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass

*/

public class TC_003_LoginDDT extends baseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups= {"Sanity"})
	public void verifyLoginData(String username, String password, String exp) {
		logger.info("******STarting TC_003_LoginDDT*****");

		try {

			LandingPage lp = new LandingPage(driver);
			lp.loginToApplication(username, password);
			DashBoard db = new DashBoard(driver);
			boolean verifyLogin = db.verifyLogin();
//			String title = db.verifyPageTitle();
//			boolean pageExist = title.equalsIgnoreCase("Let's Shop");
//			System.out.println(pageExist);

			if (exp.equalsIgnoreCase("Valid")) {
				if (verifyLogin == true) {
					db.signOut();
					logger.info("Login success");
					Assert.assertTrue(true);

				} else {
					logger.error("Login failed");
					Assert.assertTrue(false);
				}

			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (verifyLogin == true) {
					db.signOut();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());

		}
		logger.info("**** Finished TC_003_LoginDDT *****");

	}

}

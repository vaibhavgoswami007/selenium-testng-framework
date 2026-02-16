package testCasesEcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;

import MMTPageObjects.HomePage;
import testComponents.TestBase;

public class TC_07_Verify_TestCase_Page extends TestBase {
	
	@Test
	public void verifyTestcasePage() {
		HomePage homePage = new HomePage(driver);
		homePage.clickTestCaseButton();
		homePage.closeAdIfPresent();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/test_cases");
	}

}

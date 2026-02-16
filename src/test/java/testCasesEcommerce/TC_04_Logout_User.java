package testCasesEcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;

import MMTPageObjects.HomePage;
import MMTPageObjects.LoggedInPage;
import MMTPageObjects.LoginSignupPage;
import testComponents.TestBase;

public class TC_04_Logout_User extends TestBase{


	@Test
	public void logoutUser() {
		HomePage homepage = new HomePage(driver);
		homepage.loginClick();

		LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
		Assert.assertEquals(loginSignupPage.loginHeadingText(),"Login to your account");
		loginSignupPage.login("ayush0202@mail.com","Test@12345");

		LoggedInPage loggedIn = new LoggedInPage(driver);
		Assert.assertEquals(loggedIn.getLoggedInUsername(), "Ayush Yadav");
		loggedIn.logOutUser();

		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");

	}
}

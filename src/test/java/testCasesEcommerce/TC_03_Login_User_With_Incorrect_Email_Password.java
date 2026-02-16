package testCasesEcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;

import MMTPageObjects.HomePage;
import MMTPageObjects.LoggedInPage;
import MMTPageObjects.LoginSignupPage;
import testComponents.TestBase;

public class TC_03_Login_User_With_Incorrect_Email_Password extends TestBase{
	
	
	@Test
	public void loginUserWithIncorrectEmailandPassword() {
		
		HomePage homepage = new HomePage(driver);
		homepage.loginClick();
		
		LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
		Assert.assertEquals(loginSignupPage.loginHeadingText(),"Login to your account");
		loginSignupPage.login("ayush0202@maill.com","Test@12345");
		
		Assert.assertEquals(loginSignupPage.getErrorMessage(),"Your email or password is incorrect!");
	}

}

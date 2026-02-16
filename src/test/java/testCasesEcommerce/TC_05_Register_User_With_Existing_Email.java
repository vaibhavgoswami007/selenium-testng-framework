package testCasesEcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;

import MMTPageObjects.HomePage;
import MMTPageObjects.LoginSignupPage;
import testComponents.TestBase;

public class TC_05_Register_User_With_Existing_Email extends TestBase {
	
	@Test
	public void registerUserWithExistingEmail() {
		
		HomePage homePage = new HomePage(driver);
		homePage.loginClick();
		
		LoginSignupPage signup = new LoginSignupPage(driver);
	    Assert.assertEquals(signup.getSignUpText(), "New User Signup!");
	    signup.signUp("Ayush Yadav", "ayush0202@mail.com");
	    Assert.assertEquals(signup.getAlreadyExistMSg(),"Email Address already exist!");
	    
	}
}

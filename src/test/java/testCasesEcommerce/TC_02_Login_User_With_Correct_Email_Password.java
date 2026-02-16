package testCasesEcommerce;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import MMTPageObjects.HomePage;
import MMTPageObjects.LoggedInPage;
import MMTPageObjects.LoginSignupPage;
import testComponents.TestBase;
import testDataProvider.LoginDataProvider;


//WHen you use PArameters
//public class TC_02_Login_User_With_Correct_Email_Password extends TestBase{
//
//	@Parameters({"email","password"})
//	@Test
//	public void loginUserWithCorrectEmailandPassword(@Optional("ayush0202@mail.com") String email ,@Optional("Test@12345") String password){
//		
//		HomePage homepage = new HomePage(driver);
//		homepage.loginClick();
//		
//		LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
//		Assert.assertEquals(loginSignupPage.loginHeadingText(),"Login to your account");
//		loginSignupPage.login(email,password);
//		
//		 LoggedInPage loggedIn = new LoggedInPage(driver);
//		 Assert.assertEquals(loggedIn.getLoggedInUsername(), "Ayush Yadav");
////		 loggedIn.deleteAccount();
//		
//	}
//}
public class TC_02_Login_User_With_Correct_Email_Password extends TestBase{

	@Test(
		    dataProvider = "loginData",
		    dataProviderClass = LoginDataProvider.class
		)
		public void loginUserWithCorrectEmailandPassword(
		        String email,
		        String password,
		        String expectedUsername) {

		    HomePage homepage = new HomePage(driver);
		    homepage.loginClick();

		    LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
		    Assert.assertEquals(
		        loginSignupPage.loginHeadingText(),
		        "Login to your account"
		    );

		    loginSignupPage.login(email, password);

		    LoggedInPage loggedIn = new LoggedInPage(driver);
		    Assert.assertEquals(
		        loggedIn.getLoggedInUsername(),
		        expectedUsername
		    );
		}

}


package testCasesEcommerce;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponent.BasePage;
import MMTPageObjects.AccountCreatedPage;
import MMTPageObjects.AccountInformationPage;
import MMTPageObjects.HomePage;
import MMTPageObjects.LoggedInPage;
import MMTPageObjects.LoginSignupPage;
import testComponents.TestBase;

public class TC_01_Register_User extends TestBase {


	@Test
	public void registerUser() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		homePage.loginClick();
		
		
		((JavascriptExecutor)driver)
		  .executeScript("window.scrollBy(0,300)");
		
		
		LoginSignupPage signup = new LoginSignupPage(driver);
	    Assert.assertEquals(signup.getSignUpText(), "New User Signup!");
	    signup.signUp("Ayush Yadav", "ayush" + System.currentTimeMillis() + "@mail.com");
		
	    AccountInformationPage account = new AccountInformationPage(driver);
	    account.selectTitle();
	    Assert.assertEquals(account.getName(), "Ayush Yadav");
	    account.fillPasswordAndDOB();
	    account.fillAddressDetails();

	    ((JavascriptExecutor)driver)
		  .executeScript("window.scrollBy(0,300)");
		
	    account.createAccount();
	    
	    
	    
	    AccountCreatedPage created = new AccountCreatedPage(driver);
	    created.clickContinue();
	    created.closeAdIfPresent();	   
	    
	    LoggedInPage loggedIn = new LoggedInPage(driver);
	    Assert.assertEquals(loggedIn.getLoggedInUsername(), "Ayush Yadav");
	    loggedIn.deleteAccount();
	    
	    
	    
	    
//		Before POM Implementation

//		BasePage bp= new BasePage(driver);
//		WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
//		loginButton.click();	
//
//
//		WebElement newUserSignUp = driver.findElement(By.xpath("//form[@action='/signup']/preceding-sibling::h2[1]"));
//		Assert.assertEquals(newUserSignUp.getText(),"New User Signup!");
//
//
//		WebElement signUpName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
//		signUpName.sendKeys("Ayush Yadav");
//
//		WebElement signUpEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
//		signUpEmail.sendKeys("ayushyadav02011@gmail.com");
//
//
//		WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
//
//		signUpButton.click();
//
//		//input[@value='Mrs']
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@value='Mrs']")).click();
//
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@data-qa='name']")).getAttribute("value"),"Ayush Yadav");
//
//		bp.handleCalender("21","3","1992");
//
//
//		driver.findElement(By.xpath("//input[@data-qa='password']"))
//		.sendKeys("Test@12345");
//
//		driver.findElement(By.xpath("//input[@data-qa='first_name']"))
//		.sendKeys("John");
//
//		driver.findElement(By.xpath("//input[@data-qa='last_name']"))
//		.sendKeys("Doe");
//
//		driver.findElement(By.xpath("//input[@data-qa='company']"))
//		.sendKeys("AcmeCorp");
//
//		driver.findElement(By.xpath("//input[@data-qa='address']"))
//		.sendKeys("221 Baker Street");
//
//
//		driver.findElement(By.xpath("//input[@data-qa='state']"))
//		.sendKeys("California");
//
//		driver.findElement(By.xpath("//input[@data-qa='city']"))
//		.sendKeys("Los Angeles");
//
//		driver.findElement(By.xpath("//input[@data-qa='zipcode']"))
//		.sendKeys("90001");
//
//		driver.findElement(By.xpath("//input[@data-qa='mobile_number']"))
//		.sendKeys("9876543210");
//
//		driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
//		
//		
//		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Logged')]/b")).getText(),"Ayush Yadav");
//		
//		driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();
//		
//		
//		
//		
//		//input[@data-qa='state']
//		//input[@data-qa='city']
//		//input[@data-qa='zipcode']
//		//input[@data-qa='mobile_number']






	}

}

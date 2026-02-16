package MMTPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponent.BasePage;

public class LoginSignupPage extends BasePage{
	
	private By newUserSignUp = By.xpath("//form[@action='/signup']/preceding-sibling::h2[1]");
	private By signUpName = By.xpath("//input[@data-qa='signup-name']");
	private By signUpEmail = By.xpath("//input[@data-qa='signup-email']");
	private By signUpButton = By.xpath("//button[@data-qa='signup-button']");
	
	
	private By loginHeading = By.xpath("//form[@action='/login']/preceding-sibling::h2[1]");
	private By loginEmail = By.xpath("//input[@data-qa='login-email']");
	private By loginPasword = By.xpath("//input[@data-qa='login-password']");
	private By loginbutton = By.xpath("//button[@data-qa='login-button']");
	
	private By errorMessage = By.cssSelector("input[data-qa='login-password']+p");
	private By alreadExistmsg = By.xpath("//input[@data-qa='signup-email']/following-sibling::p");
	
	

	public LoginSignupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getSignUpText() {
		return driver.findElement(newUserSignUp).getText();
	}
	
	public String loginHeadingText() {
		return driver.findElement(loginHeading).getText();
	}
	
	public void signUp(String name , String email ) {
		driver.findElement(signUpName).sendKeys(name);
		driver.findElement(signUpEmail).sendKeys(email);
		driver.findElement(signUpButton).click();
	}
	
	public void login(String email,String password) {
		driver.findElement(loginEmail).sendKeys(email);
		driver.findElement(loginPasword).sendKeys(password);
		driver.findElement(loginbutton).click();
		
	}
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
	
	public String getAlreadyExistMSg() {
		return driver.findElement(alreadExistmsg).getText();
	}
	

}


//WebElement newUserSignUp = driver.findElement(By.xpath("//form[@action='/signup']/preceding-sibling::h2[1]"));
//Assert.assertEquals(newUserSignUp.getText(),"New User Signup!");
//
//
//WebElement signUpName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
//signUpName.sendKeys("Ayush Yadav");
//
//WebElement signUpEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
//signUpEmail.sendKeys("ayushyadav02011@gmail.com");
//
//
//WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
package MMTPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponent.BasePage;


public class HomePage extends BasePage {
	
	private By loginButton = By.xpath("//a[@href='/login']");
	
	private By contactUsButton = By.xpath("//a[@href='/contact_us']");

	private By testCaseBUtton = By.xpath("//a[@href='/test_cases']");

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void loginClick() {
		driver.findElement(loginButton).click();
	}
		
	public void contactButtonClick() {
		driver.findElement(contactUsButton).click();
	}
	public void clickTestCaseButton() {
		driver.findElement(testCaseBUtton).click();
	}
}

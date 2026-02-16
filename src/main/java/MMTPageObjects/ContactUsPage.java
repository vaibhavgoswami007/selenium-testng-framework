package MMTPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponent.BasePage;

public class ContactUsPage extends BasePage{


	private By getInTouch = By.xpath("//div[@class='contact-form']/h2");
	private By nameInput = By.cssSelector("input[data-qa='name']");
	private By emailInput = By.cssSelector("input[data-qa='email']");
	private By subjectInput = By.cssSelector("input[data-qa='subject']");
	private By messageTextarea = By.cssSelector("textarea[data-qa='message']");
	private By uploadFile = By.xpath("//input[@name = 'upload_file']");
	private By submitButton = By.xpath("//input[@data-qa='submit-button']");
	
	private By successMsg = By.xpath("//div[contains(@class,'status')]");
	private By homeButton = By.xpath("//a[contains(@class,'btn')]");
	
	private By addClose = By.id("dismiss-button");
	

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
	public String getInTouchText() {
		return driver.findElement(getInTouch).getText();
	}

	public String getSuccessMsg () {
		return driver.findElement(successMsg).getText();
	}
	
	public void clickHomeButton() {
		driver.findElement(homeButton).click();
	}

	public void fillContactForm(String name, String email,
			String subject, String message,String fileLocation) {
		
		driver.findElement(nameInput).sendKeys(name);
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(subjectInput).sendKeys(subject);
		driver.findElement(messageTextarea).sendKeys(message);
		driver.findElement(uploadFile).sendKeys(fileLocation);
		driver.findElement(submitButton).click();
		
	}
}




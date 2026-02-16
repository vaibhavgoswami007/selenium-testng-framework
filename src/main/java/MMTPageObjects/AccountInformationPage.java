package MMTPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponent.BasePage;

public class AccountInformationPage extends BasePage {

    private By titleMrs = By.xpath("//input[@value='Mrs']");
    private By nameValue = By.xpath("//input[@data-qa='name']");
    private By password = By.xpath("//input[@data-qa='password']");
    private By createAccountBtn =
        By.xpath("//button[@data-qa='create-account']");

    public AccountInformationPage(WebDriver driver) {
        super(driver);
    }

    public void selectTitle() {
//        click(titleMrs);
    	driver.findElement(titleMrs).click();
    }

    public String getName() {
        return driver.findElement(nameValue).getAttribute("value");
    }

    public void fillPasswordAndDOB() {
        handleCalender("21", "3", "1992");
        sendKeys(password, "Test@12345");
    }

    public void fillAddressDetails() {
        sendKeys(By.xpath("//input[@data-qa='first_name']"), "John");
        sendKeys(By.xpath("//input[@data-qa='last_name']"), "Doe");
        sendKeys(By.xpath("//input[@data-qa='company']"), "AcmeCorp");
        sendKeys(By.xpath("//input[@data-qa='address']"), "221 Baker Street");
        sendKeys(By.xpath("//input[@data-qa='state']"), "California");
        sendKeys(By.xpath("//input[@data-qa='city']"), "Los Angeles");
        sendKeys(By.xpath("//input[@data-qa='zipcode']"), "90001");
        sendKeys(By.xpath("//input[@data-qa='mobile_number']"), "9876543210");
    }

    public void createAccount() {
        driver.findElement(createAccountBtn).click();
    }
}

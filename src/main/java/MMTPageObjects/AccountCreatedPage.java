package MMTPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponent.BasePage;

public class AccountCreatedPage extends BasePage {

    private By continueBtn =
        By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    
    
    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
}




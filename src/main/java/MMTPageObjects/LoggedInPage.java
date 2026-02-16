package MMTPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponent.BasePage;

public class LoggedInPage extends BasePage {

    private By loggedInUser =
        By.xpath("//a[contains(text(),'Logged')]/b");
    private By deleteAccount =
        By.xpath("//a[@href='/delete_account']");
    
    private By logoutButton = By.cssSelector("a[href='/logout']");

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUsername() {
        return driver.findElement(loggedInUser).getText();
    }

    public void deleteAccount() {
        driver.findElement(deleteAccount).click();
    }
    
    public void logOutUser() {
    	driver.findElement(logoutButton).click();
    }
}

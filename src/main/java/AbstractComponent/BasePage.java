package AbstractComponent;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.DriverFactory;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		
		this.driver = driver;
    	PageFactory.initElements(driver, this);
		
	}
	public void handleCalender(String date , String month , String year) {
		
		WebElement dateElement = driver.findElement(By.xpath("//select[@data-qa='days']"));
		Select dateDropdown = new Select(dateElement);
		dateDropdown.selectByValue(date);
		

		WebElement MonthElement = driver.findElement(By.xpath("//select[@data-qa='months']"));
		Select MonthDropdown = new Select(MonthElement);
		MonthDropdown.selectByValue(month);
		

		WebElement yearElement = driver.findElement(By.xpath("//select[@data-qa='years']"));
		Select yearDropdown = new Select(yearElement);
		yearDropdown.selectByValue(year);
		
	}
	
	public void closeAdIfPresent() {
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println(iframes.size());
		for (WebElement iframe : iframes) {
		    driver.switchTo().frame(iframe);
		    List<WebElement> dismiss =
		            driver.findElements(By.id("dismiss-button"));
		    if (!dismiss.isEmpty()) {
		        dismiss.get(0).click();
		        driver.switchTo().defaultContent();
		        break;
		    }
		    driver.switchTo().defaultContent();
		}
	}
	
	public String captureScreenshot(String testName) throws IOException {

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir")
                + "/reports/screenshots/" + testName + ".png";

        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
	public void sendKeys(By locator, String value) {
	    driver.findElement(locator).sendKeys(value);
	}
	
	
}

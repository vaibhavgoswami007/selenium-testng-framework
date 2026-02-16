package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Resources.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
public final class DriverFactory {

    private DriverFactory() {}

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().getDownloadedDriverVersion();
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());

        } else {
            throw new RuntimeException("Invalid browser: " + browser);
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
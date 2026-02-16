package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Resources.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public WebDriver driver;


	public WebDriver initializeDriver() throws IOException {

//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream(
//				System.getProperty("user.dir") + "/src/main/java/Resources/config.properties");
//		prop.load(fis);
//		ConfigReader configReader = new ConfigReader();
		

		String browser = ConfigReader.get("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().getDownloadedDriverVersion();
			driver = new ChromeDriver();

			System.out.println("test");

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			throw new RuntimeException("Invalid browser: " + browser);
		}

		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void launchApplication() throws IOException {
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream(
//				System.getProperty("user.dir") + "/src/main/java/Resources/config.properties");
//		prop.load(fis);

		driver = initializeDriver();
		driver.get(ConfigReader.get("url"));

	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}



}

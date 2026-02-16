package testComponents;

import Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import AbstractComponent.BasePage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    } 

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());

	    try {
	        // Get running test instance
	        TestBase testBase =
	                (TestBase) result.getInstance();

	        WebDriver driver = testBase.getDriver();

	        // Create BasePage with same driver
	        BasePage basePage = new BasePage(driver);

	        String screenshotPath =
	                basePage.captureScreenshot(
	                        result.getMethod().getMethodName());

	        test.addScreenCaptureFromPath(screenshotPath);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		
	}
}
package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir")
                + "/reports/ExtentReport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Test Results");
        reporter.config().setDocumentTitle("Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Vaibhav Goswami");
        extent.setSystemInfo("Framework", "Selenium + TestNG");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}

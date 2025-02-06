package reports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static WebDriver driver;  // Declare WebDriver

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setReportName("Automation Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("❌ Test Failed: " + result.getName());
        test.fail("Reason: " + result.getThrowable().getMessage());

        // Take a screenshot and attach it to the report
        if (driver != null) {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
//            test.addScreenCaptureFromPath(screenshotPath);
            test.addScreenCaptureFromPath(screenshotPath.replace("test-output/", ""));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("⚠️ Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();  // Save the report
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}


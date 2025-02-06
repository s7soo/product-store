package reports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    private int passedTests = 0;
    private int failedTests = 0;
    private int skippedTests = 0;

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests++;
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests++;
        System.out.println("Test Failed: " + result.getName());
        System.out.println("Reason: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedTests++;
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n===== TEST EXECUTION SUMMARY =====");
        System.out.println("Total Tests Run: " + context.getAllTestMethods().length);
        System.out.println("Passed Tests: " + passedTests);
        System.out.println("Failed Tests: " + failedTests);
        System.out.println("Skipped Tests: " + skippedTests);
        System.out.println("==================================");
    }
}


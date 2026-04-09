package base;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.*;

import java.io.File;

public class Listeners implements ITestListener, ISuiteListener {

    private ExtentReports extent = ExtentManager.getReporter();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ISuite suite) {

        System.out.println("====================================");
        System.out.println("Starting Automation Suite: " + suite.getName());
        System.out.println("====================================");
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println(">>> Starting Test Module: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Executing Test: " + result.getName());

        ExtentTest extentTest =
                extent.createTest(
                        result.getTestClass().getName()
                                + " :: "
                                + result.getMethod().getMethodName()
                );

        test.set(extentTest);

        test.get().log(Status.INFO,
                "Test Execution Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Passed: " + result.getName());

        if (test.get() != null) {
            test.get().log(Status.PASS,
                    "Verification Successful for: " + result.getName());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.err.println("Test FAILED: " + result.getName());

        if (test.get() == null) {

            ExtentTest extentTest =
                    extent.createTest(
                            result.getTestClass().getName()
                                    + " :: "
                                    + result.getMethod().getMethodName()
                    );

            test.set(extentTest);
        }

        test.get().log(Status.FAIL,
                "Verification FAILED for: " + result.getName());

        test.get().log(Status.FAIL,
                result.getThrowable());

        try {

            Object testClass = result.getInstance();

            if (testClass instanceof BaseClass) {

                BaseClass base = (BaseClass) testClass;

                String screenshotPath =
                        base.captureScreenshot(result.getName());

                test.get().fail(
                        "Failure Evidence:",
                        MediaEntityBuilder
                                .createScreenCaptureFromPath(screenshotPath)
                                .build()
                );
            }

        } catch (Exception e) {

            test.get().log(Status.WARNING,
                    "Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Test Skipped: " + result.getName());

        if (test.get() == null) {

            ExtentTest extentTest =
                    extent.createTest(
                            result.getTestClass().getName()
                                    + " :: "
                                    + result.getMethod().getMethodName()
                    );

            test.set(extentTest);
        }

        test.get().log(Status.SKIP,
                "Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ISuite suite) {

        System.out.println("====================================");
        System.out.println("Finalizing Automation Suite...");
        System.out.println("Generating Report...");
        System.out.println("====================================");

        if (extent != null) {

            extent.flush();

            System.out.println("SUCCESS: Extent Report Generated in /reports folder");
        }
    }
}
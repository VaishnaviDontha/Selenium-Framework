package listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import annotations.FrameworkAnnotation;
import reports.ExtentLogger;
import reports.Reporting;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) { // Before Suite calls
        try {
            Reporting.initReports();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) { // After Suite calls
        try {
            Reporting.flushReports();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Reporting.createTest(result.getMethod().getMethodName());
        Reporting.createTest(result.getMethod().getDescription());
        Reporting.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        Reporting.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + "is Failed", true);
            ExtentLogger.fail(result.getThrowable().toString()); // to grab top-most log from the exception
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); // to grab complete failed o/p
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentLogger.skip(result.getMethod().getMethodName() + "is Skipped", true);
        } catch (Exception e) {
        
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * Not having any implementation for now
         */
       
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * Not having any implementation for now
         */
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
         /*
         * Not having any implementation for now
         */
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
         /*
         * Not having any implementation for now
         */
    }


    
}

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
import utilities.ElkUtils;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) { // Before Suite calls
 
            Reporting.initReports();
       
    }

    @Override
    public void onFinish(ISuite suite) { // After Suite calls
   
            Reporting.flushReports();
       
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
        ElkUtils.sendDetailsToElk(result.getMethod().getMethodName(), "pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        
            ExtentLogger.fail(result.getMethod().getMethodName() + "is Failed", true);
            ExtentLogger.fail(result.getThrowable().toString()); // to grab top-most log from the exception
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); // to grab complete failed o/p
            ElkUtils.sendDetailsToElk(result.getMethod().getMethodName(), "fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        
            ExtentLogger.skip(result.getMethod().getMethodName() + "is Skipped", true);
            ElkUtils.sendDetailsToElk(result.getMethod().getMethodName(), "skip");
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

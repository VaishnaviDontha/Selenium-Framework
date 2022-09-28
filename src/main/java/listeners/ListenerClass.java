package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
        Reporting.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + "is Failed", true);
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

}

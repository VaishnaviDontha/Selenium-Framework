package tests;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class BaseTest {

    protected BaseTest() {
    }

    // @AfterSuite
    // public void afterSuite() throws IOException {
    // // Reporting.flushReports();

    // }

    @BeforeMethod
    protected void setUp(Method m) throws Exception {

        // Reporting.createTest(m.getName()); // retreiving method name via
        // java.lang.reflect
        Driver.initDriver();

    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        Driver.quitDriver();

    }

}

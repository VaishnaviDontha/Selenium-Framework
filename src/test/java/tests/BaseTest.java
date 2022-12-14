package tests;

import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class BaseTest {

    protected BaseTest() {
    }

    // @SuppressWarnings("unchecked")
    // @BeforeMethod
    // protected void setUp(Object[] data) throws Exception {

    //     Map<String, String> map = (Map<String, String>) data[0];
    //     Driver.initDriver(map.get("browser"));

    // }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data)  {

        Map<String,String> map = (Map<String,String>)data[0];
        Driver.initDriver(map.get("browser"));
        
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        Driver.quitDriver();

    }

}

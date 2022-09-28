package reports;

import com.aventstack.extentreports.ExtentTest;

public class ReportingManager {

    private ReportingManager() {}

    private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();

    static ExtentTest getExtenttest() {
        return extenttest.get();
    }

    static void setExtenttest(ExtentTest test) {
       extenttest.set(test);
    }

    static void unload() {
        extenttest.remove();
        
    }
    
}

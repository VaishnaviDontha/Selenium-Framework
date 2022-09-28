package reports;

import java.io.File;
import java.util.Objects;
import java.awt.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

public class Reporting {

    private Reporting() {
    }

    private static ExtentReports extent;

    public static void initReports() throws Exception {

        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Se Report");
            spark.config().setReportName("Report");
        }

    }

    public static void flushReports() throws Exception {

        if (Objects.nonNull(extent)) {
            extent.flush();
            
        }

        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        
    }

    public static void createTest(String testcasename) {
        ExtentTest test = extent.createTest(testcasename);   
        ReportingManager.setExtenttest(test);
        
    }
}

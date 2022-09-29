package reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;

import driver.DriverManager;
import enums.ConfigProperties;
import utilities.PropertyUtils;
import utilities.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger() {}

    public static void pass(String message) {
        ReportingManager.getExtenttest().pass(message);
    }

    public static void fail(String message) {
        ReportingManager.getExtenttest().fail(message);
    }

    public static void skip(String message) {
        ReportingManager.getExtenttest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotRequired) throws Exception {
        if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotRequired) {

            ReportingManager.getExtenttest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            
        }
        else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotRequired) throws Exception {
        if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotRequired) {

            ReportingManager.getExtenttest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            
        }
        else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotRequired) throws Exception {
        if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotRequired) {

            ReportingManager.getExtenttest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            
        }
        else{
            skip(message);
        }
    }

   
    
}

package constants;

import enums.ConfigProperties;
import utilities.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){
        
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir")+ "/src/test/resources" ;
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver";
    private static final String FIREFOXDRIVERPATH = RESOURCESPATH + "/executables/geckodriver";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties"; 
    private static final int EXPLICITWAIT = 10; 
    private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
    private static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath = "";
    

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }
 
    public static String getFirefoxdriverpath() {
        
        return FIREFOXDRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }

    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
            
        }
        return extentReportFilePath;
    }

    private static String createReportPath() throws Exception {

        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {

            return EXTENTREPORTPATH+"/"+System.currentTimeMillis()+"/index.html"; 
        }
        else{
        return EXTENTREPORTPATH+"/index.html";
        }
    }

    public static String getExcelpath() {
        return EXCELPATH;
    }


    
}



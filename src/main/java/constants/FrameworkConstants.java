package constants;

public final class FrameworkConstants {

    private FrameworkConstants(){
        
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir")+ "/src/test/resources" ;
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver";
    private static final String FIREFOXDRIVERPATH = RESOURCESPATH + "/executables/geckodriver";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties"; 
    private static final int EXPLICITWAIT = 10; 

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    
    public static String getFirefoxdriverpath() {
        System.out.println(FIREFOXDRIVERPATH);
        return FIREFOXDRIVERPATH;
    }



    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }

    
    
}

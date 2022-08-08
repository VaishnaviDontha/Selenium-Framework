package constants;

public final class FrameworkConstants {

    private FrameworkConstants(){
        
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir")+ "/src/test/resources" ;
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties"; 
    
    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    
    
}

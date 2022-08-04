package constants;

public final class FrameworkConstants {

    private FrameworkConstants(){
        
    }

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+ "/src/test/resources/executables/chromedriver";

    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }
    
}

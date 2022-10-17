package utilities;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}

    public static String getXpath(String xpath, String value) {

        // return xpath.replace("%replacable%", value);
        return String.format(xpath, value);
        
    }
    
}

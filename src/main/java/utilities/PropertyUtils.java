package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import constants.FrameworkConstants;
import enums.ConfigProperties;

public final class PropertyUtils {

    private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	private PropertyUtils() {

	}

	static {
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			property.load(file);

			for(Map.Entry<Object,Object> entry : property.entrySet()){

				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
	
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} 


	}

	/**
	 * @author 
	 * @param url To be fetched from property file
	 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
	 * @throws Exception
	 */

	 
	public static String get(ConfigProperties key) throws Exception  {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());

		// if(Objects.isNull(property.getProperty(url)) || Objects.isNull(url)){
		// 	throw new Exception("Property name " + url + " is not found. Please check config.properties");

		// }
		// return property.getProperty(url);

	}
    
}

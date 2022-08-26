package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import constants.FrameworkConstants;
import enums.ConfigProperties;

public final class ReadingPropertyFile {

    private static Properties property = new Properties();

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ReadingPropertyFile() {}

	static {
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			property.load(file);
	
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} 
	}

	/**
	 * @author 
	 * @param key To be fetched from property file
	 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
	 * @throws Exception
	 */

	 
	public static String getValue(ConfigProperties key) throws Exception  {
		if (Objects.isNull(key) || Objects.isNull(key.name().toLowerCase())) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties");
		}
		return key.name().toLowerCase();
	}
    
    
}

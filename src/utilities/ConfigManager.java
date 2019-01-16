package utilities;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigManager {

	public static ThreadLocal<Properties> propThread = new ThreadLocal<Properties>();
	OutputStream outputStream = null;
	InputStream inputStream = null;
	String propertyName;
	Properties prop = new Properties();
	String configPath = "/resources/config.properties";
	static FileReader reader;

	// 1. method to get property from config file

	//	public String getProperty(String property)
	//	{
	//		try
	//		{
	//			inputStream = new FileInputStream(configPath);
	//			if (inputStream != null) {
	//				prop.load(inputStream);
	//			} else {
	//				throw new FileNotFoundException("property file '" + configPath + "' not found in the classpath");
	//			}
	//			propertyName = prop.getProperty(property);			
	//		}
	//		catch(Exception e)
	//		{
	//			System.out.println(e.getMessage());
	//		}
	//		return propertyName;
	//	}

	// 2. method to get property from config file	
	// To use when config file is in the classpath
	//	public String getProperty1(String property)
	//	{
	//		try
	//		{
	//			inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(System.getProperty("user.dir") + configPath);
	//			if (inputStream != null) {
	//				prop.load(inputStream);
	//			} else {
	//				throw new FileNotFoundException("property file '" + configPath + "' not found in the classpath");
	//			}
	//			propertyName = prop.getProperty(property);
	//		}
	//		catch(Exception e)
	//		{
	//			System.out.println(e.getMessage());
	//		}
	//		return propertyName;
	//	}

	//method to get properties for a threadlocal variable
	public static Properties getProperties()
	{
		return propThread.get();
	}

	//sets a given property into the properties file
	public void setProperty(String key, String property)
	{
		try
		{
			outputStream = new FileOutputStream(configPath);
			prop.setProperty(key, property);
			prop.store(outputStream, null);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// this method sets/loads the Properties file to read 
	public static void setProperties()
	{
		try
		{
			propThread.set(new Properties());
			reader = new FileReader("resources/config.properties");
			propThread.get().load(reader);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

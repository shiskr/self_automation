package utilities;

import java.util.Properties;

import utilities.ConfigManager;

public class ReadConfig {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ThreadLocal<Properties> prop = new ThreadLocal<Properties>();
//		ConfigManager manager = new ConfigManager();
//		manager.setProperty();
		
//		System.out.println(manager.getProperty1("browser"));
		ConfigManager.setProperties();
		System.out.println(ConfigManager.getProperties().getProperty("browser"));
//		System.out.println(System.getProperty("user.dir"));

	}

}

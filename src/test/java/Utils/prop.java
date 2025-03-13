package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class prop {

	private Properties properties;

	public prop() {
		// Initialize properties object
		properties = new Properties();

		// Load the properties file from the user's current directory
		try (FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\Env.properties")) {
			properties.load(fs); // Load the properties file into the Properties object
		} catch (FileNotFoundException e) {
			System.out.println("Property file not found at the specified path.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error loading the property file.");
			e.printStackTrace();
		}
	}

	// Method to get the browser name from properties
	public String getBrowser() {
		return properties.getProperty("browserName");
	}

	// Method to get the platform from properties
	public String getPlatform() {
		return properties.getProperty("platform");
	}

	public String Urll(){
		
		return properties.getProperty("url");
	}
}

package tool;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private  final String file = "delay.properties";
	public  Properties properties = new Properties();

	public void createInstance() {
		try {
			InputStream inputStream = new FileInputStream(file);
			properties.load(inputStream);
			inputStream.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public long getSleeptime() {
		return Integer.parseInt(properties.getProperty("demo"));
	}
}

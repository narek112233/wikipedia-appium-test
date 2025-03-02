package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties loadConfig() {
        Properties properties = new Properties();
        String configFile = System.getProperty("config", "configs/appium-config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(configFile);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("properties " + properties);
        return properties;
    }
}
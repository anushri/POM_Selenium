package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    static Properties properties;

    public PropertyReader() {

        loadAllProperties();
    }

    public void loadAllProperties() {
        properties = new Properties();
        try {
            String property_filepath = System.getProperty("user.dir") + "/src/main/resources/dev_config.properties";
            properties.load(new FileInputStream(property_filepath));
        } catch (IOException e) {
            throw new RuntimeException("Could not read the properties file");
        }
    }

    public static String readItem(String propertyName) {
        return properties.getProperty(propertyName);
    }


}

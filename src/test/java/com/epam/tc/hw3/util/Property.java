package com.epam.tc.hw3.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public String readProperty(String key) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testdata/user.property");
            Properties properties = new Properties();
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

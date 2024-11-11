package com.saucedemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties loadProperties(String filePath){

        File file= new File(filePath);

        try {
            Properties properties=new Properties();
            FileInputStream fis =new FileInputStream(file);
            properties.load(fis);
            return properties;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is not found");
        } catch (IOException e) {
            throw new RuntimeException("Error while loading the file");
        }

    }
}

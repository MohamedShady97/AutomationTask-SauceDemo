package com.saucedemo.utils;

import java.util.Properties;

public class ConfigUtils {
    private static ConfigUtils configUtils;
    private  Properties properties;

    public  ConfigUtils(){
        properties= PropertiesUtils.loadProperties("src/test/java/com/saucedemo/config/Config.Properties");
    }

    public static ConfigUtils getInstance(){

        if (configUtils==null)
            configUtils = new ConfigUtils();
        return configUtils;
    }
    public  String getbaseUrl(){

        String url= properties.getProperty("app.url");
        if (url!=null)
            return url;
        throw new RuntimeException("could not find the base url");

    }
    public String getUserName(){
        String email=properties.getProperty("login.username");
        if (email!=null)
            return email;
        throw new RuntimeException("could not find the userName in the properties file");

    }

    public String getPassword(){
        String password=properties.getProperty("login.password");
        if (password!=null)
            return password;
        throw new RuntimeException("could not find the password in the properties file");
    }

    public String getFirstName(){
        return properties.getProperty("checkout.firstname");
    }

    public String getLastName(){
        return properties.getProperty("checkout.lastname");
    }

    public String getPostalCode(){
        return properties.getProperty("postalcode");
    }
}

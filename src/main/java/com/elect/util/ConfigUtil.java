package com.elect.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    public static final String DAO_PROP="dao.properties";
    static Properties prop=new Properties();
    public ConfigUtil(String properties){
        try {
            prop.load(ConfigUtil.class.getClassLoader().getResourceAsStream(properties));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValues(String key){
        return prop.getProperty(key);
    }
}

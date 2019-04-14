package com.elect.factory;

import com.elect.util.ConfigUtil;

public class DaoFactory {

    public static Object getDaoImpl(String value){
        ConfigUtil configUtil=new ConfigUtil(ConfigUtil.DAO_PROP);
        Object object=null;
        try {
            object=Class.forName(configUtil.getValues(value)).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }
}

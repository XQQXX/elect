package com.elect.test;

import com.elect.util.ConfigUtil;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

public class ConfigTest {

    @Test
    public void config(){
        ConfigUtil configUtil=new ConfigUtil(ConfigUtil.DAO_PROP);
        System.out.println(configUtil.getValues("BookDao"));
    }

    @Test
    public void test(){

        System.out.println( System.currentTimeMillis());
    }
}

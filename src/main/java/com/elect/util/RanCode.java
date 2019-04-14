package com.elect.util;

import java.util.UUID;

/**
 * 生成注册激活码
 */
public class RanCode {

    public static String ranUUID(){
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(RanCode.ranUUID());
    }
}

package com.elect.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	public static String CALSSNAME=null;
	public static String URL=null;
	public static String USERNAME=null;
	public static String PASSWORD=null;
	public static int MAXIDLE=0;
	public static int MINIDLE=0;
	public static int INITIASIZE=0;
	static Properties pro=new Properties();
	static BasicDataSource bds=new BasicDataSource();
	static{
		try {
			pro.load(DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			CALSSNAME=pro.getProperty("ClassName");
			URL=pro.getProperty("url");
			USERNAME=pro.getProperty("username");
			PASSWORD=pro.getProperty("password");
			MAXIDLE=Integer.parseInt(pro.getProperty("maxIdle"));
			MINIDLE=Integer.parseInt(pro.getProperty("minIdle"));
			INITIASIZE=Integer.parseInt(pro.getProperty("initialSize"));
			Class.forName(CALSSNAME);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static Connection getConnection(){
		bds.setUsername(USERNAME);
		bds.setPassword(PASSWORD);
		bds.setUrl(URL);
		bds.setDriverClassName(CALSSNAME);
		bds.setInitialSize(INITIASIZE);
		bds.setMaxIdle(MAXIDLE);
		bds.setMinIdle(MINIDLE);
		Connection conn=null;
		try {
			conn=bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

    public static void main(String[] args) {
        System.out.println(DBUtil.getConnection());
    }
}

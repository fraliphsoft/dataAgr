package com.edu.nju.data.datamatch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC_Driver {

    static Properties properties = null;

    // 只加载一次
    static {
        properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String driver = properties.getProperty("driver");
    private static String url = properties.getProperty("dbURL");
    private static String user = properties.getProperty("user");
    private static String password = properties.getProperty("password");

    public static Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

package com.test.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/16/2017
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
public class JdbcConnection {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        /*String url = "jdbc:mysql://localhost:3306/classicmodels";
        String username = "root";
        String password = "root";*/
//            Class.forName("com.mysql.jdbc.Driver");
        try (FileInputStream fileInputStream = new FileInputStream("/WEB-INF/db.properties")){

//            FileInputStream fileInputStream = new FileInputStream("F:\\IdeaProjects\\hello_web\\hello_web\\web\\WEB-INF\\db.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url,user,password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //test
    public static void main(String args[]){
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
}

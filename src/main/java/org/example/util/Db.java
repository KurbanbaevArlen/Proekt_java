package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "arlen2002";


    public static Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the PostgresSQL successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }



//    public static Connection connectshort() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/postgres",
//                    "postgres",
//                    "arlen2002"
//            );
//            System.out.println("Connected to the PostgresSQL successfully");
//        } catch (SQLException throwables) {
//            System.out.println(throwables.getMessage());
//        }
//        return connection;
//
//
//    }
}
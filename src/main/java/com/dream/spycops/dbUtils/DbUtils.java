package com.dream.spycops.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

    private static final String connectionURL = "jdbc:sqlite:spycopsdb.db";
    private static Connection connection;
    private static Statement statement;

    private final static String copSchema = "";

    public static void connect() {
        try {
            connection = DriverManager.getConnection(connectionURL);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

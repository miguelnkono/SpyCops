package com.dream.spycops.dbUtils;

import com.dream.spycops.models.Cop;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.dream.spycops.Utils.ShowAlert.showAlert;

public class DbUtils {

    private static final String connectionURL = "jdbc:sqlite:spycopsdb.db";
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static AtomicInteger id = new AtomicInteger(0);

    private final static String copSchema = "create table if not exists cops" +
            "(" +
            "id integer primary key autoincrement," +
            "firstName text not null," +
            "lastName text not null," +
            "email text not null," +
            "password text not null" +
            ");";

    public static void connect() {
        try {
            connection = DriverManager.getConnection(connectionURL);
            statement = connection.createStatement();

            System.out.println("connected to the database!!!");
            statement.executeUpdate(copSchema);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registerCops(String firstName, String lastName,
                                    String password, String email) {
        String insertion = "insert into cops(id, firstName, lastName, " +
                "email, password) values ( ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(insertion);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }

    public static void registerCops(Cop cop) {
        String insertion = "insert into cops(firstName, lastName, " +
                "email, password) values (?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(insertion);
            preparedStatement.setString(1, cop.firstName());
            preparedStatement.setString(2, cop.lastName());
            preparedStatement.setString(3, cop.email());
            preparedStatement.setString(4, cop.password());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }

    public static boolean loginCop(String email, String password) {
        String selection = "select email, password from cops where email = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(selection);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String email1 = resultSet.getString("email");
                String password1 = resultSet.getString("password");
                if (email1.equals(email) && password1.equals(password)) {
                    return true;
                }
            }

            // If login fails, show an error pop-up
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid email or password. Please try again.");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }

    public static void close() {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

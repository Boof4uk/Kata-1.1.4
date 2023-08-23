package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/firstdbforidea";
    private static final String LOGIN = "root";
    private static final String PASS = "1234";
    // реализуйте настройку соеденения с БД
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASS);
//            System.out.println("Connection ok");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection is not available");
            return null;
        }
    }
}

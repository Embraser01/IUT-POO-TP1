package db;

import java.sql.*;

public class DatabaseConnector {

    private static Connection c = null;

    public static Connection openDb(String dataName) {

        if (c == null) {

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:" + dataName);
                System.out.println("Opened database successfully");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        return c;
    }

    public static Connection getDb() {
        return c;
    }

    public static void close() {
        if(c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
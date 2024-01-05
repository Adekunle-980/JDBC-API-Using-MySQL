// JDBCConnector.java
package ca.myjava.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnector {
    public static Connection getConnection() throws Exception {
        // Replace the placeholders with your actual Oracle database information
        String url = "jdbc:oracle:thin:@calvin.humber.ca:1521:grok";
        String username = "N01600998";
        String password = "oracle";

        // Load the JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Establish the connection
        return DriverManager.getConnection(url, username, password);
    }
}

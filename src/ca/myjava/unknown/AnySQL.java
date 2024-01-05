// AnySQL.java
package ca.myjava.unknown;

import java.sql.Connection;
/*import java.sql.DriverManager;
*/import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import ca.myjava.conn.JDBCConnector;

public class AnySQL {
    public static void main(String[] args) {
        try {
            // Get a connection
            Connection connection = JDBCConnector.getConnection();

            // Create a statement
            Statement statement = connection.createStatement();

            // Accept user input for SQL command
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter SQL command:");
            String sql = scanner.nextLine();

            // Execute the user's SQL command
            boolean isResultSet = statement.execute(sql);

            // Display results if it's a query
            if (isResultSet) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    System.out.println("Result: " + resultSet.getString(1));
                }
                resultSet.close();
            } else {
                System.out.println("Command executed successfully.");
            }

            // Close resources
            statement.close();
            connection.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// DeleteCountry.java
package ca.myjava.update;

import java.sql.Connection;
/*import java.sql.DriverManager;
*/import java.sql.Statement;

import ca.myjava.conn.JDBCConnector;

public class DeleteCountry {
    public static void main(String[] args) {
        try {
            // Get a connection
            Connection connection = JDBCConnector.getConnection();

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the delete statement
            int rowsAffected = statement.executeUpdate("DELETE FROM Country WHERE CountryName = 'Egypt'");

            // Display the result
            System.out.println(rowsAffected + " row(s) deleted.");

            // Close resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

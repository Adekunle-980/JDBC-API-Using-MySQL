// UpdateCountry.java
package ca.myjava.update;

import java.sql.Connection;
/*import java.sql.DriverManager;
*/import java.sql.Statement;

import ca.myjava.conn.JDBCConnector;

public class UpdateCountry {
    public static void main(String[] args) {
        try {
            // Get a connection
            Connection connection = JDBCConnector.getConnection();

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the update statement
            int rowsAffected = statement.executeUpdate("UPDATE Country SET LifeExpectancy = 87.9 WHERE CountryName = 'United States'");

            // Display the result
            System.out.println(rowsAffected + " row(s) updated.");

            // Close resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package ca.myjava.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ca.myjava.conn.JDBCConnector;

public class InsertCountry {
    public static void main(String[] args) {
        try {
            // Get a connection
            Connection connection = JDBCConnector.getConnection();

            // Define the SQL statement with placeholders
            String sql = "INSERT INTO Country (CountryID, CountryName, LifeExpectancy) VALUES (?, ?, ?)";

            // Use a PreparedStatement to handle parameters
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set values for the parameters
            	preparedStatement.setInt(1, 19 ); 
            	preparedStatement.setString(2, "Nigeria");
            	preparedStatement.setDouble(3, 50);


                // Execute the insert statement
                int rowsAffected = preparedStatement.executeUpdate();

                // Display the result
                System.out.println(rowsAffected + " row(s) inserted.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the connection
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

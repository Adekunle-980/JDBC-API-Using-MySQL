// QueryUsingPreparedStatement.java
package ca.myjava.query;

import java.sql.Connection;
/*import java.sql.DriverManager;
*/import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ca.myjava.conn.JDBCConnector;

public class QueryUsingPreparedStatement {
    public static void main(String[] args) {
        try {
            // Get a connection
            Connection connection = JDBCConnector.getConnection();

            // Create a prepared statement
            String sql = "SELECT * FROM Country WHERE LifeExpectancy BETWEEN ? AND ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, 70.0);
            preparedStatement.setDouble(2, 80.0);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Country: " + resultSet.getString("CountryName") +
                                   ", Life Expectancy: " + resultSet.getDouble("LifeExpectancy"));
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

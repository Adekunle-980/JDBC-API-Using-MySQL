// QueryUsingStatement.java
package ca.myjava.query;

import java.sql.Connection;
/*import java.sql.DriverManager;
*/import java.sql.ResultSet;
import java.sql.Statement;

import ca.myjava.conn.JDBCConnector;

public class QueryUsingStatement {
    public static void main(String[] args) {
        try {
            // Get a connection
            Connection connection = JDBCConnector.getConnection();

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Country WHERE LifeExpectancy BETWEEN 70 AND 80");

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Country: " + resultSet.getString("CountryName") +
                                   ", Life Expectancy: " + resultSet.getDouble("LifeExpectancy"));
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

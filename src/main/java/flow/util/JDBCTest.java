package flow.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

    public static void main(String[] argv) throws Exception {


        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");


        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        Statement stmt = connection.createStatement();

        String sql = "INSERT INTO Request " +
                "VALUES (100, 'Hello from JDBC world')";
        stmt.executeUpdate(sql);

        stmt.close();
        connection.close();
    }
}
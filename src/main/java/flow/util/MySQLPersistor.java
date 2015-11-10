package flow.util;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
import query.Response;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLPersistor implements Persistor {

    private MySQLPersistor()
    {

    }
    Connection connection= null;


    @Override
    public void init() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //TODO - connection pool

    @Override
    public synchronized void persist(long id, String request) {

        try {
            Statement stmt = connection.createStatement();
            String s = "Hello World from facade";
            int i= 500;

           String sql = "INSERT INTO Request VALUES (" + (int)id + ",'" +  request + "')";
           //   String sql = "INSERT INTO Request VALUES (" + id +  ")";
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void persist(Response response) {

    }

    @Override
    public void destroy() {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    static class Holder
    {
        static MySQLPersistor factory = new MySQLPersistor();
    }

    public static MySQLPersistor getInstance()
    {
        return Holder.factory;

    }



}

package main;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private static Properties connectionProperties = null;
    private static String url = "jdbc:mysql://eu-cdbr-west-02.cleardb.net";
    private static Connection conn = null;
    

    private DatabaseConnection(Connection conn){
        DatabaseConnection.conn = conn;
    }

    public static DatabaseConnection getConnection() throws URISyntaxException, SQLException {
        if (connectionProperties == null){
            initProperties();
        }    
        
        if (instance == null){
                return new DatabaseConnection(DriverManager.getConnection(url, connectionProperties));
            } else return instance;
            
        }

    private static void initProperties(){
        try {
            connectionProperties = new Properties();
            connectionProperties.put("user", "b6604973ab52f0");
            connectionProperties.put("password", "7708ceee");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private PreparedStatement prepareStatement(String sql) throws SQLException{
        return DatabaseConnection.conn.prepareStatement(sql);
    }

    private Statement createStatement() throws SQLException{
        return DatabaseConnection.conn.createStatement();
    }

    private static int execUpdate(String sql){
        int res = 0;
        try {
            Statement statement = instance.createStatement();    
            res = statement.executeUpdate(sql);
        } catch (SQLException e){
            System.out.println("SQL Execution error");
        }
        return res;
    }
    


    public static ResultSet read(String sql) throws SQLException{
        PreparedStatement statement = instance.prepareStatement(sql);
        return statement.executeQuery();
    }

    public static int insert(String sql){
        return execUpdate(sql);
    } 

    public static int update(String sql){
        return execUpdate(sql);
    }

    public static int delete(String sql){
        return execUpdate(sql);
    }

    

    
    
}

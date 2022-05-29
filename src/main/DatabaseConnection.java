package main;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = DriverManager.getConnection("jdbc:mysql://b6604973ab52f0:7708ceee@eu-cdbr-west-02.cleardb.net/heroku_08b2595a841e93c?reconnect=true");
            instance = new DatabaseConnection(conn);
                
        }
        return instance;
        
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
            conn = DriverManager.getConnection("jdbc:mysql://b6604973ab52f0:7708ceee@eu-cdbr-west-02.cleardb.net/heroku_08b2595a841e93c?reconnect=true");
            Statement statement = conn.createStatement();    
            res = statement.executeUpdate(sql);
        } catch (SQLException e){
            System.out.println("SQL Execution error");
        }
        return res;
    }
    


    public static ResultSet read(String sql){
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://b6604973ab52f0:7708ceee@eu-cdbr-west-02.cleardb.net/heroku_08b2595a841e93c?reconnect=true");
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
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

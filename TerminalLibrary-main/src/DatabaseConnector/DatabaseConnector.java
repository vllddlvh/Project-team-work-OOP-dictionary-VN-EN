package DatabaseConnector;


import java.sql.DriverManager;
import java.sql.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;


public class DatabaseConnector {
    
    protected static Connection connection;
    
    protected static Connection getJDBCConnection() throws SQLException {
        final String url = "jdbc:mysql://127.0.0.1:3306/library_demo_contents";
        final String username = "root";
        final String password = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * There are some task we must do. 
     * Make a JDBCconnection to the database as example.
     * 
     * @throws SQLException 
     */
    public static void firstTODO() throws SQLException{
        connection = DatabaseConnector.getJDBCConnection();
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

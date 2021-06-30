package vcon_final;


import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class DBconnection {
    
    private static String Servername = "localhost";
    private static String Username = "root";
    private static String DBname = "user_db";
    private static Integer Portnumber = 3306;
    private static String Password = "";
    
    public static Connection getConnection()
    {
        Connection Connect = null;
        
        MysqlDataSource DataSource = new MysqlDataSource();
        
        DataSource.setServerName(Servername);
        DataSource.setUser(Username);
        DataSource.setPassword(Password);
        DataSource.setDatabaseName(DBname);
        DataSource.setPortNumber(Portnumber);
        
        try {
            Connect = DataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("get connection -> " + DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Connect;
    }
}

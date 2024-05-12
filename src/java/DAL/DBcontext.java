/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.*;
/**
 *
 * @author Acer
 */
public class DBcontext {
    protected Connection connect;
    
    public DBcontext(){
        try{
            String url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url,userID,password);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private final String serverName = "localhost";
    private final String dbName = "Human";
    private final String portNumber = " 1433";
    private final String userID = "sa";
    private final String password = "buidat0306";
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author A S U S
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class connection {
      private static Connection connection;
       public static Connection getConnection(){
       Connection conn = null;
       String url = "jdbc:mysql://localhost:3306/mahasiswa";
       String username = "root";
       String password = "";
       
       try{
           conn = DriverManager.getConnection(url, username, password);
           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           connection = (Connection) DriverManager.getConnection(url,username,password);
           System.out.println("Connection Succes!");
       }catch(SQLException e){
           Logger.getLogger(connection.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Connection Failed: " + e.getMessage());
       }
       return connection;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Shidqi
 */
public class Koneksi_db {
    // membuat variabel conn
    public static com.mysql.jdbc.Connection conn;
  
    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // String url untuk memanggil database nya
            String url= "jdbc:mysql://localhost:3306/java_db_mhs";

            conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(url,"root","" );
        }
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Class Tidak Ada");
        }
        catch (java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"tidak bisa koneksi");
        }
        return conn;
    }
}
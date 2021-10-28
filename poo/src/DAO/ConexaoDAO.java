package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class ConexaoDAO {
    
    public Connection conexao(){
        Connection con = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/locacao?user=root&password=root";
            con = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return con;
    }
                   
}

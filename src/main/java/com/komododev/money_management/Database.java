/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.komododev.money_management;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tengk
 */


public class Database {
    private static final String DATABASE = "money_management";
    private static final String Table = "balance";
    private static final String USER = "username";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;

    private static Connection conn =  null;
    private static PreparedStatement pst = null;
    
    public static Connection Connect(){
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error has occurred.", "Connection failed: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(())
        }
        return conn;
    }
    
    public static void Insert(Connection conn, String balance, String information){
        try {
            pst = conn.prepareStatement("INSERT INTO " + Table + " (balance, deposit, withdraw, information) VALUES (?, ?, ?, ?)");
            
            pst.setString(1, URL);
            pst.setString(2, URL);
            pst.setString(1, URL);
            pst.setString(1, URL);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error has occurred.", "Connection failed: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
}

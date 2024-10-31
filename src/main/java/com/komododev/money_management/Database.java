/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.komododev.money_management;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author https://github.com/trbp-lost
 */
public class Database {
    private static final String DATABASE = "money_management";
    private static final String Table = "balance";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    
    private static Connection conn =  null;
    private static PreparedStatement pst = null;
    
    public static Connection Connect(){
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage(), "An error has occurred.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return conn;
    }
    
    public static void ShowTable (Connection conn, DefaultTableModel dft){
        int no = 1;
        
        try {
            pst = conn.prepareStatement("SELECT * FROM " + Table );
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnCount = rsmd.getColumnCount();
            dft.setRowCount(0);
            
            while (rs.next()) {
                Vector<Object> v2 = new Vector<>();

                for (int i = 1; i <= columnCount; i++) {
                    v2.add(no);
                    v2.add(rs.getDate("Date"));
                    v2.add(rs.getDouble("Deposit"));
                    v2.add(rs.getDouble("Withdraw"));
                    v2.add(rs.getDouble("Balance"));
                    v2.add(rs.getString("Information"));
                }
                no++;
                dft.addRow(v2);
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed Show Table Balance: " + e.getMessage(), "An error has occurred.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static boolean Insert(Connection conn, String balance, String information, String typeBalance){
        double lastBalance = CheckLastBalance(conn);
        double deposit = 0 , withdraw = 0;
        
        if (typeBalance == "Deposit") {
            deposit = Double.parseDouble(balance);
            lastBalance += deposit;
            
        }
        else {
            withdraw = Double.parseDouble(balance);
            lastBalance -= withdraw;
        }
             
        try {
            pst = conn.prepareStatement("INSERT INTO " + Table + " (balance, deposit, withdraw, information) VALUES (?, ?, ?, ?)");
            
            pst.setDouble(1, lastBalance);
            pst.setDouble(2, deposit);
            pst.setDouble(3, withdraw);
            pst.setString(4, information);
            
            pst.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Failed Add Data: " + e.getMessage(), "An error has occurred.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public static double CheckLastBalance(Connection conn){
        try {
            pst = conn.prepareStatement("SELECT balance FROM " + Table + " ORDER BY id_balance DESC LIMIT 1 ");
            ResultSet rs = pst.executeQuery();
            
            if (rs != null && rs.next()) {
                double lastBalance = rs.getDouble("balance");
                System.out.println("Balance terakhir: " + lastBalance);
                return lastBalance;
            } else {
                System.out.println("Tidak ada data balance.");
                return 0;
            }
            
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Check Last Balance failed: " + e.getMessage(), "An error has occurred.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    
}

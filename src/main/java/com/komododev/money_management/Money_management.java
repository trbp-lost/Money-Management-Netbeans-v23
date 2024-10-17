/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.komododev.money_management;
import javax.swing.JFrame;

/**
 *
 * @author  trbp-lost
 */
public class Money_management {

    public static Login loginFrame;
    
    public static void main(String[] args) {
        loginFrame = new Login();
//        Login loginFrame = new Login();

        loginFrame.setVisible(true);

        System.out.println("Hello World!");
    }
}


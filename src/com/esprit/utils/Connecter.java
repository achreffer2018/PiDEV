/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.utils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khalil
 */
public class Connecter {
    
   Connection connexion;
    final String url = "jdbc:mysql://localhost:3306/pidev";
    final String user = "root";
    final String password = "";
    private static Connecter instance;

    private Connecter() {
        try {
            connexion =  DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connecter getInstance() {
        if (instance == null) {
            instance = new Connecter();
        }

        return instance;
    }

    public Connection getConnection() {
        return connexion;
    }
    
}

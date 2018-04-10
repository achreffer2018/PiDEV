/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.entities.AppelOffre;
import com.esprit.entities.demandeoffre;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PACKARDBELL
 */
public class demandeService {

    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

    public void participerOffre(demandeoffre e) {
        try {

            String req = "INSERT INTO demandeoffre (user_id,appel_id,statut) VALUES (?,?,?)";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, e.getUser_id().getId());
            st.setInt(2, e.getAppel_id().getId());
            st.setInt(3, e.getStatut());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

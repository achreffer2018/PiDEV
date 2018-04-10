package com.esprit.services;

import com.esprit.entities.User;
import com.esprit.Iservice.IUserService;
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
 * @author Ahmed
 */
public class UserService implements IUserService {
   
    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;
    
    @Override
    public void createUser(User user) {
                try {
            String req = "INSERT INTO User (username,email,password,roles,numero) VALUES (?,?,?,?,?)";
            
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1,user.getUsername());
            st.setString(2,user.getEmail());
            st.setString(3,user.getPassword());
            st.setString(4,user.getRoles());
            st.setString(5,user.getNumero());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> getAll() {
                ArrayList<User> listUser = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from User");
            while (rs.next()) {
                
                System.out.println(rs.getString(1) + " (" + rs.getString(2) + ")"
                + " (" + rs.getString(3) + ")"+ " (" + rs.getString(4) + ")" + "(" + rs.getString(5) + ")");
                listUser.add(
            new User
                       (rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                               
                        
                               
                       ));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;  
    }
    
        @Override
    public List<User> getAllName() {
                ArrayList<User> listUser = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select username from User");
            while (rs.next()) {
                
                System.out.println(rs.getString(1));
                listUser.add(
            new User(rs.getString(1)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;  
    }
}
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
    public static int userconnected;

    @Override
    public void createUser(User user) {
        try {
            String req = "INSERT INTO User (username,email,password,roles) VALUES (?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, user.getUsername());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            st.setString(4, user.getRoles());
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
                        + " (" + rs.getString(3) + ")" + " (" + rs.getString(4) + ")");
                listUser.add(
                        new User(rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4)
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

    public User AfficherUser(String username) {

        User u = new User();
        try {
            Connection conn = DataSource.getInstance().getConnection();
            Statement stmt = null;

            ResultSet rs = stmt.executeQuery("Select * from user where user.`username`='" + username + "'");

            while (rs.next()) {
                System.out.println("id " + rs.getString(1) + "contenu  " + rs.getString(4));
                u.setId(rs.getInt(5));
                u.setUsername(rs.getString(1));
                u.setEmail(rs.getString(2));
                u.setPassword(rs.getString(3));

            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }

    public User AfficherUserId(int id) {

        User u = new User();
        try {
            Connection conn = DataSource.getInstance().getConnection();
            Statement stmt = null;
            ResultSet rs = stmt.executeQuery("Select * from user where user.`id`='" + id + "'");
            while (rs.next()) {
                System.out.println("id " + rs.getString(1) + "contenu  " + rs.getString(4));
                u.setId(rs.getInt(5));
                u.setUsername(rs.getString(1));
                u.setEmail(rs.getString(2));
                u.setPassword(rs.getString(3));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    //@Override
    public Boolean Login(String username, String password) {

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from User WHERE User.`username` = '" + username + "'and  User.`password` like '" + password + "%'");

            if (rs.next()) {
                System.out.println("login success");
                userconnected = rs.getInt("id");
                return true;
            }

            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}

package com.esprit.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import com.esprit.entities.User;
import com.esprit.services.UserService;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLRegister implements Initializable {

    @FXML
    ToggleGroup group = new ToggleGroup();
    @FXML
    RadioButton r1 = new RadioButton("visiterur");

    @FXML
    RadioButton r2 = new RadioButton("client pro");

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    
    String roles;
    @FXML
    private TextField num;

    @FXML
    private void AjoutUser(ActionEvent event) {
        r1.setToggleGroup(group);
        r1.setSelected(true);
        r2.setToggleGroup(group);

        if (r1.isSelected()) {
            roles = "Visiteur";
        } else if (r2.isSelected()) {
            roles = "client pro";
        }

        UserService es = new UserService();
        User e = new User();

        e.setUsername(username.getText());
        e.setEmail(email.getText());
        e.setPassword(password.getText());
        e.setRoles(roles.toString());
        e.setNumero(num.getText());

        if (username.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vérifier votre Formulaire");
        } else {
            es.createUser(e);
            username.clear();
            email.clear();
            password.clear();
            num.clear();
            System.out.println("Done");
            JOptionPane.showMessageDialog(null, "Votre inscription est terminé avec succée");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
package com.esprit.controller;
import com.esprit.entities.User;
import com.esprit.services.UserService;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
public class FXMLDocumentController implements Initializable {
    
    private Connection connection;
    
    @FXML
    private AnchorPane rootanchor;
    @FXML
    private TextField login;
    @FXML
    private TextField pass;
    
    @FXML
    private void LoginAction(javafx.event.ActionEvent event) throws IOException {
            UserService service =new UserService();

        if (pass.getText().equals("client") && (login.getText().equals("client"))) 
        {
            JOptionPane.showMessageDialog(null, " Bienvenu cher Client ");
        
            
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        } else 
        if (service.Login(login.getText(), pass.getText()))
      // if (pass.getText().equals("client") && (login.getText().equals("client"))) 
        {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null, " Votre Login incorrect ");
        }
        pass.clear();
        login.clear();
    }
    // Navigation entre deux pages
    @FXML
    private void hundleRegister(javafx.event.ActionEvent event) {
        makeFadeOut();}
    private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootanchor);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandlerImpl());
        fadeTransition.play();
    }
    private void loadNextScren() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) rootanchor.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {}
    }
    private class EventHandlerImpl implements EventHandler<javafx.event.ActionEvent> {
        public EventHandlerImpl() {
        }
        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScren();}}

        @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
    
}
/*
    @FXML
    private void toregister(javafx.event.ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
   }
    */ 
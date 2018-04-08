package com.esprit.controller;

import com.esprit.entities.AppelOffre;
import com.esprit.services.AppelOffreService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppelOffreController implements Initializable {

    @FXML
    private TextField sujet;
    @FXML
    private TextField description;
    @FXML
    private DatePicker date;
    @FXML
    private Button bt;
    ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void ajoutAppeloffre(ActionEvent event) {
        AppelOffreService es = new AppelOffreService();
        AppelOffre e = new AppelOffre(sujet.getText(),date.getValue().toString(),description.getText());
        es.createAo(e);
        
        
        sujet.clear();
        description.clear();
        System.out.println("Ajout effectué");
        items.clear();

        //l.getSelectionModel().select(items.size() - 1);
        // l.scrollTo(items.size() - 1);
    }

}

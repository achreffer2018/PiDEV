package com.esprit.controller;

import com.esprit.entities.AppelOffre;
import com.esprit.services.AppelOffreService;
import static java.lang.System.load;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class ToutlesAppelController implements Initializable {
    ObservableList<String> items = FXCollections.observableArrayList();
    
    @FXML
    private TableView<AppelOffre> table;
    @FXML
    private TableColumn<AppelOffre,String> pet;
    @FXML
    private TableColumn<AppelOffre,String> su;
    @FXML
    private TableColumn<AppelOffre,String>des;
    @FXML
    private TableColumn<AppelOffre,String> eta;
    @FXML
    private TableColumn<AppelOffre,String> da;
       AppelOffreService es = new AppelOffreService();
    ObservableList<AppelOffre> list = FXCollections.observableArrayList(es.getAll2());
    @FXML
    private Button participer;
    @FXML
    private void participer(ActionEvent event) {
        load("MesParticipation");
           
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AppelOffreService es = new AppelOffreService();
        //tableview
               
        su.setCellValueFactory(new PropertyValueFactory("sujet"));      
        des.setCellValueFactory(new PropertyValueFactory("description"));
        da.setCellValueFactory(new PropertyValueFactory("datemax"));
        eta.setCellValueFactory(new PropertyValueFactory("statut"));
       
        table.setItems(list);
    }    

    private void load(String ui)
    {
        Parent root =null ;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (Exception e) {
        }
    
    }
  
    
}

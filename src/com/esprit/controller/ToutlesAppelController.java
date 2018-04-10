package com.esprit.controller;

import com.esprit.entities.AppelOffre;
import com.esprit.entities.User;
import com.esprit.entities.demandeoffre;
import com.esprit.services.AppelOffreService;
import com.esprit.services.demandeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AppelOffre a= new AppelOffre();
        AppelOffreService es = new AppelOffreService();        
        su.setCellValueFactory(new PropertyValueFactory("sujet"));      
        des.setCellValueFactory(new PropertyValueFactory("description"));
        da.setCellValueFactory(new PropertyValueFactory("datemax"));
        if (a.statut==0){ 
        eta.setCellValueFactory(new PropertyValueFactory("En attente"));
        }else 
            eta.setCellValueFactory(new PropertyValueFactory("Confirmé"));
       
        table.setItems(list);
    }    

   AppelOffre a;
   User u;
   
   @FXML
   private void participer(ActionEvent event) {
        
        demandeService ds = new demandeService();
        demandeoffre e = new demandeoffre();
        e.setStatut(0);
        e.setAppel_id(a);
        e.setUser_id(u);
        ds.participerOffre(e);
        System.out.println("Participation réussite");
        items.clear();
        
        
        
    }
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author PACKARDBELL
 */
public class StatController implements Initializable {

    @FXML
    private BarChart<?, ?> NombreA;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("Patisserie 1",2));
        set1.getData().add(new XYChart.Data("Patisserie 2",6));
        set1.getData().add(new XYChart.Data("Patisserie 3",1));
        set1.getData().add(new XYChart.Data("Patisserie 4",8));
        set1.getData().add(new XYChart.Data("Patisserie 5",3));
        set1.getData().add(new XYChart.Data("Patisserie 6",0));
        NombreA.getData().addAll(set1);
        
        
    }    
    
}

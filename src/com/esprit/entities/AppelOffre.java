/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

/**
 *
 * @author PACKARDBELL
 */
public class AppelOffre {

    public int id;
    public String datemax;
    public String sujet;
    public String description;
    public  int statut;

    public AppelOffre(int id, String datemax, String sujet, String description, int statut) {
        this.id = id;
        this.datemax = datemax;
        this.sujet = sujet;
        this.description = description;
        this.statut = statut;
    }

    public AppelOffre(String datemax, String sujet, String description, int statut) {
        this.datemax = datemax;
        this.sujet = sujet;
        this.description = description;
        this.statut = statut;
    }
  
    public String getDatemax() {
        return datemax;
    }

    public void setDatemax(String datemax) {
        this.datemax = datemax;
    }


    public AppelOffre(int id, String datemax, String sujet, String description) {
        this.id = id;
        this.datemax = datemax;
        this.sujet = sujet;
        this.description = description;
       
    }

    public AppelOffre(String datemax, String sujet, String description) {
        this.datemax = datemax;
        this.sujet = sujet;
        this.description = description;
        
    }

 

 



    public AppelOffre() {
    }

    public void setDate(String datemax) {
        this.datemax = datemax;
    }

    public String getDate() {
        return datemax;
    }

    public int getId() {
        return id;
    }

    public String getSujet() {
        return sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AppelOffre{" + "id=" + id + ", sujet=" + sujet + ", description=" + description + '}';
    }

    public void update(AppelOffre appelOffre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

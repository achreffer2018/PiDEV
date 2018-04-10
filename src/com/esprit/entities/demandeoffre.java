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
public class demandeoffre {

    public int id;
    public User user_id;
    public AppelOffre appel_id;
    public int statut;

    public demandeoffre(int id, int statut) {
        this.id = id;
        this.statut = statut;
    }

   

    public demandeoffre() {
this.statut = statut;    }

    public demandeoffre(int id, User user_id, AppelOffre appel_id, int statut) {
        this.id = id;
        this.user_id = user_id;
        this.appel_id = appel_id;
        this.statut = statut;
    }

    public demandeoffre(String string, int aInt, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public void setAppel_id(AppelOffre appel_id) {
        this.appel_id = appel_id;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public User getUser_id() {
        return user_id;
    }

    public AppelOffre getAppel_id() {
        return appel_id;
    }

    public int getStatut() {
        return statut;
    }

}

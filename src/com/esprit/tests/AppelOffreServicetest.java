/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;


import com.esprit.entities.AppelOffre;
import com.esprit.services.AppelOffreService;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author PACKARDBELL
 */
public class AppelOffreServicetest {

      public static void main(String args[]) {
       
        AppelOffre a = new AppelOffre("Sujet", "Date","Description");
        AppelOffreService as = new AppelOffreService();
        as.createAo(new AppelOffre("Sujet", "Date","Description"));
        as.createAo(new AppelOffre("Sujet", "Date","Description"));
        as.createAo(new AppelOffre("Sujet", "Date","Description"));
         as.createAo(new AppelOffre("Sujet", "Date","Description"));
        
        
        
        System.out.println("Avant delete ****************************");
        as.getAll().forEach(System.out::println);
        as.delete(3);
        System.out.println("Avant update****************************");
        as.getAll().forEach(System.out::println);
        as.update(new AppelOffre(8, "updated sujet", "updated description","update datemax "));
        System.out.println("Apres delete****************************");
        as.getAll().forEach(System.out::println);
    }
    
}

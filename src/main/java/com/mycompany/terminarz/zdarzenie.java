/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.terminarz;

import java.util.Scanner;

/**
 *
 * @author Dominik
 */
public class zdarzenie {
    
    protected String godzinaPoczatek, godzinaKoniec;
    protected String tekstZdarzenia, tytulZdarzenia;
    
    public zdarzenie(){}
    
    public zdarzenie(String gP, String gK, String t, String z){
        godzinaPoczatek = gP;
        godzinaKoniec = gK;
        tekstZdarzenia = z;
        tytulZdarzenia = t;
    }
    
    public void wyswietl(){
        System.out.println(godzinaPoczatek +"-"+ godzinaKoniec + " " +tytulZdarzenia + ": "+tekstZdarzenia);
    }
    
    public String wyswietlString(){
        return godzinaPoczatek +"-"+ godzinaKoniec + " " +tytulZdarzenia + ": "+tekstZdarzenia;
    }
    
    public void wyswietlKrotko(){
        System.out.println(godzinaPoczatek +"-"+ godzinaKoniec + " " +tytulZdarzenia);
    }
    
    public String wyswietlStringKrotko(){
        return godzinaPoczatek +"-"+ godzinaKoniec + " " +tytulZdarzenia;
    }
}

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
    
    /**
     * Wyświetla obiekt klasy zdarzenie w postaci godzinaPoczątkowa-godzinaKońcowa tytuł: teskt
    */
    public void wyswietl(){
        System.out.println(godzinaPoczatek + "-" + godzinaKoniec + " " + tytulZdarzenia + ": " + tekstZdarzenia);
    }
    
    /**
     * Zwraca obiekt klasy zdarzenie jako string w postaci godzinaPoczątkowa-godzinaKońcowa tytuł: teskt
     * @return string
    */
    public String wyswietlString(){
        return godzinaPoczatek + "-" + godzinaKoniec + " " + tytulZdarzenia + ": " + tekstZdarzenia;
    }
    
    /**
    * Wyświetla obiekt klasy zdarzenie w któtszej postaci godzinaPoczątkowa-godzinaKońcowa tytuł
    */
    public void wyswietlKrotko(){
        System.out.println(godzinaPoczatek + "-" + godzinaKoniec + " " + tytulZdarzenia);
    }
    /**
     * Zwraca obiekt klasy zdarzenie jako string w któtszej postaci godzinaPoczątkowa-godzinaKońcowa tytuł
     * @return string
    */
    public String wyswietlStringKrotko(){
        return godzinaPoczatek + "-" + godzinaKoniec + " " +tytulZdarzenia;
    }
}

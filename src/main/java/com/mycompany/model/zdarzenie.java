/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

import java.util.Scanner;

/**
 *
 * @author Dominik Ślusarz, Radosław Zając, Roger Woźniak, Aleksandra Worhacz, Daniel Stanek 
 */
public class zdarzenie {
    
    protected String godzinaPoczatek, godzinaKoniec;
    protected String tekstZdarzenia, tytulZdarzenia, tekstZdarzeniaKrotki;
    protected String dzien;
    
    /**
     * Konstruktor niesparametryzowany
     */
    public zdarzenie(){}
    
    /**
     * Konstruktor kopiujący zdarzenie
     * @param z obiekt klasy zdarzenie
     */
    public zdarzenie(zdarzenie z){
        this.godzinaPoczatek = z.godzinaPoczatek;
        this.godzinaKoniec = z.godzinaKoniec;
        this.tekstZdarzenia = z.tekstZdarzenia;
        this.tytulZdarzenia = z.tytulZdarzenia;
        this.dzien = z.dzien;
        if(this.tekstZdarzenia.length() > 15) this.tekstZdarzeniaKrotki = this.tekstZdarzenia.substring(0, 10)+"...";
        else this.tekstZdarzeniaKrotki = this.tekstZdarzenia;
    }
    
    /**
     * Konstruktor
     * @param gP  godzina początwka
     * @param gK  godzina koncowa
     * @param t  tytuł
     * @param z  tekst
     * @param d  dzieć
     */
    public zdarzenie(String gP, String gK, String t, String z, String d){
        godzinaPoczatek = gP;
        godzinaKoniec = gK;
        tekstZdarzenia = z;
        tytulZdarzenia = t;
        dzien = d;
        if(z.length() > 15) tekstZdarzeniaKrotki = z.substring(0, 10)+"...";
        else tekstZdarzeniaKrotki = z;
    }
    
    /**
     * Wyświetla obiekt klasy zdarzenie w postaci godzinaPoczątkowa-godzinaKońcowa tytuł: teskt
    */
    public void wyswietl(){
        System.out.println(dzien + " " + godzinaPoczatek + "-" + godzinaKoniec + " " + tytulZdarzenia + ": " + tekstZdarzenia);
    }
    
    /**
     * Zwraca obiekt klasy zdarzenie jako string w postaci godzinaPoczątkowa-godzinaKońcowa tytuł: teskt
     * @return string
    */
    public String wyswietlString(){
        return dzien + " " + godzinaPoczatek + "-" + godzinaKoniec + " " + tytulZdarzenia + ": " + tekstZdarzenia;
    }
    
    /**
    * Wyświetla obiekt klasy zdarzenie w któtszej postaci godzinaPoczątkowa-godzinaKońcowa tytuł
    */
    public void wyswietlKrotko(){
        System.out.println(dzien+" "+godzinaPoczatek + "-" + godzinaKoniec + " " + tytulZdarzenia);
    }
    /**
     * Zwraca obiekt klasy zdarzenie jako string w któtszej postaci godzinaPoczątkowa-godzinaKońcowa tytuł
     * @return string
    */
    public String wyswietlStringKrotko(){
        return dzien + ": " + godzinaPoczatek + "-" + godzinaKoniec + " " +tytulZdarzenia + ": "+ tekstZdarzeniaKrotki;
    }
     
    public void setGodzinaPoczatek(String godzinaPoczatek) {
        this.godzinaPoczatek = godzinaPoczatek;
    }

    public void setGodzinaKoniec(String godzinaKoniec) {
        this.godzinaKoniec = godzinaKoniec;
    }

    public void setTekstZdarzenia(String tekstZdarzenia) {
        this.tekstZdarzenia = tekstZdarzenia;
    }

    public void setTytulZdarzenia(String tytulZdarzenia) {
        this.tytulZdarzenia = tytulZdarzenia;
    }

    public void setTekstZdarzeniaKrotki(String tekstZdarzeniaKrotki) {
        this.tekstZdarzeniaKrotki = tekstZdarzeniaKrotki;
    }

    public String getGodzinaPoczatek() {
        return godzinaPoczatek;
    }

    public String getGodzinaKoniec() {
        return godzinaKoniec;
    }

    public String getTekstZdarzenia() {
        return tekstZdarzenia;
    }

    public String getTytulZdarzenia() {
        return tytulZdarzenia;
    }

    public String getTekstZdarzeniaKrotki() {
        return tekstZdarzeniaKrotki;
    }
    
}
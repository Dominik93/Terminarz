/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

/**
 *
 * @author Dominik
 */

public class dekoratorZdarzenia extends zdarzenie{

    public dekoratorZdarzenia(zdarzenie z){
        super(z);
    }
    
    /**
     * Funkcja zwraca string do umieszczenia w elemencie jLabel
     * @return s
     */
    public String wyswietlLabel(){
        String s = "";
        s += "<html>";
        s += "Dzień: " + dzien + "<br>";
        s += "Godzina: " + godzinaPoczatek + "-" + godzinaKoniec + "<br>";
        s += "Tytuł: " + tytulZdarzenia + "<br>";
        String[] parts = tekstZdarzenia.split(" ");
        s += "Opis: ";
        for(int i = 0; i < parts.length; i++){
            s += parts[i] + " ";
            if((i+1 % 6) == 0) s += "<br>";
        }
        s += "</html>";
        return s;
    }

}


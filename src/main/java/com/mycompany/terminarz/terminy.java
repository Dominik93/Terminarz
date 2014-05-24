/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.terminarz;

import java.util.ArrayList;

/**
 *
 * @author Dominik
 */
public class terminy {
    
    private final String[] dni = { "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela" };
    protected ArrayList<listaZdarzen> lista = new ArrayList<listaZdarzen>();
    
    public terminy(){
        int j = 0;
        for(int i = 1; i < 53; i++){
           lista.add(new listaZdarzen(dni[j], i));
           j++;
           if (j == 7) j = 0;
        }
    }
    
    public void dodaj(String d, int t, zdarzenie z){
        for(int i = 0; i < 52; i++){
            if(lista.get(i).dzien.equals(d) && lista.get(i).tydzien == t){
                lista.get(i).dodaj(z);
            }
        }
    }
    
    public void wyswietl(String d, int t){
        for(int i = 0; i < 52; i++){
            if(lista.get(i).dzien.equals(d) && lista.get(i).tydzien == t){
                lista.get(i).wyswietl();
            }
        }
    
    }
}

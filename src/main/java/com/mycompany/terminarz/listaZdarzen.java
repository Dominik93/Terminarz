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
public class listaZdarzen{
    
    protected ArrayList<zdarzenie> lista = new ArrayList<zdarzenie>();
    protected String dzien, tydzien;
    
    public listaZdarzen(String d, String t){
        dzien = d;
        tydzien = t;
    }
    
    public void dodajZdarzenie(zdarzenie obiekt){
        lista.add(obiekt);
    }
    
    public void usunZdarzenie(int i){
        lista.remove(i);
    }
    
    public void usunZdarzenie(zdarzenie ob){
        lista.remove(ob);
    }
    
    public void usunWszystkieZdarzenia(){
        lista.removeAll(lista);
    }
    
}

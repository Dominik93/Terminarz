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
public class listaZdarzen implements interfaceZdarzen<zdarzenie>{
    
    protected ArrayList<zdarzenie> listaZdarzen = new ArrayList<zdarzenie>();
    protected String dzien;
    protected int tydzien;
    
    public listaZdarzen(String d, int t){
        dzien = d;
        tydzien = t;
    }
    
    @Override
    public void dodaj(zdarzenie obiekt){
        listaZdarzen.add(obiekt);
    }
    
    @Override
    public void usun(int i){
        listaZdarzen.remove(i);
    }
    
    @Override
    public void usun(zdarzenie ob){
        listaZdarzen.remove(ob);
    }
    
    @Override
    public void usunWszystko(){
        listaZdarzen.removeAll(listaZdarzen);
    }    
    
    // sortuje ArrayList po godzinie początkowej a potem koncowej... taa jakby nie można było odrazu dodawać w odpowiednie miejsce xD
    public void sortuj(){
        zdarzenie temp = new zdarzenie();
        for(int i = 0 ; i < listaZdarzen.size(); i++)
            for(int j = 0 ; j < listaZdarzen.size(); j++)
                if(listaZdarzen.get(i).godzinaPoczatek.compareTo(listaZdarzen.get(j).godzinaPoczatek) < 0){ // arg jest wiekszy
                    temp = listaZdarzen.get(i);
                    listaZdarzen.set(i,listaZdarzen.get(j));
                    listaZdarzen.set(j,temp);
                }else if(listaZdarzen.get(i).godzinaPoczatek.compareTo(listaZdarzen.get(j).godzinaPoczatek) == 0){ // arg jest mniejszy
                    if(listaZdarzen.get(i).godzinaKoniec.compareTo(listaZdarzen.get(j).godzinaKoniec) < 0){ // arg jest wiekszy
                    temp = listaZdarzen.get(i);
                    listaZdarzen.set(i,listaZdarzen.get(j));
                    listaZdarzen.set(j,temp);
                    }
                }
    }
    
    public void wyswietl(){
        for(zdarzenie ob : listaZdarzen){
            ob.wyswietl();
        }
    }
}

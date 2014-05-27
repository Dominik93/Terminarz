/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.terminarz;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

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
    public void dodaj(zdarzenie ob){
        listaZdarzen.add(ob);
        sortuj();
    }
    
    @Override
    public void usun(int i){
        listaZdarzen.remove(i);
        sortuj();
    }
    
    @Override
    public void usun(zdarzenie ob){
        listaZdarzen.remove(ob);
        sortuj();
    }
    
    @Override
    public void usunWszystko(){
        listaZdarzen.removeAll(listaZdarzen);
    }    
    
    /**
     * Sortuje liste zdarzeń po godzinie początkowej a potem koncowej... taa jakby nie można było odrazu dodawać w odpowiednie miejsce xD
     */
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
    
    /**
     * Wyświetla wszystkie zdarzzenia w danej liście zdarzeń
     */
    public void wyswietl(){
        for(zdarzenie ob : listaZdarzen){
            ob.wyswietl();
        }
    }
    
    public String[] test(int t){
        String [] stringList = new String[listaZdarzen.size()];
        int i = 0;
        for(zdarzenie ob : listaZdarzen){
            stringList[i] = ob.wyswietlStringKrotko(dzien);
            i++;
        }
        return stringList;
    }
    
    public void setListaZdarzen(ArrayList<zdarzenie> listaZdarzen) {
        this.listaZdarzen = listaZdarzen;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public void setTydzien(int tydzien) {
        this.tydzien = tydzien;
    }

    public ArrayList<zdarzenie> getListaZdarzen() {
        return listaZdarzen;
    }

    public String getDzien() {
        return dzien;
    }

    public int getTydzien() {
        return tydzien;
    }
    
    
}

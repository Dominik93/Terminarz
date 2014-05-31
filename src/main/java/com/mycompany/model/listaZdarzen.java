/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Dominik Ślusarz, Radosław Zając, Roger Woźniak, Aleksandra Worhacz, Daniel Stanek 
 */ 
public class listaZdarzen implements interfaceZdarzen<zdarzenie>{

    protected ArrayList<zdarzenie> listaZdarzen = new ArrayList<zdarzenie>();
    protected int tydzien;
    /**
     * Konstruktor
     * @param t  zaznaczony tydzien 
     */
    public listaZdarzen(int t){
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
     * Sortuje liste zdarzeń po dniu, godzinie początkowej a potem koncowej... taa jakby nie można było odrazu dodawać w odpowiednie miejsce xD
     */
    public void sortuj(){
        zdarzenie temp = new zdarzenie();
        String tabStr[] = { "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela" };
        int tabInt[] = {1,2,3,4,5,6,7};
        int dzienJ=0, dzienI=0;
        for(int i = 0 ; i < listaZdarzen.size(); i++)
            for(int j = 0 ; j < listaZdarzen.size(); j++){
                for(int k = 0; k < tabStr.length; k++)
                    if(listaZdarzen.get(i).dzien.equals(tabStr[k])) dzienI = k + 1;
                for(int k = 0; k < tabStr.length; k++)
                    if(listaZdarzen.get(j).dzien.equals(tabStr[k])) dzienJ = k + 1;
                
                if(dzienI < dzienJ){
                    temp = listaZdarzen.get(i);
                    listaZdarzen.set(i,listaZdarzen.get(j));
                    listaZdarzen.set(j,temp);
                }
                else if(dzienI == dzienJ && listaZdarzen.get(i).godzinaPoczatek.compareTo(listaZdarzen.get(j).godzinaPoczatek) < 0){ // arg jest wiekszy
                    temp = listaZdarzen.get(i);
                    listaZdarzen.set(i,listaZdarzen.get(j));
                    listaZdarzen.set(j,temp);
                }
                else if(listaZdarzen.get(i).godzinaPoczatek.compareTo(listaZdarzen.get(j).godzinaPoczatek) == 0){ // arg jest mniejszy
                    if(listaZdarzen.get(i).godzinaKoniec.compareTo(listaZdarzen.get(j).godzinaKoniec) < 0){ // arg jest wiekszy
                    temp = listaZdarzen.get(i);
                    listaZdarzen.set(i,listaZdarzen.get(j));
                    listaZdarzen.set(j,temp);
                    }
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
    
    /**
     * Funkcja zwaraca tablice stringów w której są wartości do wyświetlenia w jList
     * @param t  zaznaczony tydzine
     * @return String[]
     */
    public String[] model(int t){
        String [] stringList = new String[listaZdarzen.size()];
        int i = 0;
        for(zdarzenie ob : listaZdarzen){
            stringList[i] = ob.wyswietlStringKrotko();
            i++;
        }
        return stringList;
    }
    
    public void setListaZdarzen(ArrayList<zdarzenie> listaZdarzen) {
        this.listaZdarzen = listaZdarzen;
    }

    public void setTydzien(int tydzien) {
        this.tydzien = tydzien;
    }

    public ArrayList<zdarzenie> getListaZdarzen() {
        return listaZdarzen;
    }

    public int getTydzien() {
        return tydzien;
    }
    
    
}

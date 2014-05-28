/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.terminarz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Dominik
 */
public class terminy {
    
    protected ArrayList<listaZdarzen> lista = new ArrayList<listaZdarzen>();
    
    public terminy(){
        for(int i = 1; i < 53; i++){
           lista.add(new listaZdarzen(i));
        }
    }
    
    /**
     * Dodaje zdarzenie do odpowiedniej listy zdrzeń 
     * @param t - zaznaczony tydzień
     * @param z - obiekt klasy zdarzenie
     */
    public void dodaj(int t, zdarzenie z){
        for(listaZdarzen ob : lista){
            if (ob.tydzien == t){
                ob.dodaj(z);
            }
        }
    }
    
    /**
     * Usuwa wszystkie listy zdarzeń 
     */
    public void usun(){
        for(listaZdarzen ob : lista){
            ob.usunWszystko();
        }
    }
    
    /**
     * Usuwa zdarzenie o indeksie i z danego tygodnia
     * @param t - zaznaczony tydzien
     * @param i - indeks zdarzenia
     */
    public void usun(int t, int i){
        for(listaZdarzen ob : lista){
            if (ob.tydzien == t){
                ob.usun(i);
            }
        }
    }
        
    /**
     * Wyświetla daną liste zdarzeń
     * @param t - zaznaczony tydzień
     */
    public void wyswietl(int t){
        for(listaZdarzen ob : lista){
            if (ob.tydzien == t){
                ob.wyswietl();
            }
        }
    }
    
    /**
     * Wyswietla wszsytkie listy zdarzen w terminarzu
     */
    public void wyswietl(){
        for(listaZdarzen ob : lista){
            ob.wyswietl();
        }
    }
    
    /**
     * Zwraca model listy dla jList na dany tydzien
     * @param t - zaznaczony tydzień
     * @return DefaultListModel
     */
    public DefaultListModel ustalModel(int t){
        DefaultListModel listModel = new DefaultListModel();
        String [] stringList;
        for(listaZdarzen ob : lista){
            if(ob.tydzien == t && !ob.listaZdarzen.isEmpty()){
                stringList = ob.model(t);
                for(int i = 0; i < ob.listaZdarzen.size(); i ++){
                    listModel.addElement(stringList[i]);
                }
            }
        }
        return listModel;
    }
    
    /**
     * Zapis całego terminarza w postaci tydzien;dzien;godzinaPoczatek;godzinaKoniec;temat;opis do pliku .txt
     * @throws FileNotFoundException 
     */
    public void zapisDoPliku() throws FileNotFoundException{
        PrintWriter zapis = null;
        // OTWIERANIE PLIKU:
        try{
            zapis = new PrintWriter("terminarz.txt");
        }catch (FileNotFoundException e){
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }
        for(listaZdarzen ob : lista){
            for(int i = 0; i < ob.listaZdarzen.size(); i++){
                zapis.println(ob.tydzien+";"+ob.listaZdarzen.get(i).dzien+";"+ob.listaZdarzen.get(i).godzinaPoczatek+";"+
                        ob.listaZdarzen.get(i).godzinaKoniec+";"+ob.listaZdarzen.get(i).tytulZdarzenia+";"+
                        ob.listaZdarzen.get(i).tekstZdarzenia);
                System.out.println(ob.tydzien+";"+ob.listaZdarzen.get(i).dzien+";"+ob.listaZdarzen.get(i).godzinaPoczatek+";"+
                        ob.listaZdarzen.get(i).godzinaKoniec+";"+ob.listaZdarzen.get(i).tytulZdarzenia+";"+
                        ob.listaZdarzen.get(i).tekstZdarzenia);
            }

        }
        zapis.close();
    }
    
    /**
     * Odczyt z pliku .txt do aplikacji
     */
    public void odczytZPliku(){
        FileReader odczyt = null;
        String linia = "";

        // OTWIERANIE PLIKU:
        try{
            odczyt = new FileReader("terminarz.txt");
        }catch (FileNotFoundException e){
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(odczyt);
        // ODCZYT KOLEJNYCH LINII Z PLIKU:
        try{
            while((linia = bfr.readLine()) != null){
                String[] list = linia.split(";");
                System.out.println(list);
                for(listaZdarzen ob : lista){
                    if (ob.tydzien == Integer.parseInt(list[0])){
                        ob.dodaj(new zdarzenie(list[2], list[3], list[4], list[5],list[1]));
                    }
                }
            }
        }catch (IOException e){
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        // ZAMYKANIE PLIKU
        try{
          odczyt.close();
        }catch (IOException e){
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }
    
    public Lista<zdarzenie> iteruj(int t){
        Lista<zdarzenie> listaZdarzen = new Lista<zdarzenie>();
        boolean znalazl = false;
        int stop = 0;
        for(listaZdarzen ob : lista){
            if (znalazl || (ob.tydzien == t)){
                znalazl = true;
                ArrayList<zdarzenie> lista  = ob.getListaZdarzen();
                for(int i = 0; i < lista.size() ; i++){
                    listaZdarzen.wstawNaPoczatek(lista.get(i));
                    stop++;
                    if(stop == 10) break;
                }
            }
            if(stop == 10) break;
        }
        return listaZdarzen;
    }
    
    public void setLista(ArrayList<listaZdarzen> lista) {
        this.lista = lista;
    }

    public ArrayList<listaZdarzen> getLista() {
        return lista;
    }
    
    
}

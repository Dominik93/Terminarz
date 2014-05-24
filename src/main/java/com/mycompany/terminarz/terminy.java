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

/**
 *
 * @author Dominik
 */
public class terminy {
    
    private final String[] dni = { "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela" };
    protected ArrayList<listaZdarzen> lista = new ArrayList<listaZdarzen>();
    
    public terminy(){
        int j = 0, k = 1;
        for(int i = 1; i < (53*7); i++){
           lista.add(new listaZdarzen(dni[j], k));
           j++;
           if (j == 7){ 
               j = 0; 
               k++;
           }
        }
    }
    
    public void dodaj(String d, int t, zdarzenie z){
        for(listaZdarzen ob : lista){
            if (ob.dzien.equals(d) && ob.tydzien == t){
                ob.dodaj(z);
            }
        }
    }
    
    public void usun(){
        for(listaZdarzen ob : lista){
            ob.usunWszystko();
        }
    }
    
    public void wyswietl(String d, int t){
        for(listaZdarzen ob : lista){
            if (ob.dzien.equals(d) && ob.tydzien == t){
                ob.wyswietl();
            }
        }
    }
    
    public void wyswietl(){
        for(listaZdarzen ob : lista){
            ob.wyswietl();
        }
    }
    
    
    public void zapisDoPliku() throws FileNotFoundException{
        //tydzien;dzien;godzinaPoczatek;godzinaKoniec;temat;opis
        try{
            PrintWriter zapis = new PrintWriter("terminarz.txt");
            for(listaZdarzen ob : lista){
                for(int i = 0; i < ob.listaZdarzen.size(); i++){
                    zapis.println(ob.tydzien+";"+ob.dzien+";"+ob.listaZdarzen.get(i).godzinaPoczatek+";"+
                        ob.listaZdarzen.get(i).godzinaKoniec+";"+ob.listaZdarzen.get(i).tytulZdarzenia+";"+
                        ob.listaZdarzen.get(i).tekstZdarzenia);
                    System.out.println(ob.tydzien+";"+ob.dzien+";"+ob.listaZdarzen.get(i).godzinaPoczatek+";"+
                        ob.listaZdarzen.get(i).godzinaKoniec+";"+ob.listaZdarzen.get(i).tytulZdarzenia+";"+
                        ob.listaZdarzen.get(i).tekstZdarzenia);
                }
                
            }
            zapis.close();
        }catch(IOException ex){
        }
    }
    
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
                    if (ob.dzien.equals(list[1]) && ob.tydzien == Integer.parseInt(list[0])){
                        ob.dodaj(new zdarzenie(list[2], list[3], list[4], list[5]));
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
}

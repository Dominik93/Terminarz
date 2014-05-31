/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.kontroler;

import com.mycompany.model.dekoratorZdarzenia;
import com.mycompany.model.terminy;
import com.mycompany.model.zdarzenie;
import com.mycompany.widok.widok;

import java.awt.event.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Dominik Ślusarz, Radosław Zając, Roger Woźniak, Aleksandra Worhacz, Daniel Stanek 
 */
public class kontroler {
    
    private terminy model = null;
    private widok  widok = null;
    private String zaznaczonyDzien = "";
    private int zaznaczonyTydzien = 0;
    Iterator<zdarzenie> iteratorZdarzen;
    
    public kontroler(terminy model, widok widok) {
        this.model = model;
        this.widok  = widok;
        
        /*
            dodanie action listenerów
        */
        this.widok.addListenerButton1(new button1Listener());
        this.widok.addListenerButton2(new button2Listener());
        this.widok.addListenerButton3(new button3Listener());
        this.widok.addListenerButton4(new button4Listener());
        this.widok.addListenerButton5(new button5Listener());
        this.widok.addListenerButton6(new button6Listener());
        this.widok.addListenerButton7(new button7Listener());
        this.widok.addListenerButton8(new button8Listener());
        this.widok.addListenerButton9(new button9Listener());
        this.widok.addListenerButton10(new button10Listener());
        this.widok.addListenerButton11(new button11Listener());
        
        this.widok.addListenerComboBox1(new comboBox1Listener());
        
        this.widok.addListenerRadioButton1(new radioButton1Listener());
        this.widok.addListenerRadioButton2(new radioButton2Listener());
        this.widok.addListenerRadioButton3(new radioButton3Listener());
        this.widok.addListenerRadioButton4(new radioButton4Listener());
        this.widok.addListenerRadioButton5(new radioButton5Listener());
        this.widok.addListenerRadioButton6(new radioButton6Listener());
        this.widok.addListenerRadioButton1(new radioButton7Listener());
        
    }
    
    /*
        klasy odpowiedzialne za action listenery
    */
    
    // <editor-fold defaultstate="collapsed" desc="obsługa zdarzen dla radioButtonów"> 
    class radioButton1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            zaznaczonyDzien = "Poniedziałek";
        }
    }
    
    class radioButton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            zaznaczonyDzien = "Wtorek";
        }
    }
    
    class radioButton3Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            zaznaczonyDzien = "Środa";
        }
    }
    
    class radioButton4Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            zaznaczonyDzien = "Czwartek";
        }
    }
    
    class radioButton5Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            zaznaczonyDzien = "Piątek";
        }
    }
    
    class radioButton6Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            zaznaczonyDzien = "Sobota";
        }
    }
    
    class radioButton7Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            zaznaczonyDzien = "Niedziela";
        }
    }
    //</editor-fold> 

    
    class comboBox1Listener implements ActionListener { // wybierz tydzień
        public void actionPerformed(ActionEvent e) {
            zaznaczonyTydzien = widok.getComboBox();
            widok.setList(model.ustalModel(zaznaczonyTydzien));
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="obsługa zdarzen dla buttonów"> 
    class button1Listener implements ActionListener { // dodaj zdarzenie
        public void actionPerformed(ActionEvent e) {
            if(zaznaczonyTydzien != 0 && !zaznaczonyDzien.equals(""))
            widok.setVisibleJDialog1(true);
        }
    }
    
    class button2Listener implements ActionListener { // przeglad wszystkich zdarzen
        public void actionPerformed(ActionEvent e) {
            
            widok.setVisibleButton11(true);
            iteratorZdarzen = model.iteruj(zaznaczonyTydzien);
            widok.setVisibleJDialog2(true);
        }
    }
    
    class button3Listener implements ActionListener { // ok jDialog1
        public void actionPerformed(ActionEvent e) {
            
            if( !(( widok.getTextField1().startsWith("0") ) || ( widok.getTextField1().startsWith("1") ) || ( widok.getTextField1().startsWith("2") )) || 
                    (widok.getTextField1().startsWith("2") && !( (widok.getTextField1().startsWith("0", 1)) || (widok.getTextField1().startsWith("1", 1))
                    || (widok.getTextField1().startsWith("2", 1)) || (widok.getTextField1().startsWith("3", 1)) || (widok.getTextField1().startsWith("4", 1) ))) ){
                JOptionPane.showMessageDialog(null,"Błędnie podana godzina od!!");
            }
            else if( !(( widok.getTextField2().startsWith("0") ) || ( widok.getTextField2().startsWith("1") ) || ( widok.getTextField2().startsWith("2") )) || 
                    (widok.getTextField2().startsWith("2") && !( (widok.getTextField2().startsWith("0", 1)) || (widok.getTextField2().startsWith("1", 1))
                    || (widok.getTextField2().startsWith("2", 1)) || (widok.getTextField2().startsWith("3", 1)) || (widok.getTextField2().startsWith("4", 1) ))) ){
                JOptionPane.showMessageDialog(null,"Błędnie podana godzina do!!");
            }
            else{
            model.dodaj(zaznaczonyTydzien, new zdarzenie(widok.getTextField1(), widok.getTextField2(),widok.getTextField3(),widok.getTextArea1(),zaznaczonyDzien));
            widok.setTextField1("");
            widok.setTextField2("");
            widok.setTextField3("");
            widok.setTextArea1("");
            widok.setVisibleJDialog1(false);
            widok.setList(model.ustalModel(zaznaczonyTydzien));
            }
        }
    }
    
    class button4Listener implements ActionListener { // anuluj jDialog1
        public void actionPerformed(ActionEvent e) {
            widok.setTextField1("");
            widok.setTextField2("");
            widok.setTextField3("");
            widok.setTextArea1("");
            widok.setVisibleJDialog1(false);
        }
    }
    
    class button5Listener implements ActionListener { // usun
        public void actionPerformed(ActionEvent e) {
            if(widok.getList() != -1){
                model.usun(zaznaczonyTydzien,widok.getList());
                widok.setList(model.ustalModel(zaznaczonyTydzien));
            }
        }
    }
    
    class button6Listener implements ActionListener { //zapisz terminarz
        public void actionPerformed(ActionEvent e) {
            try {
                model.zapisDoPliku();
            }catch (IOException ex) {
                Logger.getLogger(kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class button7Listener implements ActionListener { // otworz terminarz
        public void actionPerformed(ActionEvent e) {
            model.odczytZPliku();
            widok.setList(model.ustalModel(zaznaczonyTydzien));
        }
    }

    class button8Listener implements ActionListener { //pokaz zdarzenie
        public void actionPerformed(ActionEvent e) {
            if(widok.getList() != -1){
                widok.setVisibleJDialog2(true);
                dekoratorZdarzenia dekZd = new dekoratorZdarzenia(
                        model.getZdarzenie(zaznaczonyTydzien, widok.getList())
                );
                widok.setLabel6(dekZd.wyswietlLabel());
                widok.setVisibleButton11(false);
            }
        }
    }
    
    class button9Listener implements ActionListener { // usun terminarz
        public void actionPerformed(ActionEvent e) {
            model.usun();
            widok.setList(model.ustalModel(zaznaczonyTydzien));
        }
    }
    
    class button10Listener implements ActionListener { //zamknij jDialog2
        public void actionPerformed(ActionEvent e) {
            widok.setLabel6("");
            widok.setVisibleJDialog2(false);
        }
    }
    
    class button11Listener implements ActionListener { //nastepne zdarzenie jDialog2
        public void actionPerformed(ActionEvent e) {
            if(iteratorZdarzen.hasNext()) {
                dekoratorZdarzenia dekZd = new dekoratorZdarzenia(iteratorZdarzen.next());
                widok.setLabel6(dekZd.wyswietlLabel());
            }else{
                widok.setLabel6("Koniec zdarzen");
            }
        }
    }
    //</editor-fold>
    
}

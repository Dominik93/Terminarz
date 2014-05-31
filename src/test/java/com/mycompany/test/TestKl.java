/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.test;
import com.mycompany.model.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author rados
 */
public class TestKl {
       @Test
    public void testZdarzenieGodzina() {
        zdarzenie ob = new zdarzenie();
        ob.setGodzinaPoczatek("12:00");
        assertEquals(ob.getGodzinaPoczatek(), "12:00");
    }
    @Test
    public void testZdarzenieTytuł(){
        zdarzenie ob = new zdarzenie();
        ob.setTytulZdarzenia("przykladowy tytul");
        assertEquals(ob.getTytulZdarzenia(), "przykladowy tytul");
    }
    @Test
    public void testListaZdarzenTydzien(){
        listaZdarzen ob = new listaZdarzen(2);
        assertEquals(ob.getTydzien(),2);
    }
    @Test
    public void testZdarzenieCalosc(){
        zdarzenie ob = new zdarzenie("10:00","12:45","test","testujemy poprawne działanie","poniedziałek");
        assertEquals(ob.wyswietlString(),"poniedziałek 10:00-12:45 test: testujemy poprawne działanie");
    }
    @Test
    public void testPass() {
        assertTrue(true);
    }
}

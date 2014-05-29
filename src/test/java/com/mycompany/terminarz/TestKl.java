/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.terminarz;
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
    public void testTerminyDni(){
        terminy ob = new terminy();       
        String[] dni = { "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela" };       
        assertArrayEquals(ob.getDni(),dni);
    }
    @Test
    public void testListaZdarzenDdzien(){
        listaZdarzen ob = new listaZdarzen("poniedziałek",2);
        assertEquals(ob.getDzien(),"poniedziałek");
    }
}

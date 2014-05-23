/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.terminarz;

import java.util.Scanner;

/**
 *
 * @author Dominik
 */
public class zdarzenie {
    
    protected String godzinaPoczatek, godzinaKoniec;
    protected String tekstZdarzenia;
    
    
    public zdarzenie(String gP, String gK, String z){
        godzinaPoczatek = gP;
        godzinaKoniec = gK;
        tekstZdarzenia = z;
    }
}

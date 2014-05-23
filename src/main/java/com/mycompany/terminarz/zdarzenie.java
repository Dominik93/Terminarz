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
    protected String dzien, tydzien;
    protected String zdarzenie;
    
    
    public zdarzenie(String gP, String gK, String d, String t, String z){
        godzinaPoczatek = gP;
        godzinaKoniec = gK;
        dzien = d;
        tydzien = t;
        zdarzenie = z;
    }
}

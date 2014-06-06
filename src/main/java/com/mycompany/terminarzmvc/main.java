/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.terminarzmvc;

import com.mycompany.kontroler.kontroler;
import com.mycompany.widok.widok;
import com.mycompany.model.terminy;

/**
 *
 * @author Dominik Ślusarz, Radosław Zając, Roger Woźniak, Aleksandra Worhacz, Daniel Stanek 
 */
public class main {
    
    public static void main(String[] args) {
        // TODO code application logic here\
        /*
        * Tworzę instancję terminów przypisaną do referencji typu Object
        * Następnie castuję ją do terminy i używam funkcji zawartej w 
        * klasie terminy (PoliInst())
        */
         Object model = terminy.wezInstancje();//new terminy();
         widok widok = new widok(((terminy)model).PoliInst());
         kontroler kontroler = new kontroler(((terminy)model).PoliInst(), widok);
        
         widok.setVisible(true);
        
    }
    
}

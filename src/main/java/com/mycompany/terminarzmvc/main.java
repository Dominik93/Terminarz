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
        // TODO code application logic here
         terminy model = new terminy();
         widok widok = new widok(model);
         kontroler kontroler = new kontroler(model, widok);
        
         widok.setVisible(true);
        
    }
    
}

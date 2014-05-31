/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

/**
 *
 * @author Dominik Ślusarz, Radosław Zając, Roger Woźniak, Aleksandra Worhacz, Daniel Stanek 
 */
public interface interfaceZdarzen<T> {
    void dodaj(T ob);
    void usun(int i);
    void usun(T ob);
    void usunWszystko();
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

/**
 *
 * @author Dominik Ślusarz, Radosław Zając, Roger Woźniak, Aleksandra Worhacz, Daniel Stanek 
 */
class Wezel<T> {
 // pole przechowujące wartość znajdującą się w węźle
 private T obiekt;
 // referencja do następnego elementu listy
 private Wezel<T> nastepny;
 
 // konstruktor domyślny;
 public Wezel() {
  // wywołanie konstruktora dwuparametrowego)
  this(null, null);
 }
 
 // konstruktor dwuparametrowy
 // wartość oraz referencja do następnego węzła
 public Wezel(T obiekt, Wezel<T> nastepny) {
  this.obiekt = obiekt;
  this.nastepny = nastepny;
 }
  
 // metoda zwraca referencję do następnego węzła
 public Wezel<T> pobierzNastepny() {
  return nastepny;
 }
 
 // metoda zwraca przechowywaną w węźle wartość
 public T pobierzObiekt() {
  return obiekt;
 }
}
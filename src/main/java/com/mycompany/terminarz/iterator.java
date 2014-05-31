/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.terminarz;

/**
 *
 * @author Dominik
 */
import java.util.Iterator;

class Lista<T> implements Iterable<T> {

 // pole przechowujące referencję do początku listy
 private Wezel<T> poczatek;
 
 // konstruktor bezparametrowy
 public Lista () {
  // ustawiamy początek na null (lista pusta)
  poczatek = null;
 }
 
 // metoda wstawia dane na początek listy
 public void wstawNaPoczatek(T dane) {
  // tworzymy nowy węzeł oraz ustawiamy 
  // zmienną poczatek tak aby go wskazywała
  poczatek = new Wezel<T>(dane, poczatek);
 }
 
 // metoda usuwa element znajdujący się na początku listy
 // oraz zwraca referencję do niego
 public Wezel<T> usunZPoczatku() {
  // zapamiętujemy element z początku listy
  Wezel<T> temp = poczatek;
  // zmieniamy referencje początku listy
  // na następny element (pomijamy pierwszy)
  poczatek = poczatek.pobierzNastepny();
  // zwracamy zapamiętaną referencję
  return temp; 
 }
 
 // metoda zwraca referencję do obiektu klasy
 // implementującej interfejs Iterator<T>
 public Iterator<T> iterator() {
  // tworzymy nowy obiekt wewnętrznej klasy IteratorListy
  // i zwracamy jego referencję
  return new IteratorListy();
 }
 
 // prywatna klasa wewnętrzna implementująca interfejs Iterator<T>
 private class IteratorListy implements Iterator<T> {
  
  // pole przechowujące referencję do pierwszego elementu naszej listy
  private Wezel<T> temp = poczatek;
  
  // metoda zwraca wartość logiczną czy są jeszcze elementy w kolekcji
  public boolean hasNext() {
   return temp != null;
  }
  
  // metoda zwraca wartość elementu przechowywanego w kolejnym węźle
  public T next() {
   // pobieramy wartość (obiekt typu T)
   T obiekt = temp.pobierzObiekt();
   // przechodzimy na następny element listy
   temp = temp.pobierzNastepny();
   // zwracamy wartość
   return obiekt;
  }
  
  // metoda usuwająca element z kolekcji
  public void remove() {
   // ciało metody puste (patrz opis)
  }
   
 }
}

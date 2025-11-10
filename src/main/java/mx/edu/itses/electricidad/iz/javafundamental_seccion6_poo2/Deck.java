/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.electricidad.iz.javafundamental_seccion6_poo2;

/**
 *
 * @author zunig
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] ranks = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Reina", "Rey"};
        int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        // Construir el mazo de 52 cartas
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }
    } 
    public void shuffle() {
        Collections.shuffle(cards);
    }
    // Repartir una carta del tope
    public Card dealCard() {
        if (cards.isEmpty()) {
            return null; // Mazo vacío
        }
        return cards.remove(0); // Remueve y devuelve la primera carta
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
}

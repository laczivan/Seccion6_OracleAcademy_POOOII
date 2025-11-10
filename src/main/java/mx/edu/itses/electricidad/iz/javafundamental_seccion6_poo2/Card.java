/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.electricidad.iz.javafundamental_seccion6_poo2;

/**
 *
 * @author zunig
 */
public class Card {
    private String suit; 
    private String rank; 
    private int value;   

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }

    // Método para ajustar el valor del As de 11 a 1
    public void setValueToOne() {
        if (this.rank.equals("As") && this.value == 11) {
            this.value = 1;
        }
    }

    @Override
    public String toString() {
        return rank + " de " + suit;
    }
}

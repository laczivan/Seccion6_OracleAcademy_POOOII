/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.electricidad.iz.javafundamental_seccion6_poo2;

/**
 *
 * @author zunig
 */
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        
        // 9.a: Prueba de Mezcla
        System.out.println("Prueba del Mazo");
        System.out.println("Mazo Sin Mezclar (Primeras 5): " + deck.getCards().subList(0, 5));
        deck.shuffle();
        System.out.println("Mazo Mezclado (Primeras 5): " + deck.getCards().subList(0, 5));
       
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand(); 

        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        
        System.out.println("Inicio del juego");
        System.out.println("Croupier tiene: [" + dealerHand.getCards().get(0) + " y una carta oculya]");
        

        playerTurn(deck, playerHand, scanner);

        if (playerHand.isBust()) {
            System.out.println("Puntuación: " + playerHand.getPoints());
            System.out.println("Croupier gana.");
            return;
        }
        dealerTurn(deck, dealerHand);
        determineWinner(playerHand, dealerHand);
        
        scanner.close();
    }

    private static void playerTurn(Deck deck, Hand hand, Scanner scanner) {
        String choice;
        boolean playing = true;

        while (playing && !hand.isBust() && !hand.isFull()) {
            System.out.println("Tu mano: " + hand.getCards());
            System.out.println("Tienes: " + hand.getPoints() + " puntos.");

            if (hand.isFull()) {
                System.out.println("Tu mano está llena. Deteniendose..");
                break;
            }

            System.out.print("¿Quieres otra carta? (s/n): ");
            choice = scanner.next().toLowerCase();

            if (choice.startsWith("s")) {
                hand.addCard(deck.dealCard());
            } else {
                playing = false;
            }
        }
    }


    private static void dealerTurn(Deck deck, Hand hand) {
        System.out.println("Turno del Croupier");
        System.out.println("Croupier revela: " + hand.getCards());

 
        while (hand.getPoints() < 17 && !hand.isBust() && !hand.isFull()) {
            Card newCard = deck.dealCard();
            hand.addCard(newCard);
            System.out.println("Croupier toma: " + newCard);
            System.out.println("Puntuación del Croupier: " + hand.getPoints());
        }

        if (hand.isBust()) {
            System.out.println("Croupier se pasa (" + hand.getPoints() + ").");
        } else {
            System.out.println("Croupier se planta con " + hand.getPoints() + " puntos.");
        }
    }

    // Determinar el ganador
    private static void determineWinner(Hand player, Hand dealer) {
        int pPoints = player.getPoints();
        int dPoints = dealer.getPoints();

        System.out.println("resultados");
        System.out.println("Jugador: " + pPoints + " puntos.");
        System.out.println("Croupier: " + dPoints + " puntos.");

        if (dealer.isBust() || (pPoints > dPoints && pPoints <= 21)) {
            System.out.println("Ganas la partida.");
        } else if (pPoints == dPoints) {
            System.out.println(" Es un empate .");
        } else {
            System.out.println("El Croupier gana.");
        }
    }
}

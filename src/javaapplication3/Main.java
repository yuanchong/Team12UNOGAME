/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Scanner;

/**
 *
 * @author VIVEKANAND
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String curPlayer = null;
        UnoGame j = new UnoGame();
        for (int i = 0; i < 4; i++) {
            Player p = new Player();
            p.setName("Player " +i);
            j.addPlayer(p);
           
        }

        j.init();
        System.out.println();
        System.out.println("Remaining cards in Draw Pile:"+j.deckCount());
        System.out.println();
        
         Scanner in = new Scanner(System.in);
         do {
         System.out.println("Enter next player number");
         
         String nextPlayer = in.nextLine();
         //System.out.println("Next player is Player "+ nextPlayer);
         System.out.println ("Enter card to discard: (Enter Draw to DrawCard)");
         String cardToDiscard = in.nextLine();
         //j.changeCardOnTable(cardToDiscard);
         //System.out.println("Card On Top " + j.getCardOnTable());
         curPlayer = ("Player "+nextPlayer);
         
         if (cardToDiscard.equalsIgnoreCase("draw")){
             Player p = j.getPlayer(curPlayer);
             String newCard = j.drawOneCard();
             p.addCard(newCard);
             
         }else{
         
         Player p = j.getPlayer(curPlayer);
         //String msg = p.checkCard(cardToDiscard);
         //if (msg.equalsIgnoreCase("found")){
         //System.out.println("player to remove" + p);
         p.removeCard(cardToDiscard);
         
         j.changeCardOnTable(cardToDiscard);
         }
         /*else
             System.out.println(msg);
         }*/
         j.showTable();
         }while (j.deckCount() != 0 && j.getPlayer(curPlayer).getHand().size()!=0 );
         System.out.println("Game Ended");
    }

}

package javaapplication3;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private String name;
    private List<String> hand = new LinkedList();

    public void addCard(String card) {
        hand.add(card);
    }
    public void removeCard (String card){
        hand.remove(card);
    }
    /*
    public String checkCard (String card){
        String msg = null;
        for(int i =0; i<hand.size();i++){
        String card1 = hand.get(i);
        System.out.println(card1);
        if (card1.equalsIgnoreCase(card) ) {
           msg =  "found";
        }
        else 
        msg =  "Card Not Found";
        }
        return msg;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHand() {
        return hand;
    }

    public void setHand(List<String> hand) {
        this.hand = hand;
    }

}

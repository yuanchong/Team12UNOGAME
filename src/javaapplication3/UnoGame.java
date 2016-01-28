package javaapplication3;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UnoGame {
    private String gid = UUID.randomUUID().toString();
    private Map<String, Player> playerlist = new HashMap<>();
    private static List<String> deck = new LinkedList();
    private String cardOnTable;
    
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public Map<String, Player> getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(Map<String, Player> playerlist) {
        this.playerlist = playerlist;
    }

    public List<String> getDeck() {
        return deck;
    }

    public void setDeck(List<String> deck) {
        this.deck = deck;
    }
    
    public String getCardOnTable() {
        return cardOnTable;
    }

    public void setCardOnTable(String cardOnTable) {
        this.cardOnTable = cardOnTable;
    }
    
    public void addPlayer(Player player) {
        playerlist.put(player.getName(), player);
    }

    /**
     *
     * @param hm
     * @param player
     * @return
     */
    public static Player getKeyFromValue(Map hm, Player player){
        for(Object p : hm.keySet()){
            if (hm.get(p).equals(player)){
                return (Player) p;
            }
        }
        return null;
        }
    
    public Player getPlayer(String name) {
        //Player p = playerlist.get(name);
        //return p;
        ///*
        //playerlist.keySet()
        for (Player p : playerlist.values()) {
            if(p.equals(playerlist.get(name))){
                return p;
            }
        }
        
    //    Player z = playerlist.values();
        return null; 
        //*/
    }

    private void setupDeck() {
        for (int i = 1; i < 10; i++) {
            deck.add("B" + i);
            deck.add("R" + i);
            deck.add("G" + i);
            deck.add("Y" + i);
        }
        for (int i = 0; i < 10; i++) {
            deck.add("B" + i);
            deck.add("R" + i);
            deck.add("G" + i);
            deck.add("Y" + i);
        }
        for (int i = 0; i < 4; i++) {
            deck.add("W4");
            deck.add("W");
        }
        for (int i = 0; i < 2; i++) {
            deck.add("BSkip");
            deck.add("RSkip");
            deck.add("GSkip");
            deck.add("YSkip");

            deck.add("BRev");
            deck.add("RRev");
            deck.add("GRev");
            deck.add("YRev");

            deck.add("BPlus2");
            deck.add("RPlus2");
            deck.add("GPlus2");
            deck.add("YPlus2");
        }
    }
    public void drawCard(String name, Player player){
        for (String p: playerlist.keySet()){
            if (p.equals(name)){
                for(Player pz : playerlist.values()){
                pz.addCard(name);
                }
            }
        }
    }
    
    public String drawOneCard() {

        String removeCard = deck.remove(0);
        return removeCard;
    }

    public String dealTopCard() {
        return deck.remove(0);
    }

    public void init() {

        setupDeck();
        Collections.shuffle(deck);

        for (Player p : playerlist.values()) {
            for (int j = 0; j < 7; j++) {
                p.addCard(deck.get(0));
                deck.remove(0);
            }
        }
        System.out.println();
        System.out.println("Game ID: " + gid);

        for (Player p : playerlist.values()) {
            System.out.println();
            System.out.println(p.getName());
            System.out.println(p.getHand());
        }

        cardOnTable = dealTopCard();
        System.out.println();
        System.out.println("Top card:" + cardOnTable);

    }
    public void changeCardOnTable(String card){
        cardOnTable = card;
        
    }
    public void showTable(){
        System.out.println("========================");
        System.out.println("Game ID: " + gid);

        for (Player p : playerlist.values()) {
            System.out.println();
            System.out.println(p.getName());
            System.out.println(p.getHand());
        }
        System.out.println();
        System.out.println("Top card:" + cardOnTable);
    }

    public int deckCount() {
        return deck.size();
    }

}

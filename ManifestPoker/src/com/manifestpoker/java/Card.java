package com.manifestpoker.java;

public class Card {
    private int rank;
    private int suit;

    //create my suits and ranks
    private static String[] suits ={"C", "S","D","H"};
    private static String[] ranks ={ "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A" };

    public static String rankString(int rank){
        return ranks[rank];
    }

    //initialization
   Card(int suit, int rank){
        this.rank=rank;
        this.suit=suit;
    }
    //this will print the details to the card
    public String toString(){
        return ranks[rank] + suits[suit];
    }

    //get statements
    public int getRank(){

        return rank;
    }
    public int getSuit(){

        return suit;
    }



}

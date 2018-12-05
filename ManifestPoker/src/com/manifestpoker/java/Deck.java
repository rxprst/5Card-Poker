package com.manifestpoker.java;
import java.util.Random;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    ///create a deck of 52 cards
    Deck()
    {
        cards=new ArrayList<Card>();
        int index1, index2;
        Random rand=new Random();
        Card temp;

        for(int i=0; i<=3; i++){
            for(int j=0; j<=12;j++){
                cards.add( new Card(i,j));
            }
        }


           for(int x=0; x<52; x++)
           {
               index1 =rand.nextInt(cards.size() -1);
               index2=rand.nextInt(cards.size()-1);

               temp=cards.get(index2);
               cards.set(index2, cards.get(index1));
               cards.set(index1,temp);
           }
         }

         public Card drawFromDeck(){
        return cards.remove(0);
         }

}

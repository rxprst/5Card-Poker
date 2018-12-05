package com.manifestpoker.java;


public class Main {

    public static void main(String[] args) {
        Deck deck=new Deck();
        Hand black=new Hand(deck);
        Hand white= new Hand(deck);
        //our player named black
        System.out.print("Black :");
        black.displayAll();
        black.display();

        //our player named white
        System.out.print("White: ");
        white.displayAll();
        white.display();

        if(black.compareTo(white) == -1)
            System.out.println("White wins!");
        if(black.compareTo(white)==1)
            System.out.println("Black wins!");
        if(black.compareTo(white)==0)
            System.out.print("tie");
    }

    }


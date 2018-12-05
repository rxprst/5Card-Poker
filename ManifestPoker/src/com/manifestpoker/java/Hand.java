package com.manifestpoker.java;

public class Hand {
    private Card[] cards;
    private int[] value;


    Hand(Deck d) {
        value = new int[6];
        cards = new Card[5];
        for (int x = 0; x < 5; x++) {
            cards[x] = d.drawFromDeck();
        }
        int[] ranks = new int[14];

        for (int x = 0; x <= 13; x++) {
            ranks[x] = 0;
        }
        for (int x = 0; x <= 13; x++) {
            ranks[x] = 0;
        }
        for (int x = 0; x < 4; x++) {
            ranks[cards[x].getRank()]++;
        }
        //checking for pairs
        int sameCards = 1, sameCards2 = 1;
        int largegroupRank = 0, smallgroupRank = 0;

        for (int x = 13; x >=1; x--) {
            if (ranks[x] > sameCards) {
                if (sameCards == 1) {
                    largegroupRank=x;
                }
                else{
                    sameCards2=sameCards;
                    smallgroupRank=x;
                }
                sameCards=ranks[x];
            } else if (ranks[x] > sameCards2) {

                sameCards2 =ranks[x];
                smallgroupRank=x;
            }
        }
        boolean flush = true;

        for (int x = 0; x < 4; x++) {
            if (cards[x].getSuit() != cards[x + 1].getSuit())
                flush = false;
        }
        int highStraightVal = 0;
        boolean straight = false;

        for (int x = 1; x <= 9; x++) {
            if (ranks[x] == 1 && ranks[x + 1] == 1 && ranks[x + 3] == 1 && ranks[x + 4] == 1) {
                straight = true;
                highStraightVal = x + 4;
                break;
            }
        }
        if (ranks[10] == 1 && ranks[11] == 1 && ranks[12] == 1 && ranks[13] == 1 && ranks[1] == 1) {
            straight = true;
            highStraightVal = 14;
        }
        int[] orderedRanks = new int[5];
        int index = 0;

        if (ranks[1] == 1) {
            orderedRanks[index] = 14;
            index++;
        }

        for (int x = 13; x >= 2; x--) {
            if (ranks[x] == 1) {
                orderedRanks[index] = x;
                index++;
            }
        }


        //evaluation
        if (sameCards == 1) {
            value[0]=1;
            value[1]=orderedRanks[0];
            value[2]=orderedRanks[1];
            value[3]=orderedRanks[2];
            value[4]=orderedRanks[3];
            value[5]=orderedRanks[4];
        }
        if(sameCards==2 && sameCards2==1){
            value[0]=2;
            value[1]=largegroupRank;
            value[2]=orderedRanks[0];
            value[3]=orderedRanks[1];
            value[4]=orderedRanks[2];
        }
        if(sameCards==3 && sameCards2!=2){
            value[0]=4;
            value[1]=largegroupRank;
            value[2]=orderedRanks[0];
            value[3]=orderedRanks[1];
        }
        if(straight){
            value[0]=5;
            value[1]=highStraightVal;
        }
        if(flush){
            value[0]=6;
            value[1]=orderedRanks[0];
            value[2]=orderedRanks[1];
            value[3]=orderedRanks[2];
            value[4]=orderedRanks[3];
            value[5]=orderedRanks[4];
        }
        if(sameCards==3 && sameCards2==2){
            value[0]=6;
            value[1]=orderedRanks[0];
            value[2]=orderedRanks[1];
            value[3]=orderedRanks[2];
            value[4]=orderedRanks[3];
            value[5]=orderedRanks[4];
        }
        if(sameCards==3 && sameCards2==2){
            value[0]=7;
            value[1]=largegroupRank;
            value[2]=smallgroupRank;
        }
        if(sameCards==4)
        {
            value[0]=8;
            value[1]=largegroupRank;
            value[2]=orderedRanks[0];
        }
        if(straight && flush){
            value[0]=9;
            value[1]=highStraightVal;
        }

    }

    public void displayAll() {
        for (int x = 0; x < 5; x++)
            System.out.print("{" + cards[x] + "}");
    }
    int compareTo(Hand that){
        for(int x=0; x<6; x++)
        {
            if(this.value[x]>that.value[x])
                return 1;
            if(this.value[x]<that.value[x])
                return -1;
        }
    return 0;


    }
    public void display()
    {
        String s;
        switch(value[0])
        {
            case 1:
                s="high card";
                break;
            case 2:
                s="pair of -"+ Card.rankString(value[1]) + "s";
                break;
            case 3:
                s="two pair -" + Card.rankString(value[1]) + "and -" + Card.rankString(value[2]);
                break;
            case 4:
                s="Three of a kind -" + Card.rankString(value[1]) +"s";
                break;
            case 5:
                s=Card.rankString(value[1]) + "Straight";
                break;
            case 6:
                s="flush";
                break;
            case 7:
                s="full house" + Card.rankString(value[1]) + "over" + Card.rankString(value[2]);
                break;
            case 8:
                s="four of a kind " + Card.rankString(value[1]);
                break;
            case 9:
                s="straight flush" + Card.rankString(value[1]) + "high";
                break;

             default:
                 s="error";
        }
        s="                     " + s;
        System.out.println(s);
    }

}



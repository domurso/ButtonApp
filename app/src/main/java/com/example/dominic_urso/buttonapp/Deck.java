package com.example.dominic_urso.buttonapp;

import java.util.*;

public class Deck{
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        fill();
    }

    private void fill(){
        for(int i = 1; i<5; i++){
            for(int j = 1; j< 14; j++){
                deck.add(new Card(i,j));
            }
        }
    }

    public void shuffle(){
        Random gen = new Random();
        int card1 = gen.nextInt(deck.size());
        int card2 = gen.nextInt(deck.size());
        Card c1 = deck.get(card1);
        Card c2 = deck.get(card2);

        for(int i = 0; i < 999; i++)
        {
            deck.set(card1,c2);
            deck.set(card2,c1);

            card1 = gen.nextInt(deck.size());
            card2 = gen.nextInt(deck.size());
            c1 = deck.get(card1);
            c2= deck.get(card2);
        }
    }


    public Card deal(){
        if(deck.size() > 0)
            return deck.remove(deck.size() - 1);
        else
            return null;
    }

    public int size(){
        return deck.size();
    }

    public String toString(){
        String list = "";
        for(Card c : deck){
            list += c + "\n";

        }
        return list;
    }

}
    
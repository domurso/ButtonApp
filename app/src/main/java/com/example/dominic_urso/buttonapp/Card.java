package com.example.dominic_urso.buttonapp;

public class Card{
    private int suit, rank;
    public Card(int s, int r){
        suit = s;
        rank = r;
    }
    public int getSuit(){
        return suit;
    }
    public int getRank(){
        return rank;
    }
    public String toString(){
        String face = "";
        String suits = "";

        switch(rank){
            case 10:
                face = "J";
                break;

            case 11:
                face = "♛";
                break;

            case 12:
                face = "♚";
                break;

            case 13:
                face = "A";
                break;

            default:
                face = "" + (rank + 1);
                break;

        }

        switch(suit){
            case 1:
                suits = "♦";
                break;
            case 2:
                suits = "♥";
                break;
            case 3:
                suits = "♠";
                break;
            case 4:
                suits = "♣";
                break;
            default:
                suits = "Invalid";
        }
        return suits +face;
    }
}

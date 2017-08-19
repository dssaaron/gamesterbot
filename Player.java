package com.homedev.bot;

import java.util.List;

//Class of player that can play a game in some room
public class Player {

    private int id;
    private String name;
    private List<Card> cards;
    private int balance;

    Player( int newId, String newName ) {

        balance = 100;
        id = newId;
        name = newName;
    }

    int getId( ) {
        return id;
    }

    String getName( ) {
        return name;
    }

    List<Card> getCards( ) {
        return cards;
    }

    int getBalance( ) {
        return balance;
    }

    void giveCards( List<Card> newCards ) {

        cards.addAll( newCards );
    }

    void takeCards( List<Card> newCards ) {

        cards.removeAll( newCards );
    }

    public String toString( ) {

        String info = "Id: " + id + ". Name: " + name + ". Balance: " + balance + "\n";
        return info;
    }
}

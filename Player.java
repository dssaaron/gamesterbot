package com.homedev.bot;

public class Player {

    private int id;
    private String name;
    private int cardAmount;
    private Card[] card; // somehow should get cards one by one even if there are more than 2 cards

    void SetId( int newId ) { id = newId; }
    void SetName( String newName ) { name = newName; }
    void SetCardAmount( int newCardAmount ) { cardAmount = newCardAmount; }

    int GetId( ) { return id; }
    String GetName( ) { return name; }
    int GetCardAmount( ) { return cardAmount; }
}

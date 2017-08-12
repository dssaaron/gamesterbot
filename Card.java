package com.homedev.bot;

public class Card {

    private int denomination;
    private int suit;
    private boolean availability;
    private String label;

    Card (int cardDenomination, int cardSuit) {

        denomination = cardDenomination;
        suit = cardSuit;
        availability = true;

        SetLabel( );
    }

    int GetDenomination( ) { return denomination; }

    int GetSuit( ) { return suit; }

    boolean IsAvailable( ) { return availability; }

    void SetAvailability( boolean cardAvailability ) { availability = cardAvailability; }

    String ShowLabel( ) { return label; }

    private void SetLabel( ) {

        switch ( denomination ) {

            case 2: label = "2";
                    break;
            case 3: label = "3";
                    break;
            case 4: label = "4";
                break;
            case 5: label = "5";
                break;
            case 6: label = "6";
                break;
            case 7: label = "7";
                break;
            case 8: label = "8";
                break;
            case 9: label = "9";
                break;
            case 10: label = "10";
                break;
            case 11: label = "J";
                break;
            case 12: label = "Q";
                break;
            case 13: label = "K";
                break;
            case 14: label = "A";
                break;
            case 15: label = "RED JOKER";
                break;
            case 16: label = "BLACK JOKER";
                break;
        }

        switch ( suit ) {

            case 0: label = label + " of hearth";
                    break;
            case 1: label = label + " of diamonds";
                    break;
            case 2: label = label + " of clubs";
                    break;
            case 3: label = label + " of spades";
                    break;
            case 4: break;
        }
    }
}
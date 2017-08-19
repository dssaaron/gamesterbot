package com.homedev.bot;

public class Deck {

    private int cardAmount;
    private Card[] card;

    Deck ( int amount ) {

        cardAmount = amount;
        System.out.print( "CREATING DECK\n" );

        card = new Card[54];

        int k = 0;
        for( int i = 2; i < 15; i++ ) {

            for( int j = 0; j < 4; j++ ) {

                card[ k ] = new Card( i, j );
                k++;
            }

        }

        card[ 52 ] = new Card( 15, 4);
        card[ 53 ] = new Card( 16, 4);

        if ( amount == 36) {
            for ( int l = 0; l < 17; l++ ) {

                card[ l ].setAvailability( false );
            }

            card[ 52 ].setAvailability( false );
            card[ 53 ].setAvailability( false );
        }
    }

    void showDeck( ) {

        System.out.println( cardAmount );

        for ( int k = 0; k < 54; k++ ) {

            if ( card[ k ].isAvailable( ) ) {
                System.out.println(card[k].showLabel());
            }
        }
    }
}

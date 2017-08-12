package com.homedev.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;

public class GamesterBot {

    public static void main( String[] argc ) {

        TelegramBot bot = TelegramBotAdapter.build( "404808549:AAEQGg_6K4W3JiDor3MIXCJOldYmLqV1sLw" );

        System.out.print( "STARTING BOT\n" );
        Deck deck = new Deck( 36 );
        deck.ShowDeck( );
    }
}

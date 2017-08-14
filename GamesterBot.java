package com.homedev.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetMe;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.util.List;

public class GamesterBot {

    static final String BOT_TOKEN = "404808549:AAEQGg_6K4W3JiDor3MIXCJOldYmLqV1sLw";

    static TelegramBot bot = TelegramBotAdapter.build( BOT_TOKEN );

    private static List<Update> GetUpdateList(int timeout, int offset) {

        GetUpdates getUpdates = new GetUpdates().limit(5).offset(offset).timeout( timeout );
        GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
        List<Update> updates = updatesResponse.updates();
        return  updates;
    }

    public static void main( String[] argc ) {

        System.out.print( "STARTING BOT\n" );
        //TelegramBot bot = TelegramBotAdapter.build( BOT_TOKEN );

        //Getting the last worked update
        //We need this to initialize getting message serviceß
        int lastProcessedUpdateId;

        //Getting old updates
        List<Update> updates = GetUpdateList( 1, 0 );

        //size of update's list
        int sizeOfUpdates = updates.size();

        //Setting the last update as worked
        if ( sizeOfUpdates > 0 ) {

            lastProcessedUpdateId = updates.get(sizeOfUpdates - 1).updateId();
            System.out.printf("Last processed update id: %s\n", lastProcessedUpdateId);
        } else {

            lastProcessedUpdateId = 0;
        }

        //here we have bug in which there is infinite loop of first
        //message if there were none of messages before bot started
        do {

            updates = GetUpdateList( 1, lastProcessedUpdateId + 1 );
            sizeOfUpdates = updates.size();
            if ( sizeOfUpdates > 0 ) {

                for ( int iUpdate = 0; iUpdate < sizeOfUpdates; iUpdate++ ) {

                    String message = updates.get( iUpdate ).message( ).text( ).toString( );
                    lastProcessedUpdateId = updates.get( iUpdate ).updateId( );

                    //System.out.println( updates.get( iUpdate ) );
                    System.out.println( message );

                    //trying to resend back message
                    long chatId = updates.get( iUpdate ).message( ).chat( ).id( );
                    SendMessage request = new SendMessage( chatId, message );
                }
            }
        } while ( true );

        //System.out.print( getUpdates );
        //Deck deck = new Deck( 36 );
        //deck.ShowDeck( );
    }
}

package com.homedev.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
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

    //private int[][] chat;

    static int lastProcessedUpdateId;

    static List<Update> updates;
    static int sizeOfUpdates;

    public static void main( String[] argc ) {

        initBot( );
        messageProcessing( );

    }

    static void initBot( ) {

        System.out.print( "STARTING BOT\n" );

        //Getting the last worked update:
        //Getting old updates
        updates = GetUpdateList( 1, 0 );

        //size of update's list
        sizeOfUpdates = updates.size();

        //Setting the last update as worked
        if ( sizeOfUpdates > 0 ) {

            lastProcessedUpdateId = updates.get(sizeOfUpdates - 1).updateId();
            System.out.printf("Last processed update id: %s\n", lastProcessedUpdateId);
        } else {

            lastProcessedUpdateId = 0;
        }
    }

    static void messageProcessing( ) {

        do {

            updates = GetUpdateList( 1, lastProcessedUpdateId + 1 );
            sizeOfUpdates = updates.size();
            if ( sizeOfUpdates > 0 ) {

                for ( int iUpdate = 0; iUpdate < sizeOfUpdates; iUpdate++ ) {

                    String message = updates.get( iUpdate ).message( ).text( );
                    lastProcessedUpdateId = updates.get( iUpdate ).updateId( );

                    long senderId = updates.get( iUpdate ).message( ).chat( ).id( );

                    //message logs
                    System.out.printf( "%d : %s\n", senderId, message );

                    if ( checkUserPosition( senderId ) ) {

                        mainMenuProcessing( senderId );

                    } else {

                        inGameProcessing( senderId );
                    }

                    //trying if user is in main menu or in room process in different ways

                }
            }
        } while ( true );
    }

    //true = mainmenu; false = ingame
    static boolean checkUserPosition( long senderId ){

        return false;
    }

    static void mainMenuProcessing( long senderId ) {

        SendMessage message = new SendMessage( senderId, "UR IN MAIN MENU" );
        bot.execute( message );
    }

    static void inGameProcessing( long senderId ) {

        SendMessage message = new SendMessage( senderId, "UR IN A GAME" );
        bot.execute( message );
    }

    //for future savings of user data
    static void saveData( ) {}

    private static List<Update> GetUpdateList(int timeout, int offset) {

        GetUpdates getUpdates = new GetUpdates().limit(5).offset(offset).timeout( timeout );
        GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
        return  updatesResponse.updates();
    }
}

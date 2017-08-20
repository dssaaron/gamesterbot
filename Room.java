package com.homedev.bot;

import java.util.List;

//Class of room in which a game can run
public class Room {

    private int roomId;
    private List<Player> players;
    private GameTimer timer;
    private boolean gameIsOn;

    Room( int roomId, List<Player> newPlayers ) {

        this.gameIsOn = false;

        this.roomId = roomId;

        for ( int i = 0; i < newPlayers.size( ); i++ ) {
            players.add( newPlayers.get( i ) );
        }
    }

    void startGame( ) {

        this.gameIsOn = true;
        this.timer.setGameStartTime();
        this.timer.setRoundStartTime();
    }

    private String showRoomInfo( ) {

        String logString = "Room N" + roomId + " info\n";

        for ( int i = 0; i < players.size( ); i++ ) {

            logString += players.get( i ).toString( );
        }

        return logString;
    }
}

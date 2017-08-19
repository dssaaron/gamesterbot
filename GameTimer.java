package com.homedev.bot;

public class GameTimer {

    //everything in milliseconds
    private long gameStartTime;
    private long roundStartTime;


    void setGameStartTime( ) {

        gameStartTime = System.currentTimeMillis( );
    }


    void setRoundStartTime( ) {

        roundStartTime = System.currentTimeMillis( );
    }


    long getRoundTime( ) {

        return System.currentTimeMillis( ) - roundStartTime;
    }

}

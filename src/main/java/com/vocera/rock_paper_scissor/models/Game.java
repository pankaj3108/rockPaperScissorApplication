package com.vocera.rock_paper_scissor.models;

public class Game {

    private String userToken;
    private int yourScore;
    private int serverScore;
    private String serverMove;
    private boolean gameFinished;

    public Game() {

    }

    public Game(String userToken) {
        this.userToken = userToken;
        this.yourScore = 0;
        this.serverScore = 0;
        this.serverMove = null;
        this.gameFinished = false;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public int getYourScore() {
        return yourScore;
    }

    public void setYourScore(int yourScore) {
        this.yourScore = yourScore;
    }

    public int getServerScore() {
        return serverScore;
    }

    public void setServerScore(int serverScore) {
        this.serverScore = serverScore;
    }

    public String getServerMove() {
        return serverMove;
    }

    public void setServerMove(String serverMove) {
        this.serverMove = serverMove;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
}

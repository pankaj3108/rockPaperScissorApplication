package com.vocera.rock_paper_scissor.util;

import com.vocera.rock_paper_scissor.models.Game;

public class GameApiResponse {
    private String status;
    private Game game;

    public GameApiResponse(String status, Game game) {
        this.status = status;
        this.game = game;
    }

    public String getStatus() {
        return status;
    }

    public Game getGame() {
        return game;
    }


}

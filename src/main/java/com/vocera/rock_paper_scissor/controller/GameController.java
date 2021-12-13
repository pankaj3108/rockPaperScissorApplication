package com.vocera.rock_paper_scissor.controller;

import com.vocera.rock_paper_scissor.Exceptions.AuthenticationException;
import com.vocera.rock_paper_scissor.Exceptions.UserMoveException;
import com.vocera.rock_paper_scissor.models.Game;
import com.vocera.rock_paper_scissor.service.AuthenticationTokenService;
import com.vocera.rock_paper_scissor.service.GameService;
import com.vocera.rock_paper_scissor.util.ApiResponse;
import com.vocera.rock_paper_scissor.util.GameApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GameController {

    @Autowired
    private AuthenticationTokenService authenticationTokenService;

    @Autowired
    private GameService gameService;

    @RequestMapping("/start")
    public ResponseEntity<ApiResponse> startGame() {

        String token = this.authenticationTokenService.createToken();

        this.gameService.createGameEnvironment(token);

        return new ResponseEntity<ApiResponse>(new ApiResponse("READY", token), HttpStatus.CREATED);

    }

    @GetMapping("/v1/{token}/{value}")
    public ResponseEntity<GameApiResponse> takeHandGesture(@PathVariable("token") String token, @PathVariable("value") String value) throws AuthenticationException, UserMoveException {

        Game game = this.gameService.currentTurnResult(token, value.toUpperCase());

        GameApiResponse gameApiResponse = null;

        if(game.isGameFinished())
            gameApiResponse = new GameApiResponse("The Game is finished", game);
        else
            gameApiResponse = new GameApiResponse("The game is in progress", game);

        return new ResponseEntity<GameApiResponse>(gameApiResponse, HttpStatus.OK);

    }

}

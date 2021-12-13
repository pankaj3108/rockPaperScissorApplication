package com.vocera.rock_paper_scissor.service;

import com.vocera.rock_paper_scissor.Exceptions.AuthenticationException;
import com.vocera.rock_paper_scissor.Exceptions.UserMoveException;
import com.vocera.rock_paper_scissor.enums.Move;
import com.vocera.rock_paper_scissor.models.AuthenticationToken;
import com.vocera.rock_paper_scissor.models.Game;
import com.vocera.rock_paper_scissor.repository.AuthenticationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class GameService {

    private Game game;
    private static Random random = new Random();

    @Autowired
    private AuthenticationTokenRepository authenticationTokenRepository;

    private void createGame(String token) {
        this.game = new Game(token);
    }

    public void createGameEnvironment(String token) {

        createGame(token);

    }

    private String findServerChoice() {

        String serverChoice = null;

        int input = random.nextInt(3)+1;

        if(input == 1)
            serverChoice = Move.ROCK.name();
        else if(input == 2)
            serverChoice = Move.PAPER.name();
        else
            serverChoice = Move.SCISSORS.name();

        return serverChoice;
    }

    private int findTheWinner(String serverChoice, String value) {

        if(serverChoice.equals(value))
            return -1;
        else if(value.equals(Move.ROCK.name())) {
            if(serverChoice.equals(Move.PAPER.name()))
                return 1;
            else
                return 0;
        }
        else if(value.equals(Move.PAPER.name())) {
            if(serverChoice.equals(Move.SCISSORS.name()))
                return 1;
            else
                return 0;
        }
        else {
            if(serverChoice.equals(Move.ROCK.name()))
                return 1;
            else
                return 0;
        }

    }

    public Game currentTurnResult(String token, String value) throws AuthenticationException, UserMoveException {

        Optional<AuthenticationToken> auth = this.authenticationTokenRepository.findByToken(token);

        if(!auth.isPresent()) {
            throw new AuthenticationException("Token is not valid");
        }

        if(!value.equals(Move.ROCK.name()) && !value.equals(Move.PAPER.name()) && !value.equals(Move.SCISSORS.name()))
            throw new UserMoveException("Move is not valid");

        if(game.isGameFinished())
            createGameEnvironment(token);

        String serverChoice = findServerChoice();

        int res = findTheWinner(serverChoice, value);

        game.setServerMove(serverChoice);

        if(res == 0) {
            game.setYourScore(game.getYourScore()+1);
        }
        else if(res == 1)
            game.setServerScore(game.getServerScore()+1);

        if(game.getServerScore() == 3 || game.getYourScore() == 3)
            game.setGameFinished(true);

        return game;

    }

}

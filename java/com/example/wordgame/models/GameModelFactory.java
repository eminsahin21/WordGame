package com.example.wordgame.models;

import com.example.wordgame.presenters.GameModel;

public class GameModelFactory {

    private GameModelFactory() {
    }

    public static GameModel newGameModel(GameType gameType) {
        switch (gameType) {
            case WORDGAME:
                return new WordGameModel();
            default:
                return null;
        }
    }

}

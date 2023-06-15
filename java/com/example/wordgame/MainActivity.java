package com.example.wordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.wordgame.models.GameModelFactory;
import com.example.wordgame.models.GameType;
import com.example.wordgame.presenters.GamePresenter;
import com.example.wordgame.views.GameFrame;
import com.example.wordgame.views.GameViewFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameFrame gameFrame = findViewById(R.id.game_container);
        TextView gameScoreText = findViewById(R.id.game_score);
        TextView gameStatusText = findViewById(R.id.game_status);
        Button gameCtlBtn = findViewById(R.id.game_ctl_btn);

        GamePresenter gamePresenter = new GamePresenter();
        gamePresenter.setGameModel(GameModelFactory.newGameModel(GameType.WORDGAME));
        gamePresenter.setGameView(GameViewFactory.newGameView(gameFrame, gameScoreText, gameStatusText, gameCtlBtn));

        gameCtlBtn.setOnClickListener(v -> gamePresenter.changeStatus());

        gamePresenter.init();


    }
}
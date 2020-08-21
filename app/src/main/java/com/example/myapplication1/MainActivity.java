package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
    int activePLayer = 0;
    int []gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                         {0,3,6}, {1,4,7}, {2,5,8},
                         {0,4,8}, {2,4,6}};
    public void playerTap(View view){

        ImageView img = (ImageView) view;
        int tappedImg  = Integer.parseInt(img.getTag().toString());

        if (gameState[tappedImg] == 2 && gameActive){

            gameState[tappedImg] = activePLayer;
            img.setTranslationY(-1000f);

            if (!gameActive){
                gameReset (view);
            }
            if (activePLayer == 0){
                activePLayer = 1;
                img.setImageResource(R.drawable.x);
                TextView status = findViewById(R.id.status);
                status.setText("o turn to Play");
            }else {

                activePLayer = 0;
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.status);
                status.setText("x turn to Play");
            }

            img.animate().translationYBy(1000f).setDuration(100);

        }
        for (int[] winPosition : winPositions){

            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2){

                    String winStr;
                    gameActive = false;

                if (gameState[winPosition[0]] == 0){

                    winStr = "x is  win";
                }else {

                    winStr = "o is win";

                }
                TextView status = findViewById(R.id.status);
                status.setText(winStr);

            }
        }

    }

    public void gameReset (View view){

        gameActive = true;
        activePLayer =  0 ;
        for (int i=0; i<gameState.length; i++)
        {
            gameState[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


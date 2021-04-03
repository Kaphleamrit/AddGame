package com.example.mathstester;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class startActivity extends AppCompatActivity {
TextView timerView;
TextView scoreView;
TextView done;
Button playAgain;
int a;
int b;
TextView addView;
Button b1 ;
Button b2 ;
Button b3;
Button b4;
int buttonRandom;
int score;
int totalQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        timerView = (TextView) findViewById(R.id.timerView);
        done = (TextView) findViewById(R.id.doneView);
        playAgain = (Button) findViewById(R.id.playAgain);
        addView = (TextView) findViewById(R.id.addView);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        controller();

        timer();

    }

    public void timer() {

        new CountDownTimer(30000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                int time = (int) millisUntilFinished/1000 ;
                timerView.setText(time + "");
            }

            @Override
            public void onFinish() {
                timerView.setText("Time up");
                done.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
            }
        }.start();
    }

    public void controller() {
        Button[] btnArr = {b1,b2,b3,b4};

        buttonRandom =  (int) (Math.random()*4);

        a =(int) (Math.random()*100);
        b =(int) (Math.random()*100);
        int ans = a + b;

        addView.setText(a + " + " + b);



        for (Button b : btnArr) {
            if (Integer.parseInt(b.getTag().toString()) == buttonRandom) b.setText(ans +"");
            else b.setText((int)(Math.random() * 200) + "");
        }
    }

    public void ansClick(View view) {
        Button b = (Button) view;
        scoreView = (TextView) findViewById(R.id.scoreView);
        if(Integer.parseInt(b.getTag().toString()) == buttonRandom ) {
            score++;
            totalQ++;
        }
        else totalQ++;
        scoreView.setText(score + "/" + totalQ);
        controller();


    }

    public void playAgain(View view) {
        score = 0;
        totalQ =0;
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        scoreView.setText("0/0");
        done.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        timer();
        controller();

    }

}
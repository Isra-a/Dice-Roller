package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;


import android.opengl.Visibility;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private ImageView dice1,dice2,dice3;
    private ImageButton imageButton;
    private Random random=new Random();
    private int [] diceArray={
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button RollButton;
        RollButton=(Button)findViewById(R.id.action_roll);
        dice1=findViewById(R.id.dice1);
        dice2=findViewById(R.id.dice2);
        dice3=findViewById(R.id.dice3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }
    public void onClick(MenuItem item ){

        Log.d("MenuItem", "onClick :: "+item.getItemId());
        CountDownTimer timer = new CountDownTimer(2000, 100) {
            public void onTick(long millisUntilFinished) {
                findViewById(R.id.action_stop).setAlpha(1);
                Random RandomGenerator = new Random();
                int nbre = RandomGenerator.nextInt(6);
                dice1.setImageResource(diceArray[nbre]);
                nbre = RandomGenerator.nextInt(6);
                dice2.setImageResource(diceArray[nbre]);
                nbre = RandomGenerator.nextInt(6);
                dice3.setImageResource(diceArray[nbre]);
            }
            public void onFinish() {
                findViewById(R.id.action_stop).setAlpha(0);
            }
        };
        timer.start();
    }
    public void stop(MenuItem item){
        Random RandomGenerator = new Random();
        int nbre = RandomGenerator.nextInt(6);
        dice1.setImageResource(diceArray[nbre]);
        nbre = RandomGenerator.nextInt(6);
        dice2.setImageResource(diceArray[nbre]);
        nbre = RandomGenerator.nextInt(6);
        dice3.setImageResource(diceArray[nbre]);
    }


    public void onOne(MenuItem item){
        findViewById(R.id.dice1).setAlpha(0);
        findViewById(R.id.dice3).setAlpha(0);
    }
    public void onTwo(MenuItem item){
        findViewById(R.id.dice1).setAlpha(1);
        findViewById(R.id.dice2).setAlpha(1);
        findViewById(R.id.dice3).setAlpha(0);
    }
    public void onThree(MenuItem item){
        findViewById(R.id.dice1).setAlpha(1);
        findViewById(R.id.dice2).setAlpha(1);
        findViewById(R.id.dice3).setAlpha(1);
    }



}



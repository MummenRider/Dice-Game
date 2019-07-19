package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView left_dice,right_dice;
    int[] diceArray = {  R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();

        buttonClickListener();

    }

    private void buttonClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Dice", "onClick:  Button pressed.");

                Random ranNumGen = new Random();
                int number_one = ranNumGen.nextInt(6);
                int number_two = ranNumGen.nextInt(6);

                Log.d("Dice", "onClick:The left dice number is: " +number_one);
                left_dice.setImageResource(diceArray[number_one]);
                Log.d("Dice", "onClick:The right dice number is: " +number_two);
                right_dice.setImageResource(diceArray[number_two]);

                if(number_one == number_two){
                    Toast.makeText(MainActivity.this,"CONGRATS!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initWidgets() {
        button = findViewById(R.id.btn_roll);
        left_dice = findViewById(R.id.diceone);
        right_dice = findViewById(R.id.dicetwo);
    }
}

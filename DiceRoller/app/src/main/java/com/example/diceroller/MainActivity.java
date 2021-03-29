package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageView leftDice;
    private ImageView rightDice;
    private Button rollmyDice;
    private Random myRandomNumber = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  imageViewDicy = findViewById(R.id.imageView);
        leftDice = findViewById(R.id.imageViewLeft);
        rightDice = findViewById(R.id.imageViewRight);
        rollmyDice = findViewById(R.id.rollDice);

        rollmyDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  RollLeftDice();
                  RollRightDice();
            }
        });
        /*imageViewDicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RollDice();

            }
        });*/
    }
        private void RollLeftDice()
        {
            int myRanNumber = myRandomNumber.nextInt(6)+1;
            switch(myRanNumber)
            {
                case 1:
                    leftDice.setImageResource(R.drawable.dice1);

                   // imageViewDicy.setImageResource(R.drawable.dice1);
                    break;
                case 2:
                    leftDice.setImageResource(R.drawable.dice2);

                    //imageViewDicy.setImageResource(R.drawable.dice2);
                    break;

                case 3:
                    leftDice.setImageResource(R.drawable.dice3);

                    //imageViewDicy.setImageResource(R.drawable.dice3);
                    break;

                case 4:
                    leftDice.setImageResource(R.drawable.dice4);
                    //imageViewDicy.setImageResource(R.drawable.dice4);
                    break;

                case 5:
                    leftDice.setImageResource(R.drawable.dice5);
                    //imageViewDicy.setImageResource(R.drawable.dice5);
                    break;
                case 6:
                    leftDice.setImageResource(R.drawable.dice6);
                   // imageViewDicy.setImageResource(R.drawable.dice6);
                    break;

                default:

            }

        }
    private void RollRightDice()
    {
        int myRanNumber = myRandomNumber.nextInt(6)+1;
        switch(myRanNumber)
        {
            case 1:

                rightDice.setImageResource(R.drawable.dice1);
                // imageViewDicy.setImageResource(R.drawable.dice1);
                break;
            case 2:

                rightDice.setImageResource(R.drawable.dice2);
                //imageViewDicy.setImageResource(R.drawable.dice2);
                break;

            case 3:

                rightDice.setImageResource(R.drawable.dice3);
                //imageViewDicy.setImageResource(R.drawable.dice3);
                break;

            case 4:
                rightDice.setImageResource(R.drawable.dice4);
                //imageViewDicy.setImageResource(R.drawable.dice4);
                break;

            case 5:
                rightDice.setImageResource(R.drawable.dice5);
                //imageViewDicy.setImageResource(R.drawable.dice5);
                break;
            case 6:
                rightDice.setImageResource(R.drawable.dice6);
                // imageViewDicy.setImageResource(R.drawable.dice6);
                break;

            default:

        }

    }

}
package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView textView3, text_view;
    Button butt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text_view = findViewById(R.id.text_view);
        textView3 = findViewById(R.id.textView3);
        butt = findViewById(R.id.button);

//        Receiving Intent

        Intent i = getIntent();
        String inputName = i.getStringExtra("name");

//        Storing the random Number:
        int random_num = generateRandom();
        text_view.setText(""+random_num);

//        Sharing Results:

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareData(inputName, random_num);//method shareData declared below.
            }
        });





    }

    public int generateRandom(){
        Random random = new Random();
        int upperLimit = 1000; //The random nos generated will be from 0 to 1000
        int randomNumberGenerated = random.nextInt(upperLimit); //we save the random number generated in a local variable
        return randomNumberGenerated; //the method returns the random number generated
    }

    public void shareData(String inputName, int random_num){
        Intent i = new Intent(Intent.ACTION_SEND);
//        ACTION_SEND is to send the data in the implicit intent to the other apps

        i.setType("text/plain");
//      setType signifies the type of text we are sending to the other apps

        i.putExtra(Intent.EXTRA_SUBJECT,inputName+" got lucky today!");
//        Extra_subject creates a subject as in the case of emails with the text passed

        i.putExtra(Intent.EXTRA_TEXT, inputName + "'s"+" lucky number is: "+random_num);
//        Extra_text send the additional text like body along with the subject

//        Create multiple platforms to choose from when the activity is started
        startActivity(Intent.createChooser(i,"Choose a Platform to Share Your Results"));
    }
}
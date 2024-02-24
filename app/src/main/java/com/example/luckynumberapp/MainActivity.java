package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;


    EditText edit_text;

    ImageView dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        edit_text = findViewById(R.id.edit_text);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        dice = findViewById(R.id.dice);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = edit_text.getText().toString();

//                Expicit intent

                Intent i = new Intent(getApplicationContext(),SecondActivity.class);
//               Sharing the inputName field with Second activity
                i.putExtra("name", inputName);

                startActivity(i);

            }
        });



    }
}
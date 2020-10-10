package com.example.labassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        btnBack = findViewById(R.id.backbtn);

        textView1.setText("Number 1: " + intent.getStringExtra("number1"));
        textView2.setText("Number 2: " + intent.getStringExtra("number2"));
        textView3.setText("Number 3: " + intent.getStringExtra("number3"));
        textView4.setText("Sum: " + intent.getStringExtra("sum"));

        btnBack.setOnClickListener((View v) -> {
            Intent intentBack = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intentBack);
        });
    }
}





















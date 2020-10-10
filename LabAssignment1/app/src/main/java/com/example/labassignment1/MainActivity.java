package com.example.labassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    Button sumBtn;
    EditText edtxt1,edtxt2,edtxt3;
    int num1 = 0,num2 = 0,num3 = 0,sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumBtn=findViewById(R.id.btnsum);
        edtxt1=findViewById(R.id.editTextNumber);
        edtxt2=findViewById(R.id.editTextNumber2);
        edtxt3=findViewById(R.id.editTextNumber3);

        try {
            num1 = Integer.parseInt(edtxt1.getText().toString(), 16);
            num2 = Integer.parseInt(edtxt2.getText().toString(), 16);
            num3 = Integer.parseInt(edtxt3.getText().toString(), 16);
        }catch (NumberFormatException nfe){
            System.out.println("Could not parse " + nfe);
        }
        sum = num1 + num2 + num3;

        sumBtn.setOnClickListener((view) ->  {
            Toast.makeText(MainActivity.this,"Test" + sum,Toast.LENGTH_LONG).show();
        });


    }
}
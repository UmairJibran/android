package com.example.labassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    Button sumBtn;
    EditText editText1,editText2, editText3;
    int num1 = 0,num2 = 0,num3 = 0,sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumBtn=findViewById(R.id.btnsum);
        editText1 =findViewById(R.id.editTextNumber);
        editText2=findViewById(R.id.editTextNumber2);
        editText3 =findViewById(R.id.editTextNumber3);


        sumBtn.setOnClickListener((view) ->  {
            try {
                num1 = Integer.parseInt(editText1.getText().toString(), 10);
                num2 = Integer.parseInt(editText2.getText().toString(), 10);
                num3 = Integer.parseInt(editText3.getText().toString(), 10);
            }catch (NumberFormatException nfe){
                System.out.println("Could not parse " + nfe);
            }
            sum = num1 + num2 + num3;

            Toast.makeText(MainActivity.this,""+sum,Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("number1",""+num1);
            intent.putExtra("number2",""+num2);
            intent.putExtra("number3",""+num3);
            intent.putExtra("sum",""+sum);
            startActivity(intent);
        });


    }
}
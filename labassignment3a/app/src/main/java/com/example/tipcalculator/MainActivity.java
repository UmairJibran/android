package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    EditText bill, percentageOf;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.calculateButton);
        bill = findViewById(R.id.bill);
        percentageOf = findViewById(R.id.percentageOf);
        result = findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float billF = parseFloat(bill.getText().toString());
                float percentageF = parseFloat(percentageOf.getText().toString());
                result.setText((percentageF / 100 * billF) + "");
            }
        });

    }
}
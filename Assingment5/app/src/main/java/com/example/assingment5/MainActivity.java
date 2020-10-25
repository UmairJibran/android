package com.example.assingment5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    String[] matrixItem = {"Weight","Time","Length","Temperature"};
    String[][] matrixSubItem = {{"g","kg","lb","oz"},{"sec","min","hr"},{"m","km","ft","M"},{"C","F","K"}};
    String calcFrom,calcTo;
    Spinner matrixSpinner,toConvertFromSpinner,toConvertToSpinner;
    int result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrixSpinner = (Spinner) findViewById(R.id.matrixSpinner);
        toConvertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        toConvertToSpinner = (Spinner) findViewById(R.id.convertToSpinner);

        final ArrayAdapter<String> arrayAdapterForMatrixSpinner = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,matrixItem);
        arrayAdapterForMatrixSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        matrixSpinner.setAdapter(arrayAdapterForMatrixSpinner);

        matrixSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String[] selectedMatrix= matrixSubItem[position];
                final ArrayAdapter<String> arrayAdapterForToConvertFromSpinner = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,matrixSubItem[position]);
                final ArrayAdapter<String> arrayAdapterForToConvertToSpinner = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,selectedMatrix);
                arrayAdapterForToConvertFromSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                arrayAdapterForToConvertToSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                toConvertFromSpinner.setAdapter(arrayAdapterForToConvertFromSpinner);
                toConvertToSpinner.setAdapter(arrayAdapterForToConvertToSpinner);

                toConvertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        calcFrom = selectedMatrix[position];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
                toConvertToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        calcTo = selectedMatrix[position];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        ImageButton calculate = (ImageButton) findViewById(R.id.imageButton);
        final TextView finalResult = (TextView) findViewById(R.id.finalResult);
        final EditText convertThis = (EditText) findViewById(R.id.convertThisNumber);
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (calcFrom){
                    case "g":{ //{"g","kg","lb","oz"}
                        switch (calcTo){
                            case "kg":{
                                result = Integer.parseInt(String.valueOf(convertThis),10) / 1000;
                            }
                        }
                        break;
                    }
                    case "kg":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "lb":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "oz":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "sec":{ //{"sec","min","hr"}
                        switch (calcTo){

                        }
                        break;
                    }
                    case "min":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "hr":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "m":{ //{"m","km","ft","M"}
                        switch (calcTo){

                        }
                        break;
                    }
                    case "km":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "ft":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "M":{
                        switch (calcTo){

                        }
                        break;
                    }

                    case "C":{ //{"C","F","K"}
                        switch (calcTo){

                        }
                        break;
                    }
                    case "F":{
                        switch (calcTo){

                        }
                        break;
                    }
                    case "K":{
                        switch (calcTo){

                        }
                        break;
                    }
                }
                String finResult = result + " " + calcTo;
                finalResult.setText(finResult);
//                finalResult.setText(""+result+" "+calcTo);
            }
        });

    }

}
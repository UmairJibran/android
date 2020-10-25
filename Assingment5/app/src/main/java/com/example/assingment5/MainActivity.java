package com.example.assingment5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    String[] matrixItem = {"Weight","Time","Length","Temperature"};
    String[][] matrixSubItem = {{"g","kg","lb","oz"},{"sec","min","hr"},{"m","km","ft","M"},{"C","F","K"}};
    String calcFrom,calcTo;
    Spinner matrixSpinner,toConvertFromSpinner,toConvertToSpinner;
    float inputNumber = 0,result = 0;
    EditText convertThis;
    TextView finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton calculate = findViewById(R.id.imageButton);
        finalResult = findViewById(R.id.finalResult);
        matrixSpinner = findViewById(R.id.matrixSpinner);
        toConvertFromSpinner = findViewById(R.id.convertFromSpinner);
        toConvertToSpinner = findViewById(R.id.convertToSpinner);

        final ArrayAdapter<String> arrayAdapterForMatrixSpinner = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,matrixItem);
        arrayAdapterForMatrixSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        matrixSpinner.setAdapter(arrayAdapterForMatrixSpinner);

        matrixSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String[] selectedMatrix= matrixSubItem[position];
                final ArrayAdapter<String> arrayAdapterForToConvertFromSpinner = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_item,matrixSubItem[position]);
                final ArrayAdapter<String> arrayAdapterForToConvertToSpinner = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_item,selectedMatrix);
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
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                convertThis = findViewById(R.id.convertThisNumber);
                try {
                    inputNumber = Float.parseFloat(convertThis.getText().toString());
                }catch (NumberFormatException nfe){
                    System.out.println("Could not parse " + nfe);
                }
                switch (calcFrom){
                    case "g":{ //{"g","kg","lb","oz"}
                        switch (calcTo){
                            case "kg":{
                                result = (float) (inputNumber * 0.001);
                                break;
                            }
                            case "lb":{
                                result = (float) (inputNumber * 0.00220462);
                                break;
                            }
                            case "oz":{
                                result = (float) (inputNumber * 0.03527396);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "kg":{
                        switch (calcTo){
                            case "g":{
                                result = (inputNumber * 1000);
                                break;
                            }
                            case "lb":{
                                result = (float) (inputNumber * 2.20462262);
                                break;
                            }
                            case "oz":{
                                result = (float) (inputNumber * 35.273962);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "lb":{
                        switch (calcTo){
                            case "g":{
                                result = (float) (inputNumber * 453.59237);
                                break;
                            }
                            case "kg":{
                                result = (float) (inputNumber * 0.45359237);
                                break;
                            }
                            case "oz":{
                                result = (inputNumber * 16);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "oz":{
                        switch (calcTo){
                            case "g":{
                                result = (float) (inputNumber * 28.3495231);
                                break;
                            }
                            case "kg":{
                                result = (float) (inputNumber * 0.02834952);
                                break;
                            }
                            case "lb":{
                                result = (float) (inputNumber * 0.0625);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "sec":{ //{"sec","min","hr"}
                        switch (calcTo){
                            case "min":{
                                result = (float) (inputNumber * 0.01666667);
                                break;
                            }
                            case "hr":{
                                result = (float) (inputNumber * 0.00027778);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "min":{
                        switch (calcTo){
                            case "sec":{
                                result = (inputNumber * 60);
                                break;
                            }
                            case "hr":{
                                result = (float) (inputNumber * 0.01666667);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "hr":{
                        switch (calcTo){
                            case "sec":{
                                result = (inputNumber * 3600);
                                break;
                            }
                            case "min":{
                                result = (inputNumber * 60);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "m":{ //{"m","km","ft","M"}
                        switch (calcTo){
                            case "km":{
                                result = (float) (inputNumber * 0.001);
                                break;
                            }
                            case "ft":{
                                result = (float) (inputNumber * 3.2808399);
                                break;
                            }
                            case "M":{
                                result = (float) (inputNumber * 0.00062137);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "km":{
                        switch (calcTo){
                            case "m":{
                                result = (inputNumber * 1000);
                                break;
                            }
                            case "ft":{
                                result = (float) (inputNumber * 3280.8399);
                                break;
                            }
                            case "M":{
                                result = (float) (inputNumber * 0.62137119);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "ft":{
                        switch (calcTo){
                            case "m":{
                                result = (float) (inputNumber * 0.3048);
                                break;
                            }
                            case "km":{
                                result = (float) (inputNumber * 0.0003048);
                                break;
                            }
                            case "M":{
                                result = (float) (inputNumber * 0.00018939);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "M":{
                        switch (calcTo){
                            case "m":{
                                result = (float) (inputNumber * 1609.344);
                                break;
                            }
                            case "km":{
                                result = (float) (inputNumber * 1.609344);
                                break;
                            }
                            case "ft":{
                                result = inputNumber * 5280;
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }

                    case "C":{ //{"C","F","K"}
                        switch (calcTo){
                            case "F":{
                                result = (float) (inputNumber * 33.8);
                                break;
                            }
                            case "K":{
                                result = (float) (inputNumber * 274.15);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "F":{
                        switch (calcTo){
                            case "C":{
                                result = (float) (inputNumber * -17.2222222);
                                break;
                            }
                            case "K":{
                                result = (float) (inputNumber * 255.927778);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                    case "K":{
                        switch (calcTo){
                            case "C":{
                                result = (float) (inputNumber * -272.15);
                                break;
                            }
                            case "F":{
                                result = (float) (inputNumber * -457.87);
                                break;
                            }
                            default:{
                                result = inputNumber;
                            }
                        }
                        break;
                    }
                }
                String finResult = result + " " + calcTo;
                finalResult.setText(finResult);
            }
        });
    }
}
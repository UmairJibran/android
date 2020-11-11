package com.example.assignment7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,calc;
    TextView td,tm,ty;
    DatePickerDialog.OnDateSetListener ds1,ds2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        calc = findViewById(R.id.calc);
        td = findViewById(R.id.td);
        tm = findViewById(R.id.tm);
        ty = findViewById(R.id.ty);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(Calendar.getInstance().getTime());
        btn2.setText(date);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,android.R.style.Theme_Black, ds1,year,month,day //here
                );
                datePickerDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT)
                );
                datePickerDialog.show();
            }
        });

        ds1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear+=1;
                String date = day + "/" + monthOfYear + "/"+ year;
                btn1.setText(date);
            }
        };

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,android.R.style.Theme_Black,ds2,year,month,day //here
                );
                datePickerDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT)
                );
                datePickerDialog.show();
            }
        });

        ds2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear+=1;
                String date = day + "/" + monthOfYear + "/"+ year;
                btn2.setText(date);
            }
        };

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String today = btn2.getText().toString();
                String birthDate = btn1.getText().toString();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
            try{
                Date date1 = simpleDateFormat1.parse(today);
                Date date2 = simpleDateFormat1.parse(birthDate);

                long startDate = date1.getTime();
                long endDate = date2.getTime();
                if(startDate >= endDate){
                    Period period = new Period(startDate, endDate, PeriodType.yearMonthDay());
                    int years = period.getYears();
                    int months = period.getMonths();
                    int days = period.getDays();

                    td.setText("Days: " + days);
                    tm.setText("Months: " + months);
                    ty.setText("Years: " + years);
                }else{
                    Toast.makeText(MainActivity.this, "Birthdate should be greater than today's date", Toast.LENGTH_SHORT).show();
                }
            }catch (ParseException pe){
                pe.printStackTrace();
            }
            }
        });
    }
}
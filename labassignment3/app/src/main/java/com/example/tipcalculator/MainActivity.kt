package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val increaseButton = findViewById<Button>(R.id.increasePercentage)
        val decreaseButton = findViewById<Button>(R.id.decreasePercentage)
        val percentageOf = findViewById<EditText>(R.id.percentageOf)
        val bill = findViewById<EditText>(R.id.bill)
        val total = findViewById<TextView>(R.id.result)
        calculateButton.setOnClickListener {
            val percentage = percentageOf.text.toString().toFloat()
            val totalBill = bill.text.toString().toFloat()
            total.text = percentage.toString() + "% of " +  totalBill.toString() + " is " + (percentage / 100 * totalBill).toString()
        }
        increaseButton.setOnClickListener{
            val percentage = percentageOf.text.toString().toFloat()
            val totalBill = bill.text.toString().toFloat()
            total.text = percentage.toString() + "% increase in " +  totalBill.toString() + " is " + ((percentage / 100 * totalBill) + totalBill)
        }
        decreaseButton.setOnClickListener{
            val percentage = percentageOf.text.toString().toFloat()
            val totalBill = bill.text.toString().toFloat()
            total.text = percentage.toString() + "% decrease in " +  totalBill.toString() + " is " +(totalBill - (percentage / 100 * totalBill))
        }
    }
}
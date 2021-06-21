package com.samiparken.android_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentValue: Double = 0.0
    var isInteger = false
    var isEmpty = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        Toast.makeText(this, "Digit", Toast.LENGTH_SHORT).show()
        tvInput.append((view as Button).text)
        if (isEmpty) {
            isInteger = true
            isEmpty = false
        }
    }

    fun onOperator(view: View){
        val operator = (view as Button).text
        val inputValue: String = tvInput.text.toString()

        if( operator == "+/-") {
            when(isInteger) {
                true -> tvInput.text = (inputValue.toInt() * -1).toString()
                false -> tvInput.text = (inputValue.toDouble() * -1).toString()
            }
        } else if (operator == "−") {

        } else if (operator == "+") {

        } else if (operator == "✕") {

        } else if (operator == "÷") {

        } else if (operator == "%") {

        }
    }

    fun onClear(view: View) {
        Toast.makeText(this, "Clear!", Toast.LENGTH_SHORT).show()
        tvInput.text = ""
        isInteger = false
        isEmpty = true
    }

    fun onDecimalPoint(view: View) {
        if (isEmpty) {
            tvInput.append("0.")
        } else if (!isEmpty && isInteger) {
            tvInput.append(".")
            isInteger = false
        }
    }
}

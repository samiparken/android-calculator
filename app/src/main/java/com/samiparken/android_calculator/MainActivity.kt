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
    var previousOperator: String = ""
    var isInteger = false
    var isEmpty = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        Toast.makeText(this, "Digit", Toast.LENGTH_SHORT).show()
        if (isEmpty) {
            isInteger = true
            isEmpty = false
            tvInput.text = (view as Button).text
        } else {
            tvInput.append((view as Button).text)
        }
    }

    fun onOperator(view: View){
        Toast.makeText(this, (view as Button).text, Toast.LENGTH_SHORT).show()

        val operator = (view as Button).text.toString()
        val inputValue: String = tvInput.text.toString()

        if( operator == "+/-") {
            when(isInteger) {
                true -> tvInput.text = (inputValue.toInt() * -1).toString()
                false -> tvInput.text = (inputValue.toDouble() * -1).toString()
            }
        } else {
            if (previousOperator == "-") {
                currentValue -= inputValue.toDouble()
            } else if (previousOperator == "+") {
                currentValue += inputValue.toDouble()
            } else if (previousOperator == "x") {
                currentValue *= inputValue.toDouble()
            } else if (previousOperator == "÷") {
                currentValue /= inputValue.toDouble()
            } else if (previousOperator == "%") {
                currentValue %= inputValue.toDouble()
            }

            isEmpty = true
            if ( operator == "=") {
                previousOperator = ""
                tvInput.text = currentValue.toString()
                return
            }

            if (previousOperator == "") {
                currentValue = inputValue.toDouble()
            } else {
                tvInput.text = currentValue.toString()
            }
            previousOperator = operator
        }
    }

    fun onClear(view: View) {
        Toast.makeText(this, "Clear!", Toast.LENGTH_SHORT).show()
        tvInput.text = "0"
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

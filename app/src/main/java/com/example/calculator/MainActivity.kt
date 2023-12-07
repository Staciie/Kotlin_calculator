package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ezylang.evalex.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultOutputView = findViewById<TextView>(R.id.result_output);

        val zeroButton = findViewById<Button>(R.id.zero_button);
        val oneButton = findViewById<Button>(R.id.one_button);
        val twoButton = findViewById<Button>(R.id.two_button);
        val threeButton = findViewById<Button>(R.id.three_button);
        val fourButton = findViewById<Button>(R.id.four_button);
        val fiveButton = findViewById<Button>(R.id.five_button);
        val sixButton = findViewById<Button>(R.id.six_button);
        val sevenButton = findViewById<Button>(R.id.seven_button);
        val eightButton = findViewById<Button>(R.id.eight_button);
        val nineButton = findViewById<Button>(R.id.nine_button);

        val equalButton = findViewById<Button>(R.id.equal_button);
        val plusButton = findViewById<Button>(R.id.plus_button);
        val minusButton = findViewById<Button>(R.id.minus_button);
        val divisionButton = findViewById<Button>(R.id.division_button);
        val multiplicationButton = findViewById<Button>(R.id.multiplication_button);
        val dotButton = findViewById<Button>(R.id.dot_button);
        val clearButton = findViewById<Button>(R.id.delete_button);


        val resultStringBuilder = StringBuilder();
        resultOutputView.text = resultStringBuilder;

        zeroButton.setOnClickListener {
            resultStringBuilder.append(0);
            resultOutputView.text = resultStringBuilder;
        }
        oneButton.setOnClickListener {
            resultStringBuilder.append(1);
            resultOutputView.text = resultStringBuilder;
        }

        twoButton.setOnClickListener {
            resultStringBuilder.append(2);
            resultOutputView.text = resultStringBuilder;
        }

        threeButton.setOnClickListener {
            resultStringBuilder.append(3);
            resultOutputView.text = resultStringBuilder;
        }

        fourButton.setOnClickListener {
            resultStringBuilder.append(4);
            resultOutputView.text = resultStringBuilder;
        }

        fiveButton.setOnClickListener {
            resultStringBuilder.append(5);
            resultOutputView.text = resultStringBuilder;
        }

        sixButton.setOnClickListener {
            resultStringBuilder.append(6);
            resultOutputView.text = resultStringBuilder;
        }

        sevenButton.setOnClickListener {
            resultStringBuilder.append(7);
            resultOutputView.text = resultStringBuilder;
        }

        eightButton.setOnClickListener {
            resultStringBuilder.append(8);
            resultOutputView.text = resultStringBuilder;
        }

        nineButton.setOnClickListener {
            resultStringBuilder.append(9);
            resultOutputView.text = resultStringBuilder;
        }

        plusButton.setOnClickListener {
            resultStringBuilder.append("+");
            resultOutputView.text = resultStringBuilder;
        }

        minusButton.setOnClickListener {
            resultStringBuilder.append("-");
            resultOutputView.text = resultStringBuilder;
        }

        multiplicationButton.setOnClickListener {
            resultStringBuilder.append("*");
            resultOutputView.text = resultStringBuilder;
        }

        divisionButton.setOnClickListener {
            resultStringBuilder.append("/");
            resultOutputView.text = resultStringBuilder;
        }

        dotButton.setOnClickListener {
            resultStringBuilder.append(".");
            resultOutputView.text = resultStringBuilder;
        }

        equalButton.setOnClickListener {
            val expression = Expression(resultStringBuilder.toString());
            val expressionResult = expression.evaluate().numberValue.toString();
            resultOutputView.text = expressionResult;

            resultStringBuilder.clear();
        }
    }
}
package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import com.ezylang.evalex.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private val resultStringBuilder = StringBuilder();
    private var resultsList = mutableListOf<String>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners();
    }

    private fun setListeners() = with(binding) {
        val resultOutputView = resultOutput;
        resultOutputView.text = "";

        var allowDot: Boolean = true;

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
            allowDot = true;
        }

        minusButton.setOnClickListener {
            resultStringBuilder.append("-");
            resultOutputView.text = resultStringBuilder;
            allowDot = true;
        }

        multiplicationButton.setOnClickListener {
            resultStringBuilder.append("*");
            resultOutputView.text = resultStringBuilder;
            allowDot = true;
        }

        divisionButton.setOnClickListener {
            resultStringBuilder.append("/");
            resultOutputView.text = resultStringBuilder;
            allowDot = true;
        }

        dotButton.setOnClickListener {
            if (allowDot) {
                resultStringBuilder.append(".");
                resultOutputView.text = resultStringBuilder;
                allowDot = false;
            };
        }

        equalButton.setOnClickListener {
            try {
                val expression = Expression(resultStringBuilder.toString());
                val expressionResult = expression.evaluate().numberValue.toPlainString();
                resultOutputView.text = expressionResult;
                resultsList.add(resultStringBuilder.toString());
                resultStringBuilder.clear();
                resultStringBuilder.append(expressionResult);
                allowDot = true;
            } catch (t: Throwable) {
                Toast.makeText(this@MainActivity, "Exeption: $t", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            resultStringBuilder.clear();
            resultOutputView.text = "0";
            allowDot = true;
        }
        deleteButton.setOnClickListener{
            resultStringBuilder.deleteCharAt(resultStringBuilder.length- 1);
            resultOutputView.text = resultStringBuilder;
        }
        historyButton.setOnClickListener{
            // navigate to new activity, pass the data
            val h = resultsList;
            val intent = Intent(this@MainActivity, HistoryActivity::class.java);
            intent.putExtra("history_list", resultsList.toTypedArray());
            startActivity(intent)

        }
    }
}
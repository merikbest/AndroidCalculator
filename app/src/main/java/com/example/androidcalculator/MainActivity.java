package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonClear, buttonBracket, buttonPercent, buttonDivision, buttonMultiply, buttonMinus,
            buttonPlus, buttonEquals, buttonDot;
    TextView tvInput, tvOutput;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivision = findViewById(R.id.buttonDivision);

        buttonClear = findViewById(R.id.buttonClear);
        buttonBracket = findViewById(R.id.buttonBracket);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonDot = findViewById(R.id.buttonDot);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "9");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "×");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "÷");
            }
        });


        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "%");
            }
        });


        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + ".");
            }
        });

        buttonBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBracket) {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + ")");
                    checkBracket = false;
                } else {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + "(");
                    checkBracket = true;
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();

                process = process.replaceAll("×", "*");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("÷", "/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();

                } catch (Exception e) {
                    finalResult = "0";
                }

                tvOutput.setText(finalResult);
            }
        });
    }
}
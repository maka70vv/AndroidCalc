package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonClear;
    String operand1 = "";
    String operand2 = "";
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
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
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonClear = findViewById(R.id.buttonClear);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String buttonText = button.getText().toString();
                if (operation.isEmpty()) {
                    operand1 += buttonText;
                } else {
                    operand2 += buttonText;
                }
                updateResult();
            }
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);

        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                operation = button.getText().toString();
                updateResult();
            }
        };

        buttonAdd.setOnClickListener(operationClickListener);
        buttonSubtract.setOnClickListener(operationClickListener);
        buttonMultiply.setOnClickListener(operationClickListener);
        buttonDivide.setOnClickListener(operationClickListener);

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand1 = "";
                operand2 = "";
                operation = "";
                updateResult();
            }
        });
    }

    private void updateResult() {
        resultTextView.setText(operand1 + operation + operand2);
    }

    private void calculateResult() {
        double result = 0;
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultTextView.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        resultTextView.setText(String.valueOf(result));
        operand1 = String.valueOf(result);
        operand2 = "";
        operation = "";
    }
}

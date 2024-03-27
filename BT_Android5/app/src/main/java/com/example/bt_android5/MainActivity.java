package com.example.bt_android5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display;
    double firstNumber = 0;
    double secondNumber = 0;
    String operation = "";
    boolean isOpPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);

        // Number Buttons
        View.OnClickListener numberListener = view -> {
            Button b = (Button) view;
            if(isOpPressed) {
                display.setText(b.getText());
                isOpPressed = false;
            } else {
                if(display.getText().toString().equals("0")) {
                    display.setText(b.getText());
                } else {
                    display.setText(display.getText().toString() + b.getText().toString());
                }
            }
        };

        findViewById(R.id.button0).setOnClickListener(numberListener);
        findViewById(R.id.button1).setOnClickListener(numberListener);
        findViewById(R.id.button2).setOnClickListener(numberListener);
        findViewById(R.id.button3).setOnClickListener(numberListener);
        findViewById(R.id.button4).setOnClickListener(numberListener);
        findViewById(R.id.button5).setOnClickListener(numberListener);
        findViewById(R.id.button6).setOnClickListener(numberListener);
        findViewById(R.id.button7).setOnClickListener(numberListener);
        findViewById(R.id.button8).setOnClickListener(numberListener);
        findViewById(R.id.button9).setOnClickListener(numberListener);

        // Operation Buttons
        View.OnClickListener operationListener = view -> {
            Button b = (Button) view;
            if (!display.getText().toString().equals("0")) {
                firstNumber = Double.parseDouble(display.getText().toString());
                operation = b.getText().toString();
                isOpPressed = true;
            }
        };

        findViewById(R.id.buttonAdd).setOnClickListener(operationListener);
        findViewById(R.id.buttonSub).setOnClickListener(operationListener);
        findViewById(R.id.buttonMul).setOnClickListener(operationListener);
        findViewById(R.id.buttonDiv).setOnClickListener(operationListener);

        // Equals Button
        // Equals Button
        findViewById(R.id.buttonEqual).setOnClickListener(view -> {
            if (!isOpPressed && !operation.isEmpty()) {
                secondNumber = Double.parseDouble(display.getText().toString());
                double result = 0;
                String expression = firstNumber + " " + operation + " " + secondNumber + " = ";
                switch (operation) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        } else {
                            display.setText("Error");
                            operation = "";
                            isOpPressed = false;
                            return;
                        }
                        break;
                }
                display.setText(expression + result);
                operation = "";
                isOpPressed = false;
            }
        });


        // Clear Button
        findViewById(R.id.buttonClear).setOnClickListener(view -> {
            display.setText("0");
            firstNumber = 0;
            secondNumber = 0;
            operation = "";
            isOpPressed = false;
        });
    }
}

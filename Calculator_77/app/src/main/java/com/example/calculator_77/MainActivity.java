package com.example.calculator_77;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtDisplay;

    Button btn0, btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9;

    Button btnPlus, btnMinus, btnMultiply, btnDivide;
    Button btnAC, btnEqual;

    double firstNumber = 0;
    String operator = "";
    boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txtDisplay);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        btnAC = findViewById(R.id.btnAC);
        btnEqual = findViewById(R.id.btnEqual);

        // Number buttons

        btn0.setOnClickListener(v -> appendNumber("0"));
        btn1.setOnClickListener(v -> appendNumber("1"));
        btn2.setOnClickListener(v -> appendNumber("2"));
        btn3.setOnClickListener(v -> appendNumber("3"));
        btn4.setOnClickListener(v -> appendNumber("4"));
        btn5.setOnClickListener(v -> appendNumber("5"));
        btn6.setOnClickListener(v -> appendNumber("6"));
        btn7.setOnClickListener(v -> appendNumber("7"));
        btn8.setOnClickListener(v -> appendNumber("8"));
        btn9.setOnClickListener(v -> appendNumber("9"));

        // Operator buttons

        btnPlus.setOnClickListener(v -> setOperator("+"));
        btnMinus.setOnClickListener(v -> setOperator("-"));
        btnMultiply.setOnClickListener(v -> setOperator("×"));
        btnDivide.setOnClickListener(v -> setOperator("/"));

        // AC button

        btnAC.setOnClickListener(v -> {
            txtDisplay.setText("0");
            firstNumber = 0;
            operator = "";
            isNewOperation = true;
        });

        // Equal button

        btnEqual.setOnClickListener(v -> calculateResult());
    }

    private void appendNumber(String number) {

        if (isNewOperation) {
            txtDisplay.setText(number);
            isNewOperation = false;
        } else {
            txtDisplay.setText(txtDisplay.getText().toString() + number);
        }
    }

    private void setOperator(String op) {

        firstNumber = Double.parseDouble(txtDisplay.getText().toString());

        operator = op;

        isNewOperation = true;
    }

    private void calculateResult() {

        double secondNumber =
                Double.parseDouble(txtDisplay.getText().toString());

        double result = 0;

        switch (operator) {

            case "+":
                result = firstNumber + secondNumber;
                break;

            case "-":
                result = firstNumber - secondNumber;
                break;

            case "×":
                result = firstNumber * secondNumber;
                break;

            case "/":

                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    txtDisplay.setText("Error");
                    return;
                }

                break;
        }

        if (result == (int) result) {
            txtDisplay.setText(String.valueOf((int) result));
        } else {
            txtDisplay.setText(String.valueOf(result));
        }

        isNewOperation = true;
    }
}
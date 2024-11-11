package com.activity.mobcom.Activity.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.activity.mobcom.R;

public class Calculator extends AppCompatActivity {

    TextView resultView;  // Remove solutionView
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button add, subtract, multiply, divide, equals, clear, allClear, percent, posNeg;

    String currentInput = "";
    String lastOperation = "";
    double lastResult = 0;
    boolean isError = false;
    boolean lastNumeric = false;
    boolean stateError = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultView = findViewById(R.id.result_view);

        btn0 = findViewById(R.id.calcbtn0);
        btn1 = findViewById(R.id.calcbtn1);
        btn2 = findViewById(R.id.calcbtn2);
        btn3 = findViewById(R.id.calcbtn3);
        btn4 = findViewById(R.id.calcbtn4);
        btn5 = findViewById(R.id.calcbtn5);
        btn6 = findViewById(R.id.calcbtn6);
        btn7 = findViewById(R.id.calcbtn7);
        btn8 = findViewById(R.id.calcbtn8);
        btn9 = findViewById(R.id.calcbtn9);

        add = findViewById(R.id.addition);
        subtract = findViewById(R.id.subtraction);
        multiply = findViewById(R.id.multiplication);
        divide = findViewById(R.id.division);
        equals = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);
        allClear = findViewById(R.id.allclear);
        percent = findViewById(R.id.percent);
        posNeg = findViewById(R.id.posneg);

        // Set up number buttons
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                currentInput += button.getText().toString();
                resultView.setText(currentInput);
                lastNumeric = true;
            }
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);

        // Operators
        add.setOnClickListener(createOperatorListener("+"));
        subtract.setOnClickListener(createOperatorListener("-"));
        multiply.setOnClickListener(createOperatorListener("×"));
        divide.setOnClickListener(createOperatorListener("÷"));

        // Equals
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastNumeric && !stateError) {
                    performCalculation();
                }
            }
        });

        // All clear
        allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput = "";
                lastOperation = "";
                lastResult = 0;
                resultView.setText("0");
                stateError = false;
                lastNumeric = false;
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                    resultView.setText(currentInput);
                }
            }
        });

        // Percent
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastNumeric && !stateError) {
                    double value = Double.parseDouble(currentInput) / 100;
                    currentInput = String.valueOf((int) value);  // Convert to integer
                    resultView.setText(currentInput);
                }
            }
        });

        // Positive/Negative
        posNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentInput.isEmpty()) {
                    if (currentInput.startsWith("-")) {
                        currentInput = currentInput.substring(1);
                    } else {
                        currentInput = "-" + currentInput;
                    }
                    resultView.setText(currentInput);
                }
            }
        });
    }

    private View.OnClickListener createOperatorListener(final String operator) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastNumeric && !stateError) {
                    performCalculation();
                    lastOperation = operator;
                    currentInput = "";
                    lastNumeric = false;
                }
            }
        };
    }

    @SuppressLint("SetTextI18n")
    private void performCalculation() {
        try {
            // Parse the current input to a double value
            double currentValue = Double.parseDouble(currentInput);

            // Perform the operation based on the last operator
            switch (lastOperation) {
                case "+":
                    lastResult += currentValue;
                    break;
                case "-":
                    lastResult -= currentValue;
                    break;
                case "×":
                    // If lastResult is 0 and this is the first operation, set it to currentValue
                    if (lastOperation.isEmpty() || lastResult == 0) {
                        lastResult = currentValue;
                    } else {
                        lastResult *= currentValue;
                    }
                    break;
                case "÷":
                    if (currentValue == 0) {
                        resultView.setText("Error");  // Handle division by zero
                        stateError = true;
                        lastNumeric = false;
                        return;
                    }
                    // If lastResult is 0 and this is the first operation, set it to currentValue
                    if (lastOperation.isEmpty() || lastResult == 0) {
                        lastResult = currentValue;
                    } else {
                        lastResult /= currentValue;
                    }
                    break;
                default:
                    lastResult = currentValue;  // First operation
                    break;
            }

            // Display the result as a decimal if necessary
            if (lastResult == (int) lastResult) {
                resultView.setText(String.valueOf((int) lastResult));  // Show integer
            } else {
                resultView.setText(String.valueOf(lastResult));  // Show decimal
            }

        } catch (Exception e) {
            resultView.setText("Error");
            stateError = true;
            lastNumeric = false;
        }
    }


}

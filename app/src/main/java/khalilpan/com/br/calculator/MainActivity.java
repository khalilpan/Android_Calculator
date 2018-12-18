package khalilpan.com.br.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //to make LOG
    public static final String TAG = "MainActivity";

    // Variables
    public double result = 0.0;
    public double firstValue = 0.0;
    public double secondValue = 0.0;
    public char operand = ' ';
    public char secondOperand = ' ';
    public boolean decimalPointStatus = false; // to use for "." decimal part of a value

    //making it possible to have access for all objects of views inside the class
    TextView txtView_screen;
    Button button_clear;
    Button button_number7;
    Button button_number8;
    Button button_number9;
    Button button_devide;
    Button button_number4;
    Button button_number5;
    Button button_number6;
    Button button_multiple;
    Button button_number1;
    Button button_number2;
    Button button_number3;
    Button button_minus;
    Button button_dot;
    Button button_number0;
    Button button_plus;
    Button button_equal;

    //to keep the result on the screen after every operation
    private Boolean screenStatusClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if the status is false we should use the current value of screen as the second value
        screenStatusClean = false;

        Log.i(TAG, "onCreate ------> is running");

        //initializing the objects of view
        txtView_screen = findViewById(R.id.txtView_screen);
        button_clear = findViewById(R.id.button_clear);
        button_number7 = findViewById(R.id.button_number7);
        button_number8 = findViewById(R.id.button_number8);
        button_number9 = findViewById(R.id.button_number9);
        button_devide = findViewById(R.id.button_devide);
        button_number4 = findViewById(R.id.button_number4);
        button_number5 = findViewById(R.id.button_number5);
        button_number6 = findViewById(R.id.button_number6);
        button_multiple = findViewById(R.id.button_multiple);
        button_number1 = findViewById(R.id.button_number1);
        button_number2 = findViewById(R.id.button_number2);
        button_number3 = findViewById(R.id.button_number3);
        button_minus = findViewById(R.id.button_minus);
        button_dot = findViewById(R.id.button_dot);
        button_number0 = findViewById(R.id.button_number0);
        button_equal = findViewById(R.id.button_equal);
        button_plus = findViewById(R.id.button_plus);

        // ===========================number buttons pressed========================================//

        button_number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("0");
            }
        });

        button_number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("1");
            }
        });
        button_number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("2");
            }
        });

        button_number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("3");
            }
        });

        button_number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("4");
            }
        });

        button_number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("5");
            }
        });

        button_number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("6");
            }
        });

        button_number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("7");
            }
        });

        button_number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("8");
            }
        });

        button_number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed("9");
            }
        });

        //======================operand buttons pressed=============================================//

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondOperand = '+';
                keyPressed_Operand();
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondOperand = '-';
                keyPressed_Operand();
            }
        });
        button_devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondOperand = '/';
                keyPressed_Operand();
            }
        });

        button_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondOperand = '*';
                keyPressed_Operand();
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondOperand = '=';
                keyPressed_Operand();
            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressed(".");
            }
        });

        // cleaning all the values and screen to start calculate from first
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValue = 0.0;
                result = 0.0;
                secondValue = 0.0;
                operand = ' ';
                secondOperand = ' ';
                decimalPointStatus = false;
                txtView_screen.setText("");
                decimalPointStatus=false;
            }
        });

    }//end of oncreate

//====================================Public Methods================================================//

    //handling the pressed number keys and showing them on the screen
    public void keyPressed(String tempNumber) {
        if (screenStatusClean == false)
            txtView_screen.setText(txtView_screen.getText() + tempNumber);
        else {
            txtView_screen.setText("");
            txtView_screen.setText(txtView_screen.getText() + tempNumber);
            screenStatusClean = false;
        }
    }

    public void keyPressed_Operand() {

        // == deploying the first values
        if (operand == ' ')
            if ((operand == ' ') && (firstValue == 0.0))
                firstValue = Double.valueOf(txtView_screen.getText().toString());

        // == deploying the second value and calculating the result and showing in screen
        if ((operand == '+') && (firstValue != 0.0) && (secondValue == 0.0)) {
            secondValue = Double.valueOf(txtView_screen.getText().toString());
            result = firstValue + secondValue;
            afterOperation();
        } else if ((operand == '-') && (firstValue != 0.0) && (secondValue == 0.0)) {
            secondValue = Double.valueOf(txtView_screen.getText().toString());
            result = firstValue - secondValue;
            afterOperation();
        } else if ((operand == '*') && (firstValue != 0.0) && (secondValue == 0.0)) {
            secondValue = Double.valueOf(txtView_screen.getText().toString());
            result = firstValue * secondValue;
            afterOperation();
        } else if ((operand == '/') && (firstValue != 0.0) && (secondValue == 0.0)) {
            secondValue = Double.valueOf(txtView_screen.getText().toString());
            result = firstValue / secondValue;
            afterOperation();
        }

        //clear the screen after first operand key pressed and wait for second value
        if (operand == ' ')
            txtView_screen.setText("");

        //making it possible to process the previous operand after pressing any operand key without using equal(=) key
        operand = secondOperand;

    }

    //to show the result in screen after operation and cleaning the second value to get ready for receiving next value to do next operation
    public void afterOperation(){
        txtView_screen.setText(Double.toString(result));
        screenStatusClean = true; //when status is true means that we can delete it before getting the second value ,cause we don't need it
        firstValue = result;
        secondValue = 0.0;
    }

}//end of main class

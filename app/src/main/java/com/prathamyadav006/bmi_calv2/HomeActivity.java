package com.prathamyadav006.bmi_calv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    TextView weight;
    TextView height;
    TextView calculate;
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Objects.requireNonNull(getSupportActionBar()).hide();

        weight = findViewById(R.id.weightInput);
        height = findViewById(R.id.heightInput);
        calculate = findViewById(R.id.calBtn);
        result = findViewById(R.id.showOutput);
    }

    @SuppressLint("SetTextI18n")
    public void calculateBMI(View view) {
        String wStr = weight.getText().toString();
        double w = Double.parseDouble(wStr);

        String hStr = height.getText().toString();
        double h = Double.parseDouble(hStr);

        double b = (w*10000)/(h*h);
        DecimalFormat df = new DecimalFormat("#.#");

        double BMI  = Double.parseDouble(df.format(b));
        String BMI_OUT = Double.toString(BMI);

        String BMI_CAT;

        if (BMI < 15){
            BMI_CAT = "Very severely underweight";
        }
        else if (BMI >= 15 && BMI < 16){
            BMI_CAT = "Severely underweight";
        }
        else if (BMI >=16 && BMI < 18.5){
            BMI_CAT = "Underweight";
        }
        else if (BMI >=18.5 && BMI < 25){
            BMI_CAT = "Normal";
        }
        else if (BMI >= 25 && BMI < 30){
            BMI_CAT = "Overweight";
        }
        else if (BMI>=30 && BMI < 35 ){
            BMI_CAT = "Obese Class 1 - Moderately Obese";
        }
        else if (BMI>= 35 && BMI < 40){
            BMI_CAT = "Obese Class 2 - Severely Obese";
        }
        else {
            BMI_CAT = "Obese Class 3 - Very Severely Obese";

        }
        result.setText(BMI_OUT + " " + BMI_CAT);
    }
}
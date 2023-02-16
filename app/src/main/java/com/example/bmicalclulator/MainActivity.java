package com.example.bmicalclulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.et1);
        EditText e2 = findViewById(R.id.et2);
        TextView tv4 = findViewById(R.id.abc);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Enter your weight");
                    e1.requestFocus();
                    return;
                }
               if(TextUtils.isEmpty(str2)){
                    e2.setError("Enter your weight");
                    e2.requestFocus();
                    return;
                }
        float weight = Float.parseFloat(str1);
        float height = Float.parseFloat(str2)/100;

        float bmiValue = calculateBMI(weight, height);

        String bmiInterpretation = interpretBMI(bmiValue);

        tv4.setText(bmiValue+"-"+bmiInterpretation);

        }
        });
    }
    private float calculateBMI(float weight, float height){
        return weight/(height*height);
    }
    private String interpretBMI(float bmivalue){
        if(bmivalue < 18.5){
            return "underweight";
        }
        else if (bmivalue < 24.9){
            return "normal";
        }
        else if (bmivalue < 29.9){
            return "overweight";
        }
        else if (bmivalue < 30){
            return "pre-obese";
        }
        else {
            return "obese";
        }
    }
}
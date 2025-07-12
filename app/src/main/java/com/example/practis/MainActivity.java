package com.example.practis;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHeightFt, editHeightIn;
        Button btnCalculate;
        TextView textResult;
        LinearLayout llmain;

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn = findViewById(R.id.editHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);
        llmain = findViewById(R.id.llmain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(editWeight.getText().toString());
                int htFt = Integer.parseInt(editHeightFt.getText().toString());
                int htIn = Integer.parseInt(editHeightIn.getText().toString());

                int totalIn = htFt*12 + htIn;
                double totalCm = totalIn*2.53;
                double totalM = totalCm / 100;

                double bmi = wt / (totalM*totalM);

                if(bmi > 25){
                    textResult.setText("You are overweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorR));
                } else if (bmi < 18) {
                    textResult.setText("You are underweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorUw));
                }else {
                    textResult.setText("You are healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorG));
                }
            }
        });





    }

}
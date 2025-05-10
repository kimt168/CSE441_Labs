package com.example.lab03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button BtnAdd, BtnMinus, BtnTimes, BtnDivide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edta);
        edt2 = findViewById(R.id.edtb);
        edt3 = findViewById(R.id.edtc);
        BtnAdd = findViewById(R.id.BtnAdd);
        BtnMinus = findViewById(R.id.BtnMinus);
        BtnTimes = findViewById(R.id.BtnTimes);
        BtnDivide = findViewById(R.id.BtnDivide);
        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());

                // TODO Auto-generated method stub
                edt3.setText("a + b =" +(a+b));
            }
        });
        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());
                // TODO Auto-generated method stub
                edt3.setText("a - b =" +(a-b));

            }
        });
        BtnTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());
                // TODO Auto-generated method stub
                edt3.setText("a * b =" +(a*b));
            }
        });
        BtnDivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());
                if (b == 0)
                {
                    edt3.setText("B phai khac 0");
                }
                else
                {
                    edt3.setText("a / b =" +(a/b));
                }
            }
        });
    }
}


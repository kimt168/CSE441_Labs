package com.example.lab04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtC, edtF;
    Button btnC, btnF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnC = findViewById(R.id.btnF);
        btnF = findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = edtC.getText() + "";
                //
                int C = Integer.parseInt(doC);
                edtF.setText("" + dcf.format(C * 1.8 + 32));

            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                // TODO Auto-generated method stub
                String doF = edtF.getText() + "";
                int F = Integer.parseInt(doF);
                edtC.setText("" + dcf.format((F - 32) / 1.8));
            }
        });
    }
}
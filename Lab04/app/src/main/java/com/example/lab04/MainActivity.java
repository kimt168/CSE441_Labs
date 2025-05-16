package com.example.lab04;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtC,edtF;
    Button btncf,btnfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtC = findViewById(R.id.edtdoC);
        edtF = findViewById(R.id.edtdoF);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);
        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DecimalFormat dcf=new DecimalFormat("#.00");
                String doC = edtdoC.getText()+"";
                //
                int C=Integer.parseInt(doC);
                edtdoF.setText(""+dcf.format(C*1.8+32));

            }
        });
        btnfc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("#.00");
                // TODO Auto-generated method stub
                String doF = edtdoF.getText()+"";
                int F=Integer.parseInt(doF);
                edtdoC.setText(""+dcf.format((F-32)/1.8));
            }
        });
    }
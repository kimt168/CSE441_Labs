package com.example.lab072;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Result extends AppCompatActivity {
    TextView txtResult;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        txtResult = findViewById(R.id.txtResult);
        btnBack = findViewById(R.id.btnBack);
        Intent yourintent = getIntent();
        Bundle yourbundle = yourintent.getBundleExtra("mybackage");
        int a = yourbundle.getInt("soa");
        int b = yourbundle.getInt("sob");
        String result="";
        if(a==0 && b==0)
        {
            result="Vô số nghiệm";
        }
        else if(a==0 && b!=0)
        {
            result="Vô nghiệm";
        }
        else
        {
            DecimalFormat dcf=new DecimalFormat("0.##");
            result=dcf.format(-b*1.0/a);
        }
        txtResult.setText(result);
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub 
                finish();
            }
        });
    }
}

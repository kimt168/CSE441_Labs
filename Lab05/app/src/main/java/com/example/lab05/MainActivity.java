package com.example.lab05;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab05.R;

public class MainActivity extends Activity {
    Button btnBmi;
    EditText edtName,edtHeight,edtWeight,edtBmi,edtDiagnosis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBmi= findViewById(R.id.btnBmi);
        edtName=findViewById(R.id.edtName);
        edtHeight= findViewById(R.id.edtHeight);
        edtWeight= findViewById(R.id.edtWeight);
        edtBmi= findViewById(R.id.edtBmi);
        edtDiagnosis= findViewById(R.id.edtDiagnosis);
        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                double H=Double.parseDouble(edtHeight.getText()+"");
                double W=Double.parseDouble(edtWeight.getText()+"");
                double BMI=W/Math.pow(H,2);
                String diagnosis="";
                if(BMI<18)
                {
                    diagnosis="Bạn gầy";
                }
                else if(BMI<=24.9)
                {
                    diagnosis="Bạn bình thường";
                }
                else if(BMI<=29.9)
                {
                    diagnosis="Bạn béo phì độ 1";
                }
                else if(BMI<=34.9)
                {
                    diagnosis="Bạn béo phì độ 2";
                }
                else
                {
                    diagnosis="Bạn béo phì độ 3";
                }
                DecimalFormat dcf=new DecimalFormat("#.0");
                edtBmi.setText(dcf.format(BMI));
                edtDiagnosis.setText(diagnosis);
            }
        });
    }
}
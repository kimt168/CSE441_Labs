package com.example.lab072;

import android.content.Intent;
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

    EditText txta,txtb;
    Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myintent = new Intent(MainActivity.this,ketqua.class);
                Bundle bundle1 = new Bundle();
                int a = Integer.parseInt(txta.getText()+"");
                int b = Integer.parseInt(txtb.getText()+"");
                bundle1.putInt("soa", a);
                bundle1.putInt("sob",b);
                myintent.putExtra("mybackage", bundle1);
                startActivity(myintent);
            }
        });
    }
}
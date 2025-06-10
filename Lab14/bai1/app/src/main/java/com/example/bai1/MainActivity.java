package com.example.bai1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edta,edtb;
    Button btncong;
    ListView lv1;
    ArrayList<String> list;
    ArrayAdapter<String> myarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }
    private void addEvent() {
        // TODO Auto-generated method stub
        btncong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Xulycong();
            }
            private void Xulycong() {
                // TODO Auto-generated method stub

            }
            int a = Integer.parseInt(edta.getText().toString());
            int b = Integer.parseInt(edtb.getText().toString());
            String c = a+" + "+b+" = "+(a+b);
    list.add(c);
    myarray.notifyDataSetChanged();
    edta.setText("");
    edtb.setText("");
        }
    });
    }

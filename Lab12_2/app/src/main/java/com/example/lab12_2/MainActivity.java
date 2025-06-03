package com.example.lab12_2;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapater;
    EditText edtwork, edth, edtm;
    TextView txtdate;
    Button btnwork;
    SharedPreferences sharedPreferences;
    final String PREF_NAME = "WORK_PREF";
    final String KEY_WORK_LIST = "WORK_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edth = findViewById(R.id.edthour);
        edtm = findViewById(R.id.edtmi);
        edtwork = findViewById(R.id.edtwork);
        btnwork = findViewById(R.id.btnadd);
        lv = findViewById(R.id.listView1);
        txtdate = findViewById(R.id.txtdate);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Load data from SharedPreferences
        arraywork = new ArrayList<>();
        String savedList = sharedPreferences.getString(KEY_WORK_LIST, "");
        if (!savedList.isEmpty()) {
            arraywork.addAll(Arrays.asList(savedList.split("\n")));
        }

        arrAdapater = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrAdapater);

        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm Nay: " + simpleDateFormat.format(currentDate));

        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtwork.getText().toString().equals("") || edth.getText().toString().equals("") || edtm.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", null);
                    builder.show();
                } else {
                    String str = edtwork.getText().toString() + " - " +
                            edth.getText().toString() + ":" + edtm.getText().toString();
                    arraywork.add(str);
                    arrAdapater.notifyDataSetChanged();
                    saveListToPreferences();
                    edth.setText("");
                    edtm.setText("");
                    edtwork.setText("");
                }
            }
        });

        // Delete item on click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arraywork.remove(position);
                arrAdapater.notifyDataSetChanged();
                saveListToPreferences();
            }
        });
    }

    // Save the list to SharedPreferences
    private void saveListToPreferences() {
        StringBuilder sb = new StringBuilder();
        for (String s : arraywork) {
            sb.append(s).append("\n");
        }
        sharedPreferences.edit().putString(KEY_WORK_LIST, sb.toString().trim()).apply();
    }
}
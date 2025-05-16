package com.example.lab06;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtCMND,edtMore;
    CheckBox chk1,chk2,chk3;
    Button btnSend;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtNamee);
        edtCMND = findViewById(R.id.edtCMTND);
        edtMore = findViewById(R.id.edtMore);
        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                doShowInformation();
            }
        });
    }
    public void doShowInformation()
    {
//Kiểm tra tên hợp lệ
        String name=edtName.getText().toString();
        name=name.trim();
        if(name.length()<3)
        {
            edtName.requestFocus();
            edtName.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự",
                    Toast.LENGTH_LONG).show();
            return;
        }
//kiểm tra CMND hợp lệ
        String cmnd=edtCMND.getText().toString();
        cmnd=cmnd.trim();
        if(cmnd.length()!=9)
        {
            edtCMND.requestFocus();
            edtCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự",
                    Toast.LENGTH_LONG).show();
            return;
        }
//Kiểm tra bằng cấp
        String degree="";
        group = findViewById(R.id.group);
        int id=group.getCheckedRadioButtonId();// Trả về Id
        if(id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp",
                    Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad= findViewById(id);
        bang=rad.getText()+"";
//Kiểm tra sở thích
        String hobbie="";
        if(chk1.isChecked())
            hobbie+=chk1.getText()+"\n";
        if(chk2.isChecked())
            hobbie+=chk2.getText()+"\n";
        if(chk3.isChecked())
            hobbie+=chk3.getText()+"\n";
        String more=edtMore.getText()+"";
        //Tạo Dialpg
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });
        //tạo nội dung
        String msg=name+"\n";
        msg+= cmnd+"\n";
        msg+=degree+"\n";
        msg+=hobbie;
        msg+="—————————–\n";
        msg+="Thông tin bổ sung:\n";
        msg+=more+ "\n";
        msg+="—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b =new
                AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.
                OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }});
        b.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                });
        b.create().show();
    }

}